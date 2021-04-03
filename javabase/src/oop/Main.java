package oop;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.List;
import java.util.Random;

public class Main {

	public static void main(String[] args) throws FileNotFoundException, IOException, ClassNotFoundException {
		System.out.println(Integer.toBinaryString(72));
		System.out.println(Integer.toBinaryString(-72));
		System.out.println(Float.toHexString(10F));
		System.out.println(Float.floatToIntBits(Float.MAX_VALUE-1));
		System.out.println(Integer.toHexString(Float.floatToIntBits(Float.MAX_VALUE)));
		System.out.println(Float.MAX_VALUE);
		
		System.out.println(Integer.toBinaryString(Float.floatToIntBits(1)));
		System.out.println(Integer.toBinaryString(Float.floatToIntBits(-0.1f)));
		Random r = new Random();
		System.out.println(r.nextInt());
		boolean b = true;
		System.out.println(b&false);
		char c ='陈';
		c = (char) (c-1);
		System.out.println(c);
		float f = Long.MAX_VALUE;
		double d = Long.MAX_VALUE;
		System.out.printf("%20f\n",f);
		System.out.printf("%20G\n",d);
		System.out.println(Long.MAX_VALUE);
	}
    public int superpalindromesInRange(String L, String R) {
        long l = Long.parseLong(L);
        long r = Long.parseLong(R);
        long lt = (long) Math.sqrt(l);
        long rt =(long) Math.sqrt(r)+1;
        int sum =0;
        for(long i = lt;i<=rt;i++) {
        	if (judge(i)&&judge(i*i)) {
				sum++;
			}
        }
        return sum;
    }
    public final boolean judge(long l) {
    	char[] c =  String.valueOf(l).toCharArray();
    	for(int i = 0,length=c.length>>1;i<length;i++) {
    		if (c[i]!=c[c.length-i-1]) {
				return false;
			}
    	}
    	return true;
    }

}
