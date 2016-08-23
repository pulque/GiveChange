package com.lizheblogs.android.change;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import java.util.Map;

public class MainActivity extends AppCompatActivity {

    private android.widget.TextView yijiaoTV;
    private android.widget.TextView wujiaoTV;
    private android.widget.TextView yiyuanTV;
    private android.widget.TextView yiyuanzhiTV;
    private android.widget.TextView wuyuanTV;
    private android.widget.TextView shiyuanTV;
    private android.widget.TextView ershiyuanTV;
    private android.widget.TextView wushiyuanTV;

    private Map<DataDao.RMB, Integer> money;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initUI();
        initData();
    }

    private void initUI() {
        this.wushiyuanTV = (TextView) findViewById(R.id.wushiyuanTV);
        this.ershiyuanTV = (TextView) findViewById(R.id.ershiyuanTV);
        this.shiyuanTV = (TextView) findViewById(R.id.shiyuanTV);
        this.wuyuanTV = (TextView) findViewById(R.id.wuyuanTV);
        this.yiyuanzhiTV = (TextView) findViewById(R.id.yiyuanzhiTV);
        this.yiyuanTV = (TextView) findViewById(R.id.yiyuanTV);
        this.wujiaoTV = (TextView) findViewById(R.id.wujiaoTV);
        this.yijiaoTV = (TextView) findViewById(R.id.yijiaoTV);
    }

    private void initData() {
        money = DataDao.readAll(this);
        wushiyuanTV.setText(String.valueOf(money.get(DataDao.RMB.WU_SHI_YUAN)));
        ershiyuanTV.setText(String.valueOf(money.get(DataDao.RMB.ER_SHI_YUAN)));
        shiyuanTV.setText(String.valueOf(money.get(DataDao.RMB.SHI_YUAN)));
        wuyuanTV.setText(String.valueOf(money.get(DataDao.RMB.WU_YUAN)));
        yiyuanzhiTV.setText(String.valueOf(money.get(DataDao.RMB.YI_YUAN_ZHI)));
        yiyuanTV.setText(String.valueOf(money.get(DataDao.RMB.YI_YUAN)));
        wujiaoTV.setText(String.valueOf(money.get(DataDao.RMB.WU_JIAO)));
        yijiaoTV.setText(String.valueOf(money.get(DataDao.RMB.YI_JIAO)));
    }


    public void clickMoney(View view) {
        switch (view.getId()) {
            case R.id.wushiyuanIV:
            case R.id.wushiyuanTV:
                showChangeDialog(wushiyuanTV, DataDao.RMB.WU_SHI_YUAN);
                break;
            case R.id.ershiyuanIV:
            case R.id.ershiyuanTV:
                showChangeDialog(ershiyuanTV, DataDao.RMB.ER_SHI_YUAN);
                break;
            case R.id.shiyuanIV:
            case R.id.shiyuanTV:
                showChangeDialog(shiyuanTV, DataDao.RMB.SHI_YUAN);
                break;
            case R.id.wuyuanIV:
            case R.id.wuyuanTV:
                showChangeDialog(wuyuanTV, DataDao.RMB.WU_YUAN);
                break;
            case R.id.yiyuanzhiIV:
            case R.id.yiyuanzhiTV:
                showChangeDialog(yiyuanzhiTV, DataDao.RMB.YI_YUAN_ZHI);
                break;
            case R.id.yiyuanIV:
            case R.id.yiyuanTV:
                showChangeDialog(yiyuanTV, DataDao.RMB.YI_YUAN);
                break;
            case R.id.wujiaoIV:
            case R.id.wujiaoTV:
                showChangeDialog(wujiaoTV, DataDao.RMB.WU_JIAO);
                break;
            case R.id.yijiaoIV:
            case R.id.yijiaoTV:
                showChangeDialog(yijiaoTV, DataDao.RMB.YI_JIAO);
                break;

        }
    }

    private void showChangeDialog(final TextView textView, final DataDao.RMB tag) {
        CustomDialog mDialog = new CustomDialog(this, new CustomDialog.NumberCallBack() {

            @Override
            public void updateNumber(int num) {
                textView.setText(String.valueOf(num));
                money.put(tag, num);
            }
        });
        mDialog.show(tag, textView.getText().toString());
    }
}
