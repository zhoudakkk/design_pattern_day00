package app.yjkm.com.day_00.image;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.Log;
import android.widget.ImageView;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 图片加载类
 */
public class ImageLoader {
    private ExecutorService mExecutorService = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());
    private IImageCache mCache;

    public ImageLoader(IImageCache cache) {
        mCache = cache;
    }


    public void displayImage(final String url, final ImageView imageView) {
        imageView.setTag(url);
        mExecutorService.submit(new Runnable() {
            @Override
            public void run() {
                Bitmap bitmap = downloadImage(url);
                Log.e("text123", "run: mCache go" );
                mCache.put(url, bitmap);
                if (bitmap == null) {
                    Log.e("text123", "run: bitmap = null" );
                    return;
                }
                Log.e("text123", "run: mCache go-----------" );
                if (imageView.getTag().equals(url)) {
                    imageView.setImageBitmap(bitmap);
                }
            }
        });
    }

    public Bitmap downloadImage(String imageUrl) {
        Bitmap bitmap = mCache.get(imageUrl);
        if (bitmap != null) {
            return bitmap;
        }
//        Bitmap bitmap =null;
        try {
            URL url = new URL(imageUrl);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            bitmap = BitmapFactory.decodeStream(conn.getInputStream());
            conn.connect();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return bitmap;
    }

}
