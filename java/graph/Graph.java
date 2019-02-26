/*
 * Methods:
 * nearestNeighborTsp() bruteForceArray() bruteForceTsp() bruteCost() best() permutationList() getPermutations()
 * by Michael Block - mb4239
 */

import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.stream.Collectors;

public class Graph {

  // Keep a fast index to nodes in the map
  private Map<Integer, Vertex> vertexNames;
  private ArrayList<Integer> bruteForceArray;
  private int totalCost;

  /**
   * Construct an empty Graph with a map. The map's key is the name of a vertex
   * and the map's value is the vertex object.
   */
  public Graph() {
    vertexNames = new HashMap<>();
    bruteForceArray = new ArrayList<Integer>();
    totalCost = 0;
      
  }
    public static void main(String[] args){
        Graph graph = new Graph();
        graph.bruteForceTsp();
    }

  /**
   * Adds a vertex to the graph. Throws IllegalArgumentException if two vertices
   * with the same name are added.
   * 
   * @param v
   *          (Vertex) vertex to be added to the graph
   */
  public void addVertex(Vertex v) {
    if (vertexNames.containsKey(v.name))
      throw new IllegalArgumentException("Cannot create new vertex with existing name.");
    vertexNames.put(v.name, v);
  }

  /**
   * Gets a collection of all the vertices in the graph
   * 
   * @return (Collection<Vertex>) collection of all the vertices in the graph
   */
  public Collection<Vertex> getVertices() {
    return vertexNames.values();
  }

  /**
   * Gets the vertex object with the given name
   * 
   * @param name
   *          (String) name of the vertex object requested
   * @return (Vertex) vertex object associated with the name
   */
  public Vertex getVertex(String name) {
    int vname = Integer.parseInt(name);
    return vertexNames.get(vname);
  }

  /**
   * Adds a directed edge from vertex u to vertex v
   * 
   * @param nameU
   *          (String) name of vertex u
   * @param nameV
   *          (String) name of vertex v
   * @param cost
   *          (double) cost of the edge between vertex u and v
   */
  public void addEdge(int nameU, int nameV, Double cost) {
    if (!vertexNames.containsKey(nameU))
      throw new IllegalArgumentException(nameU + " does not exist. Cannot create edge.");
    if (!vertexNames.containsKey(nameV))
      throw new IllegalArgumentException(nameV + " does not exist. Cannot create edge.");
    Vertex sourceVertex = vertexNames.get(nameU);
    Vertex targetVertex = vertexNames.get(nameV);
    Edge newEdge = new Edge(sourceVertex, targetVertex, cost);
    sourceVertex.addEdge(newEdge);
  }

  /**
   * Adds an undirected edge between vertex u and vertex v by adding a directed
   * edge from u to v, then a directed edge from v to u
   * 
   * @param name
   *          (String) name of vertex u
   * @param name2
   *          (String) name of vertex v
   * @param cost
   *          (double) cost of the edge between vertex u and v
   */
  public void addUndirectedEdge(int name, int name2, double cost) {
    addEdge(name, name2, cost);
    addEdge(name2, name, cost);
  }


  /**
   * Computes the euclidean distance between two points as described by their
   * coordinates
   * 
   * @param ux
   *          (double) x coordinate of point u
   * @param uy
   *          (double) y coordinate of point u
   * @param vx
   *          (double) x coordinate of point v
   * @param vy
   *          (double) y coordinate of point v
   * @return (double) distance between the two points
   */
  public double computeEuclideanDistance(double ux, double uy, double vx, double vy) {
    return Math.sqrt(Math.pow(ux - vx, 2) + Math.pow(uy - vy, 2));
  }

  /**
   * Computes euclidean distance between two vertices as described by their
   * coordinates
   * 
   * @param u
   *          (Vertex) vertex u
   * @param v
   *          (Vertex) vertex v
   * @return (double) distance between two vertices
   */
  public double computeEuclideanDistance(Vertex u, Vertex v) {
    return computeEuclideanDistance(u.x, u.y, v.x, v.y);
  }

  /**
   * Calculates the euclidean distance for all edges in the map using the
   * computeEuclideanCost method.
   */
  public void computeAllEuclideanDistances() {
    for (Vertex u : getVertices())
      for (Edge uv : u.adjacentEdges) {
        Vertex v = uv.target;
        uv.distance = computeEuclideanDistance(u.x, u.y, v.x, v.y);
      }
  }



  // STUDENT CODE STARTS HERE

