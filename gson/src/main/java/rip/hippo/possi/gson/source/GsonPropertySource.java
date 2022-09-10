package rip.hippo.possi.gson.source;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import rip.hippo.possi.source.AbstractPropertySource;
import rip.hippo.possi.source.PropertyBind;

import java.io.*;

/**
 * @author Hippo
 */
public final class GsonPropertySource extends AbstractPropertySource {

  private final JsonSource jsonSource;
  private final Gson gson;

  public GsonPropertySource(JsonSource jsonSource, Gson gson) {
    this.jsonSource = jsonSource;
    this.gson = gson;
  }

  public GsonPropertySource(JsonSource jsonSource) {
    this(jsonSource, new Gson());
  }

  @Override
  public void load() {
    for (PropertyBind<?, ?> bind : getBinds()) {
      bind.onLoad();
    }
  }

  @Override
  public void save() {
    for (PropertyBind<?, ?> bind : getBinds()) {
      bind.onSave();
    }
  }

  public <T> GsonPropertyBind<T> getGsonBind(Class<T> type, String path) {
    return new GsonPropertyBind<>(this, type, path);
  }

  public JsonSource getJsonSource() {
    return jsonSource;
  }

  public Gson getGson() {
    return gson;
  }
}
