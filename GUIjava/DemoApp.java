import java.awt.*;

class Calculator extends Frame {
    Calculator() {
        Button b = new Button("=");
        b.setBounds(30, 220, 75, 30);
        add(b);

        Button plus = new Button("+");
        plus.setBounds(115, 220, 30, 30);
        add(plus);

        Button minus = new Button("-");
        minus.setBounds(145, 220, 30, 30);
        add(minus);

        Button into = new Button("*");
        into.setBounds(175, 220, 30, 30);
        add(into);

        Button divide = new Button("/");
        divide.setBounds(205, 220, 30, 30);
        add(divide);
/*
        Button dot = new Button(".");
        dot.setBounds(10, 190, 30, 30);
        add(dot);
*/
        Button[] num = new Button[10];
        for (int i = 0; i <= 9; i++) {
            num[i] = new Button(String.valueOf(i));
            num[i].setBounds(30 * i + 30, 150, 30, 30);
            add(num[i]);
        }

        TextField input1 = new TextField("11");
        input1.setBounds(30, 40, 195, 30);
        add(input1);
		
		TextField input2 = new TextField("22");
        input2.setBounds(30, 80, 195, 30);
        add(input2);
		
		TextField result = new TextField("Result: ");
        result.setBounds(240, 60, 195, 30);
        add(result);
		
		int sum = Integer.parseInt(input1.getText()) + Integer.parseInt(input2.getText());
		
		result.setText(String.valueOf(sum));

        setSize(600, 300);
        setLayout(null);
        setVisible(true);
    }
}

class CalculatorApp {
    public static void main(String[] args) {
        Calculator calculator = new Calculator();
    }
}
