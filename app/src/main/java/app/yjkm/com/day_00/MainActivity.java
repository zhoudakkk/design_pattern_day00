 package app.yjkm.com.day_00;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import app.yjkm.com.day_00.image.ImageCacheDouble;
import app.yjkm.com.day_00.image.ImageCacheSD;
import app.yjkm.com.day_00.image.ImageLoader;

 public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ImageView mMainIv = findViewById(R.id.main_iv);
//        ImageLoader loader = new ImageLoader(new ImageCacheDouble());
        ImageLoader loader = new ImageLoader(new ImageCacheSD());
        String str = "https://static.firefoxchina.cn/img/201904/8_5cc650135d39b0.jpg";
        loader.displayImage(str,mMainIv);
    }
}
