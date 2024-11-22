# Campus Map Navigation Program

This project is a **Java-based navigation system** for a school campus, designed using **Swing** for GUI and implementing **Dijkstra's Algorithm** to find and display the shortest path between two nodes on the campus map.

## Features
- Interactive campus map visualization.
- Visualization of edges, nodes, and regions on the map.
- Shortest path calculation using Dijkstra's Algorithm.
- Highlights shortest path with **bold blue lines**.
- Displays alternative paths using custom "Mudang" edges (special paths with unique weights).

## Requirements
- Java 8 or higher
- Swing library (default in Java SE)
- An IDE or compiler supporting Java projects (e.g., IntelliJ IDEA, Eclipse)

## How to Run
1. Clone this repository:
   ```bash
   git clone https://github.com/0catt0/Algo_Navigation/edit/main/README.md
2. Open the project in your preferred IDE.
3. Compile and run the Map class:
   ```bash
   javac Map.java
   java Map
4. The program will display an interactive map with the shortest path highlighted.

Implementation Details

Classes and Functionality
Node
Represents a location on the campus map.
Attributes:
name: The name of the location (e.g., "Library").
x, y: The coordinates on the map.
Edge
Represents a regular path between two nodes.
Attributes:
from: Starting node.
to: Ending node.
cost: Weight of the edge (distance or time).
Mudang
Represents a special path (custom logic for unique pathways).
Attributes:
from: Starting node.
to: Ending node.
cost: Weight of the edge.
Dijkstra
Implements the shortest path algorithm.
Returns a list of edges and mudang paths comprising the shortest route.
Map
Main class to initialize the program and GUI.
Visualizes nodes, edges, and shortest paths.
MapPanel
A JPanel extension for rendering the map and its components.
Highlights shortest paths and mudang paths with appropriate colors.
Visualization
Nodes: Red circles with labels.
Edges: Curved lines connecting nodes.
Special Paths (Mudang): Red lines.
Shortest Path: Bold blue lines.
Sample Input

The program includes pre-defined nodes and edges representing a sample campus map. To customize:

Modify the nodes, edges, and mudang lists in the main method of the Map class.
Example Campus Map Nodes
Node Name	X Coordinate	Y Coordinate
Main Gate	700	720
Engineering 2	850	590
Library	470	220
Stadium	150	100
Example Edges
From	To	Cost
Main Gate	Engineering 2	1
Library	Stadium	2
Example Mudang Paths
From	To	Cost
Main Gate	Library	2
Library	Stadium	1
Screenshot


Example of the campus map visualization with the shortest path highlighted in blue.

Future Enhancements

Add functionality to dynamically select start and end points via the GUI.
Include real-time path updates based on user-defined weights.
Support for additional algorithms like A* for pathfinding.
License

This project is licensed under the MIT License. See the LICENSE file for details.

Contributing

Contributions are welcome! Feel free to open issues or submit pull requests.
   


   
