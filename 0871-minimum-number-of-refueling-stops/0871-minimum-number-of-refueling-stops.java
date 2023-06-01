class Solution {
    public int minRefuelStops(int target, int startFuel, int[][] stations) {
       //GOAL: keep the farthest distance while taking the most fuel
        //want max fuel first
        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b)->(b-a));
        
       // Two variables are initialized: xCurrent represents the current position of the vehicle (initialized with startFuel), and numberStops keeps track of the number of refueling stops made.
        int xCurrent = startFuel;
        int numberStops=0;
 //The code then iterates through each station in the stations array using a for-each loop. For each station, it retrieves the station's position (xStation) and the amount of fuel it provides (fuelX).       
        for(int[] station: stations)
        {
            int xStation = station[0];
            int fuelX = station[1];
            //The code enters a while loop, which continues as long as the current position (xCurrent) is less than the position of the current station (xStation). This loop aims to refuel the vehicle at the most suitable fuel stations to reach the current station.
            while(xCurrent<xStation)
            {
                //Within the while loop, it first checks if the priority queue pq is empty. If it is, it means that no fuel stations are available to reach the current station, so the function returns -1 (indicating that it's impossible to reach the target distance).
             if(pq.isEmpty()) return -1;
                //If pq is not empty, it retrieves the maximum fuel capacity from the priority queue using pq.poll() and assigns it to the variable maxFuel. The current position is then increased by the amount of fuel obtained, xCurrent += maxFuel, and the number of stops is incremented (numberStops++).
             int maxFuel = pq.poll();
             xCurrent+=maxFuel;
             numberStops++;
            }
            //Once the while loop finishes, it means that the current position has reached or exceeded the position of the current station. The code then adds the fuel capacity of the current station to the priority queue using pq.offer(fuelX).
           pq.offer(fuelX);
        }
        //After iterating through all the stations, there might still be a remaining distance to reach the target. Thus, the code enters another while loop that continues as long as the current position (xCurrent) is less than the target distance.
        while(xCurrent<target){
            if(pq.isEmpty()) return -1;
             int maxFuel = pq.poll();
             xCurrent+=maxFuel;
             numberStops++;
        }
       // Finally, when the while loop ends, the function returns the total number of stops made (numberStops).


        return numberStops;
    }
}