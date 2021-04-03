package observer;

import java.util.ArrayList;
import java.util.List;

/**
 * 观察设计模式
 *  定义对象间的一种一对多的依赖关系，当一个对象的状态发生改变时，所有依赖于它的对象都得到通知并被自动更新。
 *  
 *  4种重要的角色
 * 	1 	抽象被观察者角色：也就是一个抽象主题，它把所有对观察者对象的引用保存在一个集合中，每个主题都可以有任意数量的观察者。抽象主题提供一个接口，可以增加和删除观察者角色。一般用一个抽象类和接口来实现。
	2	抽象观察者角色：为所有的具体观察者定义一个接口，在得到主题通知时更新自己。
	3	具体被观察者角色：也就是一个具体的主题，在集体主题的内部状态改变时，所有登记过的观察者发出通知。
	4	具体观察者角色：实现抽象观察者角色所需要的更新接口，一边使本身的状态与制图的状态相协调。
 *  
 * @author Mchen
 *
 *spring中Observer模式常用的地方是listener的实现。如ApplicationListener。 
 */
public class Observers {

}
/**
 *	抽象的呗观察者
 *	声明了添加,删除,通知观察者方法 
 *
 */
interface Observerable{
	//添加观察者
	void registerObserver(Observer observer);
	//移除观察者
	void removeObserver(Observer observer);
	//状态改变通知观察者
	void notifyObserver();
}

/**
 * 	抽象的观察者
 *	定义了一个update()方法,当被观察者调用notifyObserver()方法时,回调观察者的方法. 
 */
interface Observer{
	
	void update(String message);
	
}
/**
 * 	被观察者的具体实现类, (类似微信公众号)
 * 	实现Observer接口
 */
class WechatServer implements Observerable{
	
	private List<Observer> list = new ArrayList<Observer>();
	private String message;
	@Override
	public void registerObserver(Observer observer) {
		list.add(observer);
		
	}
	@Override
	public void removeObserver(Observer observer) {
		list.remove(observer);
		
	}
	@Override
	public void notifyObserver() {
		
		for(Observer observer: list) {
			observer.update(message);
		}
	}
	
	public void setMessage(String message) {
		this.message = message;
		notifyObserver();
	}
	
}
/**
 * 观察者的具体实现类
 */
class User implements Observer{
	
	private String name;
	private String message;
	
	public  User(String name) {
		this.name = name;
	}
	
	@Override
	public void update(String message) {
		this.message = message;
		//等到通知后执行相关的操作
		read();
	}
	
	private void read() {
		System.out.println(message);
	}
}