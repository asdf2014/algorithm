/**
* 采用数组加链表的方式实现
**/
class MyHashMap {
private class Pair {
        private int key;
        private int value;

        public Pair(int key, int value) {
            this.key = key;
            this.value = value;
        }

        public int getKey() {
            return key;
        }

        public void setKey(int key) {
            this.key = key;
        }

        public int getValue() {
            return value;
        }

        public void setValue(int value) {
            this.value = value;
        }
    }

    private LinkedList[] data;
    private static final int BASE = 1000;

    /**
     * Initialize your data structure here.
     */
    public MyHashMap() {
        data = new LinkedList[BASE];
        for (int i = 0; i < BASE; i++) {
            data[i] = new LinkedList<Pair>();
        }
    }

    /**
     * value will always be non-negative.
     */
    public void put(int key, int value) {
        int index = hash(key);
        for (Pair pair : (Iterable<Pair>) data[index]) {
            if (pair.getKey() == key) {
                pair.setValue(value);
                return;
            }
        }
        data[index].offerLast(new Pair(key, value));
    }

    /**
     * Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key
     */
    public int get(int key) {
        int index = hash(key);
        for (Pair pair : (Iterable<Pair>) data[index]) {
            if (pair.getKey() == key) {
                return pair.getValue();
            }
        }
        return -1;
    }

    /**
     * Removes the mapping of the specified value key if this map contains a mapping for the key
     */
    public void remove(int key) {
        int index = hash(key);
        for (Pair pair : (Iterable<Pair>) data[index]) {
            if (pair.getKey() == key) {
                data[index].remove(pair);
                return;
            }
        }
    }

    private int hash(int key) {
        return key % BASE;
    }
}