package LinkedList.SinglyLinkedList;

import java.util.*;

class User {
    int userId;
    String name;
    int age;
    List<Integer> friendIds;
    User next;

    public User(int userId, String name, int age) {
        this.userId = userId;
        this.name = name;
        this.age = age;
        this.friendIds = new ArrayList<>();
        this.next = null;
    }
}

public class SocialMediaFriends {
    User head = null;

    public void addUser(int userId, String name, int age) {
        User newUser = new User(userId, name, age);
        if (head == null)
            head = newUser;
        else {
            User temp = head;
            while (temp.next != null)
                temp = temp.next;
            temp.next = newUser;
        }
    }

    public User getUserById(int userId) {
        User temp = head;
        while (temp != null) {
            if (temp.userId == userId)
                return temp;
            temp = temp.next;
        }
        return null;
    }

    public void addFriend(int userId1, int userId2) {
        User user1 = getUserById(userId1);
        User user2 = getUserById(userId2);
        if (user1 != null && user2 != null && userId1 != userId2) {
            if (!user1.friendIds.contains(userId2))
                user1.friendIds.add(userId2);
            if (!user2.friendIds.contains(userId1))
                user2.friendIds.add(userId1);
        }
    }

    public void removeFriend(int userId1, int userId2) {
        User user1 = getUserById(userId1);
        User user2 = getUserById(userId2);
        if (user1 != null && user2 != null) {
            user1.friendIds.remove(Integer.valueOf(userId2));
            user2.friendIds.remove(Integer.valueOf(userId1));
        }
    }

    public void displayFriends(int userId) {
        User user = getUserById(userId);
        if (user != null) {
            System.out.println("Friends of " + user.name + ":");
            for (int fid : user.friendIds) {
                User friend = getUserById(fid);
                if (friend != null) {
                    System.out.println("- " + friend.name + " (ID: " + friend.userId + ")");
                }
            }
        }
    }

    public void searchUser(String keyword) {
        User temp = head;
        while (temp != null) {
            if (String.valueOf(temp.userId).equals(keyword) || temp.name.equalsIgnoreCase(keyword)) {
                System.out.println("User ID: " + temp.userId + ", Name: " + temp.name + ", Age: " + temp.age);
            }
            temp = temp.next;
        }
    }

    public void mutualFriends(int userId1, int userId2) {
        User user1 = getUserById(userId1);
        User user2 = getUserById(userId2);
        if (user1 != null && user2 != null) {
            Set<Integer> set1 = new HashSet<>(user1.friendIds);
            System.out.println("Mutual Friends between " + user1.name + " and " + user2.name + ":");
            for (int fid : user2.friendIds) {
                if (set1.contains(fid)) {
                    User friend = getUserById(fid);
                    if (friend != null) {
                        System.out.println("- " + friend.name + " (ID: " + friend.userId + ")");
                    }
                }
            }
        }
    }

    public void countFriends() {
        User temp = head;
        while (temp != null) {
            System.out.println(temp.name + " has " + temp.friendIds.size() + " friend(s).");
            temp = temp.next;
        }
    }

    public static void main(String[] args) {
        SocialMediaFriends sm = new SocialMediaFriends();
        sm.addUser(1, "Alice", 25);
        sm.addUser(2, "Bob", 28);
        sm.addUser(3, "Charlie", 22);
        sm.addUser(4, "Daisy", 30);

        sm.addFriend(1, 2);
        sm.addFriend(1, 3);
        sm.addFriend(2, 3);
        sm.addFriend(3, 4);

        sm.displayFriends(1);
        sm.displayFriends(3);

        sm.mutualFriends(1, 3);
        sm.searchUser("Daisy");
        sm.countFriends();

        sm.removeFriend(1, 2);
        sm.displayFriends(1);
    }
}
