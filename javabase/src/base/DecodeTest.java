package base;

public class DecodeTest {
	
	public static void main(String[] args) {
		testDecode();
	}

	
	public static void testDecode() {
		//decode方法可以解析十六进制，八进制，二进制,有小数会报错
		
		System.out.println(Integer.decode("12"));
		System.out.println(Integer.decode("0X12"));
		System.out.println(Integer.decode("012"));
		System.out.println(Integer.decode("#12"));
		try {
			//valueof解析小数会报错调用parseint解析十进制
			Integer.valueOf("12.11");
		} catch (Exception e) {
			System.out.println("解析错误");
		}
	}
}
