package httle.steiner.buildermod;

import net.minecraft.client.Minecraft;
import net.minecraft.client.player.LocalPlayer;
import net.minecraft.client.CameraType;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.phys.Vec3;

import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.InputEvent;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

import org.lwjgl.glfw.GLFW;

@Mod.EventBusSubscriber(modid = Buildermod.MODID, bus = Mod.EventBusSubscriber.Bus.FORGE, value = Dist.CLIENT)
public class Freecam {

    private static boolean enabled = false;
    private static Vec3 originalPos = null;
    private static float originalYaw, originalPitch;
    private static Entity freecamEntity = null;

    @SubscribeEvent
    public static void onKeyInput(InputEvent.Key event) {
        if (event.getKey() == GLFW.GLFW_KEY_F6 && event.getAction() == GLFW.GLFW_PRESS) {
            Minecraft mc = Minecraft.getInstance();
            LocalPlayer player = mc.player;

            if (player == null || mc.level == null) return;

            enabled = !enabled;

            if (enabled) {
                // Spielerposition und Rotation speichern
                originalPos = player.position();
                originalYaw = player.getYRot();
                originalPitch = player.getXRot();

                // Dummy-Entity erzeugen und positionieren
                freecamEntity = new Entity(EntityType.PLAYER, mc.level) {};
                freecamEntity.setPos(originalPos);

                // Kamera auf Dummy setzen
                mc.setCameraEntity(freecamEntity);

                // Kamera auf Third-Person umstellen
                mc.options.cameraType = CameraType.THIRD_PERSON_BACK;
            } else {
                // Kamera zurück zum Spieler setzen
                mc.setCameraEntity(player);
                player.setPos(originalPos);
                player.setYRot(originalYaw);
                player.setXRot(originalPitch);

                // Kamera wieder auf First-Person zurückstellen
                mc.options.cameraType = CameraType.FIRST_PERSON;

                freecamEntity = null;
            }
        }
    }

    @SubscribeEvent
    public static void onClientTick(TickEvent.ClientTickEvent event) {
        if (!enabled || freecamEntity == null) return;
        if (event.phase != TickEvent.Phase.END) return;

        Minecraft mc = Minecraft.getInstance();
        double speed = 0.5;
        Vec3 move = Vec3.ZERO;

        // Bewegungstasten abfragen
        if (mc.options.keyUp.isDown()) move = move.add(0, 0, -speed);
        if (mc.options.keyDown.isDown()) move = move.add(0, 0, speed);
        if (mc.options.keyLeft.isDown()) move = move.add(-speed, 0, 0);
        if (mc.options.keyRight.isDown()) move = move.add(speed, 0, 0);
        if (mc.options.keyJump.isDown()) move = move.add(0, speed, 0);
        if (mc.options.keyShift.isDown()) move = move.add(0, -speed, 0);

        // Bewegung relativ zur Kamera-Richtung berechnen
        Vec3 look = freecamEntity.getLookAngle();
        Vec3 side = look.cross(new Vec3(0, 1, 0)).normalize();
        Vec3 forward = look.normalize();

        Vec3 actualMove = new Vec3(0, move.y, 0)
                .add(forward.scale(move.z))
                .add(side.scale(move.x));

        // Position der Freecam-Entity aktualisieren
        freecamEntity.setPos(freecamEntity.position().add(actualMove));
    }
}
