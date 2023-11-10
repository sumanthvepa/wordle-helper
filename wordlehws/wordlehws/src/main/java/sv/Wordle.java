package sv;

import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;

import java.util.Set;

public class Wordle {
  public static final int WORD_LENGTH = 5;


  @Contract(pure = true)
  public @NotNull Set<LetterPosition> allCorrectLetters() {
    // TODO: Implement this.
    return null;
  }

  @Contract(pure = true)
  public @NotNull Set<LetterPosition> allIdentifiedLetters() {
    // TODO: Implement this.
    return null;
  }

  @Contract(pure = true)
  public @NotNull Set<Character> allEliminatedLetters() {
    // TODO: Implement this.
    return null;
  }
}

