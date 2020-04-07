package me.hippo.api.possi.property.builder;

import me.hippo.api.possi.group.Group;
import me.hippo.api.possi.property.Property;
import me.hippo.api.possi.property.impl.BooleanProperty;
import me.hippo.api.possi.property.impl.NumberProperty;
import me.hippo.api.possi.property.impl.SelectiveProperty;
import me.hippo.api.possi.property.impl.StringProperty;
import me.hippo.api.possi.value.impl.BooleanValue;
import me.hippo.api.possi.value.impl.NumberValue;
import me.hippo.api.possi.value.impl.SelectiveValue;
import me.hippo.api.possi.value.impl.StringValue;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Predicate;

/**
 * @author Hippo
 * @version 3.0.0, 4/2/20
 * @since 3.0.0
 *
 * A property builder is the first stage in building a property,
 * once all the base attributes of a property is set, it will be finished off with a
 * {@link BooleanPropertyBuilder}, a {@link StringPropertyBuilder}, a {@link NumberPropertyBuilder}, or a {@link SelectivePropertyBuilder}.
 */
public final class PropertyBuilder {

    /**
     * The group this builder is building for.
     */
    private final Group group;

    /**
     * The name of the property.
     */
    private String name;

    /**
     * The properties parent.
     */
    private Property parent;

    /**
     * The properties children.
     */
    private final Map<String, Property> children;


    /**
     * Constructs a <tt>Property Builder</tt> under <tt>group</tt>.
     *
     * @param group  The group the builder is building for.
     */
    public PropertyBuilder(Group group) {
        this.group = group;
        this.children = new HashMap<>();
    }

    /**
     * Sets the name of the property.
     *
     * @param name  The name.
     * @return  {@code this}.
     */
    public PropertyBuilder setName(String name) {
        this.name = name;
        return this;
    }

    /**
     * Sets the parent of the property.
     *
     * @param parent  The parent.
     * @return  {@code this}.
     */
    public PropertyBuilder setParent(Property parent) {
        this.parent = parent;
        return this;
    }

    /**
     * Adds a child to the property.
     *
     * @param child  The child.
     * @return  {@code this}.
     */
    public PropertyBuilder addChild(Property child) {
        children.put(child.getName(), child);
        return this;
    }

    /**
     * Sets the properties type to {@link BooleanProperty}.
     *
     * @return  The new builder.
     */
    public BooleanPropertyBuilder asBoolean() {
        return new BooleanPropertyBuilder(this);
    }

    /**
     * Sets the properties type to {@link StringProperty}.
     *
     * @return  The new builder.
     */
    public StringPropertyBuilder asString() {
        return new StringPropertyBuilder(this);
    }

    /**
     * Sets the properties type to {@link NumberProperty}.
     *
     * @return  The new builder.
     */
    public NumberPropertyBuilder asNumber() {
        return new NumberPropertyBuilder(this);
    }
    /**
     * Sets the properties type to {@link SelectiveProperty}.
     *
     * @param <T>  The type the selections will be.
     * @param type  Sets the generic type.
     * @return  The new builder.
     */
    public <T> SelectivePropertyBuilder<T> asSelective(Class<T> type) {
        return new SelectivePropertyBuilder<>(this);
    }

    /**
     * Invoked once <tt>property</tt> is built or deployed.
     *
     * @param property  The property that was built or deployed.
     */
    private void buildCallBack(Property property) {
        for (Property child : children.values()) {
            child.setParent(property);
        }
    }

    /**
     * A builder that constructs {@link BooleanProperty}s.
     */
    public static final class BooleanPropertyBuilder {

        /**
         * The delegate builder.
         */
        private final PropertyBuilder delegate;

        /**
         * The boolean value.
         */
        private BooleanValue value;

        /**
         * Constructs a <tt>Boolean Property Builder</tt> with <tt>delegate</tt>.
         *
         * @param delegate  The delegate.
         */
        private BooleanPropertyBuilder(PropertyBuilder delegate) {
            this.delegate = delegate;
            this.value = BooleanValue.DEFAULT_VALUE;
        }

