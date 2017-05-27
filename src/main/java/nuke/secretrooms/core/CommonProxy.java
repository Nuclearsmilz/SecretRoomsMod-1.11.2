package nuke.secretrooms.core;

import net.minecraftforge.fml.common.event.*;
import nuke.secretrooms.common.*;

public class CommonProxy {

	public void preInit( FMLPreInitializationEvent e ) {
		Content.init();
		//Recipes.init();
	}

	public void init( FMLInitializationEvent e ) {
		//TERegistry.registerTEs();
	}

	public void postInit( FMLPostInitializationEvent e ) {
		//NetworkRegistry.INSTANCE.registerGuiHandler(SecretRooms.instance, new GuiHandler());
	}

}