package projectGraph;

import java.util.Comparator;

/*______________________________CLASS TO CUSTOMISE PRIORITY QUEUE BASED ON EDGE WEIGHT PREFERENCES______________________________*/
class DistanceComparator implements Comparator<ConnectingSpot>{
            // Overriding compare()method of Comparator 
    /*------------- Function to have ascending order of edge distances in the queue-------------*/
            public int compare(ConnectingSpot s1, ConnectingSpot s2) {
                //If first location is more distanced as compared to second location
                if (s1.km>=s2.km)
                    return 1;
                //If second location is more distanced as compared to first location
                else if (s1.km < s2.km)
                    return -1;
                    return 0;
                }//end of function
}
/*______________________________DISTANCECOMPARATOR CLASS ENDS HERE______________________________*/

