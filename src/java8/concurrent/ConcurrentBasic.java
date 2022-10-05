package java8.concurrent;

import java.time.Duration;
import java.time.Instant;
import java.time.Period;
import java.time.temporal.ChronoUnit;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.*;

/**
 * Concurrent 소프트웨어 = 동시에 여러 작업을 할 수 있는 소프트웨어
 * JAVA 8 CompletableFuture 를 이해하기 위한 기초지식 + CompletableFuture 기본 문법
 * 순서대로 읽어주세요.
 */
public class ConcurrentBasic {

    /**
     * Java Thread
     */
    public static void threadBasic() throws InterruptedException {
        /**
         * 코드 순서상 My -> Lambda -> Main 순으로 출력될 것 같지만, 실행때마다 순서가 뒤바뀐다.
         * 다른 쓰레드에서 돌기 때문에 순서가 보장이 안된다.
         */
        MyThread myThread = new MyThread();
        myThread.start();

        Thread thread = new Thread(() -> {
            System.out.println("Lambda Thread: " + Thread.currentThread().getName());
        });
        thread.start();

        // java의 기본 thread는 main
        System.out.println("Main Thread: " + Thread.currentThread().getName());

        /**
         * Thread 주요 기능 3가지
         * 1. sleep (쓰레드 멈추기, 재우기)
         * 2. interrupt (쓰레드 깨우기)
         * 3. join (다른 쓰레드 기다리기)
         */
        Thread threadExample = new Thread(() -> {
            while (true) {
                try {
                    Thread.sleep(1000L);
                    System.out.println("Hello: " + Thread.currentThread().getName());
                } catch (InterruptedException e) {
                    System.out.println("Interrupted!");
                    return;
                }
            }
        });
        threadExample.start();
        Thread.sleep(5000L);
        threadExample.interrupt();

        Thread threadJoinExample = new Thread(() -> {
            System.out.println("Wait Please.");
            try {
                Thread.sleep(1000L);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("Thank you!");
        });
        threadJoinExample.start();
        threadJoinExample.join(); // threadJoinExample이 끝날때까지 Hello가 찍히지 않는다.
        System.out.println(threadJoinExample + " is finished!");
    }

    public static class MyThread extends Thread {
        @Override
        public void run() {
            System.out.println("My Thread: " + Thread.currentThread().getName());
        }
    }

    /**
     * 고수준 Concurrency 프로그래밍
     * - 쓰레드를 만들고 관리하는 작업을 애플리케이션에서 분리
     * - 그런 기능을 Executors에 위임
     *
     * Executors 하는 일
     * 1. 쓰레드 만들기: 애플리케이션이 사용할 쓰레드 풀을 만들어 관리
     * 2. 쓰레드 관리: 쓰레드 생명 주기를 관리한다.
     * 3. 작업 처리 및 실행: 쓰레드로 실행할 작업을 제공할 수 있는 API 제공
     */
    public static void executorsBasic() throws InterruptedException {
        /**
         * ExecutorService는 작업을 실행하면 다음 작업을 기다리기 때문에 명시적으로 Shutdown을 해줘야 함.
         */
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        executorService.execute(() -> System.out.println(Thread.currentThread().getName()));
        // shutdown하지 않으면 프로세스가 죽지 않음
        executorService.shutdown();

        /**
         * ExecutorService(이하 ES)가 2개의 쓰레드를 생성 후 5개의 작업을 나눠하는 모습
         * ES는 BlockingQueue를 갖고 있음. 해당 큐에 작업들을 넣어두고 쓰레드가 빌때마다 작업을 전달
         */
        ExecutorService fixedThreadPool = Executors.newFixedThreadPool(2);
        fixedThreadPool.execute(getRunnable("Hello"));
        fixedThreadPool.execute(getRunnable("Chanwoo"));
        fixedThreadPool.execute(getRunnable("Cali"));
        fixedThreadPool.execute(getRunnable("Dev"));
        fixedThreadPool.execute(getRunnable("Good"));
        fixedThreadPool.shutdown();

        /**
         * ScheduleExecutorService: ExecutorService를 상속받은 인터페이스로 특정 시간 이후에 또는 주기적으로 작업 실행 가능
         * 아래 예제는 1초뒤 2초마다 Hello를 찍는 함수
         */
        ScheduledExecutorService scheduledExecutorService = Executors.newSingleThreadScheduledExecutor();
        scheduledExecutorService.scheduleAtFixedRate(getRunnable("Hello"), 1, 2, TimeUnit.SECONDS);

        Thread.sleep(10000L);
        scheduledExecutorService.shutdown();
    }

    private static Runnable getRunnable(String message) {
        return () -> System.out.println(message + " " + Thread.currentThread().getName());
    }

    /**
     * Callable & Future
     */
    public static void callableFutureBasic() throws ExecutionException, InterruptedException {
        ExecutorService executorService = Executors.newSingleThreadExecutor();

        /**
         * Callable
         * Runnable과 유사하지만 결과값을 받을 수 있다. Runnable은 단순 void
         * return 받을 값을 제너릭에 넣어 사용
         */
        Callable<String> hello = () -> {
            Thread.sleep(2000L);
            return "Hello";
        };

        /**
         * Future
         * Callable의 반환 타입
         * 비동기적인 작업의 현재 상태를 조회하거나 결과를 가져올 수 있다.
         *
         * get() - 결과 가져오기
         * isDone() - 작업 종료 여부 확인
         * cancel() - 작업 취소
         */
        Future<String> helloFuture = executorService.submit(hello);
        System.out.println(helloFuture.isDone());
        System.out.println("Started!");

        String s = helloFuture.get(); // 결과값을 기다리기 때문에 블록킹 콜이라고 한다.

        System.out.println(helloFuture.isDone());
        System.out.println("End!");
        executorService.shutdown();

        Callable<String> java = () -> {
            Thread.sleep(4000L);
            return "Java";
        };

        Callable<String> cali = () -> {
            Thread.sleep(3000L);
            return "Cali";
        };

        /**
         * invokeAll() - 여러 작업 동시 실행
         * singleThread 환경에서는 모든 작업이 다 수행된 후 끝나고,
         * threadPool이 여러개 생성된 환경에서는 가장 긴 작업시간만큼 걸린다.
         * 
         * invokeAny() - 가장 먼저 끝난 작업 반환
         * singleThread에서는 제일 먼저 들어간 작업이, 여러 쓰레드 환경에서는 가장 짧은 시간의 작업이 반환
         */
//        ExecutorService fixedThreadPool = Executors.newFixedThreadPool(3);
        ExecutorService fixedThreadPool = Executors.newSingleThreadExecutor();

        Instant startTime = Instant.now();
        List<Future<String>> futures = fixedThreadPool.invokeAll(Arrays.asList(hello, java, cali));
        for (Future<String> future : futures) {
            System.out.println(future.get());
        }
        String invokeAny = fixedThreadPool.invokeAny(Arrays.asList(hello, java, cali));
        System.out.println(invokeAny);
        Instant endTime = Instant.now();
        System.out.println("Duration: " + Duration.between(startTime, endTime).getSeconds());
        fixedThreadPool.shutdown();
    }

    /**
     * JAVA 8 에서 도입된 CompletableFuture
     * 위 예제들은 모두 이걸 위한 예제였다.
     * Future의 문제점을 보완
     */
    public static void completableFutureBasic() throws ExecutionException, InterruptedException {
        /**
         * Future의 문제점
         * Future를 외부에서 완료시킬 수 없고, 취소하거나 get()에 타임아웃을 설정할 수 없다.
         * 블로킹 코드(get())를 사용하지 않고서는 작업이 끝났을 때 콜백을 실행할 수 없다.
         * 여러 Future를 조합할 수 없고, 예외처리용 API를 제공하지 않는다.
         */
        ExecutorService executorService = Executors.newFixedThreadPool(4);
        Future<String> future = executorService.submit(() -> "Hello1");
        System.out.println(future.get());
        executorService.shutdown();

        /**
         * CompletableFuture implements Future, CompletionStage
         */
//        CompletableFuture<String> completableFuture = new CompletableFuture<>();
//        completableFuture.complete("Hello"); // future 기본값 세팅
        CompletableFuture<String> completableFuture = CompletableFuture.completedFuture("Hello2");

        System.out.println(completableFuture.get());

        /**
         * CompletableFuture 비동기 작업
         */
        // return 타입이 없는 경우 -> runAsync
        CompletableFuture<Void> runAsyncCompletableFuture = CompletableFuture.runAsync(() -> {
            System.out.println("Hello3 " + Thread.currentThread().getName());
        });

        // return 타입이 있는 경우 -> supplyAsync
        CompletableFuture<String> supplyAsyncCompletableFuture = CompletableFuture.supplyAsync(() -> {
            System.out.println("Hello4 " + Thread.currentThread().getName());
            return "Hello";
        });
        System.out.println(supplyAsyncCompletableFuture.get());

        /**
         * CompletableFuture 비동기 작업은 콜백 호출 가능
         */
        // thenApply -> return 값 있는 경우
        CompletableFuture<String> callbackThenApply = CompletableFuture.supplyAsync(() -> {
            System.out.println("Hello5 " + Thread.currentThread().getName());
            return "Hello";
        }).thenApply(s -> {
            System.out.println("Hello6 " + Thread.currentThread().getName());
            return s.toUpperCase();
        });

        // thenAccept -> return 값 없는 경우
        CompletableFuture<Void> callbackThenAccept = CompletableFuture.supplyAsync(() -> {
            System.out.println("Hello7 " + Thread.currentThread().getName());
            return "Hello";
        }).thenAccept(s -> {
            System.out.println("Hello8 " + Thread.currentThread().getName());
        });

        // thenRun -> return 값을 받지도 않고 넘기지도 않는 경우
        CompletableFuture<Void> callbackThenRun = CompletableFuture.supplyAsync(() -> {
            System.out.println("Hello9 " + Thread.currentThread().getName());
            return "Hello";
        }).thenRun(() -> {
            System.out.println("Hello10 " + Thread.currentThread().getName());
        });

        /**
         * CompletableFuture는 ThreadPool 생성도 없이 어떻게 쓰레드에서 동작하나?
         * -> ForkJoinPool, ForkJoinPool.commonPool-worker-
         * java7부터 들어온 Pool. Executer를 구현한 구현체
         * Dequeue를 이용해 작업을 관리
         *
         * 물론 다른 쓰레드 풀을 이용하도록 직접 변경도 가능하다.
         */
        ExecutorService executorService1 = Executors.newFixedThreadPool(3);
        CompletableFuture<Void> voidCompletableFuture = CompletableFuture.runAsync(() -> {
            System.out.println("Hello11 " + Thread.currentThread().getName());
        }, executorService1).thenRunAsync(() -> {
            System.out.println("Hello12 " + Thread.currentThread().getName());
        }, executorService1);
        voidCompletableFuture.get();
    }

    public static void main(String[] args) throws InterruptedException, ExecutionException {
//        threadBasic();
//        executorsBasic();
//        callableFutureBasic();
        completableFutureBasic();
    }
}
