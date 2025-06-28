import java.util.*;

class Faculty {
    String name;

    Faculty(String name) {
        this.name = name;
    }

    void show() {
        System.out.println("Faculty: " + name);
    }
}

class Department {
    String deptName;

    Department(String name) {
        this.deptName = name;
    }

    void show() {
        System.out.println("Department: " + deptName);
    }
}

class University {
    String uniName;
    List<Department> departments = new ArrayList<>();
    List<Faculty> faculties = new ArrayList<>();

    University(String name) {
        this.uniName = name;
    }

    void addDepartment(Department d) {
        departments.add(d);
    }

    void addFaculty(Faculty f) {
        faculties.add(f);
    }

    void deleteUniversity() {
        departments.clear();  
        System.out.println("University and its departments deleted.");
    }
}

public class UniversityStructure {
    public static void main(String[] args) {
        University uni = new University("Global University");

        Department cs = new Department("Computer Science");
        Department ee = new Department("Electrical");

        Faculty john = new Faculty("John");
        Faculty jane = new Faculty("Jane");

        uni.addDepartment(cs);
        uni.addDepartment(ee);
        uni.addFaculty(john);
        uni.addFaculty(jane);
        john.show();
        jane.show();
        uni.deleteUniversity();
    }
}
