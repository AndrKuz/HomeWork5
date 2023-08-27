package hashmap;

public class CustomHashSet<E> {
    CustomHashMap<E, Object> map = new CustomHashMap<>();
    private final static Object PRESENT = new Object();

    public boolean add(E el) {
        return map.put(el, PRESENT) == null;
    }

    public boolean remove(E el) {
        return map.remove(el) == PRESENT;
    }

    public boolean contains(E el) {
        return map.containsKey(el);
    }

    public int size() {
        return map.size();
    }

    public static void main(String[] args) {
        CustomHashSet<String> defSet = new CustomHashSet<>();
        System.out.println(defSet.add("a"));
        System.out.println(defSet.add("b"));
        System.out.println(defSet.add("c"));
        System.out.println(defSet.size());
        System.out.println();
        System.out.println(defSet.contains("c"));
        System.out.println(defSet.remove("c"));
        System.out.println(defSet.size());
        System.out.println(defSet.contains("a"));
        System.out.println(defSet.contains("c"));
        System.out.println();
        System.out.println(defSet.contains("d"));
        System.out.println(defSet.add("d"));
        System.out.println(defSet.size());
        System.out.println(defSet.contains("d"));
        System.out.println(defSet.add("d"));
        System.out.println(defSet.size());
    }
}
