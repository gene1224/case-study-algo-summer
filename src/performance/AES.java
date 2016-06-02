package performance;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Date;
import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;


public class AES {
	public long encrypt(String plainText)
			throws Exception {
		Cipher cipher = Cipher.getInstance("AES");
		SecretKey key = KeyGenerator.getInstance("AES").generateKey();
		cipher.init(Cipher.ENCRYPT_MODE, key);
		Date start = new Date();
		cipher.doFinal(plainText.getBytes());
		Date end = new Date();
		return end.getTime() - start.getTime();
	}
	
	public static void main(String[] args) {
		AES aes = new AES();
		System.out.println("Advance Encryption Standards");
		String text = "";
		try (BufferedReader br = new BufferedReader(new FileReader(
				"/home/rangrang/Desktop/Accidents0514.csv"))) {
			System.out.println("--Start Reading--");
			String sCurrentLine;
			int x = 0;
			StringBuilder sb = new StringBuilder();
			String line = br.readLine();
			while (line != null) {
				sb.append(line);
				sb.append(System.lineSeparator());
				line = br.readLine();
			}
			text = sb.toString();

			System.out.println("--Done Reading--");
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		try {
			for (int x = 1; x < 6; x++) {
				System.out.println("Test No. : " + x);
				System.out.println("--Start Encrypt--");
				System.out.println("Execution Time : "
						+ aes.encrypt(text) + "ms");
				System.out.println("--Done Encrypt--");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	
}