package factory;

/**
 * 工厂方法 工厂方法模式是完全符合开闭原则的
 * 一般情况下,应用程序有自己的工厂对象来创建bean.如果将应用程序自己的工厂对象交给Spring管理,那么Spring管理的就不是普通的bean,而是工厂Bean。
 * 
 * @author mchen
 *
 *
 */
public class FactoryMethod {

}

//抽象工厂
abstract class AbstractCarFactory {

	public abstract Car createCar(String car);
}
//具体工厂

class BenzCarFactory extends AbstractCarFactory {

	@Override
	public Car createCar(String car) {

		return new Benz();
	}

}

class BmwCarFactory extends AbstractCarFactory {

	@Override
	public Car createCar(String car) {

		return new Bmw();
	}

}