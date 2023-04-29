1import java.util.Scanner;



public class TicTacToe  {
    private static final int ROW = 3;
    private static final int COL = 3;
    private static String board [][] = new String[ROW][COL];

    public static void main(String[] args)
    {
        boolean finished = false;
        boolean playing = true;
        Scanner in = new Scanner (System.in);
        String player = "X";
        int moveCnt = 0;
        int row = -1;
        int col = -1;
        final int MOVES_FOR_WIN = 5;
        final int MOVES_FOR_TIE = 7;

        do{ player = "X";
            playing = true;
            moveCnt = 0;
            clearBoard();
            do{
                do{
                    display();
                    System.out.println("Enter move for " + player);
                    row = SafeInput.getRangedInt(in, "Enter row", 1, 3);
                    col = SafeInput.getRangedInt(in, "Enter col", 1, 3);
                    row--; col--;
                } while(!isValidMove(row, col));
                board[row][col] = player;
                moveCnt++;
                if(moveCnt>= MOVES_FOR_WIN)
                { if(isWin(player, row, col)){
                    display ();
                    System.out.println("Player" + player + " wins!");
                    playing = false;
                }
                    if (moveCnt == 9) {
                        display();
                        System.out.println("It's a tie!");
                        break;}
                    else{}
                }

                while(!playing){
                    if (moveCnt == 9) {
                        System.out.println("It's a tie!");}
                    else{}
                }

                if(player.equals("X")){
                    player = "O";
                }
                else { player= "X";}
            }while(playing);

            if (playing == true)
            {
                finished = SafeInput.getYNConfirm(in, "Do you want to play again?");
            }

        }while(!finished);
    }



    private static boolean isColWin(String player)
    {
        for(int col = 0; col < COL; col++)
        {
            if(board[0][col].equals(player)&&
                    board[1][col].equals(player)&&
                    board[2][col].equals(player))
            {
                return true;
            }
        }
        return false;
    }

    private static boolean isDiagnalWin(String player){
        if(board[0][0].equals(player)&&
                board[1][1].equals(player)&&
                board[2][2].equals(player))
        {return true;}
        else if(board[0][2].equals(player)&&
                board[1][1].equals(player)&&
                board[2][0].equals(player))
        {return true;}
        return false;
    }


    private static boolean isRowWin(String player)
    {
        for(int row = 0; row < ROW; row++)
        {
            if(board[row][0].equals(player)&&
                    board[row][1].equals(player)&&
                    board[row][2].equals(player))
            {
                return true;
            }
        }
        return false;
    }

    private static void clearBoard(){
        for(int row=0; row < ROW; row++)
        {for (int col=0; col <COL; col++)
        {board[row][col] = "";
        }}}

    private static boolean isValidMove(int row, int col){
        boolean retVal = false;
        if(board[row][col].equals(""))
            retVal = true;
        else
            System.out.println("That is an invalid move! Please try again!");
        return retVal;}

    private static void display()
    {
        for(int row = 0; row<ROW;row++)
        { System.out.print("| ");
            for(int col = 0; col<COL; col++)
            {System.out.print(board[row][col] + " | ");
            }
            System.out.println();
        }
    }




    private static boolean isWin(String player, int row, int col)
    {
        if(isColWin(player) || isRowWin(player) || isDiagnalWin(player))
        {
            return true;
        }
        return false;
    }

}