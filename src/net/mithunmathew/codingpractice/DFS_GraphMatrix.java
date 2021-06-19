package net.mithunmathew.codingpractice;

public class DFS_GraphMatrix {
	
	public static void DFSUtility(int[][] graph, boolean[] visited, int node) {
		visited[node] =true;
		int V = graph.length;
		
		System.out.print(" -> " +node);
		
		for(int i=0; i<V; i++) {
			if(visited[graph[node][i]] == false) {
				DFSUtility(graph, visited, i);
			}
		}
	}
	
	public static void DFS(int[][] graph) {
		int V = graph.length;
		boolean[] visited = new boolean[V];
		
		System.out.print("Start");
		for(int i=0; i<V; i++) {
			if(visited[i] == false) {
				DFSUtility(graph, visited, i);
			}
		}
		System.out.println();
	}
	
	public static void main(String args[]) {
		int graph[][] = {
						{0,1,1,0},
						{0,0,1,0},
						{1,0,0,1},
						{0,0,0,1}
				};
		DFS(graph);
	}
}
