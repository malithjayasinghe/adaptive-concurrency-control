package com.github.malithj;

import java.util.concurrent.ThreadLocalRandom;

/**
 * TO DO: Implement the Optimizer that would compute the optimal number of threads based on the most recent traiffic conditions
 */
public class BayesianOptimizer {

    public final static int MAX_THREAD_POOL_SIZE = 100;
    public final static int MIN_THREAD_POOL_SIZE = 4;


    /**
     * Gets the optimal number of threads to be used
     *
     * @return the optimal number of threads
     */
    public int getOptimalNumberOfThreads() {
        return ThreadLocalRandom.current().nextInt(MIN_THREAD_POOL_SIZE, MAX_THREAD_POOL_SIZE + 1);
    }

}
