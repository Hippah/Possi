package me.hippo.api.possi.property.impl;

import me.hippo.api.possi.group.Group;
import me.hippo.api.possi.property.Property;
import me.hippo.api.possi.value.Value;
import me.hippo.api.possi.value.impl.SelectiveValue;

import java.io.Serializable;
import java.util.Map;

/**
 * @author Hippo
 * @version 3.0.0, 4/5/20
 * @since 3.0.0
 *
 * A {@link Property} based around <tt>selections</tt>
 */
public final class SelectiveProperty<T>  extends Property {

    /**
     * The serial id.
     * @see Serializable
     */
    private static final long serialVersionUID = 1L;

    /**
     * The <tt>properties</tt> value.
     */
    private final SelectiveValue<T> value;

    /**
     * @inheritDoc
     * @param value  The <tt>properties</tt> value.
     */
    public SelectiveProperty(Group group, String name, Property parent, Map<String, Property> children, SelectiveValue<T> value) {
        super(group, name, parent, children);
        this.value = value;
    }

    /**
     * @inheritDoc
     */
    @Override
    public SelectiveValue<T> getValue() {
        return value;
    }
}
