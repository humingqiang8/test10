def to_upper(s):
    """
    将字符串中的英文小写字母转换为大写，其他字符保持不变。
    """
    result = []
    for char in s:
        if 'a' <= char <= 'z':
            # 将小写字母转换为大写
            upper_char = chr(ord(char) - ord('a') + ord('A'))
            result.append(upper_char)
        else:
            # 其他字符保持不变
            result.append(char)
    return ''.join(result)

def join_and_upper(strings):
    """
    接收多个字符串列表，先将每个字符串调用 to_upper 转换，
    然后将所有转换后的字符串拼接成一个字符串返回。
    
    参数:
        strings (list of str): 字符串列表
    
    返回:
        str: 拼接并转换后的大写字符串
    """
    converted_strings = [to_upper(s) for s in strings]
    return ''.join(converted_strings)

# 测试用例
if __name__ == "__main__":
    # 测试 to_upper
    print(to_upper("hello world!"))  # 输出: HELLO WORLD!
    print(to_upper("Python3.8"))    # 输出: PYTHON3.8
    
    # 测试 join_and_upper
    input_list = ["hello", " ", "world!", " 123", " café"]
    result = join_and_upper(input_list)
    print(f"输入: {input_list}")
    print(f"输出: {result}") 
    # 预期输出: HELLO WORLD! 123 CAFé
