class MyThread extends Thread {
    public void run() {
        System.out.println("Thread is running...");
        System.out.println("Thread ID: " + this.currentThread());
    }
}

class ThreadExample {
    public static void main(String[] args) {
        MyThread myThread = new MyThread();
        myThread.setName("MyThread");
        System.out.println("Thread Name: " + myThread.getName());
        myThread.start();
        //long threadId = myThread.currentThread();
        System.out.println("Thread ID: " + myThread.currentThread());
        boolean isAlive = myThread.isAlive();
        System.out.println("Is the thread alive? " + isAlive);
    }
}
