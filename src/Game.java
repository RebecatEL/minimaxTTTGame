import java.util.Scanner;

public class Game {

    public Player player1;
    public Player player2;
    public DumbAI dumbAI;
    public SmartAI smartAI; //
    public Board board;

    public char symbolUser1Char;
    public char symbolUser2Char;
    public char symbolBotChar;
    public Game(){
        player1 = new Player();
        player2 = new Player();
        dumbAI = new DumbAI();
        board = new Board();
        smartAI = new SmartAI(symbolUser1Char,symbolUser1Char,board.board); //
    }

    Scanner input = new Scanner(System.in);
    public void dumbAiGame(){
        System.out.println("This are the positions, please input one of them to make your moves");
        board.printTutorialBoard();
        System.out.println(" ");

        // User Symbol Selection
        System.out.println("Choose your symbol: X/O");
        System.out.println(" ");
        String symbolUserString = input.nextLine();
        while ((symbolUserString.toLowerCase().compareTo("x") != 0) && (symbolUserString.toLowerCase().compareTo("o") != 0)){
            System.out.println("Wrong input, X/O");
            symbolUserString = input.nextLine();
        }

        if (symbolUserString.toLowerCase().compareTo("x") == 0){
            symbolUser1Char = 'X';
            symbolBotChar = 'O';
        } else {
            symbolUser1Char = 'O';
            symbolBotChar = 'X';
        }

        // User first movement choice
        System.out.println("Do you want to go first? y/n");
        String choice = input.nextLine();
        while ((choice.toLowerCase().compareTo("y") != 0) && (choice.toLowerCase().compareTo("n") != 0)){
            System.out.println("Wrong input, y/n");
            choice = input.nextLine();
        }

        if (choice.toLowerCase().compareTo("n") == 0){
            board.makeMovement(symbolBotChar,dumbAI.makeMove());
        }
        // Game
        board.printActualBoard();
        while (!board.checkFull()){
            // User move
            while (true){
                if(board.makeMovement(symbolUser1Char,player1.makeMovement())){
                    board.printActualBoard();
                    System.out.println(" ");
                    break;
                }
                else {
                    System.out.println("That positions is already full, try again\n");
                }
            }

            if( board.checkWin(symbolUser1Char)){
                System.out.println("Congratulations you won");
                break;
            }

            // Bot move
            while (true){
                if(board.makeMovement(symbolBotChar,dumbAI.makeMove())){
                    board.printActualBoard();
                    System.out.println("AI move");
                    break;
                }
            }

            if (board.checkWin(symbolBotChar)){
                System.out.println("The AI won this match, Try again!");
                break;
            }

        }

        if (board.checkFull() && board.checkWin(symbolBotChar) && board.checkWin(symbolUser1Char)){
            System.out.println("You ended the match in a draw");
        }
        board.cleanBoard();
    }

    public void intelligentAIGame(){
        //code for intelligentAIGame method
        System.out.println("This are the positions, please input one of them to make your moves");
        board.printTutorialBoard();
        System.out.println(" ");

        // User Symbol Selection
        System.out.println("Choose your symbol: X/O");
        System.out.println(" ");
        String symbolUserString = input.nextLine();
        while ((symbolUserString.toLowerCase().compareTo("x") != 0) && (symbolUserString.toLowerCase().compareTo("o") != 0)){
            System.out.println("Wrong input, X/O");
            symbolUserString = input.nextLine();
        }

        if (symbolUserString.toLowerCase().compareTo("x") == 0){
            symbolUser1Char = 'X';
            symbolBotChar = 'O';
        } else {
            symbolUser1Char = 'O';
            symbolBotChar = 'X';
        }

        // User first movement choice
        System.out.println("Do you want to go first? y/n");
        String choice = input.nextLine();
        while ((choice.toLowerCase().compareTo("y") != 0) && (choice.toLowerCase().compareTo("n") != 0)){
            System.out.println("Wrong input, y/n");
            choice = input.nextLine();
        }

        if (choice.toLowerCase().compareTo("n") == 0){
            board.makeMovement(symbolBotChar,smartAI.makeMove());  //
        }

        board.printActualBoard();
        while (!board.checkFull()){  // Check if board != empty
            // User move
            while (true){
                if(board.makeMovement(symbolUser1Char,player1.makeMovement())){
                    board.printActualBoard();
                    System.out.println(" ");
                    break;
                }
                else {
                    System.out.println("That positions is already full, try again\n");
                }
            }

            if( board.checkWin(symbolUser1Char)){
                System.out.println("Congratulations you won");
                break;
            }

            smartAI.setBoard(board.board);
            // Bot move
            while (true){
                if(board.makeMovement(symbolBotChar,smartAI.makeMove())){  // Smart AI move
                    board.printActualBoard();
                    System.out.println("AI move");
                    break;
                }
            }

            if (board.checkWin(symbolBotChar)){
                System.out.println("The AI won this match, Try again!");
                break;
            }

        }

        if (board.checkFull() && board.checkWin(symbolBotChar) && board.checkWin(symbolUser1Char)){
            System.out.println("You ended the match in a draw");
        }
        board.cleanBoard();
    }



    public void twoPlayer(){

        System.out.println("Welcome to the Tic Tac Toe game!");
        board.printTutorialBoard();

        System.out.println("Enter the first player name: ");
        String name1 = input.nextLine();

        System.out.println("Enter the second player name: ");
        String name2 = input.nextLine();

        // User Symbol Selection
        System.out.println(name1 + "--Choose your symbol: X/O");
        String symbolUserString = input.nextLine();
        while ((symbolUserString.toLowerCase().compareTo("x") != 0) && (symbolUserString.toLowerCase().compareTo("o") != 0)){
            System.out.println("Wrong input, X/O");
            symbolUserString = input.nextLine();
        }

        if (symbolUserString.toLowerCase().compareTo("x") == 0){
            symbolUser1Char = 'X';
            symbolUser2Char = 'O';
        } else {
            symbolUser1Char = 'O';
            symbolUser2Char = 'X';
        }

        while (!board.checkFull()) {
            // First User move
            while (true) {
                System.out.println(name1 + "'s turn!");
                if (board.makeMovement(symbolUser1Char, player1.makeMovement())) {
                    board.printActualBoard();
                    break;
                } else {
                    System.out.println("That positions is already full, try again\n");
                }
            }

            if (board.checkWin(symbolUser1Char)) {
                System.out.println("Congratulations! " + name1 + " won this game");
                break;
            }
            // Second User move
            while (true){
                System.out.println(name2 + "'s turn!");
                if(board.makeMovement(symbolUser2Char,player2.makeMovement())){
                    board.printActualBoard();
                    break;
                }
                else {
                    System.out.println("That positions is already full, try again\n");
                }
            }

            if( board.checkWin(symbolUser2Char)){
                System.out.println("Congratulations! " + name2 +" won this game");
                break;
            }
        }
        if (board.checkFull() && board.checkWin(symbolBotChar) && board.checkWin(symbolUser1Char)){
            System.out.println("You ended the match in a draw");
        }
        board.cleanBoard();
    }

}
