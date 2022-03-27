package com.felix.algorithm;

/**
 * @author: FelixSuXP
 * @date: 2022/3/27
 * @description: 无序数组中找局部最小值的
 */
public class DisorderMinNum {

    private static int getLessIndex(int[] arr) {
        if (arr == null || arr.length < 1)
            return -1;

        int length = arr.length;
        if (length == 1 || arr[0] < arr[1])
            return 0;
        if (arr[length - 1] < arr[length - 2])
            return length - 1;
        int left = 0, right = length - 1, min;
        while (left < right) {
            min = left + ((right - left) >> 1);
            if (arr[min] > arr[min - 1])
                right = min - 1;
            else if (arr[min] > arr[min + 1])
                left = min + 1;
            else
                return min;
        }
        return left;
    }

    // 验证得到的结果，是不是局部最小
    public static boolean isRight(int[] arr, int index) {
        if (arr.length <= 1) {
            return true;
        }
        if (index == 0) {
            return arr[index] < arr[index + 1];
        }
        if (index == arr.length - 1) {
            return arr[index] < arr[index - 1];
        }
        return arr[index] < arr[index - 1] && arr[index] < arr[index + 1];
    }

    // 为了测试
    // 生成相邻不相等的数组
    public static int[] generateRandomArray(int maxSize, int maxValue) {
        int[] arr = new int[(int) (Math.random() * maxSize) + 1];
        arr[0] = (int) (Math.random() * maxValue) - (int) (Math.random() * maxValue);
        for (int i = 1; i < arr.length; i++) {
            do {
                arr[i] = (int) (Math.random() * maxValue) - (int) (Math.random() * maxValue);
            } while (arr[i] == arr[i - 1]);
        }
        return arr;
    }

    // 为了测试
    public static void main(String[] args) {
        int testTime = 500;
        int maxSize = 30;
        int maxValue = 100;
        System.out.println("测试开始");
        for (int i = 0; i < testTime; i++) {
            int[] arr = generateRandomArray(maxSize, maxValue);
            int ans = 0;
            try {
                ans = getLessIndex(arr);
            } catch (Exception e) {
                for (int k : arr) System.out.print(k + " ");
                System.out.println();
            }
            if (!isRight(arr, ans)) {
                System.out.println("出错了！");
                for (int k : arr) System.out.print(k + " ");
                System.out.println();
                System.out.println(ans + " " + arr[ans] + " " + arr.length);
                break;
            }
        }
        System.out.println("测试结束");
    }
}
