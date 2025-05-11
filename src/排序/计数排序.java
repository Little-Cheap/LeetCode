package 排序;

public class 计数排序 {
    public static void main(String[] args) {
        //
        int[] nums = {1,0,1,2,0,4,0,2,2,4};

    }

    /**
     * 简单排序
     * 1.找到最大的数m
     * 2.创建一个m+1的数组
     * 3.计算出现的次数
     * 4.依次排序
     */
    public void countingSortNaive(int[] nums){
        int max = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (max < nums[i]) {
                max = nums[i];
            }
        }
        int[] temp = new int[max + 1];
        for (int i = 0; i < nums.length; i++) {
            temp[nums[i]]++;
        }
        for (int i = 0; i < nums.length;) {
            for (int j = 0; j < temp[i]; j++,i++) {
                nums[i]--;
            }
        }

    }
}
