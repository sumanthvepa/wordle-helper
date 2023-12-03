package sv;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Path;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import com.fasterxml.jackson.databind.SerializationFeature;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;


public class WordleIO {
  private static final ObjectMapper mapper = new ObjectMapper();
  static {
    mapper.configure(
        SerializationFeature.ORDER_MAP_ENTRIES_BY_KEYS,
        true);
  }

  @Contract(pure=true)
  static @NotNull String readStream(@NotNull InputStream is)
      throws IOException {
    var stringBuilder = new StringBuilder();
    var isr = new InputStreamReader(is, StandardCharsets.UTF_8);
    try (var br = new BufferedReader(isr)) {
      int character;
      while((character = br.read()) != -1) {
        stringBuilder.append((char)character);
      }
    }
    return stringBuilder.toString();
  }

  static @NotNull Wordle load(InputStream is)
      throws IOException {
    var json = readStream(is);
    return mapper.readValue(json, Wordle.class);
  }
  public static @NotNull Wordle load(
      String filename) throws IOException {
    return load(new FileInputStream(filename));
  }

  public static @NotNull String toJson(@NotNull Wordle wordle)
      throws JsonProcessingException {
    return mapper.writeValueAsString(wordle);
  }

  public static void save(@NotNull Wordle wordle, @NotNull String filename)
      throws IOException {
    // Construct the JSON first *before* opening the file.
    // This way any problems with JSON generation will result
    // in an exception being raise before any access to the
    // filesystem. So the save will fail without leaving behind an
    // incompletely written file.
    var json = toJson(wordle);
    try (var writer = new BufferedWriter(new FileWriter(filename))) {
      writer.write(json);
    }
  }

  public static void save(@NotNull Wordle wordle, @NotNull Path filepath)
      throws IOException {
    save(wordle, filepath.toString());
  }
}
