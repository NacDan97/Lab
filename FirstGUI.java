import javax.swing.*;

import java.awt.*;
import java.awt.event.*;

    public class FirstGUI extends JFrame{

        JButton button;
        JLabel label;
        JTextField textField;
        JButton clearButton;
        JRadioButton cel, far;

        double num, totalCalc;

        public static void main(String[] args){

            new FirstGUI();

        }

        public FirstGUI(){

            this.setSize(400, 200);

            this.setLocationRelativeTo(null);

            this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

            this.setTitle("Java Lab 10");

            JPanel thePanel = new JPanel();

            button = new JButton("Calculate");
            clearButton = new JButton("Clear");

            ListenForButton lForButton = new ListenForButton();

            ListenForButton lForClearButton = new ListenForButton();

            button.addActionListener(lForButton);

            clearButton.addActionListener(lForClearButton);

            thePanel.add(button);

            thePanel.add(clearButton);

            label = new JLabel("Degrees");

            thePanel.add(label);

            textField = new JTextField("", 10);

            thePanel.add(textField);

            cel = new JRadioButton("Celsius");
            far = new JRadioButton("Fahrenheit");

            ButtonGroup operation = new ButtonGroup();

            operation.add(cel);
            operation.add(far);

            JPanel operPanel = new JPanel();

            operPanel.add(cel);
            operPanel.add(far);

            thePanel.add(operPanel);

            this.add(thePanel);

            this.setVisible(true);

            textField.requestFocus();

        }

        private class ListenForButton implements ActionListener {

            public void actionPerformed(ActionEvent e) {

                if(e.getSource() == clearButton) {
                    textField.setText("");
                }

                else if (e.getSource() == button) {

                        num = Double.parseDouble(textField.getText());

                    if (far.isSelected()) {
                        totalCalc = calcFar(num);

                    } else if (cel.isSelected()) {
                        totalCalc = calcCel(num);
                    }
                    //if you select fahrenheit, you are wanting to change it to celsius
                    if(far.isSelected()){
                        JOptionPane.showMessageDialog(FirstGUI.this,"Your degrees transferred from\n Fahrenheit to Celsius is: " + totalCalc,"Solution", JOptionPane.INFORMATION_MESSAGE);
                    }
                    //if you select celsius, you are wanting to change it to fahrenheit
                    else if (cel.isSelected()){
                        JOptionPane.showMessageDialog(FirstGUI.this,"Your degrees transferred from\n Celsius to Fahrenheit is: " + totalCalc,"Solution", JOptionPane.INFORMATION_MESSAGE);
                    }
                }
            }
        }

        public static double calcCel(double number1){

            double total = 0;

                total = (9.0/5)*number1 + 32;
            return total;

        }
        public static double calcFar(double number1){

            double total = 0;

                total = (number1-32)*(5.0/9);

            return total;

        }

    }


