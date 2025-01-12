package com.game;

import com.game.enums.AttributeType;
import com.game.challenges.*;
import java.io.IOException;
import java.util.*;

public class Game {
    private static final int MAX_CHARACTERS = 5;

    private List<Character> playerCharacters;
    private List<Character> botCharacters;
    private int playerTeamScore;
    private int botTeamScore;
    private Scanner scanner;
    private String playerTeamName;
    private String botTeamName;
    private List<Challenge> challenges;

    public Game() {
        playerCharacters = new ArrayList<>();
        botCharacters = new ArrayList<>();
        scanner = new Scanner(System.in);
        playerTeamName = "qwerty";
        botTeamName = "BOTS";
        initializeChallenges();
    }

    private void initializeChallenges() {
        challenges = new ArrayList<>();
        challenges.add(new FistfightChallenge());
        challenges.add(new NecromancerBattleChallenge());
        challenges.add(new ForestEscapeChallenge());
        challenges.add(new CastleConvincingChallenge());
        challenges.add(new TreasureHuntChallenge());
        challenges.add(new TrapNavigationChallenge());
    }

    public void setPlayerTeamName() {
        System.out.print("Enter your team name (or type 'back' to return to menu): ");
        String input = scanner.next();
        if (input.equalsIgnoreCase("back")) {
            return;
        }
        playerTeamName = input;
    }

    public void createPlayerCharacter() {
        if (playerCharacters.size() >= MAX_CHARACTERS) {
            System.out.println("You can only add up to 5 characters.");
            return;
        }

        System.out.print("Enter character name (or type 'back' to return to menu): ");
        String name = scanner.next();
        if (name.equalsIgnoreCase("back")) {
            return;
        }

        int[] attributes = new int[AttributeType.values().length];
        int points = 10;

        while (points > 0) {
            for (int i = 0; i < AttributeType.values().length; i++) {
                System.out.println("You have " + points + " points left to distribute.");
                System.out.print("Enter points for " + AttributeType.values()[i].name().toLowerCase() + " (or type 'back' to return to menu): ");
                String input = scanner.next();
                if (input.equalsIgnoreCase("back")) {
                    return;
                }
                try {
                    int pointInput = Integer.parseInt(input);
                    if (pointInput < 0 || pointInput > points) {
                        System.out.println("Invalid number of points. Try again.");
                        i--; // Retry this attribute
                        continue;
                    }
                    attributes[i] += pointInput;
                    points -= pointInput;
                } catch (NumberFormatException e) {
                    System.out.println("Invalid input. Please enter a number.");
                    i--; // Retry this attribute
                }
            }

            if (points > 0) {
                System.out.println("You must distribute exactly 10 points. Please continue allocating the remaining points.");
            }
        }

        playerCharacters.add(new Character(name, attributes));
    }

    public void removePlayerCharacter() {
        if (playerCharacters.isEmpty()) {
            System.out.println("No characters to remove.");
            return;
        }

        System.out.print("Enter the ID of the character to remove (or type 'back' to return to menu): ");
        String input = scanner.next();
        if (input.equalsIgnoreCase("back")) {
            return;
        }
        try {
            int id = Integer.parseInt(input);
            if (id < 1 || id > playerCharacters.size()) {
                System.out.println("Invalid ID.");
                return;
            }
            playerCharacters.remove(id - 1);
            System.out.println("Character removed.");
        } catch (NumberFormatException e) {
            System.out.println("Invalid input. Please enter a number.");
        }
    }

    public void removeAllCharacters() {
        System.out.print("Are you sure you want to remove all characters? (yes/no, or type 'back' to return to menu): ");
        String input = scanner.next();
        if (input.equalsIgnoreCase("back")) {
            return;
        }
        if (input.equalsIgnoreCase("yes")) {
            playerCharacters.clear();
            System.out.println("All characters removed.");
        } else {
            System.out.println("Operation cancelled.");
        }
    }

