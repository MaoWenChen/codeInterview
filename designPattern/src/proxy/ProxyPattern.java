package proxy;

import java.lang.reflect.Proxy;

/**
 * 
 * 代理模式为其他对象提供一种代理以控制对这个对象的访问。
 * 从结构上来看和装饰模式类似，但Proxy是控制，更像是一种对功能的限制，而Decorator是增加职责。
 * spring的Proxy模式在aop中有体现，比如JdkDynamicAopProxy和Cglib2AopProxy。
 * @author mchen
 * 代理模式的分类
 * 1> 静态代理模式
 * 2> 动态代理模式
 * 		2.1>jdk代理
 * 		2.2>cglib代理
 */

//静态代理类
public class ProxyPattern {
	public static void main(String[] args) {
		ProxyTarget proxyTarget = new ProxyTarget(new Target());
		proxyTarget.save();
		//jdk代理
		iUser user =(iUser) Proxy.newProxyInstance(ProxyTarget.class.getClassLoader(), new Class[] {iUser.class}, new JDKProxyObject(new Target()));
		user.save();
	}
}

interface iUser{
	 void save();
}
//目标类
class Target implements iUser{

	@Override
	public void save() {
		System.out.println("目标对象的显示");
	}
	 
}
//代理类
class ProxyTarget implements iUser{
	private Target target;
	public ProxyTarget(Target target) {
		this.target = target;
	}
	@Override
	public void save() {
		//增强类的作用
		System.out.println("静态代理");
		target.save();
		
	}
	
}
