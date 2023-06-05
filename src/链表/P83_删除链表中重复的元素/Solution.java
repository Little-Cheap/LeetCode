package 链表.P83_删除链表中重复的元素;

class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        ListNode node1 = new ListNode();
        node1.val = 1;
        ListNode node2 = new ListNode();
        node2.val = 1;
        node1.next = node2;
        ListNode node3 = new ListNode();
        node3.val = 3;
        node2.next = node3;
        ListNode listNode = solution.deleteDuplicates(node1);
        System.out.println(listNode.val);
        while (listNode.next!=null){
            System.out.println(listNode.next.val);
            listNode = listNode.next;
        }
        System.out.println(listNode);
    }
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null){
            return head;
        }
        if (head.next == null){
            return head;
        }
        ListNode right = new ListNode();
        right = head;
        if (right.next.val == right.val){
            right.next = right.next.next;
            deleteDuplicates(right);
        }else {
            deleteDuplicates(right.next);
        }
        return head;
    }

    /**
     * 官网答案
     * @param head
     * @return
     */
    public ListNode deleteDuplicates1(ListNode head) {
        if (head == null) {
            return head;
        }

        ListNode cur = head;
        while (cur.next != null) {
            if (cur.val == cur.next.val) {
                cur.next = cur.next.next;
            } else {
                cur = cur.next;
            }
        }

        return head;
    }

}