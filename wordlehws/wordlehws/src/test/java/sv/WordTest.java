package sv;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class WordTest {
  @Test public void testCompareTo() {
    assertTrue(
        Wordles.wordle0_attempt0.compareTo(
            Wordles.wordle0_attempt1) < 0);
  }
}
