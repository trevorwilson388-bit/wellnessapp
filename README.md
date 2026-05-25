# Tembo Trevor - Health & Wellness App

A comprehensive Android health and wellness application built with Kotlin. Track your hydration, meditate with a built-in timer, get daily motivation, discover healthy recipes, learn nutrition tips, exercise with guided routines, and shop for wellness products — all in one app.

## App Icon

The app is named "Tembo Trevor" — inspired by strength and resilience ("Tembo" means elephant in Swahili, symbolizing health and vitality).

## ✨ Features

### 🧘 Meditation Timer
- Customizable timer from 1 to 60 minutes
- Start, Pause, and Reset controls
- Visual countdown display with monospace font
- Calming status messages throughout your session

### 💧 Hydration Tracker
- Track your daily water intake (goal: 8 glasses)
- Progress bar visual indicator
- Add and reset functionality
- Motivational status messages

### 💡 Daily Motivation
- Collection of 10 inspirational quotes
- Random quote display with one tap
- Clean card-based layout

### 🏋️ Exercise Routine
- 10-exercise guided workout
- Each exercise with reps and sets counts
- Pre-formatted workout plan display

### 🥗 Healthy Recipes
- 5 healthy recipes with detailed ingredients
- Step-by-step cooking instructions
- Clean card-based display

### 🥦 Nutrition Advice
- 6 categorized nutrition topics
- Actionable tips for each category
- Focus on balanced diet, hydration, and whole foods

### 🛒 Wellness Shop (NEW)
- Browse wellness products (yoga mats, supplements, e-books, cushions, tea, resistance bands)
- Add items to shopping cart
- Cart with quantity controls (+/- buttons)
- Subtotal calculation
- Checkout flow with confirmation dialog

## 🛠 Tech Stack

| Component | Technology |
|-----------|------------|
| **Language** | Kotlin |
| **Minimum SDK** | API 25 (Android 7.1)
| **Target SDK** | API 36 (Android 15)
| **UI Framework** | Android Jetpack (AppCompat, Activity, Core KTX) |
| **Design System** | Material Design 3 (Material Components) |
| **Layout** | ConstraintLayout, ScrollView, LinearLayout |
| **Ads** | Google AdMob (Banner ads) |
| **Build System** | Gradle with Kotlin DSL |
| **Architecture** | Activity-based with singleton CartManager |

## 📸 Screenshots

> *Screenshots coming soon*

| Screen | Description |
|--------|-------------|
| Home | Card-based dashboard with all feature navigation |
| Meditation | Timer screen with start/pause/reset controls |
| Hydration | Water tracking with progress bar |
| Motivation | Random quote generator |
| Exercise | Workout routine display |
| Recipes | Healthy recipe cards with ingredients |
| Nutrition | Categorized nutrition tips |
| Shop | Wellness products with add-to-cart |
| Cart | Shopping cart with quantity controls |

## 🚀 Setup Instructions

### Prerequisites
- Android Studio Hedgehog (2023.1.1) or later
- JDK 11 or later
- Android SDK API 36 (compile SDK)

### Steps

1. **Clone the repository**
   ```bash
   git clone https://github.com/trevorwilson388-bit/wellnessapp.git
   cd wellnessapp
   ```

2. **Open in Android Studio**
   - Launch Android Studio
   - Select "Open an existing project"
   - Navigate to the cloned directory and select it
   - Wait for Gradle sync to complete

3. **Run the app**
   - Connect an Android device (API 25+) or start an emulator
   - Click the "Run" button (▶) or use `./gradlew installDebug`

### Building from Command Line
```bash
# Clean build
./gradlew clean

# Build debug APK
./gradlew assembleDebug

# Build release APK
./gradlew assembleRelease
```

The debug APK will be at `app/build/outputs/apk/debug/app-debug.apk`

## 📁 Project Structure

```
app/
└── src/main/
    ├── java/com/example/tembotrevor/
    │   ├── MainActivity.kt          # Home screen with navigation
    │   ├── Daily_Motivation.kt      # Random quote generator
    │   ├── Hydration_alert.kt       # Water intake tracker
    │   ├── Meditation.kt            # Meditation timer
    │   ├── Start_exercise.kt        # Exercise routine display
    │   ├── HealthyRecipes.kt        # Recipe cards with ingredients
    │   ├── Nutrition.kt             # Categorized nutrition tips
    │   ├── ProductsActivity.kt      # Wellness product shop
    │   ├── CartActivity.kt          # Shopping cart
    │   ├── Product.kt               # Product data model
    │   └── CartManager.kt           # Cart state management singleton
    ├── res/
    │   ├── layout/                  # XML layout files
    │   ├── values/                  # Strings, colors, themes
    │   ├── drawable/                # Images and icons
    │   └── mipmap-*/                # App launcher icons
    └── AndroidManifest.xml          # App manifest
```

## 📄 License

This project is for educational and demonstration purposes.

---

*Built with ❤️ using Kotlin and Android SDK*