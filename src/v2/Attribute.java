package v2;

/**
 * Attribute, represente une branche.
 */
public class Attribute {
    
    private Property mainProperty;
    private Property connectedProperty;
    private String name;
    private Boolean isEnd = false;
    private Boolean survive = false;

    public Attribute(String name, Property mainProperty){
        this.name = name;
        this.mainProperty = mainProperty;
    }

    public Attribute(String name, Property mainProperty, Property connectedProperty){
        this.name = name;     
        this.mainProperty = mainProperty;
        this.connectedProperty = connectedProperty;
    }

    public Property getSource(){
        return mainProperty;
    }

    public Property getTarget(){
        return connectedProperty;
    }
    
    public String getName(){
        return name;
    }

    public void setEnd(Boolean survive){
        this.survive = survive;
        this.isEnd = true;
    }
}