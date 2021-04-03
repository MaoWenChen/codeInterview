package adapter;

/**
 * 适配器模式：将一个类的接口转换成客户希望的另一个接口。适配器模式让那些接口不兼容的类可以一起工作
 * Spring aop中采用适配器模式将advice转换成interceptor 对象适配器
 * Spring mvc中handleAdaptor查找处理器
 * @author mchen
 *
 *适配器模式分两种，类适配器和对象适配器。先讲类适配器，类适配器把适配的类的API转换成目标类的API，类适配器所涉及的角色有：

1、目标角色

这是所期待得到的接口

2、源角色

现在需要适配的接口

3、适配器角色

模式的核心，适配器把源接口转换成目标接口
 */
public class Adaptor {

}

/**
 * 类适配器
 * 
1、客户端期待一个接口ClassTarget有sampleOperation1()和sampleOperation2()这两个方法
2、现在我一个类ClassAdaptee里面只有一个sampleOperation1()方法
3、既然ClassTarget要两个方法，我现在的ClassAdaptee只有一个方法怎么办？搞一个适配器，多变出一个sampleOperation2()，
   就符合ClassTarget的标准了，由于适配器是ClassTarget接口的实现类，所以可以直接使用适配器作为ClassTarget
 */
class ClassAdaptor extends ClassAdaptee implements ClassTarget{

	@Override
	public void sampleOperation2() {
		
	}
	
}
/**
 * 目标角色
 */
interface ClassTarget{
	//这是源类ClassAdaptee也有的方法
	public void sampleOperation();
	//这是源类ClasssAdaptee没有的方法
	public void sampleOperation2();
}
/**
 * 源角色
 */
class ClassAdaptee{
	public void sampleOperation() {}
}

/////////////////////////////////////////////////////////对象适配器模式
//目标接口期待两个方法
interface ObjectTarget{
	void sampleOperation1();
	void sampleOperation2();
}
//源角色只有一个方法
class ObjectAdaptee{
	void sampleOperation1() {}
}

//对象适配器,对象适配器采用委派关系将源角色与适配器角色关联起来
class ObjectAdaptor{
	//维持一个源对象
	private ObjectAdaptee objectAdaptee;
	
	public void sampleOperation1() {
		this.objectAdaptee.sampleOperation1();
	}
	
	public void sampleOperation2() {}
}

