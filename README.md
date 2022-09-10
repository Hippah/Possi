# Possi
A robust and flexible Java property library.

# Adding Possi to your project
```kotlin
repositories {
    maven("https://jitpack.io")
}
```

Then:

```kotlin
dependencies {
    implementation("rip.hippo.possi:core:4.0.1")
    
    // Spigot module
    implementation("rip.hippo.possi:spigot:4.0.1")
}
```

# How it works
### Property
A [Property](core/src/main/java/rip/hippo/possi/Property.java), at its core, is simply just an object that holds a mutable value. 
Optionally however, they may contain:
- Keys
- Attributes
- Callbacks

### Source
A [PropertySource](core/src/main/java/rip/hippo/possi/source/PropertySource.java)
is an arbitrary data source that can be read from and written to.
For the source to be able to read and write to properties it must contain Binds.

<small>The standard implementation handles adding binds to sources automatically</small>
### Bind
A [PropertyBind](core/src/main/java/rip/hippo/possi/source/PropertyBind.java)
is an adapter for binding properties to sources, these must contain a single Property.

Whenever `PropertySource#load` is invoked, the bind will read the source and set the property's value accordingly.

Whenever `PropertySource#save` is invoked, the bind will write the property's value to the source.

<small>The standard implementation handles adding properties to binds automatically</small>

A usage example of binds and sources can be found [here](core/src/test/java/rip/hippo/possi/testing/PropertySourceTest.java)
### Key
A [PropertyKey](core/src/main/java/rip/hippo/possi/key/PropertyKey.java)
is an object that is used to locate a property
via a [PropertyKeyRegistry](core/src/main/java/rip/hippo/possi/key/PropertyKeyRegistry.java).

A usage example of keys can be found [here](core/src/test/java/rip/hippo/possi/testing/PropertyKeyTest.java).

### Attribute
A [PropertyAttribute](core/src/main/java/rip/hippo/possi/attribute/PropertyAttribute.java)
is additional runtime information attached to the property.
This may contain information such as number ranges, default values, and much more.

A usage example of attributes can be found [here](core/src/test/java/rip/hippo/possi/testing/PropertyAttributeTest.java).

### Callback
A [ValueChangeCallback](core/src/main/java/rip/hippo/possi/callback/ValueChangeCallback.java)
is a callback that is invoked when the value of a property changes.
These may modify the value of the property or cancel the change entirely.

A usage example of callbacks can be found [here](core/src/test/java/rip/hippo/possi/testing/PropertyCallbackTest.java).

# Modules

A purpose of a module is to mainly provide implementations for Sources and Binds.

You may have to write your own module depending on your project, on this repo we provide modules for the following:

Spigot (YAML Configuration)

- [Implementation](spigot/src/main/java/rip/hippo/possi/spigot/source)
- [Example](spigot-example/src/main/java/rip/hippo/possi/spigot/example/PossiExamplePlugin.java)

Gson

- [Implementation](gson/src/main/java/rip/hippo/possi/gson/source)
- [Example](gson/src/test/java/rip/hippo/possi/gson/testing/GsonTest.java)
