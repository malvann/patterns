package multithrading;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;
import java.util.concurrent.RecursiveTask;

public class RecursiveTaskSample {
  public static void main(String[] args) {

    String text =
        "При слишком низком отношении значения порога THRESHOLD к общему\n"
            + "числу обрабатываемых данных, создается слишком много разветвлений пото-\n"
            + "ков, поэтому возникает опасность переполнения стека виртуальной машины.\n"
            + "Возможности Stream API позволяют переписать реализацию метода\n"
            + "compute() с применением лямбда выражений:\n"
            + "protected Long compute() {\n"
            + "int length = end - begin;\n"
            + "long result = 0;\n"
            + "if (length <= THRESHOLD) {\n"
            + "for (int i = begin; i < end; i++) {\n"
            + "result += longList.get(i);\n"
            + "}\n"
            + "} else {\n"
            + "int middle = begin + length / 2;\n"
            + "List<SumRecursiveTask> tasks = new ArrayList<>();\n"
            + "tasks.add(new SumRecursiveTask(longList, begin, middle));\n"
            + "tasks.add(new SumRecursiveTask(longList, middle, end));\n"
            + "377JAVA FROM EPAM\n"
            + "tasks.stream().forEach(RecursiveTask::fork);\n"
            + "result = tasks.stream()\n"
            + ".map(RecursiveTask::join)\n"
            + ".reduce((r1, r2)-> r1 + r2)\n"
            + ".orElse(0L);\n"
            + "}\n"
            + "return result;\n"
            + "}\n"
            + "При необходимости можно одну задачу разбивать не на две, а на большее\n"
            + "число подзадач.\n"
            + "Класс RecursiveAction применяется для задач, которые не возвращают зна-\n"
            + "чений, и по своей сути аналогичен интерфейсу Runnable с его методом void\n"
            + "run(). Определен абстрактный метод protected void compute(), также не пред-\n"
            + "назначенный для внешних вызовов и определяющий алгоритм решения задачи\n"
            + "и разбиения на более мелкие.";
    ForkJoinTask<Long> task = new SomeRecursiveTask(text);
    long result = new ForkJoinPool().invoke(task);
    System.out.println(result);
  }
}

class SomeRecursiveTask extends RecursiveTask<Long>{
  private static final int TEXT_LENGTH_LIMIT = 50;
  private static final String REG_WORD_DELIMITER = "\\W";
  private final String text;

  public SomeRecursiveTask(String text) {
    this.text = text;
  }

  @Override
  protected Long compute() {
    if (text.length() <= TEXT_LENGTH_LIMIT) return countWords(text);
    String part1 = text.substring(0, text.length()/2);
    String part2 = text.substring(text.length()/2);
//    SomeRecursiveTask task1 = new SomeRecursiveTask(part1);
//    SomeRecursiveTask task2 = new SomeRecursiveTask(part2);
//    task1.fork();
//    task2.fork();
//    long res1 = task1.join();
//    long res2 = task2.join();
//    return res1 + res2;
    List<SomeRecursiveTask> tasks = List.of(new SomeRecursiveTask(part1), new SomeRecursiveTask(part2));
    tasks.forEach(RecursiveTask::fork);
    return tasks.stream().map(RecursiveTask::join).reduce(Long::sum).orElse(0L);
  }

  private long countWords(String text){
    return Arrays.stream(text.split(REG_WORD_DELIMITER)).count();
  }
}
