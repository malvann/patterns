package patterns.creating.prototype;

public abstract class Shape implements Prototype<Shape>{
    protected int a;
    protected int b;
    protected String color;

    public Shape(int a, int b, String color) {
        this.a = a;
        this.b = b;
        this.color = color;
    }

    @Override
    public Shape clone() {
        return null;
    }
}
