package 排序;

import java.util.Arrays;

/**
 * 归并排序
 * 1.递归拆分数组，最后将数组拆到只有一个元素，然后进行合并
 * 2.合并数组，将两个有序数组合并成一个有序数组
 * 时间复杂度：O(nlogn)
 * 空间复杂度：O(n)
 */
public class 归并排序 {
    public static void main(String[] args) {
        int[] arr = {5, 4, 3, 2, 1};
        归并排序 meg = new 归并排序();
        meg.mergeSort(arr, 0, arr.length - 1);

        System.out.println(Arrays.toString(arr));
    }

    /**
     * 合并左子数组和右子数组
     */
    public void merge(int[] arr, int left, int mid, int right) {
        // 左子数组区间为 [left, mid], 右子数组区间为 [mid+1, right]
        // 创建一个临时数组 tmp ，用于存放合并后的结果
        int[] temp = new int[right - left + 1];
        // 初始化左子数组和右子数组的起始索引
        int i = left, j = mid + 1, k = 0;
        // 当左右子数组都还有元素时，进行比较并将较小的元素复制到临时数组中
        while (i <= mid && j <= right) {
            if (arr[i] <= arr[j]) {
                temp[k++] = arr[i++];
            } else {
                temp[k++] = arr[j++];
            }
        }
        // 将左子数组和右子数组的剩余元素复制到临时数组中
        while (i <= mid) {
            temp[k++] = arr[i++];
        }
        while (j <= right) {
            temp[k++] = arr[j++];
        }

        // 将临时数组 tmp 中的元素复制回原数组 nums 的对应区间
        for (k = 0; k < temp.length; k++) {
            arr[left + k] = temp[k];
        }

    }

    /**
     * 归并
     */
    public void mergeSort(int[] arr, int left, int right) {
        if (left >= right) {
            return;
        }
        int mid = (left + right) / 2;
        mergeSort(arr, left, mid);
        mergeSort(arr, mid + 1, right);
        merge(arr, left, mid, right);
    }
}
