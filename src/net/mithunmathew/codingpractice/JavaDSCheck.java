package net.mithunmathew.codingpractice;

import java.util.ArrayList;

public class JavaDSCheck {
	
	@SuppressWarnings("deprecation")
	public static void main(String args[]) {
		
		String src = "Source";
		String dest = src + "abc";
		
		System.out.println("src = " + src);
		System.out.println("dest = " + dest);
		
		System.out.println();
		
		ArrayList<Integer> list = new ArrayList<Integer>();
		list.add(1);
		list.add(2);
		list.add(3);
		list.add(4);
		list.add(5);
		
		System.out.println(list);
		list.remove(1);
		System.out.println(list);
		list.remove(new Integer(1));
		System.out.println(list);
	}

}
