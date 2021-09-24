package sorting;

import java.util.Arrays;

public class QuickSort {

    public static void quickSort(int[] arr) {
        qSort(arr, 0, arr.length-1);
    }

    private static void qSort(int[] arr, int low, int high) {
        if (low < high) {
            int pi = partition(arr, low, high);
            qSort(arr, low, pi - 1);
            qSort(arr, pi + 1, high);
        }
    }

    private static int partition(int[] arr, int low, int high) {
        int pivot = arr[high];

        int i = low -1;
        for (int j = low; j < high; j++) {
            if (arr[j] < pivot) {
                i++;
                swap(arr, i, j);
            }
        }
        swap(arr, i+1, high);
        return i+1;

        // 3 9 12 2 -3  7
        // 3 2 12 9 -3  7
        // 3 2 -3 9 12  7
        // 3 2 -3 7 12  9
    }

    private static void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    public static void main(String[] args) {
        int[] nums = { 3, 9, 16, 2, -3,  7 };
        quickSort(nums);

        Arrays.stream(nums).forEach(x -> System.out.print(x + " "));
    }
}
