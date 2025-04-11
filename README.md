# 🌀 ProShape

![ProShape Preview](docs/gifs/promote.gif)

**ProShape** is an open-source [JetBrains Compose Multiplatform](https://github.com/JetBrains/compose-multiplatform) UI library that brings elegant, iOS-style rounded corners — called squircles — to your components. Designed to simplify UI creation, **ProShape** helps you deliver a polished, premium look with minimal effort.

---

## ✨ Features

-  **iOS-like rounded corners** for Compose components (aka "squircles")
- ️ Fully compatible with **JetBrains Compose Multiplatform** (Android and iOS)
- ️ Easy to integrate and use across platforms
-  Lightweight and customizable
-  Simple, expressive API: use `topRounded()`, `endRounded()`, `bottomStartRounded()` and more

---

## 📦 Installation

ProShape is available via **Maven Central**.

Add the dependency to your `build.gradle.kts`:

```kotlin
dependencies {
    implementation("com.riadmahi.proshape:proshape:1.0.0")
}
```

Or to `build.gradle`:

```groovy
dependencies {
    implementation 'com.riadmahi.proshape:proshape:1.0.0'
}
```

---

## 🧪 Usage

### Use the Modifier Extension

```kotlin
Box(
    modifier = Modifier
        .size(120.dp)
        .background(Color.Gray)
        .proShape(30.dp)
)
```

### Clip with Custom Shape

```kotlin
Box(
    modifier = Modifier
        .size(120.dp)
        .clip(ProShape.topRounded(40.dp))
        .background(Color.Cyan)
)
```

### Compose Multiplatform Compatibility

ProShape works great on Android, Desktop, and iOS through Compose Multiplatform.

---

## API Overview

### Common Shape Presets

```kotlin
ProShape.rounded()
ProShape.topRounded()
ProShape.bottomRounded()
ProShape.startRounded()
ProShape.endRounded()
```

### Individual Corners

```kotlin
ProShape.topStartRounded()
ProShape.topEndRounded()
ProShape.bottomStartRounded()
ProShape.bottomEndRounded()
```

### Full Custom Shape

```kotlin
clip(
    ProSquircleShape(
        topStart = 30.dp,
        topEnd = 0.dp,
        bottomEnd = 30.dp,
        bottomStart = 0.dp
    )
)
```

---

## 📱 Demo App

Check out the live Compose app using ProShape:

![Demo App](docs/gifs/demo.gif)

---

## 👨‍💻 Author

Crafted with ❤️ by [Riad Mahi](https://github.com/riadmahi)

> Passionate about mobile, design systems and developer experience.

---

## 📄 License

MIT License © 2025 Riad Mahi

Feel free to use, modify, and contribute to make ProShape even better!

---

## ⭐️ Show Some Love

If you find this library helpful, please consider giving it a ⭐️ on [GitHub](https://github.com/riadmahi/ProShape)!

