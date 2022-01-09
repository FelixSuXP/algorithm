//给定一个 m x n 二维字符网格 board 和一个字符串单词 word 。如果 word 存在于网格中，返回 true ；否则，返回 false 。 
//
// 单词必须按照字母顺序，通过相邻的单元格内的字母构成，其中“相邻”单元格是那些水平相邻或垂直相邻的单元格。同一个单元格内的字母不允许被重复使用。 
//
// 
//
// 示例 1： 
//
// 
//输入：board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word =
//"ABCCED"
//输出：true
//
//
// 示例 2：
//
//
//输入：board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word =
//"SEE"
//输出：true
//
//
// 示例 3：
//
//
//输入：board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word =
//"ABCB"
//输出：false
//
//
//
//
// 提示：
//
//
// m == board.length
// n = board[i].length
// 1 <= m, n <= 6
// 1 <= word.length <= 15
// board 和 word 仅由大小写英文字母组成
//
//
//
//
// 进阶：你可以使用搜索剪枝的技术来优化解决方案，使其在 board 更大的情况下可以更快解决问题？
// Related Topics 数组 回溯 矩阵 👍 1043 👎 0


package com.felix.leetcode.editor.cn;

public class WordSearch {
    public static void main(String[] args) {
        Solution solution = new WordSearch().new Solution();
        char[][] board = new char[][]{{'A', 'B', 'C', 'E'}, {'S', 'F', 'C', 'S'}, {'A', 'D', 'E', 'E'}};
        String word = "ABCCEESC";
        boolean exist = solution.exist(board, word);
        System.out.println(exist);

    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        int[][] directions = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

        public boolean exist(char[][] board, String word) {
            int length = word.length(),
                    m = board.length,
                    n = board[0].length;

            char c = word.charAt(0);
            boolean flag[][] = new boolean[m][n];
            for (int j = 0; j < m; j++) {
                for (int k = 0; k < n; k++) {
                    if (board[j][k] != c) {
                        continue;
                    }
                    boolean exist = exist(board, flag, word, j, k, 0);
                    if (exist) {
                        return true;
                    }
                }
            }
            return false;
        }

        private boolean exist(char[][] board, boolean[][] flag, String word, int j, int k, int m) {
            if (word.charAt(m) != board[j][k]) {
                return false;
            } else if (word.length() - 1 == m) {
                return true;
            }
            boolean state = false;
            flag[j][k] = true;
            for (int[] dir : directions) {
                int newj = j + dir[0], newk = k + dir[1];
                if (newj >= 0 && newj < board.length &&
                        newk >= 0 && newk < board[0].length &&
                        word.charAt(m + 1) == board[newj][newk]) {
                    if (!flag[newj][newk]) {
                        boolean exist = exist(board, flag, word, newj, newk, m + 1);
                        if (exist) {
                            state = true;
                            break;
                        }
                    }
                }
            }
            flag[j][k] = false;
            return state;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}