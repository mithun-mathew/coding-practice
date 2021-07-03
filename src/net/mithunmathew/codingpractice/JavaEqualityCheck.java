package net.mithunmathew.codingpractice;

class Sample{
	
	String description;
	
	Sample(){
		
		System.out.println("\n[Constructor Sample()]: Start");
		description = "Sample";
		System.out.println("[Constructor Sample()]: End\n");
		
	}
	
	public void display() {
		
		System.out.println("\n[Sample.display()]: Start");
		System.out.println("description is " + description);
		System.out.println("[Sample.display()]: End\n");
		
	}
	
}

public class JavaEqualityCheck {
	
	public static void main(String args[]) {
		
		System.out.println("[main()]: Start");
		Sample obj1 = new Sample();
		System.out.println("Calling obj1.display()");
		obj1.display();
		System.out.println("Returned from obj1.display()\n");
		
		Sample obj2 = new Sample();
		System.out.println("Calling obj2.display()");
		obj2.display();
		System.out.println("Returned from obj2.display()\n");
		
		if(obj1.equals(obj1)) {
			System.out.println("obj1.equals(obj1): True\n");
		}
		else {
			System.out.println("obj1.equals(obj1): False\n");
		}
		
		if(obj1 == obj1) {
			System.out.println("obj1 == obj1: True\n");
		}
		else {
			System.out.println("obj1 == obj1: False\n");
		}
		
		if(obj1.equals(obj2)) {
			System.out.println("obj1.equals(obj2): True\n");
		}
		else {
			System.out.println("obj1.equals(obj2): False\n");
		}
		
		if(obj1 == obj2) {
			System.out.println("obj1 == obj2: True\n");
		}
		else {
			System.out.println("obj1 == obj2: False\n");
		}
		
		System.out.println("[main()]: End\n");
	}
}
