package sv;

import org.junit.jupiter.api.Test;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

public class WordleHelperTest {

  @Test public void testWordHasCorrectLetter() {
    assertNull(
        WordleHelper.wordHasCorrectLetter(
            Wordles.wordle0_attempt0,
            Position.FIRST));
    assertEquals('Q',
        WordleHelper.wordHasCorrectLetter(
            Wordles.wordle0_attempt3,
            Position.FIRST));
  }

  @Test public void testExcludeAllLettersBut() {
    var expected = new HashSet<Character>(Wordles.alphabet);
    expected.remove('Z');
    assertEquals(expected, WordleHelper.excludeAllLettersBut('Z'));
  }

  @Test public void testAllWrongLetters() {
    assertEquals(
        Wordles.wordle0_attempt0_wrong_letters,
        WordleHelper.allWrongLetters(Wordles.wordle0_attempt0));
  }

  @Test public void testLetterAtWrongPosition() {
    assertNull(
        WordleHelper.letterAtWrongPosition(
            Wordles.wordle0_attempt0,
            Position.FIRST));
    assertEquals(
        'E',
        WordleHelper.letterAtWrongPosition(
            Wordles.wordle0_attempt0,
            Position.FIFTH));
  }

  @Test public void testExcludedLetters() {
    assertEquals(
        Wordles.wordle0_position0_excluded_letters,
        WordleHelper.excludedLetters(Wordles.wordle0, Position.FIRST));
  }
  @Test public void testComplement() {
    var set = new HashSet<Character>(Wordles.alphabet);
    set.remove('A');
    set.remove('Q');
    set.remove('Y');
    var expected = new HashSet<Character>();
    expected.add('A');
    expected.add('Q');
    expected.add('Y');
    assertEquals(expected, WordleHelper.complement(set));

    set = new HashSet<>();
    set.add('A');
    set.add('Q');
    set.add('Y');
    expected = new HashSet<Character>();
    expected.add('B');
    expected.add('C');
    expected.add('D');
    expected.add('E');
    expected.add('F');
    expected.add('G');
    expected.add('H');
    expected.add('I');
    expected.add('J');
    expected.add('K');
    expected.add('L');
    expected.add('M');
    expected.add('N');
    expected.add('O');
    expected.add('P');
    expected.add('R');
    expected.add('S');
    expected.add('T');
    expected.add('U');
    expected.add('V');
    expected.add('W');
    expected.add('X');
    expected.add('Z');
    assertEquals(expected, WordleHelper.complement(set));

    set = new HashSet<>();
    assertEquals(Wordles.alphabet, WordleHelper.complement(set));

    set = new HashSet<>(Wordles.alphabet);
    expected = new HashSet<>();
    assertEquals(expected, WordleHelper.complement(set));
  }

  @Test public void testPossibleLetters() {
    assertEquals(
        Wordles.wordle0_position0_possible_letters,
        WordleHelper.possibleLetters(
            Wordles.wordle0,
            Position.FIRST));
    assertEquals(
        Wordles.wordle0_position1_possible_letters,
        WordleHelper.possibleLetters(
            Wordles.wordle0,
            Position.SECOND));
    assertEquals(
        Wordles.wordle0_position2_possible_letters,
        WordleHelper.possibleLetters(
            Wordles.wordle0,
            Position.THIRD));
    assertEquals(
        Wordles.wordle0_position3_possible_letters,
        WordleHelper.possibleLetters(
            Wordles.wordle0,
            Position.FOURTH));
    assertEquals(
        Wordles.wordle0_position4_possible_letters,
        WordleHelper.possibleLetters(
            Wordles.wordle0,
            Position.FIFTH));
  }
  @Test public void testAllCombinations() {
    var expected = Wordles.wordle0_possible_suffixes_position_fifth;
    var actual = WordleHelper.allCombinations(
        Position.FIFTH,
        Wordles.wordle0_position4_possible_letters,
        Wordles.empty_suffix_list);
    Collections.sort(expected);
    Collections.sort(actual);
    assertEquals(expected.size(), actual.size());
    for (int n = 0; n < expected.size(); ++n) {
      var e = expected.get(n);
      var a = actual.get(n);
      assertEquals(e, a);
    }
    assertEquals(expected, actual);
    assertEquals(
        Wordles.wordle0_possible_suffixes_position_fourth,
        WordleHelper.allCombinations(
            Position.FOURTH,
            Wordles.wordle0_position3_possible_letters,
            Wordles.wordle0_possible_suffixes_position_fifth));
  }

  @Test public void testGuessLetterSets() {
    assertEquals(
        Wordles.wordle0_possible_letter_sets,
        WordleHelper.guessLetterSets(Wordles.wordle0));
  }

  @Test public void testLettersToWordList() {
    var expected = Wordles.wordle0_possibilities;
    var actual = WordleHelper.letterSetsToWordList(
        Wordles.wordle0_possible_letter_sets, Position.FIRST);
    Collections.sort(expected);
    Collections.sort(actual);
    assertEquals(expected, actual);
  }

  @Test public void testGuessWords()  {
    var expected = Wordles.wordle0_possibilities;
    var actual = WordleHelper.guessWords(Wordles.wordle0);
    Collections.sort(expected);
    Collections.sort(actual);
    assertEquals(expected, actual);
  }
}
