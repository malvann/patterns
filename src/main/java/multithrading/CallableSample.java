package multithrading;

import java.util.Arrays;
import java.util.Comparator;
import java.util.concurrent.*;

class SimpleCallable {
  public static void main(String[] args) {
      String test = "В Java 5 добавлен механизм управления заданиями, основанный на возмож-\n" +
              "ностях интерфейса Executor и его наследников ExecutorService,\n" +
              "ScheduledExecutorService, включающих организацию запуска потоков и их\n" +
              "групп, а также способы их планирования, управления, отслеживания прогрес-\n" +
              "са и завершения асинхронных задач. Все эти задачи можно было сделать\n" +
              "и раньше, но это выполнялось либо самим программистом, либо с привлечением\n" +
              "сторонних библиотек. Поэтому был определен наиболее распространенный\n" +
              "набор задач и реализован в возможностях ExecutorService.\n" +
              "Класс ExecutorService методом execute(Runnable task) запускает тради\n" +
              "ционные потоки, методы же submit(Callable<T> task) и submit(Runnable task)\n" +
              "запускают потоки как с возвращаемым значением, так и классические. Несколько\n" +
              "потоков можно запустить методом invokeAll(Collection<? extends Callable<T>>\n" +
              "tasks). Метод shutdown() прекращает действие самого исполнителя после того,\n" +
              "как все запущенные им ранее потоки отработают, и не даст запустить новые,\n" +
              "сгенерировав при этом исключение RejectedExecutionException. Метод\n" +
              "shutdownNow() останавливает работу сервиса и удаляет все запущенные на\n" +
              "объекте ExecutorService задачи-потоки.";
      ExecutorService service = Executors.newSingleThreadExecutor();
      Future<String> res = service.submit(new ExCallable(test));
      service.shutdown();
      try {
          System.out.println(res.get());
      } catch (InterruptedException | ExecutionException e) {
          e.printStackTrace();
      }
  }
}

class ExCallable implements Callable<String> {
    private final String text;

    public ExCallable(String text) {
        this.text = text;
    }

    @Override
    public String call() {
        return Arrays.stream(text.split("\\s")).max(Comparator.comparing(String::length)).orElse("");
    }
}
