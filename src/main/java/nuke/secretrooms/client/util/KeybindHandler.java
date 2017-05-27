package nuke.secretrooms.client.util;

import org.lwjgl.input.*;

import net.minecraft.client.*;
import net.minecraft.client.settings.*;
import net.minecraft.entity.player.*;
import net.minecraft.util.text.*;
import net.minecraftforge.fml.client.*;
import net.minecraftforge.fml.client.registry.*;
import net.minecraftforge.fml.common.eventhandler.*;
import net.minecraftforge.fml.common.gameevent.InputEvent.*;
import nuke.secretrooms.core.*;

public class KeybindHandler {
	private static final Style yellow = new Style().setColor(TextFormatting.YELLOW);
	public static KeyBinding oneWayFace;

	public static void init() {
		oneWayFace = new KeyBinding("key.secretroomsmod.oneWayface", Keyboard.KEY_BACKSLASH, "key.categories.gameplay");
		ClientRegistry.registerKeyBinding(oneWayFace);
	}

	@SubscribeEvent
	public void keyPress( KeyInputEvent e ) {
		if (GameSettings.isKeyDown(oneWayFace)) {
			EntityPlayer player = FMLClientHandler.instance().getClient().player;
			if (player == null || player.world == null || Minecraft.getMinecraft().currentScreen != null) return;
			SecretRooms.proxy.onKeyPress(player.getUniqueID());
			if(SecretRooms.proxy.getFaceTowards(player.getUniqueID())){
				//player.sendMessage(TOWARDS);
			}
		}
	}

	
}