

//File: Surgeon.java
public class Surgeon extends Doctor
{
 private String department;

 public Surgeon(int id, String name, String department)
 {
     // Call the constructor of the parent class (Doctor)
     super(id, name);
     this.department = department;
 }

 /**
  * Overridden to print the doctor's name and their department.
  * It uses the 'name' field inherited from the Doctor class.
  * @return A string containing the name and department.
  */
 @Override
 public String toString()
 {
     return "Name: " + this.name + ", Department: " + this.department;
 }
};