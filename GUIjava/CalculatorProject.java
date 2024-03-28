import java.awt.*;
import java.awt.event.*;
import javax.script.ScriptEngineManager;
import javax.script.ScriptEngine;
import javax.script.ScriptException;

class ScientificCalculator extends Frame implements ActionListener {
    TextField textField;
    String input = "";

    ScientificCalculator() {
        setLayout(new BorderLayout());

        Panel resultPanel = new Panel(new FlowLayout(FlowLayout.RIGHT));
        textField = new TextField();
        textField.setEditable(false);
        textField.setFont(new Font("Segoe UI", Font.PLAIN, 30)); // Changed font and size
        resultPanel.add(textField);
		textField.setBounds(30, 50, 240, 30);

        Panel buttonPanel = new Panel(new GridLayout(5, 4, 5, 5));

        String[] buttonLabels = {
            "7", "8", "9", "/",
            "4", "5", "6", "*",
            "1", "2", "3", "-",
            "0", ".", "=", "+",
            "sqrt", "x^2", "x^y", "C"
        };

        for (String label : buttonLabels) {
            Button button = new Button(label);
            button.addActionListener(this);
            button.setFont(new Font("Arial", Font.PLAIN, 18));
            buttonPanel.add(button);
        }

        add(resultPanel, BorderLayout.NORTH);
        add(buttonPanel, BorderLayout.CENTER);

        setSize(400, 500);
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
        return (double) engine.eval(expression.replaceAll("\\^", "**"));
    }
}

class CalculatorApp {
    public static void main(String[] args) {
        new ScientificCalculator();
    }
}
