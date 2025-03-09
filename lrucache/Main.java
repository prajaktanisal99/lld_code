public class Main {

    public static void main(String []args) {

        LRUCache cache = new LRUCache(2);

        cache.put(1, 1); // [1]
        cache.put(2, 2); // [2, 1]

        System.out.println(cache.get(1)); // [1, 2] -> cache hit

        cache.put(3, 3); // [3, 1]

        System.out.println(cache.get(2)); // [3, 1] -> cache miss

        cache.put(4, 4); // [4, 3]

        System.out.println(cache.get(2)); // [4, 3] -> cache miss

        System.out.println(cache.get(3)); // [3, 4] -> cache hit

        System.out.println(cache.get(4)); // [4, 4] -> cache hit
    }
}
