package patterns.structre.decorator;

import java.util.ArrayList;

public class FileDataSource implements DataSource{
    ArrayList<String> base = new ArrayList<>();

    @Override
    public void write(String data) {
        base.add(data);
    }

    @Override
    public String read() {
        return String.join("", base);
    }
}
