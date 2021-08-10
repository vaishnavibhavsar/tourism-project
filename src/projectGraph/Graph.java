package projectGraph;

import java.util.*;
import java.io.*;

class Graph {

	InputStreamReader in = new InputStreamReader(System.in);
	BufferedReader buf = new BufferedReader(in);

	public Map<String, List<ConnectingSpot>> graph = new HashMap<>(); // An object of HashMap class to store source name
																		// and its corresponding adjacency list

	/*------------- Function to add edges into the graph by taking source name and destination node as parameters -------------*/

	/*------------- Function to Add a vertex to the Map -------------*/
	public void addVertex(String vertex) {
		graph.put(vertex, new LinkedList<ConnectingSpot>());
	}
	/*------------- END OF addVertex FUNCTION -------------*/
	

	public void addEdge(String source, ConnectingSpot dest) {
		// If the entered source is not a part of the current graph
		if (!graph.containsKey(source)) {
			addVertex(source); // adding this source as a new vertex in the graph
		}
		// If the entered destination is not a part of the current graph
		if (!graph.containsKey(dest.destination)) {
			addVertex(dest.destination); // adding this destination as a new vertex in the graph
		}
		// Once it is made sure that vertices between whom the edge is desired are
		// present in the graph, finishing the task by adding edges
		graph.get(source).add(dest);
		graph.get(dest.destination).add(new ConnectingSpot(source, dest.km)); // Two way edges for undirected graph
	}
	/*------------- END OF addEdge FUNCTION -------------*/
	

	
	/*------------- Function to Traverse Graph using Breadth First Search by taking Hashmap and source as parameters -------------*/
	public ArrayList<String> bfs(String spot_source) {
		boolean visited[] = new boolean[graph.size()]; // visited array to store status of each vertex during traversal
														// hence size is same as graph
		LinkedList<String> queue = new LinkedList<String>(); // queue of type LinkedList to store all neighbours of a
																// visted vertex
		LinkedList<String> spots = new LinkedList<String>(); // Linked List of type String to store names of all spots
		ArrayList<String> BFS_sequence = new ArrayList<String>(); // ArrayList to store the bfs traversal
		// Adding all spot names from the recieved graph into the String type Linked
		// List
		for (String spot : graph.keySet())
			spots.add(spot); // adding spots to a list helps map each name to an index which can be used
								// later
		// 'spots' Linked List & 'visited' array will have same size which then enables
		// us to set a vertex as visited in the array using spot name
		// setting the source received as visited in the boolean array
		// first extracting index of spot from linked list using indexOf and then using
		// the same to set visited flag for a specific location
		visited[spots.indexOf(spot_source)] = true;
		queue.add(spot_source); // adding first source to queue from where the BFS Traversal Begins

		// while queue is not empty loop must go on
		while (queue.size() != 0) {
			spot_source = queue.remove(); // removing top element from queue
			BFS_sequence.add(spot_source);
			// System.out.print("\n"+spot_source); //printing the top element
			// for loop to traverse all the connecting nodes in the graph for a given source
			for (ConnectingSpot dest_spots : graph.get(spot_source)) {
				// if this neighbour of the current source is not visited
				if (!visited[spots.indexOf(dest_spots.destination)]) {
					visited[spots.indexOf(dest_spots.destination)] = true; // marking as visited
					queue.add(dest_spots.destination); // adding to queue
				}
			} // inner for ends here
		} // while ends here
		return BFS_sequence;
	}
	/*------------- END OF bfs FUNCTION -------------*/
	

