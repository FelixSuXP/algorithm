//给你一个链表数组，每个链表都已经按升序排列。
//
// 请你将所有链表合并到一个升序链表中，返回合并后的链表。
//
//
//
// 示例 1：
//
// 输入：lists = [[1,4,5],[1,3,4],[2,6]]
//输出：[1,1,2,3,4,4,5,6]
//解释：链表数组如下：
//[
//  1->4->5,
//  1->3->4,
//  2->6
//]
//将它们合并到一个有序链表中得到。
//1->1->2->3->4->4->5->6
//
//
// 示例 2：
//
// 输入：lists = []
//输出：[]
//
//
// 示例 3：
//
// 输入：lists = [[]]
//输出：[]
//
//
//
//
// 提示：
//
//
// k == lists.length
// 0 <= k <= 10^4
// 0 <= lists[i].length <= 500
// -10^4 <= lists[i][j] <= 10^4
// lists[i] 按 升序 排列
// lists[i].length 的总和不超过 10^4
//
// Related Topics 链表 分治 堆（优先队列） 归并排序 👍 1693 👎 0


package com.felix.leetcode.editor.cn;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class Code23_MergeKSortedLists {
    public static void main(String[] args) {
        Solution solution = new Code23_MergeKSortedLists().new Solution();
        List a = Arrays.asList(1, 3, 5, 7, 9);
        List b = Arrays.asList(2, 4, 6, 8);
        ListNode l1 = null, l2 = null, next = null;
        for (int i = 0; i < a.size(); i++) {
            if (l1 == null) {
                l1 = new ListNode((Integer) a.get(i));
                next = l1;
            } else {
                next.next = new ListNode((Integer) a.get(i));
                next = next.next;
            }

        }
        for (int i = 0; i < b.size(); i++) {
            if (l2 == null) {
                l2 = new ListNode((Integer) b.get(i));
                next = l2;
            } else {
                next.next = new ListNode((Integer) b.get(i));
                next = next.next;
            }

        }
        print(l1);
        print(l2);
        ListNode[] listNodes = new ListNode[5];
        listNodes[0] = (l1);
        listNodes[1] = (l2);
        ListNode listNode = solution.mergeKLists(listNodes);

        print(listNode);
    }


    private static void print(ListNode listNode) {
        while (listNode != null) {
            System.out.print(listNode.val + " ");
            listNode = listNode.next;
        }
        System.out.println();
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
    //leetcode submit region begin(Prohibit modification and deletion)

    /**
     * Definition for singly-linked list.
     * public class ListNode {
     * int val;
     * ListNode next;
     * ListNode() {}
     * ListNode(int val) { this.val = val; }
     * ListNode(int val, ListNode next) { this.val = val; this.next = next; }
     * }
     */
    class Solution {
        public ListNode mergeKLists(ListNode[] lists) {
            if (lists == null)
                return null;
            PriorityQueue<ListNode> priorityQueue = new PriorityQueue<>(new MyComposite());
            for (ListNode list : lists) {
                if (list != null)
                    priorityQueue.add(list);
            }
            if (priorityQueue.isEmpty())
                return null;
            ListNode poll = priorityQueue.poll();
            ListNode pre = poll;
            if (pre.next != null)
                priorityQueue.add(pre.next);
            while (!priorityQueue.isEmpty()) {
                ListNode cur = priorityQueue.poll();
                pre.next = cur;
                pre = pre.next;
                if (cur.next != null)
                    priorityQueue.add(cur.next);
            }
            return poll;
        }

        private class MyComposite implements Comparator<ListNode> {

            @Override
            public int compare(ListNode o1, ListNode o2) {
                return o1.val - o2.val;
            }
        }

    }
//leetcode submit region end(Prohibit modification and deletion)

}
