package tms.bird.practice;

import java.util.Random;

public class GenerateRandomNumber {

	public static void main(String[] args) {
		
/*		Random random = new Random();
		int ran = random.nextInt(1000);
		System.out.println(ran);
*/

		int random = new Random().nextInt(1000);
		System.out.println(random);
		
//		long ran = new Faker().number().randomNumber(3,false);
//		System.out.println(ran);
		
		
	}

}