	/*------------- Function to Implement the Dijkstra's Algorithm & Display the shortest path from current source -------------*/
	public void dijkastra(String spot_source, int flag) throws IOException {	//Spot parameter gives the location from which shortest path to spots is to be found
		
		ConnectingSpot distance[] = new ConnectingSpot[10];	//it will contain the final shortest distances to all the other spots 
		ArrayList<String> allSpots = new ArrayList<String>();	//allSpots array will contain the list of all the spots in the graph of the city selected
		for (String spot : graph.keySet()) {//adding all the spots to the allSpots array
			String s = spot;
			allSpots.add(s);
		}//for ends here

		ArrayList<String> settled = new ArrayList<String>();	//settled array to keep note of which spots minimum distance is already obtained
		/*
		 * Priority queue helps us to arrange all the distances in ascending order
		 * Therefore used to get minimum distance spot at a point of time
		 * and make it settled*/
		PriorityQueue<ConnectingSpot> queue = new PriorityQueue<>(10, new DistanceComparator());

		for (int i = 0; i < 10; i++)	//initially making all the distance from spot_souce to infinity
			distance[i] = new ConnectingSpot("", Integer.MAX_VALUE);

		queue.add(new ConnectingSpot(spot_source, 0));	//adding source to queue 
		distance[allSpots.indexOf(spot_source)].km = 0;	//setting distance of spot_source from itself to zero

		while (settled.size() != 10) {	//loop till all the spots are settled ,i.e.till minimum distance to all other spots from spot_source is obtained
			String name = queue.remove().destination;//removing the starting of the queue as the distance will be minimum
			settled.add(name);	//and adding it to settled list

			double newDistance = -1; //to calculate the new distance of all the unsettled spots from name spot

			for (ConnectingSpot node : graph.get(name)) { //getting all the connected spots with there respective distances 
				ConnectingSpot v = node;

				//checking if v node is already settled 
				if (!settled.contains(v.destination)) {	//if not settled
					
					newDistance = v.km + distance[allSpots.indexOf(name)].km; //calculating new distance of the connected node

					if (newDistance < distance[allSpots.indexOf(v.destination)].km)	//if new calculated distance is less than its already present distance 
						//if yes then updating the distance array and adding the spot to queue
						distance[allSpots.indexOf(v.destination)].km = newDistance;
					queue.add(new ConnectingSpot(v.destination, distance[allSpots.indexOf(v.destination)].km));
				}//if ends here
			}//for ends here
		}//while ends here
		if (flag == 0) 	//if flag=0 displaying minimum distance of all spots from current location
		{
			System.out.println("\n\n");
			for (int i = 0; i < 10; i++) {
				if (distance[i].km != 0) {
					System.out.println("-------|-------------------------------------------------------------|-------");
					System.out.println("          " + allSpots.get(i) + " = " + distance[i].km + "km");

				}//if ends here
			}//for ends here
			System.out.println("-------|-------------------------------------------------------------|-------");

		}//outer if ends here
		else {		//else flag=1 displaying minimum distance of all spots from current location within a particular radius
			System.out.println("\n--->Enter the radius within which you want to see all the places in kms");
			double radius = Double.parseDouble(buf.readLine());	//accepting the radius within which the user wants to search places
			int check = 0;	//check to keep not of whether any spots are present within the given radius
			System.out.println("\n\n");
			System.out.println("-------|-------------------------------------------------------------|-------");
			for (int i = 0; i < 10; i++) {

				if (distance[i].km <= radius && distance[i].km != 0) {

					System.out.println("          " + allSpots.get(i) + " = " + distance[i].km + "km");
					check++;
					System.out.println("-------|-------------------------------------------------------------|-------");
				}

			}
			if (check == 0)	//if no spots are present in given radius then displaying valid message
				System.out.println("\n\tSORRY!!!! There are no spots within the radius of " + radius + " km");

		}
	}

	/*------------- END OF dijkstra FUNCTION -------------*/

