package sv;

import java.util.*;


public final class Wordles {
  public static final Set<Character> alphabet = new HashSet<>();

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

  public static final Set<Character>
      wordle0_position0_excluded_letters = new HashSet<>(alphabet);

  static {
    wordle0_position0_excluded_letters.remove('Q');
  }
  public static final Set<Character>
      wordle0_position0_possible_letters = new HashSet<>();
  static {
    wordle0_position0_possible_letters.add('Q');
  }
  public static final Set<Character>
      wordle0_position1_excluded_letters = new HashSet<>(alphabet);
  static {
    wordle0_position1_excluded_letters.remove('U');
  }
  public static final Set<Character>
      wordle0_position1_possible_letters = new HashSet<>();
  static {
    wordle0_position1_possible_letters.add('U');
  }
  public static final Set<Character>
      wordle0_position2_excluded_letters = new HashSet<>(alphabet);
  static {
    wordle0_position2_excluded_letters.remove('E');
  }
  public static final Set<Character>
      wordle0_position2_possible_letters = new HashSet<>();
  static {
    wordle0_position2_possible_letters.add('E');
  }
  public static final Set<Character>
      wordle0_position3_excluded_letters = new HashSet<>(alphabet);
  static {
    wordle0_position3_excluded_letters.remove('B');
    wordle0_position3_excluded_letters.remove('E');
    wordle0_position3_excluded_letters.remove('F');
    wordle0_position3_excluded_letters.remove('J');
    wordle0_position3_excluded_letters.remove('K');
    wordle0_position3_excluded_letters.remove('M');
    wordle0_position3_excluded_letters.remove('N');
    wordle0_position3_excluded_letters.remove('Q');
    wordle0_position3_excluded_letters.remove('V');
    wordle0_position3_excluded_letters.remove('W');
    wordle0_position3_excluded_letters.remove('X');
    wordle0_position3_excluded_letters.remove('Z');
  }
  public static final Set<Character>
      wordle0_position3_possible_letters = new HashSet<>();
  static {
    wordle0_position3_possible_letters.add('B');
    wordle0_position3_possible_letters.add('E');
    wordle0_position3_possible_letters.add('F');
    wordle0_position3_possible_letters.add('J');
    wordle0_position3_possible_letters.add('K');
    wordle0_position3_possible_letters.add('M');
    wordle0_position3_possible_letters.add('N');
    wordle0_position3_possible_letters.add('Q');
    wordle0_position3_possible_letters.add('V');
    wordle0_position3_possible_letters.add('W');
    wordle0_position3_possible_letters.add('X');
    wordle0_position3_possible_letters.add('Z');
  }
  public static final Set<Character>
      wordle0_position4_excluded_letters = new HashSet<>(alphabet);
  static {
    wordle0_position4_excluded_letters.remove('B');
    wordle0_position4_excluded_letters.remove('F');
    wordle0_position4_excluded_letters.remove('J');
    wordle0_position4_excluded_letters.remove('K');
    wordle0_position4_excluded_letters.remove('M');
    wordle0_position4_excluded_letters.remove('N');
    wordle0_position4_excluded_letters.remove('Q');
    wordle0_position4_excluded_letters.remove('V');
    wordle0_position4_excluded_letters.remove('W');
    wordle0_position4_excluded_letters.remove('X');
    wordle0_position4_excluded_letters.remove('Z');
  }
  public static final Set<Character>
      wordle0_position4_possible_letters = new HashSet<>();
  static {
    wordle0_position4_possible_letters.add('B');
    wordle0_position4_possible_letters.add('F');
    wordle0_position4_possible_letters.add('J');
    wordle0_position4_possible_letters.add('K');
    wordle0_position4_possible_letters.add('M');
    wordle0_position4_possible_letters.add('N');
    wordle0_position4_possible_letters.add('Q');
    wordle0_position4_possible_letters.add('V');
    wordle0_position4_possible_letters.add('W');
    wordle0_position4_possible_letters.add('X');
    wordle0_position4_possible_letters.add('Z');
  }
  static final Guess wordle0_attempt0_letter0
      = new Guess('A', Hint.WRONG_LETTER);
  static final Guess wordle0_attempt0_letter1
      = new Guess('I', Hint.WRONG_LETTER);
  static final Guess wordle0_attempt0_letter2
      = new Guess('S', Hint.WRONG_LETTER);
  static final Guess wordle0_attempt0_letter3
      = new Guess('L', Hint.WRONG_LETTER);
  static final Guess wordle0_attempt0_letter4
      = new Guess('E', Hint.WRONG_POSITION);
  static final Map<Position, Guess> wordle0_attempt0_guesses
      = new HashMap<>();
  static {
    wordle0_attempt0_guesses.put(
        Position.FIRST, wordle0_attempt0_letter0);
    wordle0_attempt0_guesses.put(
        Position.SECOND, wordle0_attempt0_letter1);
    wordle0_attempt0_guesses.put(
        Position.THIRD, wordle0_attempt0_letter2);
    wordle0_attempt0_guesses.put(
        Position.FOURTH, wordle0_attempt0_letter3);
    wordle0_attempt0_guesses.put(
        Position.FIFTH, wordle0_attempt0_letter4);
  }
  static final Word wordle0_attempt0 = new Word(wordle0_attempt0_guesses);

