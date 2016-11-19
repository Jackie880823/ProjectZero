/*
 *
 *             $$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$
 *             $                                                   $
 *             $                       _oo0oo_                     $
 *             $                      o8888888o                    $
 *             $                      88" . "88                    $
 *             $                      (| -_- |)                    $
 *             $                      0\  =  /0                    $
 *             $                    ___/`-_-'\___                  $
 *             $                  .' \\|     |$ '.                 $
 *             $                 / \\|||  :  |||$ \                $
 *             $                / _||||| -:- |||||- \              $
 *             $               |   | \\\  -  $/ |   |              $
 *             $               | \_|  ''\- -/''  |_/ |             $
 *             $               \  .-\__  '-'  ___/-. /             $
 *             $             ___'. .'  /-_._-\  `. .'___           $
 *             $          ."" '<  `.___\_<|>_/___.' >' "".         $
 *             $         | | :  `- \`.;`\ _ /`;.`/ - ` : | |       $
 *             $         \  \ `_.   \_ __\ /__ _/   .-` /  /       $
 *             $     =====`-.____`.___ \_____/___.-`___.-'=====    $
 *             $                       `=-_-='                     $
 *             $     ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~   $
 *             $                                                   $
 *             $          Buddha Bless         Never Bug           $
 *             $                                                   $
 *             $$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$
 */

package com.jackie.projectzero;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

/**
 * Uda City中Google: Android开发者纳米学位 - 第 1 学期
 * 项目0：我的应用作品集
 * 点击按钮并弹出相应的{@link Toast}提示
 * <p>
 * Created 16/11/18.
 *
 * @author Jackie
 * @version 1.0
 */
public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Toast mToast;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // 设计按钮监听
        // 热门电影
        findViewById(R.id.btn_move).setOnClickListener(this);
        // 股票雄鹰
        findViewById(R.id.btn_stock).setOnClickListener(this);
        // xyz阅读器
        findViewById(R.id.btn_reader).setOnClickListener(this);
        // 最新闻
        findViewById(R.id.btn_news).setOnClickListener(this);
        // 毕业设计
        findViewById(R.id.btn_graduation).setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        String message = getString(R.string.txt_toast_message);
        switch (view.getId()) {
            case R.id.btn_move:
            case R.id.btn_stock:
            case R.id.btn_reader:
            case R.id.btn_news:
            case R.id.btn_graduation:
                message = String.format(message, ((Button) view).getText());
                break;
            default:
                // 五个按钮以外的控件点击不响应
                return;
        }

        // 停止之前运行的 toast
        if (mToast != null) {
            // 当按下按钮toast就会出现在屏幕上，但是立即按下另外一个按钮，这时就需要延迟好一段时间才能看到第二个
            // toast. 可以试着考虑在显示一个新的toast时，取消依旧还存在的toast。这样可以减少延迟时间并且可以使得
            // app的用户体验更好，可以即时收到反馈toast
            mToast.cancel();
        }

        mToast = Toast.makeText(this, message, Toast.LENGTH_LONG);
        mToast.show();
    }
}
