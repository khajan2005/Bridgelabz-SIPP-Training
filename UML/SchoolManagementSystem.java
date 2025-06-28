import java.util.*;

class Course {
    String courseName;
    List<Student> enrolledStudents = new ArrayList<>();

    Course(String name) {
        this.courseName = name;
    }

    void enrollStudent(Student s) {
        enrolledStudents.add(s);
    }

    void showEnrolledStudents() {
        System.out.println("Course: " + courseName);
        for (Student s : enrolledStudents) {
            System.out.println("- " + s.name);
        }
    }
}

class Student {
    String name;
    List<Course> courses = new ArrayList<>();

    Student(String name) {
        this.name = name;
    }

    void enrollInCourse(Course c) {
        courses.add(c);
        c.enrollStudent(this); 
    }

    void showCourses() {
        System.out.println("Student: " + name);
        for (Course c : courses) {
            System.out.println("- " + c.courseName);
        }
    }
}

class School {
    String schoolName;
    List<Student> students = new ArrayList<>();

    School(String name) {
        this.schoolName = name;
    }

    void addStudent(Student s) {
        students.add(s);
    }
}

public class SchoolManagementSystem {
    public static void main(String[] args) {
        School school = new School("Springfield High");

        Student alice = new Student("Alice");
        Student bob = new Student("Bob");

        Course math = new Course("Mathematics");
        Course physics = new Course("Physics");

        school.addStudent(alice);
        school.addStudent(bob);

        alice.enrollInCourse(math);
        alice.enrollInCourse(physics);
        bob.enrollInCourse(physics);

        alice.showCourses();
        bob.showCourses();
        math.showEnrolledStudents();
        physics.showEnrolledStudents();
    }
}
