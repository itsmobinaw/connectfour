# 🎮 Connect Four (Java Console Game)

ciao! 👋 Welcome to my Connect Four project. I built this for my Software Engineering class to practice writing clean, testable, and object-oriented Java code. 

## 🛠️ What I focused on in this project:
I wanted to go a bit beyond just making a working game, so I tried to apply some good software engineering practices:
- **TDD & Testing:** I used JUnit to write tests for the board logic (like checking wins and column limits) to make sure everything works without bugs.
- **GitHub Actions (CI):** I set up a simple workflow (`ci.yml`) so that my tests run automatically every time I push new code to GitHub!
- **Clean Code (SOLID):** I tried my best to keep the game logic completely separate from the user interface.
- **Java Streams:** Used the Stream API to check if the board is full, instead of using traditional nested loops.
- **Colorful UI:** Added ANSI color codes and Unicode characters (●) so the terminal game actually looks fun and realistic to play.

## 🚀 How to Run
1. Clone this repository to your computer.
2. Open the project in your IDE.
3. Run the `Main.java` file.
4. Play with a friend by entering a column number (0-6) and enjoy ^~^!
