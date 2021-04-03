package base;

import oop.EumnTest;
import oop.Fruit;
import oop.Person;

import java.io.Externalizable;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;

public class SerializerTest extends SupperTest implements Serializable{
	
	
	public static void main(String[] args) throws FileNotFoundException, IOException, ClassNotFoundException {
		SerializerTest test = new SerializerTest("陈果果", 18, "666", EumnTest.TEST);
		test.setFruit(new Fruit(12, 12, "苹果"));
		test.setPerson(new Person(22, "广州", "广东"));
		ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("D:\\cdev\\object.dat"));
		out.writeObject(test);
		System.out.println(test.toString());
		ObjectInputStream in = new ObjectInputStream(new FileInputStream("D:\\cdev\\object.dat"));
		SerializerTest test1 = (SerializerTest) in.readObject();
		System.out.println(test1.toString());
		System.out.println(test == test1);
		System.out.println(test.getEumnTest() == test1.getEumnTest());
		System.out.println(test.getSupperName());
		System.out.println(test1.getSupperName());
	}

	private String name;
	private Integer age;
	private transient String test;
	private EumnTest eumnTest;
	
	private transient Fruit fruit;
	
	private Person person;
	
	public Fruit getFruit() {
		return fruit;
	}

	public void setFruit(Fruit fruit) {
		this.fruit = fruit;
	}

	public Person getPerson() {
		return person;
	}

	public void setPerson(Person person) {
		this.person = person;
	}

	public SerializerTest(String name,Integer age,String test,EumnTest eumnTest) {
		super(test);
		this.name = name;
		this.age = age;
		this.test = test;
		this.eumnTest = eumnTest;
	}

	public EumnTest getEumnTest() {
		return eumnTest;
	}

	public void setEumnTest(EumnTest eumnTest) {
		this.eumnTest = eumnTest;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public String getTest() {
		return test;
	}

	public void setTest(String test) {
		this.test = test;
	}
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("name:").append(name)
		.append(",age:").append(age)
		.append(",test:").append(test)
		.append(",fruit:{").append(fruit!=null?true:false)
		.append("},person:{").append(person!=null?true:false).append("}");
		return sb.toString();
	}
	
}
