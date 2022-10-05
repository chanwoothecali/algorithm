package java8.concurrent;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public class CompletableFutureBasic {

    /**
     * CompletableFuture 여러가지 사용 방법
     *
     * thenCompose(): 두 작업이 서로 이어서 실행하도록 조합
     * thenCombine(): 두 작업을 독립적으로 실행하고 둘 다 종료했을 때 콜백 실행
     * allOf(): 여러 작업을 모두 실행하고 모든 작업 결과에 콜백 실행
     * anyOf(): 여러 작업 중에 가장 빨리 끝난 하나의 결과에 콜백 실행
     */
    public static void completableFutureThen() throws ExecutionException, InterruptedException {
        /**
         * 둘이 연관관계가 있는 경우
         */
        CompletableFuture<String> hello = CompletableFuture.supplyAsync(() -> {
            System.out.println("Hello " + Thread.currentThread().getName());
            return "Hello";
        });

        System.out.println(hello.thenCompose(CompletableFutureBasic::getWorld).get());

        /**
         * 둘이 서로 연관관계가 없는 경우
         */
        CompletableFuture<String> hello2 = CompletableFuture.supplyAsync(() -> {
            System.out.println("Hello2 " + Thread.currentThread().getName());
            return "Hello2";
        });

        CompletableFuture<String> world2 = CompletableFuture.supplyAsync(() -> {
            System.out.println("World2 " + Thread.currentThread().getName());
            return "World2";
        });

        CompletableFuture<String> future = hello2.thenCombine(world2, (h, w) -> {
            return h + " " + w;
        });
        System.out.println(future.get());

        /**
         * 작업이 둘 이상일때
         *
         * allOf -> 모든 작업 결과에 콜백 실행
         * anyOf -> 가장 먼저 끝난 결과에 콜백 실행
         */
        // join()은 get()과 동작은 같지만 UncheckedException을 발생시킨다는 점이 다르다.
        CompletableFuture<List<String>> results = CompletableFuture.allOf(hello2, world2)
                .thenApply(v -> Arrays.asList(hello2.join(), world2.join()));
        results.get().forEach(System.out::println);

        CompletableFuture<Void> anyOf = CompletableFuture.anyOf(hello2, world2).thenAccept(System.out::println);
        System.out.println(anyOf.get());
    }

    private static CompletableFuture<String> getWorld(String message) {
        return CompletableFuture.supplyAsync(() -> {
            System.out.println("World " + Thread.currentThread().getName());
            return message + " World";
        });
    }

    /**
     * CompletableFuture 예외처리
     */
    public static void completableFutureException() throws ExecutionException, InterruptedException {
        boolean throwError = true;

        /**
         * 예외처리만을 위한 exceptionally
         */
        CompletableFuture<String> completableFutureError = CompletableFuture.supplyAsync(() -> {
            if (throwError) {
                throw new IllegalArgumentException();
            }

            System.out.println("Hello " + Thread.currentThread().getName());
            return "Hello";
        }).exceptionally(ex -> {
            System.out.println(ex);
            return "Error!";
        });
        System.out.println(completableFutureError.get());

        /**
         * 일반적인 경우, 예외 경우 둘 다 고려한 handle
         */
        CompletableFuture<Object> handle = CompletableFuture.supplyAsync(() -> {
            if (throwError) {
                throw new IllegalArgumentException();
            }

            System.out.println("Hello " + Thread.currentThread().getName());
            return "Hello";
        }).handle((result, ex) -> {
            if (ex != null) {
                System.out.println(ex);
                return "ERROR";
            }
            return result;
        });
        System.out.println(handle.get());
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {
//        completableFutureThen();
        completableFutureException();
    }
}
