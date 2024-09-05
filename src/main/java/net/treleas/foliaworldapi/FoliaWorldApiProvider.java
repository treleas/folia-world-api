package net.treleas.foliaworldapi;

import lombok.experimental.UtilityClass;
import org.bukkit.Bukkit;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.Optional;
import java.util.function.Supplier;

@UtilityClass
@SuppressWarnings("unused")
public class FoliaWorldApiProvider {
    private static final FoliaWorldApi API = api();
    private @Nullable FoliaWorldApi api() {
        final Supplier<FoliaWorldApi> latest = net.treleas.foliaworldapi.v1_20_R4.FoliaWorldApiImpl::new;

        final String minecraftVersion = Bukkit.getBukkitVersion().split("-")[0];
        switch (minecraftVersion) {
            case "1.20.3":
            case "1.20.4": {
                return new net.treleas.foliaworldapi.v1_20_R3.FoliaWorldApiImpl();
            }

            case "1.20.5":
            case "1.20.6": {
                return latest.get();
            }
        }

        // Also try
        if (minecraftVersion.startsWith("1.20")) {
            return latest.get();
        }

        return null;
    }

    public @Nullable FoliaWorldApi get() {
        return FoliaWorldApiProvider.API;
    }

    public @NotNull FoliaWorldApi unsafe() {
        if (FoliaWorldApiProvider.API == null) {
            throw new IllegalStateException("Folia World API not available");
        }

        return FoliaWorldApiProvider.API;
    }

    public @NotNull Optional<FoliaWorldApi> safe() {
        return Optional.ofNullable(FoliaWorldApiProvider.API);
    }
}
