package com.felix.algorithm;

import java.util.Arrays;

/**
 * @author: FelixSuXP
 * @date: 2022/1/10
 * @description: 排序算法
 */
public class sort {
    public static void main(String[] args) {
        int testTime = 500000;
        int maxSize = 100;
        int maxValue = 100;
        boolean succeed = true;
        for (int i = 0; i < testTime; i++) {
            int[] arr1 = generateRandomArray(maxSize, maxValue);
            int[] arr2 = copyArray(arr1);
//            selectSort(arr1);
//            bubblingSort(arr1);
//            insertionSort1(arr1);
            insertionSort2(arr1);
            comparator(arr2);
            if (!isEqual(arr1, arr2)) {
                succeed = false;
                print(arr1);
                print(arr2);
                break;
            }
        }
        System.out.println(succeed ? "Nice!" : "Fucking fucked!");

        int[] arr = generateRandomArray(maxSize, maxValue);
        print(arr);
        selectSort(arr);
        print(arr);

    }

    // for test
    public static int[] copyArray(int[] arr) {
        if (arr == null) {
            return null;
        }
        int[] res = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            res[i] = arr[i];
        }
        return res;
    }

    // for test
    public static boolean isEqual(int[] arr1, int[] arr2) {
        if ((arr1 == null && arr2 != null) || (arr1 != null && arr2 == null)) {
            return false;
        }
        if (arr1 == null && arr2 == null) {
            return true;
        }
        if (arr1.length != arr2.length) {
            return false;
        }
        for (int i = 0; i < arr1.length; i++) {
            if (arr1[i] != arr2[i]) {
                return false;
            }
        }
        return true;
    }

    // for test
    public static void comparator(int[] arr) {
        Arrays.sort(arr);
    }

    // for test
    public static int[] generateRandomArray(int maxSize, int maxValue) {
        // Math.random()   [0,1)
        // Math.random() * N  [0,N)
        // (int)(Math.random() * N)  [0, N-1]
        int[] arr = new int[(int) ((maxSize + 1) * Math.random())];
        for (int i = 0; i < arr.length; i++) {
            // [-? , +?]
            arr[i] = (int) ((maxValue + 1) * Math.random()) - (int) (maxValue * Math.random());
        }
        return arr;
    }

    // for test
    private static void print(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    private static void swap(int[] arr, int first, int second) {
        int temp = arr[first];
        arr[first] = arr[second];
        arr[second] = temp;
    }

    // 异或，无额外变量交换 first不能等于second
    private static void swap1(int[] arr, int first, int second) {
        arr[first] = arr[first] ^ arr[second];
        arr[second] = arr[first] ^ arr[second];
        arr[first] = arr[first] ^ arr[second];
    }

    //选择排序
    private static void selectSort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        int N = arr.length;
        for (int i = 0; i < N; i++) {
            int minValueIndex = i;
            for (int j = i + 1; j < N; j++) {
                minValueIndex = arr[minValueIndex] < arr[j] ? minValueIndex : j;
            }
            if (minValueIndex != i)
                swap(arr, i, minValueIndex);
        }
    }

    // 冒泡排序
    private static void bubblingSort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        int N = arr.length;
        for (int end = N - 1; end >= 0; end--) {
            for (int j = 1; j < end; j++) {
                if (arr[j - 1] > arr[j]) {
                    swap(arr, j - 1, j);
                }
            }
        }
    }

    // 插入排序
    private static void insertionSort1(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        int N = arr.length;
        for (int end = 1; end < N; end++) {
            int newIndex = end;
            while (newIndex - 1 >= 0 && arr[newIndex - 1] > arr[newIndex]) {
                swap(arr, newIndex - 1, newIndex);
                newIndex--;
            }
        }
    }

    // 插入排序
    private static void insertionSort2(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        int N = arr.length;
        for (int end = 1; end < N; end++) {
            for (int j = end; j > 0 && arr[j] < arr[j - 1]; j--) {
                swap(arr, j - 1, j);
            }
        }
    }
}
