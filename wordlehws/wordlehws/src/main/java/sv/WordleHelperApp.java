package sv;

import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;

public class WordleHelperApp {
  private static final String DEFAULT_FILENAME = "attempts.json";

  @Contract(pure = true)
  private static @NotNull String getFilename(
      @NotNull String @NotNull [] args) {
    return (args.length > 0) ? args[0] : DEFAULT_FILENAME;
  }

  public static void main(@NotNull String @NotNull [] args) {
    System.out.println(
        WordleHelper.guessWords(WordleIO.load(getFilename(args))));
  }
}
