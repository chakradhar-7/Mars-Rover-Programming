# Mars-Rover-Programming

Problem Statement
Create a simulation for a Mars Rover that can navigate a grid-based terrain. Your Rover should be able to move forward, turn left, and turn right. You'll need to make sure that it avoids obstacles and stays within the boundaries of the grid. Remember to use pure Object-Oriented Programming, design patterns, and avoid using if-else conditional constructs.
Functional Requirements
  1. Initialize the Rover with a starting position (x, y) and direction (N, S, E, W).
  2. Implement the following commands:
    'M' for moving one step forward in the direction the rover is facing
    'L' for turning left
    'R' for turning right
  3. Implement obstacle detection. If an obstacle is detected in the path, the Rover should not move.
  4. Optional: Add functionality for the Rover to send a status report containing its current position and facing direction.
Key Focus
  1. Behavioral Pattern: Use the Command Pattern to encapsulate 'M', 'L', 'R' as objects for flexibility.
  2. Structural Pattern: Use the Composite Pattern to represent the grid and obstacles.
  3. OOP: Leverage encapsulation, inheritance, and polymorphism.
Possible Inputs
  Grid Size: (10 x 10)
  Starting Position: (0, 0, N)
  Commands: ['M', 'M', 'R', 'M', 'L', 'M']
  Obstacles: [(2, 2), (3, 5)]
Possible Outputs
  Final Position: (1, 3, N)
  Status Report: "Rover is at (1, 3) facing North. No Obstacles detected."
By
  Name: Kotha Chakrahar
  Reg No. BL.EN.U4CSE20081
