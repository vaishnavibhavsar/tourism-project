package projectGraph;

public class Spot {
	String spotName;	//stores name of the spot
	String cityName;	//stores name of the city
	String info;		//stores name of file
	Spot lc;			//reference of class Spot to store left child
	Spot rc;			//reference of class Spot to store right child
	int h;
	Spot()			//default Constructor	
	{
		spotName="";
		cityName="";
		info="";
		lc=null;
		rc=null;
		h=0;
	}
	Spot(String spotName, String cityName ,String info) //parametrized Constructor
	{
		this.spotName=spotName;
		this.cityName=cityName;
		this.info=info;
		lc=null;
		rc=null;
		h=0;
	}
}
  