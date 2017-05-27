package nuke.secretrooms.client.util;

import net.minecraft.world.*;

public class ClientBlockLocation extends CommonBlockLocation {
	private final World world;

	public ClientBlockLocation(World world, int x, int y, int z) {
		super(world, x, y, z);
		this.world = world;
	}

	@Override
	public World getWorld() {
		return world;
	}
}