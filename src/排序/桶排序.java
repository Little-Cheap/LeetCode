package 排序;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * 桶排序[0-1)float类型排序
 * 1.初始化k个桶，将n个元素分配到k个桶中。
 * 2.对每个桶分别执行排序(这里采用编程语言的内置排序函数)
 * 3.按照桶从小到大的顺序合并结果。
 * 时间复杂度：O(n+k)
 * 空间复杂度：O(n+k)
 */
public class 桶排序 {
    public static void main(String[] args) {
        float[] arr = {0.49f, 0.96f, 0.82f, 0.09f, 0.57f, 0.43f, 0.91f, 0.75f, 0.15f, 0.37f};
        桶排序 meg = new 桶排序();
        meg.bucketSort(arr);

        System.out.println(Arrays.toString(arr));
    }

    /**
     * 堆排序
     */
    public void bucketSort(float[] arr) {
        // 初始化k个桶
        // 预期每个桶两个元素
        int k = arr.length / 2;
        List<List<Float>> buckets = new ArrayList<>();
        for (int i = 0; i < k; i++) {
            buckets.add(new ArrayList<>());
        }
        // 将n个元素分配到k个桶中。
        for (int i = 0; i < arr.length; i++) {
            float item = arr[i];
            int t = (int) (item * k);
            buckets.get(t).add(item);
        }
        // 对每个桶分别执行排序
        // 按照桶从小到大的顺序合并结果
        for (int i = 0; i < buckets.size(); i++) {
            Collections.sort(buckets.get(i));
        }
        int index = 0;
        for (List<Float> bucket : buckets) {
            for (Float item : bucket) {
                arr[index++] = item;
            }
        }
    }
}
