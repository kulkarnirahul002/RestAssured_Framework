package GenericUtils;

import java.util.Random;

public class JavaUtility {
	/**
	 * Below method generates a Random Number for multiple data.
	 * @author Rahul
	 * @return
	 */
	
	public int getRandomNumber() {
		
		Random ran=new Random();
		int random=ran.nextInt(1000);
		return random;
	}

}
