package mmm;

public class Obstacle implements GridComponent {
	private int x;
    private int y;

    public Obstacle(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void display() {
        System.out.println("Obstacle at (" + x + ", " + y + ")");
    }

}
