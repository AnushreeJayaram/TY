package tms.bird.practice;

import java.util.Base64;

public class EncyptAndDecrypt {

	public static void main(String[] args) 
	{
//		use this website https://base64.guru/converter -> to convert
		String encryptData="YWRtaW4=";   // admin-> YWRtaW4=
		byte[] byteA = encryptData.getBytes();
		byte[] byteB = Base64.getDecoder().decode(byteA);

		String s = new String(byteB);
		
		System.out.println(s);
	}

}
