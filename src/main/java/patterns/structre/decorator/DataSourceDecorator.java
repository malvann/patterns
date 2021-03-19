package patterns.structre.decorator;

public class DataSourceDecorator implements DataSource{
    DataSource source;

    public DataSourceDecorator(DataSource source) {
        this.source = source;
    }

    @Override
    public void write(String data) {
        String processedData = new StringBuilder(data).reverse().toString();
        source.write(processedData);
    }

    @Override
    public String read() {
        String processedData = new StringBuilder(source.read()).reverse().toString();
        return processedData;
    }
}
