package rip.hippo.possi.gson.testing;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import rip.hippo.possi.Property;
import rip.hippo.possi.gson.source.GsonPropertySource;
import rip.hippo.possi.gson.source.JsonSource;

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
    Assertions.assertDoesNotThrow(() -> {
      try (InputStream stream = Thread.currentThread().getContextClassLoader().getResourceAsStream("test.json")) {
        JsonSource jsonSource = JsonSource.of(stream);
        GsonPropertySource propertySource = new GsonPropertySource(jsonSource);

        Property<String> firstProperty = Property.of("my value")
                .withBind(propertySource.getGsonBind(String.class, "firstProperty"));

        Property<List<String>> secondProperty = Property.of(Arrays.asList("cool", "values"))
                .withBind(propertySource.getGsonBind(getListClass(), "spacer.secondProperty"));

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
        throw new RuntimeException(e);
      }
    });
  }

  @SuppressWarnings("unchecked")
  private static <T> Class<List<T>> getListClass() {
    return (Class<List<T>>) (Class<?>) List.class;
  }
}
