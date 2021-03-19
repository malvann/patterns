package patterns.creating.builder;

public interface Builder<T> {
    void reset();
    void setFoundation();
    void setWalls();
    void setRoof();
     T getResult();
}
