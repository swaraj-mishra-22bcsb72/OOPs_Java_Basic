import java.awt.*;

class PrimeCheck extends Frame {
    PrimeCheck() {
		TextField input1 = new TextField("11");
        input1.setBounds(30, 40, 195, 30);
        add(input1);
		
		int num = Integer.parseInt(input1.getText());
		
		TextField result = new TextField("Result: ");
        result.setBounds(240, 40, 195, 30);
        add(result);
		
		if(isPrime(num)){
			result.setText(num+ " is Prime");
		}
		else{
			result.setText(num+ " is not Prime");
		}
		
		
        setSize(500, 80);
        setLayout(null);
        setVisible(true);
	}
	public static boolean isPrime(int x){
		int flag = 1;
		for(int i = 2; i <= Math.sqrt(2); i++){
			if(x%i == 0){
				flag = 0;
				return false;
			}
		}
		return true;
	}
}

class Prime {
    public static void main(String[] args) {
        PrimeCheck check = new PrimeCheck();
    }
}