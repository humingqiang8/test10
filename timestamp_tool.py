#!/usr/bin/env python3
# -*- coding: utf-8 -*-
"""
时间戳工具脚本
提供获取当前时间戳、转换时间戳等功能
"""

import time
from datetime import datetime


def get_current_timestamp():
    """获取当前时间戳（秒）"""
    return int(time.time())


def get_current_timestamp_ms():
    """获取当前时间戳（毫秒）"""
    return int(time.time() * 1000)


def timestamp_to_datetime(timestamp, format_str="%Y-%m-%d %H:%M:%S"):
    """
    将时间戳转换为日期时间字符串
    
    参数:
        timestamp: 时间戳（秒）
        format_str: 输出格式，默认 "%Y-%m-%d %H:%M:%S"
    
    返回:
        格式化后的日期时间字符串
    """
    dt = datetime.fromtimestamp(timestamp)
    return dt.strftime(format_str)


def datetime_to_timestamp(date_string, format_str="%Y-%m-%d %H:%M:%S"):
    """
    将日期时间字符串转换为时间戳
    
    参数:
        date_string: 日期时间字符串
        format_str: 输入格式，默认 "%Y-%m-%d %H:%M:%S"
    
    返回:
        时间戳（秒）
    """
    dt = datetime.strptime(date_string, format_str)
    return int(dt.timestamp())


if __name__ == "__main__":
    # 获取当前时间戳
    current_ts = get_current_timestamp()
    current_ts_ms = get_current_timestamp_ms()
    
    print("=" * 50)
    print("时间戳工具")
    print("=" * 50)
    print(f"当前时间戳（秒）: {current_ts}")
    print(f"当前时间戳（毫秒）: {current_ts_ms}")
    print(f"当前时间: {timestamp_to_datetime(current_ts)}")
    print("=" * 50)
    
    # 示例：转换特定时间戳
    example_ts = 1700000000
    print(f"\n示例时间戳 {example_ts} 对应的时间: {timestamp_to_datetime(example_ts)}")
    
    # 示例：将日期转换为时间戳
    example_date = "2024-01-01 00:00:00"
    print(f"\n示例日期 '{example_date}' 对应的时间戳: {datetime_to_timestamp(example_date)}")