  static final Set<Character> wordle0_attempt0_wrong_letters
      = new HashSet<>();
  static {
    wordle0_attempt0_wrong_letters.add('A');
    wordle0_attempt0_wrong_letters.add('I');
    wordle0_attempt0_wrong_letters.add('S');
    wordle0_attempt0_wrong_letters.add('L');
  }

  static final Guess wordle0_attempt1_letter0
      = new Guess('C', Hint.WRONG_LETTER);
  static final Guess wordle0_attempt1_letter1
      = new Guess('R', Hint.WRONG_LETTER);
  static final Guess wordle0_attempt1_letter2
      = new Guess('Y', Hint.WRONG_LETTER);
  static final Guess wordle0_attempt1_letter3
      = new Guess('P', Hint.WRONG_LETTER);
  static final Guess wordle0_attempt1_letter4
      = new Guess('T', Hint.WRONG_LETTER);
  static final Map<Position, Guess> wordle0_attempt1_guesses
      = new HashMap<>();
  static {
    wordle0_attempt1_guesses.put(
        Position.FIRST, wordle0_attempt1_letter0);
    wordle0_attempt1_guesses.put(
        Position.SECOND, wordle0_attempt1_letter1);
    wordle0_attempt1_guesses.put(
        Position.THIRD, wordle0_attempt1_letter2);
    wordle0_attempt1_guesses.put(
        Position.FOURTH, wordle0_attempt1_letter3);
    wordle0_attempt1_guesses.put(
        Position.FIFTH, wordle0_attempt1_letter4);
  }
  static final Word wordle0_attempt1 = new Word(wordle0_attempt1_guesses);
  static final Guess wordle0_attempt2_letter0
      = new Guess('D', Hint.WRONG_LETTER);
  static final Guess wordle0_attempt2_letter1
      = new Guess('O', Hint.WRONG_LETTER);
  static final Guess wordle0_attempt2_letter2
      = new Guess('U', Hint.WRONG_POSITION);
  static final Guess wordle0_attempt2_letter3
      = new Guess('G', Hint.WRONG_LETTER);
  static final Guess wordle0_attempt2_letter4
      = new Guess('H', Hint.WRONG_LETTER);
  static final Map<Position, Guess> wordle0_attempt2_guesses
      = new HashMap<>();
  static {
    wordle0_attempt2_guesses.put(
        Position.FIRST, wordle0_attempt2_letter0);
    wordle0_attempt2_guesses.put(
        Position.SECOND, wordle0_attempt2_letter1);
    wordle0_attempt2_guesses.put(
        Position.THIRD, wordle0_attempt2_letter2);
    wordle0_attempt2_guesses.put(
        Position.FOURTH, wordle0_attempt2_letter3);
    wordle0_attempt2_guesses.put(
        Position.FIFTH, wordle0_attempt2_letter4);
  }
  static final Word wordle0_attempt2
      = new Word(wordle0_attempt2_guesses);
  static final Guess wordle0_attempt3_letter0
      = new Guess('Q', Hint.CORRECT);
  static final Guess wordle0_attempt3_letter1
      = new Guess('U', Hint.CORRECT);
  static final Guess wordle0_attempt3_letter2
      = new Guess('E', Hint.CORRECT);
  static final Guess wordle0_attempt3_letter3
      = new Guess('U', Hint.WRONG_LETTER);
  static final Guess wordle0_attempt3_letter4
      = new Guess('E', Hint.WRONG_POSITION);
  static final Map<Position, Guess> wordle0_attempt3_guesses
      = new HashMap<>();
  static {
    wordle0_attempt3_guesses.put(
        Position.FIRST, wordle0_attempt3_letter0);
    wordle0_attempt3_guesses.put(
        Position.SECOND, wordle0_attempt3_letter1);
    wordle0_attempt3_guesses.put(
        Position.THIRD, wordle0_attempt3_letter2);
    wordle0_attempt3_guesses.put(
        Position.FOURTH, wordle0_attempt3_letter3);
    wordle0_attempt3_guesses.put(
        Position.FIFTH, wordle0_attempt3_letter4);
  }
  static final Word wordle0_attempt3
      = new Word(wordle0_attempt3_guesses);
  static final List<Word> wordle0_attempts = new ArrayList<>();
  static {
    wordle0_attempts.add(wordle0_attempt0);
    wordle0_attempts.add(wordle0_attempt1);
    wordle0_attempts.add(wordle0_attempt2);
    wordle0_attempts.add(wordle0_attempt3);
  }
  static final Wordle wordle0 = new Wordle(wordle0_attempts);
  static final String wordle0_filename = "wordle0.json";
  static final String wordle0_json = "{" +
      "\"attempts\":[" +
        "{\"guesses\":{" +
            "\"FIRST\":{\"letter\":\"A\",\"hint\":\"WRONG_LETTER\"}," +
            "\"SECOND\":{\"letter\":\"I\",\"hint\":\"WRONG_LETTER\"}," +
            "\"THIRD\":{\"letter\":\"S\",\"hint\":\"WRONG_LETTER\"}," +
            "\"FOURTH\":{\"letter\":\"L\",\"hint\":\"WRONG_LETTER\"}," +
            "\"FIFTH\":{\"letter\":\"E\",\"hint\":\"WRONG_POSITION\"}" +
          "}" +
        "}," +
        "{\"guesses\":{" +
            "\"FIRST\":{\"letter\":\"C\",\"hint\":\"WRONG_LETTER\"}," +
            "\"SECOND\":{\"letter\":\"R\",\"hint\":\"WRONG_LETTER\"}," +
            "\"THIRD\":{\"letter\":\"Y\",\"hint\":\"WRONG_LETTER\"}," +
            "\"FOURTH\":{\"letter\":\"P\",\"hint\":\"WRONG_LETTER\"}," +
            "\"FIFTH\":{\"letter\":\"T\",\"hint\":\"WRONG_LETTER\"}" +
          "}" +
        "}," +
        "{\"guesses\":{" +
            "\"FIRST\":{\"letter\":\"D\",\"hint\":\"WRONG_LETTER\"}," +
            "\"SECOND\":{\"letter\":\"O\",\"hint\":\"WRONG_LETTER\"}," +
            "\"THIRD\":{\"letter\":\"U\",\"hint\":\"WRONG_POSITION\"}," +
            "\"FOURTH\":{\"letter\":\"G\",\"hint\":\"WRONG_LETTER\"}," +
            "\"FIFTH\":{\"letter\":\"H\",\"hint\":\"WRONG_LETTER\"}" +
          "}" +
        "}," +
        "{\"guesses\":{" +
            "\"FIRST\":{\"letter\":\"Q\",\"hint\":\"CORRECT\"}," +
            "\"SECOND\":{\"letter\":\"U\",\"hint\":\"CORRECT\"}," +
            "\"THIRD\":{\"letter\":\"E\",\"hint\":\"CORRECT\"}," +
            "\"FOURTH\":{\"letter\":\"U\",\"hint\":\"WRONG_LETTER\"}," +
            "\"FIFTH\":{\"letter\":\"E\",\"hint\":\"WRONG_POSITION\"}" +
          "}" +
        "}" +
    "]" +
  "}";

