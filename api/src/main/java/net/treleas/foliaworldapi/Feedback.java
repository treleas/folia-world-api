package net.treleas.foliaworldapi;

import org.bukkit.World;
import org.jetbrains.annotations.NotNull;

public enum Feedback {
    WORLD_ALREADY_EXISTS,
    WORLD_DUPLICATED,
    WORLD_FOLDER_INVALID,
    WORLD_DEFAULT,
    SUCCESS;


    public @NotNull FeedbackWorld toFeedbackWorld(final @NotNull World world) {
        return new FeedbackWorld(world, this);
    }

    public @NotNull FeedbackWorld toFeedbackWorld() {
        return new FeedbackWorld(this);
    }
}
