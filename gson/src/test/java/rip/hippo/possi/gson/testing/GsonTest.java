package rip.hippo.possi.gson.testing;

import org.junit.jupiter.api.Test;
import rip.hippo.possi.Property;
import rip.hippo.possi.gson.source.GsonPropertySource;
import rip.hippo.possi.gson.source.JsonSource;
import rip.hippo.possi.reflector.Reflector;

import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
import java.util.List;

/**
 * @author Hippo
 */
public final class GsonTest {

  @Test
  public void test() {
    try (InputStream stream = Thread.currentThread().getContextClassLoader().getResourceAsStream("test.json")) {
      JsonSource jsonSource = JsonSource.of(stream);
      GsonPropertySource propertySource = new GsonPropertySource(jsonSource);

      Property<String> firstProperty = Property.of("my value")
              .withBind(propertySource.getGsonBind(String.class, "firstProperty"));

      Property<List<String>> secondProperty = Property.of(Arrays.asList("cool", "values"))
              .withBind(propertySource.getGsonBind(Reflector.getListClass(String.class), "spacer.secondProperty"));

      System.out.println("First property: " + firstProperty.get());
      System.out.println("Second property: " + secondProperty.get());

      propertySource.load();

      System.out.println("First property: " + firstProperty.get());
      System.out.println("Second property: " + secondProperty.get());

      firstProperty.set("new value");
      secondProperty.set(Arrays.asList("new", "values"));
      propertySource.save();

      System.out.println("First property: " + firstProperty.get());
      System.out.println("Second property: " + secondProperty.get());
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
}
