def bubble_sort(arr):
    """
    冒泡排序算法
    
    参数:
        arr: 待排序的列表
    
    返回:
        排序后的列表
    """
    n = len(arr)
    
    # 遍历所有数组元素
    for i in range(n):
        # 最后 i 个元素已经有序，不需要再比较
        for j in range(0, n - i - 1):
            # 如果当前元素大于下一个元素，则交换它们
            if arr[j] > arr[j + 1]:
                arr[j], arr[j + 1] = arr[j + 1], arr[j]
    
    return arr


# 测试示例
if __name__ == "__main__":
    # 测试数据
    test_arr = [64, 34, 25, 12, 22, 11, 90]
    
    print("原始数组:", test_arr)
    sorted_arr = bubble_sort(test_arr.copy())
    print("排序后数组:", sorted_arr)
    
    # 更多测试
    test_cases = [
        [5, 2, 8, 1, 9],
        [1, 2, 3, 4, 5],
        [9, 7, 5, 3, 1],
        [3],
        []
    ]
    
    print("\n更多测试用例:")
    for i, case in enumerate(test_cases, 1):
        result = bubble_sort(case.copy())
        print(f"测试{i}: {case} -> {result}")
