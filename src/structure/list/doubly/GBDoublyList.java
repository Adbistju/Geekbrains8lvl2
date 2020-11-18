package structure.list.doubly;

public interface GBDoublyList extends GBDoublyIterable {
    void add(String val);
    boolean remove(String val);
    int size();
    String get(int index);
}