    private void createBotCharacters() {
        botCharacters.clear();
        for (int i = 1; i <= MAX_CHARACTERS; i++) {
            String name = "BOT" + i;
            int[] attributes = new int[AttributeType.values().length];
            int points = 10;

            while (points > 0) {
                for (int j = 0; j < attributes.length; j++) {
                    int attributePoints = new Random().nextInt(points + 1);
                    attributes[j] = attributePoints;
                    points -= attributePoints;
                    if (points <= 0) break;
                }
            }

            botCharacters.add(new Character(name, attributes));
        }
    }

    public void startGameRounds() {
        if (playerCharacters.size() < MAX_CHARACTERS) {
            System.out.println("You need to create 5 characters before starting the game.");
            return;
        }

        createBotCharacters();

        playerTeamScore = 0;
        botTeamScore = 0;

        for (int i = 0; i < MAX_CHARACTERS; i++) {
            Character player = playerCharacters.get(i);
            Character bot = botCharacters.get(i);

            System.out.println(player.getName() + " vs " + bot.getName() + "\n");

            int playerWins = 0;
            int botWins = 0;
            int ties = 0;

            Collections.shuffle(challenges);
            List<Challenge> selectedChallenges = challenges.subList(0, 3);

            for (Challenge challenge : selectedChallenges) {
                System.out.println("Challenge: " + challenge.getName());
                try {
                    Thread.sleep(2000); // 2 seconds delay
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                boolean playerWinsChallenge = challenge.execute(player, bot);
                boolean botWinsChallenge = challenge.execute(bot, player);

                if (playerWinsChallenge && !botWinsChallenge) {
                    System.out.println(player.getName() + " wins the " + challenge.getName() + "!\n");
                    playerWins++;
                } else if (!playerWinsChallenge && botWinsChallenge) {
                    System.out.println(bot.getName() + " wins the " + challenge.getName() + "!\n");
                    botWins++;
                } else {
                    System.out.println("It's a tie in the " + challenge.getName() + "!\n");
                    ties++;
                }

                try {
                    Thread.sleep(2000); // 2 seconds delay before the next challenge
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

            System.out.println(player.getName() + " won " + playerWins + " challenges.");
            System.out.println(bot.getName() + " won " + botWins + " challenges.");
            System.out.println("There were " + ties + " ties.\n");

            if (playerWins > botWins) {
                System.out.println(player.getName() + " is the overall winner!");
                playerTeamScore++;
            } else if (botWins > playerWins) {
                System.out.println(bot.getName() + " is the overall winner!");
                botTeamScore++;
            } else {
                System.out.println("It's a tie overall!");
            }

            System.out.println("Current Score: " + botTeamName + " " + botTeamScore + " : " + playerTeamScore + " " + "Team " + playerTeamName);
        }

        if (playerTeamScore > botTeamScore) {
            System.out.println("Team " + playerTeamName + " wins!");
        } else if (botTeamScore > playerTeamScore) {
            System.out.println(botTeamName + " wins!");
        } else {
            System.out.println("It's a tie!");
        }
    }

    public void showAllCharacters() {
        if (playerCharacters.isEmpty()) {
            System.out.println("No characters to display.");
            return;
        }

        for (int i = 0; i < playerCharacters.size(); i++) {
            Character character = playerCharacters.get(i);
            System.out.println("ID: " + (i + 1) + ", " + character);
        }
    }

    public void showMenu() {
        while (true) {
            System.out.println("Menu:");
            System.out.println("1. Set team name");
            System.out.println("2. Add new character");
            System.out.println("3. Remove a character");
            System.out.println("4. Remove all characters");
            System.out.println("5. Show all characters");
            System.out.println("6. Start game rounds");
            System.out.println("7. Exit");
            System.out.print("Enter your choice: ");
            try {
                int choice = Integer.parseInt(scanner.next());
                switch (choice) {
                    case 1:
                        setPlayerTeamName();
                        break;
                    case 2:
                        createPlayerCharacter();
                        break;
                    case 3:
                        removePlayerCharacter();
                        break;
                    case 4:
                        removeAllCharacters();
                        break;
                    case 5:
                        showAllCharacters();
                        break;
                    case 6:
                        startGameRounds();
                        break;
                    case 7:
                        System.out.println("Exiting...");
                        return;
                    default:
                        System.out.println("Invalid choice. Try again.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a number.");
            }
        }
    }
}
