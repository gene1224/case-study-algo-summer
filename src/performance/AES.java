package performance;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Date;
import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;

public class AES {
	public long total = 0;

	public byte[] encrypt(String plainText) throws Exception {
		Cipher cipher = Cipher.getInstance("AES");
		SecretKey key = KeyGenerator.getInstance("AES").generateKey();
		cipher.init(Cipher.ENCRYPT_MODE, key);
		Date start = new Date();
		byte[] encryptedt_text = cipher.doFinal(plainText.getBytes());
		Date end = new Date();
		long time = end.getTime() - start.getTime();
		System.out.println("Execution Time : " + time + "ms");
		total += time;
		return encryptedt_text;
	}

	public static void main(String[] args) {
		AES aes = new AES();
		System.out.println("##### Advance Encryption Standards ######");
		System.out.println("##### --        Group - 1       -- ######");
		System.out.println("#####     **Algorithm Testing**    ######");
		String text = "";
		// if in windows Please Place your data set on C: then change
		// "/home/rangrang/.." to "C:\"
		try (BufferedReader br = new BufferedReader(new FileReader(
				"/home/rangrang/Desktop/msnbc990928.seq"))) {
			System.out.println("--Start Reading--");
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
				System.out.println("\t ### -- Start Encrypt -- ###");
				aes.encrypt(text);
				System.out.println("\t ### -- Done Encrypt -- ###");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("Average Execution : " + (aes.total / 5));
		System.out.println("#####    **  Execution  Done **    ######");
		System.out.println("##### --   Sescon, Torres, Ong  -- ######");
		System.out.println("#####            Serentas          ######");
	}
}