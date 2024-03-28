class MyThread extends Thread {
    public void run() {
        System.out.println(getName() + " is running with priority: " + getPriority());
    }
}

public class ThreadPriorityExample {
    public static void main(String[] args) {
        MyThread thread1 = new MyThread();
		thread1.setName("First_Thread");
        MyThread thread2 = new MyThread();
		thread2.setName("Second_Thread");

        thread1.setPriority(Thread.MIN_PRIORITY); 
        thread2.setPriority(Thread.MAX_PRIORITY); 

        thread1.start();
        thread2.start();
    }
}
