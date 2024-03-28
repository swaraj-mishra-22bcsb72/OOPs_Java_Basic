import java.awt.*;
import java.awt.event.*;
import javax.script.ScriptEngineManager;
import javax.script.ScriptEngine;
import javax.script.ScriptException;

class ScientificCalculator extends Frame implements ActionListener {
    TextField textField;
    String input = "";

    ScientificCalculator() {
        setLayout(null);

        textField = new TextField();
        textField.setBounds(30, 50, 240, 30);
        textField.setEditable(false);
        add(textField);

        String[] buttonLabels = {"7", "8", "9", "/", "4", "5", "6", "*", "1", "2", "3", "-", "0", ".", "=", "+", "sqrt", "x^2", "x^y", "C"};

        int x = 30, y = 100, width = 60, height = 40;

        for (String label : buttonLabels) {
            Button button = new Button(label);
            button.setBounds(x, y, width, height);
            button.addActionListener(this);
            add(button);
            x += width + 10;
            if (x > 240) {
                x = 30;
                y += height + 10;
            }
        }

        setSize(300, 400);
        setTitle("Scientific Calculator");
        setVisible(true);
        setResizable(false);
        setLocationRelativeTo(null);

        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent windowEvent) {
                System.exit(0);
            }
        });
    }

    public void actionPerformed(ActionEvent e) {
        String command = e.getActionCommand();
        switch (command) {
            case "=": calculate(); break;
            case "C": clear(); break;
            case "sqrt": calculateSquareRoot(); break;
            case "x^2": calculateSquare(); break;
            case "x^y": input += "^"; break;
            default: input += command;
        }
        textField.setText(input);
    }

    private void calculate() {
        try {
            double result = eval(input);
            textField.setText(String.valueOf(result));
            input = String.valueOf(result);
        } catch (Exception e) {
            textField.setText("Error");
            input = "";
        }
    }

    private void calculateSquareRoot() {
        try {
            double value = Double.parseDouble(input);
            double result = Math.sqrt(value);
            textField.setText(String.valueOf(result));
            input = String.valueOf(result);
        } catch (NumberFormatException e) {
            textField.setText("Error");
            input = "";
        }
    }

    private void calculateSquare() {
        try {
            double value = Double.parseDouble(input);
            double result = value * value;
            textField.setText(String.valueOf(result));
            input = String.valueOf(result);
        } catch (NumberFormatException e) {
            textField.setText("Error");
            input = "";
        }
    }

    private void clear() {
        input = "";
        textField.setText("");
    }

    public static void main(String[] args) {
        new ScientificCalculator();
    }

    private static double eval(String expression) throws ScriptException {
        ScriptEngineManager mgr = new ScriptEngineManager();
        ScriptEngine engine = mgr.getEngineByName("JavaScript");
        return (double) engine.eval(expression);
    }
}

class CalculatorApp {
    public static void main(String[] args) {
        new ScientificCalculator();
    }
}
