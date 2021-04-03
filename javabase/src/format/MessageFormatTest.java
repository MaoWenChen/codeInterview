package format;

import java.text.ChoiceFormat;
import java.text.MessageFormat;
import java.text.ParseException;
import java.text.ParsePosition;
import java.util.Date;

public class MessageFormatTest {

	public static void main(String[] args) throws ParseException {
		test3();
	}

	public static void test() {
		int planet = 7;
		String event = "a disturbance in the Force";
		String result = MessageFormat.format("At {1,time} ont {1,date}, there was {2} on planet {0,number,integer}.",
				planet, new Date(), event);
		System.out.println(result);
	}

	public static void test1() {
		int fileCount = 1273;
		String diskName = "myDisk";
		Object[] testArgs = {new Long(fileCount),diskName};
		MessageFormat form = new MessageFormat("The disk \"{1}\" contains {0} file(s). ") ;
		System.out.println(form.format(testArgs));
	}
	
	public static void test2() {
		MessageFormat form = new MessageFormat("The disk \"{1}\" contains {0}.");
		double[]  filelimits = {0,1,2};
		String[] filepart = {"no files","one file","{0,number} files"};
		ChoiceFormat fileFormat = new ChoiceFormat(filelimits, filepart);
		form.setFormatByArgumentIndex(0, fileFormat);
		
		int fileCount = 1273;
		String diskName = "MyDisk";
		Object[] testArgs = {new Long(fileCount),diskName};
		
		System.out.println(form.format(testArgs));
	}
	public static void test3() throws ParseException {
		MessageFormat mf = new MessageFormat("{0},{0},{0}");
		String forParsing = "x,y,z";
		Object[] objs = mf.parse(forParsing, new ParsePosition(0));
				 objs = mf.parse(forParsing);
		System.out.println(objs);
	}
}
