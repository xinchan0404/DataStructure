package sort.first;

import java.util.Arrays;

/**
 * @author zhengxin
 * @version 1.0.1 2021-11-20
 */
public class QuickSort {
    public static void main(String[] args) {
        /*
         * 测试快速排序每一轮运行情况
         */
        System.out.println("----------测试快速排序----------");
        // 创建随记无序数组
//        int[] randomArray = createUnsortedArray(50000);
//        int[] randomArray = {-9, 78, 0, 23, -567, 70};
//        int[] randomArray = {1, 2, 3, 4, 6, 7, 2, 8};
//        int[] randomArray = {1, 2, 3, 4, 5, 6, 7, 8};
        int[] randomArray = {-1, 3, 0, 0, 1, 2, 3};

        System.out.println("快速排序前：");
        System.out.println(Arrays.toString(randomArray));
        long startMs = System.currentTimeMillis();
        quickSort(randomArray, 0, randomArray.length - 1);  // 7 ms 快速排序牛逼~~
        long timeCost = System.currentTimeMillis() - startMs;
        System.out.println("快速排序后：");
        System.out.println(Arrays.toString(randomArray));
        System.out.println("耗时：" + timeCost + " ms");
    }

    /**
     * 快速排序
     */
    public static void quickSort(int[] array, int start, int end) {
        // 创建待排序数组
        int s = start;
        int e = end;
        int pivot = array[(s + e) / 2];  // 中轴值


        while (s < e) {
            while (array[s] < pivot) {
                s++;
            }
            while (array[e] > pivot) {
                e--;
            }

            if (s >= e) {
                break;
            }

            // 交换值
            swap(array, s, e);

            if (array[s] == pivot) {
                e--;
            }
            if (array[e] == pivot) {
                s++;
            }
        }
        /*
         * 出现过 BUG
         * 如果出现： e 指向 pivot 前面一个，s 指向 pivot，即 s > e，会出现此种情况
         */
        if (s == e) {
            s++;
            e--;
        }

        // 向左递归
        if (start < e) {
            quickSort(array, start, e);
        }
        // 向右递归
        if (s < end) {
            quickSort(array, s, end);
        }
    }

    private static void swap(int[] array, int xIndex, int yIndex) {
        int tmp = array[xIndex];
        array[xIndex] = array[yIndex];
        array[yIndex] = tmp;
    }
}
