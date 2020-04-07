package me.hippo.api.possi.value;

import me.hippo.api.possi.value.callback.PropertyValueCallback;

import java.io.Serializable;

/**
 * @author Hippo
 * @version 3.0.0, 4/2/20
 * @since 3.0.0
 *
 * An object that wraps around {@code T}.
 * @param <T>  The type of the value.
 */
public interface Value<T> extends Serializable {


    /**
     * Updates the <tt>value</tt>.
     *
     * @param value  The value to update to.
     * @return  The callback after updating.
     */
    PropertyValueCallback<T> update(T value);

    /**
     * Parses <tt>value</tt> from a {@link String} value.
     *
     * @param value  The value as a {@link String}.
     * @return  If the parse was successful.
     */
    boolean parse(String value);

    /**
     * Gets the <tt>value</tt>.
     *
     * @return  The value.
     */
    T get();
}
