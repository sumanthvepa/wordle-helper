package sv;

import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Path;

public class ResourceIO {
  @Contract(pure = true)
  public static @NotNull String resourceFilePath(@NotNull String filename)
      throws FileNotFoundException {
    var classLoader = Thread.currentThread().getContextClassLoader();
    var url = classLoader.getResource(filename);
    if (url == null)
      throw new FileNotFoundException(
          "Could not find " + filename + " in resources");
    return url.getPath();
  }

  public static @NotNull InputStream streamFromResourceFilename(
      String filename) throws IOException {
    var classLoader = Thread.currentThread().getContextClassLoader();
    if (classLoader == null)
      throw new IOException(
          "Could not get class loader for the current thread.");
    var is = classLoader.getResourceAsStream(filename);
    if (is == null)
      throw new IOException(
          "Could not find resource stream " + filename);
    return is;
  }

  public static @NotNull String load(@NotNull InputStream is)
      throws IOException {
    var stringBuilder = new StringBuilder();
    var isr = new InputStreamReader(is, StandardCharsets.UTF_8);
    try (var br = new BufferedReader(isr)) {
      int character;
      while ((character = br.read()) != -1) {
        stringBuilder.append((char) character);
      }
    }
    return stringBuilder.toString();
  }

  public static @NotNull String load(@NotNull String filename)
      throws IOException {
    return load(new FileInputStream(filename));
  }

  public static @NotNull String load(@NotNull Path filepath)
      throws IOException {
    return load(filepath.toString());
  }

  @Contract(pure = true)
  public static @NotNull String loadFileFromResources(
      @NotNull String filename) throws IOException {
    return load(streamFromResourceFilename(filename));
  }
}
