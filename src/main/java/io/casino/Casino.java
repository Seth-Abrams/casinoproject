package io.casino;

import io.casino.chancegames.Roulette;
import io.casino.interfaces.Game;

    public class Casino {
        private Player player;
        private Game game;
        private int choice;
        boolean playFlag;

        public Casino() {
            player = new Player();
        }

        public void startCasino() {

            printWelcome();
            askForName();
            askForBank();
            chooseGame();
        }


        public void printWelcome(){
            Console.print("♠♥♦♣♠♥♦♣♠♥♦♣♠♥♦♣♠♥♦♣♠♥♦♣♠♥♦♣♠♥♦♣♠♥♦♣♠♥♦♣♠♥♦♣♠♥♦♣♠♥♦♣♠♥♦♣♠♥♦♣");
            Console.print("  /$$$$$$   /$$$$$$   /$$$$$$  /$$$$$$ /$$   /$$  /$$$$$$ \n" +
                    " /$$__  $$ /$$__  $$ /$$__  $$|_  $$_/| $$$ | $$ /$$__  $$\n" +
                    "| $$  \\__/| $$  \\ $$| $$  \\__/  | $$  | $$$$| $$| $$  \\ $$\n" +
                    "| $$      | $$$$$$$$|  $$$$$$   | $$  | $$ $$ $$| $$  | $$\n" +
                    "| $$      | $$__  $$ \\____  $$  | $$  | $$  $$$$| $$  | $$\n" +
                    "| $$    $$| $$  | $$ /$$  \\ $$  | $$  | $$\\  $$$| $$  | $$\n" +
                    "|  $$$$$$/| $$  | $$|  $$$$$$/ /$$$$$$| $$ \\  $$|  $$$$$$/\n" +
                    " \\______/ |__/  |__/ \\______/ |______/|__/  \\__/ \\______/");
            Console.print("♠♥♦♣♠♥♦♣♠♥♦♣♠♥♦♣♠♥♦♣♠♥♦♣♠♥♦♣♠♥♦♣♠♥♦♣♠♥♦♣♠♥♦♣♠♥♦♣♠♥♦♣♠♥♦♣♠♥♦♣");
            Console.print("Welcome to the io.casino.Casino");
        }

        public void askForName() {
            player.setName(Console.printAndTakeString("Enter your name:"));
        }

        public void printMenu() {
            Console.print("Choose a game! Enter the option number (ex. 1 for Blackjack)"
                    + "\nPlayer Bank: "
                    + player.getBank()
                    + "\n1: Blackjack\n2: Hi Lo\n3: Roulette"
                    + "\n4: Craps\n5: Slots\n6: Go Fish\n7: Quit io.casino.Casino");
        }

        public void askForBank() {

            int userBank = Console.printAndTakeInt("Enter the amount you want to start playing with (bank) :");
            if (!player.checkInitialBank(userBank)) {
                Console.print("Didn't quite catch that, here's 10k Zimbabwean dollars to play.");
                player.setBank(10000);
            } else {
                player.setBank(userBank);
            }
        }


        private void chooseGame() {
            boolean playGame = true;
            while (playGame) {
                printMenu();
                choice = Console.getIntegerInput();
                switch (choice) {
                    case 1:
                        game = new Roulette(player);
                        game.play();
                        break;

                    case 2:
                        playGame = false;

                    default:
                        Console.print("Incorrect choice. Choose the listed options");
                        continue;
                }

                Console.print("\n\n\n\n\n♠♥♦♣♠♥♦♣♠♥♦♣♠♥♦♣♠♥♦♣♠♥♦♣♠♥♦♣♠♥♦♣♠♥♦♣♠♥♦♣♠♥♦♣♠♥♦♣♠♥♦♣♠♥♦♣♠♥♦♣\n"
                        + "Welcome back to the io.casino.Casino Menu!");
            }
        }
    }

