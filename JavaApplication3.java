/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication3;
//import com.tinkerpop.blueprints.impls.orient.OrientGraph;

import com.tinkerpop.blueprints.Direction;
import com.tinkerpop.blueprints.Edge;
import com.tinkerpop.blueprints.Vertex;
import com.tinkerpop.blueprints.impls.orient.OrientEdge;
import com.tinkerpop.blueprints.impls.orient.OrientGraph;
import com.tinkerpop.blueprints.impls.orient.OrientVertex;
//import com.tinkerpop.blueprints.oupls.jung.GraphJung;
//mport edu.uci.ics.jung.algorithms.scoring.PageRank;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 *
 * @author User
 */
public class JavaApplication3 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        OrientGraph graph = new OrientGraph("remote:localhost/final_2");
        //ShortestPath path=new ShortestPath();
        //Vertex[] vers = new Vertex[1393382];
        
        System.out.println(" enter 1 for DFS or enter 2 for BFS");
        System.out.println("");
        Scanner in = new Scanner(System.in);
        int choice = in.nextInt();
        
        if(choice == 1)
        {
            int[][] edge_matrix = new int[12000][12000];
        
            System.out.println(edge_matrix[3][3]);

            int i = 0;
            //Edge[] edges = new Edge[4000000];

            for(Edge e: graph.getEdges())
            {
                Vertex v1,v2;
                v1 = e.getVertex(Direction.IN);
                v2 = e.getVertex(Direction.OUT);
                if((int)v1.getProperty("node") < 10000 &&(int) v2.getProperty("node") < 10000)
                {
                    edge_matrix[v1.getProperty("node")][v2.getProperty("node")] = 1;
                }    
                //edges[i] = e;



                System.out.println(e.getId());
            }
        
            DFS dfs = new DFS();
            dfs.dfs(edge_matrix, 1);  //(graph, source)	
        
        
        }
        
        else if( choice == 2)
        {
            Graph_bfs g = new Graph_bfs(12000);
 
            
            for(Edge e: graph.getEdges())
            {
                Vertex v1,v2;
                v1 = e.getVertex(Direction.IN);
                v2 = e.getVertex(Direction.OUT);
                g.addEdge((int)v1.getProperty("node"), (int)v2.getProperty("node"));
                //[v1.getProperty("node")][v2.getProperty("node")]


                System.out.println(e.getId());
            }
 
       
 
            g.BFS(0); // (source node)
        
        }
        
        
        graph.shutdown();
        }
    
}
