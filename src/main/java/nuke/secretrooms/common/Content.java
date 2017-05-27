package nuke.secretrooms.common;

import java.util.*;

import net.minecraft.block.*;
import net.minecraft.item.*;
import nuke.secretrooms.common.blocks.*;
import nuke.secretrooms.common.items.*;

public class Content {
	public static ArrayList<Block> blocks = new ArrayList<Block>();
	public static ArrayList<Item> items = new ArrayList<Item>();

	public static void init() {

	}

	public static void registerRenderer() {
		for (int i = 0; i < blocks.size(); i++) {
			if (blocks.get(i) instanceof IModeledBlock) {
				((IModeledBlock) blocks.get(i)).initModel();
			}
		}

		for (int i = 0; i < items.size(); i++) {
			if (items.get(i) instanceof IModeledItem) {
				((IModeledItem) items.get(i)).initModel();
			}
		}
	}
}