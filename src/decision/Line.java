package decision;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author azuron
 */
public class Line {
    
    public Cell[] surroundings;
    public Boolean death;
    
    public Line(Cell top, Cell right, Cell bottom, Cell left, Boolean death){
        
        surroundings = new Cell[4];
        surroundings[0] = top;
        surroundings[1] = right;
        surroundings[2] = bottom;
        surroundings[3] = left;
        this.death = death;
    }

}

