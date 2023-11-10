package sv;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.checkerframework.checker.units.qual.A;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;


public class WordleHelper {

  private static final Set<Character> allLetters = new HashSet<>();

  static {
    allLetters.add('A');
    allLetters.add('B');
    allLetters.add('C');
    allLetters.add('D');
    allLetters.add('E');
    allLetters.add('F');
    allLetters.add('G');
    allLetters.add('H');
    allLetters.add('I');
    allLetters.add('J');
    allLetters.add('K');
    allLetters.add('L');
    allLetters.add('M');
    allLetters.add('N');
    allLetters.add('O');
    allLetters.add('P');
    allLetters.add('Q');
    allLetters.add('R');
    allLetters.add('S');
    allLetters.add('T');
    allLetters.add('U');
    allLetters.add('W');
    allLetters.add('X');
    allLetters.add('Y');
    allLetters.add('Z');
  }

  @Contract(pure = true)
  private static @Nullable Character letterForPosition(
      int position, @NotNull Set<LetterPosition> letterPositions) {
    for (var letterPosition: letterPositions) {
      if (position == letterPosition.position())
        return letterPosition.letter();
    }
    return null;
  }

  @Contract(pure = true)
  private static @NotNull Set<Character>
  lettersNotPossibleForPosition(
      int position,
      @NotNull Set<LetterPosition> identified,
      @NotNull Set<Character> eliminated) {
    var notPossible = new HashSet<>(allLetters);
    for (var letter: eliminated) notPossible.remove(letter);
    for (var letterPosition: identified) {
      if (letterPosition.position() == position) {
        notPossible.remove(letterPosition.letter());
      }
    }
    return notPossible;
  }

  @Contract(pure = true)
  private static @NotNull Set<Character> lettersComplement(
      @NotNull Set<Character> letters) {
    var possible = new HashSet<>(allLetters);
    for (var letter: letters) {
      possible.remove(letter);
    }
    return possible;
  }

  @Contract(pure = true)
  private static @NotNull Set<Character> lettersPossibleForPosition(
      int position,
      @NotNull Set<LetterPosition> identified,
      @NotNull Set<Character> eliminated) {
    return lettersComplement(
        lettersNotPossibleForPosition(
            position,
            identified,
            eliminated));
  }

  @Contract(pure = true)
  private static @NotNull Set<Character> lettersForPosition(
      int position,
      @NotNull Set<LetterPosition> correct,
      @NotNull Set<LetterPosition> identified,
      @NotNull Set<Character> eliminated) {
    var letters = new HashSet<Character>();
    var letter = letterForPosition(position, correct);
    if (letter != null) letters.add(letter);
    else letters.addAll(lettersPossibleForPosition(position, identified, eliminated));
    return letters;
  }

  @Contract(pure = true)
  private static @NotNull List<Set<Character>> guessCharacters(
      @NotNull Set<LetterPosition> correct,
      @NotNull Set<LetterPosition> identified,
      @NotNull Set<Character> eliminated) {
    var characters = new ArrayList<Set<Character>>();
    for (int position = 0; position < Wordle.WORD_LENGTH; ++position) {
      characters.add(
          lettersForPosition(
              position,
              correct,
              identified,
              eliminated));
    }
    return characters;
  }

  private List<Character> makeWords(List<Set<Character>> lettersList, List<Character> prefix, int position) {
    if (position > Wordle.WORD_LENGTH) return prefix;
    else {

    }
  }
  private static @NotNull List<Word> toWordList(
      @NotNull List<Set<Character>> lettersList) {
    int wordCount = lettersList.stream().map(Set::size).reduce(0, Math::max);
    wordList(prefix, )
  }

  @Contract(pure = true)
  public static @NotNull List<Word> guessWords(@NotNull Wordle wordle) {
    return toWordList(
        guessCharacters(
            wordle.allCorrectLetters(),
            wordle.allIdentifiedLetters(),
            wordle.allEliminatedLetters()));
  }
}
