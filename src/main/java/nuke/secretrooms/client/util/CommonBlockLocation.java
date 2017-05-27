package nuke.secretrooms.client.util;

import java.io.*;

import com.google.common.base.*;

import net.minecraft.nbt.*;
import net.minecraft.world.*;
import net.minecraftforge.common.*;

public class CommonBlockLocation {
	public final int x, y, z, dimId;

	public CommonBlockLocation(World world, int x, int y, int z) {
		this.x = x;
		this.y = y;
		this.z = z;
		this.dimId = world.provider.getDimension();
	}

	public CommonBlockLocation(int x, int y, int z, int dimid) {
		this.x = x;
		this.y = y;
		this.z = z;
		this.dimId = dimid;
	}

	public World getWorld() {
		return DimensionManager.getWorld(dimId);
	}

	public void writeToNbt( NBTTagCompound nbt ) {
		nbt.setInteger("x", x);
		nbt.setInteger("y", y);
		nbt.setInteger("z", z);
		nbt.setInteger("dim", dimId);
	}

	public static CommonBlockLocation readFromNbt( NBTTagCompound nbt ) {
		int x = nbt.getInteger("x");
		int y = nbt.getInteger("y");
		int z = nbt.getInteger("z");
		int dim = nbt.getInteger("dim");
		return new CommonBlockLocation(x, y, z, dim);
	}

	public void writeToData( DataOutput out, boolean writeWorld ) {
		try {
			out.writeInt(x);
			out.writeInt(y);
			out.writeInt(z);

			if (writeWorld) {
				out.writeInt(dimId);
			}
		} catch (IOException e) {
			Throwables.propagate(e);
			e.printStackTrace();
		}
	}

	public static CommonBlockLocation readFromData( DataInput in, boolean readWorld, int dim ) {
		try {
			return new CommonBlockLocation(in.readInt(), in.readInt(), in.readInt(), readWorld ? in.readInt() : dim);
		} catch (IOException e) {
			Throwables.propagate(e);
			return null;
		}
	}

	@Override
	public String toString() {
		return "" + x + ", " + y + ", " + z + ", DIM" + dimId;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + dimId;
		result = prime * result + x;
		result = prime * result + y;
		result = prime * result + z;
		return result;
	}

	@Override
	public boolean equals( Object obj ) {
		if (this == obj) return true;
		if (obj == null) return false;

		CommonBlockLocation other = (CommonBlockLocation) obj;

		if (dimId != other.dimId) return false;
		if (x != other.x) return false;
		if (y != other.y) return false;
		if (z != other.z) return false;
		return true;
	}
}