import java.lang.reflect.Array;

public class Board {

    char[][] board;

    public Board() {
        board = new char[][]{{'-', '-', '-'}, {'-', '-', '-'}, {'-', '-', '-'}};
    }

    public boolean makeMovement(char sign, int pos){
        switch (pos){
            case 1:if(board[0][0] == 'X' || board[0][0] == 'O')return false;
                else{
                    board[0][0] = sign;
                    return true;
                }
            case 2:if(board[0][1] == 'X' || board[0][1] == 'O')return false;
                else{
                    board[0][1] = sign;
                    return true;
                }
            case 3:if(board[0][2] == 'X' || board[0][2] == 'O')return false;
                else{
                    board[0][2] = sign;
                    return true;
                }
            case 4:if(board[1][0] == 'X' || board[1][0] == 'O')return false;
                else{
                    board[1][0] = sign;
                    return true;
                }
            case 5:if(board[1][1] == 'X' || board[1][1] == 'O')return false;
                else{
                    board[1][1] = sign;
                    return true;
                }
            case 6:if(board[1][2] == 'X' || board[1][2] == 'O')return false;
                else{
                    board[1][2] = sign;
                    return true;
                }
            case 7:if(board[2][0] == 'X' || board[2][0] == 'O')return false;
                else{
                    board[2][0] = sign;
                    return true;
                }
            case 8:if(board[2][1] == 'X' || board[2][1] == 'O')return false;
                else{
                    board[2][1] = sign;
                    return true;
                }
            case 9:if(board[2][2] == 'X' || board[2][2] == 'O')return false;
                else{
                    board[2][2] = sign;
                    return true;
                }
            default:
                return false;
        }
    }
    public boolean checkWin(char sign){
        if (board[0][0] == sign && board[0][1] == sign && board[0][2] == sign || // 1st row
            board[1][0] == sign && board[1][1] == sign && board[1][2] == sign || // 2nd row
            board[2][0] == sign && board[2][1] == sign && board[2][2] == sign || // 3rd row
            board[0][0] == sign && board[1][0] == sign && board[2][0] == sign || // 1st col.
            board[0][1] == sign && board[1][1] == sign && board[2][1] == sign || // 2nd col.
            board[0][2] == sign && board[1][2] == sign && board[2][2] == sign || // 3rd col.
            board[0][0] == sign && board[1][1] == sign && board[2][2] == sign || // Diagonal
            board[2][0] == sign && board[1][1] == sign && board[0][2] == sign)   // Diagonal
            return true;
        else {
            return false;
        }
    }

    public boolean checkFull(){
        if (board[0][0] != '-' && board[0][1] != '-' && board[0][2] != '-' &&
            board[1][0] != '-' && board[1][1] != '-' && board[1][2] != '-' &&
            board[2][0] != '-' && board[2][1] != '-' && board[2][2] != '-')
            return true;
        else {
            return false;
        }
    }

    public void printActualBoard(){
        System.out.println("  " + board[0][0] + "  |  "
                + board[0][1] + "  |  " + board[0][2]);

        System.out.println("-----|-----|-----");

        System.out.println("  " + board[1][0] + "  |  "
                + board[1][1] + "  |  " + board[1][2]);

        System.out.println("-----|-----|-----");

        System.out.println("  " + board[2][0] + "  |  "
                + board[2][1] + "  |  " + board[2][2]);
    }

    // Board with numbers so the user knows what to input to select the space.
    public void printTutorialBoard(){
        System.out.println("  1  |  2  |  3 ");
        System.out.println("-----|-----|-----");
        System.out.println("  4  |  5  |  6");
        System.out.println("-----|-----|-----");
        System.out.println("  7  |  8  |  9");
    }

    public void cleanBoard(){
        board = new char[][]{{'-', '-', '-'}, {'-', '-', '-'}, {'-', '-', '-'}};
    }

}