        /**
         * Sets the booleans value to {@code true}.
         *
         * @return  {@code this}.
         */
        public BooleanPropertyBuilder setTrue() {
            this.value = BooleanValue.of(true);
            return this;
        }

        /**
         * Sets the booleans value to {@code false}.
         *
         * @return  {@code this}.
         */
        public BooleanPropertyBuilder setFalse() {
            this.value = BooleanValue.of(false);
            return this;
        }

        /**
         * Builds the property.
         *
         * @return  The property.
         */
        public BooleanProperty build() {
            BooleanProperty booleanProperty = new BooleanProperty(delegate.group, delegate.name, delegate.parent, delegate.children, value);
            delegate.group.getProperties().put(booleanProperty.getName(), booleanProperty);
            delegate.buildCallBack(booleanProperty);
            return booleanProperty;
        }

        /**
         * Builds the property and gets its group.
         *
         * @return  The properties group.
         */
        public Group deploy() {
            BooleanProperty booleanProperty = new BooleanProperty(delegate.group, delegate.name, delegate.parent, delegate.children, value);
            delegate.group.getProperties().put(booleanProperty.getName(), booleanProperty);
            delegate.buildCallBack(booleanProperty);
            return booleanProperty.getGroup();
        }
    }


    /**
     * A builder that constructs {@link StringProperty}s.
     */
    public static final class StringPropertyBuilder {

        /**
         * The builder delegate.
         */
        private final PropertyBuilder delegate;

        /**
         * The string value.
         */
        private StringValue value;

        /**
         * Constructs a <tt>String Property Builder</tt> with <tt>delegate</tt>.
         *
         * @param delegate  The delegate.
         */
        private StringPropertyBuilder(PropertyBuilder delegate) {
            this.delegate = delegate;
            this.value = StringValue.DEFAULT_VALUE;
        }

        /**
         * Sets the strings value.
         *
         * @param value  The value.
         * @return  {@code this}.
         */
        public StringPropertyBuilder setValue(StringValue value) {
            this.value = value;
            return this;
        }

        /**
         * Adds a filter.
         *
         * @param filter  The filter.
         * @return  {@code this}.
         */
        public StringPropertyBuilder addFilter(Predicate<String> filter) {
            value.addFilter(filter);
            return this;
        }

        /**
         * Builds the property.
         *
         * @return  The property.
         */
        public StringProperty build() {
            StringProperty stringProperty = new StringProperty(delegate.group, delegate.name, delegate.parent, delegate.children, value);
            delegate.group.getProperties().put(stringProperty.getName(), stringProperty);
            delegate.buildCallBack(stringProperty);
            return stringProperty;
        }

        /**
         * Builds the property and gets its group.
         *
         * @return  The properties group.
         */
        public Group deploy() {
            StringProperty stringProperty = new StringProperty(delegate.group, delegate.name, delegate.parent, delegate.children, value);
            delegate.group.getProperties().put(stringProperty.getName(), stringProperty);
            delegate.buildCallBack(stringProperty);
            return stringProperty.getGroup();
        }
    }


    /**
     * A builder that constructs {@link NumberProperty}s.
     */
    public static final class NumberPropertyBuilder {

        /**
         * The builder delegate.
         */
        private final PropertyBuilder delegate;

        /**
         * The number value.
         */
        private NumberValue value;

        /**
         * The increment, minimum, and maximum.
         */
        private Number increment, minimum, maximum;

        /**
         * Constructs a <tt>Number Property Builder</tt> with <tt>delegate</tt>.
         *
         * @param delegate  The delegate.
         */
        private NumberPropertyBuilder(PropertyBuilder delegate) {
            this.delegate = delegate;
            this.value = NumberValue.DEFAULT_VALUE;
        }

        /**
         * Sets the number value.
         *
         * @param value  The value.
         * @return  {@code this}.
         */
        public NumberPropertyBuilder setValue(NumberValue value) {
            this.value = value;
            return this;
        }

        /**
         * Adds a filter.
         *
         * @param filter  The filter.
         * @return  {@code this}.
         */
        public NumberPropertyBuilder addFilter(Predicate<Number> filter) {
            value.addFilter(filter);
            return this;
        }

