class MyThread extends Thread{
	public void run(){
		System.out.println("My Thread is running");
	}
}
public class DemoMultiThreading{
	public static void main(String[] args){
		MyThread t1 = new MyThread();
		t1.start();
		System.out.println("Main Thread is running");
	}
}