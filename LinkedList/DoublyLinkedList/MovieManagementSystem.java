package LinkedList.DoublyLinkedList;

class Movie {
    String title, director;
    int year;
    double rating;
    Movie next, prev;

    public Movie(String title, String director, int year, double rating) {
        this.title = title;
        this.director = director;
        this.year = year;
        this.rating = rating;
    }
}

public class MovieManagementSystem {
    Movie head, tail;

    void addFirst(Movie m) {
        if (head == null) {
            head = tail = m;
        } else {
            m.next = head;
            head.prev = m;
            head = m;
        }
    }

    void addLast(Movie m) {
        if (tail == null) {
            head = tail = m;
        } else {
            tail.next = m;
            m.prev = tail;
            tail = m;
        }
    }

    void addAtPosition(Movie m, int pos) {
        if (pos <= 0 || head == null) {
            addFirst(m);
            return;
        }
        Movie temp = head;
        for (int i = 1; i < pos && temp.next != null; i++)
            temp = temp.next;
        m.next = temp.next;
        m.prev = temp;
        if (temp.next != null)
            temp.next.prev = m;
        temp.next = m;
        if (m.next == null)
            tail = m;
    }

    void deleteByTitle(String title) {
        Movie temp = head;
        while (temp != null && !temp.title.equals(title))
            temp = temp.next;
        if (temp == null)
            return;
        if (temp.prev != null)
            temp.prev.next = temp.next;
        else
            head = temp.next;
        if (temp.next != null)
            temp.next.prev = temp.prev;
        else
            tail = temp.prev;
    }

    void searchByDirector(String director) {
        Movie temp = head;
        while (temp != null) {
            if (temp.director.equalsIgnoreCase(director))
                System.out.println(temp.title + " " + temp.year + " " + temp.rating);
            temp = temp.next;
        }
    }

    void searchByRating(double rating) {
        Movie temp = head;
        while (temp != null) {
            if (temp.rating == rating)
                System.out.println(temp.title + " " + temp.director);
            temp = temp.next;
        }
    }

    void updateRating(String title, double newRating) {
        Movie temp = head;
        while (temp != null) {
            if (temp.title.equals(title)) {
                temp.rating = newRating;
                return;
            }
            temp = temp.next;
        }
    }

    void displayForward() {
        Movie temp = head;
        while (temp != null) {
            System.out.println(temp.title + " " + temp.director + " " + temp.year + " " + temp.rating);
            temp = temp.next;
        }
    }

    void displayReverse() {
        Movie temp = tail;
        while (temp != null) {
            System.out.println(temp.title + " " + temp.director + " " + temp.year + " " + temp.rating);
            temp = temp.prev;
        }
    }
}
