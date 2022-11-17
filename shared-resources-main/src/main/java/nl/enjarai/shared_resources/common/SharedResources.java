package nl.enjarai.shared_resources.common;

//import net.fabricmc.api.ModInitializer;
import net.minecraft.util.Identifier;
import net.minecraftforge.fml.IExtensionPoint;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.network.NetworkConstants;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@Mod(SharedResources.MODID)
public class SharedResources {
	public static final String MODID = "shared-resources";
	public static final Logger LOGGER = LogManager.getLogger(MODID);

	public SharedResources() {
		FMLJavaModLoadingContext.get().getModEventBus().addListener(this::onInitialize);

		ModLoadingContext.get().registerExtensionPoint(IExtensionPoint.DisplayTest.class, () -> new IExtensionPoint.DisplayTest(() -> NetworkConstants.IGNORESERVERONLY, (a, b) -> true));

	}

	public void onInitialize(final FMLCommonSetupEvent event) {
	}

	public static Identifier id(String path) {
		return new Identifier(MODID, path);
	}
}
