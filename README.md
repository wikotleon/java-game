# Java Game

This project is a simple text-based game where players can choose characters with different attributes and compete in various challenges. The game includes rounds where characters face off in challenges based on their skills in magic, strength, endurance, charisma, perception, and intelligence.

## Features

- **Character Selection**: Players can choose from 10 unique characters, each with different names and skill points.
- **Challenges**: The game includes several challenges:
  - Fistfight (Strength)
  - Battle against a Necromancer (Magic)
  - Escape through the Forest (Endurance)
  - Convincing Castle Guards (Charisma)
  - Treasure Hunting (Perception)
  - Navigating a Trap-filled Castle (Intelligence)
- **Randomized Challenges**: Each game round features three randomly selected challenges.

## Getting Started

1. **Clone the repository**:
   ```
   git clone <repository-url>
   ```

2. **Navigate to the project directory**:
   ```
   cd java-game
   ```

3. **Build the project**:
   ```
   mvn clean install
   ```

4. **Run the game**:
   ```
   mvn exec:java -Dexec.mainClass="com.game.Main"
   ```

## How to Play

- Players will be prompted to select their characters.
- The game will randomly select three challenges for each round.
- The winner of each challenge is determined based on the character's attributes.
- The player with the most wins at the end of the rounds is declared the overall winner.

## Contributing

Feel free to fork the repository and submit pull requests for any improvements or features you'd like to add!