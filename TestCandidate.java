package BAI7_8;

import java.util.*;

class Candidate {

    String id;
    String name;
    int day;
    int month;
    int year;
    double mark;
    double mark1;
    double mark2;

    Candidate() {

    }

    Candidate(String id, String name, int day, int month, int year, double mark, double mark1, double mark2) {
        this.id = id;
        this.name = name;
        this.day = day;
        this.month = month;
        this.year = year;
        this.mark = mark;
        this.mark1 = mark1;
        this.mark2 = mark2;
    }

    void input(Scanner sc) {
        System.out.print("* Code ID : ");
        id = sc.nextLine();
        System.out.print("* Name : ");
        name = sc.nextLine();
        System.out.print("* DayOfBirth : ");
        day = sc.nextInt();
        month = sc.nextInt();
        year = sc.nextInt();
        System.out.print("* Test Mark 1 : ");
        mark1 = sc.nextDouble();
        System.out.print("* Test Mark 2 : ");
        mark2 = sc.nextDouble();
        System.out.print("* Test Mark : ");
        mark = sc.nextDouble();
        sc.nextLine();
    }

    double Average() {
        return ((mark1 + mark2) / 2 + (mark * 2)) / 3;
    }

    int check(Candidate[] arr) {
        int count = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i].Average() >= 5) {
                count++;
            }
        }
        return count;
    }

    void infor(Candidate[] arr) {
        int count = 1;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i].Average() >= 5) {
                System.out.println("@Student " + count + " : ");
                System.out.println(arr[i].name);
                arr[i].display();
                count++;
            }
        }
    }

    void Rank() {
        double n = Average();
        if (n >= 8 && n <= 10) {
            System.out.println("- Good");
        } else if (n >= 7 && n < 8) {
            System.out.println("- Fairly good");
        } else if (n >= 5 && n < 7) {
            System.out.println("- Average");
        } else {
            System.out.println("- Fail");
        }
    }

    void display() {
        System.out.println("- The average mark = " + Average());
    }
}

public class TestCandidate {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Candidate f1 = new Candidate();
        Candidate f = new Candidate();
        System.out.println("***************EX7********************");
        f1.input(sc);
        f1.display();
        f1.Rank();
        System.out.println("\n***************EX8********************");
        System.out.print("\tEnter number student want input : ");
        int n =sc.nextInt();
        sc.nextLine();
        Candidate[] arr = new Candidate[n];
        System.out.println("\t Enter information 10 student :");
        for (int i = 0; i < n; i++) {
            arr[i] = new Candidate();
            System.out.println("*Student " + (i + 1) + " :");
            arr[i].input(sc);
        }
        System.out.println("- The number student pass : " + f.check(arr));
        System.out.println("- The information student pass :");
        f.infor(arr);

    }
}
