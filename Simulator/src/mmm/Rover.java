package mmm;
import java.util.ArrayList;
import java.util.List;

public class Rover {
    private int x;
    private int y;
    private int rows;
    private int columns;
    private List<Obstacle> obstacles;
    private List<Obstacle> detectedObstacles = new ArrayList<>();
    private int directionIndex;  
    private static final char[] DIRECTIONS = {'N', 'E', 'S', 'W'};
    private static final int[][] MOVEMENTS = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};  
    public Rover(int x, int y, char direction, int rows,int columns, List<Obstacle> obstacles) {
        this.x = x;
        this.y = y;
        this.directionIndex = getDirectionIndex(direction);
        this.rows=rows;
        this.columns=columns;
        this.obstacles = obstacles;
    }
    private boolean isValidPosition(int x, int y) {
        return x >= 0 && x < columns && y >= 0 && y < rows;
    }
    public void move() {
        int newX = x + MOVEMENTS[directionIndex][0];
        int newY = y + MOVEMENTS[directionIndex][1];
        if (!isValidPosition(newX, newY)) {
            throw new InvalidPositionException("Invalid position after moving. Exiting program. Finally rover is at (" + x + ", " + y + ") facing " + getDirection() +". ");
        }
        if (hasObstacle(newX, newY)) {
            detectedObstacles.add(new Obstacle(newX, newY));
        } else {
        	x=newX;
        	y=newY;
        }
    }

   /* public void move() {
        int newX = x;
        int newY = y;

        switch (direction) {
            case 'N':
                newY = Math.min(y + 1, rows - 1);
                break;
            case 'S':
                newY = Math.max(y - 1, 0);
                break;
            case 'E':
                newX = Math.min(x + 1, columns - 1);
                break;
            case 'W':
                newX = Math.max(x - 1, 0);
                break;
        }
        

        if (hasObstacle(newX, newY)) {
            detectedObstacles.add(new Obstacle(newX, newY));
        } 
        if (isValidPosition(newX, newY) && !hasObstacle(newX, newY)) {
            x = newX;
            y = newY;
        }
    }*/

    public boolean hasObstacle(int x, int y) {
        for (Obstacle obstacle : obstacles) {
            if (obstacle.getX() == x && obstacle.getY() == y) {
                System.out.println("Obstacle detected at (" + x + ", " + y + "). Rover cannot move.");
                return true;
            }
        }
        return false;
    }
    public void turnLeft() {
        directionIndex = (directionIndex + 3) % 4;  
    }

    public void turnRight() {
        directionIndex = (directionIndex + 1) % 4; 
    }/*

    public void turnLeft() {
        switch (direction) {
            case 'N':
                direction = 'W';
                break;
            case 'S':
                direction = 'E';
                break;
            case 'E':
                direction = 'N';
                break;
            case 'W':
                direction = 'S';
                break;
        }
    }

    public void turnRight() {
        switch (direction) {
            case 'N':
                direction = 'E';
                break;
            case 'S':
                direction = 'W';
                break;
            case 'E':
                direction = 'S';
                break;
            case 'W':
                direction = 'N';
                break;
        }
    }*/
    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public char getDirection() {
        return DIRECTIONS[directionIndex];
    }
    private int getDirectionIndex(char direction) {
        for (int i = 0; i < DIRECTIONS.length; i++) {
            if (DIRECTIONS[i] == direction) {
                return i;
            }
        }
        throw new IllegalArgumentException("Invalid direction: " + direction);
    }
    public String getStatusReport() {
        StringBuilder report = new StringBuilder("Rover is at (" + x + ", " + y + ") facing " + getDirection() + ". ");

        if (!detectedObstacles.isEmpty()) {
            report.append(" Obstacles detected at: ");
            for (Obstacle obstacle : detectedObstacles) {
                report.append("(").append(obstacle.getX()).append(", ").append(obstacle.getY()).append(") ");
            }
        } else {
            report.append(" No Obstacles detected.");
        }

        return report.toString();
    }
   }
