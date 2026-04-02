# CLAUDE.md

This file provides guidance to Claude Code (claude.ai/code) when working with code in this repository.

## Project Overview

This is an Android Kotlin application named "Tugas1" (Assignment 1) - a simple two-screen app demonstrating Android Navigation Component with fragments.

## Build Commands

- **Build the project**: `./gradlew build` (or `gradlew.bat build` on Windows)
- **Run debug build**: `./gradlew installDebug`
- **Run unit tests**: `./gradlew test`
- **Run instrumented tests**: `./gradlew connectedAndroidTest`
- **Clean build**: `./gradlew clean`

## Architecture

- **Single Activity, Multiple Fragments**: Uses `MainActivity` as the single host activity with `FirstFragment` and `SecondFragment` as destinations
- **Navigation Component**: Uses Android Navigation Component with navigation graph defined in `app/src/main/res/navigation/nav_graph.xml`
- **View Binding**: Enabled in build config - all views use generated binding classes (e.g., `ActivityMainBinding`, `FragmentFirstBinding`)
- **Package**: `com.example.tugas1`

## Project Structure

```
app/src/main/
├── java/com/example/tugas1/
│   ├── MainActivity.kt           # Single activity host
│   ├── FirstFragment.kt          # First screen
│   └── SecondFragment.kt         # Second screen
├── res/
│   ├── layout/
│   │   ├── activity_main.xml     # Main activity layout with NavHost
│   │   ├── content_main.xml      # Content for main activity
│   │   ├── fragment_first.xml    # First fragment layout
│   │   └── fragment_second.xml   # Second fragment layout
│   └── navigation/
│       └── nav_graph.xml         # Navigation graph
```

## Dependencies (via Version Catalog)

- Kotlin 1.9.24, AGP 8.7.3
- compileSdk 34, minSdk 24, targetSdk 34
- androidx.core:core-ktx 1.13.1 (downgraded for AGP compatibility)
- AndroidX Core KTX, AppCompat, Material, ConstraintLayout
- Navigation Fragment KTX, Navigation UI KTX
- Testing: JUnit, AndroidX JUnit, Espresso
