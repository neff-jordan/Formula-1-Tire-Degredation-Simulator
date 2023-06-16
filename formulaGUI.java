package formula1;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

public class formulaGUI extends JFrame implements ActionListener {

    private JTextField trackTextField, lapATextField, lapBTextField, lapCTextField, lapDTextField, lapETextField;
    private JLabel resultLabel;

    public formulaGUI() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("Formula 1 Tire Degradation Simulator");
        setLayout(new BorderLayout());

        // Create input panel
        JPanel inputPanel = new JPanel();
        inputPanel.setLayout(new GridLayout(7, 2));

        // Track input
        JLabel trackLabel = new JLabel("Enter Grand Prix:");
        trackTextField = new JTextField();
        inputPanel.add(trackLabel);
        inputPanel.add(trackTextField);

        // Lap inputs
        JLabel lapALabel = new JLabel("Enter Lap A:");
        lapATextField = new JTextField();
        inputPanel.add(lapALabel);
        inputPanel.add(lapATextField);

        JLabel lapBLabel = new JLabel("Enter Lap B:");
        lapBTextField = new JTextField();
        inputPanel.add(lapBLabel);
        inputPanel.add(lapBTextField);

        JLabel lapCLabel = new JLabel("Enter Lap C:");
        lapCTextField = new JTextField();
        inputPanel.add(lapCLabel);
        inputPanel.add(lapCTextField);

        JLabel lapDLabel = new JLabel("Enter Lap D:");
        lapDTextField = new JTextField();
        inputPanel.add(lapDLabel);
        inputPanel.add(lapDTextField);

        JLabel lapELabel = new JLabel("Enter Lap E:");
        lapETextField = new JTextField();
        inputPanel.add(lapELabel);
        inputPanel.add(lapETextField);

        // Result label
        resultLabel = new JLabel();
        resultLabel.setHorizontalAlignment(JLabel.CENTER);

        // Calculate button
        JButton calculateButton = new JButton("Calculate");
        calculateButton.addActionListener(this);

        // Add components to the frame
        add(inputPanel, BorderLayout.CENTER);
        add(calculateButton, BorderLayout.SOUTH);
        add(resultLabel, BorderLayout.NORTH);

        pack();
        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        String track = trackTextField.getText().toUpperCase();
        double lapA = Double.parseDouble(lapATextField.getText());
        double lapB = Double.parseDouble(lapBTextField.getText());
        double lapC = Double.parseDouble(lapCTextField.getText());
        double lapD = Double.parseDouble(lapDTextField.getText());
        double lapE = Double.parseDouble(lapETextField.getText());

        double laps = lapA + lapB + lapC + lapD + lapE;

        // Create a File object for the Excel file
        File file = new File(track + ".xlsx");

        // Check if the file exists
        if (!file.exists()) {
            resultLabel.setText("The file does not exist.");
            return;
        }

        lapTime time = new lapTime();
        double lapAverage = time.files(file);
        resultLabel.setText("The average historical lap time is " + String.valueOf(lapAverage) + " seconds");

        double total = laps / 5;

        if (total >= lapAverage) {
            resultLabel.setText("You Need a Pit Stop, BOX BOX BOX");
        } else {
            resultLabel.setText("DO NOT BOX, Stay out stay out");
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new formulaGUI();
            }
        });
    }
}
