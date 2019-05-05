package app.yjkm.com.day_00.image;

import android.content.Context;
import android.graphics.Bitmap;

/**
 * 双缓存
 */
public class ImageCacheDouble implements IImageCache {
    ImageCacheSD cacheSD;
    ImageCache cache;

    public ImageCacheDouble() {
        cache = new ImageCache();
        cacheSD = new ImageCacheSD();
    }

    @Override
    public Bitmap get(String url) {
        Bitmap bitmap = null;
        if (cache.get(url) == null) {
            bitmap = cacheSD.get(url);
        }
        return bitmap;
    }

    @Override
    public void put(String url, Bitmap bitmap) {
        cache.put(url,bitmap);
        cacheSD.put(url,bitmap);
    }
}
