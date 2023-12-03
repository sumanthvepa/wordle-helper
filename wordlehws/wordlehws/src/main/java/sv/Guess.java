package sv;

import org.jetbrains.annotations.NotNull;

public record Guess(Character letter, Hint hint) implements Comparable<Guess> {

  @Override public boolean equals(Object o) {
    if (o == this) return true;
    if (!(o instanceof Guess guess)) return false;
    return guess.letter.equals(this.letter);
  }

  @Override public int hashCode() { return this.letter.hashCode(); }

  @Override public int compareTo(@NotNull Guess guess) {
    if (letter == null) {
      if (guess.letter == null) return 0;
      return -1;
    }
    if (guess.letter == null) return 1;
    return letter.compareTo(guess.letter);
  }
}
