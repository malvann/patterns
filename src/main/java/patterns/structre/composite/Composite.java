package patterns.structre.composite;

public class Composite implements Component{
    private String data;
    private Component child;

    public Composite(String data, Component child) {
        this.data = data;
        this.child = child;
    }

    @Override
    public String getData() {
        return data;
    }

    @Override
    public Component getChild() {
        return child;
    }
}
