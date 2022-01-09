//给定一个由整数数组 A 表示的环形数组 C，求 C 的非空子数组的最大可能和。 
//
// 在此处，环形数组意味着数组的末端将会与开头相连呈环状。（形式上，当0 <= i < A.length 时 C[i] = A[i]，且当 i >= 0 时 
//C[i+A.length] = C[i]） 
//
// 此外，子数组最多只能包含固定缓冲区 A 中的每个元素一次。（形式上，对于子数组 C[i], C[i+1], ..., C[j]，不存在 i <= k1, 
//k2 <= j 其中 k1 % A.length = k2 % A.length） 
//
// 
//
// 示例 1： 
//
// 输入：[1,-2,3,-2]
//输出：3
//解释：从子数组 [3] 得到最大和 3
// 
//
// 示例 2： 
//
// 输入：[5,-3,5]
//输出：10
//解释：从子数组 [5,5] 得到最大和 5 + 5 = 10
// 
//
// 示例 3： 
//
// 输入：[3,-1,2,-1]
//输出：4
//解释：从子数组 [2,-1,3] 得到最大和 2 + (-1) + 3 = 4
// 
//
// 示例 4： 
//
// 输入：[3,-2,2,-3]
//输出：3
//解释：从子数组 [3] 和 [3,-2,2] 都可以得到最大和 3
// 
//
// 示例 5： 
//
// 输入：[-2,-3,-1]
//输出：-1
//解释：从子数组 [-1] 得到最大和 -1
// 
//
// 
//
// 提示： 
//
// 
// -30000 <= A[i] <= 30000 
// 1 <= A.length <= 30000 
// 
// Related Topics 队列 数组 分治 动态规划 单调队列 👍 216 👎 0


package com.felix.leetcode.editor.cn;

public class MaximumSumCircularSubarray {
    public static void main(String[] args) {
        Solution solution = new MaximumSumCircularSubarray().new Solution();
        int[] nums = new int[]{3,-2,2,-3};
        int i = solution.maxSubarraySumCircular(nums);
        System.out.println(i);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int maxSubarraySumCircular(int[] nums) {
            int pre =0, maxAns=nums[0];
            for (int x : nums) {
                pre=Math.max(x,pre+x);
                maxAns = Math.max(pre, maxAns);
            }
            return maxAns;
//            int length = nums.length;
//            int sum, sumA = 0, sumB = 0;
//            for (int i = 0; i < length; i++) {
//                sum = 0;
//                for (int j = 0; j < length; j++) {
//                    int tag = i + j;
//                    if (tag >= length) {
//                        tag -= length;
//                    }
//                    sum += nums[tag];
//                    if (j == 0) {
//                        sumA = sum;
//                    } else {
//                        sumA = Math.max(sum, sumA);
//                    }
//                }
//                if (i == 0) {
//                    sumB = sumA;
//                } else {
//                    sumB = Math.max(sumB, sumA);
//                }
//            }
//            return sumB;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}