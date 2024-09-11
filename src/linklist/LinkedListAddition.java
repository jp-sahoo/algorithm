package linklist;

public class LinkedListAddition {
    public static void main(String[] args) {
        ListNode first = new ListNode(9);
        first.next = new ListNode(9);
        first.next.next = new ListNode(9);
        first.next.next.next = new ListNode(9);
        first.next.next.next.next = new ListNode(9);
        first.next.next.next.next.next = new ListNode(9);
        first.next.next.next.next.next.next = new ListNode(9);
        ListNode second = new ListNode(9);
        second.next = new ListNode(9);
        second.next.next = new ListNode(9);
        second.next.next.next = new ListNode(9);
        ListNode result = new LinkedListAddition().addTwoNumbers(first, second);
        while(result != null) {
            System.out.print(result.val + " ");
            result = result.next;
        }


    }
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode head = null;
        ListNode cur = null;
        int carry = 0;
        while (l1 != null || l2 != null || carry == 1) {
            int finalValue = carry + (l1 != null ? l1.val : 0) + (l2 != null ? l2.val : 0);
            if (cur == null) {
                cur = new ListNode(finalValue % 10);
            } else {
                cur.next = new ListNode(finalValue % 10);
            }
            carry = finalValue / 10;
            if (head == null) {
                head = cur;
            } else {
                cur = cur.next;
            }
            l1 = l1 != null? l1.next: null;
            l2 = l2 != null? l2.next: null;
        }
        cur = null;
        return head;
    }

    public static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

}