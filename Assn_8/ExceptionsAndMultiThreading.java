class MyThread extends Thread{
	public void run(){
		for (int i = 1; i <= 10; i++){
			try{
				Thread.sleep(500);
			}
			catch(InterruptedException e){
				System.out.println(e);
			}
			System.out.println("My Thread is running for "+i+"th time");
		}
	}
}
public class ExceptionsAndMultiThreading{
	public static void main(String[] args){
		MyThread t1 = new MyThread();
		t1.start();
		for (int i = 1; i <= 10; i++){
			try{
				Thread.sleep(500);
			}
			catch(InterruptedException e){
				System.out.println(e);
			}
			System.out.println("Main Thread is running for "+i+"th time");
		}
	}
}