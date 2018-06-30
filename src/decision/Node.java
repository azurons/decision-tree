/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package decision;

import java.util.ArrayList;

/**
 *
 * @author azuron
 */
public class Node {
    private Boolean isRoot;
    private ArrayList<Node> neighbors = new ArrayList();
    private int index;
    
    
     public Node(int index){
        this.index = index;
        this.isRoot = false;
    }
    
    public Node(int index, Boolean isRoot){
        this.index = index;
        this.isRoot = isRoot;
    }
    
    public void addNeighbor(Node node){
        neighbors.add(node);
    }
    
    public Node[] getNeighbors(){
        Node[] n = new Node[neighbors.size()];
        return neighbors.toArray(n);
    }
}
