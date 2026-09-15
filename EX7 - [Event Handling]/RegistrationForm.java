// RegistrationForm.java
// Program: User Registration Form using Swing
// Collects Name, Age, Mail ID, Gender, and Contact Number.
// 1. OK button -> validates input and displays details on next screen
// 2. Clear button -> clears all input fields
// 3. Shows alert if invalid or missing data

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class RegistrationForm extends JFrame implements ActionListener {
    JTextField nameField, ageField, mailField, contactField;
    JRadioButton male, female, other;
    JButton okButton, clearButton;
    ButtonGroup genderGroup;

    public RegistrationForm() {
        setTitle("User Registration Form");
        setSize(450, 400);
        setLayout(new GridLayout(8, 2, 5, 5));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // ---------- Form Fields ----------
        add(new JLabel("Name:"));
        nameField = new JTextField();
        add(nameField);

        add(new JLabel("Age:"));
        ageField = new JTextField();
        add(ageField);

        add(new JLabel("Mail ID:"));
        mailField = new JTextField();
        add(mailField);

        add(new JLabel("Gender:"));
        JPanel genderPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        male = new JRadioButton("Male");
        female = new JRadioButton("Female");
        other = new JRadioButton("Other");
        genderGroup = new ButtonGroup();
        genderGroup.add(male);
        genderGroup.add(female);
        genderGroup.add(other);
        genderPanel.add(male);
        genderPanel.add(female);
        genderPanel.add(other);
        add(genderPanel);

        add(new JLabel("Contact Number:"));
        contactField = new JTextField();
        add(contactField);

        // ---------- Buttons ----------
        okButton = new JButton("OK");
        clearButton = new JButton("Clear");
        add(okButton);
        add(clearButton);

        okButton.addActionListener(this);
        clearButton.addActionListener(this);

        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == okButton) {
            validateAndDisplay();
        } else if (e.getSource() == clearButton) {
            clearFields();
        }
    }

    // ---------- Validate and Show Details ----------
    void validateAndDisplay() {
        String name = nameField.getText().trim();
        String ageText = ageField.getText().trim();
        String mail = mailField.getText().trim();
        String contact = contactField.getText().trim();
        String gender = "";

        if (male.isSelected()) gender = "Male";
        else if (female.isSelected()) gender = "Female";
        else if (other.isSelected()) gender = "Other";

        // Simple validation
        if (name.isEmpty() || ageText.isEmpty() || mail.isEmpty() || contact.isEmpty() || gender.equals("")) {
            JOptionPane.showMessageDialog(this, "All fields are required!", "Alert", JOptionPane.ERROR_MESSAGE);
            return;
        }

        int age = 0;
        try {
            age = Integer.parseInt(ageText);
            if (age <= 0 || age > 120) {
                JOptionPane.showMessageDialog(this, "Enter a valid age!", "Alert", JOptionPane.ERROR_MESSAGE);
                return;
            }
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Age must be a number!", "Alert", JOptionPane.ERROR_MESSAGE);
            return;
        }

        if (!mail.contains("@") || !mail.contains(".")) {
            JOptionPane.showMessageDialog(this, "Enter a valid Mail ID!", "Alert", JOptionPane.ERROR_MESSAGE);
            return;
        }

        if (!contact.matches("\\d{10}")) {
            JOptionPane.showMessageDialog(this, "Contact must be 10 digits!", "Alert", JOptionPane.ERROR_MESSAGE);
            return;
        }

        // ---------- Show next screen with details ----------
        JFrame detailsFrame = new JFrame("Registered Details");
        detailsFrame.setSize(300, 250);
        detailsFrame.setLayout(new GridLayout(6, 1));

        detailsFrame.add(new JLabel("Name: " + name));
        detailsFrame.add(new JLabel("Age: " + age));
        detailsFrame.add(new JLabel("Mail ID: " + mail));
        detailsFrame.add(new JLabel("Gender: " + gender));
        detailsFrame.add(new JLabel("Contact: " + contact));

        JButton closeButton = new JButton("Close");
        closeButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                detailsFrame.dispose();
            }
        });
        detailsFrame.add(closeButton);

        detailsFrame.setVisible(true);
    }

    // ---------- Clear Fields ----------
    void clearFields() {
        nameField.setText("");
        ageField.setText("");
        mailField.setText("");
        contactField.setText("");
        genderGroup.clearSelection();
    }

    public static void main(String[] args) {
        new RegistrationForm();
    }
}