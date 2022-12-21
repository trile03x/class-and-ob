import java.util.*;
public class Complex {
    float real;
    float imaginary;
    void display()
    {
        System.out.println(real +"+"+ imaginary+"i");
    }
    void input()
    {
        Scanner sc = new Scanner(System.in);
        float real = sc.nextFloat();
        float imaginary = sc.nextFloat();
        this.real = real;
        this.imaginary = imaginary;
    }
    static void AddComplex(Complex f1, Complex f2, Complex f3)
    {
        f3.real = f1.real+f2.real;
        f3.imaginary = f1.imaginary+f2.imaginary;
        f3.display();
    }
    static void Subtract(Complex f1, Complex f2, Complex f3)
    {
        f3.real = f1.real - f2.real;
        f3.imaginary = f3.imaginary - f2.imaginary;
        f3.display();
    }
    static void Multiply(Complex f1, Complex f2, Complex f3)
    {
        f3.real = f1.real * f2.real - f1.imaginary * f2.imaginary;
        f3.imaginary = f1.real * f2.imaginary + f2.real *f1.imaginary;
        f3.display();
    }
    static void Divide(Complex f1, Complex f2, Complex f3)
    {
        f3.real = (float) ((f1.real * f2.real + f1.imaginary * f2.imaginary)/(Math.pow(f2.real,2)+Math.pow(f2.imaginary, 2)));
        f3.imaginary = (float) ((f2.real * f1.imaginary - f1.real *f2.imaginary)/(Math.pow(f2.real,2)+Math.pow(f2.imaginary, 2)));
        f3.display();
    }
    public static void main(String[] args)
    {
        Complex f1 = new Complex();
        Complex f2 = new Complex();
        Complex f3 = new Complex();
        f1.input();
        f2.input();
        System.out.println("* Complex's form : ");
        System.out.print("- Complex number 1: ");
        f1.display();
        System.out.print("- Complex number 2: ");
        f2.display();
        System.out.print("- Add two complexes: ");
        f3.input();
        AddComplex(f1,f2,f3);
        System.out.print("- Subtract two complexes: ");
        Subtract(f1,f2,f3);
        System.out.print("- Multiply two complexes: ");
        Multiply(f1,f2,f3);
        System.out.print("- Divide two complexes: ");
        Divide(f1,f2,f3);
        System.out.print("- A complex value: ");
        f1.display();
        System.out.println(f1.real+" is the real park, "+f1.imaginary+" is the imaginary");
        
    }
}
