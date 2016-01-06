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
	 * ͼƬ�ϳ� ��Բ(�кܶ���ģʽ������ģʽ�뿴assets�µ��ļ�,Ŀǰʹ�õ�������֮һ)
	 * ����ͨ��PoterDuffXfermode����Ϊ����ģʽ,������Thomas Porter��Tom Duff������,������1984����ACM
	 * SIGGRAPH�����ͼ��ѧ����Compositing digital
	 * images(�ϳ�����ͼ��)��������,�������˱˴��ص�����ͼ��Ĳ�ͬ����.��Щ����������Щͼ�����Щ���ֽ������ڽ�������.
	 * ��Android��PorterDuff.Mode�����о���Porter��Duff�������������ƶ��Ĺ���.
	 * android.graphics.PorterDuff.Mode.SRC:�˹�����ζ��ֻ����Դͼ��,��ǰ������Ӧ�ô˹����Paint����.
	 * android.graphics.PorterDuff.Mode.DST:�˹�����ζ��ֻ��ʾĿ��ͼ��,�����л����ϵĳ�ʼͼ��.
	 * 
	 * @param bitmap
	 */
	@SuppressWarnings("deprecation")
	private void addFrameToImage(Bitmap bitmap) // bmpԭͼ(ǰ��) bm��ԴͼƬ(����)
	{
		Bitmap roundBitmap = Bitmap.createBitmap(bitmap.getWidth(), bitmap.getHeight(),
				Config.ARGB_8888);
		Canvas canvas = new Canvas(roundBitmap);
		int color = 0xff424242;
		Paint paint = new Paint();
		// ����Բ�ΰ뾶
		int radius = 25;
		// ����Բ��
		paint.setAntiAlias(true);
		canvas.drawARGB(0, 0, 0, 0);
		paint.setColor(color);
		canvas.drawCircle(0, 0, radius, paint);// ����λ��
		paint.setXfermode(new PorterDuffXfermode(Mode.SRC_OUT));// ��Ҫ���룬������Բ
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
