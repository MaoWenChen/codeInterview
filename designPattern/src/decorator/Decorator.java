package decorator;

/**
 * 包装设计模式 
 * 
 * 包装设计模式主要有如下五个步骤：
 * 
 * ① 自定义一个类，实现与目标对象(被增强对象)相同的接口。
 * 
 * ② 在自定义的类中定义一个成员变量，来记住(指向)目标对象。
 * 
 * ③ 定义一个构造函数，用来接收目标对象。
 * 
 * ④ 覆盖想增强或改写的方法。
 * 
 * ⑤ 对于其他不想增强或改写的方法，使用刚才记住目标对象的成员变量来一一调用目标对象的方法即可。
 * 
 * @author mchen
 * 
 * 	通常增强某个对象方法的方式有三种：
 * 
 *	       ⑴ 使用子类继承某个实现类；
 * 
 * 	       ⑵ 使用包装设计模式；
 * 
 *   	⑶ 使用动态代理。
 * 
 * spring中用到的包装器模式在类名上有两种表现：一种是类名中含有Wrapper，
 * 另一种是类名中含有Decorator。基本上都是动态地给一个对象添加一些额外的职责。
 *
 */
//包装设计模式的类
public class Decorator implements Connection{
	Connection con = null;
	public Decorator(Connection con) {
		this.con = con;
	}
	//增强或者改写方法 注意(对不增强的方法可以调用原来的类的方法)
	@Override
	public void con() {
		System.out.println(con);
	}

}

interface Connection{
	void con();
}


