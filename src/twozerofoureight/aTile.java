package twozerofoureight;

import java.awt.Color;
public class aTile
{
    int val;
    Color colorofTile;
    public aTile()
    {
        val = 0;
    }

    public aTile( int number )
    {
        val = number;
    }

    public int getValue()
    {
        return val;
    }

    public void setValue( int value )
    {
        this.val = value;
    }

    public String toString()
    {
        return "" + val;
    }
    public void setColor()
    {
        if ( this.getValue() == 2 )
        {
            colorofTile = new Color( 238, 228, 218 );
        }
        else if ( this.getValue() == 4 )
        {
            colorofTile = new Color( 237, 224, 200 );
        }
        else if ( this.getValue() == 8 )
        {
            colorofTile = new Color( 242, 177, 121 );
        }
        else if ( this.getValue() == 16 )
        {
            colorofTile = new Color( 245, 149, 99 );
        }
        else if ( this.getValue() == 32 )
        {
            colorofTile = new Color( 246, 124, 95 );
        }
        else if ( this.getValue() == 64 )
        {
            colorofTile = new Color( 246, 94, 59 );
        }
        else if ( this.getValue() == 128 )
        {
            colorofTile = new Color( 237, 207, 114 );
        }
        else if ( this.getValue() == 256 )
        {
            colorofTile = new Color( 237, 204, 97 );
        }
        else if ( this.getValue() == 512 )
        {
            colorofTile = new Color( 237, 200, 80 );
        }
        else if ( this.getValue() == 1024 )
        {
            colorofTile = new Color( 237, 197, 63 );
        }
        else
        {
            colorofTile = new Color( 237, 194, 46 );
        }
    }
    public Color getColor()
    {
        this.setColor();
        return colorofTile;
    }
}