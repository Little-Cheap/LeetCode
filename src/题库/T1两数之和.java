package 题库;

import java.util.HashMap;
import java.util.Map;

/**
 * 题目：
 * 给定一个整数数组 nums 和一个整数目标值 target，请你在该数组中找出 和为目标值 target  的那 两个 整数，并返回它们的数组下标。
 * 你可以假设每种输入只会对应一个答案，并且你不能使用两次相同的元素。
 * 你可以按任意顺序返回答案
 *
 * 示例 2：
 * 输入：nums = [3,2,4], target = 6
 * 输出：[1,2]
 *
 * 示例 3：
 * 输入：nums = [3,3], target = 6
 * 输出：[0,1]
 */
public class T1两数之和 {
    public static void main(String[] args) {
        int[] nums = {2,7,11,15};
//        int[] ints = new T1两数之和().twoSum1(nums, 9);
        int[] ints2 = new T1两数之和().twoSum2(nums, 9);
        System.out.println(ints2[0] + " " + ints2[1]);
    }

    /**
     * 暴力枚举
     * @param nums
     * @param target
     * @return
     */
    public int[] twoSum1(int[] nums, int target) {
        int[] res = new int[2];
        for (int i = 0; i < nums.length; i++) {
            for (int j = i+1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    res = new int[]{i,j};
                }
            }
        }

        return res;
    }

    /**
     * 哈希索引
     * @param nums
     * @param target
     * @return
     */
    public int[] twoSum2(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            int diff = target - num;
            if (map.containsKey(diff)) {
                return new int[]{map.get(diff), i};
            }
            map.put(num, i);
        }

        return new int[]{0, 0};
    }
}
