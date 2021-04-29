package patterns.behavior.iterator;

public interface Iterator<T> {
    T getNext();
    boolean hasNext();
}
