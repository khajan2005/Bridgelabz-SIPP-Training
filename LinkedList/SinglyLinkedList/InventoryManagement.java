package LinkedList.SinglyLinkedList;

class Item {
    int itemId, quantity;
    double price;
    String itemName;
    Item next;

    public Item(int itemId, String itemName, int quantity, double price) {
        this.itemId = itemId;
        this.itemName = itemName;
        this.quantity = quantity;
        this.price = price;
        this.next = null;
    }
}

public class InventoryManagement {
    private Item head;

    public void addFirst(Item newItem) {
        newItem.next = head;
        head = newItem;
    }

    public void addLast(Item newItem) {
        if (head == null) {
            head = newItem;
            return;
        }
        Item temp = head;
        while (temp.next != null)
            temp = temp.next;
        temp.next = newItem;
    }

    public void addAtPosition(Item newItem, int pos) {
        if (pos <= 0 || head == null) {
            addFirst(newItem);
            return;
        }
        Item temp = head;
        for (int i = 1; i < pos && temp.next != null; i++)
            temp = temp.next;
        newItem.next = temp.next;
        temp.next = newItem;
    }

    public void removeById(int itemId) {
        if (head == null)
            return;
        if (head.itemId == itemId) {
            head = head.next;
            return;
        }
        Item temp = head;
        while (temp.next != null && temp.next.itemId != itemId)
            temp = temp.next;
        if (temp.next != null)
            temp.next = temp.next.next;
    }

    public void updateQuantity(int itemId, int newQty) {
        Item temp = head;
        while (temp != null) {
            if (temp.itemId == itemId) {
                temp.quantity = newQty;
                return;
            }
            temp = temp.next;
        }
    }

    public void searchItem(String keyword) {
        Item temp = head;
        while (temp != null) {
            if (String.valueOf(temp.itemId).equals(keyword) || temp.itemName.equalsIgnoreCase(keyword)) {
                System.out.println(
                        temp.itemId + " " + temp.itemName + " Qty: " + temp.quantity + " Price: " + temp.price);
            }
            temp = temp.next;
        }
    }

    public void displayTotalValue() {
        double total = 0;
        Item temp = head;
        while (temp != null) {
            total += temp.quantity * temp.price;
            temp = temp.next;
        }
        System.out.println("Total Inventory Value: Rs. " + total);
    }

    public void displayAll() {
        Item temp = head;
        while (temp != null) {
            System.out.println(temp.itemId + " " + temp.itemName + " Qty: " + temp.quantity + " Price: " + temp.price);
            temp = temp.next;
        }
    }

    public void sortByField(String field, boolean ascending) {
        head = mergeSort(head, field, ascending);
    }

    private Item mergeSort(Item head, String field, boolean asc) {
        if (head == null || head.next == null)
            return head;

        Item middle = getMiddle(head);
        Item nextOfMiddle = middle.next;
        middle.next = null;

        Item left = mergeSort(head, field, asc);
        Item right = mergeSort(nextOfMiddle, field, asc);

        return sortedMerge(left, right, field, asc);
    }

    private Item sortedMerge(Item a, Item b, String field, boolean asc) {
        if (a == null)
            return b;
        if (b == null)
            return a;

        Item result;
        boolean condition;
        if (field.equalsIgnoreCase("name")) {
            condition = asc ? a.itemName.compareToIgnoreCase(b.itemName) <= 0
                    : a.itemName.compareToIgnoreCase(b.itemName) > 0;
        } else {
            condition = asc ? a.price <= b.price : a.price > b.price;
        }

        if (condition) {
            result = a;
            result.next = sortedMerge(a.next, b, field, asc);
        } else {
            result = b;
            result.next = sortedMerge(a, b.next, field, asc);
        }
        return result;
    }

    private Item getMiddle(Item head) {
        if (head == null)
            return head;
        Item slow = head, fast = head.next;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    public static void main(String[] args) {
        InventoryManagement inv = new InventoryManagement();
        inv.addLast(new Item(101, "Pen", 50, 10));
        inv.addLast(new Item(102, "Notebook", 20, 40));
        inv.addFirst(new Item(103, "Pencil", 100, 5));

        System.out.println("All Items:");
        inv.displayAll();

        System.out.println("\nTotal Value:");
        inv.displayTotalValue();

        System.out.println("\nSort by Name Ascending:");
        inv.sortByField("name", true);
        inv.displayAll();

        System.out.println("\nSearch by Item Name 'Pen':");
        inv.searchItem("Pen");

        System.out.println("\nUpdating Quantity of Item ID 101:");
        inv.updateQuantity(101, 70);
        inv.displayAll();

        System.out.println("\nRemoving Item ID 102:");
        inv.removeById(102);
        inv.displayAll();
    }
}