        /**
         * Sets the increment.
         *
         * @param increment the increment.
         * @return {@code this}.
         */
        public NumberPropertyBuilder setIncrement(Integer increment) {
            this.increment = increment;
            return this;
        }

        /**
         * Sets the minimum.
         *
         * @param minimum the minimum.
         * @return {@code this}.
         */
        public NumberPropertyBuilder setMinimum(Integer minimum) {
            this.minimum = minimum;
            return this;
        }

        /**
         * Sets the maximum.
         *
         * @param maximum the maximum.
         * @return {@code this}.
         */
        public NumberPropertyBuilder setMaximum(Integer maximum) {
            this.maximum = maximum;
            return this;
        }

        /**
         * Builds the property.
         *
         * @return  The property.
         */
        public NumberProperty build() {
            NumberProperty numberProperty = new NumberProperty(delegate.group, delegate.name, delegate.parent, delegate.children, value);
            numberProperty.getValue().setIncrement(increment);
            numberProperty.getValue().setMinimum(minimum);
            numberProperty.getValue().setMaximum(maximum);
            delegate.group.getProperties().put(numberProperty.getName(), numberProperty);
            delegate.buildCallBack(numberProperty);
            return numberProperty;
        }

        /**
         * Builds the property and gets its group.
         *
         * @return  The properties group.
         */
        public Group deploy() {
            NumberProperty numberProperty = new NumberProperty(delegate.group, delegate.name, delegate.parent, delegate.children, value);
            numberProperty.getValue().setIncrement(increment);
            numberProperty.getValue().setMinimum(minimum);
            numberProperty.getValue().setMaximum(maximum);
            delegate.group.getProperties().put(numberProperty.getName(), numberProperty);
            delegate.buildCallBack(numberProperty);
            return numberProperty.getGroup();
        }
    }

    /**
     * A builder that constructs {@link SelectiveProperty}s.
     *
     * @param <T>  The selection types.
     */
    public static final class SelectivePropertyBuilder<T> {

        /**
         * The builder delegate.
         */
        private final PropertyBuilder delegate;

        /**
         * The selective value.
         */
        private SelectiveValue<T> value;

        /**
         * The values selections.
         */
        private final List<T> selections;

        /**
         * Constructs a <tt>Selective Property Builder</tt> with <tt>delegate</tt>.
         *
         * @param delegate  The delegate.
         */
        private SelectivePropertyBuilder(PropertyBuilder delegate) {
            this.delegate = delegate;
            this.value = new SelectiveValue<>();
            this.selections = new ArrayList<>();
        }

        /**
         * Sets the selective value.
         *
         * @param value  The value.
         * @return  {@code this}.
         */
        public SelectivePropertyBuilder<T> setValue(SelectiveValue<T> value) {
            this.value = value;
            return this;
        }

        /**
         * Adds a filter.
         *
         * @param filter  The filter.
         * @return  {@code this}.
         */
        public SelectivePropertyBuilder<T> addFilter(Predicate<T> filter) {
            value.addFilter(filter);
            return this;
        }

        /**
         * Adds a selection.
         *
         * @param selection  The selection.
         * @return  {@code this}.
         */
        public SelectivePropertyBuilder<T> add(T selection) {
            selections.add(selection);
            return this;
        }

        /**
         * Builds the property.
         *
         * @return  The property.
         */
        public SelectiveProperty<T> build() {
            SelectiveProperty<T> selectiveProperty = new SelectiveProperty<>(delegate.group, delegate.name, delegate.parent, delegate.children, value);
            delegate.group.getProperties().put(selectiveProperty.getName(), selectiveProperty);
            for (T selection : selections) {
                value.add(selection);
            }
            delegate.buildCallBack(selectiveProperty);
            return selectiveProperty;
        }

        /**
         * Builds the property and gets its group.
         *
         * @return  The properties group.
         */
        public Group deploy() {
            SelectiveProperty<T> selectiveProperty = new SelectiveProperty<>(delegate.group, delegate.name, delegate.parent, delegate.children, value);
            delegate.group.getProperties().put(selectiveProperty.getName(), selectiveProperty);
            for (T selection : selections) {
                value.add(selection);
            }
            delegate.buildCallBack(selectiveProperty);
            return selectiveProperty.getGroup();
        }
    }
}
