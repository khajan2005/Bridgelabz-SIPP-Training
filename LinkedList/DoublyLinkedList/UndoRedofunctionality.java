package LinkedList.DoublyLinkedList;

class TextState {
    String content;
    TextState prev;
    TextState next;

    public TextState(String content) {
        this.content = content;
        this.prev = null;
        this.next = null;
    }
}

public class UndoRedofunctionality {
    private TextState head = null;
    private TextState tail = null;
    private TextState current = null;
    private int size = 0;
    private final int MAX_HISTORY = 10;

    public void addState(String content) {
        TextState newState = new TextState(content);
        if (current != null && current.next != null) {
            current.next.prev = null;
            current.next = null;
            tail = current;
        }
        if (head == null) {
            head = tail = newState;
        } else {
            tail.next = newState;
            newState.prev = tail;
            tail = newState;
        }
        current = newState;
        size++;
        if (size > MAX_HISTORY) {
            head = head.next;
            head.prev = null;
            size--;
        }
    }

    public void undo() {
        if (current != null && current.prev != null) {
            current = current.prev;
        }
    }

    public void redo() {
        if (current != null && current.next != null) {
            current = current.next;
        }
    }

    public void showCurrentState() {
        if (current != null) {
            System.out.println("Current State: " + current.content);
        } else {
            System.out.println("No state available.");
        }
    }

    public static void main(String[] args) {
        UndoRedofunctionality editor = new UndoRedofunctionality();
        editor.addState("Hello");
        editor.addState("Hello World");
        editor.addState("Hello World!");
        editor.showCurrentState();

        editor.undo();
        editor.showCurrentState();

        editor.undo();
        editor.showCurrentState();

        editor.redo();
        editor.showCurrentState();

        editor.addState("New Edit");
        editor.showCurrentState();

        editor.redo();
        editor.showCurrentState();
    }
}
