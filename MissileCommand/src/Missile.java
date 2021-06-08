
public abstract class Missile {
    double originX;
    double originY;
    double velocityMag;
    double destinationX;
    double destinationY;
    double currentX;
    double currentY;

    public Missile ( final int x, final int y ) {
        this.destinationX = x;
        this.destinationY = y;
    }

    public abstract void interval ();
}
