package hashmap;

import java.util.Objects;

public class CustomHashMap<K, V> {
    private int size;
    private MyMapBucket[] buckets;
    private final int CAPACITY = 10;

    public CustomHashMap() {
        this.buckets = new MyMapBucket[CAPACITY];
    }

    private int getHash(K key) {
        return (key == null) ? 0 : (key.hashCode() & 0xfffffff) % CAPACITY;
    }

    private MyKeyValueEntry getEntry(K key) {
        int hash = getHash(key);
        for(int i = 0; i < buckets[hash].getEntries().size(); i++) {
            MyKeyValueEntry myKeyValueEntry = buckets[hash].getEntries().get(i);
            if (myKeyValueEntry.getKey().equals(key)) {
                return myKeyValueEntry;
            }
        }
        return null;
    }

    public boolean containsKey(K key) {
        int hash = getHash(key);
        return !(Objects.isNull(buckets[hash]) || Objects.isNull(getEntry(key)));
    }

    public V put(K key, V value) {
        if (containsKey(key)) {
            MyKeyValueEntry entry = getEntry(key);
            V temp = (V) entry.getValue();
            entry.setValue(value);
            return temp;
        } else {
            int hash = getHash(key);
            if (buckets[hash] == null) {
                buckets[hash] = new MyMapBucket();
            }
            buckets[hash].addEntry(new MyKeyValueEntry(key, value));
            size++;
        }
        return null;
    }

    public V get(K key) {
        return containsKey(key) ? (V) getEntry(key).getValue() : null;
    }

    public V remove(K key) {
        if (containsKey(key)) {
            V temp = get(key);
            int hash = getHash(key);
            buckets[hash].removeEntry(getEntry(key));
            size--;
            return temp;
        }
        return null;
    }

    public int size() {
        return size;
    }

    public static void main(String[] args) {
        CustomHashMap<String, Integer> map = new CustomHashMap<>();
        map.put("one", 1);
        map.put("two", 2);
        map.put("three", 3);

        System.out.println(map.size());
        System.out.println(map.get("two"));
        System.out.println();
        System.out.println(map.put("two", 22));
        System.out.println(map.size());
        System.out.println(map.get("two"));
    }
}
