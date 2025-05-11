package 分治;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 汉诺塔问题
 * <p>
 * 要求：
 * 1. 3个柱子，A，B，C
 * 2. 圆盘只能从一根柱子顶部拿出，从另一根柱子顶部放入
 * 3. 每次只能移动一个圆盘
 * 4. 小圆盘必须时刻位于大圆盘之上
 * <p>
 * 实现：
 * 盘中数为1个，直接将盘中从A移动到C
 * 盘中数为2个或两个以上盘中数n
 * 1.先将n-1个盘子抽象成一个整体从A移动到B
 * 2.再把最下面的盘子从A移动到C
 * 3.最后再把中间的盘子从B移动到C
 */
public class 汉诺塔问题 {

    public static void main(String[] args) {
        ArrayList<Integer> A = new ArrayList<>(Arrays.asList(2, 4, 6, 8, 10));
        ArrayList<Integer> B = new ArrayList<>();
        ArrayList<Integer> C = new ArrayList<>();
        solveHanNota(A, B, C);
        System.out.println(C);
    }

    /**
     * 移动盘子
     * @param src
     * @param tar
     */
    public static void move(List<Integer> src, List<Integer> tar) {
        tar.add(src.removeLast());
    }

    /**
     * 递归
     * @param n 盘子数
     * @param src 源柱
     * @param buf 缓冲柱
     * @param tar 目标柱
     */
    public static void dfs(int n, List<Integer> src, List<Integer> buf, List<Integer> tar) {
        // 盘子数为1
        if (n == 1) {
            move(src, tar);
            return;
        }
        // 盘子数大于1
        // 1.先将n-1个盘子抽象成一个整体从A移动到B
        dfs(n - 1, src, tar, buf);
        // 2.再把最下面的盘子从A移动到C
        move(src, tar);
        // 3.最后再把中间的盘子从B移动到C
        dfs(n - 1, buf, src, tar);
    }

    public static void solveHanNota(List<Integer> A, List<Integer> B, List<Integer> C) {
        int n = A.size();
        dfs(n, A, B, C);
    }
}