	/*------------- Function to Implement the Prim's Algorithm & Calculate the minimum Spanning tree along with minimum cost -------------*/
	double MST_ByPrims(String source) {
		boolean visited[] = new boolean[graph.size()]; // visited array to store status of each vertex during traversal
														// hence size is same as graph
		ArrayList<String> added_spots = new ArrayList<String>(); // ArrayList to store the spots that have already been
																	// added to the minimum spanning tree
		Queue<ConnectingSpot> mst_queue = new PriorityQueue<>(graph.size(), new DistanceComparator()); // Priority Queue
																										// to store the
																										// edges in
																										// ascending
																										// order
		mst_queue.add(new ConnectingSpot(source, 0.0f)); // adding the source in priority queue
		LinkedList<String> spots = new LinkedList<String>(); // Linked List of type String to store names of all spots
		for (String spot : graph.keySet())
			spots.add(spot);
		// 'spots' Linked List & 'visited' array will have same size which then enables
		// us to set a vertex as visited in the array using spot name
		// setting the source received as visited in the boolean array
		// first extracting index of spot from linked list using indexOf and then using
		// the same to set visited flag for a specific location
		visited[spots.indexOf(source)] = true;
		double mincost = 0, totalcost = 0; // variables to store minimum edge cost and total cost
		String s = source; // initialising variable to store varying sources in the loop
		added_spots.add(s); // adding visited spot to edge
		visited[spots.indexOf(s)] = true; // marking as visited
		// while all vertices have not been added to the arraylist this loop must go on
		while (added_spots.size() != graph.size()) {
			// If queue is not empty then performing operations - Avoiding Null Pointer
			// exception here
			if (!mst_queue.isEmpty()) {
				mincost = mst_queue.peek().km; // updating cost of minimum edge
				s = mst_queue.remove().destination; // updating new source that carries this minimum edge while also
													// removing it from queue
				// Now adding all edges connected to this source into the priority queue
				for (ConnectingSpot next_s : graph.get(s)) {
					// If a particular location has not yet been traversed then adding its edge from
					// current source
					if (!visited[spots.indexOf(next_s.destination)])
						mst_queue.add(next_s);
				}
				// If this particular source is not present in array list
				if (!added_spots.contains(s)) {
					added_spots.add(s); // updating arrayList
					totalcost += mincost; // adding cost of selected minimum edge to final cost
					visited[spots.indexOf(s)] = true; // marking this location as visited
				}
			}
		}

		return totalcost; // returning final cost of minimum spanning tree
																				

	}
	//------------- END OF MST_ByPrims FUNCTION -------------

	//function to check if a particular spot exists in the graph
	public boolean checkIfExists(String find) {
		return graph.containsKey(find);	//if yes then returning true else false
	}
	//checkIfExists Function ends here
	
	
	public void shortCutDisplayer(String cityName, int flag) throws IOException { 
		ClearScreen clear = new ClearScreen();	//object to clear the screen
		clear.clearScreen();	//clearScreen Function is called
		String currentLoc = null;	
		System.out
				.println("\n<:><:><:><:><:><:><:><:><:><:><:><:><:><:><:><:> THE FOLLOWING IS THE LIST OF ALL SPOTS IN "
						+ cityName + " <:><:><:><:><:><:><:><:><:><:><:><:><:><:><:><:><:><:>\n");
		for (String spots : graph.keySet())//traversing through all the spots in the particular city and displaying them for user reference

		{
			System.out.println("-------|-------------------------------------------------------------|-------");
			System.out.println("                         ---> " + spots);

		}
		System.out.println("-------|-------------------------------------------------------------|-------");
		System.out.println("\n --->  Out of the above locations enter your location\n");
		do {//accepting the current location from the user
			currentLoc = (buf.readLine()).toUpperCase();	//converting into upper case so that user doesn't have to worry about the case
			if (!checkIfExists(currentLoc))	//checking if entered location is present in the graph 
				System.out.println("\n --->  Entered Location is INVALID !!! Kindly re-enter correct spot name.\n");	//if not displaying valid message
		} while (!checkIfExists(currentLoc));//looping till user enters valid location
		dijkastra(currentLoc, flag);	//calling dijkastra function to get the shortest distance
		char exit;
		System.out.println("\n\n---------------------------------------------------------------------------------");
		System.out.println("Enter X to return to guide sub menu");	//accepting exit input from user
		do {
			exit = (char) buf.read();
			buf.readLine();
			if (exit != 'X')
				System.out.println("!!!!!!!!!! INVALID INPUT !!!!!!!!!");
		} while (exit != 'X');//looping till user enters valid input
	}
	//shortCutDisplayer Function ends here

}
/* ______________________________GRAPH CLASS ENDS HERE______________________________
 */
