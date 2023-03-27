package metromendeley;

/**
 *
 * @author Andres
 */
public class SortedSummaryList extends List<Summary> {
    public void insert(Summary summary) {
        ListNode<Summary> node = new ListNode<>(summary);
        for(ListNode<Summary> current = first, prev = null; current != null; prev = current, current = current.getNext()) {
            if(current.getValue().getTitle().compareTo(summary.getTitle()) > 0) {
                if(prev == null) {
                    node.setNext(first);
                    first = node;
                }
                else {
                    prev.setNext(node);
                    node.setNext(current);
                }
                size += 1;
                return;
            }
        }
        append(summary);
    }
}
