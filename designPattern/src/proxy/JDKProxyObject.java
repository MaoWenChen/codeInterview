package proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class JDKProxyObject implements InvocationHandler{

	private Target target = null;
	public JDKProxyObject(Target target) {
		this.target = target;
	}
	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		//增强一些行为
		System.out.println("JDK代理");
		method.invoke(target, args);
		return target;
	}

}
