
public class Student {
    private String name;
    private int rollNo;
    private String course;


    Student() {
        this("Unknown", 0, "Not Assigned");
    }

    Student(String name, int rollNo) {
        this(name, rollNo, "B.Tech");
    }

    Student(String name, int rollNo, String course) {
        this.name = name;
        this.rollNo = rollNo;
        this.course = course;
    }

    public void display() {
        System.out.println("Name: " + this.name);
        System.out.println("RollNo: " + this.rollNo);
        System.out.println("Course: " + this.course);
    }

    public static void main(String[] args) {
        Student s1 = new Student();
        Student s2 = new Student("Rahul", 101);
        Student s3 = new Student("Aman", 102, "CSE");

        s1.display();
        s2.display();
        s3.display();
    }
}
