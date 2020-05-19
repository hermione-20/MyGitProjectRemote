package cn.itcastma.reflect;

public class student {
	public String name="张三";
	private int age;
	public student() {
		System.out.println("无参构造方法");
	}
	public student(String name) {
		System.out.println("姓名:"+name);
	}
	private student(int age) {
		System.out.println("年龄:"+age);
	}
	student(String name,int age) {
		System.out.println("姓名:"+name+"年龄:"+age);
	}
	
	public void m1() {
		System.out.println("m1");
	}
	public void m2(String name) {
		System.out.println(name);
	}
	public String m3(String name) {
		return name;
	}
	private void m4(int age) {
		System.out.println(age);
	}
	public static void m5(String name,int age) {
		System.out.println(name+","+age);
	}
	public static void m6(String[] args) {
		for (int i = 0; i < args.length; i++) {	
			System.out.println(args[i]);
		}
		
	}
}
