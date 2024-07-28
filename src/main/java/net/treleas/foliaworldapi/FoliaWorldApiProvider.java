package net.treleas.foliaworldapi;

import lombok.experimental.UtilityClass;
import org.bukkit.Bukkit;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.Optional;

@UtilityClass
@SuppressWarnings("unused")
public class FoliaWorldApiProvider {
    public @Nullable FoliaWorldApi getUnsafe() {
        final String minecraftVersion = Bukkit.getBukkitVersion().split("-")[0];
        switch (minecraftVersion) {
            case "1.20.3":
            case "1.20.4": {
                return new net.treleas.foliaworldapi.v1_20_R3.FoliaWorldApiImpl();
            }

            case "1.20.5":
            case "1.20.6": {
                return new net.treleas.foliaworldapi.v1_20_R4.FoliaWorldApiImpl();
            }
        }

        return null;
    }

    public @NotNull Optional<FoliaWorldApi> get() {
        return Optional.ofNullable(getUnsafe());
    }
}
