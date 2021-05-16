package net.mithunmathew.codingpractice;

class Graph{
	int V, E;
	Edge edge[];
	
	Graph(int v, int e){
		this.V = v;
		this.E = e;
		this.edge = new Edge[e];
		for(int i=0; i<e; i++) {
			this.edge[i] = new Edge();
		}
	}
}

class Edge{
	int src, dst;
}

class Subset{
	int parent;
	int rank;
}

public class UnionFind {
	
	public static void unionNaive(int parent[], int v1, int v2) {
		int g1 = findNaive(parent, v1);
		int g2 = findNaive(parent, v2);
		parent[g1] = g2;
	}
	
	public static int findNaive(int parent[], int v) {
		if(parent[v] == -1) {
			return v;
		}
		return findNaive(parent, parent[v]);
	}
	
	// O(n) in worst case
	public static boolean unionFindNaive(Graph graph) {
		int parent[] = new int[graph.V];
		for(int i=0; i<graph.V; i++) {
			parent[i] = -1;
		}
		
		for(int i=0; i< graph.E; i++) {
			if(findNaive(parent, graph.edge[i].src) == findNaive(parent, graph.edge[i].dst)) {
				return true;
			}
			
			unionNaive(parent, graph.edge[i].src, graph.edge[i].dst);
		}
		return false;
	}
	
	public static void union(Subset subset[], int v1, int v2) {
		int g1 = find(subset, v1);
		int g2 = find(subset, v2);
		
		if(subset[g1].rank < subset[g2].rank) {
			subset[g1].parent = g2;
		}
		else if(subset[g1].rank > subset[g2].rank) {
			subset[g2].parent = g1;
		}
		else {
			subset[g1].parent = g2;
			subset[g2].rank++;
		}
	}
	
	public static int find(Subset subset[], int v) {
		if(subset[v].parent == -1) {
			return v;
		}
		subset[v].parent = find(subset, subset[v].parent);
		return subset[v].parent;
	}
	
	// O(log n)	
	public static boolean unionFind(Graph graph) {
		Subset subset[] = new Subset[graph.V];
		for(int i=0; i<graph.V; i++) {
			subset[i] = new Subset();
			subset[i].parent = -1;
			subset[i].rank = 0;
		}
		
		for(int i=0; i<graph.E; i++) {
			if(find(subset,graph.edge[i].src) == find(subset,graph.edge[i].dst)) {
				return true;
			}
			union(subset, graph.edge[i].src, graph.edge[i].dst);
		}
		return false;
	}
	
	public static void main(String args[]) {
		int V=3, E=3;
		Graph graph = new Graph(V, E);
		
		graph.edge[0].src = 0;
		graph.edge[0].dst = 1;
		
		graph.edge[1].src = 1;
		graph.edge[1].dst = 2;
		
		graph.edge[2].src = 0;
		graph.edge[2].dst = 2;
		
		if(unionFindNaive(graph)) {
			System.out.println("[unionFindNaive] Graph has cycle");
		}
		else {
			System.out.println("[unionFindNaive] Graph doesn't have cycle");
		}
		
		if(unionFind(graph)) {
			System.out.println("[unionFind] Graph has cycle");
		}
		else {
			System.out.println("[unionFind] Graph doesn't have cycle");
		}
	}
}
