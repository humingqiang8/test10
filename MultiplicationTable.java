public class MultiplicationTable {
    public static void main(String[] args) {
        System.out.println("九九乘法表：");
        System.out.println("====================");
        
        // 外层循环控制行数，从1到9
        for (int i = 1; i <= 9; i++) {
            // 内层循环控制每行的列数，从1到i
            for (int j = 1; j <= i; j++) {
                // 打印乘法表达式，使用\t制表符对齐
                System.out.print(j + "×" + i + "=" + (i * j) + "\t");
            }
            // 每行结束后换行
            System.out.println();
        }
    }
}
