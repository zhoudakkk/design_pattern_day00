package app.yjkm.com.day_00.image;

import android.graphics.Bitmap;
import android.util.LruCache;

/**
 * 图片缓存
 */
public class ImageCache implements IImageCache {
    LruCache<String, Bitmap> mImageLruCache;

    public ImageCache() {
        initImageLoader();
    }

    private void initImageLoader() {
        int maxMemory = (int) (Runtime.getRuntime().maxMemory() / 1024);
        int cacheSize = maxMemory / 4;
        mImageLruCache = new LruCache<String, Bitmap>(cacheSize) {
            @Override
            protected int sizeOf(String key, Bitmap value) {
                return super.sizeOf(key, value);
            }
        };
    }

    @Override
    public void put(String url, Bitmap bitmap) {
        mImageLruCache.put(url, bitmap);
    }

    @Override
    public Bitmap get(String url) {
        return mImageLruCache.get(url);
    }
}
