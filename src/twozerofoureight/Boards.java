package twozerofoureight;

import twozerofoureight.aTile;

public class Boards
{
    public aTile[][] board;
    int cols = 4;
    int border = 0;
    public int score = 0;
    public Boards()
    {
        board = new aTile[4][4];
        for ( int i = 0; i < board.length; i++ )
        {
            for ( int j = 0; j < board[i].length; j++ )
            {
                board[i][j] = new aTile();
            }
        }
    }
    public Boards( int grids )
    {
        this.cols = grids;
        board = new aTile[grids][grids];
        for ( int i = 0; i < board.length; i++ )
        {
            for ( int j = 0; j < board[i].length; j++ )
            {
                board[i][j] = new aTile();
            }
        }
    }
    public Boards( int num, int grids )
    {
        this.cols = grids;
        board = new aTile[grids][grids];
        for ( int i = 0; i < board.length; i++ )
        {
            for ( int j = 0; j < board[i].length; j++ )
            {
                board[i][j] = new aTile( ( num + i + j ) * ( i + j ) );
            }
        }
    }

    public aTile[][] getBoard()
    {
        return board;
    }
    public int getScore()
    {
        return score;
    }
    public int getHighestTile()
    {
        int high = board[0][0].getValue();
        for ( int i = 0; i < board.length; i++ )
        {
            for ( int j = 0; j < board[i].length; j++ )
            {
                if ( board[i][j].getValue() > high )
                {
                    high = board[i][j].getValue();
                }
            }
        }
        return high;
    }
    public void print()
    {
        for ( int i = 0; i < board.length; i++ )
        {
            for ( int j = 0; j < board[i].length; j++ )
            {
                String s = board[i][j].toString() + " ";
                System.out.print( s );
            }
            System.out.println( "" );
        }
        System.out.println( "Score of the game: " + score );
    }
    public String toString()
    {
        String str = "";
        for ( int i = 0; i < board.length; i++ )
        {
            for ( int j = 0; j < board[i].length; j++ )
            {
                str += board[i][j].toString() + " ";
            }
            str += "\n";
        }
        return str;
    }
    public void space()
    {
        boolean empty = true;
        while ( empty )
        {
            int row = (int)( Math.random() * 4 );
            int col = (int)( Math.random() * 4 );
            double x = Math.random();
            if ( board[row][col].getValue() == 0 )
            {
                if ( x < 0.2 )
                {
                    board[row][col] = new aTile( 4 );
                    empty = false;
                }
                else
                {
                    board[row][col] = new aTile( 2 );
                    empty = false;
                }
            }

        }

    }
    public boolean outofGame()
    {
        int count = 0;
        for ( int i = 0; i < board.length; i++ )
        {
            for ( int j = 0; j < board[i].length; j++ )
            {
                if ( board[i][j].getValue() > 0 )
                {
                    count++;
                }
            }
        }
        if ( count == 16 )
        {
            return true;
        }
        return false;
    }
    public boolean gameOver()
    {
        int count = 0;
        for ( int i = 0; i < board.length; i++ )
        {
            for ( int j = 0; j < board[i].length; j++ )
            {
                if ( board[i][j].getValue() > 0 )
                {
                    if ( i == 0 && j == 0 )
                    {
                        if ( board[i][j].getValue() != board[i + 1][j].getValue()
                                && board[i][j].getValue() != board[i][j + 1].getValue() )
                        {
                            count++;
                        }
                    }
                    else if ( i == 0 && j == 3 )
                    {
                        if ( board[i][j].getValue() != board[i + 1][j].getValue()
                                && board[i][j].getValue() != board[i][j - 1].getValue() )
                        {
                            count++;
                        }
                    }
                    else if ( i == 3 && j == 3 )
                    {
                        if ( board[i][j].getValue() != board[i - 1][j].getValue()
                                && board[i][j].getValue() != board[i][j - 1].getValue() )
                        {
                            count++;
                        }
                    }
                    else if ( i == 3 && j == 0 )
                    {
                        if ( board[i][j].getValue() != board[i - 1][j].getValue()
                                && board[i][j].getValue() != board[i][j + 1].getValue() )
                        {
                            count++;
                        }
                    }
                    else if ( i == 0 && ( j == 1 || j == 2 ) )
                    {
                        if ( board[i][j].getValue() != board[i + 1][j].getValue()
                                && board[i][j].getValue() != board[i][j + 1].getValue()
                                && board[i][j].getValue() != board[i][j - 1].getValue() )
                        {
                            count++;
                        }
                    }
                    else if ( i == 3 && ( j == 1 || j == 2 ) )
                    {
                        if ( board[i][j].getValue() != board[i - 1][j].getValue()
                                && board[i][j].getValue() != board[i][j + 1].getValue()
                                && board[i][j].getValue() != board[i][j - 1].getValue() )
                        {
                            count++;
                        }
                    }
                    else if ( j == 0 && ( i == 1 || i == 2 ) )
                    {
                        if ( board[i][j].getValue() != board[i][j + 1].getValue()
                                && board[i][j].getValue() != board[i - 1][j].getValue()
                                && board[i][j].getValue() != board[i + 1][j].getValue() )
                        {
                            count++;
                        }
                    }
                    else if ( j == 3 && ( i == 1 || i == 2 ) )
                    {
                        if ( board[i][j].getValue() != board[i][j - 1].getValue()
                                && board[i][j].getValue() != board[i - 1][j].getValue()
                                && board[i][j].getValue() != board[i + 1][j].getValue() )
                        {
                            count++;
                        }
                    }
                    else
                    {
                        if ( board[i][j].getValue() != board[i][j - 1].getValue()
                                && board[i][j].getValue() != board[i][j + 1].getValue()
                                && board[i][j].getValue() != board[i - 1][j].getValue()
                                && board[i][j].getValue() != board[i + 1][j].getValue() )
                        {
                            count++;
                        }
                    }
                }
            }
        }
        if ( count == 16 )
        {
            return true;
        }
        return false;
    }

