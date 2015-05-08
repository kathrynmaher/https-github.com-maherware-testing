//tollbooth
public class tollbooth{

	//Create private data here
   public int carThrough;
   public int tollProfit;


	/** construct a tollbooth object.
	 *  at this point there have been 0 cars and 0 dollars
	 *  have been collected.
	 **/
	public tollbooth() {
      carThrough = 0;
      tollProfit = 0;

	}

	/** Accesses the number of cars that have
	 *  passed through our tollbooth
	 *  @return the number of cars that have come
	 *  through the tollbooth
	 **/
	public int numCars(){
      return carThrough;

	}

	/**Accesses the ammount of money collected by the tollbooth
	 * @return the ammount of money collected
	 **/
	public double moneyCollected(){
      return tollProfit;

	}

	/** A car passes through the tollbooth and state variables are
	 *  updated accordingly.
	 **/
	public void addCar( ){
      tollProfit = tollProfit + 100;
      carThrough = carThrough + 1;

	}
}
