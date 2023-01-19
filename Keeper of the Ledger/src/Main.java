import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

import static java.lang.System.exit;

public class Main {

    private static ArrayList<NPC> NPCList = new ArrayList<NPC>();
    private static ArrayList<Item> inventoryList = new ArrayList<>();

    // Variables
    public static boolean winFight = false;


    public static void main(String[] args) {
        Scanner scnr = new Scanner(System.in);
        String userIn = "-1";
        Self self = new Self();
        String currentLocation = "null";

        while (userIn == "-1") {
            System.out.println("Welcome to the Keeper of the Ledger. Start a new game? (y/n)");
            userIn = scnr.nextLine();
            if ((userIn.equalsIgnoreCase("no") || (userIn.equalsIgnoreCase("n")))) {
                quit();
            }
            if ((userIn.equalsIgnoreCase("yes")) || (userIn.equalsIgnoreCase("y"))) {
                gameStarting();
                //initializeShards();
                initializeSelf(self);
                characterCreation(self);

                currentLocation = "Courtyard";
                System.out.println("You are in the Courtyard. Where would you like to go?");

                // GAME LOOP HERE
                while (userIn != "QUIT") {
                    userIn = scnr.nextLine();
                    switch (userIn) {
                        case "go north":
                            System.out.println("This has not been implemented yet");
                            switch (currentLocation) {
                                case "Courtyard":
                                    currentLocation = "Barn";
                                    System.out.println("You travel down a rocky northern path and follow a familiar scent that reminds you of home.");
                                    courtyard();
                            }
                            break;

                        case "go south":
                            System.out.println("This has not been implemented yet");
                            break;

                        case "go east":
                            System.out.println("This has not been implemented yet");
                            break;

                        case "go west":
                            System.out.println("This has not been implemented yet");
                            break;

                        case "QUIT":
                            System.out.println("This has not been implemented yet");
                            break;

                        case "HELP":
                            System.out.println("This has not been implemented yet");
                            break;

                        case "STATS":
                            System.out.println("This has not been implemented yet");
                            break;

                        case "INVENTORY":
                            System.out.println("This has not been implemented yet");
                            break;

                        default:
                            System.out.println("Invalid input. Type \"HELP\" for a list of commands.");
                            break;
                    }


                }

            } else {
                System.out.println("Invalid input");
                userIn = "-1";
            }
        }

    }

    public static void characterCreation(Self me) {
        // in progress
        String userIn = "-1";
        int points = 11;
        int charisma = me.getCharisma();
        int strength = me.getStrength();
        int endurance = me.getEndurance();

        int sum = charisma + strength + endurance;

        int remaining = 11 - sum;

        int userIntIn;

        boolean change = true;

        Scanner scnr = new Scanner(System.in);
        System.out.printf("Create your character here.\n" +
                "Points remaining: %s \n" +
                "Charisma: %s\n" +
                "Strength: %s\n" +
                "Endurance: %s\n" +
                "Make changes? (Y/N)\n",remaining, charisma, strength, endurance);
        userIn = scnr.nextLine();
        if (userIn.equalsIgnoreCase("Y")) {
            while (change) {
                System.out.println("Change what?");
                // Use printf and Self() class
                userIn = scnr.next();
                try {
                    if (userIn.equalsIgnoreCase("charisma")) {
                        System.out.println("+/- how many points?");
                        userIntIn = scnr.nextInt();
                        charisma = charisma + userIntIn;
                        remaining = remaining - userIntIn;

                        if (((sum) > points) || (remaining < 0)) {
                            charisma = charisma - userIntIn;
                            remaining = remaining + userIntIn;
                            System.out.printf("Not enough points remaining. You have %s points remaining\n", remaining);
                        }
                        if ((charisma) <= 0) {
                            charisma = charisma - userIntIn;
                            remaining = remaining + userIntIn;
                            System.out.printf("Cannot have less than 1 point in each skill. You have %s points remaining\n", remaining);
                        }
                        if ((sum) <= points) {
                            System.out.printf(
                                    "Points remaining: %s \n" +
                                            "Charisma: %s\n" +
                                            "Strength: %s\n" +
                                            "Endurance: %s\n" +
                                            "Make changes? (Y/N)\n", remaining, charisma, strength, endurance);
                            userIn = scnr.next();

                            if (userIn.equalsIgnoreCase("y")) {}

                            if (userIn.equalsIgnoreCase("n")) { break; }
                        }
                    }
                }
                catch(InputMismatchException e) {System.out.println("Invalid input");}

                try {
                    if (userIn.equalsIgnoreCase("strength")) {
                        System.out.println("+/- how many points?");
                        userIntIn = scnr.nextInt();
                        strength = strength + userIntIn;
                        remaining = remaining - userIntIn;
                        if ((sum) > points || (remaining < 0)) {
                            strength = strength - userIntIn;
                            remaining = remaining + userIntIn;
                            System.out.printf("Not enough points remaining. You have %s points remaining\n", remaining);
                        }
                        if ((strength) <= 0) {
                            strength = strength - userIntIn;
                            remaining = remaining + userIntIn;
                            System.out.printf("Cannot have less than 1 point in each skill. You have %s points remaining\n", remaining);
                        }
                        if ((sum) <= points) {
                            System.out.printf(
                                    "Points remaining: %s \n" +
                                            "Charisma: %s\n" +
                                            "Strength: %s\n" +
                                            "Endurance: %s\n" +
                                            "Make changes? (Y/N)\n", remaining, charisma, strength, endurance);
                            userIn = scnr.next();

                            if (userIn.equalsIgnoreCase("y")) {}

                            if (userIn.equalsIgnoreCase("n")) { break; }
                        }
                    }
                }
                catch(InputMismatchException e) {System.out.println("Invalid input");}

                try {
                    if (userIn.equalsIgnoreCase("endurance")) {
                        System.out.println("+/- how many points?");
                        userIntIn = scnr.nextInt();
                        endurance = endurance + userIntIn;
                        remaining = remaining - userIntIn;

                        if ((sum) > points || (remaining < 0)) {
                            endurance = endurance - userIntIn;
                            remaining = remaining + userIntIn;
                            System.out.printf("Not enough points remaining. You have %s points remaining\n", remaining);
                        }

                        if ((endurance) <= 0) {
                            endurance = endurance - userIntIn;
                            remaining = remaining + userIntIn;
                            System.out.printf("Cannot have less than 1 point in each skill. You have %s points remaining\n", remaining);
                        }

                        if ((sum) <= points) {
                            System.out.printf(
                                    "Points remaining: %s \n" +
                                            "Charisma: %s\n" +
                                            "Strength: %s\n" +
                                            "Endurance: %s\n" +
                                            "Make changes? (Y/N)\n", remaining, charisma, strength, endurance);
                            userIn = scnr.next();
                            if (userIn.equalsIgnoreCase("y")) {}

                            if (userIn.equalsIgnoreCase("n")) { break; }
                        }
                    }
                }
                catch(InputMismatchException e) {System.out.println("Invalid input");}
            }
        }
        if (userIn.equalsIgnoreCase("n")) {

        }

    }

