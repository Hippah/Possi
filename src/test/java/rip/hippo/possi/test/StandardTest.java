package rip.hippo.possi.test;

import rip.hippo.possi.GroupRegistry;
import rip.hippo.possi.group.Group;
import rip.hippo.possi.property.Property;
import rip.hippo.possi.value.impl.NumberValue;
import rip.hippo.possi.value.impl.StringValue;
import org.junit.jupiter.api.Test;

import java.util.Map;

/**
 * @author Hippo
 * @version 3.0.0, 4/2/20
 * @since 3.0.0
 */
public final class StandardTest {

  @Test
  public void test() {
    GroupRegistry groupRegistry = new GroupRegistry();
    Group group = groupRegistry.registerGroup("MyGroup")
        .buildProperty().setName("MyBoolean").asBoolean().setTrue().deploy()
        .buildProperty().setName("MyString").asString().setValue(StringValue.of("hippo")).deploy()
        .buildProperty().setName("MyNumber").asNumber().setValue(NumberValue.of(69)).deploy()
        .buildProperty().setName("MySelective").asSelective(String.class).addFilter(string -> string.startsWith("_")).add("fails test").add("_passes test").deploy();

    group.buildProperty().setName("Boolean With Child").addChild(group.getProperty("MyBoolean")).asBoolean().deploy();

    for (Map.Entry<String, Property<?>> properties : group.getProperties().entrySet()) {
      String name = properties.getKey();
      Property<?> property = properties.getValue();
      System.out.println(name + " " + property.getValue() + " " + property.getChildren() + " " + property.getParent());
    }

  }
}
