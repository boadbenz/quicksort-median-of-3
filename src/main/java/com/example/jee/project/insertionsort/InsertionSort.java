package com.example.jee.project.insertionsort;

public class InsertionSort {
    public static int sort(int[] nums, int low, int height) {
        for(int i = low + 1; i <= height; i++) {
            int key = nums[i];
            int j = i-1;
            while (j >= low && key < nums[j]) {
                nums[j+1] = nums[j];
                j--;
            }
            nums[j+1] = key;
        }
        return --height;
    }
}
