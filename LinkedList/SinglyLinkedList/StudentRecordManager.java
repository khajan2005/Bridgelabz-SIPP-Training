package LinkedList.SinglyLinkedList;

class Student {
    int rollNo, age;
    String name, grade;
    Student next;

    public Student(int rollNo, String name, int age, String grade) {
        this.rollNo = rollNo;
        this.name = name;
        this.age = age;
        this.grade = grade;
        this.next = null;
    }
}

public class StudentRecordManager {
    Student head;

    void addFirst(Student s) {
        s.next = head;
        head = s;
    }

    void addLast(Student s) {
        if (head == null) {
            head = s;
            return;
        }
        Student temp = head;
        while (temp.next != null)
            temp = temp.next;
        temp.next = s;
    }

    void addAtPosition(Student s, int pos) {
        if (pos <= 0 || head == null) {
            addFirst(s);
            return;
        }
        Student temp = head;
        for (int i = 1; i < pos && temp.next != null; i++)
            temp = temp.next;
        s.next = temp.next;
        temp.next = s;
    }

    void deleteByRoll(int rollNo) {
        if (head == null)
            return;
        if (head.rollNo == rollNo) {
            head = head.next;
            return;
        }
        Student temp = head;
        while (temp.next != null && temp.next.rollNo != rollNo)
            temp = temp.next;
        if (temp.next != null)
            temp.next = temp.next.next;
    }

    Student search(int rollNo) {
        Student temp = head;
        while (temp != null) {
            if (temp.rollNo == rollNo)
                return temp;
            temp = temp.next;
        }
        return null;
    }

    void updateGrade(int rollNo, String newGrade) {
        Student s = search(rollNo);
        if (s != null)
            s.grade = newGrade;
    }

    void displayAll() {
        Student temp = head;
        while (temp != null) {
            System.out.println(temp.rollNo + " " + temp.name + " " + temp.age + " " + temp.grade);
            temp = temp.next;
        }
    }
}
