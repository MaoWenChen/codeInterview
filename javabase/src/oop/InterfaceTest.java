package oop;

import java.io.IOException;
import java.nio.CharBuffer;
import java.util.Random;
import java.util.Scanner;

public class InterfaceTest {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(new RandomWords());
		if (scanner.hasNext()) {
			System.out.println(scanner.next());
			
		}
		new ImplTest();
		
	}
}

class RandomWords implements Readable{

	@Override
	public int read(CharBuffer cb) throws IOException {
		for (int i = 0; i < 3; i++) {
			cb.append(i+",");
		}
		cb.append(" ");
		return 7;
	}
	
}

interface i11{
	Random RAND = new Random();
	int RANDOM_INT =RAND.nextInt();
	
   void	f();
}
interface i22{
	void f();
}

interface i3 {
	int f();
}

class ImplTest implements i11,i22{
	boolean flag = true;
	int i = init();

	int init() {
		return 1;
	}
	@Override
	public void f() {
		System.out.println("no prebloms");
	}
	
}
/*class ImplTest1 implements i1,i3{
	编译错误
	@Override
	public void f() {
	
	}
	
}*/

interface testi11{//接口中嵌套接口只能有两种访问权限
	interface t1{}
	public interface t2{}
}
class Testi1{//类中嵌套接口可以有四种访问权限
	interface t11{}
	public interface t22{}
	private interface t33{}
	protected interface t44{}
}