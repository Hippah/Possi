package me.hippo.api.possi.property.impl;

import me.hippo.api.possi.group.Group;
import me.hippo.api.possi.property.Property;
import me.hippo.api.possi.value.Value;
import me.hippo.api.possi.value.impl.NumberValue;

import java.io.Serializable;
import java.util.Map;

/**
 * @author Hippo
 * @version 3.0.0, 4/5/20
 * @since 3.0.0
 *
 * A {@link Property} based around {@link Number}s.
 */
public final class NumberProperty extends Property {

    /**
     * The serial id.
     * @see Serializable
     */
    private static final long serialVersionUID = 1L;

    /**
     * The <tt>properties</tt> value.
     */
    public final NumberValue value;

    /**
     * @inheritDoc
     * @param value  The <tt>properties</tt> value.
     */
    public NumberProperty(Group group, String name, Property parent, Map<String, Property> children, NumberValue value) {
        super(group, name, parent, children);
        this.value = value;
    }

    /**
     * @inheritDoc
     */
    @Override
    public NumberValue getValue() {
        return value;
    }
}
