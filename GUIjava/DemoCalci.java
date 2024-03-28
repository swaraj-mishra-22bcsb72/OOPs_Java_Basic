import java.awt.*;
import java.awt.event.*;

class CalculatorApp extends Frame implements ActionListener, KeyListener {
    private TextField textField;

    private double num1, num2, result;
    private char operator;

    public CalculatorApp() {
        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.BOTH;
        gbc.insets = new Insets(5, 5, 5, 5);

        // Textfield
        textField = new TextField(20);
        textField.setEditable(false);
        textField.addKeyListener(this); // Add KeyListener
        gbc.gridwidth = 5;
        gbc.gridx = 0;
        gbc.gridy = 0;
        add(textField, gbc);

        // Buttons
        String buttonLabels = "789/456*123-0.=+";
        gbc.gridwidth = 1;
        for (int i = 0; i < buttonLabels.length(); i++) {
            Button button = new Button(String.valueOf(buttonLabels.charAt(i)));
            button.addActionListener(this);
            gbc.gridx = i % 5;
            gbc.gridy = 1 + i / 5;
            add(button, gbc);
        }

        addWindowListener(new MyWindowAdapter());
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // ... (unchanged actionPerformed method)
    }

    @Override
    public void keyPressed(KeyEvent e) {
        // Handle numeric key presses
        char keyChar = e.getKeyChar();
        if (Character.isDigit(keyChar) || keyChar == '.') {
            textField.setText(textField.getText() + keyChar);
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {
        // Unused, but required for KeyListener interface
    }

    @Override
    public void keyReleased(KeyEvent e) {
        // Unused, but required for KeyListener interface
    }

    public static void main(String[] args) {
        CalculatorApp calculator = new CalculatorApp();
        calculator.setSize(400, 500);
        calculator.setTitle("Calculator");
        calculator.setVisible(true);
    }

    class MyWindowAdapter extends WindowAdapter {
        public void windowClosing(WindowEvent we) {
            System.exit(0);
        }
    }
}
