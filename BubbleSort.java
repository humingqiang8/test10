public class BubbleSort {

    /**
     * 冒泡排序实现
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
            // 每趟结束后，最大的元素会"冒泡"到末尾，所以减去 i
            for (int j = 0; j < n - 1 - i; j++) {
                if (arr[j] > arr[j + 1]) {
                    // 交换元素
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    swapped = true;
                }
            }
            
            // 如果一趟下来没有发生交换，说明已经有序，提前结束
            if (!swapped) {
                break;
            }
        }
    }

    /**
     * 打印数组
     */
    public static void printArray(int[] arr) {
        System.out.print("[");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]);
            if (i < arr.length - 1) {
                System.out.print(", ");
            }
        }
        System.out.println("]");
    }

    public static void main(String[] args) {
        // 测试数据
        int[] array = {64, 34, 25, 12, 22, 11, 90};
        
        System.out.println("原始数组:");
        printArray(array);
        
        bubbleSort(array);
        
        System.out.println("排序后数组:");
        printArray(array);
        
        // 测试已排序数组（验证优化逻辑）
        int[] sortedArray = {1, 2, 3, 4, 5};
        System.out.println("\n已排序数组测试:");
        printArray(sortedArray);
        bubbleSort(sortedArray);
        printArray(sortedArray);
        
        // 测试逆序数组
        int[] reverseArray = {5, 4, 3, 2, 1};
        System.out.println("\n逆序数组测试:");
        printArray(reverseArray);
        bubbleSort(reverseArray);
        printArray(reverseArray);
    }
}
