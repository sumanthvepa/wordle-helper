package sv;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import com.fasterxml.jackson.core.JsonProcessingException;


public class WordleIOTest {
  @Test public void testReadStream() throws IOException {
    try (var is
             = ResourceIO.streamFromResourceFilename(
                 Wordles.wordle0_filename)) {
      assertEquals(Wordles.wordle0_json, WordleIO.readStream(is));
    }
  }

  @Test public void testToJson() throws JsonProcessingException {
    var json = WordleIO.toJson(Wordles.wordle0);
    assertEquals(Wordles.wordle0_json, json);
  }

  @Test public void testSave() throws IOException {
    var tempDirectory = System.getProperty("java.io.tmpdir");
    var filename = "wordle0-tmp.json";
    var path = Paths.get(tempDirectory, filename);
    try {
      WordleIO.save(Wordles.wordle0, path);
      var json = ResourceIO.load(path);
      assertEquals(Wordles.wordle0_json, json);
    } finally {
      Files.deleteIfExists(path);
    }
  }
}
