package patterns.structre.composite;

public class EndComponent implements Component{
    private String data;

    public EndComponent(String data) {
        this.data = data;
    }

    @Override
    public String getData() {
        return data;
    }

    @Override
    public Component getChild() {
        throw new UnsupportedOperationException();
    }
}
