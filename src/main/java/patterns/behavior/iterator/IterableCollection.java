package patterns.behavior.iterator;

public interface IterableCollection<T> {
    Iterator<T> createIterator();
}
