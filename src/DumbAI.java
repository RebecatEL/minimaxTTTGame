import java.util.Random;

public class DumbAI {

    Random rand= new Random();
    int min = 1;
    int max = 0;
    public int makeMove(){
        return rand.nextInt(9) + 1;
    }
}
