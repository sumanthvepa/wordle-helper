package sv;

import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;

import java.io.IOException;

public class WordleHelperApp {
  static final String DEFAULT_FILENAME = "wordle.json";

  @Contract(pure = true)
  static @NotNull String getFilename(
      @NotNull String @NotNull [] args) {
    return (args.length > 0) ? args[0] : DEFAULT_FILENAME;
  }

  static @NotNull String run(@NotNull String filename) throws IOException {
    return WordleHelper.guessWords(WordleIO.load(filename)).toString();
  }

  public static void main(@NotNull String @NotNull [] args) {
    try {
      System.out.println(run(getFilename(args)));
    } catch(IOException ex) {
      ex.printStackTrace(System.err);
    }
  }
}
