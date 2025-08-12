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
   git clone https://github.com/mrunknownpbu/komf-date-copilot.git
   ```
2. Navigate to the project directory:
   ```
   cd komf-date-copilot
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

## Deployment on Ubuntu and other Linux distributions

Below are production-friendly options to run the app continuously on Linux.

### Option A: Run directly with Gradle (quick start)

- Install dependencies (Ubuntu/Debian):
  ```
  sudo apt update
  sudo apt install -y openjdk-17-jre-headless git
  java -version
  ```

- Create a dedicated user (optional but recommended):
  ```
  sudo useradd -r -m -d /opt/komf -s /usr/sbin/nologin komf
  sudo -u komf bash -lc 'git clone https://github.com/mrunknownpbu/komf-date-copilot.git /opt/komf/app'
  ```

- Build and run:
  ```
  sudo -u komf bash -lc 'cd /opt/komf/app && ./gradlew build'
  sudo -u komf bash -lc 'cd /opt/komf/app && ./gradlew run'
  ```

This keeps the app attached to the terminal. For background/auto-start, use systemd below.

### Option B: Run as a systemd service (recommended)

1. Ensure Java is installed (see above).

2. Prepare app directory:
   ```
   sudo useradd -r -m -d /opt/komf -s /usr/sbin/nologin komf || true
   sudo -u komf bash -lc 'if [ -d /opt/komf/app ]; then cd /opt/komf/app && git pull; else git clone https://github.com/mrunknownpbu/komf-date-copilot.git /opt/komf/app; fi'
   sudo -u komf bash -lc 'cd /opt/komf/app && ./gradlew build'
   ```

3. Create a systemd unit:
   ```
   sudo tee /etc/systemd/system/komf.service >/dev/null <<'EOF'
   [Unit]
   Description=Komf Plus (Komf Date Copilot)
   Wants=network-online.target
   After=network-online.target

   [Service]
   Type=simple
   WorkingDirectory=/opt/komf/app
   User=komf
   Group=komf
   ExecStart=/opt/komf/app/gradlew run --no-daemon
   Restart=on-failure
   RestartSec=5
   Environment=JAVA_OPTS=-Xms128m -Xmx512m

   [Install]
   WantedBy=multi-user.target
   EOF
   ```

4. Start and enable:
   ```
   sudo systemctl daemon-reload
   sudo systemctl enable --now komf
   sudo systemctl status komf
   ```

5. View logs:
   ```
   journalctl -u komf -f
   ```

6. Update to a newer version:
   ```
   sudo -u komf bash -lc 'cd /opt/komf/app && git pull && ./gradlew build'
   sudo systemctl restart komf
   ```

Notes:
- If your build uses the Gradle Application plugin, you can replace ExecStart with the generated launcher script after running:
  ```
  ./gradlew installDist
  ```
  The script is typically at:
  ```
  /opt/komf/app/build/install/<project-name>/bin/<project-name>
  ```
  Update ExecStart to point to that script for faster startup and fewer Gradle dependencies at runtime.

### Package prerequisites for other distros

- Fedora/RHEL/CentOS:
  ```
  sudo dnf install -y java-17-openjdk-headless git
  ```
  (On older RHEL/CentOS: sudo yum install -y java-17-openjdk-headless git)

- Arch Linux:
  ```
  sudo pacman -S --needed jre-openjdk git
  ```

- Alpine:
  ```
  sudo apk add openjdk17-jre git bash
  ```

Ensure the same systemd steps apply; only the package manager commands differ.

## Contributing

Contributions are welcome! Please open an issue or submit a pull request for any enhancements or bug fixes.

## License

This project is licensed under the MIT License - see the [LICENSE](LICENSE) file for details.