  static final Guess wordle0_possibility0_letter0
      = new Guess('Q', Hint.CORRECT);
  static final Guess wordle0_possibility0_letter1
      = new Guess('U', Hint.CORRECT);
  static final Guess wordle0_possibility0_letter2
      = new Guess('E', Hint.CORRECT);
  public static final Guess wordle0_possibility0_letter3
      = new Guess('E', Hint.NO_HINT);
  public static final Guess wordle0_possibility0_letter4
      = new Guess('N', Hint.NO_HINT);
  public static final Map<Position, Guess> wordle0_possibility0_guesses
      = new HashMap<>();
  static {
    wordle0_possibility0_guesses.put(
        Position.FIRST, wordle0_possibility0_letter0);
    wordle0_possibility0_guesses.put(
        Position.SECOND, wordle0_possibility0_letter1);
    wordle0_possibility0_guesses.put(
        Position.THIRD, wordle0_possibility0_letter2);
    wordle0_possibility0_guesses.put(
        Position.FOURTH, wordle0_possibility0_letter3);
    wordle0_possibility0_guesses.put(
        Position.FIFTH, wordle0_possibility0_letter4);
  }

  public static final List<Word> empty_suffix_list
      = new ArrayList<>();

  public static final List<Word>
      wordle0_possible_suffixes_position_fifth = new ArrayList<>();
  static {
    for (Character letter: wordle0_position4_possible_letters) {
      var guesses = new HashMap<Position, Guess>();
      guesses.put(Position.FIFTH, new Guess(letter, Hint.NO_HINT));
      var word = new Word(guesses);
      wordle0_possible_suffixes_position_fifth.add(word);
    }
  }

