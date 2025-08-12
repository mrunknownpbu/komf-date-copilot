# Komf Plus

Komf Plus is an enhanced version of the Komf project, designed to manage and update manga chapter dates efficiently. This application provides a command-line interface for users to interact with their manga collections, allowing them to fetch, update, and manage chapter information seamlessly.

## Features

- **Manga Management**: Add, update, and retrieve manga details including title, author, and chapters.
- **Chapter Date Updates**: Automatically update publication dates for manga chapters.
- **HTTP Client**: Fetch manga data from external sources using a robust HTTP client.
- **Data Persistence**: Save and retrieve manga and chapter information with a dedicated repository.
- **Scheduled Updates**: Regularly check for updates on manga chapters using a scheduler.
- **Testing**: Comprehensive unit and integration tests to ensure application reliability.

## Project Structure

```
komf-plus
├── src
│   ├── main
│   │   ├── kotlin
│   │   │   ├── App.kt
│   │   │   ├── config
│   │   │   │   └── ApplicationConfig.kt
│   │   │   ├── domain
│   │   │   │   ├── manga
│   │   │   │   │   ├── Manga.kt
│   │   │   │   │   └── Chapter.kt
│   │   │   │   └── updates
│   │   │   │       └── ChapterDateUpdater.kt
│   │   │   ├── infrastructure
│   │   │   │   ├── http
│   │   │   │   │   └── HttpClient.kt
│   │   │   │   ├── persistence
│   │   │   │   │   └── Repository.kt
│   │   │   │   └── schedulers
│   │   │   │       └── UpdateScheduler.kt
│   │   │   └── presentation
│   │   │       └── cli
│   │   │           └── Commands.kt
│   │   └── resources
│   │       ├── application.yml
│   │       └── logback.xml
│   └── test
│       ├── kotlin
│       │   ├── ChapterDateUpdaterTest.kt
│       │   └── IntegrationTest.kt
│       └── resources
│           └── test-data
│               └── sample-manga.json
├── build.gradle.kts
├── settings.gradle.kts
├── gradle
│   └── wrapper
│       └── gradle-wrapper.properties
├── gradlew
├── gradlew.bat
├── .gitignore
├── .editorconfig
└── README.md
```

## Getting Started

### Prerequisites

- Kotlin 1.5 or higher
- Gradle 7.0 or higher

### Installation

1. Clone the repository:
   ```
   git clone https://github.com/yourusername/komf-plus.git
   ```
2. Navigate to the project directory:
   ```
   cd komf-plus
   ```
3. Build the project:
   ```
   ./gradlew build
   ```

### Usage

To run the application, execute the following command:
```
./gradlew run
```

You can use the command-line interface to manage your manga collection and update chapter dates.

## Contributing

Contributions are welcome! Please open an issue or submit a pull request for any enhancements or bug fixes.

## License

This project is licensed under the MIT License - see the [LICENSE](LICENSE) file for details.