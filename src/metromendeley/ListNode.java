package metromendeley;

/**
 * Nodo de lista enlazada
 * @author Andres
 */
public class ListNode<T> {
    private T value;
    private ListNode<T> next;

    public ListNode(T value) {
        this.value = value;
    }

    public T getValue() {
        return value;
    }

    public void setValue(T value) {
        this.value = value;
    }

    public ListNode<T> getNext() {
        return next;
    }

    public void setNext(ListNode<T> next) {
        this.next = next;
    }
}
