# Mars Rover Programming Simulation

## Problem Statement
Create a simulation for a Mars Rover that can navigate a grid-based terrain. The Rover should be capable of moving forward, turning left, and turning right while avoiding obstacles and staying within the boundaries of the grid. The implementation should adhere to pure Object-Oriented Programming principles, design patterns, and avoid the use of if-else conditional constructs.

## Functional Requirements
1. Initialize the Rover with a starting position (x, y) and direction (N, S, E, W).
2. Implement the following commands:
    - 'M' for moving one step forward in the direction the rover is facing.
    - 'L' for turning left.
    - 'R' for turning right.
3. Implement obstacle detection. If an obstacle is detected in the path, the Rover should not move.
4. Optional: Add functionality for the Rover to send a status report containing its current position and facing direction.

## Key Focus
1. **Behavioral Pattern:** Use the Command Pattern to encapsulate 'M', 'L', 'R' as objects for flexibility.
2. **Structural Pattern:** Use the Composite Pattern to represent the grid and obstacles.
3. **OOP:** Leverage encapsulation, inheritance, and polymorphism.

## Usage
Download the file and run MarsRoverSimulation.java

## Input
1.Grid Size: (10 x 10)
2.Starting Position: (0, 0, N)
3.Commands: ['M', 'M', 'R', 'M', 'L', 'M']
4. Obstacles: [(2, 2), (3, 5)]

## Output
1.Final Position: (1, 3, N)
2.Status Report: "Rover is at (1, 3) facing North. No obstacles detected."

## Author
KOTHA CHAKRADHAR
BL.EN.U4CSE20081
