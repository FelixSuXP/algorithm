//给你一个链表，每 k 个节点一组进行翻转，请你返回翻转后的链表。
//
// k 是一个正整数，它的值小于或等于链表的长度。
//
// 如果节点总数不是 k 的整数倍，那么请将最后剩余的节点保持原有顺序。
//
// 进阶：
//
//
// 你可以设计一个只使用常数额外空间的算法来解决此问题吗？
// 你不能只是单纯的改变节点内部的值，而是需要实际进行节点交换。
//
//
//
//
// 示例 1：
//
//
//输入：head = [1,2,3,4,5], k = 2
//输出：[2,1,4,3,5]
//
//
// 示例 2：
//
//
//输入：head = [1,2,3,4,5], k = 3
//输出：[3,2,1,4,5]
//
//
// 示例 3：
//
//
//输入：head = [1,2,3,4,5], k = 1
//输出：[1,2,3,4,5]
//
//
// 示例 4：
//
//
//输入：head = [1], k = 1
//输出：[1]
//
//
//
//
//
// 提示：
//
//
// 列表中节点的数量在范围 sz 内
// 1 <= sz <= 5000
// 0 <= Node.val <= 1000
// 1 <= k <= sz
//
// Related Topics 递归 链表 👍 1432 👎 0


package com.felix.leetcode.editor.cn;

import java.util.Arrays;
import java.util.List;

public class Code25_ReverseNodesInKGroup {
    public static void main(String[] args) {
        Solution solution = new Code25_ReverseNodesInKGroup().new Solution();
        List a = Arrays.asList(1, 2, 3, 4, 5);
        ListNode head = null, next = null;
        for (int i = 0; i < a.size(); i++) {
            if (head == null) {
                head = new ListNode((Integer) a.get(i));
                next = head;
            } else {
                next.next = new ListNode((Integer) a.get(i));
                next = next.next;
            }

        }
        print(head);
        ListNode listNode = solution.reverseKGroup(head, 3);
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
//    class Solution {
//        public ListNode reverseKGroup(ListNode head, int k) {
//            ListNode startNode = head;
//            ListNode endNode = getGroupEndNode(startNode, k);
//            if (endNode == null) {
//                return head;
//            }
//            head = endNode;
//            reverseNode(startNode, endNode);
//            // 上一组的结尾
//            ListNode lastEndNode = startNode;
//            while (lastEndNode.next != null) {
//                startNode = lastEndNode.next;
//                endNode = getGroupEndNode(startNode, k);
//                if (endNode == null) {
//                    return head;
//                }
//                reverseNode(startNode, endNode);
//                lastEndNode.next = endNode;
//                lastEndNode = startNode;
//            }
//            return head;
//        }
//
//        // 获取每组的最后一个node
//        private ListNode getGroupEndNode(ListNode startNode, int k) {
//            while (--k > 0 && startNode != null) {
//                startNode = startNode.next;
//            }
//            return startNode;
//        }
//
//        // 交换两个node之间的节点
//        private void reverseNode(ListNode startNode, ListNode endNode) {
//            endNode = endNode.next;
//            ListNode pre = null;
//            ListNode cur = startNode;
//            ListNode next;
//            while (cur != endNode) {
//                next = cur.next;
//                cur.next = pre;
//                pre = cur;
//                cur = next;
//            }
//            startNode.next = endNode;
//        }
//    }


    class Solution {
        public ListNode reverseKGroup(ListNode head, int kind) {
            ListNode startNode = head;
            ListNode endNode = getGroupEndNode(startNode, kind);
            if (endNode == null) {
                return head;
            }
            head = endNode;
            reverse(startNode, endNode);
            ListNode lastEndNode = startNode;
            while (lastEndNode != null) {
                startNode = lastEndNode.next;
                endNode = getGroupEndNode(startNode, kind);
                if (endNode == null) {
                    return head;
                }
                reverse(startNode, endNode);
                lastEndNode.next = endNode;
                lastEndNode = startNode;
            }
            return head;
        }

        private ListNode getGroupEndNode(ListNode startNode, int kind) {
            while (--kind > 0 && startNode != null)
                startNode = startNode.next;
            return startNode;
        }

        private void reverse(ListNode startNode, ListNode endNode) {
            endNode = endNode.next;
            ListNode head = startNode;
            ListNode pre = null, next;
            while (head != endNode) {
                next = head.next;
                head.next = pre;
                pre = head;
                head = next;
            }
            startNode.next = endNode;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
