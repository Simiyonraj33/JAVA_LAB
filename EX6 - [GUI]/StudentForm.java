import javax.swing.*;
import java.awt.*;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

/*
===============================================
 PROGRAM : Student Registration Form
 TOPIC   : Event Handling & GUI Programming
 GOAL    : Demonstrate Swing form creation 
           with small text fields, radio buttons, 
           checkboxes, and placeholder behavior.
===============================================
*/

public class StudentForm {

    public static void main(String[] args) {

        // ------------------ MAIN FRAME ------------------
        JFrame frame = new JFrame("Student Registration Form");
        frame.setSize(600, 600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Main panel with 10 rows → each row is one form section
        JPanel mainPanel = new JPanel(new GridLayout(10, 1, 5, 5));

        // ================== ROW 1: FULL NAME ==================
        JPanel namePanel = new JPanel(new GridLayout(2, 2, 5, 5));
        JLabel firstNameLabel = new JLabel("First Name:");
        JTextField firstNameField = new JTextField(20);
         // Placeholder behavior

        JLabel lastNameLabel = new JLabel("Last Name:");
        JTextField lastNameField = new JTextField(10);
        namePanel.add(firstNameLabel);
        namePanel.add(firstNameField);
        namePanel.add(lastNameLabel);
        namePanel.add(lastNameField);

        // ================== ROW 2: ADDRESS ==================
        JPanel addressPanel = new JPanel(new GridLayout(3, 2, 5, 5));
        addressPanel.add(new JLabel("Street Address:"));
        addressPanel.add(new JTextField(10));
        addressPanel.add(new JLabel("City:"));
        addressPanel.add(new JTextField(10));
        addressPanel.add(new JLabel("State/Province:"));
        addressPanel.add(new JTextField(10));

        // ================== ROW 3: BIRTH DATE ==================
        JPanel dobPanel = new JPanel(new GridLayout(1, 4, 5, 5));
        dobPanel.add(new JLabel("Birth Date:"));
        JTextField monthField = new JTextField(2);
       
        JTextField dayField = new JTextField(2);
        
        JTextField yearField = new JTextField(4);

        dobPanel.add(monthField);
        dobPanel.add(dayField);
        dobPanel.add(yearField);

        // ================== ROW 4: GENDER ==================
        JPanel genderPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        genderPanel.add(new JLabel("Gender:"));
        JRadioButton male = new JRadioButton("Male");
        JRadioButton female = new JRadioButton("Female");
        JRadioButton na = new JRadioButton("N/A");
        ButtonGroup bg = new ButtonGroup();
        bg.add(male);
        bg.add(female);
        bg.add(na);
        genderPanel.add(male);
        genderPanel.add(female);
        genderPanel.add(na);

        // ================== ROW 5: STUDENT NUMBER ==================
        JPanel studentNumPanel = new JPanel(new GridLayout(1, 2, 5, 5));
        studentNumPanel.add(new JLabel("Student Number:"));
        studentNumPanel.add(new JTextField(10));

        // ================== ROW 6: EMAIL ==================
        JPanel emailPanel = new JPanel(new GridLayout(1, 2, 5, 5));
        emailPanel.add(new JLabel("Student Email:"));
        emailPanel.add(new JTextField(15));

        // ================== ROW 7: COMPANY ==================
        JPanel companyPanel = new JPanel(new GridLayout(1, 2, 5, 5));
        companyPanel.add(new JLabel("Company:"));
        companyPanel.add(new JTextField(15));

        // ================== ROW 8: COURSES ==================
        JPanel coursePanel = new JPanel(new GridLayout(3, 3, 5, 5));
        coursePanel.add(new JLabel("Courses:"));
        JCheckBox c = new JCheckBox("C");
        JCheckBox cpp = new JCheckBox("C++");
        JCheckBox java = new JCheckBox("Java");
        JCheckBox python = new JCheckBox("Python");
        JCheckBox mysql = new JCheckBox("MySQL");
        JCheckBox js = new JCheckBox("JavaScript");
        JCheckBox ds = new JCheckBox("Data Science");
        JCheckBox web = new JCheckBox("Web Development");
        JCheckBox app = new JCheckBox("App Development");

        coursePanel.add(c);
        coursePanel.add(cpp);
        coursePanel.add(java);
        coursePanel.add(python);
        coursePanel.add(mysql);
        coursePanel.add(js);
        coursePanel.add(ds);
        coursePanel.add(web);
        coursePanel.add(app);

        // ================== ROW 9: COMMENTS ==================
        JPanel commentsPanel = new JPanel(new GridLayout(2, 1, 5, 5));
        commentsPanel.add(new JLabel("Additional Comments:"));
        commentsPanel.add(new JTextArea(3, 20));

        // ================== ROW 10: DATE ==================
        JPanel datePanel = new JPanel(new GridLayout(1, 2, 5, 5));
        datePanel.add(new JLabel("Date:"));
        datePanel.add(new JTextField(10));

        // ================== ADD PANELS TO MAIN PANEL ==================
        mainPanel.add(namePanel);
        mainPanel.add(addressPanel);
        mainPanel.add(dobPanel);
        mainPanel.add(genderPanel);
        mainPanel.add(studentNumPanel);
        mainPanel.add(emailPanel);
        mainPanel.add(companyPanel);
        mainPanel.add(coursePanel);
        mainPanel.add(commentsPanel);
        mainPanel.add(datePanel);

        // Add main panel to frame with scroll
        frame.add(new JScrollPane(mainPanel));
        frame.setVisible(true);
    }


    
}