package GameLogic;

import java.util.Random;
import java.util.random.RandomGenerator;

public class GameBoard {
    private boolean[][] Board;
    private final int Rows;
    private final int Columns;


    public GameBoard(int rows, int columns, int percentPopulated)
    {
        boolean[][] board = new boolean[rows][columns];
        Random random = new Random();

        for(int i = 0; i < rows; i++)
        {
            for(int j = 0; j < columns; j++)
            {
                int randNumber = random.nextInt(100);
                board[i][j] = randNumber < percentPopulated;
            }
        }
        Board = board;
        Rows = rows;
        Columns = columns;
    }

    public void nextTick()
    {
        boolean[][] board = CopyBoard();
        for (int i = 0; i < Rows; i++) {
            for (int j = 0; j < Columns; j++) {
                switch (numberOfNgh(i,j))
                {
                    case 2:
                        if(board[i][j])
                            break;
                    case 3:
                        board[i][j] = true;
                        break;
                    default:
                        board[i][j] = false;
                        break;
                }
            }
        }
        Board = board;
    }


    private boolean[][] CopyBoard()
    {
        boolean[][] Copy = new boolean[Rows][Columns];
        for (int i = 0; i < Rows; i++) {
            for (int j = 0; j < Columns; j++) {
                Copy[i][j] = Board[i][j];
            }
        }
        return Copy;
    }

    private int numberOfNgh(int rowIdent, int colIdent)
    {
        int count = 0;
        for (int i = getLowBoud(rowIdent); i < getHighBoundRow(rowIdent); i++) {
            for (int j = getLowBoud(colIdent); j < getHighBoundCol(colIdent); j++) {
                if(Board[i][j] && (rowIdent != i && colIdent != j))
                    count++;
            }
        }
        return count;
    }

    private int getLowBoud(int index)
    {
        if(index == 0) return 0;
        return index - 1;
    }

    private int getHighBoundRow(int i)
    {
        if(i == Rows - 1)
            return i;
        else return i + 1;
    }
    private int getHighBoundCol(int j)
    {
        if(j == Columns - 1)
            return j;
        else return j + 1;
    }

}
