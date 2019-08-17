import java.util.Scanner;

public class Sort {
    /**
     * https://www.cnblogs.com/wangmingshun/p/5635292.html
     * 冒泡排序
     * 比较相邻的元素。如果第一个比第二个大，就交换他们两个位置。
     * 对每一对相邻元素作同样的工作，从开始第一对到结尾的最后一对。在这一点，最后的元素应该会是最大的数。
     * 针对所有的元素重复以上的步骤，除了最后一个。
     * 持续每次对越来越少的元素重复上面的步骤，直到没有任何一对数字需要比较。
     * @param numbers 需要排序的整型数组
     * 举例说明：要排序数组：int[] arr={6,3,8,2,9,1};
     *
     * 第一趟排序：
     *
     * 　　　　第一次排序：6和3比较，6大于3，交换位置：  3  6  8  2  9  1
     *
     * 　　　　第二次排序：6和8比较，6小于8，不交换位置：3  6  8  2  9  1
     *
     * 　　　　第三次排序：8和2比较，8大于2，交换位置：  3  6  2  8  9  1
     *
     * 　　　　第四次排序：8和9比较，8小于9，不交换位置：3  6  2  8  9  1
     *
     * 　　　　第五次排序：9和1比较：9大于1，交换位置：  3  6  2  8  1  9
     *
     * 　　　　第一趟总共进行了5次比较， 排序结果：      3  6  2  8  1  9
     */
    public static void bubbleSort(int[] numbers)
    {
        int temp = 0;
        int size = numbers.length;
        //size表示2个数比较的次数
        for(int i = 0 ; i < size-1; i ++)
        {
            for(int j = 0 ;j < size-1-i ; j++)
            {
                if(numbers[j] > numbers[j+1])  //交换两数位置
                {
                    temp = numbers[j];
                    numbers[j] = numbers[j+1];
                    numbers[j+1] = temp;
                }
            }
        }
    }


    public static void  bubbleSort2(int[] nums){
        if(nums == null|| nums.length==0){
            return;
        }
        for(int i = 0; i < nums.length-1; i++){
            for(int j = 0; j < nums.length-1-i; j++){
                if(nums[j] > nums[j+1]){
                    int temp = nums[j];
                    nums[j] = nums[j+1];
                    nums[j+1] = temp;
                }
            }
        }
    }

    public static void SelectSort(int[] nums){
        if(nums == null|| nums.length==0){
            return;
        }
        for(int i = 0; i < nums.length; i++){
            int key  = nums[i];
            int k  = i;
            for(int j = i; j < nums.length ;j++){
                if(nums[j] < key){
                    key = nums[j];
                    k = j;
                }
            }
            int temp  =  nums[k];
            nums[k] = nums[i];
            nums [i] = temp;
        }
    }

    public static void printArr(int[] numbers)
    {
        for(int i = 0 ; i < numbers.length ; i ++ )
        {
            System.out.print(numbers[i] + ",");
        }
        System.out.println("");
    }
    /**
     * 选择排序
     * 在未排序序列中找到最小元素，存放到排序序列的起始位置
     * 再从剩余未排序元素中继续寻找最小元素，然后放到排序序列起始位置。
     * 以此类推，直到所有元素均排序完毕。
     *
     * @param numbers
     */
    public static void selectSort(int[] numbers) {
        int size = numbers.length;
        int temp;
        for (int i = 0; i < size; i++) {
            int k = i;
            int min = numbers[i];
            for (int j = i+1 ; j < size; j++)  {
                if (numbers[j] < min) {
                    k = j;
                    min = numbers[j];
                }
            }
            temp = numbers[i];
            numbers[i] = numbers[k];
            numbers[k] = temp;
        }
    }

    //插入排序
    public static void insertSort(int[] numbers) {
        int size = numbers.length, temp, j;
        for(int i=1; i<size; i++) {
            temp = numbers[i];
            for(j = i; j > 0 && temp < numbers[j-1]; j--)
                numbers[j] = numbers[j-1];
            numbers[j] = temp;
        }
    }


    public static void InsertSort(int[] nums){
        if(nums == null|| nums.length==0){
            return;
        }
        int j = 0;
        for(int i = 1; i < nums.length; i++){
            int key = nums[i];
            for(j = i; j > 0 && key < nums[j-1] ; j--){
                    nums[j] = nums[j-1];

            }
            nums[j] = key;
        }
    }

    public static void main(String[] args) {


//        Scanner input = new Scanner( System.in );
//        System.out.print("Enter a binary number: ");
//        String binaryString =input.nextLine();
//        System.out.println("Output: "+Long.parseLong(binaryString,2));
////
            int[] numbers = {10,10,20,15,0,6,7,2,1,-5,55,10};
//            System.out.print("排序前：");
//            printArr(numbers);

//
//        selectSort(numbers);
//            System.out.print("选择排序后：");
//           printArr(numbers);


        InsertSort(numbers);
            System.out.print("冒泡排序后：");
            printArr(numbers);

//
//            quickSort(numbers);
//            System.out.print("快速排序后：");
//            printArr(numbers);
//
//
//              insertSort(numbers);
//              System.out.print("插入排序后：");
//              printArr(numbers);
        }

}
