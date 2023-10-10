package Graphs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Graphs{
/*
GRAPH:
    Vertices: All individual nodes called vertices.
    Edges: Connections between vertices called edges.
    All trees are graph but graphs are not.

    SOME TERMINOLOGY:
        Adjacent Vertices: those vertices which have common edge.
        Degree: Number of edges connect with one vertices.
        Connected Graph: vertices connect with every vertices with any path.
        Spaning tree: Minimum number of path to reach vertices called spaning tree.
        Complete Graph: vertices connect with other with common edges.
        Number of edge in tree is n-1 and in complete graph n(n-1)/2 where n is number of vertices.
*/

// Create a function for Depth First Traversal mean findout all neighbours of neighours and come back:
    public static void dfTraversal(int adjMatrix[][]){
        boolean visited[] = new boolean[adjMatrix.length];
        dfTraversal(adjMatrix, 0,visited);
    }
    public static void dfTraversal(int adjMatrix[][],int currentVertex, boolean visited[]){
        visited[currentVertex] = true;
        System.out.print(currentVertex + " ");
        for(int i =0; i<adjMatrix.length; i++){
            if(adjMatrix[currentVertex][i] == 1 && visited[i]==false){
                // i is neighbor of currentVertex
                dfTraversal(adjMatrix,i,visited);
            }
        }
    }

// Create a function for Breadth First Travesal. Its exactly same as levelwise input in tree:
    public static void bfTraversal(int adjMatrix[][]){
        Queue<Integer> pendingVertices = new LinkedList<>();
        boolean visited[] = new boolean[adjMatrix.length];
        visited[0] = true;
        pendingVertices.add(0);
        while(!pendingVertices.isEmpty()){
            int currentVertex = pendingVertices.poll();
            System.out.print(currentVertex + "");
            for(int i=0; i< adjMatrix.length;i++){
                if(adjMatrix[currentVertex][i] == 1 && !visited[i]){
                    pendingVertices.add(i);
                    visited[i] = true;
                }
            }
        }
    }

// Create a function for shorest path for given start and ending node with the help pf BFTraversal:
    public static ArrayList<Integer> getPathBFS(int adjMatrix[][], int s, int e){
        Queue<Integer> pendingVertices = new LinkedList<>();
        HashMap<Integer, Integer> map = new HashMap<>();
        boolean visited[] = new  boolean[adjMatrix.length];
        visited[s] = true;
        pendingVertices.add(s);
        map.put(s, -1);
        boolean pathFound = false;

        while(! pendingVertices.isEmpty()){
            int currentVertex = pendingVertices.poll();
            for(int i =0; i<adjMatrix.length; i++){
                if(adjMatrix[currentVertex][i] == 1 && !visited[i]){
                    pendingVertices.add(i);
                    visited[i] = true;
                    map.put(i, currentVertex);
                    if(i == e){
                        pathFound = true;
                        break;
                    }
                }
            }
        }

        if(pathFound){
            ArrayList<Integer> path = new ArrayList<>();
            int currentVertex =e;
            while(){
                path.add(currentVertex);
                int parent = map.get(currentVertex);
                currentVertex = parent;
            }return path;
        }
        else{
            return null;
        }
    } 

public static void main(String[] args) {
    // We are creating a 2D array for represent vertices connect to which vertices.
    Scanner s = new Scanner(System.in);
    int n = s.nextInt(); // no. of vertics
    int e = s.nextInt(); // no. of edges
    int adjMatrix[][] = new int[n][n];
    for(int i = 0; i<e; i++){
        int v1 = s.nextInt();
        int v2 = s.nextInt();
        adjMatrix[v1][v2] = 1;
        adjMatrix[v2][v1] = 1;
    }

    /*for(int i = 0; i<n; i++){
        for(int j = 0; j<n; j++){
            System.out.print(adjMatrix[i][j]+" ");
        }
        System.out.println();
    } */

    // print all types od graph:
    boolean visited[] = new boolean[adjMatrix.length];
    for(int i = 0; i < adjMatrix.length ;  i++){
        if(! visited[i]){
            dfTraversal(adjMatrix, i , visited);
        }
    }
}
}