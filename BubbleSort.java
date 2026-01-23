public class BubbleSort {
    
    /**
     * 冒泡排序方法
     * @param arr 待排序的整数数组
     */
    public static void bubbleSort(int[] arr) {
        int n = arr.length;
        
        // 外层循环控制排序轮数
        for (int i = 0; i < n - 1; i++) {
            // 标记本轮是否发生交换，用于优化
            boolean swapped = false;
            
            // 内层循环进行相邻元素比较和交换
            for (int j = 0; j < n - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    // 交换相邻元素
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    swapped = true;
                }
            }
            
            // 如果本轮没有发生交换，说明数组已经有序，可以提前结束
            if (!swapped) {
                break;
            }
        }
    }
    
    /**
     * 打印数组内容
     * @param arr 要打印的数组
     */
    public static void printArray(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]);
            if (i < arr.length - 1) {
                System.out.print(" ");
            }
        }
        System.out.println();
    }
    
    /**
     * 主方法，用于测试冒泡排序
     */
    public static void main(String[] args) {
        int[] arr = {64, 34, 25, 12, 22, 11, 90};
        
        System.out.println("原始数组:");
        printArray(arr);
        
        bubbleSort(arr);
        
        System.out.println("排序后数组:");
        printArray(arr);
        
        // 测试边界情况：已排序数组
        int[] sortedArr = {1, 2, 3, 4, 5};
        System.out.println("\n已排序数组测试:");
        System.out.println("排序前:");
        printArray(sortedArr);
        bubbleSort(sortedArr);
        System.out.println("排序后:");
        printArray(sortedArr);
        
        // 测试边界情况：逆序数组
        int[] reverseArr = {5, 4, 3, 2, 1};
        System.out.println("\n逆序数组测试:");
        System.out.println("排序前:");
        printArray(reverseArr);
        bubbleSort(reverseArr);
        System.out.println("排序后:");
        printArray(reverseArr);
        
        // 测试边界情况：单个元素
        int[] singleArr = {42};
        System.out.println("\n单个元素数组测试:");
        System.out.println("排序前:");
        printArray(singleArr);
        bubbleSort(singleArr);
        System.out.println("排序后:");
        printArray(singleArr);
        
        // 测试边界情况：空数组
        int[] emptyArr = {};
        System.out.println("\n空数组测试:");
        System.out.println("排序前长度: " + emptyArr.length);
        bubbleSort(emptyArr);
        System.out.println("排序后长度: " + emptyArr.length);
    }
}