// 冒泡排序函数
function bubbleSort(arr) {
    const n = arr.length;
    
    // 外层循环控制趟数
    for (let i = 0; i < n - 1; i++) {
        // 内层循环进行相邻元素比较和交换
        for (let j = 0; j < n - 1 - i; j++) {
            if (arr[j] > arr[j + 1]) {
                // 交换元素
                [arr[j], arr[j + 1]] = [arr[j + 1], arr[j]];
            }
        }
    }
    
    return arr;
}

// 测试示例
const array = [64, 34, 25, 12, 22, 11, 90];
console.log("原始数组:", array);
const sortedArray = bubbleSort(array);
console.log("排序后数组:", sortedArray);

// 导出函数（可选，用于模块导入）
module.exports = bubbleSort;
