package beans;

import java.beans.BeanInfo;
import java.beans.EventSetDescriptor;
import java.beans.IntrospectionException;
import java.beans.Introspector;
import java.beans.MethodDescriptor;
import java.beans.PropertyDescriptor;
import java.lang.reflect.Method;

public class IntrospectorTest {

	public static void main(String[] args) {
		test(TestBean.class);
	}
	
	public static void test(Class<?> clazz) {
		BeanInfo bi = null;
		try {
			bi = Introspector.getBeanInfo(clazz, Object.class);
		} catch (IntrospectionException e) {
			System.out.println(clazz.getName());
			return;
		}
		for(PropertyDescriptor d:bi.getPropertyDescriptors()) {
			Class<?> p = d.getPropertyType();
			if (p == null) {
				continue;
			}
			System.out.printf("属性名称:%1$s,属性类型:%2$s;\n",d.getName(),p.getName());
			System.out.printf("属性的read方法:%s,属性的writer方法:%s\n", d.getReadMethod().getName(),d.getWriteMethod().getName());			
		}
		for(MethodDescriptor m: bi.getMethodDescriptors()) {
			System.out.println(m.getName());
		}
		for(EventSetDescriptor e:bi.getEventSetDescriptors()) {
			System.out.println("ListenerType : "+e.getName());
			for(Method m:e.getListenerMethods()) {
				System.out.println("Listener Method:"+m.getName());
			}
			for(MethodDescriptor md:e.getListenerMethodDescriptors()) {
				System.out.println("Method Descriptor"+md.getMethod());
				System.out.println("Add Listener Method:"+e.getAddListenerMethod());
				System.out.println("remove Listener Method:"+e.getRemoveListenerMethod());
			}
		}
		
	}
}
