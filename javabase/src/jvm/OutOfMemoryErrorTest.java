package jvm;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

public class OutOfMemoryErrorTest {

	static class HeapOOM{
		private BigInteger bigInteger = new BigInteger("100000");
	}
	public static void main(String[] args) {
		try {
			int i = 3/0;
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		System.out.println("执行");
	}
}
