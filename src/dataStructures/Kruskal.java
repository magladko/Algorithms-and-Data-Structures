// Java program for Kruskal's algorithm to
// find Minimum Spanning Tree of a given
//connected, undirected and  weighted graph
package dataStructures;

import java.util.*;

class Graph {
	
	public ArrayList<int[]> addOrder = new ArrayList<int[]>();

    // A class to represent a graph edge
    class Edge implements Comparable<Edge>
    {
        int src, dest, weight;
 
        // Comparator function used for
        // sorting edgesbased on their weight
        public int compareTo(Edge compareEdge)
        {
            return this.weight - compareEdge.weight;
        }
    };
 
    // A class to represent a subset for
    // union-find
    class subset
    {
        int parent, rank;
    };
 
    int V, E; // V-> no. of vertices & E->no.of edges
    Edge edge[]; // collection of all edges
 
    // Creates a graph with V vertices and E edges
    Graph(int v, int e)
    {
        V = v;
        E = e;
        edge = new Edge[E];
        for (int i = 0; i < e; ++i)
            edge[i] = new Edge();
    }
 
    // A utility function to find set of an
    // element i (uses path compression technique)
    int find(subset subsets[], int i)
    {
        // find root and make root as parent of i
        // (path compression)
        if (subsets[i].parent != i)
            subsets[i].parent
                = find(subsets, subsets[i].parent);
 
        return subsets[i].parent;
    }
 
    // A function that does union of two sets
    // of x and y (uses union by rank)
    void Union(subset subsets[], int x, int y)
    {
        int xroot = find(subsets, x);
        int yroot = find(subsets, y);
 
        // Attach smaller rank tree under root
        // of high rank tree (Union by Rank)
        if (subsets[xroot].rank
            < subsets[yroot].rank)
            subsets[xroot].parent = yroot;
        else if (subsets[xroot].rank
                 > subsets[yroot].rank)
            subsets[yroot].parent = xroot;
 
        // If ranks are same, then make one as
        // root and increment its rank by one
        else {
            subsets[yroot].parent = xroot;
            subsets[xroot].rank++;
        }
    }
 
    // The main function to construct MST using Kruskal's
    // algorithm
    void KruskalMST()
    {
		  int discardedInConst = 0;

        // Tnis will store the resultant MST
        Edge result[] = new Edge[V];
       
        // An index variable, used for result[]
        int e = 0;
       
        // An index variable, used for sorted edges
        int i = 0;
        for (i = 0; i < V; ++i)
            result[i] = new Edge();
 
        // Step 1:  Sort all the edges in non-decreasing
        // order of their weight.  If we are not allowed to
        // change the given graph, we can create a copy of
        // array of edges
        Arrays.sort(edge, new Comparator<Edge>() {
			  public int compare(Edge e1, Edge e2) {

				  if (e1.weight == e2.weight){

					  int a = Integer.parseInt(e1.src + "" + e1.dest);
					  int b = Integer.parseInt(e2.src + "" + e2.dest);

					  return Integer.compare(a, b);

				  } else {
					  return Integer.compare(e1.weight, e2.weight);
				  }

			  }
		  });
 
        // Allocate memory for creating V subsets
        subset subsets[] = new subset[V];
        for (i = 0; i < V; ++i)
            subsets[i] = new subset();
 
        // Create V subsets with single elements
        for (int v = 0; v < V; ++v)
        {
            subsets[v].parent = v;
            subsets[v].rank = 0;
        }
 
        i = 0; // Index used to pick next edge
 
        // Number of edges to be taken is equal to V-1
        while (e < V - 1)
        {
            // Step 2: Pick the smallest edge. And increment
            // the index for next iteration
            Edge next_edge = edge[i++];
 
            int x = find(subsets, next_edge.src);
            int y = find(subsets, next_edge.dest);
 
            // If including this edge does't cause cycle,
            // include it in result and increment the index
            // of result for next edge
            if (x != y) {
                result[e++] = next_edge;
                Union(subsets, x, y);
					 System.out.println(String.format("ADD (%s,%s) - %s", next_edge.src, next_edge.dest, next_edge.weight));
            } else {
					 System.out.println(String.format("DISC (%s,%s) - %s", next_edge.src, next_edge.dest, next_edge.weight));
					discardedInConst++;
				}
            // Else discard the next_edge
        }
		  int discardedAftConst = 0;
		  System.out.println("- END CONST -");
		  int e2 = e+1;
		  while (e2 < edge.length){
			  System.out.println(String.format("DISC (%s,%s) - %s", edge[e2].src, edge[e2].dest, edge[e2].weight));
			  e2++;
			  discardedAftConst++;
		  }

			// total edges - non-discarded - discarded in construction
		 

        // print the contents of result[] to display
        // the built MST
        System.out.println("Following are the edges in "
                           + "the constructed MST");
        int minimumCost = 0;
        for (i = 0; i < e; ++i)
        {
			  	addOrder.add(new int[] {result[i].src, result[i].dest});
            System.out.println(result[i].src + " -- "
                               + result[i].dest
                               + " == " + result[i].weight);
            minimumCost += result[i].weight;
        }
        System.out.println("COST: "
                           + minimumCost);
		  System.out.println("DISC IN CONST: "
		  							+ discardedInConst);
			System.out.println("DISC AFT CONST: "
									+ discardedAftConst);
			System.out.println("NOT DISCARDED: "
									+ e);
    }

	 public void printAddOrder(){

		 System.out.print("ADD ORD: {");
		 
		 for (int[] edgePair : addOrder) {

			 int x = edgePair[0];
			 int y = edgePair[1];

			 if (x > y) {
				 int tmp = y;
				 y = x;
				 x = tmp;
			 }

			 System.out.print(String.format("(%s,%s), ", x, y));
		 }

		 System.out.println("\b\b}");

	 }

	 void addEdges(int[][] edgeTable){

		 int i = 0;
		 for (int[] relation : edgeTable){
			 int from = relation[0];
			 int to = relation[1];
			 int weight = relation[2];

			 this.edge[i].src = from;
			 this.edge[i].dest = to;
			 this.edge[i].weight = weight;
			 i++;
		 }

	 }
 
    // Driver Code
    public static void main(String[] args)
    {
	
		 /*
		int[][] edges = new int[][] {
			// {from, to, wgt}
			{0, 7, 2},
			{1, 6, 2},
			{3, 6, 3},
			{4, 5, 3},
			{5, 6, 3},
			{0, 1, 4},
			{0, 5, 4},
			{1, 5, 4},
			{6, 7, 4},
			{3, 7, 4},
			{2, 6, 5},
			{4, 7, 5},
			{2, 6, 5},
		};
		*/

		
		int[][] edges = new int[][] {
			// {from, to, wgt}
			{0,1,5},
			{0,2,2},
			{1,3,2},
			{1,5,2},
			{1,6,4},
			{2,5,1},
			{2,3,1},
			{2,7,5},
			{3,6,3},
			{3,4,2},
			{3,7,1},
			{4,5,4},
			{4,6,4},
			{4,7,4},
			{5,6,1},
			{6,7,4}
		};
		
 
        int V = 8; // Number of vertices in graph
        int E = edges.length; // Number of edges in graph
        Graph graph = new Graph(V, E);
 
        // add edges
		  graph.addEdges(edges);

        // Function call
        graph.KruskalMST();

		  graph.printAddOrder();
    }
}
// This code is contributed by Aakash Hasija