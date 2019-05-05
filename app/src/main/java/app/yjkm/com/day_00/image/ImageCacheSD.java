package app.yjkm.com.day_00.image;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Environment;
import android.util.Log;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class ImageCacheSD implements IImageCache {

    public static final String cacheDir = Environment.getExternalStorageDirectory().getAbsolutePath() + File.separator + "temp" + File.separator; //路径名

    public ImageCacheSD() {
    }


    @Override
    public Bitmap get(String url) {
        return BitmapFactory.decodeFile(cacheDir + "/text0.jpg");
    }

    @Override
    public void put(String url, Bitmap bitmap) {
        Log.e("text123", "put: ");
        FileOutputStream fileOutputStream = null;
        try {
            File file = new File(cacheDir);
            if(!file.exists()) {
                file.mkdirs();//新建目录
            }
            String newPath = "text0" + ".jpg"; //文件名
            File files = new File(file,newPath);
            fileOutputStream = new FileOutputStream(files);
            boolean compress = bitmap.compress(Bitmap.CompressFormat.PNG, 80, fileOutputStream);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            Log.e("text123", "put: e = " + e.toString());
        } finally {
            if (fileOutputStream != null) {
                try {
                    fileOutputStream.close();
                } catch (IOException e) {
                    Log.e("text123", "put: e = " + e.toString());
                    e.printStackTrace();
                }
            }
        }
    }
}
