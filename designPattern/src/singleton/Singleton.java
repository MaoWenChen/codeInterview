package singleton;
/**
 * 单例模式	保证一个类只有一个实例
 * 
 * @author 单例模式
 * 
 *spring中默认创建的bean都是单例模式
 */
public class Singleton {

}

//饿汗模式
class Hungry {

	private static Hungry instance = new Hungry();
	private Hungry() {
	}
	public static Hungry getInstance() {
		return instance;
	}
}
//懒汉模式有并发安全问题
class Lazy {
	private static Lazy instance = null;
	private Lazy() {}
	
	public static Lazy getInstance() {
		if (instance == null) {
			instance = new Lazy();
		}
		return instance;
	}
}
//懒汉模式的双标记法

class LazySafety{
	private static LazySafety instance = null;
	private LazySafety() {}
	public static LazySafety getInstance() {
		if (instance!=null) {
			
		}else {
			synchronized (LazySafety.class) {
				if (instance==null) {
					instance = new LazySafety();
				}
			}
		}
		return instance;
	}
}
