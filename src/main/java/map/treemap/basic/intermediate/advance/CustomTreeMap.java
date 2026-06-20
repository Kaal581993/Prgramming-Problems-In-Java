package map.treemap.basic.intermediate.advance;

class Node<K, V> {
    K key;
    V value;
    Node<K, V> left, right;

    public Node(K key, V value) {
        this.key = key;
        this.value = value;
    }
}

// Simplified Binary Search Tree implementation for the custom map
public class CustomTreeMap<K extends Comparable<K>, V> {
    private Node<K, V> root;

    public void put(K key, V value) {
        root = put(root, key, value);
    }

    private Node<K, V> put(Node<K, V> node, K key, V value) {
        if (node == null) {
            return new Node<>(key, value);
        }
        int cmp = key.compareTo(node.key);
        if (cmp < 0) {
            node.left = put(node.left, key, value);
        } else if (cmp > 0) {
            node.right = put(node.right, key, value);
        } else {
            node.value = value; // Update value for existing key
        }
        return node;
    }

    public V get(K key) {
        Node<K, V> node = get(root, key);
        return node == null ? null : node.value;
    }

    private Node<K, V> get(Node<K, V> node, K key) {
        if (node == null) {
            return null;
        }
        int cmp = key.compareTo(node.key);
        if (cmp < 0) {
            return get(node.left, key);
        } else if (cmp > 0) {
            return get(node.right, key);
        } else {
            return node;
        }
    }

    public static void main(String[] args) {
        // Problem 11: Implement custom TreeMap (simplified BST).
        CustomTreeMap<String, Integer> map = new CustomTreeMap<>();
        map.put("C", 3);
        map.put("A", 1);
        map.put("B", 2);
        map.put("A", 11); // Update

        System.out.println("Value for 'A': " + map.get("A"));
        System.out.println("Value for 'B': " + map.get("B"));
        System.out.println("Value for 'D': " + map.get("D"));
    }
}
