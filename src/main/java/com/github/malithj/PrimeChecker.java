package com.github.malithj;

/**
 * Worker that checks if a given number is prime or not
 */
public class PrimeChecker implements Runnable {

    private int primeNumber;

    /**
     * The consturctor
     *
     * @param primeNumber the id of worker
     */
    public PrimeChecker(int primeNumber) {
        this.primeNumber = primeNumber;
    }

    @Override
    public void run() {
        try {
            isPrime(primeNumber);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    /**
     * Check if a given number if prime or no
     *
     * @param n the number to be checked for prieme
     * @return true if prime false otherwsie
     */
    boolean isPrime(int n) {
        //check if n is a multiple of 2
        if (n % 2 == 0) return false;
        //if not, then just check the odds
        for (int i = 3; i * i <= n; i += 2) {
            if (n % i == 0)
                return false;
        }
        return true;
    }

}