package com.example.withm.ui.xzqfragment.activity;

import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.PopupWindow;
import android.widget.Toast;

import com.example.withm.R;
import com.umeng.socialize.ShareAction;
import com.umeng.socialize.UMAuthListener;
import com.umeng.socialize.UMShareListener;
import com.umeng.socialize.bean.SHARE_MEDIA;
import com.umeng.socialize.media.UMImage;

import java.util.Map;

//  ak:  5ceb3e324ca3576935000ebb
public class PhotoActivity extends AppCompatActivity {

    private ImageView img;
    private ImageView share;
    private ImageView close;
    private View weibo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_photo);
        initView();
    }

    private void initView() {
        img = (ImageView) findViewById(R.id.img);
        share = (ImageView) findViewById(R.id.share);
        img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        share.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                popupData();
            }

        });
    }

    private void popupData() {
        final PopupWindow pop = new PopupWindow();
        View inflate = LayoutInflater.from(this).inflate(R.layout.popitem, null);
        close = inflate.findViewById(R.id.close);
        weibo = inflate.findViewById(R.id.weibo);
        pop.setContentView(inflate);
        pop.setHeight(ViewGroup.LayoutParams.WRAP_CONTENT);
        pop.setWidth(ViewGroup.LayoutParams.MATCH_PARENT);
        pop.setBackgroundDrawable(new ColorDrawable());
        pop.setOutsideTouchable(true);
        pop.showAtLocation(img, Gravity.BOTTOM, 0, 0);
        close.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pop.dismiss();
            }
        });
        weibo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                share(SHARE_MEDIA.SINA);
            }
        });
        // getLayoutInflater().inflate(R.layout.popitem, null);
//        pop.setHeight();
//        inflate.findViewById()findViewById
    }
//    private void login(SHARE_MEDIA type) {
//        UMShareAPI umShareAPI = UMShareAPI.get(this);
//        umShareAPI.getPlatformInfo(this, type, umAuthListener);
//    }
    UMAuthListener umAuthListener = new UMAuthListener() {
        /**
         * @desc 授权开始的回调
         * @param platform 平台名称
         */
        @Override
        public void onStart(SHARE_MEDIA platform) {

        }

        /**
         * @desc 授权成功的回调
         * @param platform 平台名称
         * @param action 行为序号，开发者用不上
         * @param data 用户资料返回
         */
        @Override
        public void onComplete(SHARE_MEDIA platform, int action, Map<String, String> data) {
            for (Map.Entry<String, String> entry:data.entrySet()){
                String key = entry.getKey();
                String value = entry.getValue();
                Log.d("tag", "key: "+key+",value:"+value);

            }
            Toast.makeText(PhotoActivity.this, "成功了", Toast.LENGTH_LONG).show();

        }

        /**
         * @desc 授权失败的回调
         * @param platform 平台名称
         * @param action 行为序号，开发者用不上
         * @param t 错误原因
         */
        @Override
        public void onError(SHARE_MEDIA platform, int action, Throwable t) {

            Toast.makeText(PhotoActivity.this, "失败：" + t.getMessage(),                                     Toast.LENGTH_LONG).show();
        }

        /**
         * @desc 授权取消的回调
         * @param platform 平台名称
         * @param action 行为序号，开发者用不上
         */
        @Override
        public void onCancel(SHARE_MEDIA platform, int action) {
            Toast.makeText(PhotoActivity.this, "取消了", Toast.LENGTH_LONG).show();
        }
    };
    public void share(SHARE_MEDIA type) {
        UMImage thumb = new UMImage(this, "https://ws1.sinaimg.cn/large/0065oQSqly1g0ajj4h6ndj30sg11xdmj.jpg");
        thumb.compressStyle = UMImage.CompressStyle.SCALE;//大小压缩，默认为大小压缩，
        new ShareAction(PhotoActivity.this)
                .setPlatform(type)//传入平台
                .withText("hello")//分享内容
                .withMedia(thumb)//图片
                .setCallback(umShareListener)//回调监听器
                .share();
    }

    /**
     * 带面板分享
     */
    private void shareBorad() {
        UMImage thumb = new UMImage(this, "https://ws1.sinaimg.cn/large/0065oQSqly1g0ajj4h6ndj30sg11xdmj.jpg");
        thumb.compressStyle = UMImage.CompressStyle.SCALE;//大小压缩，默认为大小压缩，

        new ShareAction(PhotoActivity.this).withText("hello")
                .withMedia(thumb)
                .setDisplayList(SHARE_MEDIA.SINA, SHARE_MEDIA.QQ, SHARE_MEDIA.WEIXIN)
                .setCallback(umShareListener).open();
    }
    private UMShareListener umShareListener = new UMShareListener() {
        /**
         * @descrption 分享开始的回调
         * @param platform 平台类型
         */
        @Override
        public void onStart(SHARE_MEDIA platform) {

        }

        /**
         * @descrption 分享成功的回调
         * @param platform 平台类型
         */
        @Override
        public void onResult(SHARE_MEDIA platform) {
            Toast.makeText(PhotoActivity.this, "成功了", Toast.LENGTH_LONG).show();
        }

        /**
         * @descrption 分享失败的回调
         * @param platform 平台类型
         * @param t 错误原因
         */
        @Override
        public void onError(SHARE_MEDIA platform, Throwable t) {
            Toast.makeText(PhotoActivity.this, "失败" + t.getMessage(), Toast.LENGTH_LONG).show();
        }

        /**
         * @descrption 分享取消的回调
         * @param platform 平台类型
         */
        @Override
        public void onCancel(SHARE_MEDIA platform) {
            Toast.makeText(PhotoActivity.this, "取消了", Toast.LENGTH_LONG).show();

        }
    };
}
