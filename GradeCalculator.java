import java.util.*;

class GradeCalculator {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter your Name : ");
        String name = sc.nextLine();

        System.out.println("Enter marks obtained in 6 subject (out of 100) :");
        System.out.print("1) Physics : ");
        int phy = sc.nextInt();
        System.out.print("2) Chemistry : ");
        int chem = sc.nextInt();
        System.out.print("3) Biology : ");
        int bio = sc.nextInt();
        System.out.print("4) Math : ");
        int math = sc.nextInt();
        System.out.print("5) Marathi : ");
        int marathi = sc.nextInt();
        System.out.print("6) English : ");
        int english = sc.nextInt();
        System.out.println("Student Name : " + name);

        int total = phy + chem + bio + math + marathi + english;
        int per = total / 6;
        System.out.println("Percentage of " + name + " is : " + per + "%");

        if (phy < 35 || chem < 35 || bio < 35 || math < 35 || marathi < 35 || english < 35) {
            System.out.println(name +" is fail");
        } else if (per > 75) {
            System.out.println("Grade : A");
        } else if (per > 60 && per < 75) {
            System.out.println("Grade : B");
        } else if (per > 45 && per < 60) {
            System.out.println("Grade : C");
        } else if (per > 35 && per < 45) {
            System.out.println("Grade : D");
        } else {
            System.out.println(name+"is fail");
        }
    }
}
