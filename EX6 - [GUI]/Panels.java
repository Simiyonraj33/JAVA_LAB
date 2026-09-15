import javax.swing.*;   // For JFrame, JPanel, Timer
import java.awt.*;      // For BorderLayout, Color
import java.util.Random; // For generating random colors

public class Panels extends JFrame {

    // Declare 5 panels for NORTH, SOUTH, EAST, WEST, and CENTER
    JPanel northPanel, southPanel, eastPanel, westPanel, centerPanel;
    
    // Random object to generate random colors
    Random rand = new Random();

    // Constructor to set up the frame and panels
    public Panels() {
        // Set the title of the frame
        setTitle("Color Changing Panels");

        // Set the size of the frame
        setSize(500, 500);

        // Exit the application when the frame is closed
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Set layout manager to BorderLayout
        setLayout(new BorderLayout());

        // Initialize each panel
        northPanel = new JPanel();
        southPanel = new JPanel();
        eastPanel = new JPanel();
        westPanel = new JPanel();
        centerPanel = new JPanel();

        // OPTIONAL: Set initial background colors for clarity
        northPanel.setBackground(Color.RED);
        southPanel.setBackground(Color.GREEN);
        eastPanel.setBackground(Color.BLUE);
        westPanel.setBackground(Color.YELLOW);
        centerPanel.setBackground(Color.CYAN);

        // Add panels to the frame using BorderLayout positions
        add(northPanel, BorderLayout.NORTH);
        add(southPanel, BorderLayout.SOUTH);
        add(eastPanel, BorderLayout.EAST);
        add(westPanel, BorderLayout.WEST);
        add(centerPanel, BorderLayout.CENTER);

        // Create a Timer that changes panel colors every 3 seconds (3000 milliseconds)
        Timer timer = new Timer(3000, e -> changeColors());
        timer.start(); // Start the timer

        // Make the frame visible
        setVisible(true);
    }

    // Method to change each panel to a random background color
    private void changeColors() {
        northPanel.setBackground(new Color(rand.nextInt(256), rand.nextInt(256), rand.nextInt(256)));
        southPanel.setBackground(new Color(rand.nextInt(256), rand.nextInt(256), rand.nextInt(256)));
        eastPanel.setBackground(new Color(rand.nextInt(256), rand.nextInt(256), rand.nextInt(256)));
        westPanel.setBackground(new Color(rand.nextInt(256), rand.nextInt(256), rand.nextInt(256)));
        centerPanel.setBackground(new Color(rand.nextInt(256), rand.nextInt(256), rand.nextInt(256)));
    }

    // Main method to run the program
    public static void main(String[] args) {
        new Panels(); // Create and display the frame
    }
}