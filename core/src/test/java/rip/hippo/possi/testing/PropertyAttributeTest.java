package rip.hippo.possi.testing;

import org.junit.jupiter.api.Test;
import rip.hippo.possi.Property;
import rip.hippo.possi.attribute.impl.DefaultValueAttribute;
import rip.hippo.possi.attribute.impl.SubPropertiesAttribute;

/**
 * @author Hippo
 */
public final class PropertyAttributeTest {


  @Test
  public void test() {
    Property<String> property = Property.of("My Value")
        .withAttribute(new DefaultValueAttribute<>("Default Value"))
        .withAttribute(new SubPropertiesAttribute(Property.of(true)));
    System.out.println("Initial value: " + property.get());
    property.getAttribute(DefaultValueAttribute.class)
        .ifPresent(DefaultValueAttribute::setDefaultValue);

    System.out.println("New value: " + property.get());

    property.getAttribute(SubPropertiesAttribute.class)
        .ifPresent(subPropertiesAttribute -> subPropertiesAttribute.getProperties().forEach(System.out::println));
  }
}
