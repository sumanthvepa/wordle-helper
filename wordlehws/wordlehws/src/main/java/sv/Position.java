package sv;

public enum Position {
  FIRST(0),
  SECOND(1),
  THIRD(2),
  FOURTH(3),
  FIFTH(4);

  public final int index;

  Position(int index) { this.index = index; }

  Position next() {
    return switch (this) {
      case FIRST -> SECOND;
      case SECOND -> THIRD;
      case THIRD -> FOURTH;
      case FOURTH -> FIFTH;
      case FIFTH -> null;
    };
  }
}
