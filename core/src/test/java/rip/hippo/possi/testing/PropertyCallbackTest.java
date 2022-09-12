package rip.hippo.possi.testing;

import org.junit.jupiter.api.Test;
import rip.hippo.possi.Property;
import rip.hippo.possi.callback.impl.ClampCallback;

/**
 * @author Hippo
 */
public final class PropertyCallbackTest {



  @Test
  public void test() {
    Property<Double> property = Property.of(5.5)
        .withCallback(new ClampCallback<>(0.0, 10.0));

    System.out.println("Initial value: " + property.get());
    property.set(8.0);
    System.out.println("In-range value: " + property.get());
    property.set(15.0);
    System.out.println("Out-of-range (+) value: " + property.get());
    property.set(-5.0);
    System.out.println("Out-of-range (-) value: " + property.get());
  }

}
