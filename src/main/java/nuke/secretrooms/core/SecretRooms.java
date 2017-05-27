package nuke.secretrooms.core;

import net.minecraft.creativetab.*;
import net.minecraft.init.*;
import net.minecraft.item.*;
import net.minecraftforge.fml.common.*;
import net.minecraftforge.fml.common.Mod.*;
import net.minecraftforge.fml.common.event.*;
import net.minecraftforge.fml.relauncher.*;
import nuke.secretrooms.client.util.*;

@Mod(modid = References.MODID, version = References.VERSION, useMetadata = true, dependencies = References.DEPENDENCIES)

@Mod.EventBusSubscriber
public class SecretRooms {
	
	@Instance(References.MODID)
	public static SecretRooms instance;

	@SidedProxy(clientSide = References.CLIENT_PROXY_CLASS)
	public static CommonProxy proxy;
	
	@EventHandler
	public void preInit( FMLPreInitializationEvent e ) {
		this.proxy.preInit(e);
	}

	@EventHandler
	public void init( FMLInitializationEvent e ) {
		this.proxy.init(e);
	}

	@EventHandler
	public void postInit( FMLPostInitializationEvent e ) {
		this.proxy.postInit(e);
	}

	public static CreativeTabs secretTab = new CreativeTabs("secretrooms.general") {
		@Override
		public String getTabLabel() {
			return "secretrooms.general";
		}

		@Override
		@SideOnly(Side.CLIENT)
		public ItemStack getTabIconItem() {
			return new ItemStack(Items.OAK_DOOR);
		}
	};
	
	public static String prependModID( String name ) {
		return References.MODID + ":" + name;
	}

	public static String prependModIDCapacity( String name ) {
		return References.MODID + ":" + name + "Capacity";
	}
}
