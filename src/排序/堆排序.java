package 排序;

import java.util.Arrays;

/**
 * 堆排序
 * 1.先进行建堆操作(初始化大顶堆)
 *  让其非叶子节点逐一与其子节点比较，小于子节点进行交换
 * 2.取根节点与最后一个元素交换位置，即放于已排序区域
 * 时间复杂度：O(nlogn)
 * 空间复杂度：O(1)
 */
public class 堆排序 {
    public static void main(String[] args) {
        int[] arr = {5, 4, 3, 2, 1};
        堆排序 meg = new 堆排序();
        meg.heapSort(arr);

        System.out.println(Arrays.toString(arr));
    }

    /**
     * 堆的长度为 n ，从节点 i 开始，从顶至底堆化
     */
    public void siftDown(int[] arr, int n, int i) {
        // 开始堆化
        // 节点与其子节点比较，节点小于子节点，交换位置
        while (true){
            // 最大数的节点的索引
            int max = i;
            int left = 2 * i + 1;
            int right = 2 * i + 2;
            // 左节点的索引
            if (left<n && arr[left] > arr[max]){
                max = left;
            }
            // 右节点的索引
            if (right<n && arr[right] > arr[max]){
                max = right;
            }
            // 当前节点就是最大节点直接退出，无需堆化
            if (max == i){
                break;
            }
            // 交换
            int temp = arr[i];
            arr[i] = arr[max];
            arr[max] = temp;
            // 接续向下堆化
            i = max;
        }

    }

    /**
     * 堆排序
     */
    public void heapSort(int[] arr) {
        // 建堆操作
        // 从非叶子节点开始堆化
        for (int i = arr.length / 2 - 1; i >= 0; i--) {
            siftDown(arr, arr.length, i);
        }

        // 将堆的根节点与最后有个叶子节点交换位置
        // 即将根节点放入已排序区域
        for (int i = arr.length - 1; i >= 0; i--) {
            int temp = arr[i];
            arr[i] = arr[0];
            arr[0] = temp;
            siftDown(arr, i, 0);
        }
    }
}
