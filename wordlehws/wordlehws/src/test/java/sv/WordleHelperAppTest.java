package sv;

import java.io.IOException;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import org.jetbrains.annotations.NotNull;


public class WordleHelperAppTest {
  @Test public void testGetFilenameEmptyArgList() {
    var expected = WordleHelperApp.DEFAULT_FILENAME;
    var args = new String[0];
    assertEquals(expected, WordleHelperApp.getFilename(args));
  }

  @Test public void testGetFilenameArgWithFilename() {
    var expected = "november10.json";
    var args = new String[1];
    args[0] = expected;
    assertEquals(expected,WordleHelperApp.getFilename(args));
  }

  @Test public void testGetFilenameArgWithMultipleArgs() {
    var expected = "november11.json";
    var args = new String[2];
    args[0] = expected;
    args[1] = "does-not-exist.txt";
    assertEquals(expected,WordleHelperApp.getFilename(args));
  }

  private void testRun(
      @NotNull String inputFilename, @NotNull String expectedOutputFilename)
      throws IOException {
    var expectedOutput
        = ResourceIO.loadFileFromResources(expectedOutputFilename);
    var fullPathInputFilename = ResourceIO.resourceFilePath(inputFilename);
    var actualOutput = WordleHelperApp.run(fullPathInputFilename);
    assertEquals(expectedOutput, actualOutput);
  }

  @Test public void testRunWithWordle0() throws IOException {
    testRun(
        "wordle0.json",
        "wordle0-output.txt");
  }
}
