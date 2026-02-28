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
        boolean swapped; // 优化标志，如果某一轮没有发生交换，则说明数组已经有序
        
        for (int i = 0; i < n - 1; i++) {
            swapped = false;
            
            // 每轮将最大的元素"冒泡"到末尾
            for (int j = 0; j < n - 1 - i; j++) {
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
    
    // 测试方法
    public static void main(String[] args) {
        int[] arr = {64, 34, 25, 12, 22, 11, 90};
        System.out.println("原始数组:");
        printArray(arr);
        
        bubbleSort(arr);
        
        System.out.println("排序后数组:");
        printArray(arr);
    }
}