package net.mithunmathew.codingpractice.multithreading;

class MultithreadingRunnableExample implements Runnable{
	
	public void run() {
		try {
			System.out.println("Currently running thread is " + Thread.currentThread().toString());
		}
		catch(Exception e) {
			System.out.print("Exception caught in thread " + Thread.currentThread().getId());
		}
	}
	
}

public class MultithreadingRunnable {
	
	public static void main(String args[]) {
		int n = 10;
		for(int i=0; i<n; i++) {
			Thread obj = new Thread(new MultithreadingRunnableExample());
			obj.start();
		}
	}

}
