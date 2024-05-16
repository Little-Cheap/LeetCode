package 哈希.最长连续序列;

import java.util.HashSet;
import java.util.Set;

class Solution {
    public static void main(String[] args) {
        int[] nums = {100, 4, 200, 1, 3, 2};
        int i = new Solution().longestConsecutive(nums);
        System.out.println(i);
    }

    /**
     * 遍历数组，将数组中的元素添加到set中，然后遍历set，如果set中存在当前元素减一的元素，则说明当前元素不是连续序列的起始元素，跳过。
     * 如果当前元素减一的元素不存在，则说明当前元素是连续序列的起始元素，计算当前元素到set中不存在元素的距离，更新最长连续序列的长度。
     * @param nums
     * @return
     */
    public int longestConsecutive(int[] nums) {
        Set<Integer> num_set = new HashSet<Integer>();
        for (int num : nums) {
            num_set.add(num);
        }
        int longestStreak = 0;
        for (Integer i : num_set) {
            if (!num_set.contains(i - 1)){
                int currentNum = i;
                int currentStreak = 1;
                while (num_set.contains(currentNum + 1)) {
                    currentNum++;
                    currentStreak++;

                }
                longestStreak= Math.max(longestStreak,currentStreak);
            }
        }

        return longestStreak;
    }
}