package app.yjkm.com.day_00.image;

import java.io.Closeable;
import java.io.IOException;

/**
 * 接口隔离原则
 * fileOutputStream 实现了接口 Closeable
 * 此接口用于负责流的关闭
 */
public class CloseUtils {
    public static void CloseStream (Closeable closeable) {
        if (closeable == null) {
            return;
        }
        try {
            closeable.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
