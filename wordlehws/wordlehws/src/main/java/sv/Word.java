package sv;

import java.util.Map;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.checkerframework.checker.units.qual.C;
import org.jetbrains.annotations.NotNull;


@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
public class Word implements Comparable<Word> {
  public static final int LENGTH = 5;

  private final Map<Position, Guess> guesses;

  public Word(
      @NotNull @JsonProperty("guesses") Map<Position, Guess> guesses) {
    this.guesses = guesses;
  }


  @Override public @NotNull String toString() {
    StringBuilder builder = new StringBuilder(LENGTH);
    for (var position = Position.FIRST; position != null; position = position.next()) {
      builder.append(guesses.get(position).letter());
    }
    return builder.toString();
  }

  @Override public boolean equals(Object o) {
    if (o == this) return true;
    if (!(o instanceof Word word)) return false;
    return word.guesses.equals(this.guesses);
  }

  @Override public int hashCode() { return this.guesses.hashCode(); }


  @Override public int compareTo(@NotNull Word word) {
    if (this.guesses.size() < word.guesses.size()) return -1;
    if (this.guesses.size() == word.guesses.size()) {
      for (var position: Position.values()) {
        var thisGuess = guesses.get(position);
        var otherGuess = word.guesses.get(position);
        if (thisGuess == null && otherGuess != null) return -1;
        if (otherGuess == null) return 1;
        var comparison = thisGuess.compareTo(otherGuess);
        if (comparison < 0) return -1;
        if (comparison > 0) return 1;
      }
      return 0;
    }
    return 1;
  }

  public final Map<Position, Guess> getGuesses() { return guesses; }
}
