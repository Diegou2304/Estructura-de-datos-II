/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package grafoslistasadyacencia;

import java.util.Scanner;

/**
 *
 * @author Diego U
 */
public class GrafosListasAdyacencia {

      public static GrafoL grafo=new GrafoL();
  
    private static Scanner scanner = new Scanner( System.in );
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        System.out.println("Introduzca la cantidad de vertices:");
        int input = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < input; i++) 
        {
            grafo.CrearVertice();
            
        }
        grafo.InsertarArco(0, 5);
        grafo.InsertarArco(0, 1);
        grafo.InsertarArco(1, 5);
        grafo.InsertarArco(1, 4);
        grafo.InsertarArco(1, 3);
        grafo.InsertarArco(2, 3);
        grafo.DFS(0);
       System.out.println("\n");
       grafo.BFS(0);
    }
    
}
