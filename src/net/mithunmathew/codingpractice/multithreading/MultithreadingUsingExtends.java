package net.mithunmathew.codingpractice.multithreading;

class MultithreadingExample extends Thread {
	
	public void run() {
		try {
			System.out.println("Currently running thread is " + Thread.currentThread().toString());
		}
		catch(Exception e) {
			System.out.print("Exception caught in thread " + Thread.currentThread().getId());
		}
	}
	
}

public class MultithreadingUsingExtends{
	
	public static void main(String args[]) {
		int n = 10;
		for(int i=0; i<n; i++) {
			MultithreadingExample obj = new MultithreadingExample();
			obj.start();
		}
	}
	
}
