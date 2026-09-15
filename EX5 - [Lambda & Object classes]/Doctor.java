

public class Doctor
{
    protected int id;
    protected String name;

    public Doctor(int id, String name)
    {
        this.id = id;
        this.name = name;
    }

    @Override
    public int hashCode()
    {
        return id;
    }

    @Override
    public boolean equals(Object obj)
    {
        if (this == obj)
        {
            return true;
        }
        if (obj == null || !(obj instanceof Doctor))
        {
            return false;
        }
        Doctor other = (Doctor) obj;
        return this.id == other.id;
    }

    @Override
    public String toString()
    {
        return "ID: " + this.id + ", Name: " + this.name;
    }

    // Add this main method
    public static void main(String[] args)
    {
        Doctor d1 = new Doctor(1, "John Doe");
        Doctor d2 = new Doctor(2, "Jane Smith");

        System.out.println(d1);
        System.out.println(d2);
        System.out.println("Are they equal? " + d1.equals(d2));
    }
}