  public static final List<Word>
      wordle0_possible_suffixes_position_fourth = new ArrayList<>();
  static {
    for (var letter: wordle0_position3_possible_letters) {
      for (var suffix : wordle0_possible_suffixes_position_fifth) {
        var guesses = new HashMap<Position, Guess>();
        guesses.put(Position.FOURTH, new Guess(letter, Hint.NO_HINT));
        guesses.putAll(suffix.getGuesses());
        var word = new Word(guesses);
        wordle0_possible_suffixes_position_fourth.add(word);
      }
    }
  }

  public static Map<Position, Set<Character>> wordle0_possible_letter_sets
      = new HashMap<>();
  static {
    wordle0_possible_letter_sets.put(
        Position.FIRST,
        wordle0_position0_possible_letters);
    wordle0_possible_letter_sets.put(
        Position.SECOND,
        wordle0_position1_possible_letters);
    wordle0_possible_letter_sets.put(
        Position.THIRD,
        wordle0_position2_possible_letters);
    wordle0_possible_letter_sets.put(
        Position.FOURTH,
        wordle0_position3_possible_letters);
    wordle0_possible_letter_sets.put(
        Position.FIFTH,
        wordle0_position4_possible_letters);
  }

  public static List<Word> wordle0_possibilities = new ArrayList<>();
  static {
    for (var character0: wordle0_position0_possible_letters) {
      for (var character1: wordle0_position1_possible_letters) {
        for (var character2: wordle0_position2_possible_letters) {
          for (var character3: wordle0_position3_possible_letters) {
            for (var character4: wordle0_position4_possible_letters) {
              var guess = new HashMap<Position, Guess>();
              guess.put(Position.FIRST, new Guess(character0, Hint.CORRECT));
              guess.put(Position.SECOND, new Guess(character1, Hint.CORRECT));
              guess.put(Position.THIRD, new Guess(character2, Hint.CORRECT));
              guess.put(Position.FOURTH, new Guess(character3, Hint.NO_HINT));
              guess.put(Position.FIFTH, new Guess(character4, Hint.NO_HINT));
              var word = new Word(guess);
              wordle0_possibilities.add(word);
            }
          }
        }
      }
    }
  }
}
