package multithrading;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ForkJoinPool;
import java.util.stream.LongStream;

public class ParallelSteam {
  public static void main(String[] args) {
      long startTime = System.currentTimeMillis();
//      commonExample();
      withPoolExample();
      System.out.println(System.currentTimeMillis()-startTime);
  }

  public static void commonExample(){
      long res = LongStream.range(0,100).boxed()
              .parallel()
              .map(l -> l/7)
              .peek(l -> System.out.println(l+" "+Thread.currentThread().getName()))
              .reduce((l1, l2) -> l1+l2*2).orElse(0L);
      System.out.println(res);
  }

  public static void withPoolExample(){
      Callable<Long> task = () -> LongStream.range(0,100000000000l).boxed()
              .parallel()
              .map(l -> l/7)
              .peek(l -> System.out.println(l+" "+Thread.currentThread().getName()))
              .reduce((l1, l2) -> l1+l2*2).orElse(0L);
      ForkJoinPool pool = new ForkJoinPool(2);
      try {
          long res = pool.submit(task).get();
          System.out.println(res);
      } catch (InterruptedException | ExecutionException e) {
          e.printStackTrace();
      }
  }
}
