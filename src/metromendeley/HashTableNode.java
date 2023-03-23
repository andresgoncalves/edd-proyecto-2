package metromendeley;

/**
 * Nodo de HashTable con claves de tipo String
 * @author Andres
 */
public class HashTableNode<T> {
    private final int hash;
    private final String key;
    private T value;
    private HashTableNode<T> next;

    public HashTableNode(int hash, String key, T value) {
        this.hash = hash;
        this.key = key;
        this.value = value;
    }

    public int getHash() {
        return hash;
    }

    public String getKey() {
        return key;
    }

    public T getValue() {
        return value;
    }

    public void setValue(T value) {
        this.value = value;
    }

    public HashTableNode<T> getNext() {
        return next;
    }

    public void setNext(HashTableNode<T> next) {
        this.next = next;
    }
}
