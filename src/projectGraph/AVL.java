package projectGraph;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class AVL {
	Spot root; // reference of class Spot

	public AVL() // default constructor
	{
		root = null; // initializing root to null
	}

	// calculate height of tree
	int height(Spot root) {
		if (root == null) // if tree is empty return 0
		{
			return 0;
		}
		int lh = 0, rh = 0; // lh=left height , rh=right height initializing it to 0
		if (root.lc != null) // if left child of root is not null
		{
			lh = 1 + root.lc.h; // calculate left height
		}
		if (root.rc != null) // if right child of root is not null
		{
			rh = 1 + root.rc.h; // calculate right height
		}
		return lh > rh ? lh : rh; // return height
	}

	// calculate balance factor of each node in tree
	int balanceFactor(Spot root) {
		if (root == null) // if tree is empty return 0
		{
			return 0;
		}
		int lh = 0, rh = 0; // lh=left height , rh=right height initializing it to 0
		if (root.lc != null) // if left child of root is not null
		{
			lh = 1 + height(root.lc); // calculate left height
		}
		if (root.rc != null) // if right child of root is not null
		{
			rh = 1 + height(root.rc); // calculate left height
		}
		int bf = lh - rh; // balance factor=left height - right height
		return bf; // return value of balance factor

	}

	Spot LL(Spot root) {
		// System.out.println("LL");
		Spot temp = root.lc; // storing the left of root in temp variable
		root.lc = temp.rc; // for intermediate node
		temp.rc = root; // assigning the root to temp's right
		temp.h = height(temp); // storing heights of temp
		root.h = height(root); // storing heights of root
		return temp; // returning the updated temp
	}// LL function close

	Spot RR(Spot root) {
		// System.out.println("RR");
		Spot temp = root.rc; // storing the right of root in temp variable
		root.rc = temp.lc; // for intermediate node
		temp.lc = root; // assigning the root to temp's right
		temp.h = height(temp); // storing heights of temp
		root.h = height(root); // storing heights of root
		return temp; // returning the updated temp
	}// RR function close

	Spot LR(Spot root) {
		// System.out.println("LR");
		root.lc = RR(root.lc); // right rotation from roots child
		root = LL(root); // left rotation from root
		return root; // returning the updated root
	}// LR function close

	Spot RL(Spot root) {
		// System.out.println("RL");
		root.rc = LL(root.rc); // left rotation from roots child
		root = RR(root); // right rotation from root
		return root; // returning the updated ptr
	}// RL function close

	// inserts new node of type Spot in the AVL tree
	Spot insert(Spot root, Spot temp) {
		int bal; // balance factor
		if (root == null) { // if tree is empty return the temp node
			return temp;
		}
		if (temp.spotName.compareToIgnoreCase(root.spotName) == 0) // validating if there is a duplicate spot for same
																	// city
		{
			if (temp.cityName.compareToIgnoreCase(root.cityName) == 0) {
				System.out.println("Spot Name already exists in the city");
				return root;
			}
		}
		if (temp.spotName.compareToIgnoreCase(root.spotName) < 0) // if spotName of temp node is less than spotName of
																	// root node (alphabetically)
		{
			root.lc = insert(root.lc, temp); // call to insert function and collect the root in root.lc
			bal = balanceFactor(root); // call to balance factor function and collect balance factor in bf
			if (bal == 2 || bal == -2) // check if balance factor is either 2 or -2
			{
				// check if spotName of temp is less than spotName of leftChild of
				// root(alphabetically)
				if (temp.spotName.compareToIgnoreCase(root.lc.spotName) < 0) {
					root = LL(root); // if true ; call to LL rotation function

				} else {
					root = LR(root); // if false; call to LR rotate function
				}
			}
		} else // if spotName of temp node is greater than spotName of root node
				// (alphabetically)
		{
			root.rc = insert(root.rc, temp); // call to insert function and collect the root in root.rc
			bal = balanceFactor(root); // call to balance factor function and collect balance factor in bf
			if (bal == 2 || bal == -2) // check if balance factor is either 2 or -2
			{
				if (temp.spotName.compareToIgnoreCase(root.rc.spotName) > 0) {
					root = RR(root); // if true ; call to RR rotation function

				} else {
					root = RL(root); // if false ; call to RL rotation function

				}
			}
		}
		root.h = height(root); // call to height function and height is collected in root.h

		return root; // return root
	}

	// Creates the AVL tree
	public void create() {

		Spot temp; // reference of class Spot
		// chennai spots
		// allocating memory to temp node by passing values of spotName,cityName,name of
		// file
		temp = new Spot("Marina Beach", "Chennai", "MarinaBeach"); // 1
		root = insert(root, temp); // call to insert function to add the node temp
		temp = new Spot("Valluvar Kottam", "Chennai", "ValluvarKottam"); // 2
		root = insert(root, temp);
		temp = new Spot("Thousand's Light Mosque", "Chennai", "ThousandsLightMosque");// 3
		root = insert(root, temp);
		temp = new Spot("Elliot's Beach", "Chennai", "ElliotsBeach"); // 4
		root = insert(root, temp);
		temp = new Spot("DakshinaChitra ", "Chennai", "DakshinaChitra"); // 5
		root = insert(root, temp);
		temp = new Spot("Ashtalakshmi Temple", "Chennai", "AshtalakshmiTemple"); // 6
		root = insert(root, temp);
		temp = new Spot("Government Meuseum", "Chennai", "GovernmentMeuseum"); // 7
		root = insert(root, temp);
		temp = new Spot("Guindy National Park", "Chennai", "GuindyNationalPark");// 8
		root = insert(root, temp);
		temp = new Spot("MGR Film City", "Chennai", "MGRFilmCity"); // 9
		root = insert(root, temp);
		temp = new Spot("Mylapore", "Chennai", "Mylapore"); // 10
		root = insert(root, temp);

		// delhi spots
		temp = new Spot("Red Fort", "Delhi", "RedFort"); // 1
		root = insert(root, temp);
		temp = new Spot("Gandhi Smriti & Mahatma Gandhi Memorial", "Delhi", "GandhiSmriti"); // 2
		root = insert(root, temp);
		temp = new Spot("Agrasen Ki Baoli", "Delhi", "Agrasen"); // 3
		root = insert(root, temp);
		temp = new Spot("Gurudwara Bangla Sahib", "Delhi", "Gurudwara");// 4
		root = insert(root, temp);
		temp = new Spot("National Meuseum", "Delhi", "NationalMeuseum"); // 5
		root = insert(root, temp);
		temp = new Spot("India Gate", "Delhi", "IndiaGate"); // 6
		root = insert(root, temp);
		temp = new Spot("Dilli Haat INA", "Delhi", "DilliHaat"); // 7
		root = insert(root, temp);
		temp = new Spot("Qutub Minar", "Delhi", "QutubMinar");// 8
		root = insert(root, temp);
		temp = new Spot("Humayun's Tomb", "Delhi", "HumayunTomb"); // 9
		root = insert(root, temp);
		temp = new Spot("Akshardham Mandir", "Delhi", "Akshardham"); // 10
		root = insert(root, temp);

		// Mumbai
		temp = new Spot("Film City", "Mumbai", "FilmCity"); // 1
		root = insert(root, temp);
		temp = new Spot("Juhu Beach", "Mumbai", "JuhuBeach");// 2
		root = insert(root, temp);
		temp = new Spot("Chowpatty Beach", "Mumbai", "ChowpattyBeach");// 3
		root = insert(root, temp);
		temp = new Spot("Marine Drive", "Mumbai", "MarineDrive"); // 4
		root = insert(root, temp);
		temp = new Spot("The Gateway Of India", "Mumbai", "TheGatewayOfIndia");// 5
		root = insert(root, temp);
		temp = new Spot("Mumba Devi temple", "Mumbai", "MumbaDevitemple");// 6
		root = insert(root, temp);
		temp = new Spot("Siddhivinayak temple", "Mumbai", "Siddhivinayaktemple");// 7
		root = insert(root, temp);
		temp = new Spot("Elephanta Caves", "Mumbai", "ElephantaCaves");// 8
		root = insert(root, temp);
		temp = new Spot("Chhatrapati Shivaji Maharaj Vaastu Museum", "Mumbai", "MaharajMuseum");// 9
		root = insert(root, temp);
		temp = new Spot("Jehangir Art Gallery", "Mumbai", "JehangirArtGallery");// 10
		root = insert(root, temp);

		// Kolkata
		temp = new Spot("Victoria Memorial Hall", "Kolkata", "VictoriaMemorial");// 1
		root = insert(root, temp);
		temp = new Spot("Birla Mandir", "Kolkata", "BirlaMandir");// 2
		root = insert(root, temp);
		temp = new Spot("Science City", "Kolkata", "ScienceCity");// 3
		root = insert(root, temp);
		temp = new Spot("Belur Math", "Kolkata", "BelurMath");// 4
		root = insert(root, temp);
		temp = new Spot("St. Paul's Cathedral", "Kolkata", "StPaul");// 5
		root = insert(root, temp);
		temp = new Spot("Jorasanko Thakurbari", "Kolkata", "Joransanko");// 6
		root = insert(root, temp);
		temp = new Spot("Dakshineswar Kali Temple", "Kolkata", "DKali");// 7
		root = insert(root, temp);
		temp = new Spot("Howrah Bridge", "Kolkata", "Howrah");// 8
		root = insert(root, temp);
		temp = new Spot("Indian Museum", "Kolkata", "IndianMuseum");// 9
		root = insert(root, temp);
		temp = new Spot("Kalighat Kali Temple", "Kolkata", "Kalighat");// 10
		root = insert(root, temp);

	}

	void inOrder(Spot root) // inorder recursive traversal
	{

		if (root != null) {
			inOrder(root.lc);
			System.out.println("City Name: " + root.cityName + " Spot: " + root.spotName);
			inOrder(root.rc);
		}
	}

	// function to search a particular spot by its spotName and display its details
	public Spot searchSpot(String spotName) {
		Spot ptr = root; // ptr object of class Spot initialized to root
		while (ptr != null) // traverse till ptr is not null
		{
			if (ptr.spotName.compareToIgnoreCase(spotName) == 0) // if entered spotName is equal to the spotName in tree
			{
				break; // then break the loop
			}
			ptr = ptr.spotName.compareToIgnoreCase(spotName) < 0 ? ptr.rc : ptr.lc; // check if spotName of ptr is less
																					// than entered spotName and
																					// increment ptr accordingly
		}
		return ptr; // return the pointer
	}

	public void searchCity(String cityName, Spot root) throws IOException // if file not found will throw ioexception
	{
		if (root == null) // if root is null
		{
			return;
		} // if end
			// int flag=0;
		int count; // count to read specific number of lines
		if (root != null) // if root is not null
		{
			searchCity(cityName, root.lc); // calling recursively
			if (root.cityName.compareToIgnoreCase(cityName) == 0) // if city name is same
			{
				count = 6;
				try {
					File file = new File("E:\\SpotHistory\\" + root.info + ".txt"); // file object represents the file
																					// path on disk
					BufferedReader br = new BufferedReader(new FileReader(file)); // read the object of file from disk

					String st; // to store the one by one line
					while ((st = br.readLine()) != null && count != 0) {
						System.out.println(st); // printing linewise
						count--;
					} // while end
					System.out.println(
							"\n_______________________________________________________________________________________________________________________________________________________________\n");
				} catch (FileNotFoundException e) // if exception occured
				{
					System.out.println("File Not Found");
				}

			} // inner if end
			searchCity(cityName, root.rc);
		} // outer if end
	}// function e

}
