package nuke.secretrooms.client.util;

import java.util.*;

import org.apache.logging.log4j.*;

public class References {
	public static final String MCVERSION = "1.11.2";
	public static final int MAJOR = 0;
	public static final int MINOR = 0;
	public static final int PATCH = 1;

	public static final String MODID = "secretrooms";
	public static final String NAME = "Secret Rooms";
	public static final String VERSION = MCVERSION + "-" + MAJOR + "." + MINOR + "." + PATCH + "";
	public static final String DEPENDENCIES = "after:malisisdoors";

	public static final String CLIENT_PROXY_CLASS = "nuke.secretrooms.core.ClientProxy";
	public static final String SERVER_PROXY_CLASS = "nuke.secretrooms.core.ServerProxy";

	public static final Random RANDOM = new Random();
	public static final Logger LOGGER = LogManager.getLogger(NAME);
}