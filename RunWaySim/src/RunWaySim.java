import java.util.Scanner;

public class RunWaySim {

	public static void main(String[] args)
	{
		Scanner kb = new Scanner(System.in);
		
		System.out.println("Enter the amount of time needed for a plane to land");
		int planeLandTime = kb.nextInt();
		
		System.out.println("Enter the amount of time needed for a plane to tkae off");
		int planeTakeOffTime = kb.nextInt();
		
		System.out.println("Enter the average time between arrival of planes to landing queue");
		int averageTimeLandQueue = kb.nextInt();
		
		System.out.println("Enter the average time between departure of planes to the departure queue");
		int averageTimeDepartQueue = kb.nextInt();
		
		System.out.println("Enter the maximum amount of time a plane can stay in the landing queue");
		int maxTimeInAir = kb.nextInt();
		
		System.out.println("Enter total length of time to simulate");
		int simTime = kb.nextInt();
		
	}
}
