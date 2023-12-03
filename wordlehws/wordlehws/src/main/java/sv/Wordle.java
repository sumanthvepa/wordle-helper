package sv;

import java.util.List;

import org.jetbrains.annotations.NotNull;


public record Wordle(@NotNull List<Word> attempts) {
}
