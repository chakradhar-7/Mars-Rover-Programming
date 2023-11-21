package mmm;
import java.util.*;
import java.util.Scanner;
import java.util.function.Supplier;
import java.util.ArrayList;
import java.util.List;
public class MarsRoverSimulation {
	public static void main(String[] args) {
		try(Scanner scanner = new Scanner(System.in)) {

        System.out.print("Enter grid size (format: rows columns): ");
        int rows = scanner.nextInt();
        int columns = scanner.nextInt();
        

        System.out.print("Enter starting position (format: x y direction): ");
        int startX = scanner.nextInt();
        int startY = scanner.nextInt();
        char startDirection = scanner.next().charAt(0);
        if (!isValidStartingPosition(startX, startY, rows, columns)) {
            throw new InvalidPositionException("Invalid starting position. Exiting program.");

        }
        System.out.print("Enter the number of obstacles: ");
        int obstacleCount = scanner.nextInt();
        List<Obstacle> obstacles = new ArrayList<>();
        for (int i = 0; i < obstacleCount; i++) {
            System.out.print("Enter obstacle position " + (i + 1) + " (format: x y): ");
            int obstacleX = scanner.nextInt();
            int obstacleY = scanner.nextInt();
            if (!isValidPosition(obstacleX, obstacleY, rows, columns)) {
                throw new InvalidPositionException("Invalid obstacle position. Exiting program.");

            }
            obstacles.add(new Obstacle(obstacleX, obstacleY));
        }
        Map<Character, Supplier<RoverCommand>> commandMap = new HashMap<>();
        commandMap.put('M', MoveCommand::new);
        commandMap.put('R', TurnRightCommand::new);
        commandMap.put('L', TurnLeftCommand::new);

        // Input commands
        System.out.print("Enter commands (format: M, R, L): ");
        String commandString = scanner.next();
        List<RoverCommand> commands = new ArrayList<>();

        for (char command : commandString.toCharArray()) {
            commands.add(commandMap.getOrDefault(command, () -> {
                throw new IllegalArgumentException("Invalid command: " + command);
            }).get());
        }
/*
        System.out.print("Enter commands (format: M, R, L): ");
        String commandString = scanner.next();
        List<RoverCommand> commands = new ArrayList<>();
        for (char command : commandString.toCharArray()) {
            switch (command) {
                case 'M':
                    commands.add(new MoveCommand());
                    break;
                case 'R':
                    commands.add(new TurnRightCommand());
                    break;
                case 'L':
                    commands.add(new TurnLeftCommand());
                    break;
                default:
                    throw new IllegalArgumentException("Invalid command: " + command);

            }
        }
*/

        Rover rover = new Rover(startX, startY, startDirection, rows, columns, obstacles);


        for (RoverCommand command : commands) {
            command.execute(rover);
        }

        System.out.println("Final Position: (" + rover.getX() + ", " + rover.getY() + ", " + rover.getDirection() + ")");
        System.out.println(rover.getStatusReport());
    }
		catch (InvalidPositionException  e) {
            System.out.println(e.getMessage());}
		}
	private static boolean isValidStartingPosition(int x, int y, int rows, int columns) {
        return isValidPosition(x, y, rows, columns);
    }

    private static boolean isValidPosition(int x, int y, int rows, int columns) {
        return x >= 0 && x < columns && y >= 0 && y < rows;
    }

}
