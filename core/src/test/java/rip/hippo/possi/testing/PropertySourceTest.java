package rip.hippo.possi.testing;

import org.junit.jupiter.api.Test;
import rip.hippo.possi.Property;
import rip.hippo.possi.testing.source.TestPropertySource;

import java.util.Properties;

/**
 * @author Hippo
 */
public final class PropertySourceTest {


  @Test
  public void test() {
    Properties properties = new Properties();
    properties.setProperty("string", "My Value");
    properties.put("int", 5);

    TestPropertySource source = new TestPropertySource(properties);

    Property<String> stringProperty = Property.of(String.class)
        .with("Default Property Value")
        .withBind(source.bindString("string"));
    Property<Integer> intProperty = Property.of(Integer.class)
        .with(100)
        .withBind(source.bindInt("int"));


    System.out.println("Initial value: " + stringProperty.get() + ", " + intProperty.get());

    stringProperty.set("New Value");
    intProperty.set(200);
    System.out.println("New value: " + stringProperty.get() + ", " + intProperty.get());

    source.load();
    System.out.println("Loaded value: " + stringProperty.get() + ", " + intProperty.get());

    stringProperty.set("Save Value");
    intProperty.set(300);
    source.save();
    System.out.println("Saved value: " + stringProperty.get() + ", " + intProperty.get());

    properties.setProperty("string", "Reload Value");
    properties.put("int", 400);
    source.load();
    System.out.println("Reloaded value: " + stringProperty.get() + ", " + intProperty.get());
  }
}
