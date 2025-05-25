package 回溯;

import java.util.ArrayList;
import java.util.List;

/**
 * n皇后问题
 * 1.首先具有如下的限制
 * 2.每一行，或则每一列都只能放置一个皇后 ：设置一个列数组，用于设置当前列是否放置了皇后 数组大小为n
 * 3.每一个正对角线同样也只能放置一个皇后：设置一个正对角线数组，用于设置当前正对角线是否放置了皇后 同时满足，每一个正对角线上的row-col的值相同，取值范围为[-n+1,n-1], 数组大小为(2n-1),由于数组不能的所索引不能为负数，则取值范围为[0,row-col+n-1]
 * 4.每一个反对角线同样也只能放置一个皇后：设置一个反对角线数组，用于设置当前反对角线是否放置了皇后 同时满足，每一个反对角线上的row+col的值相同，取值范围为[0,row+col]
 */
public class n皇后问题 {


    public static void main(String[] args) {
        List<List<List<String>>> lists = nQueens(8);
        for (List<List<String>> list : lists) {
            for (List<String> strings : list) {
                System.out.println(strings.toString());
            }
            System.out.println("11111111111111");
        }
    }

    private static void backtrack(int row, int n, boolean[] cols, boolean[] posDiagonals, boolean[] negDiagonals, List<List<String>> queens, List<List<List<String>>> res) {
        // 递归终止条件
        if (row == n) {
            List<List<String>> copy = new ArrayList<>();
            for (List<String> queen : queens) {
                copy.add(new ArrayList<>(queen));
            }
            // 添加每一种结果集
            res.add(new ArrayList<>(copy));
            return;
        }
        // 遍历每一列
        for (int col = 0; col < n; col++) {
            // 判单当前列是否放置皇后的条件
            if (!cols[col] && !posDiagonals[row - col + n - 1] && !negDiagonals[row + col]) {
                // 放置皇后
                queens.get(row).set(col, "Q");
                // 设置数组状态为true，表示当前列，正对角线，反对角线已经放置了皇后
                cols[col] = posDiagonals[row - col + n - 1] = negDiagonals[row + col] = true;
                // 递归下一行
                backtrack(row + 1, n, cols, posDiagonals, negDiagonals, queens, res);
                // 没有在最后一行成功放置皇后，说明当前格子不满足条件，重新回溯
                queens.get(row).set(col, "#");
                cols[col] = posDiagonals[row - col + n - 1] = negDiagonals[row + col] = false;
            }
        }
    }
    public static List<List<List<String>>> nQueens(int n) {
        // 初始化空棋盘
        List<List<String>> queens = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            List<String> cols = new ArrayList<>();
            for (int j = 0; j < n; j++) {
                // 默认每一个格子为空格
                cols.add("#");
            }
            queens.add(cols);
        }
        // 设置列数组
        boolean[] cols = new boolean[n];
        // 设置正对角线数组
        boolean[] posDiagonals = new boolean[2 * n - 1];
        // 设置反对角线数组
        boolean[] negDiagonals = new boolean[2 * n - 1];
        // 结果集
        List<List<List<String>>> res = new ArrayList<>();
        // 回溯算法 递归 行数，维度n,  列数组，正对角线数组，反对角线数组，棋盘数组，结果集
        backtrack(0, n, cols, posDiagonals, negDiagonals, queens,  res);

        return res;
    }
}
