import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JPanel;
import javax.swing.Timer;

@SuppressWarnings ( "serial" )
public class Graphics extends JPanel implements ActionListener {

    Timer      timer = new Timer( 10, this );
    GameState  state = null;
    Graphics2D g2d   = null;

    public Graphics ( final GameState state ) {
        timer.start();
        this.state = state;
    }

    @Override
    public void paintComponent ( final java.awt.Graphics g ) {
        super.paintComponent( g );
        this.setBackground( new Color( 0, 0, 0 ) );

        this.g2d = (Graphics2D) g;
        g2d.setColor( Color.YELLOW );
        g2d.fillRect( 0, 690, 840, 150 );

        for ( int i = 0; i < state.getBases().size(); i++ ) {
            if ( state.getBases().get( i ).isAlive() ) {
                if ( i < 3 ) {
                    g2d.setColor( Color.BLUE );
                    g2d.fillOval( 50 + ( 130 * i ), 725, 15, 15 );
                }
                else {
                    g2d.setColor( Color.BLUE );
                    g2d.fillOval( 790 - ( 130 * ( i - 3 ) ), 725, 15, 15 );
                }

            }

        }

        if ( state.getMb().isAlive() ) {
            g2d.setColor( Color.cyan );
            g2d.fillRect( 420, 715, 15, 45 );
        }

        for ( int i = 0; i < state.getPlayerMissiles().size(); i++ ) {
            final PlayerMissile pm = (PlayerMissile) state.getPlayerMissiles().get( i );
            if ( pm.atDestination ) {
                if ( pm.explosionFrames % 2 == 0 && pm.explosionFrames % 20 == 0 ) {
                    g2d.setColor( Color.RED );
                }
                else {
                    g2d.setColor( Color.ORANGE );
                }
                if ( pm.frameBuffer != 0 ) {
                    g2d.fillOval( (int) state.getPlayerMissiles().get( i ).currentX - ( ( 60 - pm.frameBuffer ) / 2 ),
                            (int) state.getPlayerMissiles().get( i ).currentY - ( ( 60 - pm.frameBuffer ) / 2 ),
                            60 - pm.frameBuffer, 60 - pm.frameBuffer );
                }
                else {
                    g2d.fillOval( (int) state.getPlayerMissiles().get( i ).currentX - ( pm.explosionFrames / 2 ),
                            (int) state.getPlayerMissiles().get( i ).currentY - ( pm.explosionFrames / 2 ),
                            pm.explosionFrames, pm.explosionFrames );
                }

            }
            else {
                g2d.setColor( Color.WHITE );
                g2d.fillOval( (int) state.getPlayerMissiles().get( i ).currentX - 5,
                        (int) state.getPlayerMissiles().get( i ).currentY - 5, 5, 5 );
            }

        }
    }

    @Override
    public void actionPerformed ( final ActionEvent e ) {
        state.interval();
        repaint();
    }

}
