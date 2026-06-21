# 🎮 Connect Four (Java GUI & Console Game)

ciao! 👋 Welcome to my Connect Four project. I built this for my Software Engineering class to practice writing clean, testable, and object-oriented Java code.

## 🛠️ What I focused on in this project:

I wanted to go a bit beyond just making a working game, so I tried to apply some industry-standard software engineering practices:

* **Graphical User Interface (GUI):** Upgraded the game from a simple terminal console to a fully interactive desktop application using **Java Swing** (complete with clickable buttons, color-coded pieces, and a restart mechanism).
* **Clean Architecture (SOLID):** Strictly followed the Single Responsibility Principle (SRP). The core game logic (`Board.java`) is completely decoupled from the UI (`GameGUI.java` and `ConsolePrinter.java`).
* **TDD & Testing:** Used JUnit to write tests for the board logic (like checking wins and column limits) to make sure everything works without bugs.
* **GitHub Actions (CI):** Set up a simple workflow (`ci.yml`) so that my tests run automatically on GitHub servers.
* **Modern Java Features:** Used the Java Stream API to check if the board is full, instead of using traditional nested loops.

## 🚀 How to Run

1. Clone this repository to your computer.
2. Open the project in your IDE.
3. Run the `Main.java` file.
4. The game window will pop up! Play with a friend by clicking the "Drop" buttons at the top of each column and enjoy ^~^!
