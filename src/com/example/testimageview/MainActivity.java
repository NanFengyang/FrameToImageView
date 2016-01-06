package com.example.testimageview;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff.Mode;
import android.graphics.PorterDuffXfermode;
import android.os.Bundle;
import android.view.Menu;
import android.widget.ImageView;

public class MainActivity extends Activity {
	private ImageView mImageView;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		mImageView = (ImageView) findViewById(R.id.ImageView1);
		addFrameToImage(BitmapFactory.decodeResource(getResources(), R.drawable.ttr));
	}

	/**
	 * 图片合成 内圆(有很多种模式，具体模式请看assets下的文件,目前使用的是其中之一)
	 * 方法通过PoterDuffXfermode类作为过渡模式,该类因Thomas Porter和Tom Duff而得名,他们于1984年在ACM
	 * SIGGRAPH计算机图形学发表“Compositing digital
	 * images(合成数字图像)”的文章,它介绍了彼此重叠绘制图像的不同规则.这些规则定义了哪些图像的哪些部分将出现在结果输出中.
	 * 在Android的PorterDuff.Mode类中列举了Porter和Duff及其他更多人制定的规则.
	 * android.graphics.PorterDuff.Mode.SRC:此规则意味着只绘制源图像,当前它正是应用此规则的Paint对象.
	 * android.graphics.PorterDuff.Mode.DST:此规则意味着只显示目标图像,在已有画布上的初始图像.
	 * 
	 * @param bitmap
	 */
	@SuppressWarnings("deprecation")
	private void addFrameToImage(Bitmap bitmap) // bmp原图(前景) bm资源图片(背景)
	{
		Bitmap roundBitmap = Bitmap.createBitmap(bitmap.getWidth(), bitmap.getHeight(),
				Config.ARGB_8888);
		Canvas canvas = new Canvas(roundBitmap);
		int color = 0xff424242;
		Paint paint = new Paint();
		// 设置圆形半径
		int radius = 25;
		// 绘制圆形
		paint.setAntiAlias(true);
		canvas.drawARGB(0, 0, 0, 0);
		paint.setColor(color);
		canvas.drawCircle(0, 0, radius, paint);// 设置位置
		paint.setXfermode(new PorterDuffXfermode(Mode.SRC_OUT));// 重要代码，设置内圆
		canvas.drawBitmap(bitmap, 0, 0, paint);
		mImageView.setImageBitmap(roundBitmap);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
