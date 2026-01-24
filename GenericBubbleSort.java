import java.util.Arrays;
import java.util.Comparator;

public class GenericBubbleSort {
    
    /**
     * 泛型冒泡排序方法 - 使用自然顺序排序（要求T实现了Comparable接口）
     * @param arr 待排序的泛型数组
     * @param <T> 数组元素类型，必须实现Comparable接口
     */
    public static <T extends Comparable<T>> void bubbleSort(T[] arr) {
        int n = arr.length;
        
        for (int i = 0; i < n - 1; i++) {
            boolean swapped = false;
            
            for (int j = 0; j < n - i - 1; j++) {
                if (arr[j].compareTo(arr[j + 1]) > 0) {
                    // 交换相邻元素
                    T temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    swapped = true;
                }
            }
            
            if (!swapped) {
                break; // 如果这一轮没有发生交换，说明已经有序
            }
        }
    }
    
    /**
     * 泛型冒泡排序方法 - 使用自定义比较器
     * @param arr 待排序的泛型数组
     * @param comparator 自定义比较器
     * @param <T> 数组元素类型
     */
    public static <T> void bubbleSort(T[] arr, Comparator<T> comparator) {
        int n = arr.length;
        
        for (int i = 0; i < n - 1; i++) {
            boolean swapped = false;
            
            for (int j = 0; j < n - i - 1; j++) {
                if (comparator.compare(arr[j], arr[j + 1]) > 0) {
                    // 交换相邻元素
                    T temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    swapped = true;
                }
            }
            
            if (!swapped) {
                break; // 如果这一轮没有发生交换，说明已经有序
            }
        }
    }
    
    /**
     * 打印数组元素
     * @param arr 要打印的数组
     */
    public static <T> void printArray(T[] arr) {
        System.out.println(Arrays.toString(arr));
    }
    
    /**
     * 主方法 - 演示泛型冒泡排序的使用
     */
    public static void main(String[] args) {
        // 测试整数数组
        Integer[] intArr = {64, 34, 25, 12, 22, 11, 90};
        System.out.println("原始整数数组: " + Arrays.toString(intArr));
        bubbleSort(intArr);
        System.out.println("排序后整数数组: " + Arrays.toString(intArr));
        
        System.out.println();
        
        // 测试字符串数组
        String[] strArr = {"banana", "apple", "orange", "grape", "cherry"};
        System.out.println("原始字符串数组: " + Arrays.toString(strArr));
        bubbleSort(strArr);
        System.out.println("排序后字符串数组: " + Arrays.toString(strArr));
        
        System.out.println();
        
        // 使用自定义比较器按长度排序字符串
        String[] strArrByLength = {"banana", "apple", "orange", "grape", "cherry", "kiwi"};
        System.out.println("原始字符串数组(按长度): " + Arrays.toString(strArrByLength));
        bubbleSort(strArrByLength, Comparator.comparing(String::length));
        System.out.println("按长度排序后: " + Arrays.toString(strArrByLength));
        
        System.out.println();
        
        // 测试逆序排序
        Integer[] reverseArr = {1, 5, 3, 9, 2, 8, 4};
        System.out.println("原始数组(逆序): " + Arrays.toString(reverseArr));
        bubbleSort(reverseArr, Comparator.reverseOrder());
        System.out.println("逆序排序后: " + Arrays.toString(reverseArr));
    }
}