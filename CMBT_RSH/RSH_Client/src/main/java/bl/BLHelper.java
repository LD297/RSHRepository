package bl;

import java.util.Date;
import java.util.Random;

/**
 * for something needed in the bl
 * @author aa
 *
 */
public class BLHelper {
	
	static String passwordBase = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789_";
	
	public static String getRandom(int length){
		Random random = new Random();
		StringBuffer stringBuffer = new StringBuffer();
		for(int i=0;i<length;i++){
			int num = random.nextInt(63);
			stringBuffer.append(passwordBase.charAt(num));
		}
		return stringBuffer.toString();
	}

	public static void main(String args[]){
		System.out.println(0x80000000);
	}
	
	public static int getDifferenceSeconds(Date before,Date after){
		long difference = after.getTime()-before.getTime();
		difference=difference/1000;
		return (int)difference;
	}
}
