import java.util.*;

class Subject {
    String name;
    int marks;

    Subject(String name, int marks) {
        this.name = name;
        this.marks = marks;
    }
}

class Student {
    String name;
    List<Subject> subjects = new ArrayList<>();

    Student(String name) {
        this.name = name;
    }

    void addSubject(Subject s) {
        subjects.add(s);
    }

    List<Subject> getSubjects() {
        return subjects;
    }
}

class GradeCalculator {
    String calculateGrade(Student student) {
        int total = 0;
        List<Subject> subjects = student.getSubjects();
        for (Subject s : subjects) {
            total += s.marks;
        }

        double average = total / (double) subjects.size();

        if (average >= 90) return "A";
        else if (average >= 80) return "B";
        else if (average >= 70) return "C";
        else if (average >= 60) return "D";
        else return "F";
    }
}

public class SchoolResultsApplication {
    public static void main(String[] args) {
        Student john = new Student("John");
        john.addSubject(new Subject("Maths", 90));
        john.addSubject(new Subject("Science", 85));

        GradeCalculator gc = new GradeCalculator();
        String grade = gc.calculateGrade(john);

        System.out.println("Student: " + john.name);
        for (Subject s : john.getSubjects()) {
            System.out.println("Subject: " + s.name + ", Marks: " + s.marks);
        }
        System.out.println("Final Grade: " + grade);
    }
}
