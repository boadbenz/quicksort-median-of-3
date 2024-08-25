package com.example.jee.project;

import com.example.jee.project.quicksort.QuickSort;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int[] nums = {7, 8, 10, 2, 26, 4, 19, 5, 3, 16, 11, 6, 13, 12};
        QuickSort.quicksort(nums, 0, nums.length - 1);
        System.out.println(Arrays.toString(nums));

    }
}