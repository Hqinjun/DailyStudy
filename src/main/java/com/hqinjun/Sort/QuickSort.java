package com.hqinjun.Sort;

public class QuickSort {

    public static void quicksort(int[] nums){
        if(nums == null || nums.length ==0){
            return;
        }
        quicksort(nums, 0, nums.length-1);

    }
    public static void quicksort(int[] nums, int low, int high){
        if(low > high){
            return;
        }
        int i = low;
        int j = high;
        int key = nums[low];
        while (i < j){
            while (i < j && nums[j] >= key) {
                j--;
            }
            while (i < j && nums[i] <= key){
                i++;
            }
            if(i < j){
                int temp =  nums[j];
                nums[j] =  nums[i];
                nums[i] = temp;
            }
        }
        nums[low] = nums[i];
        nums[i] = key;
        quicksort(nums, low, i-1);
        quicksort(nums, i+1, high);
    }

    public static void printArr(int[] numbers)
        {
        for(int i = 0 ; i < numbers.length ; i ++ )
        {
            System.out.print(numbers[i] + ",");
        }
        System.out.println("");
    }


    public static void main(String[] args) {
        int[] numbers = {10,10,20,15,0,6,7,2,1,-5,55,10};
         quicksort(numbers);
        printArr(numbers);
    }
}
