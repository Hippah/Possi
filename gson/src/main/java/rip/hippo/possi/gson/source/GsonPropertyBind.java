package rip.hippo.possi.gson.source;

import com.google.gson.*;
import com.google.gson.reflect.TypeToken;
import rip.hippo.possi.source.AbstractPropertyBind;

import java.util.List;

/**
 * @author Hippo
 */
public final class GsonPropertyBind<T> extends AbstractPropertyBind<GsonPropertySource, T> {

  private final Class<T> type;
  private final String path;

  public GsonPropertyBind(GsonPropertySource source, Class<T> type, String path) {
    super(source);
    this.type = type;
    this.path = path;
  }

  @Override
  public void onLoad() {
    JsonObject jsonObject = getSource().getJsonSource().getPropertyObject(path);
    Gson gson = getSource().getGson();
    if (jsonObject == null) {
      return;
    }
    JsonElement valueElement = jsonObject.get("value");
    if (valueElement == null) {
      return;
    }

    TypeAdapter<T> adapter = gson.getAdapter(type);
    T value = adapter.fromJsonTree(valueElement);
    getProperty().set(value);
  }

  @Override
  public void onSave() {
    JsonObject jsonObject = getSource().getJsonSource().getPropertyObject(path);
    Gson gson = getSource().getGson();
    if (jsonObject == null) {
      jsonObject = getSource().getJsonSource().create(path);
    }
    TypeAdapter<T> adapter = gson.getAdapter(type);
    JsonElement jsonElement = adapter.toJsonTree(getProperty().get());
    jsonObject.add("value", jsonElement);
  }
}
