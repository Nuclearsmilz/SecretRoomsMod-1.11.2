package nuke.secretrooms.core;

import net.minecraftforge.fml.common.event.*;
import nuke.secretrooms.common.*;

public class ClientProxy extends CommonProxy {

	@Override
	public void preInit( FMLPreInitializationEvent e ) {
		super.preInit(e);
		//KeybindHandler.init();
		Content.registerRenderer();
	}

	@Override
	public void init( FMLInitializationEvent e ) {
		super.init(e);

	}

	@Override
	public void postInit( FMLPostInitializationEvent e ) {
		super.postInit(e);
	}
}