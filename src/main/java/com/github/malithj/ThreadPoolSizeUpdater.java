package com.github.malithj;

import java.text.SimpleDateFormat;
import java.util.Calendar;

/**
 * Update the thread pool size
 */
public class ThreadPoolSizeUpdater implements Runnable {

    private CustomThreadPool threadPool;
    private BayesianOptimizer optimizer;

    /**
     * The constructor
     *
     * @param threadPool the treadpool
     * @param optimizer  the BaysianOptimizer which compute the optimal number of threads
     */
    public ThreadPoolSizeUpdater(CustomThreadPool threadPool, BayesianOptimizer optimizer) {
        this.threadPool = threadPool;
        this.optimizer = optimizer;
    }

    @Override
    public void run() {
        int optimalNumberOfThreads = optimizer.getOptimalNumberOfThreads();
        Calendar cal = Calendar.getInstance();
        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
        System.out.println("time = " + sdf.format(cal.getTime()) + "  setting the pool size: pool size = " + optimalNumberOfThreads + "\n");
        threadPool.setPoolSize(optimalNumberOfThreads);
        ;
    }
}
