import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class RunWaySim {

	public static void main(String[] args)
	{
		Scanner kb = new Scanner(System.in);
		
		System.out.println("Amount of minutes to land:");
		int planeLandTime = kb.nextInt();
		
		System.out.println("Amount of minutes to take off : ");
		int planeTakeOffTime = kb.nextInt();
		
		System.out.println("Probability of arrival during a minute:");
		double averageTimeLandQueue = kb.nextDouble();
		
		System.out.println("Enter the average time between departure of planes to the departure queue");
		double averageTimeDepartQueue = kb.nextDouble();
		
		System.out.println("Enter the maximum amount of time a plane can stay in the landing queue");
		int maxTimeInAir = kb.nextInt();
		
		System.out.println("Enter total length of time to simulate");
		int simTime = kb.nextInt();
		
		runWaySimulate(planeLandTime,planeTakeOffTime,maxTimeInAir,averageTimeLandQueue, averageTimeDepartQueue, simTime);
	}
	
	 public static void runWaySimulate(int landTime, int takeOffTime, int maxFlightTime, double landingProb, double takeOffProb,int totalTime)
	   {
	      Queue<Integer> landingTimes = new LinkedList<Integer>(); 
	      Queue<Integer> departureTimes = new LinkedList<Integer>();
	      int nextLanding;
	      int nextTakeOff;
	      BooleanSource landing = new BooleanSource(landingProb);
	      BooleanSource takeOff = new BooleanSource(takeOffProb);
	      Runway runway = new Runway(landTime,takeOffTime);
	      Averager landTimes = new Averager( );
	      Averager takeOffTimes = new Averager();
	      int currentSecond;
	      int planesCrashed = 0;
	  
	      // Write the parameters to System.out.
	      System.out.println("Seconds for a plane to land: " + landTime);
	      System.out.println("Seconds for a plane to takeoff: " + takeOffTime);
	      System.out.println("Seconds plane can stay in the air: " + maxFlightTime);
	      System.out.println("Probability of of plane arrival to runway for landing: " + landingProb);
	      System.out.println("Probability of plane arrival to runway for takeoff: " + takeOffProb);
	      System.out.println("Total simulation seconds: " + totalTime); 
	   
	      // Check the precondition:
	      if (landTime <= 0 || takeOffTime <= 0 || maxFlightTime < 0 || landingProb >1 || takeOffProb > 1 || totalTime < 0)
	         throw new IllegalArgumentException("Values out of range"); 

	      for (currentSecond = 0; currentSecond < totalTime; currentSecond++)
	      {  // Simulate the passage of one second of time.

	         // Check whether a new customer has arrived.
	         if (landing.query( ))
	           landingTimes.add(currentSecond);
	         if(takeOff.query())
	        	 departureTimes.add(currentSecond);
	  
	         // Check whether the runway is busy and queues are not empty.
	         if ((!runway.isBusyWithLanding( ) && !runway.isBusyWithTakeOff()))
	         {
	        	 if(!landingTimes.isEmpty())
	        	 {
	        		nextLanding = landingTimes.remove( );
	        		if(currentSecond - nextLanding < maxFlightTime)
	        		{
	        			 landTimes.addNumber(currentSecond - nextLanding);
	        			 runway.startLanding();
	        		} 
	        		else
	        		{
	        			planesCrashed++; 
	        		}
	        	 }
	        	
	        	if(!departureTimes.isEmpty() && (landingTimes.isEmpty()))
	        	{
	        		nextTakeOff = departureTimes.remove();
	        	 	takeOffTimes.addNumber(currentSecond - nextTakeOff);
	        	 	runway.startTakeoff();
	        	}
	         }
	         runway.reduceRemainingTime();
	      }

	      // Write the summary information about the simulation.
	      System.out.println("The number of planes that landed: " + landTimes.howManyNumbers( ));
	      if (landTimes.howManyNumbers( ) > 0)
	         System.out.println("Average wait: " + landTimes.average( ) + " minutes");
	      System.out.println("The number of planes that took off: " + takeOffTimes.howManyNumbers( ));
	      if (takeOffTimes.howManyNumbers( ) > 0)
		         System.out.println("Average wait: " + takeOffTimes.average( ) + " minutes");
	      System.out.println("The total number of planes that crashed are :" + planesCrashed);
	   }
	    
	
}