    public void up()
    {
        for ( int i = 0; i < cols; i++ )
        {
            border = 0;
            for ( int j = 0; j < cols; j++ )
            {
                if ( board[j][i].getValue() != 0 )
                {
                    if ( border <= j )
                    {
                        vertical( j, i, "up" );
                    }
                }
            }
        }
    }
    public void down()
    {
        for ( int i = 0; i < cols; i++ )
        {
            border = ( cols - 1 );
            for ( int j = cols - 1; j >= 0; j-- )
            {
                if ( board[j][i].getValue() != 0 )
                {
                    if ( border >= j )
                    {
                        vertical( j, i, "down" );
                    }
                }
            }
        }
    }
    private void vertical( int row, int col, String direction )
    {
        aTile start = board[border][col];
        aTile compare = board[row][col];
        if ( start.getValue() == 0 || start.getValue() == compare.getValue() )
        {
            if ( row > border || ( direction.equals( "down" ) && ( row < border ) ) )
            {
                int addScore = start.getValue() + compare.getValue();
                if ( start.getValue() != 0 )
                {
                    score += addScore;
                }
                start.setValue( addScore );
                compare.setValue( 0 );
            }
        }
        else
        {
            if ( direction.equals( "down" ) )
            {
                border--;
            }
            else
            {
                border++;
            }
            vertical( row, col, direction );
        }
    }
    public void left()
    {
        for ( int i = 0; i < cols; i++ )
        {
            border = 0;
            for ( int j = 0; j < cols; j++ )
            {
                if ( board[i][j].getValue() != 0 )
                {
                    if ( border <= j )
                    {
                        horizontal( i, j, "left" );
                    }
                }
            }
        }
    }
    public void right()
    {
        for ( int i = 0; i < cols; i++ )
        {
            border = ( cols - 1 );
            for ( int j = ( cols - 1 ); j >= 0; j-- )
            {
                if ( board[i][j].getValue() != 0 )
                {
                    if ( border >= j )
                    {
                        horizontal( i, j, "right" );
                    }
                }
            }
        }
    }

    private void horizontal( int row, int col, String direction )
    {
        aTile start = board[row][border];
        aTile compare = board[row][col];
        if ( start.getValue() == 0 || start.getValue() == compare.getValue() )
        {
            if ( col > border || ( direction.equals( "right" ) && ( col < border ) ) )
            {
                int addScore = start.getValue() + compare.getValue();
                if ( start.getValue() != 0 )
                {
                    score += addScore;
                }
                start.setValue( addScore );
                compare.setValue( 0 );
            }
        }
        else
        {
            if ( direction.equals( "right" ) )
            {
                border--;
            }
            else
            {
                border++;
            }
            horizontal( row, col, direction );
        }
    }

}
