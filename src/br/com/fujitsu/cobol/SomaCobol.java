package br.com.fujitsu.cobol;

import com.sun.jna.Memory;
import com.sun.jna.Native;
import com.sun.jna.Pointer;

public class SomaCobol {

	public int chamaLibCobol(String param1, String param2) {
		/*
		try {
			libcob.INSTANCE.cob_init(0, null);
		} catch (UnsatisfiedLinkError e) {
			System.out.println("Libcob Exception" + e);
		}
		*/

		try {
			String stringThing1 = new String(param1);

			Pointer pointer1;
			pointer1 = new Memory(9);
			byte space1 = 32;
			pointer1.setMemory(0, 9, space1);

			byte[] data1 = Native.toByteArray(stringThing1);
			pointer1.write(0, data1, 0, data1.length - 1);

			String stringThing2 = new String(param2);
			Pointer pointer2;
			pointer2 = new Memory(9);
			byte space2 = 32;
			pointer2.setMemory(0, 9, space2);

			byte[] data2 = Native.toByteArray(stringThing2);
			pointer2.write(0, data2, 0, data2.length - 1);
			
			Pointer pointer3;
			pointer3 = new Memory(9);
			byte space3 = 32;
			pointer3.setMemory(0, 9, space3);

			return cobsoma.INSTANCE.SOMA(pointer1, pointer2, pointer3);
		} catch (UnsatisfiedLinkError e) {
			System.out.println("Exception" + e);
		}catch (Exception e) {
			System.out.println("Exception" + e);
		}
		return 0;
	}
}
