// Program: Arithmetic Operations using Native Methods (with User Input)
// Aim: To call C functions from Java using JNI for basic arithmetic operations.

import java.util.Scanner;

public class NativeArithmetic {

    // Declaration of native methods
    public native int add(int a, int b);
    public native int sub(int a, int b);
    public native int mul(int a, int b);
    public native int div(int a, int b);

    // Load the shared library
    static {
        System.loadLibrary("ArithmeticLib"); // ArithmeticLib.dll / .so / .dylib
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        NativeArithmetic obj = new NativeArithmetic();

        System.out.print("Enter first number: ");
        int a = sc.nextInt();

        System.out.print("Enter second number: ");
        int b = sc.nextInt();

        System.out.println("\n--- Arithmetic Operations ---");
        System.out.println("Addition: " + obj.add(a, b));
        System.out.println("Subtraction: " + obj.sub(a, b));
        System.out.println("Multiplication: " + obj.mul(a, b));
        System.out.println("Division: " + obj.div(a, b));

        sc.close();
    }
}







TO RUN THIS CODE  :



E:\MSEC\SEM3\JAVA\EX12 - [Native Methods]>javac NativeArithmetic.java

NativeArithmetic.class file generated ..........




E:\MSEC\SEM3\JAVA\EX12 - [Native Methods]>javac -h . NativeArithmetic.java

NativeArithmetic.h file created.............



E:\MSEC\SEM3\JAVA\EX12 - [Native Methods]>gcc -I"%JAVA_HOME%\include" -I"%JAVA_HOME%\include\win32" -shared -o ArithmeticLib.dll ArithmeticLib.c

ArithmeticLib.dll file ....................



E:\MSEC\SEM3\JAVA\EX12 - [Native Methods]>java NativeArithmetic

output .........................