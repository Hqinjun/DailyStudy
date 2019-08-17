package com.hqinjun.Sort;

public class HeapSort {
    public static void sort(int[] nums){
        if(nums == null || nums.length ==0){
            return;
        }
        for(int i = nums.length/2-1;i>=0;i--){
            heapsort(nums,i,nums.length);
        }
        for(int j = nums.length-1 ; j > 0 ; j--){
            int temp = nums[0];
            nums[0] = nums[j];
            nums[j] = temp;
            heapsort(nums,0,j);
        }
    }
    public  static void heapsort(int[] nums,int i,int len){
        int key = nums[i];
        for(int k = i*2+1;k<len;k = 2*k+1){
            if(k+1<len && nums[k]<nums[k+1]){
                k++;
            }
            if(key < nums[k]){
                nums[i] = nums[k];
                i = k;
            }else {
                break;
            }
        }
        nums[i]= key;
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
        sort(numbers);
        System.out.print("冒泡排序后：");
        printArr(numbers);

    }
}
