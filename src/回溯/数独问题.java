package 回溯;

/**
 * 约束条件：
 * 数字 1-9 在每一行只能出现一次。
 * 数字 1-9 在每一列只能出现一次。
 * 数字 1-9 在每一个以粗实线分隔的 3x3 宫内只能出现一次。
 */
public class 数独问题 {
    private static final int GRID_SIZE = 9;

    public static void main(String[] args) {
        int[][] board = {
                {5, 3, 0, 0, 7, 0, 0, 0, 0},
                {6, 0, 0, 1, 9, 5, 0, 0, 0},
                {0, 9, 8, 0, 0, 0, 0, 6, 0},
                {8, 0, 0, 0, 6, 0, 0, 0, 3},
                {4, 0, 0, 8, 0, 3, 0, 0, 1},
                {7, 0, 0, 0, 2, 0, 0, 0, 6},
                {0, 6, 0, 0, 0, 0, 2, 8, 0},
                {0, 0, 0, 4, 1, 9, 0, 0, 5},
                {0, 0, 0, 0, 8, 0, 0, 7, 9}
        };

        System.out.println("原始数独谜题:");
        printGrid(board);

        if (solveSudoku(board)) {
            System.out.println("\n成功解决数独谜题:");
            printGrid(board);
        } else {
            System.out.println("\n无法解决该数独谜题。");
        }
    }

    private static boolean solveSudoku(int[][] board) {
        // 遍历整个数独板的每一行
        for (int row = 0; row < GRID_SIZE; row++) {
            // 遍历当前行的每一列
            for (int col = 0; col < GRID_SIZE; col++) {
                // 检查当前位置是否为空（值为0）
                if (board[row][col] == 0) { // 找到一个空格子
                    // 尝试填入1到9的数字
                    for (int number = 1; number <= GRID_SIZE; number++) {
                        // 检查当前数字是否可以安全放置在当前位置
                        if (isSafe(board, row, col, number)) {
                            // 如果安全，则将数字填入当前位置
                            board[row][col] = number;

                            // 递归尝试解决剩余的数独
                            if (solveSudoku(board)) {
                                return true; // 解决方案找到
                            } else {
                                board[row][col] = 0; // 回溯
                            }
                        }
                    }
                    // 如果1-9的数字都试过了但都不行，说明当前路径不通
                    return false; // 没有有效的数字可以放在这个单元格中
                }
            }
        }
        // 如果遍历完整个数独板都没有找到空格，说明解决完成
        return true; // 所有单元格都已填充
    }

    private static boolean isSafe(int[][] board, int row, int col, int num) {
        // 检查行
        for (int c = 0; c < GRID_SIZE; c++) {
            if (board[row][c] == num) {
                return false;
            }
        }

        // 检查列
        for (int r = 0; r < GRID_SIZE; r++) {
            if (board[r][col] == num) {
                return false;
            }
        }

        // 检查 3x3 子网格
        int startRow = row - row % 3;
        int startCol = col - col % 3;
        for (int r = 0; r < 3; r++) {
            for (int c = 0; c < 3; c++) {
                if (board[r + startRow][c + startCol] == num) {
                    return false;
                }
            }
        }
        return true;
    }

    private static void printGrid(int[][] board) {
        for (int r = 0; r < GRID_SIZE; r++) {
            if (r % 3 == 0 && r != 0) {
                System.out.println("-----------+-----------+-----------");
            }
            for (int d = 0; d < GRID_SIZE; d++) {
                if (d % 3 == 0 && d != 0) {
                    System.out.print("| ");
                }
                System.out.print(board[r][d] == 0 ? ". " : board[r][d] + " ");
            }
            System.out.println();
        }
    }
}
