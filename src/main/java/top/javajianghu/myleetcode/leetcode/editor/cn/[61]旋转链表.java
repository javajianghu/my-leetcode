//给你一个链表的头节点 head ，旋转链表，将链表每个节点向右移动 k 个位置。 
//
// 
//
// 示例 1： 
// 
// 
//输入：head = [1,2,3,4,5], k = 2
//输出：[4,5,1,2,3]
// 
//
// 示例 2： 
// 
// 
//输入：head = [0,1,2], k = 4
//输出：[2,0,1]
// 
//
// 
//
// 提示： 
//
// 
// 链表中节点的数目在范围 [0, 500] 内 
// -100 <= Node.val <= 100 
// 0 <= k <= 2 * 10⁹ 
// 
//
// Related Topics 链表 双指针 👍 1012 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode rotateRight(ListNode head, int k) {
        if(null == head || null == head.next){
            return head;
        }

        // 获取链表的长度
        int count = 1;
        ListNode next = head;
        while(next.next != null){
            count++;
            next = next.next;
        }
        if(k % count == 0){
            return head;
        }

        ListNode newHead = head;
        for (int i = 0; i < k % count; i++) {
            ListNode nt = newHead;
            // 链表节点数量
            while(nt.next != null){
                nt = nt.next;
            }
            // 把最后一个节点的next改为之前的head
            nt.next = newHead;
            // 然后把last作为新的head
            newHead = new ListNode(nt.val, nt.next);
            // 这个遍历的操作是为了把最后一个节点的next改为null，当count == x的时候就表示是最后一个节点
            ListNode n = newHead;
            int x = 1;
            while(n.next != null){
                x++;
                n = n.next;
                if(x == count){
                    n.next = null;
                }
            }
        }
        return newHead;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
