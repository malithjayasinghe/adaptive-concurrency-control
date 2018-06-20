package com.github.malithj;

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
        System.out.println("set = " + optimalNumberOfThreads + "\n");
        System.out.println(threadPool);
        threadPool.setPoolSize(optimalNumberOfThreads);
        ;
    }
}
