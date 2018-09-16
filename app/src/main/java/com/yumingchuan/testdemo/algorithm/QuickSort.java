package com.yumingchuan.testdemo.algorithm;

/**
 * Created by yumingchuan on 2018/9/16.最好的时间复杂度为nlogn.最坏n^2
 */

public class QuickSort {

    public int[] quickSort(int[] arr) {
        if (arr == null || arr.length == 0) {
            if (arr == null) {
                throw new RuntimeException("数组为null");
            } else {
                throw new RuntimeException("数组长度为0");
            }
        } else {
            quickSort(arr, 0, arr.length - 1);
        }
        return arr;
    }

    private void quickSort(int[] arr, int low, int high) {
        if (low < high) {
            int povit = povit(arr, low, high);
            quickSort(arr, low, povit - 1);
            quickSort(arr, povit + 1, high);
        }
    }

    private int povit(int[] arr, int low, int high) {
        int temp = arr[low];
        while (low < high) {
            while (low < high && arr[high] >= temp) {
                high--;
            }
            arr[low] = arr[high];
            while (low < high && arr[low] <= temp) {
                low++;
            }
            arr[high] = arr[low];
        }
        arr[low] = temp;
        return low;
    }

}
