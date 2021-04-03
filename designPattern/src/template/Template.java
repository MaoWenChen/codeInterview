package template;

/**
 * 模板设计模式  : 定义一个操作中算法的骨架，而将一些步骤延迟到子类中，模板方法使得子类可以不改变算法的结构即可重定义该算法的某些特定步骤。
 * 　 通俗点的理解就是 ：完成一件事情，有固定的数个步骤，但是每个步骤根据对象的不同，而实现细节不同；就可以在父类中定义一个完成该事情的总方法，按照完成事件需要的步骤去调用其每个步骤的实现方法。每个步骤的具体实现，由子类完成。
 * @author mchen
 *         java中java.util.concurrent.locks.AbstractQueuedSynchronizer就是采用的模板设计模式
 *         jdbcTemplate 就使用了模板设计模式来规定了jdbc的特定的操作步骤
 *	 优点
 *	（1）具体细节步骤实现定义在子类中，子类定义详细处理算法是不会改变算法整体结构。

　	（2）代码复用的基本技术，在数据库设计中尤为重要。

　	（3）存在一种反向的控制结构，通过一个父类调用其子类的操作，通过子类对父类进行扩展增加新的行为，符合“开闭原则”。

	不足
    	每个不同的实现都需要定义一个子类，会导致类的个数增加，系统更加庞大。
 *
 */
public class Template {

}

abstract class AbstractTemplate{
	//模板方法 设置固定的步骤
	public void templateMethod() {
		abstractMethod();
		hookMethod();
		concreteMethod();
	}
	//基本方法的声明 (由子类实现)
	protected abstract void abstractMethod();
	
	//基本方法(空方法,可由子类实现)
	protected  void hookMethod() {}
	
	//基本方法 (已经实现)
	private final void concreteMethod() {
		//实现相关的业务代码
	}
	
}
class ConcreteTemplate extends AbstractTemplate{
	
	//基本方法的实现
	@Override
	protected void abstractMethod() {
		
		//实现相关的业务代码
	}
	@Override
	public void hookMethod() {
		//实现相关的业务代码
	}
	
}