    public static void initializeOliver() {
        Oliver Oliver = new Oliver(3, 1, 1, 200, 400);
    }

    public static void viewInventory() {
        if (inventoryList.size() == 0) {
            System.out.print("Nothing in inventory");
        } else {
            System.out.println(inventoryList);
        }
    }

    public static void quit() {
        System.out.println("Goodbye!");
        exit(0);
    }

    public static void gameStarting() {
        Scanner scnr = new Scanner(System.in);
        String userIn = "-1";

        System.out.println("You enter the labyrinth, and are aiming to achieve eternal life by defeating the keeper of the ledger.");
        displayControls();

        while (userIn != "") {
            System.out.println("Press enter to continue");
            userIn = scnr.nextLine();
        }

    }

    public static void displayControls() {
        System.out.println("Move between rooms by typing \"go north\", \"go south\", \"go west\", or \"go east\".");
        System.out.println("View your inventory by typing \"INVENTORY\".");
        System.out.println("View the list of controls by typing \"HELP\".");
        System.out.println("View your stats an by typing \"STATS\".");
        System.out.println("Quit the game by typing \"QUIT\" (progress is not saved).");
    }

    /*public static void initializeShards() {
        Shards shard1 = new Shards(false, 1);
        Shards shard2 = new Shards(false, 1);
        Shards shard3 = new Shards(false, 1);
        Shards shard4 = new Shards(false, 1);
        Shards shard5 = new Shards(false, 1);
        Shards shard6 = new Shards(false, 1);

    }*/

    public static void courtyard() {
        Scanner scnr = new Scanner(System.in);
        String userIn = "-1";

        boolean dialogue = true;
        // if shard is in inventory, if oliver is dead
        if (inventoryList.contains("Shard 1")) {

        } else {
            while (userIn != "") {
                System.out.println("You arrive at a barn, and a creature who appears to be half-man half-hog approaches you. You cower in fear for a moment before" +
                        "he speaks to you. \n \n" +
                        "\"Hello! Oh wow I haven't had a visitor in years! I don't intend to harm you, please come in!\" \n" +
                        "Press enter.");
                userIn = scnr.nextLine();
            }

            userIn = "-1";

            while (dialogue) {

                System.out.println("A. \"Who are you? Why do you look like that?\"");
                System.out.println("B. \"Where am I?\"");
                System.out.println("C. \"Creatures like you don't deserve to stay alive.\"");
                //System.out.println(userIn);

                userIn = scnr.nextLine();
                //System.out.println(userIn);

                switch (userIn) {

                    case ("A"):
                        System.out.println("Dialogue continues");
                        courtyardDialogueA();
                        break;

                    case ("B"):
                        System.out.println("Dialogue continues");
                        courtyardDialogueB();
                        break;

                    case ("C"):
                        System.out.println("Fight");
                        courtyardFight();
                        break;

                    default:
                        System.out.println("Invalid input. Enter A B or C.");

                }
            }
        }
    }

    public static void courtyardFight() {
        System.out.println("Fighting has not yet been implemented");
        while (!winFight) {
            System.out.println("Fight sequence not yet implemented");
            if (winFight) {
                inventoryList.add(new Shards(true, 1));
                System.out.println("You received Shard 1: Irony");
            } else {
                System.out.println("You lost the fight and died");
                System.exit(0);
            }
        }

    }

    public static void courtyardDialogueA() {
        System.out.println("Dialogue A has not yet been implemented");

    }

    public static void courtyardDialogueB() {
        System.out.println("Dialogue B has not yet been implemented");

    }

    public static void initializeSelf(Self self) {
        self.setStrength(3);
        self.setCharisma(3);
        self.setEndurance(3);

    }
}