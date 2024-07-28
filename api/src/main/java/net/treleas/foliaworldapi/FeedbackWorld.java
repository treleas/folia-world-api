package net.treleas.foliaworldapi;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.experimental.Accessors;
import lombok.experimental.FieldDefaults;
import org.bukkit.World;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.Optional;

@Accessors(fluent = true)
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class FeedbackWorld {
    @Nullable
    World world;

    @Getter
    Feedback feedback;

    public FeedbackWorld(final @NotNull Feedback feedback) {
        this(null, feedback);
    }

    public @Nullable World worldUnsafe() {
        return this.world;
    }

    public @NotNull Optional<World> world() {
        return Optional.ofNullable(this.world);
    }
}
