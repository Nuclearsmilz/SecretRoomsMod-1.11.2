package nuke.secretrooms.core;

import java.util.*;

import net.minecraft.world.*;
import net.minecraftforge.fml.common.*;
import net.minecraftforge.fml.common.event.*;
import nuke.secretrooms.common.*;

public class CommonProxy {

	private boolean malisisCompat;
	private HashSet<UUID> awaySet = new HashSet<UUID>();

	public void preInit( FMLPreInitializationEvent e ) {
		if (canUseMalsisDoors()) {
			//MalisisDoorsCompat.preInit();
		}
		Content.init();
		//Recipes.init();
	}

	public void init( FMLInitializationEvent e ) {
		//TERegistry.registerTEs();
	}

	public void postInit( FMLPostInitializationEvent e ) {
		//NetworkRegistry.INSTANCE.registerGuiHandler(SecretRooms.instance, new GuiHandler());
	}

	public void onServerStop( FMLServerStoppingEvent e ) {
		awaySet.clear();
	}

	private boolean canUseMalsisDoors() {
		if (!Loader.isModLoaded("malisisdoors") || !malisisCompat) { return false; }

		String version = Loader.instance().getIndexedModList().get("malisisdoors").getVersion();

		if (version.startsWith("1.11.2-6.1")) { return true; }

		return false;
	}

	public void onKeyPress( UUID uuid ) {
		if (awaySet.contains(uuid)) {
			awaySet.remove(uuid);
		} else {
			awaySet.add(uuid);
		}
	}

	public boolean getFaceTowards( UUID uuid ) {
		return !awaySet.contains(uuid);
	}

	public boolean isOwner( IBlockAccess world, int x, int y, int z ) {
		return false;
	}
}