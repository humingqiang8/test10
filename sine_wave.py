import numpy as np
import matplotlib.pyplot as plt

# 生成正弦波数据
x = np.linspace(0, 2 * np.pi, 1000)  # 从0到2π，生成1000个点
y = np.sin(x)

# 创建图像
plt.figure(figsize=(10, 6))
plt.plot(x, y, label='sin(x)', color='blue', linewidth=2)
plt.title('Sine Wave', fontsize=16)
plt.xlabel('x (radians)', fontsize=12)
plt.ylabel('sin(x)', fontsize=12)
plt.axhline(y=0, color='black', linewidth=0.5)  # x轴
plt.axvline(x=0, color='black', linewidth=0.5)  # y轴
plt.grid(True, linestyle='--', alpha=0.7)
plt.legend()
plt.tight_layout()

# 保存图像
plt.savefig('sine_wave.png', dpi=300)
print("正弦波图像已保存为 sine_wave.png")

# 显示图像（如果在本地运行）
# plt.show()
