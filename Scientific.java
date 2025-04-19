import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.lang.Math;
public class SC extends JFrame implements ActionListener { 
 private JTextField display; 
 private String operator = ""; 
 private double firstOperand = 0; 
 private double memory = 0; // Memory storage for calculator
 public SC() { 
 setTitle("Scientific Calculator");
 setSize(400, 600);
 setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
 setLayout(new BorderLayout());
 display = new JTextField();
 display.setFont(new Font("Arial", Font.BOLD, 24));
 display.setHorizontalAlignment(JTextField.RIGHT);
 display.setEditable(false); 
 add(display, BorderLayout.NORTH);
 JPanel buttonPanel = new JPanel();
 buttonPanel.setLayout(new GridLayout(8, 4, 5, 5));
 String[] buttons = {
   "7", "8", "9", "/", 
 "4", "5", "6", "*", 
 "1", "2", "3", "-", 
 "0", ".", "=", "+", 
 "sin", "cos", "tan", "log", 
 "sqrt", "pow", "C", "Exit", 
 "sec", "cosec", "cot", "1/x", 
 "exp", "!", "%", "MC", 
 "MR", "M+", "M-", "π", 
 "asin", "acos", "atan", "e" 
 };
 for (String text : buttons) { 
 JButton button = new JButton(text);
 button.setFont(new Font("Arial", Font.BOLD, 18));
 button.addActionListener(this);
 buttonPanel.add(button);
 } 
 add(buttonPanel, BorderLayout.CENTER);
 setVisible(true); 
 } 
 @Override 
 public void actionPerformed(ActionEvent e) { 
 String command = e.getActionCommand();
   try { 
 if ("0123456789.".contains(command)) { 
 display.setText(display.getText() + command);
 } else if ("+-*/".contains(command)) { 
 firstOperand = Double.parseDouble(display.getText());
 operator = command;
 display.setText("");
 } else if ("=".equals(command)) { 
 double secondOperand = 
Double.parseDouble(display.getText());
 double result = switch (operator) { 
 case "+" -> firstOperand + secondOperand;
 case "-" -> firstOperand - secondOperand;
 case "*" -> firstOperand * secondOperand;
 case "/" -> firstOperand / secondOperand;
 case "pow" -> Math.pow(firstOperand, 
secondOperand);
 default -> 0;
 };
 display.setText(String.valueOf(result));
 } else if ("sin".equals(command)) { 
 
display.setText(String.valueOf(Math.sin(Math.toRadians(Double.par
seDouble(display.getText())))));
 } else if ("cos".equals(command)) { 
 
display.setText(String.valueOf(Math.cos(Math.toRadians(Double.pa
rseDouble(display.getText())))));
 } else if ("tan".equals(command)) {
   display.setText(String.valueOf(Math.tan(Math.toRadians(Double.par
seDouble(display.getText())))));
 } else if ("asin".equals(command)) { 
 
display.setText(String.valueOf(Math.toDegrees(Math.asin(Double.pa
rseDouble(display.getText())))));
 } else if ("acos".equals(command)) { 
 
display.setText(String.valueOf(Math.toDegrees(Math.acos(Double.p
arseDouble(display.getText())))));
 } else if ("atan".equals(command)) { 
 
display.setText(String.valueOf(Math.toDegrees(Math.atan(Double.p
arseDouble(display.getText())))));
 } else if ("log".equals(command)) { 
 
display.setText(String.valueOf(Math.log10(Double.parseDouble(dis
play.getText()))));
 } else if ("sqrt".equals(command)) { 
 
display.setText(String.valueOf(Math.sqrt(Double.parseDouble(displ
ay.getText()))));
 } else if ("sec".equals(command)) { 
 display.setText(String.valueOf(1 / 
Math.cos(Math.toRadians(Double.parseDouble(display.getText())))))
;
 } else if ("cosec".equals(command)) { 
 display.setText(String.valueOf(1 / 
Math.sin(Math.toRadians(Double.parseDouble(display.getText())))));
 } else if ("cot".equals(command)) {
   display.setText(String.valueOf(1 / 
Math.tan(Math.toRadians(Double.parseDouble(display.getText())))));
 } else if ("1/x".equals(command)) { 
 display.setText(String.valueOf(1 / 
Double.parseDouble(display.getText())));
 } else if ("exp".equals(command)) { 
 
display.setText(String.valueOf(Math.exp(Double.parseDouble(displa
y.getText()))));
 } else if ("!".equals(command)) { 
 display.setText(String.valueOf(factorial((int) 
Double.parseDouble(display.getText()))));
 } else if ("%".equals(command)) { 
 
display.setText(String.valueOf(Double.parseDouble(display.getText(
)) / 100));
 } else if ("C".equals(command)) { 
 display.setText("");
 firstOperand = 0;
 operator = "";
 } else if ("Exit".equals(command)) { 
 System.exit(0);
 } else if ("MC".equals(command)) { 
 memory = 0;
 } else if ("MR".equals(command)) { 
 display.setText(String.valueOf(memory));
 } else if ("M+".equals(command)) { 
 memory += Double.parseDouble(display.getText());
 } else if ("M-".equals(command)) { 
 memory -= Double.parseDouble(display.getText())
   } else if ("π".equals(command)) { 
 display.setText(String.valueOf(Math.PI));
 } else if ("e".equals(command)) { 
 display.setText(String.valueOf(Math.E));
 } 
 } catch (Exception ex) { 
 display.setText("Error");
 } 
 } 
 private int factorial(int n) { 
 if (n <= 1) return 1;
 return n * factorial(n - 1);
 } 
 public static void main(String[] args) { 
 new SC();
 } 
}
