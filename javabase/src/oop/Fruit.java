package oop;

import java.lang.ref.WeakReference;
import java.math.BigDecimal;

public class Fruit {
	 int prices;
	 int weight;
	 String name;
	public Fruit() {}
	public Fruit(int prices, int weight, String name) {
		this.name = name;
		this.prices = prices;
		this.weight = weight;
	}
	public static void main(String[] args) throws InterruptedException {
		WeakReference<Fruit> fruit = null;
		for(int i = 0 ;i <100;i++) {
			 fruit= new WeakReference<Fruit>(new Apple());
		}
		Fruit s = fruit.get();
		s = null;
		System.gc();
		System.gc();
		Thread.sleep(3000);
		System.out.println(fruit.get());
		System.out.println(dos("ssss"));
		
	}
	public static <E> E dos( E e){
		return e;
	}

}

class Apple extends Fruit {
	 String color;
	public Apple() {
		super();
	}
	public Apple(int prices, int weight, String name, String color) {
		super(prices,weight,name);
		this.color = color;
	}
}

