class Foo {
    public static volatile int methodCompleted;

    public Foo() {
        methodCompleted = 0;
    }

    public void first(Runnable printFirst) throws InterruptedException {
        
        // printFirst.run() outputs "first". Do not change or remove this line.
        printFirst.run();
        methodCompleted = 1;
    }

    public void second(Runnable printSecond) throws InterruptedException {
        while(methodCompleted != 1) ;
        // printSecond.run() outputs "second". Do not change or remove this line.
        printSecond.run();
        methodCompleted = 2;
    }

    public void third(Runnable printThird) throws InterruptedException {
        while(methodCompleted != 2) ;
        // printThird.run() outputs "third". Do not change or remove this line.
        printThird.run();
        methodCompleted = 3;
    }
}