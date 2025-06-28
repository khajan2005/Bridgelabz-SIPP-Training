import java.util.*;

class Course {
    String courseName;
    Professor professor;
    List<Student> enrolledStudents = new ArrayList<>();

    Course(String name) {
        this.courseName = name;
    }

    void assignProfessor(Professor p) {
        this.professor = p;
    }

    void enrollStudent(Student s) {
        enrolledStudents.add(s);
    }

    void showInfo() {
        System.out.println("Course: " + courseName);
        if (professor != null) {
            System.out.println("Taught by: " + professor.name);
        }
        System.out.println("Enrolled Students:");
        for (Student s : enrolledStudents) {
            System.out.println("- " + s.name);
        }
    }
}

class Student {
    String name;

    Student(String name) {
        this.name = name;
    }

    void enrollCourse(Course c) {
        c.enrollStudent(this);
    }
}

class Professor {
    String name;

    Professor(String name) {
        this.name = name;
    }
}

public class UniversityManagementSystem {
    public static void main(String[] args) {
        Student s1 = new Student("Ravi");
        Student s2 = new Student("Meena");

        Professor prof = new Professor("Dr. Sharma");

        Course java = new Course("Java Programming");
        java.assignProfessor(prof);
        s1.enrollCourse(java);
        s2.enrollCourse(java);

        java.showInfo();
    }
}
