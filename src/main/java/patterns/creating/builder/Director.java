package patterns.creating.builder;

public class Director {
    public Object build(Builder builder){
        builder.reset();
        builder.setFoundation();
        builder.setWalls();
        builder.setRoof();
        return builder.getResult();
    }
}
