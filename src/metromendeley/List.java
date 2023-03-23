package metromendeley;

/**
 * Lista enlazada
 * @author Andres
 */
public class List<T> {
    private ListNode<T> first, last;
    private int size;
    
    public void append(T value) {
        ListNode<T> node = new ListNode<>(value);
        if(last == null) {
            first = last = node;
        }
        else {
            last.setNext(node);
            last = node;
        }
        size += 1;
    }

    public ListNode<T> getFirst() {
        return first;
    }

    public ListNode<T> getLast() {
        return last;
    }

    public int getSize() {
        return size;
    }
    
    public boolean isEmpty() {
        return size == 0;
    }
}
