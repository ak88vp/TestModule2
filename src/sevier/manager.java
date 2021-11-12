package sevier;

public interface manager  <T> {
    void add(T t);
    void print();
    void delete(String name);
    int find(String name);
    void edit (String name,T t);
}
