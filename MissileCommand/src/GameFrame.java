import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JFrame;

public class GameFrame extends JFrame {

    Graphics  graphics = null;
    GameState state    = null;

    public GameFrame ( final GameState state ) {
        this.state = state;
        graphics = new Graphics( state );
        this.setSize( 840, 840 );
        this.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
        this.add( graphics );
        this.setVisible( true );
        graphics.addMouseListener( new MouseListener() {

            @Override
            public void mouseClicked ( final MouseEvent e ) {

            }

            @Override
            public void mousePressed ( final MouseEvent e ) {
                if ( e.getY() < 690 ) {
                    state.getPlayerMissiles().add( new PlayerMissile( e.getX(), e.getY() ) );
                }
            }

            @Override
            public void mouseReleased ( final MouseEvent e ) {

            }

            @Override
            public void mouseEntered ( final MouseEvent e ) {
                // TODO Auto-generated method stub

            }

            @Override
            public void mouseExited ( final MouseEvent e ) {
                // TODO Auto-generated method stub

            }

        } );
    }
}
