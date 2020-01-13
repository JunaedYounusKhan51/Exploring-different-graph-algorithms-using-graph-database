/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package orientdb;

import com.orientechnologies.orient.core.db.ODatabase;
import com.tinkerpop.blueprints.Edge;
import com.tinkerpop.blueprints.Vertex;
import com.tinkerpop.blueprints.impls.orient.OrientEdge;
import com.tinkerpop.blueprints.impls.orient.OrientGraph;
import com.tinkerpop.blueprints.impls.orient.OrientGraphFactory;
import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.InputStreamReader;
/**
 *
 * @author SIZARD
 */
public class Orientdb {

    /**
     * @param args the command line arguments
     */
      public static void main(String[] args) 
      { 
        // TODO code application logic here 
        
        
       
        OrientGraph graph = new OrientGraph("plocal:F:\\orientdb\\orientdb-community-2.2.20\\databases\\final_2"); 
        
/*
        //string to int convert
        
        String number = "10";
        int result = Integer.parseInt(number);
        System.out.println(result);
        
        
 */
           
         try{ 



             int i = 0;
             int j;
             Vertex temp;
             Vertex[] vers = new Vertex[1393382]; //1393362   //////max = 1393382,  need to be corrected //1393382 (got by MaxNode code)
             //for(i = 0 ; i < 1393362; i++)
             /* //1
             for(i = 0, j = 1393382 ; i <1393382; i++, j--)    
             {
                 //System.out.println("vitore ");
                 //temp = graph.addVertex(null);
                 temp = graph.addVertex("V", "9");
                 temp.setProperty("node", j);
                 System.out.println(temp.getId());
                 
                 vers[i] = temp;
             
             }
             System.out.println("add kora sesh");
             */ //1
                
            
   ///* //2
     i = 0;
     for (Vertex v : graph.getVertices()) 
     {
        vers[i] = v; 
        System.out.println(v.getId());
        i++;
     
     }  
      //2
    //*/
    
   ///* //3
    System.out.println("array remade");
             //////////////////////
              try
              {
                 // int k = 0;
                  int id1;
                  int id2;
                  String[] tokens;
                  //Vertex v1;
                 // Vertex v2;
                  OrientEdge lucaKnowsMarko1;
                    //FileInputStream fstream = new FileInputStream("road.txt");
                    DataInputStream in = new DataInputStream(new FileInputStream("algo.txt"));
                    BufferedReader br = new BufferedReader(new InputStreamReader(in));
                    String strLine;
                    while ((strLine = br.readLine()) != null)  
                    {
                        tokens = strLine.split("\t");
                        System.out.println(tokens[0] + " -> " + tokens[1]);
                        id1 = Integer.parseInt(tokens[0]);
                        id2 = Integer.parseInt(tokens[1]);
                        
                       // if(id1<1393362 && id2<1393362)
                       // {
                            //v1 = vers[id1];
                            //v2 = vers[id2];
                            lucaKnowsMarko1 = graph.addEdge(null, vers[id1],  vers[id2], "knows");
                        
                      //  }
                       // else
                       // {
                        //    k++;
                        //}
                       // System.out.println("k er value: "+k);

                    }
                    
                    in.close();
                    
            }
            catch (Exception e)
            {
                System.err.println("Error: " + e.getMessage());
            }
              
              // 3
     // */       
             ////////////////////////
             
/*
             for(i = 0 ; i <= 7; i++)
             {
                  Vertex luca = graph.addVertex(i);
                  Vertex vuca = graph.addVertex(i);// 1st OPERATION: IMPLICITLY BEGINS TRANSACTION 
                  luca.setProperty( "name", i ); 
                  vuca.setProperty("name", 2);
                  if(luca.getProperty("name") == vuca.getProperty("name"))
                  {
                     luca = vuca;
                     System.out.println("sss");
                  } ;


             }


             Vertex v1 = graph.getVertex(1);
             v1 = graph.addVertex(null);

*/

////////////////////////////////////////////////////////////////////////////////////////
             //select * from V where @rid = 9:0;

             /*

               //working part (works fine)
               Vertex luca = graph.addVertex(null); // 1st OPERATION: IMPLICITLY BEGINS TRANSACTION 
               luca.setProperty( "name", "Luca" ); 
               Vertex marko = graph.addVertex(null); 
               marko.setProperty( "name", "Marko" ); 
               OrientEdge lucaKnowsMarko1 = graph.addEdge(null, luca, marko, "knows"); 
               OrientEdge lucaKnowsMarko2 = graph.addEdge(null,  marko, luca, "knows"); 

             */  


             graph.commit(); 
             System.out.println("12");

         } 
         catch( Exception e ) 
         { 
           
                 System.out.println("excptn");
         }

     } 
    
    
}
