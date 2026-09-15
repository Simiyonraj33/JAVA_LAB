
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class StudentDatabaseApp extends JFrame implements ActionListener {

    // ---------- DECLARE COMPONENTS ----------
    JTextField t1, t2, t3, t4, t5, t6, t7, t8;
    JButton insertBtn, viewBtn, updateBtn, deleteBtn;
    Connection con;
    PreparedStatement pst;
    ResultSet rs;

    // ---------- CONSTRUCTOR ----------
    public StudentDatabaseApp() {

        setTitle("Student Database App");
        setLayout(new GridLayout(10, 2, 10, 10));
        setSize(420, 450);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        // ---------- LABELS AND TEXTFIELDS ----------
        add(new JLabel("Roll No:"));
        t1 = new JTextField();
        add(t1);

        add(new JLabel("Name:"));
        t2 = new JTextField();
        add(t2);

        add(new JLabel("Mark 1:"));
        t3 = new JTextField();
        add(t3);

        add(new JLabel("Mark 2:"));
        t4 = new JTextField();
        add(t4);

        add(new JLabel("Mark 3:"));
        t5 = new JTextField();
        add(t5);

        add(new JLabel("Mark 4:"));
        t6 = new JTextField();
        add(t6);

        add(new JLabel("Mark 5:"));
        t7 = new JTextField();
        add(t7);

        add(new JLabel("Average:"));
        t8 = new JTextField();
        t8.setEditable(false);
        add(t8);

        // ---------- BUTTONS ----------
        insertBtn = new JButton("Insert");
        viewBtn = new JButton("View");
        updateBtn = new JButton("Update");
        deleteBtn = new JButton("Delete");

        add(insertBtn);
        add(viewBtn);
        add(updateBtn);
        add(deleteBtn);

        // ---------- EVENT HANDLERS ----------
        insertBtn.addActionListener(this);
        viewBtn.addActionListener(this);
        updateBtn.addActionListener(this);
        deleteBtn.addActionListener(this);

        // ---------- CONNECT TO DB ----------
        connect();

        setVisible(true);
    }

    // ------------------------------------------------------------------
    // Function: Connect to Oracle Database
    // ------------------------------------------------------------------
    void connect() {
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            con = DriverManager.getConnection(
                    "jdbc:oracle:thin:@localhost:1521:xe",
                    "system",
                    "database");
            System.out.println("✅ Connected to Oracle Database");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "DB Connection Failed: " + e.getMessage());
        }
    }

    // ------------------------------------------------------------------
    // Function: Validate that all fields are filled
    // ------------------------------------------------------------------
    boolean validateFields() {
        if (t1.getText().isEmpty() || t2.getText().isEmpty() ||
            t3.getText().isEmpty() || t4.getText().isEmpty() ||
            t5.getText().isEmpty() || t6.getText().isEmpty() ||
            t7.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "⚠️ Please fill all fields!");
            return false;
        }
        return true;
    }

    // ------------------------------------------------------------------
    // Function: Clear all fields after insertion or deletion
    // ------------------------------------------------------------------
    void clearFields() {
        t1.setText("");
        t2.setText("");
        t3.setText("");
        t4.setText("");
        t5.setText("");
        t6.setText("");
        t7.setText("");
        t8.setText("");
        t1.requestFocus();
    }

    // ------------------------------------------------------------------
    // Function: Handle all button clicks
    // ------------------------------------------------------------------
    public void actionPerformed(ActionEvent e) {
        try {
            // ---------------------------------------------------------------
            // INSERT BUTTON
            // ---------------------------------------------------------------
            if (e.getSource() == insertBtn) {

                if (!validateFields()) return;

                int roll = Integer.parseInt(t1.getText());
                String name = t2.getText();
                int m1 = Integer.parseInt(t3.getText());
                int m2 = Integer.parseInt(t4.getText());
                int m3 = Integer.parseInt(t5.getText());
                int m4 = Integer.parseInt(t6.getText());
                int m5 = Integer.parseInt(t7.getText());

                double avg = (m1 + m2 + m3 + m4 + m5) / 5.0;
                t8.setText(String.valueOf(avg));

                pst = con.prepareStatement("INSERT INTO students VALUES (?, ?, ?, ?, ?, ?, ?, ?)");
                pst.setInt(1, roll);
                pst.setString(2, name);
                pst.setInt(3, m1);
                pst.setInt(4, m2);
                pst.setInt(5, m3);
                pst.setInt(6, m4);
                pst.setInt(7, m5);
                pst.setDouble(8, avg);

                pst.executeUpdate();
                JOptionPane.showMessageDialog(this, "✅ Record Inserted Successfully!");
                clearFields();
            }

         // VIEW OPERATION - show details of a student
            else if (e.getSource() == viewBtn) {

                try {
                    // Check if Roll No field is empty
                    if(t1.getText().isEmpty()) {
                        JOptionPane.showMessageDialog(this, "Please enter Roll No!");
                        return;  // Stop if no Roll No entered
                    }

                    // Prepare SQL query to get student details for given Roll No
                    pst = con.prepareStatement("SELECT * FROM students WHERE rollno=?");

                    // Set the Roll No parameter in the query
                    pst.setInt(1, Integer.parseInt(t1.getText()));

                    // Execute query and store result
                    rs = pst.executeQuery();

                    // Create new window to display results
                    JFrame f = new JFrame("Student Details");
                    f.setSize(300, 230);

                    // Create text area for displaying student info
                    JTextArea ta = new JTextArea();
                    ta.setEditable(false);  // Prevent user from editing
                    f.add(ta);

                    // Check if student exists
                    if(rs.next()) {
                        // Display student details in the text area
                        ta.setText("Roll No  : " + rs.getInt(1) +
                                   "\nName    : " + rs.getString(2) +
                                   "\nMark 1  : " + rs.getInt(3) +
                                   "\nMark 2  : " + rs.getInt(4) +
                                   "\nMark 3  : " + rs.getInt(5) +
                                   "\nMark 4  : " + rs.getInt(6) +
                                   "\nMark 5  : " + rs.getInt(7) +
                                   "\nAverage : " + rs.getDouble(8));
                    } else {
                        // If student not found, show message
                        ta.setText("No Record Found for Roll No : " + t1.getText());
                    }

                    // Make the window visible
                    f.setVisible(true);

                } catch(Exception ex) {
                    // Show error message if something goes wrong
                    JOptionPane.showMessageDialog(this, "Error: " + ex.getMessage());
                }
            }

            // ---------------------------------------------------------------
            // UPDATE BUTTON
            // ---------------------------------------------------------------
            else if (e.getSource() == updateBtn) {

                if (!validateFields()) return;

                int roll = Integer.parseInt(t1.getText());
                String name = t2.getText();
                int m1 = Integer.parseInt(t3.getText());
                int m2 = Integer.parseInt(t4.getText());
                int m3 = Integer.parseInt(t5.getText());
                int m4 = Integer.parseInt(t6.getText());
                int m5 = Integer.parseInt(t7.getText());
                double avg = (m1 + m2 + m3 + m4 + m5) / 5.0;
                t8.setText(String.valueOf(avg));

                pst = con.prepareStatement(
                        "UPDATE students SET name=?, mark1=?, mark2=?, mark3=?, mark4=?, mark5=?, average=? WHERE rollno=?");

                pst.setString(1, name);
                pst.setInt(2, m1);
                pst.setInt(3, m2);
                pst.setInt(4, m3);
                pst.setInt(5, m4);
                pst.setInt(6, m5);
                pst.setDouble(7, avg);
                pst.setInt(8, roll);

                int rows = pst.executeUpdate();
                if (rows > 0)
                    JOptionPane.showMessageDialog(this, "✅ Record Updated Successfully!");
                else
                    JOptionPane.showMessageDialog(this, "❌ No record found!");
            }

            // ---------------------------------------------------------------
            // DELETE BUTTON
            // ---------------------------------------------------------------
            else if (e.getSource() == deleteBtn) {

                if (t1.getText().isEmpty()) {
                    JOptionPane.showMessageDialog(this, "Enter Roll No to delete record!");
                    return;
                }

                pst = con.prepareStatement("DELETE FROM students WHERE rollno=?");
                pst.setInt(1, Integer.parseInt(t1.getText()));

                int rows = pst.executeUpdate();
                if (rows > 0) {
                    JOptionPane.showMessageDialog(this, "🗑️ Record Deleted Successfully!");
                    clearFields();
                } else {
                    JOptionPane.showMessageDialog(this, "❌ No record found!");
                }
            }

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Error: " + ex.getMessage());
        }
    }

    // ------------------------------------------------------------------
    // MAIN METHOD
    // ------------------------------------------------------------------
    public static void main(String[] args) {
        new StudentDatabaseApp();
    }
}
