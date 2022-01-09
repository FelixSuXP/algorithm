//给你两个 非空 的链表，表示两个非负的整数。它们每位数字都是按照 逆序 的方式存储的，并且每个节点只能存储 一位 数字。 
//
// 请你将两个数相加，并以相同形式返回一个表示和的链表。 
//
// 你可以假设除了数字 0 之外，这两个数都不会以 0 开头。 
//
// 
//
// 示例 1： 
//
// 
//输入：l1 = [2,4,3], l2 = [5,6,4]
//输出：[7,0,8]
//解释：342 + 465 = 807.
// 
//
// 示例 2： 
//
// 
//输入：l1 = [0], l2 = [0]
//输出：[0]
// 
//
// 示例 3： 
//
// 
//输入：l1 = [9,9,9,9,9,9,9], l2 = [9,9,9,9]
//输出：[8,9,9,9,0,0,0,1]
// 
//
// 
//
// 提示： 
//
// 
// 每个链表中的节点数在范围 [1, 100] 内 
// 0 <= Node.val <= 9 
// 题目数据保证列表表示的数字不含前导零 
// 
// Related Topics 递归 链表 数学 👍 6821 👎 0


package com.felix.leetcode.editor.cn;

public class AddTwoNumbers {
    public static void main(String[] args) {
        //[1,9,9,9,9,9,9,9,9,9]
        Solution solution = new AddTwoNumbers().new Solution();
        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(5);
        ListNode l3 = l1;
        ListNode l4 = l2;

        int[] a = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1};
        int[] a1 = new int[]{6, 4};
        for (int b : a) {
            l1.next = new ListNode(b);
            l1 = l1.next;
        }
        for (int b : a1) {
            l2.next = new ListNode(b);
            l2 = l2.next;
        }
        ListNode listNode = solution.addTwoNumbers(l3, l4);
        StringBuilder str = new StringBuilder();
        while (listNode != null) {
            str.append(listNode.val);
            listNode = listNode.next;
        }
        System.out.println(str);
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
        public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
            ListNode tail = null;
            ListNode head = null;
            int m = 0;
            while (l1 != null || l2 != null) {
                int a = l1 == null ? 0 : l1.val;
                int b = l2 == null ? 0 : l2.val;
                int c = a + b + m;
                if (head == null) {
                    tail = new ListNode(c % 10);
                    head = tail;
                } else {
                    tail.next = new ListNode(c % 10);
                    tail = tail.next;
                }
                m = c / 10;
                if (l1 != null) {
                    l1 = l1.next;
                }
                if (l2 != null) {
                    l2 = l2.next;
                }
            }
            if (m > 0) {
                tail.next = new ListNode(m);
            }
            return head;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}