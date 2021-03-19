package patterns.structre.proxy;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class CashManager implements ManagerInterface {
    private PrintManager executor;
    private List<String> cash = new ArrayList<>();
    private List<String> cash1 = new ArrayList<>();

    public CashManager(PrintManager executor) {
        this.executor = executor;
    }

    @Override
    public void operation1() {
        cash.addAll(executor.data);
    }

    @Override
    public void operation2() {
        cash1.addAll(executor.data.stream().filter(s -> s.length()>4).collect(Collectors.toList()));
    }

    @Override
    public void operation3() {

    }
}
