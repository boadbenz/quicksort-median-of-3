package com.example.jee.project.quicksort;

import com.example.jee.project.insertionsort.InsertionSort;

public class QuickSort {

    public static void quicksort(int[] nums, int low, int height) {
        if(low < height) {
            int partition = chooseAlgorithm(nums, low, height);

            quicksort(nums, low, partition - 1);
            quicksort(nums, partition + 1, height);
        }
    }

    public static int chooseAlgorithm(int[] nums, int low, int height)  {
        if(height - low > 1) {
            return partition(nums, low, height);
        } else {
            return InsertionSort.sort(nums, low, height);
        }
    }

    public static void medianOfThree(int[] nums, int low, int height) {
        int length = (height - low) + 1; // Calculate the length of the subarray
        int mid = (length / 2) + (length % 2); // Find the middle index, adjusting + 1 for odd lengths
        int midIndex = (low + mid) - 1; // Calculate the actual index in the original array
        sortMedian(nums, low, midIndex, height);
    }

    public static void sortMedian(int[] nums, int low, int midIndex, int height) {
        if(nums[low] > nums[height]) {
            int temp = nums[low];
            nums[low] = nums[height];
            nums[height] = temp;
        }
        if(nums[low] > nums[midIndex]) {
            int temp = nums[low];
            nums[low] = nums[midIndex];
            nums[midIndex] = temp;
        }
        if(nums[midIndex] > nums[height]) {
            int temp = nums[midIndex];
            nums[midIndex] = nums[height];
            nums[height] = temp;
        }

        // Swap mid to Pivot height
        int temp = nums[midIndex];
        nums[midIndex] = nums[height];
        nums[height] = temp;
    }

    public static int partition(int[] nums, int low, int height) {
        medianOfThree(nums, low, height);
        int pivot = height;
        int ldx = low;
        int rdx = height - 1;

        while (ldx <= rdx) {
            if(nums[ldx] < nums[pivot]) {
                ldx++;
            } else if (nums[rdx] > nums[pivot]) {
                rdx--;
            } else {
                int temp = nums[ldx];
                nums[ldx] = nums[rdx];
                nums[rdx] = temp;
                ldx++;
                rdx--;
            }
        }
        if(nums[ldx] > nums[pivot]) {
            int temp = nums[ldx];
            nums[ldx] = nums[pivot];
            nums[pivot] = temp;
        }
        return ldx;
    }


}