package nl.enjarai.shared_resources.common.util;

import net.minecraft.resource.FileResourcePackProvider;
import net.minecraft.resource.ResourcePackProfile;
//import net.minecraft.resource.ResourcePackSource;
import nl.enjarai.shared_resources.common.mixin.resourcepacks.FileResourcePackProviderAccessor;

import java.nio.file.Path;
import java.util.function.Consumer;
import java.util.function.Supplier;

public class ExternalFileResourcePackProvider extends FileResourcePackProvider {
    protected final Supplier<Path> pathSupplier;

    public ExternalFileResourcePackProvider(Supplier<Path> pathSupplier) {
        super(null, (name) -> name);
        this.pathSupplier = pathSupplier;
    }

    @Override
    public void register(Consumer<ResourcePackProfile> profileAdder, ResourcePackProfile.Factory factory) {
        FileResourcePackProviderAccessor thiz = (FileResourcePackProviderAccessor) this;

        Path path = pathSupplier.get();
        if (path == null) return;
        thiz.setPacksFolder(path.toFile());

        super.register(profileAdder, factory);
    }
}
