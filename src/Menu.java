import java.util.Scanner;

public class Menu {
    public void menu(){
        Scanner scanner = new Scanner(System.in);
        Game game = new Game();
        boolean quit = false;
        while(!quit){
            System.out.println("Welcome to Tic Tac Toe game!");
            System.out.println("1. Weak AI Game");
            System.out.println("2. Intelligent AI Game");
            System.out.println("3. Two human players Game");
            System.out.println("4. Quit");
            System.out.println("Enter your choice: ");
            int choice = scanner.nextInt();
            switch (choice){
                case 1:
                    do {
                        game.dumbAiGame();
                        System.out.println("Do you want to play again? (Y/N)");
                    } while (scanner.next().equalsIgnoreCase("Y"));
                    break;
                case 2:
                    do {
                        game.intelligentAIGame();
                        System.out.println("Do you want to play again? (Y/N)");
                    } while (scanner.next().equalsIgnoreCase("Y"));
                    break;
                case 3:
                    do {
                        game.twoPlayer();
                        System.out.println("Do you want to play again? (Y/N)");
                    } while (scanner.next().equalsIgnoreCase("Y"));
                    break;
                case 4:
                    quit = true;
                    System.out.println("See you next time!");
                    break;
                default:
                    System.out.println("Invalid choice.");
                    break;
            }
        }
    }

}

