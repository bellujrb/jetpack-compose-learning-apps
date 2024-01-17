> _UNSCRAMBLE-GAME: Application Jetpack Compose

![Build Status](https://img.shields.io/badge/Build-Passing-brightgreen)
![Platform](https://img.shields.io/badge/Platform-Android-blue)
![License](https://img.shields.io/badge/License-MIT-green)

## 🌐 Introduction

Simple guess-the-word game to train viewmodel and state management in Jetpack Compose

## 📂 Project File Tree

```
unscramble-game/app/src
├── androidTest/java/dev/bellu/unscramblegame
│   └── ...
│        └──ExampleInstrumentedTest.kt
├── main
│   └── java/dev/bellu/unscramblegame
│        └── data
│             └── WordsData.kt
│        └── presentation
│            └── components
│                 └── ...
│            └── screens
│                 └── home
│                      └── HomeScreen.kt
│                      └── HomeUiState.kt
│                      └── HomeViewModel.kt
│                 └── welcome
│                     └── ...
│            └── themes
│                 └── Color.kt
│                 └── Theme.kt
│                 └── Type.kt
│
│   └── res
│        └── ...
│   └── AndroidManifest.xml
```


#### `home`

- `HomeScreen.kt`
    - UI
- `HomeUiState.kt`
    - UI State
- `HomeViewModel.kt`
    - Logic and ViewModel
 
---
 
## 🛠 Tech Stack

### Language and Framework
- Kotlin (Jetpack Compose)

### External Packages 
- Navigation Compose

### Architecture
- ViewModel

---
