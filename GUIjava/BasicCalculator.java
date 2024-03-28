import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class BasicCalculator extends Frame implements KeyListener {
    TextField textField;

    public BasicCalculator() {
        setLayout(null);

        textField = new TextField();
        textField.setBounds(30, 50, 240, 30);
        textField.setEditable(true);
        textField.addKeyListener(this); // Add KeyListener to textField
        add(textField);

        String[] buttonLabels = {
                "7", "8", "9", "/",
                "4", "5", "6", "*",
                "1", "2", "3", "-",
                "0", ".", "=", "+",
                "C"
        };

        int x = 30, y = 100, width = 60, height = 40;

        for (String label : buttonLabels) {
            Button button = new Button(label);
            button.setBounds(x, y, width, height);
            button.addActionListener(this::handleButtonClick);
            add(button);

            x += width + 10;

            if (x > 240) {
                x = 30;
                y += height + 10;
            }
        }

        setSize(400, 400);
        setTitle("Basic Calculator");
        setVisible(true);
        setResizable(false);
        setLocationRelativeTo(null);

        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent windowEvent) {
                System.exit(0);
            }
        });
    }

    public static void main(String[] args) {
        new BasicCalculator();
    }

    private void handleButtonClick(ActionEvent e) {
        String command = e.getActionCommand();

        switch (command) {
            case "=":
                calculate();
                break;
            case "C":
                textField.setText("");
                break;
            default:
                textField.setText(textField.getText() + command);
        }
    }

    private void calculate() {
        try {
            String expression = textField.getText();
            double result = evaluateExpression(expression);
            textField.setText(String.valueOf(result));
        } catch (Exception e) {
            textField.setText("Error");
        }
    }

    private double evaluateExpression(String expression) {
        try {
            String[] tokens = expression.split(" ");
            double operand1 = Double.parseDouble(tokens[0]);
            String operator = tokens[1];
            double operand2 = Double.parseDouble(tokens[2]);

            switch (operator) {
                case "+":
                    return operand1 + operand2;
                case "-":
                    return operand1 - operand2;
                case "*":
                    return operand1 * operand2;
                case "/":
                    return operand1 / operand2;
                default:
                    throw new IllegalArgumentException("Invalid operator");
            }
        } catch (Exception e) {
            throw new IllegalArgumentException("Invalid expression");
        }
    }

    // Implement KeyListener methods
    @Override
    public void keyTyped(KeyEvent e) {
        // Not needed for this example
    }

    @Override
    public void keyPressed(KeyEvent e) {
        // Handle key presses
        char keyChar = e.getKeyChar();

        if (Character.isDigit(keyChar) || keyChar == '+' || keyChar == '-' || keyChar == '*' || keyChar == '/' || keyChar == '.') {
            textField.setText(textField.getText() + keyChar);
        } else if (e.getKeyCode() == KeyEvent.VK_ENTER) {
            calculate();
        } else if (e.getKeyCode() == KeyEvent.VK_BACK_SPACE) {
            String currentText = textField.getText();
            if (currentText.length() > 0) {
                textField.setText(currentText.substring(0, currentText.length() - 1));
            }
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        // Not needed for this example
    }
}
