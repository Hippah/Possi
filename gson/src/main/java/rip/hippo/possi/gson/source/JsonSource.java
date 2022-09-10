package rip.hippo.possi.gson.source;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;

/**
 * @author Hippo
 */
public final class JsonSource {

  private JsonObject jsonObject = new JsonObject();


  public JsonObject getPropertyObject(String path) {
    String[] split = path.split("\\.");
    String name = split[split.length - 1];
    JsonObject current = jsonObject;
    if (split.length != 1) {
      for (int i = 0; i < split.length - 1; i++) {
        String part = split[i];
        JsonElement jsonElement = current.get(part);
        if (jsonElement == null || !jsonElement.isJsonObject()) {
          return null;
        }
        current = jsonElement.getAsJsonObject();
      }
    }
    JsonElement jsonElement = current.get(name);
    if (jsonElement == null || !jsonElement.isJsonObject()) {
      return null;
    }
    return jsonElement.getAsJsonObject();
  }

  public JsonObject getJsonObject() {
    return jsonObject;
  }

  public void setJsonObject(JsonObject jsonObject) {
    this.jsonObject = jsonObject;
  }

  public static JsonSource of(JsonObject jsonObject) {
    JsonSource jsonSource = new JsonSource();
    jsonSource.setJsonObject(jsonObject);
    return jsonSource;
  }

  public static JsonSource of(Reader reader) {
    return of(JsonParser.parseReader(reader).getAsJsonObject());
  }

  public static JsonSource of(InputStream inputStream) {
    return of(JsonParser.parseReader(new InputStreamReader(inputStream)).getAsJsonObject());
  }
}
