package projectGraph;

import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {

		ClearScreen clear = new ClearScreen();

		InputStreamReader in = new InputStreamReader(System.in);
		BufferedReader buf = new BufferedReader(in);

		Scanner sc = new Scanner(System.in);
		AVL a = new AVL(); // creating object of AVL class
		a.create(); // craeting avl tree

		char choice;
		Spot ptr1; // to store address of returing ptr
		String spot; // to store the spot name
		char city; // to store city name

		Graph mumbaiCity = new Graph();
		mumbaiCity.addEdge("FILM CITY", new ConnectingSpot("JUHU BEACH", 13));
		mumbaiCity.addEdge("FILM CITY", new ConnectingSpot("SIDDHIVINAYAK TEMPLE", 18.5));
		mumbaiCity.addEdge("JUHU BEACH", new ConnectingSpot("SIDDHIVINAYAK TEMPLE", 12.2));
		mumbaiCity.addEdge("JUHU BEACH", new ConnectingSpot("CHOWPATTY BEACH", 18.4));
		mumbaiCity.addEdge("CHOWPATTY BEACH", new ConnectingSpot("MUMBADEVI MANDIR", 3));
		mumbaiCity.addEdge("CHOWPATTY BEACH", new ConnectingSpot("JEHANGIR ART GALLERY", 5));
		mumbaiCity.addEdge("CHOWPATTY BEACH", new ConnectingSpot("MARINE DRIVE", 2));
		mumbaiCity.addEdge("MARINE DRIVE", new ConnectingSpot("GATEWAY OF INDIA", 4.4));
		mumbaiCity.addEdge("JEHANGIR ART GALLERY", new ConnectingSpot("CHATTRAPATI SHIVAJI MAHARAJ MUSEUM", 0.45));
		mumbaiCity.addEdge("CHATTRAPATI SHIVAJI MAHARAJ MUSEUM", new ConnectingSpot("MUMBADEVI MANDIR", 4.4));
		mumbaiCity.addEdge("CHATTRAPATI SHIVAJI MAHARAJ MUSEUM", new ConnectingSpot("SIDDHIVINAYAK TEMPLE", 17.3));
		mumbaiCity.addEdge("CHATTRAPATI SHIVAJI MAHARAJ MUSEUM", new ConnectingSpot("ELEPHANTA CAVES", 0.65));
		mumbaiCity.addEdge("CHATTRAPATI SHIVAJI MAHARAJ MUSEUM", new ConnectingSpot("GATEWAY OF INDIA", 0.6));
		mumbaiCity.addEdge("SIDDHIVINAYAK TEMPLE", new ConnectingSpot("MUMBADEVI MANDIR", 14.7));
		mumbaiCity.addEdge("SIDDHIVINAYAK TEMPLE", new ConnectingSpot("ELEPHANTA CAVES", 17.7));

		Graph kolkataCity = new Graph();
		kolkataCity.addEdge("BIRLA MANDIR", new ConnectingSpot("SCIENCE CITY", 6.9));
		kolkataCity.addEdge("BIRLA MANDIR", new ConnectingSpot("KALIGHAT KALI TEMPLE", 3.5));
		kolkataCity.addEdge("BIRLA MANDIR", new ConnectingSpot("ST. PAUL’S CATHEDRAL", 3.5));
		kolkataCity.addEdge("SCIENCE CITY", new ConnectingSpot("INDIAN MUSEUM", 8.2));
		kolkataCity.addEdge("SCIENCE CITY", new ConnectingSpot("DAKSHINESHWAR KALI TEMPLE", 20.6));
		kolkataCity.addEdge("KALIGHAT KALI TEMPLE", new ConnectingSpot("ST. PAUL’S CATHEDRAL", 3));
		kolkataCity.addEdge("ST. PAUL’S CATHEDRAL", new ConnectingSpot("INDIAN MUSEUM", 1.9));
		kolkataCity.addEdge("ST. PAUL’S CATHEDRAL", new ConnectingSpot("VICTORIA MEMORIAL", 0.7));
		kolkataCity.addEdge("INDIAN MUSEUM", new ConnectingSpot("HOWRAH BRIDGE", 4.6));
		kolkataCity.addEdge("INDIAN MUSEUM", new ConnectingSpot("JORASANKO THAKUR BAN", 3.9));
		kolkataCity.addEdge("HOWRAH BRIDGE", new ConnectingSpot("BELUR MATH", 6.3));
		kolkataCity.addEdge("HOWRAH BRIDGE", new ConnectingSpot("JORASANKO THAKUR BAN", 1.8));
		kolkataCity.addEdge("BELUR MATH", new ConnectingSpot("DAKSHINESHWAR KALI TEMPLE", 5));
		kolkataCity.addEdge("BELUR MATH", new ConnectingSpot("JORASANKO THAKUR BAN", 5));
		kolkataCity.addEdge("VICTORIA MEMORIAL", new ConnectingSpot("HOWRAH BRIDGE", 5.4));

		Graph delhiCity = new Graph();
		delhiCity.addEdge("RED FORT", new ConnectingSpot("GANDHI SMRITI & MAHATMA GANDHI MEMORIAL", 2.2));
		delhiCity.addEdge("RED FORT", new ConnectingSpot("GURUDWARA BANGLA SAHIB", 7.5));
		delhiCity.addEdge("GANDHI SMRITI & MAHATMA GANDHI MEMORIAL", new ConnectingSpot("AGRASEN KI BAOLI", 4.2));
		delhiCity.addEdge("GANDHI SMRITI & MAHATMA GANDHI MEMORIAL", new ConnectingSpot("HUMAYUN’S TOMB", 12));
		delhiCity.addEdge("GANDHI SMRITI & MAHATMA GANDHI MEMORIAL", new ConnectingSpot("AKSHARDHAM MANDIR", 10.1));
		delhiCity.addEdge("AGRASEN KI BAOLI", new ConnectingSpot("GURUDWARA BANGLA SAHIB", 2.2));
		delhiCity.addEdge("GURUDWARA BANGLA SAHIB", new ConnectingSpot("NATIONAL MUSEUM", 2.2));
		delhiCity.addEdge("NATIONAL MUSEUM", new ConnectingSpot("INDIA GATE", 1.3));
		delhiCity.addEdge("INDIA GATE", new ConnectingSpot("DILLI HAAT", 7.3));
		delhiCity.addEdge("DILLI HAAT", new ConnectingSpot("HUMAYUN’S TOMB", 3));
		delhiCity.addEdge("DILLI HAAT", new ConnectingSpot("QUTUB MINAR", 7.6));
		delhiCity.addEdge("QUTUB MINAR", new ConnectingSpot("AKSHARDHAM MANDIR", 20));
		delhiCity.addEdge("QUTUB MINAR", new ConnectingSpot("HUMAYUN’S TOMB", 10.8));
		delhiCity.addEdge("HUMAYUN’S TOMB", new ConnectingSpot("AKSHARDHAM MANDIR", 7));

		Graph chennaiCity = new Graph();
		chennaiCity.addEdge("MARINA BEACH", new ConnectingSpot("VALLUR KOTTAM", 5.3));
		chennaiCity.addEdge("MARINA BEACH", new ConnectingSpot("THOUSAND LIGHT MOSQUE", 4.8));
		chennaiCity.addEdge("MARINA BEACH", new ConnectingSpot("DAKSHINCHITRA", 26.3));
		chennaiCity.addEdge("VALLUR KOTTAM", new ConnectingSpot("DAKSHINCHITRA", 29.9));
		chennaiCity.addEdge("THOUSAND LIGHT MOSQUE", new ConnectingSpot("ELLIOT BEACH", 9.3));
		chennaiCity.addEdge("THOUSAND LIGHT MOSQUE", new ConnectingSpot("GUINDY NATIONAL PARK", 9.0));
		chennaiCity.addEdge("ELLIOT BEACH", new ConnectingSpot("DAKSHINCHITRA", 28.1));
		chennaiCity.addEdge("ELLIOT BEACH", new ConnectingSpot("ASHTALAKSHMI TEMPLE", 1.4));
		chennaiCity.addEdge("DAKSHINCHITRA", new ConnectingSpot("MYLAPORE", 25.7));
		chennaiCity.addEdge("ASHTALAKSHMI TEMPLE", new ConnectingSpot("MYLAPORE", 8.7));
		chennaiCity.addEdge("ASHTALAKSHMI TEMPLE", new ConnectingSpot("GOVERNMENT MUSEUM", 31.0));
		chennaiCity.addEdge("GOVERNMENT MUSEUM", new ConnectingSpot("GUINDY NATIONAL PARK", 9.5));
		chennaiCity.addEdge("GUINDY NATIONAL PARK", new ConnectingSpot("MGR FILM CITY", 5.8));
		chennaiCity.addEdge("MGR FILM CITY", new ConnectingSpot("MYLAPORE", 8.5));

		System.out.println("\t\t\t\t\t!*!*!*!*!*!*!*!*!*!*!*!*!*!*!*!*!*!*!*!*!*!*!*!*!*!*!*!*!*!*!*!*!*!*!*!*!*!");
		System.out.println("\n\t\t\t\t\t                         विश्वयात्री");
		System.out.println("\n\t\t\t\t\t                               ~आपका तकनीकी संदर्शक");

		System.out.println("\n\t\t\t\t\t!*!*!*!*!*!*!*!*!*!*!*!*!*!*!*!*!*!*!*!*!*!*!*!*!*!*!*!*!*!*!*!*!*!*!*!*!*!\n");

		char ch;
		do {
			
			System.out.println(
					"\n\t\t\t\t\t===========================================================================\n");
			System.out.println("\t\t\t\t\t                                 MAIN MENU");
			System.out
					.println("\n\t\t\t\t\t==========================================================================");
			System.out.println(
					"\n\n\t\t\t\t\t--------------------------------ADVISOR------------------------------------");
			System.out
					.println("\n\t\t\t\t\t  ? --> Plan your next tour by exploring cities and their intersting spots");
			System.out.println("\t\t\t\t\t  @ --> Get the detailed information of all the packages that we offer");
			System.out.println("\n\t\t\t\t\t-------------------------------------------------------------------------");
			System.out.println(
					"\n\n\t\t\t\t\t---------------------------------GUIDER-------------------------------------");
			System.out.println("\n\t\t\t\t\t Select the city you are in to avail our guider facilitites");
			System.out.println("\t\t\t\t\t---------------------------------------------------------------------------");
			System.out.println("\t\t\t\t\t  D -->Delhi");
			System.out.println("\t\t\t\t\t  M -->Mumbai");
			System.out.println("\t\t\t\t\t  K -->Kolkata");
			System.out.println("\t\t\t\t\t  C -->Chennai");
			System.out.println("\t\t\t\t\t-------------------------------------------------------------------------");
			System.out.println("\n\t\t\t\t\t  X -->EXIT");
			System.out.println("\t\t\t\t\t-------------------------------------------------------------------------");
			
			do {
				System.out.println("\n\t\t\t\t\t  Enter your choice");
				System.out.print("\t\t\t\t\t  --->");
				ch = (char) buf.read();// Accepting the choice from the user
				buf.readLine();
				if (!(ch == 'D') && !(ch == 'M') && !(ch == 'K') && !(ch == 'C')&& !(ch == '@') && !(ch == '?') && !(ch == 'X')) {
					{
						System.out.println("\n!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!\n");
						System.out.println("\n\t\t\t\t\t\t\t\t!!!***INVALID INPUT***!!!\n");
						System.out.println("\n!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!\n");
					}
				}
			} while (!(ch== 'D') && !(ch == 'M') && !(ch == 'K') && !(ch == 'C')&& !(ch == '@') && !(ch == '?') && !(ch == 'X'));
			
			System.out
					.println("\n\t\t\t\t\t---------------------------------------------------------------------------");
			switch (ch) {

			case '?': {
				clear.clearScreen();
				do {
					System.out.println("\n\t\t\t\t\t S --> Search a Spot and get its details");
					System.out.println("\n\t\t\t\t\t C --> Search all Spots in particular city");
					System.out.println("\n\t\t\t\t\t X --> EXIT");
					System.out.println(
							"\n\t\t\t\t\t---------------------------------------------------------------------------");
					System.out.print("\n\t\t\t\t\tEnter your choice from above list : ");
					choice = sc.next().charAt(0);
					System.out.println(
							"\n\t\t\t\t\t---------------------------------------------------------------------------");
					switch (choice) {
					case 'S':
						clear.clearScreen();
						if (a.root == null) {
							System.out.println("List is empty\n");
							System.out.println(
									"\n\t\t\t\t\t---------------------------------------------------------------------------");
						} else {
							System.out.print("\t\t\t\t\tEnter spot name: ");
							System.out.print("\n\n\t\t\t\t\t\t  --->");
							sc.nextLine();
							spot = sc.nextLine();
							System.out.println(
									"\n=========================================================================================================================================================================================\n");
							ptr1 = a.searchSpot(spot);
							try {
								File myObj = new File("E:\\SpotHistory\\" + ptr1.info + ".txt"); // file object
																									// represents the
																									// file path on disk
								Scanner myReader = new Scanner(myObj); // object of scanner class read the data from
																		// file object
								while (myReader.hasNextLine()) { // it will traverse one by one line from file
									String data = myReader.nextLine();
									System.out.println("\t\t\t\t\t " + data); // printing one by one line
								}
								myReader.close(); // object close
								System.out.println(
										"\n======================================================================================================================================================================================\n");
							} catch (FileNotFoundException e) { // if file not found
								System.out.println("File Not Found\n");
								System.out.println(
										"\t\t\t\t\t============================================================================================================================================================================\n");
							} catch (NullPointerException e) { // if null is returned
								System.out.println("\t\t\t\t\t\t\tSpot Not Found\n");
								System.out.println(
										"\n=============================================================================================================================================================================\n");
							}
							System.out.println();
						}
						break;
					case 'C':
						clear.clearScreen();
						if (a.root == null) {
							System.out.println("List is empty\n");
						}
						System.out.println("\n\t\t\t\t\tSelect the city whose spots you wish to explore");
						System.out.println(
								"\t\t\t\t\t---------------------------------------------------------------------------");
						System.out.println("\t\t\t\t\t  D -->Delhi");
						System.out.println("\t\t\t\t\t  M -->Mumbai");
						System.out.println("\t\t\t\t\t  K -->Kolkata");
						System.out.println("\t\t\t\t\t  C -->Chennai");
						System.out.println(
								"\n\t\t\t\t\t-------------------------------------------------------------------------");
						System.out.print("\n\t\t\t\t\tEnter city name from above list: ");

						do {
							sc.nextLine();
							city = sc.next().charAt(0); // city to store city name
							if (!(city == 'D') && !(city == 'M') && !(city == 'K') && !(city == 'C')) {
								System.out.print("\n\t\t\t\t\tINVALID INPUT!!! Kindly enter correct Option :");
							}
						} while (!(city == 'D') && !(city == 'M') && !(city == 'K') && !(city == 'C'));
						switch (city) {
						case 'D': {
							clear.clearScreen();

							System.out.println(
									"\n----------------------------------------------------------------------------------WELCOME TO DELHI------------------------------------------------------------------------------------------------------\n");
							a.searchCity("Delhi", a.root);// calling searchCity function
							System.out.println(
									"\n-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------\n");
						}
							break;
						case 'M':
							clear.clearScreen();
							System.out.println(
									"\n---------------------------------------------------------------------------------WELCOME TO MUMBAI--------------------------------------------------------------------------------------------------\n");
							a.searchCity("Mumbai", a.root);// calling searchCity function
							System.out.println(
									"\n-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------\n");
							break;
						case 'K':
							clear.clearScreen();
							System.out.println(
									"\n---------------------------------------------------------------------------------WELCOME TO KOLKATA--------------------------------------------------------------------------------------------------------------\n");
							a.searchCity("Kolkata", a.root);// calling searchCity function
							System.out.println(
									"\n-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------\n");
							break;
						case 'C':
							clear.clearScreen();

							System.out.println(
									"\n---------------------------------------------------------------------------------WELCOME TO CHENNAI--------------------------------------------------------------------------------------------------------------------\n");
							a.searchCity("Chennai", a.root);// calling searchCity function
							System.out.println(
									"\n--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------\n");
							break;
						default:
							System.out.println("\t\t\t\t\t!!!***INVALID INPUT***!!!");
							System.out.println(
									"---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
							break;
						}
						break;
					case 'X':
						System.out.println(
								"\n---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------\n");
						break;
					default:
						System.out.println("\t\t\t\t\t\t\t\t!!!***INVALID INPUT***!!!");
						System.out.println(
								"-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
						break;
					}

				} while (choice != 'X');
				clear.clearScreen();
			}
				break;

			case '@': {

				clear.clearScreen();
				ArrayList<String> virt_tour_city = null; // variable to store bfs sequence of spots in a city
				double pack_cost = 0; // variable to store cost of a package
				String pack_name = ""; // variable to store name of package
				char city_ch; // variable to store city choice of user
				// do while loop to drive the @ sub menu
				do {
					clear.clearScreen();
					System.out.println(
							"\n\t\t\t\t\t============================================================================\n");
					System.out.println("\t\t\t\t\t                   Pick a city to view the Sponsored Packages");
					System.out.println(
							"\n\t\t\t\t\t==============================================================================");
					System.out.println("\t\t\t\t\t  D -->Delhi");
					System.out.println("\t\t\t\t\t  M -->Mumbai");
					System.out.println("\t\t\t\t\t  K -->Kolkata");
					System.out.println("\t\t\t\t\t  C -->Chennai");
					System.out.println("\t\t\t\t\t  X -->GO BACK TO MAIN MENU");
					System.out.println(
							"\n\t\t\t\t\t------------------------------------------------------------------------------");
					System.out.println("\n\t\t\t\t\t  Enter your choice");
					System.out.print("\t\t\t\t\t  --->");
					do {
						
						city_ch = sc.next().charAt(0); // city to store city name
						sc.nextLine();
						if (!(city_ch == 'D') && !(city_ch == 'M') && !(city_ch == 'K') && !(city_ch == 'C')&& !(city_ch == 'X')) {
							System.out.print("\n\t\t\t\t\tINVALID INPUT!!! Kindly enter correct Option :");
						}
					} while (!(city_ch == 'D') && !(city_ch == 'M') && !(city_ch == 'K') && !(city_ch == 'C')&& !(city_ch == 'X'));
					System.out.println(
							"\n\t\t\t\t\t---------------------------------------------------------------------------");
					// switch case to handle user choice

					switch (city_ch) {
					case 'D':
					case 'd':

						virt_tour_city = delhiCity.bfs("RED FORT");
						pack_cost = (delhiCity.MST_ByPrims("RED FORT"));
						pack_name = "\n\t\t\t\t\t\\|/\\|/....DILLI HINDUSTAN KI Sponsored by BALMER LAWRIE TOURS & TRAVELS ....\\|/\\|/\n";
						break;
					case 'M':
					case 'm':

						virt_tour_city = mumbaiCity.bfs("FILM CITY");
						pack_cost = mumbaiCity.MST_ByPrims("FILM CITY");
						pack_name = "\n\t\t\t\t\t\\|/\\|/....SWAPNANCHI MAYANAGRI Sponsored by MUMBAI DARSHAN TOURS & TRAVELS ....\\|/\\|/\n";
						break;
					case 'K':
					case 'k':

						virt_tour_city = kolkataCity.bfs("SCIENCE CITY");
						pack_cost = kolkataCity.MST_ByPrims("SCIENCE CITY");
						pack_name = "\n\t\t\t\t\t\\|/\\|/....KOLKATA MISHTIDOI Sponsored by WESTERN TOURS & TRAVELS ....\\|/\\|/\n";
						break;
					case 'C':
					case 'c':

						virt_tour_city = chennaiCity.bfs("GOVERNMENT MUSEUM");
						pack_cost = chennaiCity.MST_ByPrims("GOVERNMENT MUSEUM");
						pack_name = "\n\t\t\t\t\t\\|/\\|/....MADRAS ARUMAI Sponsored by TRINITY TOURS & TRAVELS ....\\|/\\|/\n";
						break;
					case 'X':
						virt_tour_city = null;
						break;
					default: {
						virt_tour_city = null;
						System.out.println("\t\t\t\t\t!!!***INVALID INPUT***!!!");
					}
					}// switch ends here
						// If user selected a valid city
					if (virt_tour_city != null) {
						System.out.println(
								"\n====================================================================================================================================================================================================================================================================");
						System.out.println(
								"\\*/\\*/\\*/\\*/\\*/\\*/\\*/\\*/\\*/\\*/\\*/\\*/\\*/\\*/\\*/\\*/\\*/\\*/\\*/\\*/\\*/\\*/\\*/\\*/\\*/\\*/\\*/\\*/\\*/\\*/\\*/\\*/\\*/\\*/\\*/\\*/\\*/\\*/\\*/\\*/\\*/\\*/\\*/\\*/\\*/\\*/\\*/\\*/\\*/\\*/\\*/\\*/\\*/\\*/\\*/\\*/\\*/\\*/\\*/\\*/\\*/\\*/\\*/\\*/\\*/");
						System.out.println(
								"/*\\/*\\/*\\/*\\/*\\/*\\/*\\/*\\/*\\/*\\/*\\/*\\/*\\/*\\/*\\/*\\/*\\/*\\/*\\/*\\/*\\/*\\/*\\/*\\/*\\/*\\/*\\/*\\/*\\/*\\/*\\/*\\/*\\/*\\/*\\/*\\/*\\/*\\/*\\/*\\/*\\/*\\/*\\/*\\/*\\/*\\/*\\/*\\/*\\/*\\/*\\/*\\/*\\/*\\/*\\/*\\/*\\/*\\/*\\/*\\/*\\/*\\/*\\/*\\/*\\");
						System.out.println(
								"====================================================================================================================================================================================================================================================================");

						pack_cost = pack_cost * 250;
						System.out.println(
								"\t\t\t\t\t=======================================================================");
						System.out.println("\t\t\t\t\t\t           ***THE COST PER KM IS Rs.250***");
						System.out.println(
								"\t\t\t\t\t\t     " + pack_name + "\t\t\t\t\t\t\tCost of Package: " + pack_cost);
						System.out.println("\n\t\t\t\t\t\tLocations that will be a part of the itinerary:\n");
						// for loop to display all locations in package
						for (int i = 0; i < virt_tour_city.size(); i++) {
							System.out.println(
									"\t\t\t\t\t-------|-------------------------------------------------------------|-------");
							System.out.println("\t\t\t\t\t\t          " + virt_tour_city.get(i));
						}
						System.out.println(
								"\t\t\t\t\t-------|-------------------------------------------------------------|-------");

						System.out.println(
								"\n====================================================================================================================================================================================================================================================================");
						System.out.println(
								"\\*/\\*/\\*/\\*/\\*/\\*/\\*/\\*/\\*/\\*/\\*/\\*/\\*/\\*/\\*/\\*/\\*/\\*/\\*/\\*/\\*/\\*/\\*/\\*/\\*/\\*/\\*/\\*/\\*/\\*/\\*/\\*/\\*/\\*/\\*/\\*/\\*/\\*/\\*/\\*/\\*/\\*/\\*/\\*/\\*/\\*/\\*/\\*/\\*/\\*/\\*/\\*/\\*/\\*/\\*/\\*/\\*/\\*/\\*/\\*/\\*/\\*/\\*/\\*/\\*/");
						System.out.println(
								"/*\\/*\\/*\\/*\\/*\\/*\\/*\\/*\\/*\\/*\\/*\\/*\\/*\\/*\\/*\\/*\\/*\\/*\\/*\\/*\\/*\\/*\\/*\\/*\\/*\\/*\\/*\\/*\\/*\\/*\\/*\\/*\\/*\\/*\\/*\\/*\\/*\\/*\\/*\\/*\\/*\\/*\\/*\\/*\\/*\\/*\\/*\\/*\\/*\\/*\\/*\\/*\\/*\\/*\\/*\\/*\\/*\\/*\\/*\\/*\\/*\\/*\\/*\\/*\\/*\\");
						System.out.println(
								"====================================================================================================================================================================================================================================================================");
						System.out.print("Enter 0 to return back and view other packages :");
						int exit1;
						do {
							exit1 = sc.nextInt();
							if (exit1 != 0)
								System.out.print("INVALID INPUT!!! Enter 0 to return back and view other packages :");
						} while (exit1 != 0);
					}
				} while (city_ch != 'X');
				clear.clearScreen();
			}
				break;

			case 'D': {
				clear.clearScreen();
				int in_ch;
				System.out.println(
						"\n\t\t\t\t\t============================================================================\n");
				System.out.println("\t\t\t\t\t                         दिल्ली");
				System.out.println("\t\t\t\t\t                              ~जो है इस देश की धड़कन");

				do {
					System.out.println(
							"\n\t\t\t\t\t============================================================================\n");
					System.out.println("\t\t\t\t\t                                        MENU");
					System.out.println(
							"\n\t\t\t\t\t==============================================================================");
					System.out.println(
							"\t\t\t\t\t  1--> Tell us your current location and get to know the shortest distance to all other spots");
					System.out.println("\t\t\t\t\t  2--> Explore all the spots within the required range");
					System.out.println("\t\t\t\t\t  3--> Return back to main menu");
					System.out.println(
							"\n\t\t\t\t\t------------------------------------------------------------------------------");
					System.out.println("\n\t\t\t\t\t  Enter your choice");
					System.out.print("\t\t\t\t\t  --->");
					
					do {
						
						in_ch = Integer.parseInt(buf.readLine());
						if (!(in_ch == 1) && !(in_ch == 2) && !(in_ch == 3) ) {
							System.out.print("\n\t\t\t\t\tINVALID INPUT!!! Kindly enter correct Option :");
						}
					} while (!(in_ch == 1) && !(in_ch == 2) && !(in_ch == 3) );
					System.out.println(
							"\n\t\t\t\t\t---------------------------------------------------------------------------");
					switch (in_ch) {

					case 1:
						delhiCity.shortCutDisplayer("DELHI", 0);
						clear.clearScreen();
						break;
					case 2:
						delhiCity.shortCutDisplayer("DELHI", 1);
						clear.clearScreen();
						break;
					case 3:
						break;
			
					}// switch ends here

				} while (in_ch != 3);// do-while ends here
				clear.clearScreen();
			}
				break;

			case 'M': {
				clear.clearScreen();
				int in_ch;
				System.out.println(
						"\n\t\t\t\t\t============================================================================\n");
				System.out.println("\t\t\t\t\t\t                           मुंबई");
				System.out.println("\t\t\t\t\t\t                                 ~जहां सृजनात्मकता ही आचरण है");
				System.out.println(
						"\n\t\t\t\t\t============================================================================\n");

				do {
					System.out.println(
							"\n\t\t\t\t\t============================================================================\n");
					System.out.println("\t\t\t\t\t                                        MENU");
					System.out.println(
							"\n\t\t\t\t\t==============================================================================");
					System.out.println(
							"\t\t\t\t\t  1--> Tell us your current location and get to know the shortest distance to all other spots");
					System.out.println("\t\t\t\t\t  2--> Explore all the spots within the required range");
					System.out.println("\t\t\t\t\t  3--> Return back to main menu");
					System.out.println(
							"\n\t\t\t\t\t------------------------------------------------------------------------------");
					System.out.println("\n\t\t\t\t\t  Enter your choice");
					System.out.print("\t\t\t\t\t  --->");
					do {
						
						in_ch = Integer.parseInt(buf.readLine());
						if (!(in_ch == 1) && !(in_ch == 2) && !(in_ch == 3) ) {
							System.out.print("\n\t\t\t\t\tINVALID INPUT!!! Kindly enter correct Option :");
						}
					} while (!(in_ch == 1) && !(in_ch == 2) && !(in_ch == 3) );
					System.out.println(
							"\n\t\t\t\t\t---------------------------------------------------------------------------");
					switch (in_ch) {

					case 1:
						mumbaiCity.shortCutDisplayer("MUMBAI", 0);
						clear.clearScreen();
						break;
					case 2:
						mumbaiCity.shortCutDisplayer("MUMBAI", 1);
						clear.clearScreen();
						break;
					case 3:
						break;
					
					}// switch ends here

				} while (in_ch != 3);// do-while ends here
				clear.clearScreen();
			}
				break;

			case 'K': {
				clear.clearScreen();
				int in_ch;
				System.out.println(
						"\n\t\t\t\t\t============================================================================\n");
				System.out.println("\t\t\t\t\t                            कोलकाता");
				System.out.println(
						"\t\t\t\t\t\t                                ~जहां से आज़ादी की पुकार ने कई शूरवीरों को जन्मा");
				System.out.println(
						"\n\t\t\t\t\t============================================================================\n");
				do {
					System.out.println(
							"\n\t\t\t\t\t============================================================================\n");
					System.out.println("\t\t\t\t\t                                        MENU");
					System.out.println(
							"\n\t\t\t\t\t==============================================================================");
					System.out.println(
							"\t\t\t\t\t  1--> Tell us your current location and get to know the shortest distance to all other spots");
					System.out.println("\t\t\t\t\t  2--> Explore all the spots within the required range");
					System.out.println("\t\t\t\t\t  3--> Return back to main menu");
					System.out.println(
							"\n\t\t\t\t\t------------------------------------------------------------------------------");
					System.out.println("\n\t\t\t\t\t  Enter your choice");
					System.out.print("\t\t\t\t\t  --->");
					do {
						
						in_ch = Integer.parseInt(buf.readLine());
						if (!(in_ch == 1) && !(in_ch == 2) && !(in_ch == 3) ) {
							System.out.print("\n\t\t\t\t\tINVALID INPUT!!! Kindly enter correct Option :");
						}
					} while (!(in_ch == 1) && !(in_ch == 2) && !(in_ch == 3) );
					System.out.println(
							"\n\t\t\t\t\t---------------------------------------------------------------------------");

					switch (in_ch) {

					case 1:
						kolkataCity.shortCutDisplayer("KOLKATA", 0);
						clear.clearScreen();
						break;
					case 2:
						kolkataCity.shortCutDisplayer("KOLKATA", 1);
						clear.clearScreen();
						break;
					case 3:
						break;
					
					}// switch ends here

				} while (in_ch != 3);// do-while ends here
				clear.clearScreen();
			}
				break;

			case 'C': {
				clear.clearScreen();
				int in_ch;
				System.out.println(
						"\n\t\t\t\t\t============================================================================\n");
				System.out.println("\t\t\t\t\t                               चेन्नई ");
				System.out.println("\t\t\t\t\t\t                                ~जहां संग्रहित है भारत की प्राचीनता");
				System.out.println(
						"\n\t\t\t\t\t============================================================================\n");
				do {
					System.out.println(
							"\n\t\t\t\t\t============================================================================\n");
					System.out.println("\t\t\t\t\t                                        MENU");
					System.out.println(
							"\n\t\t\t\t\t==============================================================================");
					System.out.println(
							"\t\t\t\t\t  1--> Tell us your current location and get to know the shortest distance to all other spots");
					System.out.println("\t\t\t\t\t  2--> Explore all the spots within the required range");
					System.out.println("\t\t\t\t\t  3--> Return back to main menu");
					System.out.println(
							"\n\t\t\t\t\t------------------------------------------------------------------------------");
					System.out.println("\n\t\t\t\t\t  Enter your choice");
					System.out.print("\t\t\t\t\t  --->");
					do {
						
						in_ch = Integer.parseInt(buf.readLine());
						if (!(in_ch == 1) && !(in_ch == 2) && !(in_ch == 3) ) {
							System.out.print("\n\t\t\t\t\tINVALID INPUT!!! Kindly enter correct Option :");
						}
					} while (!(in_ch == 1) && !(in_ch == 2) && !(in_ch == 3) );
					System.out.println(
							"\n\t\t\t\t\t---------------------------------------------------------------------------");

					switch (in_ch) {

					case 1:
						chennaiCity.shortCutDisplayer("CHENNAI", 0);
						clear.clearScreen();
						break;
					case 2:
						chennaiCity.shortCutDisplayer("CHENNAI", 1);
						clear.clearScreen();
						break;
					case 3:
						break;
					
					}// switch ends here

				} while (in_ch != 3);// do-while ends here
				clear.clearScreen();
			}
				break;
			case 'X':
				break;
					
			}// switch ends here

			
		} while (ch != 'X');// do-while ends here
		
		
		/*
		 * ____________________________TIMER CODE BEGINS
		 * HERE____________________________
		 */
		clear.clearScreen();
		System.out
				.println("\n\t\t\t\t\t============================================================================\n");
		System.out.println("\t\t\t\t\t           SELECT YOUR FAVOURITE CITY TO GO ON OUR SPECIAL VIRTUAL TOUR");
		System.out
				.println("\n\t\t\t\t\t==============================================================================");
		System.out.println("\t\t\t\t\t  1 -->Delhi");
		System.out.println("\t\t\t\t\t  2 -->Mumbai");
		System.out.println("\t\t\t\t\t  3 -->Kolkata");
		System.out.println("\t\t\t\t\t  4 -->Chennai");
		System.out.println("\t\t\t\t\t  0 -->EXIT");
		System.out
				.println("\n\t\t\t\t\t------------------------------------------------------------------------------");
		System.out.println("\n\t\t\t\t\t  Enter your choice");
		System.out.print("\t\t\t\t\t  --->");
		int final_ch = Integer.parseInt(buf.readLine());
		ArrayList<String> traversal = null;

		switch (final_ch) {
		case 1:
			traversal = delhiCity.bfs("INDIA GATE");
			break;
		case 2:
			traversal = mumbaiCity.bfs("FILM CITY");
			break;
		case 3:
			traversal = kolkataCity.bfs("HOWRAH BRIDGE");
			break;
		case 4:
			traversal = chennaiCity.bfs("MGR FILM CITY");
			break;
		case 0:
			clear.clearScreen();
			System.out.println("\t\t\t\t\t          ****ViSwaYatri wishes you a safe journey ahead!****");
			System.exit(0);

		}
		clear.clearScreen();
		System.out.println("\n\t\t\t\t\t\tYour mini tour will start in few moments......\n");
		Timer timer = new Timer();
		TimerTask task = new Tour_Feel(traversal);
		timer.schedule(task, 3000, 4500);

		/* ___________________________TIMER ENDS HERE_______________________________ */

	}// main method ends here
}// Main class ends here
/*OUTPUT
 * 
 * !*!*!*!*!*!*!*!*!*!*!*!*!*!*!*!*!*!*!*!*!*!*!*!*!*!*!*!*!*!*!*!*!*!*!*!*!*!

					                         विश्वयात्री

					                               ~आपका तकनीकी संदर्शक

					!*!*!*!*!*!*!*!*!*!*!*!*!*!*!*!*!*!*!*!*!*!*!*!*!*!*!*!*!*!*!*!*!*!*!*!*!*!


					===========================================================================

					                                 MAIN MENU

					==========================================================================


					--------------------------------ADVISOR------------------------------------

					  ? --> Plan your next tour by exploring cities and their intersting spots
					  @ --> Get the detailed information of all the packages that we offer

					-------------------------------------------------------------------------


					---------------------------------GUIDER-------------------------------------

					 Select the city you are in to avail our guider facilitites
					---------------------------------------------------------------------------
					  D -->Delhi
					  M -->Mumbai
					  K -->Kolkata
					  C -->Chennai
					-------------------------------------------------------------------------

					  X -->EXIT
					-------------------------------------------------------------------------

					  Enter your choice
					  --->?

					---------------------------------------------------------------------------
====================================================================================================================================================================================================================================================================
\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/
/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\
====================================================================================================================================================================================================================================================================




					 S --> Search a Spot and get its details

					 C --> Search all Spots in particular city

					 X --> EXIT

					---------------------------------------------------------------------------

					Enter your choice from above list : S

					---------------------------------------------------------------------------
====================================================================================================================================================================================================================================================================
\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/
/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\
====================================================================================================================================================================================================================================================================



					Enter spot name: 

						  --->Juhu

=========================================================================================================================================================================================

							Spot Not Found


=============================================================================================================================================================================



					 S --> Search a Spot and get its details

					 C --> Search all Spots in particular city

					 X --> EXIT

					---------------------------------------------------------------------------

					Enter your choice from above list : S

					---------------------------------------------------------------------------

====================================================================================================================================================================================================================================================================
\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/
/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\
====================================================================================================================================================================================================================================================================



					Enter spot name: 

						  --->Juhu Beach

=========================================================================================================================================================================================

					 SPOT NAME:JUHU BEACH, MUMBAI
					 
					 ADDRESS:Juhu Beach, Juhu Tara Rd, Juhu, Mumbai,400049, Maharashtra, India.
					 
					 SPECIALITY: famous for the sprawling Juhu Beach.
					 
					 HISTORY:
					 	*Bright lights, excited vendors, and a mesmerizing aura describe Juhu beach the best. 
					 	*Be it the alluring food stalls, the loud, blaring Bollywood music or the umpteen happy 
					 	 faces around you, the place just has its own charm.
					 	*Indulge in some mouth-watering local delicacies complete with a slurpy colourful chuski (popsicle) 
					 	 or wander around and let the frenzy take over. 
					 	*Walk over to the expanding horizon and let the cool waters welcome you. 
					 	*With the wet sand underneath your feet, the soft murmur of faraway chatter and myriad thoughts, 
					 	 enjoy Juhu at its absolute best.

======================================================================================================================================================================================



					 S --> Search a Spot and get its details

					 C --> Search all Spots in particular city

					 X --> EXIT

					---------------------------------------------------------------------------

					Enter your choice from above list : C

					---------------------------------------------------------------------------

====================================================================================================================================================================================================================================================================
\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/
/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\
====================================================================================================================================================================================================================================================================




					Select the city whose spots you wish to explore
					---------------------------------------------------------------------------
					  D -->Delhi
					  M -->Mumbai
					  K -->Kolkata
					  C -->Chennai

					-------------------------------------------------------------------------

					Enter city name from above list: D



====================================================================================================================================================================================================================================================================
\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/
/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\
====================================================================================================================================================================================================================================================================




----------------------------------------------------------------------------------WELCOME TO DELHI------------------------------------------------------------------------------------------------------

SPOT NAME: AGRASEN KI BAOLI

ADDRESS: Hailey Road, KG Marg, near Diwanchand Imaging Centre, New Delhi, Delhi 110001

SPECIALITY: This location has been used for shooting for various Bollywood films.  


_______________________________________________________________________________________________________________________________________________________________

SPOT NAME: AKSHARDHAM MANDIR

ADDRESS: Noida Mor, Pandav Nagar, New Delhi, Delhi 110092

SPECIALITY: Akshardham as the World's Largest Comprehensive Hindu Temple (certificate). 
	 

_______________________________________________________________________________________________________________________________________________________________

SPOT NAME: DILLI HAAT INA

ADDRESS: INA Market, Dilli Haat, Kidwai Nagar West, Kidwai Nagar, Delhi, 110023

SPECIALITY:popular shopping gateways in New Delhi, where music, food, fun, and festivities converge in one place.


_______________________________________________________________________________________________________________________________________________________________

SPOT NAME: GANDHI SMRITI & MAHATMA GANDHI MEMORIAL

ADDRESS: Infront of National Defence College, 5, Tees January Marg Near Birla House, New Delhi, Delhi 110001

SPECIALITY: Visitors can tour the sparse room where Gandhi stayed, where all of his belongings remain intact. 
	    

_______________________________________________________________________________________________________________________________________________________________

SPOT NAME: GURUDWARA BANGLA SAHIB

ADDRESS: Hanuman Road Area, Connaught Place, New Delhi, Delhi 110001

SPECIALITY: Most prominent Sikh gurdwara, or Sikh house of worship, in Delhi, India


_______________________________________________________________________________________________________________________________________________________________

SPOT NAME: HUMAYUN'S TOMB

ADDRESS: Mathura Road Opposite, Hazrat Nizamuddin Aulia Dargah, Mathura Rd, Nizamuddin, Nizamuddin East, New Delhi, Delhi 110013

SPECIALITY: This structure is known for its unique architecture.


_______________________________________________________________________________________________________________________________________________________________

SPOT NAME: INDIA GATE

ADDRESS: Rajpath, India Gate, New Delhi, Delhi 110001

SPECIALITY: India Gate, an important monument of the city, is a memorial built in commemoration of more than 80,000
	    Indian soldiers who were killed during World War I.

_______________________________________________________________________________________________________________________________________________________________

SPOT NAME: NATIONAL MEUSEUM

ADDRESS: Janpath Rd, Rajpath Area, Central Secretariat, New Delhi, Delhi 110011

SPECIALITY: The National Museum in New Delhi, also known as the National Museum of India, is one of the largest museums in India.
	    Established in 1949, it holds a variety of articles ranging from pre-historic era to modern works of art. 

_______________________________________________________________________________________________________________________________________________________________

SPOT NAME: QUTUB MINAR

ADDRESS:  Seth Sarai, Mehrauli, New Delhi, Delhi 110030

SPECIALITY: One of the finest examples of Indo Islamic architecture, Qutub Minar is the highest brick minaret in the world. 
	   The height of Qutub Minar is 72.5 metres

_______________________________________________________________________________________________________________________________________________________________

SPOT NAME: RED FORT

ADDRESS: Netaji Subhash Marg, Lal Qila, Chandni Chowk, New Delhi, Delhi 110006

SPECIALITY:The fort, which is spread over 255 acres, features a mix of architectural styles such as Islamic, Hindi, Timurid, and Persian.


_______________________________________________________________________________________________________________________________________________________________


-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------


					 S --> Search a Spot and get its details

					 C --> Search all Spots in particular city

					 X --> EXIT

					---------------------------------------------------------------------------

					Enter your choice from above list : D

					---------------------------------------------------------------------------
								!!!***INVALID INPUT***!!!
-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------

					 S --> Search a Spot and get its details

					 C --> Search all Spots in particular city

					 X --> EXIT

					---------------------------------------------------------------------------

					Enter your choice from above list : C

					---------------------------------------------------------------------------

====================================================================================================================================================================================================================================================================
\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/
/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\
====================================================================================================================================================================================================================================================================




					Select the city whose spots you wish to explore
					---------------------------------------------------------------------------
					  D -->Delhi
					  M -->Mumbai
					  K -->Kolkata
					  C -->Chennai

					-------------------------------------------------------------------------

					Enter city name from above list: K


====================================================================================================================================================================================================================================================================
\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/
/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\
====================================================================================================================================================================================================================================================================




---------------------------------------------------------------------------------WELCOME TO KOLKATA--------------------------------------------------------------------------------------------------------------

SPOT NAME:BELUR MATH, KOLKATA

ADDRESS:Belur, Howrah, West Bengal 711202

SPECIALITY: Motifs as a symbol of unity of all religions.


_______________________________________________________________________________________________________________________________________________________________

SPOT NAME:BIRLA MANDIR, KOLKATA (Taramandal)

ADDRESS:Chowdhury Avenue, Ballygunge, Kolkata

SPECIALITY:The temple breaks away from traditional style of temples of the past and displays a modern treatment to it.


_______________________________________________________________________________________________________________________________________________________________

SPOT NAME:DAKSHINESHWAR KALI TEMPLE,KOLKATA

ADDRESS:Park Street, Kolkata

SPECIALITY:Hindu navaratna temple


_______________________________________________________________________________________________________________________________________________________________

SPOT NAME:HOWRAH BRIDGE ,KOLKATA

ADDRESS:Howrah,Constructed over Hoogly River, West Bengal, 700001

SPECIALITY:Oldest hanging bridges in the world with no pillars supporting its suspension over the Hooghly River. 
	   It is the sixth longest bridge of its type in the world.

_______________________________________________________________________________________________________________________________________________________________

SPOT NAME:INDIAN MUSEUM, KOLKATA

ADDRESS:27, Jawaharlal Nehru Road, Park Street, Kolkata - 700016. 

SPECIALITY:It has rare collections of antiques, armour and ornaments, fossils, skeletons, mummies and Mughal paintings.


_______________________________________________________________________________________________________________________________________________________________

SPOT NAME:JORASANKO THAKUR BARI, KOLKATA

ADDRESS:Singhi Bagan, Jorasanko, Kolkata, West Bengal 700007

SPECIALITY: Important centres of social reform, and Bengali literature.(Rabindranath Tagore)


_______________________________________________________________________________________________________________________________________________________________

SPOT NAME:KALIGHAT KALI TEMPLE, KOLKATA

ADDRESS:Anami Sangha, Kalighat, Kolkata, West Bengal 700026

SPECIALITY:One of the 51 Shakti Peethas of India


_______________________________________________________________________________________________________________________________________________________________

SPOT NAME:SCIENCE CITY, KOLKATA

ADDRESS:BS Haldane Avenue, Basanti Hwy, Kolkata, WB

SPECIALITY: Largest science centre in the Indian subcontinent.


_______________________________________________________________________________________________________________________________________________________________

SPOT NAME:ST. PAUL'S CATHEDRAL, KOLKATA

ADDRESS:Cathedral Rd, Maidan, Kolkata, West Bengal 700071

SPECIALITY:One of the first cathedrals built by the Britishers in India.


_______________________________________________________________________________________________________________________________________________________________

SPOT NAME:VICTORIA MEMORIAL HALL

Address:Victoria Memorial Hall, 1, Queens Way, Maidan, Kolkata, West Bengal 700071

Speciality: Famous and beautiful monuments of Kolkata


_______________________________________________________________________________________________________________________________________________________________


-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------


					 S --> Search a Spot and get its details

					 C --> Search all Spots in particular city

					 X --> EXIT

					---------------------------------------------------------------------------

					Enter your choice from above list : C

					---------------------------------------------------------------------------
					
====================================================================================================================================================================================================================================================================
\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/
/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\
====================================================================================================================================================================================================================================================================




					Select the city whose spots you wish to explore
					---------------------------------------------------------------------------
					  D -->Delhi
					  M -->Mumbai
					  K -->Kolkata
					  C -->Chennai

					-------------------------------------------------------------------------

					Enter city name from above list: L

					INVALID INPUT!!! Kindly enter correct Option :C

====================================================================================================================================================================================================================================================================
\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/
/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\
====================================================================================================================================================================================================================================================================




---------------------------------------------------------------------------------WELCOME TO CHENNAI--------------------------------------------------------------------------------------------------------------------

SPOT NAME: SHRI ASHTALAKSHMI TEMPLE

ADDRESS: 6/21 paindi Amman Kovil, Elliots Beach, Besant Nagar, Chennai, Tamil Nadu 600090

SPECIALITY: The Ashtalakshmi Kovil is a Hindu temple, which lies on the shorelines near the Elliot's beach, in Chennai, India.
	    

_______________________________________________________________________________________________________________________________________________________________

SPOT NAME: DAKSHINA CHITRA MUSEUM

ADDRESS: SH 49, Muthukadu, Tamil Nadu 603118

SPECIALITY: DakshinaChitra ("a picture of the south") is a living-history museum in the Indian state of Tamil Nadu, 
	    dedicated to South Indian heritage and culture.

_______________________________________________________________________________________________________________________________________________________________

SPOT NAME: ELLIOT'S BEACH

ADDRESS: 6th Avenue, Besant Nagar, Chennai, Tamil Nadu, 600090, India

SPECIALITY: Elliot's beach is also well-known as Besant Nagar beach. 
	    It is considered as the cleanest beach of Chennai. It is less crowded compared to Marina beach

_______________________________________________________________________________________________________________________________________________________________

SPOT NAME: GOVERNMENT MEUSEUM

ADDRESS:  Government Maternity Hospital, Pantheon Rd, Egmore, Chennai, Tamil Nadu 600008

SPECIALITY: The museum has a natural history section, a children's museum, and zoological and botanical galleries. 
	    

_______________________________________________________________________________________________________________________________________________________________

SPOT NAME: GUINDY NATIONAL PARK

ADDRESS:  Rangeguindy, Chennai, Tamil Nadu 600025

SPECIALITY: The park has a dry evergreen scrub and thorn forest, grasslands and water bodies with over 350 species of plants including shrubs, climbers, herbs and grasses
	    and over 24 variety of trees, including the sugar-apple, Atlantia monophylla, wood-apple, and neem.

_______________________________________________________________________________________________________________________________________________________________

SPOT NAME: MARINA BEACH

ADDRESS: Triplicane, Chennai, Tamil Nadu 600005, India

SPECIALITY: Marina beach in Chennai along the Bay of Bengal is India's longest and world's second longest beach.
	    Marina beach is easily accessible by buses, taxis, two and three wheelers.

_______________________________________________________________________________________________________________________________________________________________

SPOT NAME: MGR FILM CITY

ADDRESS:  Tharamani, Chennai, Tamil Nadu 600113

SPECIALITY: The MGR Film City is a popular tourist hotspot and the place-to-be for several South Indian films directors.
	    

_______________________________________________________________________________________________________________________________________________________________

SPOT NAME: MYLAPORE

ADDRESS:  Mylapore H.O, Chennai, Tamil Nadu, India (IN), Pin Code:-600004

SPECIALITY: Mylapore is home to hundreds of temples, churches and mosques.
	    

_______________________________________________________________________________________________________________________________________________________________

SPOT NAME: THOUSANDS LIGHTS MOSQUE

ADDRESS:  Royapettah, Peters Rd, Peters Colony, Thousand Lights, Chennai, Tamil Nadu 600086

SPECIALITY: Thousand Lights Mosque is a prominent place of worship of the Muslim Shia community.


_______________________________________________________________________________________________________________________________________________________________

SPOT NAME: VALLUVAR KOTTAM

ADDRESS: 34, Valluvar Kottam High Road, Nungambakkam, Chennai, Tamil Nadu, 600034 India

SPECIALITY: The monument consists of a decorative arch, an auditorium that can accommodate around 3,500 people, 
            

_______________________________________________________________________________________________________________________________________________________________


--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------


					 S --> Search a Spot and get its details

					 C --> Search all Spots in particular city

					 X --> EXIT

					---------------------------------------------------------------------------

					Enter your choice from above list : X

					---------------------------------------------------------------------------

---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------

====================================================================================================================================================================================================================================================================
\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/
/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\
====================================================================================================================================================================================================================================================================




					===========================================================================

					                                 MAIN MENU

					==========================================================================


					--------------------------------ADVISOR------------------------------------

					  ? --> Plan your next tour by exploring cities and their intersting spots
					  @ --> Get the detailed information of all the packages that we offer

					-------------------------------------------------------------------------


					---------------------------------GUIDER-------------------------------------

					 Select the city you are in to avail our guider facilitites
					---------------------------------------------------------------------------
					  D -->Delhi
					  M -->Mumbai
					  K -->Kolkata
					  C -->Chennai
					-------------------------------------------------------------------------

					  X -->EXIT
					-------------------------------------------------------------------------

					  Enter your choice
					  --->@

					---------------------------------------------------------------------------


====================================================================================================================================================================================================================================================================
\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/
/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\
====================================================================================================================================================================================================================================================================
====================================================================================================================================================================================================================================================================
\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/
/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\
====================================================================================================================================================================================================================================================================




					============================================================================

					                   Pick a city to view the Sponsored Packages

					==============================================================================
					  D -->Delhi
					  M -->Mumbai
					  K -->Kolkata
					  C -->Chennai
					  X -->GO BACK TO MAIN MENU

					------------------------------------------------------------------------------

					  Enter your choice
					  --->L

					INVALID INPUT!!! Kindly enter correct Option :D

					---------------------------------------------------------------------------

====================================================================================================================================================================================================================================================================
\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/
/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\
====================================================================================================================================================================================================================================================================
					=======================================================================
						           ***THE COST PER KM IS Rs.250***
						     
					\|/\|/....DILLI HINDUSTAN KI Sponsored by BALMER LAWRIE TOURS & TRAVELS ....\|/\|/
							Cost of Package: 9250.0

						Locations that will be a part of the itinerary:

					-------|-------------------------------------------------------------|-------
						          RED FORT
					-------|-------------------------------------------------------------|-------
						          GANDHI SMRITI & MAHATMA GANDHI MEMORIAL
					-------|-------------------------------------------------------------|-------
						          GURUDWARA BANGLA SAHIB
					-------|-------------------------------------------------------------|-------
						          AGRASEN KI BAOLI
					-------|-------------------------------------------------------------|-------
						          HUMAYUNâ€™S TOMB
					-------|-------------------------------------------------------------|-------
						          AKSHARDHAM MANDIR
					-------|-------------------------------------------------------------|-------
						          NATIONAL MUSEUM
					-------|-------------------------------------------------------------|-------
						          DILLI HAAT
					-------|-------------------------------------------------------------|-------
						          QUTUB MINAR
					-------|-------------------------------------------------------------|-------
						          INDIA GATE
					-------|-------------------------------------------------------------|-------

====================================================================================================================================================================================================================================================================
\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/
/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\
====================================================================================================================================================================================================================================================================
Enter 0 to return back and view other packages :1
INVALID INPUT!!! Enter 0 to return back and view other packages :0

====================================================================================================================================================================================================================================================================
\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/
/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\
====================================================================================================================================================================================================================================================================




					============================================================================

					                   Pick a city to view the Sponsored Packages

					==============================================================================
					  D -->Delhi
					  M -->Mumbai
					  K -->Kolkata
					  C -->Chennai
					  X -->GO BACK TO MAIN MENU

					------------------------------------------------------------------------------

					  Enter your choice
					  --->K

					---------------------------------------------------------------------------

====================================================================================================================================================================================================================================================================
\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/
/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\
====================================================================================================================================================================================================================================================================
					=======================================================================
						           ***THE COST PER KM IS Rs.250***
						     
					\|/\|/....KOLKATA MISHTIDOI Sponsored by WESTERN TOURS & TRAVELS ....\|/\|/
							Cost of Package: 7925.0

						Locations that will be a part of the itinerary:

					-------|-------------------------------------------------------------|-------
						          SCIENCE CITY
					-------|-------------------------------------------------------------|-------
						          BIRLA MANDIR
					-------|-------------------------------------------------------------|-------
						          INDIAN MUSEUM
					-------|-------------------------------------------------------------|-------
						          DAKSHINESHWAR KALI TEMPLE
					-------|-------------------------------------------------------------|-------
						          KALIGHAT KALI TEMPLE
					-------|-------------------------------------------------------------|-------
						          ST. PAULâ€™S CATHEDRAL
					-------|-------------------------------------------------------------|-------
						          HOWRAH BRIDGE
					-------|-------------------------------------------------------------|-------
						          JORASANKO THAKUR BAN
					-------|-------------------------------------------------------------|-------
						          BELUR MATH
					-------|-------------------------------------------------------------|-------
						          VICTORIA MEMORIAL
					-------|-------------------------------------------------------------|-------

====================================================================================================================================================================================================================================================================
\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/
/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\
====================================================================================================================================================================================================================================================================
Enter 0 to return back and view other packages :0

====================================================================================================================================================================================================================================================================
\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/
/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\
====================================================================================================================================================================================================================================================================




					============================================================================

					                   Pick a city to view the Sponsored Packages

					==============================================================================
					  D -->Delhi
					  M -->Mumbai
					  K -->Kolkata
					  C -->Chennai
					  X -->GO BACK TO MAIN MENU

					------------------------------------------------------------------------------

					  Enter your choice
					  --->X

					---------------------------------------------------------------------------


====================================================================================================================================================================================================================================================================
\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/
/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\
====================================================================================================================================================================================================================================================================




					===========================================================================

					                                 MAIN MENU

					==========================================================================


					--------------------------------ADVISOR------------------------------------

					  ? --> Plan your next tour by exploring cities and their intersting spots
					  @ --> Get the detailed information of all the packages that we offer

					-------------------------------------------------------------------------


					---------------------------------GUIDER-------------------------------------

					 Select the city you are in to avail our guider facilitites
					---------------------------------------------------------------------------
					  D -->Delhi
					  M -->Mumbai
					  K -->Kolkata
					  C -->Chennai
					-------------------------------------------------------------------------

					  X -->EXIT
					-------------------------------------------------------------------------

					  Enter your choice
					  --->D

					---------------------------------------------------------------------------

====================================================================================================================================================================================================================================================================
\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/
/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\
====================================================================================================================================================================================================================================================================




					============================================================================


					============================================================================

					                         दिल्ली
					                              ~जो है इस देश की धड़कन

					============================================================================

					                                        MENU

					==============================================================================
					  1--> Tell us your current location and get to know the shortest distance to all other spots
					  2--> Explore all the spots within the required range
					  3--> Return back to main menu

					------------------------------------------------------------------------------

					  Enter your choice
					  --->8

					INVALID INPUT!!! Kindly enter correct Option :1

					---------------------------------------------------------------------------
====================================================================================================================================================================================================================================================================
\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/
/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\
====================================================================================================================================================================================================================================================================




<:><:><:><:><:><:><:><:><:><:><:><:><:><:><:><:> THE FOLLOWING IS THE LIST OF ALL SPOTS IN DELHI <:><:><:><:><:><:><:><:><:><:><:><:><:><:><:><:><:><:>

-------|-------------------------------------------------------------|-------
                         ---> RED FORT
-------|-------------------------------------------------------------|-------
                         ---> HUMAYUNâ€™S TOMB
-------|-------------------------------------------------------------|-------
                         ---> INDIA GATE
-------|-------------------------------------------------------------|-------
                         ---> AKSHARDHAM MANDIR
-------|-------------------------------------------------------------|-------
                         ---> DILLI HAAT
-------|-------------------------------------------------------------|-------
                         ---> GANDHI SMRITI & MAHATMA GANDHI MEMORIAL
-------|-------------------------------------------------------------|-------
                         ---> GURUDWARA BANGLA SAHIB
-------|-------------------------------------------------------------|-------
                         ---> AGRASEN KI BAOLI
-------|-------------------------------------------------------------|-------
                         ---> QUTUB MINAR
-------|-------------------------------------------------------------|-------
                         ---> NATIONAL MUSEUM
-------|-------------------------------------------------------------|-------

 --->  Out of the above locations enter your location

red dt

 --->  Entered Location is INVALID !!! Kindly re-enter correct spot name.

red fort



-------|-------------------------------------------------------------|-------
          HUMAYUNâ€™S TOMB = 14.2km
-------|-------------------------------------------------------------|-------
          INDIA GATE = 11.0km
-------|-------------------------------------------------------------|-------
          AKSHARDHAM MANDIR = 12.3km
-------|-------------------------------------------------------------|-------
          DILLI HAAT = 18.3km
-------|-------------------------------------------------------------|-------
          GANDHI SMRITI & MAHATMA GANDHI MEMORIAL = 2.2km
-------|-------------------------------------------------------------|-------
          GURUDWARA BANGLA SAHIB = 7.5km
-------|-------------------------------------------------------------|-------
          AGRASEN KI BAOLI = 6.4km
-------|-------------------------------------------------------------|-------
          QUTUB MINAR = 32.3km
-------|-------------------------------------------------------------|-------
          NATIONAL MUSEUM = 9.7km
-------|-------------------------------------------------------------|-------


---------------------------------------------------------------------------------
Enter X to return to guide sub menu
c
!!!!!!!!!! INVALID INPUT !!!!!!!!!
X

====================================================================================================================================================================================================================================================================
\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/
/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\
====================================================================================================================================================================================================================================================================




					============================================================================

					                                        MENU

					==============================================================================
					  1--> Tell us your current location and get to know the shortest distance to all other spots
					  2--> Explore all the spots within the required range
					  3--> Return back to main menu

					------------------------------------------------------------------------------

					  Enter your choice
					  --->3

					---------------------------------------------------------------------------

====================================================================================================================================================================================================================================================================
\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/
/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\
====================================================================================================================================================================================================================================================================




					===========================================================================

					                                 MAIN MENU

					==========================================================================


					--------------------------------ADVISOR------------------------------------

					  ? --> Plan your next tour by exploring cities and their intersting spots
					  @ --> Get the detailed information of all the packages that we offer

					-------------------------------------------------------------------------


					---------------------------------GUIDER-------------------------------------

					 Select the city you are in to avail our guider facilitites
					---------------------------------------------------------------------------
					  D -->Delhi
					  M -->Mumbai
					  K -->Kolkata
					  C -->Chennai
					-------------------------------------------------------------------------

					  X -->EXIT
					-------------------------------------------------------------------------

					  Enter your choice
					  --->M

					---------------------------------------------------------------------------
====================================================================================================================================================================================================================================================================
\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/
/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\
====================================================================================================================================================================================================================================================================




					============================================================================

						                           मुंबई
						                                 ~जहां सृजनात्मकता ही आचरण है

					============================================================================


					============================================================================

					                                        MENU

					==============================================================================
					  1--> Tell us your current location and get to know the shortest distance to all other spots
					  2--> Explore all the spots within the required range
					  3--> Return back to main menu

					------------------------------------------------------------------------------

					  Enter your choice
					  --->2

					---------------------------------------------------------------------------

====================================================================================================================================================================================================================================================================
\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/
/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\
====================================================================================================================================================================================================================================================================




<:><:><:><:><:><:><:><:><:><:><:><:><:><:><:><:> THE FOLLOWING IS THE LIST OF ALL SPOTS IN MUMBAI <:><:><:><:><:><:><:><:><:><:><:><:><:><:><:><:><:><:>

-------|-------------------------------------------------------------|-------
                         ---> SIDDHIVINAYAK TEMPLE
-------|-------------------------------------------------------------|-------
                         ---> CHATTRAPATI SHIVAJI MAHARAJ MUSEUM
-------|-------------------------------------------------------------|-------
                         ---> JEHANGIR ART GALLERY
-------|-------------------------------------------------------------|-------
                         ---> ELEPHANTA CAVES
-------|-------------------------------------------------------------|-------
                         ---> CHOWPATTY BEACH
-------|-------------------------------------------------------------|-------
                         ---> GATEWAY OF INDIA
-------|-------------------------------------------------------------|-------
                         ---> FILM CITY
-------|-------------------------------------------------------------|-------
                         ---> JUHU BEACH
-------|-------------------------------------------------------------|-------
                         ---> MUMBADEVI MANDIR
-------|-------------------------------------------------------------|-------
                         ---> MARINE DRIVE
-------|-------------------------------------------------------------|-------

 --->  Out of the above locations enter your location

film city

--->Enter the radius within which you want to see all the places in kms
2



-------|-------------------------------------------------------------|-------

	SORRY!!!! There are no spots within the radius of 2.0 km


---------------------------------------------------------------------------------
Enter X to return to guide sub menu
X

====================================================================================================================================================================================================================================================================
\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/
/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\
====================================================================================================================================================================================================================================================================




					============================================================================

					                                        MENU

					==============================================================================
					  1--> Tell us your current location and get to know the shortest distance to all other spots
					  2--> Explore all the spots within the required range
					  3--> Return back to main menu

					------------------------------------------------------------------------------

					  Enter your choice
					  --->3

					---------------------------------------------------------------------------

====================================================================================================================================================================================================================================================================
\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/
/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\
====================================================================================================================================================================================================================================================================




					===========================================================================

					                                 MAIN MENU

					==========================================================================


					--------------------------------ADVISOR------------------------------------

					  ? --> Plan your next tour by exploring cities and their intersting spots
					  @ --> Get the detailed information of all the packages that we offer

					-------------------------------------------------------------------------


					---------------------------------GUIDER-------------------------------------

					 Select the city you are in to avail our guider facilitites
					---------------------------------------------------------------------------
					  D -->Delhi
					  M -->Mumbai
					  K -->Kolkata
					  C -->Chennai
					-------------------------------------------------------------------------

					  X -->EXIT
					-------------------------------------------------------------------------

					  Enter your choice
					  --->K

					---------------------------------------------------------------------------

====================================================================================================================================================================================================================================================================
\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/
/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\
====================================================================================================================================================================================================================================================================




					============================================================================

					                            कोलकाता
						                                ~जहां से आज़ादी की पुकार ने कई शूरवीरों को जन्मा

					============================================================================


					============================================================================

					                                        MENU

					==============================================================================
					  1--> Tell us your current location and get to know the shortest distance to all other spots
					  2--> Explore all the spots within the required range
					  3--> Return back to main menu

					------------------------------------------------------------------------------

					  Enter your choice
					  --->2

					---------------------------------------------------------------------------

====================================================================================================================================================================================================================================================================
\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/
/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\
====================================================================================================================================================================================================================================================================




<:><:><:><:><:><:><:><:><:><:><:><:><:><:><:><:> THE FOLLOWING IS THE LIST OF ALL SPOTS IN KOLKATA <:><:><:><:><:><:><:><:><:><:><:><:><:><:><:><:><:><:>

-------|-------------------------------------------------------------|-------
                         ---> ST. PAULâ€™S CATHEDRAL
-------|-------------------------------------------------------------|-------
                         ---> INDIAN MUSEUM
-------|-------------------------------------------------------------|-------
                         ---> BELUR MATH
-------|-------------------------------------------------------------|-------
                         ---> SCIENCE CITY
-------|-------------------------------------------------------------|-------
                         ---> KALIGHAT KALI TEMPLE
-------|-------------------------------------------------------------|-------
                         ---> VICTORIA MEMORIAL
-------|-------------------------------------------------------------|-------
                         ---> JORASANKO THAKUR BAN
-------|-------------------------------------------------------------|-------
                         ---> DAKSHINESHWAR KALI TEMPLE
-------|-------------------------------------------------------------|-------
                         ---> HOWRAH BRIDGE
-------|-------------------------------------------------------------|-------
                         ---> BIRLA MANDIR
-------|-------------------------------------------------------------|-------

 --->  Out of the above locations enter your location

belur math

--->Enter the radius within which you want to see all the places in kms
15



-------|-------------------------------------------------------------|-------
          ST. PAULâ€™S CATHEDRAL = 10.8km
-------|-------------------------------------------------------------|-------
          INDIAN MUSEUM = 8.9km
-------|-------------------------------------------------------------|-------
          KALIGHAT KALI TEMPLE = 13.8km
-------|-------------------------------------------------------------|-------
          VICTORIA MEMORIAL = 11.5km
-------|-------------------------------------------------------------|-------
          JORASANKO THAKUR BAN = 5.0km
-------|-------------------------------------------------------------|-------
          DAKSHINESHWAR KALI TEMPLE = 5.0km
-------|-------------------------------------------------------------|-------
          HOWRAH BRIDGE = 6.3km
-------|-------------------------------------------------------------|-------
          BIRLA MANDIR = 14.3km
-------|-------------------------------------------------------------|-------


---------------------------------------------------------------------------------
Enter X to return to guide sub menu
X

====================================================================================================================================================================================================================================================================
\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/
/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\
====================================================================================================================================================================================================================================================================




					============================================================================

					                                        MENU

					==============================================================================
					  1--> Tell us your current location and get to know the shortest distance to all other spots
					  2--> Explore all the spots within the required range
					  3--> Return back to main menu

					------------------------------------------------------------------------------

					  Enter your choice
					  --->3

					---------------------------------------------------------------------------


====================================================================================================================================================================================================================================================================
\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/
/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\
====================================================================================================================================================================================================================================================================




					===========================================================================

					                                 MAIN MENU

					==========================================================================


					--------------------------------ADVISOR------------------------------------

					  ? --> Plan your next tour by exploring cities and their intersting spots
					  @ --> Get the detailed information of all the packages that we offer

					-------------------------------------------------------------------------


					---------------------------------GUIDER-------------------------------------

					 Select the city you are in to avail our guider facilitites
					---------------------------------------------------------------------------
					  D -->Delhi
					  M -->Mumbai
					  K -->Kolkata
					  C -->Chennai
					-------------------------------------------------------------------------

					  X -->EXIT
					-------------------------------------------------------------------------

					  Enter your choice
					  --->X

					---------------------------------------------------------------------------


====================================================================================================================================================================================================================================================================
\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/
/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\
====================================================================================================================================================================================================================================================================




					============================================================================

					           SELECT YOUR FAVOURITE CITY TO GO ON OUR SPECIAL VIRTUAL TOUR

					==============================================================================
					  1 -->Delhi
					  2 -->Mumbai
					  3 -->Kolkata
					  4 -->Chennai
					  0 -->EXIT

					------------------------------------------------------------------------------

					  Enter your choice
					  --->1

====================================================================================================================================================================================================================================================================
\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/
/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\
====================================================================================================================================================================================================================================================================




						Your mini tour will start in few moments......

	                                                     >>>>> Current Stop: INDIA GATE <<<<<
				                                              |
				                                              |
				                                              |
	                                                     >>>>> Current Stop: NATIONAL MUSEUM <<<<<
				                                              |
				                                              |
				                                              |
	                                                     >>>>> Current Stop: DILLI HAAT <<<<<
				                                              |
				                                              |
				                                              |
	                                                     >>>>> Current Stop: GURUDWARA BANGLA SAHIB <<<<<
				                                              |
				                                              |
				                                              |
	                                                     >>>>> Current Stop: HUMAYUNâ€™S TOMB <<<<<
				                                              |
				                                              |
				                                              |
	                                                     >>>>> Current Stop: QUTUB MINAR <<<<<
				                                              |
				                                              |
				                                              |
	                                                     >>>>> Current Stop: RED FORT <<<<<
				                                              |
				                                              |
				                                              |
	                                                     >>>>> Current Stop: AGRASEN KI BAOLI <<<<<
				                                              |
				                                              |
				                                              |
	                                                     >>>>> Current Stop: GANDHI SMRITI & MAHATMA GANDHI MEMORIAL <<<<<
				                                              |
				                                              |
				                                              |
	                                                     >>>>> Current Stop: AKSHARDHAM MANDIR <<<<<

====================================================================================================================================================================================================================================================================
\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/\*/
/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\/*\*/
====================================================================================================================================================================================================================================================================