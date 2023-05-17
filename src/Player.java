import java.util.Scanner;

public class Player {

public int makeMovement(){
    Scanner input = new Scanner(System.in);
    int pos;
    while (true) {
        System.out.println("Enter a position between 1 and 9:");
        String numString = input.nextLine();
        try {
            pos = Integer.parseInt(numString);
            if (pos < 1 || pos > 9) {
                System.out.println("Number must be between 1 and 9.");
                continue; // ask again
            }
        } catch (NumberFormatException e) {
            System.out.println("Invalid input. Please enter a valid number.");
            continue; // ask again
        }
        break; // valid input entered, break out of loop
    }

    return pos;

}


}
