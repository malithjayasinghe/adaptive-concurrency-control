package com.github.malithj;

import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * Custom thread pool - allows the number of threads to controlled at run time
 */
public class CustomThreadPool {

    private final int KEEP_ALIVE_TIME = 100;
    private int poolSize = 1;
    private TimeUnit timeUnit = TimeUnit.SECONDS;
    private ThreadPoolExecutor executor;

    /**
     * The constructor
     *
     * @param poolSize size of thread pool
     */
    public CustomThreadPool(int poolSize) {

        executor = new ThreadPoolExecutor(poolSize, poolSize, KEEP_ALIVE_TIME, timeUnit,
                new LinkedBlockingQueue<Runnable>(),
                new ThreadPoolExecutor.CallerRunsPolicy());
    }

    /**
     * Default constructor
     */
    public CustomThreadPool() {
        this(100);
    }

    /**
     * Submits a task to the thread pool
     *
     * @param worker task to be executed in the thread pool
     */
    public void submitTask(Runnable worker) {
        executor.execute(worker);
    }

    /**
     * Updates the pool size
     *
     * @param poolSize new pool size to be used
     */
    public void setPoolSize(int poolSize) {
        executor.setCorePoolSize(poolSize);
        executor.setMaximumPoolSize(poolSize);
    }

    /**
     * Increments the pool size by 1
     */
    public void incrementPoolSize() {
        incrementPoolSizeBy(1);
    }

    /**
     * Increments the pool size by 1
     */
    public void decrementPoolSize() {
        decrementPoolSizeBy(1);
    }


    /**
     * Increments the pool size by n
     */
    public void incrementPoolSizeBy(int n) {
        executor.setMaximumPoolSize(executor.getMaximumPoolSize() + n);
        executor.setCorePoolSize(executor.getCorePoolSize() + n);
    }

    /**
     * Decrement the pool size by n
     *
     * @param n the number to increment by
     */
    public void decrementPoolSizeBy(int n) {
        executor.setMaximumPoolSize(executor.getMaximumPoolSize() - n);
        executor.setCorePoolSize(executor.getCorePoolSize() - n);
    }

    @Override
    public String toString() {
        return "core pool " + executor.getCorePoolSize() + "  " + "  maximum pool size" + executor.getMaximumPoolSize() + "  " + "queue size " + executor.getQueue().size() + " task count " + executor.getTaskCount();
    }
}
