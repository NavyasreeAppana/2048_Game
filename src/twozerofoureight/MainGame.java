package twozerofoureight;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
public class MainGame extends JPanel implements KeyListener {
    Boards game = new Boards();
    static MainGame newGame = new MainGame();
    static JFrame frame = new JFrame( "2048 GAME" );
    static Color green;
    String gameBoard = game.toString();
    public static void setGUI()
    {
        frame.addKeyListener( newGame );
        frame.getContentPane().add( newGame );
        frame.setSize( 600, 400 );
        frame.setVisible( true );
        frame.setResizable( false );
    }

    @Override
    public void keyPressed( KeyEvent e )
    {
        if ( e.getKeyChar() == '1' || e.getKeyCode() == KeyEvent.VK_UP )
        {
            game.up();
            game.spawn();
            gameBoard = game.toString();
            frame.repaint();
        }
        else if ( e.getKeyChar() == '2' || e.getKeyCode() == KeyEvent.VK_DOWN )
        {
            game.down();
            game.space();
            gameBoard = game.toString();
            frame.repaint();
        }
        else if ( e.getKeyChar() == '3' || e.getKeyCode() == KeyEvent.VK_LEFT )
        {
            game.left();
            game.space();
            gameBoard = game.toString();
            frame.repaint();
        }
        else if ( e.getKeyChar() == '4' || e.getKeyCode() == KeyEvent.VK_RIGHT )
        {
            game.right();
            game.space();
            gameBoard = game.toString();
            frame.repaint();
        }
        else if ( e.getKeyCode() == KeyEvent.VK_ENTER )
        {
            game = new Boards();
            game.space();
            game.space();
            frame.repaint();
        }
    }
    @Override
    public void keyReleased( KeyEvent e )
    {
    }
    @Override
    public void keyTyped( KeyEvent e )
    {
    }

    public void paint( Graphics g )
    {
        super.paint( g );
        Graphics2D g2 = (Graphics2D)g;
        g2.drawString( "2048 GAME", 250, 20 );
        g2.drawString( "Score of game: " + game.getScore(),150 - 4 * String.valueOf( game.getScore() ).length(),40 );
        g2.drawString( "Highest Tile of the game: " + game.getHighestTile(), 280 - 4 * String.valueOf( game.getHighestTile() ).length(), 40 );
        g2.drawString( "Click 'Enter' to Start game ", 210, 315 );
        if ( game.outofGame() )
        {
            g2.drawString( "GAME OVER!!!! Click 'Enter' to start again", 200, 355 );
        }
        g2.setColor( Color.black );
        g2.fillRect( 140, 50, 250, 250 );
        for ( int i = 0; i < 4; i++ )
        {
            for ( int j = 0; j < 4; j++ )
            {
                drawTiles( g, game.board[i][j], j * 60 + 150, i * 60 + 60 );
            }
        }
        if ( game.gameOver() )
        {
            g2.setColor( Color.gray );
            g2.fillRect( 140, 50, 250, 250 );
            for ( int i = 0; i < 4; i++ )
            {
                for ( int j = 0; j < 4; j++ )
                {
                    g2.setColor( Color.RED );
                    g2.fillRoundRect( j * 60 + 150, i * 60 + 60, 50, 50, 5, 5 );
                    g2.setColor( Color.black );
                    g.drawString( "GAME", j * 60 + 160, i * 60 + 75 );
                    g.drawString( "OVER", j * 60 + 160, i * 60 + 95 );
                }
            }
        }
    }
    public void drawTiles(Graphics g, aTile tile, int x, int y )
    {
        int ValueofTile = tile.getValue();
        int length = String.valueOf( ValueofTile ).length();
        Graphics2D g2 = (Graphics2D)g;
        g2.setColor( Color.lightGray );
        g2.fillRoundRect( x, y, 50, 50, 5, 5 );
        g2.setColor( Color.black );
        if ( ValueofTile > 0 )
        {
            g2.setColor( tile.getColor() );
            g2.fillRoundRect( x, y, 50, 50, 5, 5 );
            g2.setColor( Color.black );
            g.drawString( "" + ValueofTile, x + 25 - 3 * length, y + 25 );
        }
    }
    public static void main( String[] args )
    {
        setGUI();
    }

}
