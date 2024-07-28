package net.treleas.foliaworldapi;

import org.bukkit.WorldCreator;
import org.jetbrains.annotations.NotNull;

public interface FoliaWorldApi {
    @NotNull FeedbackWorld addWorld(@NotNull WorldCreator creator);
}
