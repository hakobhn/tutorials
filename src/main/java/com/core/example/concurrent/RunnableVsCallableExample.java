package com.core.example.concurrent;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.security.spec.InvalidParameterSpecException;
import java.util.concurrent.*;

import static org.junit.Assert.assertEquals;

public class RunnableVsCallableExample {

    public static class EventLoggingTask implements  Runnable{
        private Logger logger
                = LoggerFactory.getLogger(EventLoggingTask.class);

        @Override
        public void run() {
            int num = 1;
//            if(num <= 0) {
//                throw new InvalidParameterSpecException("Number should be positive");
//            }
            logger.info("Message num: " + num);
        }
    }

    public static class FactorialCallableTask implements Callable<Integer> {
        private int number;

        public FactorialCallableTask(int number) {
            this.number = number;
        }

        // standard constructors

        public Integer call() throws InvalidParameterSpecException {
            int fact = 1;

            if(number < 0) {
                throw new InvalidParameterSpecException("Number should be positive");
            }

            for(int count = number; count > 1; count--) {
                fact = fact * count;
            }

            return fact;
        }
    }

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        Future runnableFuture = executorService.submit(new EventLoggingTask());
        try {
            System.out.println("runnable future: " + runnableFuture.get());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }


        FactorialCallableTask task = new FactorialCallableTask(5);
        Future<Integer> callableFuture = executorService.submit(task);

        int result = 0;
        try {
            result = callableFuture.get().intValue();
            System.out.println("callable future: " + result);
            assertEquals(true, callableFuture.isDone());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }

        assertEquals(120, result);


        task = new FactorialCallableTask(-5);
        Future<Integer> failedCallableFuture = executorService.submit(task);

        try {
            result = failedCallableFuture.get().intValue();
            System.out.println("failed callable future: " + result);
            assertEquals(false, failedCallableFuture.isDone());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }


        executorService.shutdown();
    }

}
