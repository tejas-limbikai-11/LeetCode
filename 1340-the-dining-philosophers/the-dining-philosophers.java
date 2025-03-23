class DiningPhilosophers {
    private final Semaphore[] forks = new Semaphore[5];
    private final Semaphore mutex = new Semaphore(1);

    public DiningPhilosophers() {
        for(int i=0; i<5; i++) {
            forks[i] = new Semaphore(1);
        }
    }

    // call the run() method of any runnable to execute its code
    public void wantsToEat(int philosopher,
                           Runnable pickLeftFork,
                           Runnable pickRightFork,
                           Runnable eat,
                           Runnable putLeftFork,
                           Runnable putRightFork) throws InterruptedException {
        
        int leftFork = philosopher;
        int rightFork = (philosopher + 1) % 5;

        mutex.acquire();

        forks[leftFork].acquire();
        pickLeftFork.run();

        forks[rightFork].acquire();
        pickRightFork.run();

        eat.run();

        putLeftFork.run();
        forks[leftFork].release();

        putRightFork.run();
        forks[rightFork].release();
        
        mutex.release();
    }
}
