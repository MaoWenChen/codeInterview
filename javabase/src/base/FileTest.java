package base;

import java.io.File;
import java.net.MalformedURLException;
import java.util.Calendar;

public class FileTest {

	public static void main(String[] args) throws MalformedURLException {
		Calendar calendar = Calendar.getInstance();
		System.out.println(calendar.get(Calendar.MONTH));
	}

	public static void test() throws MalformedURLException {

		File file = new File("D:\\tat.bin");
		System.out.println(file.toURI());
		System.out.println(file.toURL());
		System.out.println(file.toPath());
	}
}
