package app.yjkm.com.day_00.image;

import android.graphics.Bitmap;

public interface IImageCache {
    Bitmap get(String url);
    void put(String url,Bitmap bitmap);
}
