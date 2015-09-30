
public class BooleanSource 
{

	
	   private double probability; // The approximate probability of query( ) returning true.
	                      
	   /**
	   * Initialize a <CODE>BooleanSource</CODE>.
	   * @param <CODE>p</CODE>
	   *   a probability
	   * <dt><b>Precondition:</b><dd>
	   *   <CODE>0 <= p</CODE> and <CODE>p <= 1</CODE>.
	   * <dt><b>Postcondition:</b><dd>
	   *   This <CODE>BooleanSource</CODE> has been initialized so that
	   *   <CODE>p</CODE> is the approximate probability of returning
	   *   <CODE>true</CODE> in any subsequent activation of the
	    *  <CODE>query</CODE> method.
	   * @exception IllegalArgumentException
	   *   Indicates that p is outside of its legal range.
	   **/
	   public BooleanSource(double p)
	   {
	       if ((p < 0) || (1 < p))
	           throw new IllegalArgumentException("Illegal p: " + p);
	       probability = p;
	   }

	   /**
	   * Get the next value from this <CODE>BooleanSource</CODE>.
	   * @param - none
	   * @return
	   *   The return value is either <CODE>true</CODE> or <CODE>false</CODE>,
	   *   with the probability of a <CODE>true</CODE> value being determined
	   *   by the argument that was given to the constructor.
	   **/   
	   public boolean query( )
	   {
	      return (Math.random( ) <= probability);
	   }
	 
	
}
