package oop;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class Person implements Serializable{
	public int age;
	private String name;
	String address;
	A a;
	public Person(int age, String address, String name) {
		this.age = age;
		this.name = name;
		this.address = address;
	}
	public static void main(String[] args) throws FileNotFoundException, IOException, ClassNotFoundException {
		ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream(new File("E:\\test.txt")));
		Person person = new Person(1, "北极", "陈茂");
		outputStream.writeObject(person);
		ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream(new File("E:\\test.txt")));
		System.out.println(inputStream.readObject());
		outputStream.close();
		inputStream.close();
	}
	@Override
	public String toString() {
		StringBuffer stringBuffer = new StringBuffer();
		stringBuffer.append("姓名:").append(name).append("\n");
		stringBuffer.append("年龄:").append(age).append("\n");
		stringBuffer.append("地址:").append(address).append("\n");
		stringBuffer.append(a.a);
		return stringBuffer.toString();
	}
}
class A{
	int a =3;
}
class Student extends Person{

	public Student(int age, String address, String name, String teacher, String peer) {
		super(age, address, name);
		this.teacher = teacher;
		this.peer = peer;
	}
	private String teacher;
	public String peer;
	
	@Override
	public String toString() {
		StringBuffer stringBuffer = new StringBuffer();
		stringBuffer.append(super.toString());
		stringBuffer.append("老师:").append(teacher).append("\n");
		stringBuffer.append("同学:").append(peer).append("\n");
		return stringBuffer.toString();
	}
}
