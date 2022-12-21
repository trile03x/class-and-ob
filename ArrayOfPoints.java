package BAI4_5;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

class Point {

    int A;
    int B;

    Point() {
        A = 0;
        B = 0;
    }

    Point(int A, int B) {
        this.A = A;
        this.B = B;
    }

     void input() {
        Scanner sc = new Scanner(System.in);
        A = sc.nextInt();
        B = sc.nextInt();
    }

     void display() {
        System.out.print("-(" + A + ";" + B + ") :");
        System.out.println(A + " is the abscissa and " + B + " is the ordinate");
    }

     double distance(Point f2) {
        return (double) Math.sqrt(Math.pow(f2.A - A, 2) + Math.pow(f2.B - B, 2));
    }

     double area(Point f1, Point f2) {

        return (double) Math.abs((f2.A - f1.A) * (B - f1.B) - (A - f1.A) * (f2.B - f1.B)) / 2;
    }

     double Max3Distance(Point[] ArrPoint) {
        double maxarea = 0;
        ArrayList<Double> Krr = new ArrayList<Double>();
        for (int i = 0; i < ArrPoint.length; i++) {
            for (int j = i + 1; j < ArrPoint.length; j++) {
                double kc = ArrPoint[i].distance(ArrPoint[j]);
                Krr.add(kc);
            }
        }
        Double[] temp = new Double[Krr.size()];
        for (int i = 0; i < Krr.size(); i++) {
            temp[i] = Krr.get(i);
        }
        Arrays.sort(temp);
        int i = temp.length;
        double cv = (temp[i-1]+temp[i-2]+temp[i-3])/2;
        return maxarea = Math.sqrt( cv*(cv-temp[i-1])*(cv-temp[i-2])*(cv-temp[i-3]));
    }

     double MaxDistance(Point[] ArrPoint) {
        double maxkc = 0;
        for (int i = 0; i < ArrPoint.length; i++) {
            for (int j = i + 1; j < ArrPoint.length; j++) {
                if (ArrPoint[i].distance(ArrPoint[j]) >= maxkc) {
                    maxkc = ArrPoint[i].distance(ArrPoint[j]);
                }
            }
        }
        return maxkc;
    }
}

public class ArrayOfPoints {

    public static void main(String[] args) {
        Point f1 = new Point();
        Point f2 = new Point();
        Point f3 = new Point();
        f1.input();
        f2.input();
        f3.input();
        System.out.println("Point 1: ");
        f1.display();
        System.out.println("Point 2: ");
        f2.display();
        System.out.println("Point 3: ");
        f3.display();
        double kc = f1.distance(f2);
        System.out.println("- The distance Point 1 & Point 2 :" + kc);
        double dt = f3.area(f1, f2);
        System.out.println("- The area = " + dt);
        Point[] ArrPoint = new Point[10];
        System.out.println("- Enter 10 point :");
        for (int i = 0; i < ArrPoint.length; i++) {
            System.out.println("* Point " + (i + 1));
            ArrPoint[i] = new Point();
            ArrPoint[i].input();
        }
        Point f4 = new Point();
        double result = f4.MaxDistance(ArrPoint);
        System.out.println("- Largest distance between 2 point in 10 point = " + result);
        double maxdt = f4.Max3Distance(ArrPoint);
        System.out.println("- Triangle that has largest area in 10 points = "+maxdt);

    }
}
