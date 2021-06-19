package net.mithunmathew.codingpractice;

import java.util.LinkedList;

public class DFS_GraphAdjacencyList {
	
	private int V;
	private LinkedList<Integer> adj[];
	
	@SuppressWarnings("unchecked")
	DFS_GraphAdjacencyList(int v){
		this.V = v;
		adj = new LinkedList[v];
		for(int i=0; i<v; i++) {
			adj[i] = new LinkedList<Integer>();
		}
	}
	
	void insertEdge(int x, int y) {
		adj[x].add(y);
	}
	
	public void DFSUtility(boolean[] visited, int node) {
		visited[node] =true;
		
		System.out.print(" -> " +node);
		
		for(int i : adj[node]) {
			if(visited[i] == false) {
				DFSUtility(visited, i);
			}
		}
	}
	
	public void DFS() {
		boolean[] visited = new boolean[V];
		
		System.out.print("Start");
		for(int i=0; i<V; i++) {
			if(visited[i] == false) {
				DFSUtility(visited, i);
			}
		}
		System.out.println();
	}
	
	public static void main(String args[]) {
		
		DFS_GraphAdjacencyList g = new DFS_GraphAdjacencyList(4);
		
		g.insertEdge(0, 1);
		g.insertEdge(0, 2);
		g.insertEdge(1, 2);
		g.insertEdge(2, 0);
		g.insertEdge(2, 3);
		g.insertEdge(3, 3);
		
		g.DFS();
	}
}
