# SVG Cylinder Project

这个项目包含一个使用 SVG (Scalable Vector Graphics) 绘制的圆柱体示例。

## 文件说明

- `cylinder.svg`: 一个使用 SVG 技术绘制的圆柱体图形文件。
- `BubbleSort.java`: 冒泡排序算法的 Java 实现（似乎与本项目无关）。
- `LICENSE`: 项目的许可证文件。

## 圆柱体 SVG 详解

`cylinder.svg` 文件通过以下 SVG 元素组合绘制出一个具有立体感的圆柱体：

1. **底部椭圆 (后半部分)**: 使用虚线表示被遮挡的部分。
2. **侧面 (矩形)**: 使用线性渐变 (`linearGradient`) 模拟光照效果，使圆柱体看起来有立体感。
3. **顶部椭圆**: 使用径向渐变 (`radialGradient`) 模拟顶部受光效果。
4. **底部椭圆 (前半部分)**: 实线表示可见部分。

### 技术特点

- **渐变效果**:
    - `cylinderGradient`: 线性渐变，从左到右由深到浅再到深，模拟侧面光照。
    - `topGradient`: 径向渐变，从中心向边缘变暗，模拟顶部光照。
- **图层顺序**: 通过合理的绘制顺序（先画背面，再画侧面，最后画正面）实现遮挡关系。

## 如何查看

你可以直接在浏览器中打开 `cylinder.svg` 文件来查看渲染效果，或者在任何支持 SVG 的图像查看器中打开它。

```bash
# 在 Linux/macOS 上使用默认浏览器打开
xdg-open cylinder.svg  # Linux
open cylinder.svg      # macOS

# 在 Windows 上使用默认浏览器打开
start cylinder.svg
```

## 示例预览

由于 Markdown 直接嵌入 SVG 的支持有限，建议直接在浏览器中打开文件查看最佳效果。不过，你也可以将 `cylinder.svg` 的内容直接嵌入到支持 SVG 的 HTML 页面中。

## 许可证

本项目遵循 [LICENSE](LICENSE) 文件中规定的许可证。10