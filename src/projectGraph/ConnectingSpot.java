package projectGraph;

/*_________________CLASS TO STORE DETAILS OF A SPOT. OBJECTS OF THIS CLASS BECOME NODES FOR THE GRAPH _________________*/
public class ConnectingSpot {
    String destination;                                                           //variable to store name of spot
	double km;                                                                     //variable to store its distance from another spot
                    //Parameterized Constructor to define spot details
	ConnectingSpot(String destination,double km)
	{
		this.destination=destination;
		this.km=km;
	}
}
/*______________________________CONNECTINGSPOT CLASS ENDS HERE______________________________*/