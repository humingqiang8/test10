public class BubbleSort {
    
    /**
     * 冒泡排序方法
     * 时间复杂度：最好情况 O(n)，最坏情况 O(n²)，平均情况 O(n²)
     * 空间复杂度：O(1)
     * @param arr 待排序的整数数组
     */
    public static void bubbleSort(int[] arr) {
        int n = arr.length;
        
        // 外层循环控制排序轮数
        for (int i = 0; i < n - 1; i++) {
            boolean swapped = false; // 优化标志，如果某一轮没有发生交换，则说明已排序完成
            
            // 内层循环进行相邻元素比较和交换
            // 每次外层循环后，最大的元素会"冒泡"到末尾，所以内层循环范围逐渐减小
            for (int j = 0; j < n - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    // 交换相邻元素
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    swapped = true;
                }
            }
            
            // 如果这一轮没有发生任何交换，说明数组已经有序
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
        
        // 测试边界情况：空数组和单个元素
        int[] emptyArr = {};
        bubbleSort(emptyArr);
        System.out.println("空数组排序后:");
        printArray(emptyArr);
        
        int[] singleElement = {42};
        bubbleSort(singleElement);
        System.out.println("单元素数组排序后:");
        printArray(singleElement);
        
        // 测试已排序数组
        int[] sortedArr = {1, 2, 3, 4, 5};
        System.out.println("已排序数组:");
        printArray(sortedArr);
        bubbleSort(sortedArr);
        System.out.println("排序后:");
        printArray(sortedArr);
    }
}