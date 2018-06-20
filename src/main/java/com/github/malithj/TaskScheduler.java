package com.github.malithj;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * The sumbits the task to be exectued by the thread pool
 */
public class TaskScheduler {

    private final static int PUB_PERIOD = 100;
    private final static int THREAD_POOL_MODIFICATION_INITIAL_DELAY = 10;
    private final static int THREAD_POOL_MODIFICATION_PERIOD = 10;

    /**
     * Main entry point
     */
    public static void main(String args[]) {
        ScheduledExecutorService threadPoolSizeModifier = Executors.newScheduledThreadPool(1);
        BayesianOptimizer bayesianOptimizer = new BayesianOptimizer();
        CustomThreadPool customThreadPool = new CustomThreadPool();
        threadPoolSizeModifier.scheduleAtFixedRate(new ThreadPoolSizeUpdater(customThreadPool, bayesianOptimizer), THREAD_POOL_MODIFICATION_INITIAL_DELAY, THREAD_POOL_MODIFICATION_PERIOD, TimeUnit.SECONDS);
        while (true) {
            customThreadPool.submitTask(new PrimeChecker(10));
            try {
                Thread.sleep(PUB_PERIOD);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
