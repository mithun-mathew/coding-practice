/*
 * Stock prices - [90, 80, 60, 75, 60, 70, 120]
 * ans			- [ 1,  1,  1,  2,  1,  3,   7]    
 */

package net.mithunmathew.codingpractice;

import java.util.ArrayList;

class NodeStockPrice{
	NodeStockPrice left;
	NodeStockPrice right;
	int value;
	int lesser;
	int equal;
	
	NodeStockPrice(int value){
		this.value = value;
		this.lesser = 0;
		this.equal = 1;
	}
}

public class StockPricesLesserTillNow {
	
	public static int insertNode(NodeStockPrice root, int val) {
		
		int currLesser = 0;		
		while(true) {
			
			if(val == root.value) {
				root.equal++;
				return currLesser + root.lesser + 1;
			}
			else if(val < root.value) {
				root.lesser++;
				if(root.left != null) {
					root = root.left;
				}
				else {
					root.left = new NodeStockPrice(val);
					return currLesser + 1;
				}
			}
			else {
				currLesser += root.lesser + root.equal;
				if(root.right != null) {
					root = root.right;
				}
				else {
					root.right = new NodeStockPrice(val);
					return currLesser + 1;
				}
			}
		}
		
	}
	
	public static ArrayList<Integer> countLesser(int[] prices){
		
		ArrayList<Integer> result = new ArrayList<Integer>();
		NodeStockPrice root = new NodeStockPrice(prices[0]);
		result.add(1);
		for(int i= 1; i<prices.length; i++) {
			result.add(insertNode(root, prices[i]));
		}
		return result;
		
	}
	
	public static void main(String args[]) {
		
		int[] prices = {90, 80, 60, 75, 60, 70, 120};
		ArrayList<Integer> result = countLesser(prices);
		System.out.println(result);
		
	}

}
