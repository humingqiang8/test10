public class BubbleSort {
    
    /**
     * 冒泡排序方法
     * @param arr 待排序的整数数组
     */
    public static void bubbleSort(int[] arr) {
        int n = arr.length;
        
        // 外层循环控制排序轮数
        for (int i = 0; i < n - 1; i++) {
            boolean swapped = false; // 优化：如果某一轮没有发生交换，则说明已经有序
            
            // 内层循环进行相邻元素比较和交换
            for (int j = 0; j < n - 1 - i; j++) {
                if (arr[j] > arr[j + 1]) {
                    // 交换相邻元素
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    swapped = true;
                }
            }
            
            // 如果这一轮没有发生交换，说明数组已经有序，可以提前结束
            if (!swapped) {
                break;
            }
        }
    }
    
    /**
     * 打印数组元素
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
     * 主方法 - 测试冒泡排序
     */
    public static void main(String[] args) {
        // 测试普通数组
        int[] arr = {64, 34, 25, 12, 22, 11, 90};
        
        System.out.println("原始数组:");
        printArray(arr);
        
        bubbleSort(arr);
        
        System.out.println("排序后数组:");
        printArray(arr);
        
        // 测试边界情况
        int[] emptyArr = {};
        System.out.println("\n空数组测试:");
        System.out.print("排序前: ");
        printArray(emptyArr);
        bubbleSort(emptyArr);
        System.out.print("排序后: ");
        printArray(emptyArr);
        
        int[] singleElement = {42};
        System.out.println("\n单元素数组测试:");
        System.out.print("排序前: ");
        printArray(singleElement);
        bubbleSort(singleElement);
        System.out.print("排序后: ");
        printArray(singleElement);
        
        int[] sortedArr = {1, 2, 3, 4, 5};
        System.out.println("\n已排序数组测试:");
        System.out.print("排序前: ");
        printArray(sortedArr);
        bubbleSort(sortedArr);
        System.out.print("排序后: ");
        printArray(sortedArr);
        
        int[] reverseSortedArr = {5, 4, 3, 2, 1};
        System.out.println("\n逆序数组测试:");
        System.out.print("排序前: ");
        printArray(reverseSortedArr);
        bubbleSort(reverseSortedArr);
        System.out.print("排序后: ");
        printArray(reverseSortedArr);
        
        int[] duplicateElementsArr = {3, 7, 3, 1, 7, 2, 1};
        System.out.println("\n重复元素数组测试:");
        System.out.print("排序前: ");
        printArray(duplicateElementsArr);
        bubbleSort(duplicateElementsArr);
        System.out.print("排序后: ");
        printArray(duplicateElementsArr);
    }
}