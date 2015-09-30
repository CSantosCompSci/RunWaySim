
public class Runway 
{
	private int seconds_For_Landing; // Seconds for a single wash
	private int seconds_For_TakeOff;
	private int landTimeLeft ;   // Seconds until this runway is no longer busy with a landng
	private int takeOffTimeLeft; //Seconds until this runway isn't busy with a take off

	                      

	public Runway(int landingTime, int takeOffTime)
	{
		seconds_For_Landing = landingTime;
		seconds_For_TakeOff = takeOffTime;
	    landTimeLeft =0;
	    takeOffTimeLeft = 0;
	}


	   /**
	   * Determine whether this washer is currently busy.
	   * @param - none
	   * @return
	   *   <CODE>true</CODE> if this washer is busy (in a wash cycle);
	   *   otherwise <CODE>false</CODE>
	   **/   
	public boolean isBusyWithLanding( )
	{
	    return (landTimeLeft > 0);
	}
	public boolean isBusyWithTakeOff()
	{
		return (takeOffTimeLeft > 0);
	}
	
	public void reduceRemainingTime()
	{
		if (takeOffTimeLeft > 0)
			takeOffTimeLeft--;
		if (landTimeLeft > 0)
			landTimeLeft--;
	}
	
	 public void startLanding( )
	 {
		 if (landTimeLeft > 0)
			 throw new IllegalStateException("Runway is already busy.");
	      landTimeLeft = seconds_For_Landing;
	 }
	   
	 public void startTakeoff( )
	 {
		 if (takeOffTimeLeft > 0)
			 throw new IllegalStateException("Runway is already busy.");
	     takeOffTimeLeft = seconds_For_TakeOff;
	 }
}  

