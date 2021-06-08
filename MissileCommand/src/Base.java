
public class Base {
    private boolean alive;

    public Base () {
        this.alive = true;
    }

    public boolean isAlive () {
        return this.alive;
    }

    public void destroyed () {
        this.alive = false;
    }

    public void reset () {
        this.alive = true;
    }
}
