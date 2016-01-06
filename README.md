    图片合成 内圆(有很多种模式，具体模式请看assets下的文件,目前使用的是其中之一)
	 * 方法通过PoterDuffXfermode类作为过渡模式,该类因Thomas Porter和Tom Duff而得名,他们于1984年在ACM
	 * SIGGRAPH计算机图形学发表“Compositing digital
	 * images(合成数字图像)”的文章,它介绍了彼此重叠绘制图像的不同规则.这些规则定义了哪些图像的哪些部分将出现在结果输出中.
	 * 在Android的PorterDuff.Mode类中列举了Porter和Duff及其他更多人制定的规则.
	 * android.graphics.PorterDuff.Mode.SRC:此规则意味着只绘制源图像,当前它正是应用此规则的Paint对象.
	 * android.graphics.PorterDuff.Mode.DST:此规则意味着只显示目标图像,在已有画布上的初始图像.
