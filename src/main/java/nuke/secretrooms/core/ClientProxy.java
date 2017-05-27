package nuke.secretrooms.core;

import java.util.*;

import net.minecraftforge.fml.common.event.*;
import nuke.secretrooms.common.*;

public class ClientProxy extends CommonProxy {
	private boolean oneWayFaceTowards = true;

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

	@Override
	public void onServerStop( FMLServerStoppingEvent e ) {
		super.onServerStop(e);
		oneWayFaceTowards = true;
	}

	@Override
	public void onKeyPress( UUID uuid ) {
		oneWayFaceTowards = !oneWayFaceTowards;
	}

	@Override
	public boolean getFaceTowards( UUID uuid ) {
		return oneWayFaceTowards;
	}
}