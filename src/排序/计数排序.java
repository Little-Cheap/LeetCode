package 排序;

import java.util.Arrays;

public class 计数排序 {
    public static void main(String[] args) {
        //
        int[] nums = {1, 0, 1, 2, 0, 4, 0, 2, 2, 4};
        countingSortNaive(nums);
        System.out.println(Arrays.toString(nums));

    }

    /**
     * 计数排序
     */
    public static void countingSortNaive(int[] nums) {
        // 1. 统计数组最大元素 m
        int m = 0;
        for (int num : nums) {
            m = Math.max(m, num);
        }
        // 2. 统计各数字的出现次数
        // counter[num] 代表 num 的出现次数
        int[] counter = new int[m + 1];
        for (int num : nums) {
            counter[num]++;
        }
        // 3. 遍历 counter ，将各元素填入原数组 nums
        int i = 0;
        for (int num = 0; num < m + 1; num++) {
            for (int j = 0; j < counter[num]; j++, i++) {
                nums[i] = num;
            }
        }
    }
}
