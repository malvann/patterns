package patterns.structre.proxy;

import java.util.ArrayList;
import java.util.List;

public class PrintManager implements ManagerInterface {
    List<String> data = new ArrayList<>();

    @Override
    public void operation1() {
        data.forEach(System.out::println);
    }

    @Override
    public void operation2() {
    }

    @Override
    public void operation3() {
    }
}
