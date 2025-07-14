class CustomHashMap {
    static class Entry {
        int key, value;
        Entry next;

        Entry(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    private final int SIZE = 16;
    private Entry[] table = new Entry[SIZE];

    private int getHash(int key) {
        return key % SIZE;
    }

    public void put(int key, int value) {
        int hash = getHash(key);
        Entry newEntry = new Entry(key, value);
        if (table[hash] == null) {
            table[hash] = newEntry;
        } else {
            Entry current = table[hash];
            while (current != null) {
                if (current.key == key) {
                    current.value = value;
                    return;
                }
                if (current.next == null) {
                    current.next = newEntry;
                    return;
                }
                current = current.next;
            }
        }
    }

    public Integer get(int key) {
        int hash = getHash(key);
        Entry current = table[hash];
        while (current != null) {
            if (current.key == key) {
                return current.value;
            }
            current = current.next;
        }
        return null;
    }

    public void remove(int key) {
        int hash = getHash(key);
        Entry current = table[hash];
        Entry prev = null;
        while (current != null) {
            if (current.key == key) {
                if (prev == null) {
                    table[hash] = current.next;
                } else {
                    prev.next = current.next;
                }
                return;
            }
            prev = current;
            current = current.next;
        }
    }
}
