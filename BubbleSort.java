public class BubbleSort {
    
    /**
     * 冒泡排序方法
     * @param arr 待排序的整数数组
     */
    public static void bubbleSort(int[] arr) {
        if (arr == null || arr.length <= 1) {
            return;
        }
        
        int n = arr.length;
        boolean swapped;
        
        // 外层循环控制趟数
        for (int i = 0; i < n - 1; i++) {
            swapped = false;
            
            // 内层循环进行相邻元素比较和交换
            for (int j = 0; j < n - 1 - i; j++) {
                if (arr[j] > arr[j + 1]) {
                    // 交换元素
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    swapped = true;
                }
            }
            
            // 如果这一趟没有发生交换，说明已经有序，提前结束
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
        for (int value : arr) {
            System.out.print(value + " ");
        }
        System.out.println();
    }
    
    /**
     * 主方法 - 测试冒泡排序
     */
    public static void main(String[] args) {
        // 测试用例1：无序数组
        int[] arr1 = {64, 34, 25, 12, 22, 11, 90};
        System.out.println("原始数组:");
        printArray(arr1);
        
        bubbleSort(arr1);
        
        System.out.println("排序后数组:");
        printArray(arr1);
        
        // 测试用例2：已排序数组
        int[] arr2 = {1, 2, 3, 4, 5};
        System.out.println("\n原始数组 (已排序):");
        printArray(arr2);
        
        bubbleSort(arr2);
        
        System.out.println("排序后数组:");
        printArray(arr2);
        
        // 测试用例3：逆序数组
        int[] arr3 = {5, 4, 3, 2, 1};
        System.out.println("\n原始数组 (逆序):");
        printArray(arr3);
        
        bubbleSort(arr3);
        
        System.out.println("排序后数组:");
        printArray(arr3);
    }
}
