package me.hippo.api.possi.property.impl;

import me.hippo.api.possi.group.Group;
import me.hippo.api.possi.property.Property;
import me.hippo.api.possi.value.Value;
import me.hippo.api.possi.value.impl.BooleanValue;

import java.io.Serializable;
import java.util.Map;

/**
 * @author Hippo
 * @version 3.0.0, 4/2/20
 * @since 3.0.0
 *
 * A {@link Property} based around {@link Boolean}s.
 */
public final class BooleanProperty extends Property {

    /**
     * The serial id.
     * @see Serializable
     */
    private static final long serialVersionUID = 1L;

    /**
     * The <tt>properties</tt> value.
     */
    private final BooleanValue value;

    /**
     * @inheritDoc
     * @param value  The <tt>properties</tt> value.
     */
    public BooleanProperty(Group group, String name, Property parent, Map<String, Property> children, BooleanValue value) {
        super(group, name, parent, children);
        this.value = value;
    }

    /**
     * @inheritDoc
     */
    @Override
    public BooleanValue getValue() {
        return value;
    }
}
