package metromendeley;

/**
 * HashTable con claves de tipo String
 * @author Andres
 */
public class HashTable<T> {
    private final HashTableNode<T>[] table;
    private final int size;

    public HashTable(int size) {
        this.table = new HashTableNode[size];
        this.size = size;
    }
    
    public T get(String key) {
        int hash = hash(key);
        int index = Math.abs(hash % size);
        for(HashTableNode<T> it = table[index]; it != null; it = it.getNext()) {
            if(it.getHash() == hash && it.getKey().equals(key)) {
                return it.getValue();
            }
        }
        return null;
    }
    
    public void set(String key, T value) {
        int hash = hash(key);
        int index = Math.abs(hash % size);
        HashTableNode<T> node = new HashTableNode<>(hash, key, value);
        for(HashTableNode<T> it = table[index]; it != null; it = it.getNext()) {
            if(it.getHash() == hash && it.getKey().equals(key)) {
                throw new DuplicateKeyException();
            }
        }
        node.setNext(table[index]);
        table[index] = node;
    }

    public int getSize() {
        return size;
    }
    
    private int hash(String key) {
        int factor = 1;
        int hash = 0;
        for(int i = 0; i < key.length(); i++) {
            hash += key.charAt(i) * factor;
            factor = factor * 31;
        }
        return hash;
    }
}
