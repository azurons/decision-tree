package v2;

import java.util.ArrayList;

/**
 * Property
 */
public class Property {

    private String name;
    private ArrayList<Attribute> attributes = new ArrayList<>();

    public Property(String name){
        this.name = name;
    }

    public void addAttribute(Attribute attr){
        attributes.add(attr);
    }

    public ArrayList<Attribute> getAttributes(){
        return attributes;
    }
}