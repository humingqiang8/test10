public class BubbleSortWithExplanation {
    
    /**
     * 带详细解释的冒泡排序方法
     * @param arr 待排序的整数数组
     */
    public static void bubbleSortWithExplanation(int[] arr) {
        int n = arr.length;
        System.out.println("开始冒泡排序，数组长度: " + n);
        
        // 外层循环控制排序轮数
        for (int i = 0; i < n - 1; i++) {
            System.out.println("\n第 " + (i + 1) + " 轮排序:");
            boolean swapped = false; // 优化：如果某一轮没有发生交换，说明已经有序
            
            // 内层循环进行相邻元素比较和交换
            for (int j = 0; j < n - i - 1; j++) {
                System.out.print("  比较 " + arr[j] + " 和 " + arr[j + 1]);
                
                if (arr[j] > arr[j + 1]) {
                    // 交换相邻元素
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    swapped = true;
                    
                    System.out.println(" -> 交换! 数组变为: ");
                    printArray(arr);
                } else {
                    System.out.println(" -> 不交换");
                }
            }
            
            // 如果这一轮没有发生交换，数组已经有序，可以提前结束
            if (!swapped) {
                System.out.println("本轮没有发生交换，数组已有序，排序结束。");
                break;
            }
        }
        
        System.out.println("\n最终排序结果: ");
        printArray(arr);
    }
    
    /**
     * 简洁版冒泡排序（不带输出）
     * @param arr 待排序的整数数组
     */
    public static void bubbleSort(int[] arr) {
        int n = arr.length;
        
        for (int i = 0; i < n - 1; i++) {
            boolean swapped = false;
            
            for (int j = 0; j < n - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    // 交换相邻元素
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    swapped = true;
                }
            }
            
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
     * 主方法 - 测试冒泡排序
     */
    public static void main(String[] args) {
        System.out.println("=== 冒泡排序演示 ===");
        int[] arr = {64, 34, 25, 12, 22, 11, 90};
        
        System.out.println("原始数组:");
        printArray(arr);
        
        // 创建一个副本用于详细演示
        int[] demoArr = arr.clone();
        bubbleSortWithExplanation(demoArr);
        
        System.out.println("\n=== 验证简洁版算法 ===");
        int[] simpleArr = {5, 2, 8, 1, 9};
        System.out.println("测试数组: ");
        printArray(simpleArr);
        
        bubbleSort(simpleArr);
        System.out.println("排序后: ");
        printArray(simpleArr);
    }
}