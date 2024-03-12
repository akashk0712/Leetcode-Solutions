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
    public ListNode removeZeroSumSublists(ListNode head) {
        Map<Integer, ListNode> prefixSumMap = new HashMap<>();
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        prefixSumMap.put(0, dummy);
        ListNode ptr = head;
        int prefixSum = 0;
        
        while(ptr != null) {
            prefixSum += ptr.val;
            if(prefixSumMap.containsKey(prefixSum)) {
                ListNode prev = prefixSumMap.get(prefixSum);
                ListNode temp = prev.next;
                int sum = prefixSum;
                while(temp != ptr) {
                    sum += temp.val;
                    prefixSumMap.remove(sum);
                    temp = temp.next;
                }
                prev.next = ptr.next;
            } else {
                prefixSumMap.put(prefixSum, ptr);
            }
            ptr = ptr.next;
        }
        return dummy.next;
    }
}
