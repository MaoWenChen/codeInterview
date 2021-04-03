package protetype;
/**
 * 原型模式：使用原型实例指定待创建对象的类型，并且通过复制这个原型来创建新的对象。
 *	
 *	（1）Prototype(抽象原型类)：声明克隆方法的接口，是所有具体原型类的公共父类，它可是抽象类也可以是接口，甚至可以是具体实现类。
 *	（2）ConcretePrototype(具体原型类)：它实现抽象原型类中声明的克隆方法，在克隆方法中返回自己的一个克隆对象。
　　（3）Client(客户端)：在客户类中，让一个原型对象克隆自身从而创建一个新的对象。
 *
 * @author mchen
 *	java中clone方法就实现了原型设计模式
 *
 */
public class Protetype {
	public static void main(String[] args) throws CloneNotSupportedException {
		Realizetype obj1 = new Realizetype();
		Realizetype obj2 = (Realizetype) obj1.clone();
		System.out.println(obj1 == obj2);
	}

}
//java中以Cloneable接口为抽象的原型父类
//具体原型类
class Realizetype implements Cloneable{
	
	@Override
	protected Object clone() throws CloneNotSupportedException {
		return (Realizetype)super.clone();
	}
	
	
}
