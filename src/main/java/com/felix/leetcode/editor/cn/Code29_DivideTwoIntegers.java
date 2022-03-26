//给定两个整数，被除数 dividend 和除数 divisor。将两数相除，要求不使用乘法、除法和 mod 运算符。
//
// 返回被除数 dividend 除以除数 divisor 得到的商。
//
// 整数除法的结果应当截去（truncate）其小数部分，例如：truncate(8.345) = 8 以及 truncate(-2.7335) = -2
//
//
//
// 示例 1:
//
// 输入: dividend = 10, divisor = 3
//输出: 3
//解释: 10/3 = truncate(3.33333..) = truncate(3) = 3
//
// 示例 2:
//
// 输入: dividend = 7, divisor = -3
//输出: -2
//解释: 7/-3 = truncate(-2.33333..) = -2
//
//
//
// 提示：
//
//
// 被除数和除数均为 32 位有符号整数。
// 除数不为 0。
// 假设我们的环境只能存储 32 位有符号整数，其数值范围是 [−2³¹, 231 − 1]。本题中，如果除法结果溢出，则返回 231 − 1。
//
// Related Topics 位运算 数学 👍 817 👎 0


package com.felix.leetcode.editor.cn;

public class Code29_DivideTwoIntegers {
    public static void main(String[] args) {
        Solution solution = new Code29_DivideTwoIntegers().new Solution();
        int a = 6, b = 2;
        solution.add(a, b);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        // 加法
        public int add(int a, int b) {
            int sum = a;
            while (b != 0) {
                sum = a ^ b;
                b = (a & b) << 1;
                a = sum;
            }
            return sum;
        }

        // 取反
        public int negNum(int n) {
            return add(~n, 1);
        }

        // 减法
        public int minus(int a, int b) {
            return add(a, negNum(b));
        }

        // 乘法
        public int multi(int a, int b) {
            int res = 0;
            while (b != 0) {
                if ((b & 1) != 0) {
                    res = add(res, a);
                }
                a <<= 1;
                b >>>= 1;
            }
            return res;
        }

        // 是否为负数
        public boolean isNeg(int n) {
            return n < 0;
        }

        public int div(int a, int b) {
            int x = isNeg(a) ? negNum(a) : a;
            int y = isNeg(b) ? negNum(b) : b;
            int res = 0;
            for (int i = 30; i >= 0; i = minus(i, 1)) {
                if ((x >> i) >= y) {
                    res = res | (1 << i);
                    x = minus(x, y << i);
                }
            }
            return isNeg(a) ^ isNeg(b) ? negNum(res) : res;
        }


        public int divide(int a, int b) {
            if (a == Integer.MIN_VALUE && b == Integer.MIN_VALUE) {
                return 1;
            } else if (b == Integer.MIN_VALUE) {
                return 0;
            } else if (a == Integer.MIN_VALUE) {
                if (b == negNum(1)) {
                    return Integer.MAX_VALUE;
                } else {
                    int c = div(add(a, 1), b);
                    return add(c, div(minus(a, multi(c, b)), b));
                }
            } else {
                return div(a, b);
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
