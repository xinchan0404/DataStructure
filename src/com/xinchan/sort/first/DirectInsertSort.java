package sort.first;

import java.util.Arrays;

import static sort.first.BubbleSort.createUnsortedArray;

/**
 * 测试 直接插入排序
 *
 * @author zhengxin
 * @version 1.0.1 2021-11-18
 */
public class DirectInsertSort {
    public static void main(String[] args) {
        /*
         * 测试 直接插入排序每轮运行结果
         */
        System.out.println("----------测试直接插入排序每一轮结果----------");
        directInsertSortTest();

        /*
         * 测试 直接插入排序
         */
        // 创建随机矩阵
        System.out.println("----------测试直接插入排序方法----------");
        int[] randomArray = createUnsortedArray(50000);

        System.out.println("直接插入排序前：");
//        System.out.println(Arrays.toString(randomArray));
        long startMs = System.currentTimeMillis();
        directInsertSort(randomArray);  // 167 ms
        long timeCost = System.currentTimeMillis() - startMs;
        System.out.println("直接插入排序后：");
//        System.out.println(Arrays.toString(randomArray));
        System.out.println("耗时：" + timeCost + " ms");
    }

    /**
     * 打印直接插入排序每轮的运行结果
     */
    public static void directInsertSortTest() {
        // 待排序数组
        int[] array = {4, 3, 2, 1};
        int insertValue = 0;
        int insertIndex = 0;

        /*
         * 直接插入排序第一轮
         */
        System.out.println("直接插入排序第一轮前：");
        System.out.println(Arrays.toString(array));
        // 定义当前待插入的数
        insertValue = array[1];  // 因为 array[0] 默认为初始化的有序序列
        insertIndex = 0;

        while (insertIndex >= 0 && insertValue < array[insertIndex]) {
            array[insertIndex + 1] = array[insertIndex];
            insertIndex--;
        }

        if (insertIndex + 1 != 1) {
            array[insertIndex + 1] = insertValue;
        }

        System.out.println("直接插入排序第一轮后：");
        System.out.println(Arrays.toString(array));

        /*
         * 直接插入排序第二轮
         */
        System.out.println("直接插入排序第二轮前：");
        System.out.println(Arrays.toString(array));
        insertValue = array[2];
        insertIndex = 1;

        while (insertIndex >= 0 && insertValue < array[insertIndex]) {
            array[insertIndex + 1] = array[insertIndex];
            insertIndex--;
        }

        if (insertIndex + 1 != 2) {
            array[insertIndex + 1] = insertValue;
        }

        System.out.println("直接插入排序第二轮后：");
        System.out.println(Arrays.toString(array));

        /*
         * 直接插入排序第三轮
         */
        System.out.println("直接插入排序第三轮前：");
        System.out.println(Arrays.toString(array));
        insertValue = array[3];
        insertIndex = 2;

        while (insertIndex >= 0 && insertValue < array[insertIndex]) {
            array[insertIndex + 1] = array[insertIndex];
            insertIndex--;
        }

        if (insertIndex + 1 != 3) {
            array[insertIndex + 1] = insertValue;
        }

        System.out.println("直接插入排序第三轮后：");
        System.out.println(Arrays.toString(array));
    }

    public static void directInsertSort(int[] array) {
        if (array == null) {
            System.out.println("数组为空，无法排序~~");
            return;
        }

        int insertValue = 0;
        int insertIndex = 0;

        for (int i = 1; i < array.length; i++) {
            insertValue = array[i];  // 默认 array[0] 初始化为有序序列
            insertIndex = i - 1;

            while (insertIndex >= 0 && insertValue < array[insertIndex]) {
                array[insertIndex + 1] = array[insertIndex];
                insertIndex--;
            }

            if (insertIndex + 1 != i) {
                array[insertIndex + 1] = insertValue;
            }
        }
    }
}