  public void generateRandomVertices(int n) {
    vertexNames = new HashMap<>(); // reset the vertex hashmap
      Random rng = new Random();
      for(int i = 0; i<n; i++){
           Vertex newVert = new Vertex(i, rng.nextInt(100), rng.nextInt(100));
           vertexNames.put(i, newVert);
                  
      }
      
      for(Vertex a: getVertices()){
          for(Vertex b: getVertices()){
              if (a.x!=b.x || a.y!=b.y){
                  addUndirectedEdge(a.name, b.name, 0);
              }
          }
      }
    
    
    computeAllEuclideanDistances(); // compute distances
  }

public List<Edge> nearestNeighborTsp() {
    LinkedList<Edge> path = new LinkedList<Edge>();     
    LinkedList<Vertex> unvisited = new LinkedList<Vertex>();
      for(Vertex v: getVertices()){
          unvisited.add(v);
      }      
    Vertex start = vertexNames.get(0);
          
     List<Edge> adjList = start.adjacentEdges;
     Collections.sort(adjList);
     Edge shortest = adjList.get(0);
     Vertex current = shortest.target;
     current.prev = start;
     unvisited.remove(start);
     unvisited.remove(current);
     path.add(shortest);
      
    while(unvisited.size() > 0){
     adjList = current.adjacentEdges;
     Collections.sort(adjList);
        for(int i = 0; i< adjList.size(); i++){
            if(unvisited.contains(adjList.get(i).target)){    
             shortest = adjList.get(i);      
             current = shortest.target;
             current.prev = adjList.get(i).source;
             unvisited.remove(current);
             break;
            }            
        }
        path.add(shortest);       
     }       
     if(unvisited.size() == 0){
         current = path.getLast().target;
         adjList = current.adjacentEdges;
         for(Edge e: adjList){
             if (e.target == start){
             Edge last = e;
             e.target.prev = current;
             path.add(last);
             break;
             }
         }
     }
     return path;     
  }
  public List<Edge> bruteForceTsp() {
      List<Vertex> perms = new ArrayList<Vertex>();
      for(Vertex v: getVertices()){
          perms.add(v);
      }
      List<Edge> bestPath = best(perms);
     
    return bestPath; 
            
  }
public ArrayList<String> permutationList(List<Vertex> list) {

    StringBuilder sb = new StringBuilder();
    for(Vertex v: list){
        sb.append(v.name);
    }
    
    String vlist = sb.toString();

    ArrayList<Integer> vNum = new ArrayList<Integer>();
    ArrayList<String> thePermutations = permutations(vlist, vNum);
    return thePermutations;

        
}
public ArrayList<String> permutations(String vertList, ArrayList<Integer> vNum){
        int len = vertList.length();
        ArrayList<String> allVerts = new ArrayList<String>();
        if(vNum.size() == len){
            allVerts.add("");
            return allVerts;
        }
        for(int i = 0; i<len; i++){
            if(vNum.contains(i)){
                continue;
            }
            ArrayList<Integer> newVNum = new ArrayList<Integer>();
            for(int x: vNum){
                newVNum.add(x);
            }
            newVNum.add(i);
            ArrayList<String>  perms = permutations(vertList, newVNum);
            for(String s: perms){
                allVerts.add(vertList.charAt(i)+s);
            }
        }
        return allVerts;
    }
public List<Edge> best(List<Vertex> list){   // finds the best permutation in terms 
        int bestCost = Integer.MAX_VALUE;    // edge cost.
        String bestVerts = "";
        List<Edge> bestEdges = new LinkedList<Edge>();
        
        ArrayList<String> thePerms = permutationList(list);
        for(int i = 0; i<thePerms.size(); i++){
            char[] temp = thePerms.get(i).toCharArray();
            char first = temp[0];
            char[] vals = new char[thePerms.get(i).length()+1];
            for(int j=0; j<temp.length; j++){
                vals[j]=temp[j];
            }
            vals[vals.length-1]= first;
            
            String currentVals = String.valueOf(vals);
            int currentCost = bruteCost(currentVals);
            if (currentCost < bestCost){
               bestCost = currentCost;
               bestVerts = currentVals; 
            
            }
            }
       
        char[] bv = bestVerts.toCharArray();       
        for(int l=0; l<bv.length-1; l++){
            String a = String.valueOf(bv[l]);
            String b = String.valueOf(bv[l+1]);
            Vertex y = getVertex(a);
            Vertex z = getVertex(b);
            Edge e = new Edge(y,z, computeEuclideanDistance(y,z));
            bestEdges.add(e);                  
        }
        return bestEdges;
        
    }
   
    
 public int bruteCost(String x){ //calculates cost of each edge
    char[] bc = x.toCharArray();
    int cost = 0;
      for(int i =0; i<x.length()-1; i++){
      String a = String.valueOf(bc[i]);
      String b = String.valueOf(bc[i+1]);
      Vertex y = getVertex(a);
      Vertex z = getVertex(b);
      cost += computeEuclideanDistance(y, z); 

      }     
    return cost; 
 }
      


  /**
   * Prints out the adjacency list of the graph for debugging
   */
  public void printAdjacencyList() {
    for (int u : vertexNames.keySet()) {
      StringBuilder sb = new StringBuilder();
      sb.append(u);
      sb.append(" -> [ ");
      for (Edge e : vertexNames.get(u).adjacentEdges) {
        sb.append(e.target.name);
        sb.append("(");
        sb.append(e.distance);
        sb.append(") ");
      }
      sb.append("]");
      System.out.println(sb.toString());
    }
  }
}
