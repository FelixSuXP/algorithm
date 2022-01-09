//给定两个整数，分别表示分数的分子 numerator 和分母 denominator，以 字符串形式返回小数 。
//
// 如果小数部分为循环小数，则将循环的部分括在括号内。
//
// 如果存在多个答案，只需返回 任意一个 。
//
// 对于所有给定的输入，保证 答案字符串的长度小于 10⁴ 。
//
//
//
// 示例 1：
//
//
//输入：numerator = 1, denominator = 2
//输出："0.5"
//
//
// 示例 2：
//
//
//输入：numerator = 2, denominator = 1
//输出："2"
//
//
// 示例 3：
//
//
//输入：numerator = 2, denominator = 3
//输出："0.(6)"
//
//
// 示例 4：
//
//
//输入：numerator = 4, denominator = 333
//输出："0.(012)"
//
//
// 示例 5：
//
//
//输入：numerator = 1, denominator = 5
//输出："0.2"
//
//
//
//
// 提示：
//
//
// -2³¹ <= numerator, denominator <= 2³¹ - 1
// denominator != 0
//
// Related Topics 哈希表 数学 字符串 👍 290 👎 0


package com.felix.leetcode.editor.cn;

import java.util.HashMap;
import java.util.Map;

public class FractionToRecurringDecimal {
    public static void main(String[] args) {
        Solution solution = new FractionToRecurringDecimal().new Solution();
        int numerator = -2147483648, denominator = 1;
        String s = solution.fractionToDecimal(numerator, denominator);
        System.out.println(s);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String fractionToDecimal(int numerator, int denominator) {
            long numeratorLong = numerator;
            long denominatorLong = denominator;
            StringBuffer stringBuffer = new StringBuffer();
            long i = numeratorLong / denominatorLong;
            long mod = numeratorLong % denominatorLong;
            if (mod == 0) {
                return String.valueOf(i);
            }
            if (numeratorLong < 0 ^ denominatorLong < 0) {
                stringBuffer.append("-");
                denominatorLong = Math.abs(denominatorLong);
                numeratorLong = Math.abs(numeratorLong);
            }
            i = numeratorLong / denominatorLong;
            mod = numeratorLong % denominatorLong;
            stringBuffer.append(i);
            stringBuffer.append(".");
            Map<Long, Integer> map = new HashMap<>();
            while (mod != 0 && !map.containsKey(mod)) {
                map.put(mod, stringBuffer.length());
                i = mod * 10 / denominatorLong;
                mod = mod * 10 % denominatorLong;
                stringBuffer.append(i);
            }
            if (mod != 0) {
                stringBuffer.insert(map.get(mod), "(");
                stringBuffer.append(")");
            }

            return stringBuffer.toString();
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}