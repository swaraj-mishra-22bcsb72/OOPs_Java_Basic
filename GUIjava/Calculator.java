import java.awt.*;
import java.awt.event.*;
import java.util.Stack;


class ScientificCalculator extends Frame implements ActionListener {
    private TextField textField;
    private String input = "";

    ScientificCalculator() {
        setLayout(new BorderLayout());

        Panel resultPanel = new Panel(new FlowLayout(FlowLayout.RIGHT));
        textField = new TextField(20);
        textField.setEditable(false);
        textField.setFont(new Font("TimesNewRoman", Font.PLAIN, 30));
        resultPanel.add(textField);
        resultPanel.setBackground(Color.LIGHT_GRAY);
        
		

        Panel buttonPanel = new Panel(new GridLayout(6, 5, 5, 5));
        buttonPanel.setBackground(Color.DARK_GRAY);

        String[] buttonLabels = {
                "%", "CE", "C", "<-",
                "1/x", "x^2", "sqrt", "/",
                "7", "8", "9", "*",
                "4", "5", "6", "-",
                "1", "2", "3", "+",
                "+/-", "0", ".", "=",
        };

        for (String label : buttonLabels) {
            Button button = new Button(label);
            button.addActionListener(this);
            button.setFont(new Font("Segoe UI", Font.PLAIN, 14));
            buttonPanel.add(button);
            button.setBackground(Color.GRAY);
            button.setForeground(Color.WHITE);
        
            // Adjust the button dimensions to 0.5x
            Dimension buttonSize = new Dimension(20, 20);
            button.setPreferredSize(buttonSize);
            button.setMinimumSize(buttonSize);
            button.setMaximumSize(buttonSize);
        
            buttonPanel.add(button);
            button.setBackground(Color.GRAY);
            button.setForeground(Color.WHITE);
        }

        add(resultPanel, BorderLayout.NORTH);
        add(buttonPanel, BorderLayout.CENTER);

        textField.addKeyListener(new KeyAdapter() {
            public void keyTyped(KeyEvent e) {
                char keyChar = e.getKeyChar();
                handleKeyPress(keyChar);
            }
        });

        setSize(468, 600);
        setTitle("Scientific Calculator");
        setResizable(true);
        setLocationRelativeTo(null);
        setVisible(true);

        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent windowEvent) {
                System.exit(0);
            }
        });
    }
    
    private void clearTextField() {
        // Clear the entire input
        input = "";
        textField.setText("");
    }

    public void actionPerformed(ActionEvent e) {
        String command = e.getActionCommand();
        switch (command) {
            case "=":
                calculate();
                break;
            case "C":
                clear();
                break;
            case "CE":
                clearTextField();
                break;
            case "<-":
                removeLastCharacter();
                break;
            case "sqrt":
                calculateSquareRoot();
                break;
            case "x^2":
                calculateSquare();
                break;
            case "x^y":
                input += "^";
                break;
            case "+/-":
                handleNegation();
                break;
            default:
                input += command;
        }
        textField.setText(input);
    }

    private void removeLastCharacter() {
        // Remove the last character from the input string
        if (!input.isEmpty()) {
            input = input.substring(0, input.length() - 1);
        }
    }

    private void handleNegation() {
        // Toggle the negation of the current input
        if (!input.isEmpty() && input.charAt(0) == '-') {
            input = input.substring(1);
        } else {
            input = "-" + input;
        }
    }

    private void handleButtonClick(String command) {
        switch (command) {
            case "=":
                calculate();
                break;
            case "C":
                clear();
                break;
            case "sqrt":
                calculateSquareRoot();
                break;
            case "x^2":
                calculateSquare();
                break;
            case "x^y":
                input += "^";
                break;
            default:
                input += command;
        }
        textField.setText(input);
    }

    private void handleKeyPress(char keyChar) {
        if (Character.isDigit(keyChar) || keyChar == '.' || isOperator(keyChar)) {
            input += keyChar;
        } else if (keyChar == KeyEvent.VK_ENTER) {
            calculate();
        } else if (keyChar == KeyEvent.VK_BACK_SPACE) {
            if (!input.isEmpty()) {
                input = input.substring(0, input.length() - 1);
            }
        } else if (keyChar == KeyEvent.VK_DELETE) {
            clearLastEntry();
        }
        textField.setText(input);
    }

    private void clearLastEntry() {
        input = "";
        textField.setText("");
    }

    private void calculate() {
        try {
            double result = evaluateExpression(input);
            if (Double.isFinite(result)) {
                textField.setText(String.valueOf(result));
                input = String.valueOf(result);
            } else {
                textField.setText("Error");
                input = "";
            }
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

    private static double evaluateExpression(String expression) {
        char[] tokens = expression.toCharArray();
        Stack<Double> values = new Stack<>();
        Stack<Character> operators = new Stack<>();
    
        for (int i = 0; i < tokens.length; i++) {
            if (tokens[i] == ' ')
                continue;
    
            if (Character.isDigit(tokens[i]) || tokens[i] == '.') {
                StringBuilder sbuf = new StringBuilder();
                // Handle negative numbers
                if (i > 0 && (tokens[i - 1] == '-' || tokens[i - 1] == '+')) {
                    sbuf.append(tokens[i - 1]);
                }
                while (i < tokens.length && (Character.isDigit(tokens[i]) || tokens[i] == '.')) {
                    sbuf.append(tokens[i++]);
                }
                i--;
                values.push(Double.parseDouble(sbuf.toString()));
            } else if (tokens[i] == '(') {
                operators.push(tokens[i]);
            } else if (tokens[i] == ')') {
                while (operators.peek() != '(') {
                    values.push(applyOperator(operators.pop(), values.pop(), values.pop()));
                }
                operators.pop();
            } else if (isOperator(tokens[i])) {
                while (!operators.isEmpty() && hasPrecedence(tokens[i], operators.peek())) {
                    values.push(applyOperator(operators.pop(), values.pop(), values.pop()));
                }
                operators.push(tokens[i]);
            }
        }
    
        while (!operators.isEmpty()) {
            values.push(applyOperator(operators.pop(), values.pop(), values.pop()));
        }
    
        return values.pop();
    }    

    private static boolean isOperator(char c) {
        return c == '+' || c == '-' || c == '*' || c == '/';
    }

    private static boolean hasPrecedence(char op1, char op2) {
        return (op1 == '*' || op1 == '/') && (op2 == '+' || op2 == '-');
    }

    private static double applyOperator(char operator, double operand2, double operand1) {
        switch (operator) {
            case '+':
                return operand1 + operand2;
            case '-':
                return operand1 - operand2;
            case '*':
                return operand1 * operand2;
            case '/':
                if (operand2 == 0) {
                    throw new ArithmeticException("Division by zero");
                }
                return operand1 / operand2;
            case '%':
                return operand1 % operand2; // Handle modulus operation
            
            default:
                throw new IllegalArgumentException("Invalid operator: " + operator);
        }
    }

    public static void main(String[] args) {
        new ScientificCalculator();
    }
}
