
import java.util.ArrayList;
import java.util.LinkedList;

public class GameState {

    private ArrayList<Base>     bases            = null;
    private LinkedList<Missile> incomingMissiles = null;
    private LinkedList<Missile> playerMissiles   = null;
    private LinkedList<Missile> deleteMissiles   = null;
    private MissileBattery      mb               = null;
    private int                 score;
    private int                 level;

    public GameState () {
        this.bases = new ArrayList<Base>();
        this.incomingMissiles = new LinkedList<Missile>();
        this.playerMissiles = new LinkedList<Missile>();
        this.deleteMissiles = new LinkedList<Missile>();
        this.mb = new MissileBattery();

        initialize();
    }

    private void initialize () {
        this.score = 0;
        this.level = 1;
        for ( int i = 0; i < 6; i++ ) {
            bases.add( new Base() );
        }
    }

    public void interval () {
        for ( int i = 0; i < this.deleteMissiles.size(); i++ ) {
            if ( this.deleteMissiles.get( i ) instanceof PlayerMissile ) {
                this.playerMissiles.remove( this.deleteMissiles.get( i ) );
            }
            else {
                this.incomingMissiles.remove( this.deleteMissiles.get( i ) );
            }
        }

        this.deleteMissiles.clear();

        for ( int i = 0; i < this.playerMissiles.size(); i++ ) {
            if ( this.playerMissiles.get( i ).currentX > 845 || this.playerMissiles.get( i ).currentX < -5
                    || this.playerMissiles.get( i ).currentX < -5 ) {
                this.deleteMissiles.add( this.playerMissiles.get( i ) );
            }
            final PlayerMissile pm = (PlayerMissile) this.playerMissiles.get( i );
            if ( pm.deleteMissile ) {
                this.deleteMissiles.add( this.playerMissiles.get( i ) );
            }

            this.playerMissiles.get( i ).interval();
        }
    }

    public void startLevel () {

    }

    public int getScore () {
        return this.score;
    }

    public MissileBattery getMb () {
        return this.mb;
    }

    public ArrayList<Base> getBases () {
        return this.bases;
    }

    public int getLevel () {
        return this.level;
    }

    public LinkedList<Missile> getIncomingMissiles () {
        return incomingMissiles;
    }

    public LinkedList<Missile> getPlayerMissiles () {
        return playerMissiles;
    }

    public LinkedList<Missile> getDeleteMissiles () {
        return deleteMissiles;
    }

}
