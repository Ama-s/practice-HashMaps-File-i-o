public class BoundedClass<T extends Number> {
    T id;

    public BoundedClass(T id) {
        this.id = id;
    }

    void display() {
        System.out.println("Type: " + id.getClass().getName());
        System.out.println("Value: " + id);
    }
}
