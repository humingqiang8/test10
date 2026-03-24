def to_upper(s: str) -> str:
    """
    将字符串中的英文字母转换为大写，其他字符保持不变。
    
    参数:
        s (str): 输入字符串
        
    返回:
        str: 转换后的字符串
    """
    result = []
    for char in s:
        if 'a' <= char <= 'z':
            # 将小写字母转换为大写
            result.append(chr(ord(char) - 32))
        else:
            # 其他字符保持不变
            result.append(char)
    return ''.join(result)


# 测试示例
if __name__ == "__main__":
    test_cases = [
        "hello world!",
        "Python3.8",
        "12345",
        "ABC",
        "mixedCASE123!@#",
        "café",  # 包含非ASCII字符
        ""
    ]
    
    for test in test_cases:
        print(f"输入: '{test}' -> 输出: '{to_upper(test)}'")
