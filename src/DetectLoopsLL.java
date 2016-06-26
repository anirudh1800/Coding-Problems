/**
 * Created by agali on 6/26/16.
 */
public class DetectLoopsLL {
    public static void main(String args[]) {
        LinkedListNode head = new LinkedListNode(1);
        head.next = new LinkedListNode(2);
        head.next.next = new LinkedListNode(3);
        head.next.next.next = new LinkedListNode(4);

        //make loop
        head.next.next.next = head.next.next;

        //check if loop exists
        System.out.println(detectCycle(head));
    }

    //Floyd Cycle Detection Algorithm
    static boolean detectCycle(LinkedListNode head) {
        LinkedListNode slow = head, fast = head;

        while (slow != null && fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;

            // If slow and fast meet at same point then loop is present
            if (slow == fast) {
                return true;
            }
        }

        return false;
    }

}

class LinkedListNode {
    public int value;
    public LinkedListNode next;

    public LinkedListNode(int value) {
        this.value = value;
    }
}
