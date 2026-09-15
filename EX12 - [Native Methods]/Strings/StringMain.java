import java.util.*;
public class StringMain
{
	public native int StringLength(String s);
    public native String Reverse(String s);
    public static void main(String[] args)
    {
		Scanner sc = new Scanner(System.in);
        String a;
        System.out.println("Enter a String :");
        a  = sc.next();
	    StringMain st = new StringMain();
        System.out.println("String Length :"+st.StringLength(a));
        System.out.println("Reversed String : "+st.Reverse(a));
    }
}



