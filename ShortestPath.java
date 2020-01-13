/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication3;

/**
 *
 * @author User
 */
public class ShortestPath {
    static int V;
    int minDistance(int dist[], Boolean sptSet[])
    {
        
        int min = Integer.MAX_VALUE, min_index=-1;
 
        for (int v = 0; v < V; v++)
            if (sptSet[v] == false && dist[v] <= min)
            {
                min = dist[v];
                min_index = v;
            }
 
        return min_index;
    }
 
    
    void printSolution(int dist[], int n,String str[])
    {
        System.out.println("Vertex   Distance from Source");
        for (int i = 0; i < V; i++)
        {
            if(str[i]!="0")
            {
                if(dist[i]!=Integer.MAX_VALUE)System.out.println(str[i]+" -- "+dist[i]);
                else System.out.println(str[i]+" -- No path");
            }
        }
            
    }
 
    
    void dijkstra(int graph[][], int src,String [] str)
    {
        int dist[] = new int[V]; 
        Boolean sptSet[] = new Boolean[V];
 
        
        for (int i = 0; i < V; i++)
        {
            dist[i] = Integer.MAX_VALUE;
            sptSet[i] = false;
        }
 
        // Distance of source vertex from itself is always 0
        dist[src] = 0;
 
        // Find shortest path for all vertices
        for (int count = 0; count < V-1; count++)
        {
            // Pick the minimum distance vertex from the set of vertices
            // not yet processed. u is always equal to src in first
            // iteration.
            int u = minDistance(dist, sptSet);
 
            // Mark the picked vertex as processed
            sptSet[u] = true;
 
            
            for (int v = 0; v < V; v++)  
            {
                
                if (!sptSet[v] && graph[u][v]!=0 &&
                        dist[u] != Integer.MAX_VALUE &&
                        dist[u]+graph[u][v] < dist[v])
                    dist[v] = dist[u] + graph[u][v];
            }
        }
 
        // print the constructed distance array
        printSolution(dist, V,str);
    }
}
