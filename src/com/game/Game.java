package com.game;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Game {
    private List<Character> playerCharacters;
    private List<Character> botCharacters;
    private List<String> challenges;
    private Random random;
    private Scanner scanner;
    private String playerTeamName;
    private String botTeamName;
    private int playerTeamScore;
    private int botTeamScore;

    public Game() {
        playerCharacters = new ArrayList<>();
        botCharacters = new ArrayList<>();
        challenges = new ArrayList<>();
        random = new Random();
        scanner = new Scanner(System.in);
        playerTeamName = "team qwerty";
        botTeamName = "team bot";
        playerTeamScore = 0;
        botTeamScore = 0;
        initializeChallenges();
    }

    private void initializeChallenges() {
        challenges.add("Fistfight");
        challenges.add("NecromancerBattle");
        challenges.add("ForestEscape");
        challenges.add("CastleConvincing");
        challenges.add("TreasureHunt");
        challenges.add("TrapNavigation");
    }

    public void setPlayerTeamName() {
        System.out.print("Enter your team name: ");
        playerTeamName = scanner.next();
    }

    public void createPlayerCharacter() {
        if (playerCharacters.size() >= 5) {
            System.out.println("You can only add up to 5 characters.");
            return;
        }

        System.out.println("Create your character:");
        System.out.print("Enter character name: ");
        String name = scanner.next();

        int magic = 0, strength = 0, endurance = 0, charisma = 0, perception = 0, intelligence = 0;
        int points = 10;

        while (points > 0) {
            System.out.println("You have " + points + " points left to distribute.");
            System.out.print("Enter points for Magic: ");
            magic = scanner.nextInt();
            points -= magic;

            if (points > 0) {
                System.out.println("You have " + points + " points left to distribute.");
                System.out.print("Enter points for Strength: ");
                strength = scanner.nextInt();
                points -= strength;
            }

            if (points > 0) {
                System.out.println("You have " + points + " points left to distribute.");
                System.out.print("Enter points for Endurance: ");
                endurance = scanner.nextInt();
                points -= endurance;
            }

            if (points > 0) {
                System.out.println("You have " + points + " points left to distribute.");
                System.out.print("Enter points for Charisma: ");
                charisma = scanner.nextInt();
                points -= charisma;
            }

            if (points > 0) {
                System.out.println("You have " + points + " points left to distribute.");
                System.out.print("Enter points for Perception: ");
                perception = scanner.nextInt();
                points -= perception;
            }

            if (points > 0) {
                System.out.println("You have " + points + " points left to distribute.");
                System.out.print("Enter points for Intelligence: ");
                intelligence = scanner.nextInt();
                points -= intelligence;
            }

            if (points < 0) {
                System.out.println("You have distributed more than 10 points. Please try again.");
                points = 10;
            }
        }

        Character character = new Character(name, magic, strength, endurance, charisma, perception, intelligence);
        playerCharacters.add(character);
    }

    public void removePlayerCharacter() {
        if (playerCharacters.isEmpty()) {
            System.out.println("No characters to remove.");
            return;
        }

        System.out.println("Enter the ID of the character to remove:");
        int id = scanner.nextInt();

        if (id < 1 || id > playerCharacters.size()) {
            System.out.println("Invalid ID.");
            return;
        }

        playerCharacters.remove(id - 1);
        System.out.println("Character removed.");
    }

    public void showAllCharacters() {
        if (playerCharacters.isEmpty()) {
            System.out.println("No characters to display.");
            return;
        }

        for (int i = 0; i < playerCharacters.size(); i++) {
            Character character = playerCharacters.get(i);
            System.out.println("ID: " + (i + 1));
            System.out.println("Name: " + character.getName());
            System.out.println("Magic: " + character.getMagic());
            System.out.println("Strength: " + character.getStrength());
            System.out.println("Endurance: " + character.getEndurance());
            System.out.println("Charisma: " + character.getCharisma());
            System.out.println("Perception: " + character.getPerception());
            System.out.println("Intelligence: " + character.getIntelligence());
            System.out.println();
        }
    }

    public void showCharactersByAttribute(String attribute) {
        if (playerCharacters.isEmpty()) {
            System.out.println("No characters to display.");
            return;
        }

        for (Character character : playerCharacters) {
            switch (attribute.toLowerCase()) {
                case "magic":
                    System.out.println(character.getName() + " - Magic: " + character.getMagic());
                    break;
                case "strength":
                    System.out.println(character.getName() + " - Strength: " + character.getStrength());
                    break;
                case "endurance":
                    System.out.println(character.getName() + " - Endurance: " + character.getEndurance());
                    break;
                case "charisma":
                    System.out.println(character.getName() + " - Charisma: " + character.getCharisma());
                    break;
                case "perception":
                    System.out.println(character.getName() + " - Perception: " + character.getPerception());
                    break;
                case "intelligence":
                    System.out.println(character.getName() + " - Intelligence: " + character.getIntelligence());
                    break;
                default:
                    System.out.println("Invalid attribute.");
                    return;
            }
        }
    }

    private void createBotCharacters() {
        botCharacters.clear();
        for (int i = 1; i <= 5; i++) {
            String name = "BOT" + i;
            int magic = 0, strength = 0, endurance = 0, charisma = 0, perception = 0, intelligence = 0;
            int points = 10;

            while (points > 0) {
                int attributePoints = random.nextInt(points + 1);
                if (magic == 0) {
                    magic = attributePoints;
                } else if (strength == 0) {
                    strength = attributePoints;
                } else if (endurance == 0) {
                    endurance = attributePoints;
                } else if (charisma == 0) {
                    charisma = attributePoints;
                } else if (perception == 0) {
                    perception = attributePoints;
                } else if (intelligence == 0) {
                    intelligence = attributePoints;
                }
                points -= attributePoints;
            }

            Character bot = new Character(name, magic, strength, endurance, charisma, perception, intelligence);
            botCharacters.add(bot);
        }
    }

    public void startGameRounds() {
        if (playerCharacters.size() < 5) {
            System.out.println("You need to create 5 characters before starting the game.");
            return;
        }

        createBotCharacters();

        playerTeamScore = 0;
        botTeamScore = 0;

        for (int i = 0; i < 5; i++) {
            Character player = playerCharacters.get(i);
            Character bot = botCharacters.get(i);

            System.out.println(player.getName() + " vs " + bot.getName() + "\n");

            int playerWins = 0;
            int botWins = 0;
            int ties = 0;

            List<String> selectedChallenges = new ArrayList<>();
            while (selectedChallenges.size() < 3) {
                String challenge = challenges.get(random.nextInt(challenges.size()));
                if (!selectedChallenges.contains(challenge)) {
                    selectedChallenges.add(challenge);
                }
            }

            for (String challenge : selectedChallenges) {
                System.out.println("Challenge: " + challenge);
                try {
                    Thread.sleep(5000); // 5 seconds delay
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                switch (challenge) {
                    case "Fistfight":
                        if (player.getStrength() > bot.getStrength()) {
                            System.out.println(player.getName() + " has more strength than " + bot.getName() + " so " + player.getName() + " wins the Fistfight!\n");
                            playerWins++;
                        } else if (player.getStrength() < bot.getStrength()) {
                            System.out.println(bot.getName() + " has more strength than " + player.getName() + " so " + bot.getName() + " wins the Fistfight!\n");
                            botWins++;
                        } else {
                            System.out.println(player.getName() + " and " + bot.getName() + " have equal strength, so it's a tie in the Fistfight!\n");
                            ties++;
                        }
                        break;
                    case "NecromancerBattle":
                        if (player.getMagic() > bot.getMagic()) {
                            System.out.println(player.getName() + " has more magic than " + bot.getName() + " so " + player.getName() + " wins the NecromancerBattle!\n");
                            playerWins++;
                        } else if (player.getMagic() < bot.getMagic()) {
                            System.out.println(bot.getName() + " has more magic than " + player.getName() + " so " + bot.getName() + " wins the NecromancerBattle!\n");
                            botWins++;
                        } else {
                            System.out.println(player.getName() + " and " + bot.getName() + " have equal magic, so it's a tie in the NecromancerBattle!\n");
                            ties++;
                        }
                        break;
                    case "ForestEscape":
                        if (player.getEndurance() > bot.getEndurance()) {
                            System.out.println(player.getName() + " has more endurance than " + bot.getName() + " so " + player.getName() + " wins the ForestEscape!\n");
                            playerWins++;
                        } else if (player.getEndurance() < bot.getEndurance()) {
                            System.out.println(bot.getName() + " has more endurance than " + player.getName() + " so " + bot.getName() + " wins the ForestEscape!\n");
                            botWins++;
                        } else {
                            System.out.println(player.getName() + " and " + bot.getName() + " have equal endurance, so it's a tie in the ForestEscape!\n");
                            ties++;
                        }
                        break;
                    case "CastleConvincing":
                        if (player.getCharisma() > bot.getCharisma()) {
                            System.out.println(player.getName() + " has more charisma than " + bot.getName() + " so " + player.getName() + " wins the CastleConvincing!\n");
                            playerWins++;
                        } else if (player.getCharisma() < bot.getCharisma()) {
                            System.out.println(bot.getName() + " has more charisma than " + player.getName() + " so " + bot.getName() + " wins the CastleConvincing!\n");
                            botWins++;
                        } else {
                            System.out.println(player.getName() + " and " + bot.getName() + " have equal charisma, so it's a tie in the CastleConvincing!\n");
                            ties++;
                        }
                        break;
                    case "TreasureHunt":
                        if (player.getPerception() > bot.getPerception()) {
                            System.out.println(player.getName() + " has more perception than " + bot.getName() + " so " + player.getName() + " wins the TreasureHunt!\n");
                            playerWins++;
                        } else if (player.getPerception() < bot.getPerception()) {
                            System.out.println(bot.getName() + " has more perception than " + player.getName() + " so " + bot.getName() + " wins the TreasureHunt!\n");
                            botWins++;
                        } else {
                            System.out.println(player.getName() + " and " + bot.getName() + " have equal perception, so it's a tie in the TreasureHunt!\n");
                            ties++;
                        }
                        break;
                    case "TrapNavigation":
                        if (player.getIntelligence() > bot.getIntelligence()) {
                            System.out.println(player.getName() + " has more intelligence than " + bot.getName() + " so " + player.getName() + " wins the TrapNavigation!\n");
                            playerWins++;
                        } else if (player.getIntelligence() < bot.getIntelligence()) {
                            System.out.println(bot.getName() + " has more intelligence than " + player.getName() + " so " + bot.getName() + " wins the TrapNavigation!\n");
                            botWins++;
                        } else {
                            System.out.println(player.getName() + " and " + bot.getName() + " have equal intelligence, so it's a tie in the TrapNavigation!\n");
                            ties++;
                        }
                        break;
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

            System.out.println("Current Score: " + botTeamName + " " + botTeamScore + " : " + playerTeamScore + " " + playerTeamName);
        }

        if (playerTeamScore > botTeamScore) {
            System.out.println("Team " + playerTeamName + " wins!");
        } else if (botTeamScore > playerTeamScore) {
            System.out.println("Team " + botTeamName + " wins!");
        } else {
            System.out.println("It's a tie!");
        }
    }

    public void showMenu() {
        while (true) {
            System.out.println("Menu:");
            System.out.println("0. Set team name");
            System.out.println("1. Add new character");
            System.out.println("2. Remove character");
            System.out.println("3. Show all characters");
            System.out.println("4. Show characters by attribute");
            System.out.println("5. Start game rounds");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 0:
                    setPlayerTeamName();
                    break;
                case 1:
                    createPlayerCharacter();
                    break;
                case 2:
                    removePlayerCharacter();
                    break;
                case 3:
                    showAllCharacters();
                    break;
                case 4:
                    System.out.print("Enter attribute (magic, strength, endurance, charisma, perception, intelligence): ");
                    String attribute = scanner.next();
                    showCharactersByAttribute(attribute);
                    break;
                case 5:
                    startGameRounds();
                    break;
                case 6:
                    System.out.println("Exiting...");
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}