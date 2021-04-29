package multithrading;

import java.util.List;
import java.util.concurrent.RecursiveAction;
import java.util.stream.Collectors;

public class RecursiveActionSample {
  public static void main(String[] args) {
    String text =
        "В процессе выполнения приложение выводит в консоль имена потоков об-\n"
            + "работки в виде:\n"
            + "ForkJoinPool.commonPool-worker-5\n"
            + "ForkJoinPool.commonPool-worker-11\n"
            + "Если убрать вызов метода parallel(), то в процессе выполнения будет выво-\n"
            + "дить только имя основного потока main, и никакого разделения на подзадачи\n"
            + "не произойдет.\n"
            + "Пользовательский пул потоков, созданный на основе Runnable или Callable,\n"
            + "непосредственно сделать выполняемым параллельно не существует возможно-\n"
            + "сти, однако его можно обернуть в ForkJoinPool.\n"
            + "/* # 8 # неявный параллелизм # ActionParallelMain.java */\n"
            + "package by.epam.learn.thread.call;\n"
            + "import java.util.concurrent.*;\n"
            + "import java.util.stream.IntStream;\n"
            + "public class ActionParallelMain {\n"
            + "public static void main(String[] args) {\n"
            + "long sec = System.currentTimeMillis();\n"
            + "Callable<Integer> task = () -> IntStream.range(0, 1_000_000_000)\n"
            + ".boxed()\n"
            + ".parallel()\n"
            + ".map(x -> x / 3)\n"
            + ".peek(th -> System.out.println(Thread.currentThread().getName()))\n"
            + ".reduce((x, y) -> x + (int)(3 * Math.sin(y)))\n"
            + ".get();\n"
            + "ForkJoinPool pool = new ForkJoinPool(8);// 8 processors\n"
            + "try {\n"
            + "int result = pool.submit(task).get();\n"
            + "System.out.println(result);\n"
            + "} catch (InterruptedException | ExecutionException e) {\n"
            + "e.printStackTrace();\n"
            + "}\n"
            + "System.out.println((System.currentTimeMillis() - sec) / 1000.);\n"
            + "}\n"
            + "}\n"
            + "Запуск кода покажет, что используются потоки вида:\n"
            + "ForkJoinPool-1-worker-21\n"
            + "ForkJoinPool-1-worker-7\n"
            + "Таким образом, параллельный поток объявляет ForkJoin в качестве роди-\n"
            + "тельского, а не обычный поток. Вследствие чего ForkJoinPool.commonPool не\n"
            + "используется.\n"
            + "Параллельные потоки, запущенные в разных частях приложения, будут кон-\n"
            + "курировать между собой, поэтому следует ограничивать размеры пула.";
      List<String> textList = List.of(text.split("\\W"));
      new SomeAction(textList, "ForkJoinPool", "XXXXXXXXXXX").invoke();
  }
}

class SomeAction extends RecursiveAction{
    private static final int TEXT_LENGTH_LIMIT = 50;
    private List<String> textList;
    private final String wrongWord;
    private final String rightWord;

    public SomeAction(List<String> text, String wrongWord, String rightWord) {
        this.textList = text;
        this.wrongWord = wrongWord;
        this.rightWord = rightWord;
    }

    @Override
    protected void compute() {
        if (textList.size() <= TEXT_LENGTH_LIMIT) {
            replacer();
            return;
        }
        invokeAll(new SomeAction(textList.subList(0, textList.size()/2), wrongWord, rightWord),
                  new SomeAction(textList.subList(textList.size() / 2, textList.size()), wrongWord, rightWord));
    }

    private void replacer(){
        textList = textList.stream().map(s -> {
            if (s.equals(wrongWord)) return rightWord;
            return s;
        }).collect(Collectors.toList());
    }
}
