package net.mithunmathew.codingpractice;

abstract class SuperClass{
	
	SuperClass(){
		
		System.out.println("SuperClass object created");
		
	}

	public abstract void display();

}

class Base extends SuperClass{
	
	Base(){
		
		System.out.println("Base object created");
		
	}
	
	public void display() {
		
		System.out.println("I am Base class method");
		
	}
}

class Derived extends Base{
	
	Derived(){
		
		System.out.println("Derived object created");
		
	}
	
	public void display() {
		
		System.out.println("I am Derived class method");
		
	}
}

public class JavaMethodOverridingCheck {
	
	public static void main(String args[]) {
		
		System.out.println("[main()]: Start\n");

		System.out.println("Base obj1 = new Base()");
		Base obj1 = new Base();
		obj1.display();
		System.out.println("End obj1\n");
		
		System.out.println("Base obj2 = new Derived();");
		Base obj2 = new Derived();
		obj2.display();
		System.out.println("End obj2\n");
		
		System.out.println("Derived obj3 = new Derived();");
		Derived obj3 = new Derived();
		obj3.display();
		System.out.println("End obj3\n");
		
		System.out.println("SuperClass obj4 = new Derived();");
		SuperClass obj4 = new Derived();
		obj4.display();
		System.out.println("End obj4\n");
		
		System.out.println("[main()]: End\n");
	}
}

