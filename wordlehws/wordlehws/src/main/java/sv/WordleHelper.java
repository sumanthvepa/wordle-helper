package sv;

import java.util.*;

import org.checkerframework.checker.units.qual.C;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class WordleHelper {
  private static Set<Character> alphabet = new HashSet<>();
  static {
      alphabet.add('A');
      alphabet.add('B');
      alphabet.add('C');
      alphabet.add('D');
      alphabet.add('E');
      alphabet.add('F');
      alphabet.add('G');
      alphabet.add('H');
      alphabet.add('I');
      alphabet.add('J');
      alphabet.add('K');
      alphabet.add('L');
      alphabet.add('M');
      alphabet.add('N');
      alphabet.add('O');
      alphabet.add('P');
      alphabet.add('Q');
      alphabet.add('R');
      alphabet.add('S');
      alphabet.add('T');
      alphabet.add('U');
      alphabet.add('V');
      alphabet.add('W');
      alphabet.add('X');
      alphabet.add('Y');
      alphabet.add('Z');
  }

  static @Nullable Character wordHasCorrectLetter(
      @NotNull Word attempt,
      @NotNull Position position) {
    var guess = attempt.getGuesses().get(position);
    if (guess.hint() == Hint.CORRECT)
      return guess.letter();
    return null;
  }

  static @NotNull Set<Character> excludeAllLettersBut(
      @NotNull Character letter) {
    var set = new HashSet<Character>(alphabet);
    set.remove(letter);
    return set;
  }

  static @NotNull Set<Character> allWrongLetters(@NotNull Word word) {
    var set = new HashSet<Character>();
    for (var position: Position.values()) {
      var guess = word.getGuesses().get(position);
      if (guess.hint() == Hint.WRONG_LETTER) set.add(guess.letter());
    }
    return set;
  }

  static @Nullable Character letterAtWrongPosition(
      @NotNull Word word, Position position) {
    var guess = word.getGuesses().get(position);
    if (guess.hint() == Hint.WRONG_POSITION) return guess.letter();
    return null;
  }

  static @NotNull Set<Character> excludedLetters(
      @NotNull Wordle wordle, @NotNull Position position) {
    var set = new HashSet<Character>();
    for (var attempt: wordle.attempts()) {
      var correctLetter = wordHasCorrectLetter(attempt, position);
      if (correctLetter != null)
        return excludeAllLettersBut(correctLetter);
      set.addAll(allWrongLetters(attempt));
      var wrongPosition = letterAtWrongPosition(attempt, position);
      if (wrongPosition != null) set.add(wrongPosition);
    }
    return set;
  }

  static @NotNull Set<Character> complement(@NotNull Set<Character> set) {
    var complement = new HashSet<>(alphabet);
    complement.removeAll(set);
    return complement;
  }
  @Contract(pure = true)
  static @NotNull Set<Character> possibleLetters(
      @NotNull Wordle wordle, Position position) {
    return complement(excludedLetters(wordle, position));
  }

  @Contract(pure = true)
  static @NotNull List<Word> allCombinations(
      Position position,
      @NotNull Set<Character> set,
      @NotNull List<Word> suffixes) {
    var words = new ArrayList<Word>();
    var hint = (set.size() > 1)? Hint.NO_HINT : Hint.CORRECT;
    for (var letter: set) {
      var guess = new Guess(letter, hint);
      if (suffixes.isEmpty()) {
        var guesses = new HashMap<Position, Guess>();
        guesses.put(position, guess);
        var word = new Word(guesses);
        words.add(word);
      } else {
        for (var suffix : suffixes) {
          var guesses = new HashMap<Position, Guess>();
          guesses.put(position, guess);
          guesses.putAll(suffix.getGuesses());
          var word = new Word(guesses);
          words.add(word);
        }
      }
    }
    return words;
  }

  @Contract(pure = true)
  static @NotNull Map<Position, Set<Character>> guessLetterSets(
      @NotNull Wordle wordle) {
    var sets = new HashMap<Position, Set<Character>>();
    for (var position: Position.values()) {
      sets.put(position, possibleLetters(wordle, position));
    }
    return sets;
  }

  @Contract(pure = true)
  static @NotNull List<Word> letterSetsToWordList(
      @NotNull Map<Position, Set<Character>> sets, Position position) {
    var words = new ArrayList<Word>();
    if (position != null) {
      var set = sets.get(position);
      var suffixes = letterSetsToWordList(sets, position.next());
      words.addAll(allCombinations(position, set, suffixes));
    }
    return words;
  }

  @Contract(pure = true)
  public static @NotNull List<Word> guessWords(
      @NotNull Wordle wordle) {
    return letterSetsToWordList(
        guessLetterSets(wordle),
        Position.FIRST);
  }
}
