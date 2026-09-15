// ClickImageFrame.java
// Program: A simple Java Swing frame with a TextField, an Image, and a Button.
// 1. Displays the number of button clicks in the text field.
// 2. Enlarges the image when the mouse is moved over it.
// 3. Restores the image to original size when the mouse is moved out.

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class ClickImageFrame extends JFrame {
    JTextField textField;
    JButton button;
    JLabel imageLabel;
    int count = 0;

    // Variables to hold icons for normal and enlarged image
    ImageIcon normalIcon;
    ImageIcon enlargedIcon;

    public ClickImageFrame() {
        setTitle("Button Click and Image Demo");
        setSize(400, 400);
        setLayout(new FlowLayout());
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // --- TextField to display number of clicks ---
        textField = new JTextField(10);
        textField.setEditable(false);
        add(textField);

        // --- Button to count clicks ---
        button = new JButton("Click Me");
        add(button);

        // --- Load image ---
        // Make sure "photo.jpg" is in the same folder as this program
        normalIcon = new ImageIcon(new ImageIcon("photo.jpg")
                        .getImage().getScaledInstance(120, 120, Image.SCALE_SMOOTH));
        enlargedIcon = new ImageIcon(new ImageIcon("photo.jpg")
                        .getImage().getScaledInstance(200, 200, Image.SCALE_SMOOTH));

        // --- Label to display the image ---
        imageLabel = new JLabel(normalIcon);
        add(imageLabel);

        // --- Button Click Action ---
        button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                count++; // increase count each click
                textField.setText(String.valueOf(count)); // show in text field
            }
        });

        // --- Mouse events for enlarging/restoring image ---
        imageLabel.addMouseListener(new MouseAdapter() {
            public void mouseEntered(MouseEvent e) {
                imageLabel.setIcon(enlargedIcon); // enlarge when mouse enters
            }
            public void mouseExited(MouseEvent e) {
                imageLabel.setIcon(normalIcon); // restore when mouse leaves
            }
        });

        setVisible(true);
    }

    public static void main(String[] args) {
        new ClickImageFrame();
    }
}