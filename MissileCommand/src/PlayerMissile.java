
public class PlayerMissile extends Missile {

    double  acceleration    = 0.1;
    int     explosionFrames = 60;
    int     frameBuffer     = 60;
    boolean deleteMissile   = false;
    boolean atDestination   = false;

    public PlayerMissile ( final int x, final int y ) {
        super( x, y );
        this.velocityMag = 2;
        this.originX = 420;
        this.originY = 715;
        this.currentX = this.originX;
        this.currentY = this.originY;
    }

    @Override
    public void interval () {
        final double toDestinationX = Math.abs( this.destinationX - this.currentX );
        final double toDestinationY = Math.abs( this.destinationY - this.currentY );

        if ( toDestinationX <= 6 && toDestinationY <= 6 ) {
            this.atDestination = true;
            this.currentX = this.destinationX;
            this.currentY = this.destinationY;
            destinationReached();
        }
        else {
            final double xDif = Math.abs( this.destinationX - this.originX );
            final double yDif = Math.abs( this.destinationY - this.originY );

            if ( xDif == 0 || yDif == 0 ) {
                this.currentY -= this.velocityMag;
            }
            else {
                final double angle = Math.atan( yDif / xDif );

                if ( this.destinationX - this.originX > 0 ) {
                    currentX += this.velocityMag * Math.cos( angle );
                }
                else {
                    currentX -= this.velocityMag * Math.cos( angle );
                }

                currentY -= this.velocityMag * Math.sin( angle );
            }

            this.velocityMag += this.acceleration;
        }
    }

    private void destinationReached () {
        if ( this.frameBuffer == 0 ) {
            if ( this.explosionFrames == 0 ) {
                this.deleteMissile = true;
            }
            else {
                this.explosionFrames--;
            }
        }
        else {
            this.frameBuffer--;
        }

    }

}
