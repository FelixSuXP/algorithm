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
// Related Topics 递归 链表 数学 👍 7358 👎 0


package com.felix.leetcode.editor.cn;

import java.util.Arrays;
import java.util.List;

public class Code2_AddTwoNumbers {
    public static void main(String[] args) {
        Solution solution = new Code2_AddTwoNumbers().new Solution();
        List a = Arrays.asList(5);
        List b = Arrays.asList(5);
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
        ListNode listNode = solution.addTwoNumbers(l1, l2);

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
        public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
            Integer length1 = getLength(l1);
            Integer length2 = getLength(l2);
            ListNode l = length1 > length2 ? l1 : l2;
            ListNode s = l == l1 ? l2 : l1;
            ListNode curl = l;
            ListNode curs = s;
            ListNode tar = null;
            int temp = 0, sum;
            while (curl != null && curs != null) {
                sum = curl.val + curs.val + temp;
                curl.val = sum % 10;
                temp = sum / 10;
                tar = curl;
                curl = curl.next;
                curs = curs.next;
            }
            while (curl != null) {
                sum = curl.val + temp;
                curl.val = sum % 10;
                temp = sum / 10;
                tar = curl;
                curl = curl.next;
            }
            if (temp > 0) {
                tar.next = new ListNode(temp);
            }
            return l;
        }

        private Integer getLength(ListNode listNode) {
            Integer length = 0;
            while (listNode != null) {
                listNode = listNode.next;
                length++;
            }
            return length;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
