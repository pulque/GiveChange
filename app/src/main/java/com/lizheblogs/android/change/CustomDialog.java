package com.lizheblogs.android.change;

import android.app.AlertDialog;
import android.content.Context;
import android.text.Html;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Locale;

/**
 * CustomDialog
 * Created by Norman.Li on 8/8/2016.
 */
public class CustomDialog extends AlertDialog implements View.OnClickListener {

    private Context mContext;
    private NumberCallBack numberCallBack;
    private StringBuffer numBuffer;
    private TextView numberIV;


    public CustomDialog(Context mContext, NumberCallBack numberCallBack) {
        super(mContext);
        this.mContext = mContext;
        this.numberCallBack = numberCallBack;
    }

    public void show(DataDao.RMB rmb, String num) {
        this.numBuffer = new StringBuffer(num);
        LayoutInflater inflater = LayoutInflater.from(mContext);
        View convertView = inflater.inflate(R.layout.dialog_edit, null);

        TextView okIV = (TextView) convertView.findViewById(R.id.okIV);
        okIV.setOnClickListener(this);
        TextView number0IV = (TextView) convertView.findViewById(R.id.number0IV);
        number0IV.setOnClickListener(this);
        TextView cancelIV = (TextView) convertView.findViewById(R.id.cancelIV);
        cancelIV.setOnClickListener(this);
        TextView number9IV = (TextView) convertView.findViewById(R.id.number9IV);
        number9IV.setOnClickListener(this);
        TextView number8IV = (TextView) convertView.findViewById(R.id.number8IV);
        number8IV.setOnClickListener(this);
        TextView number7IV = (TextView) convertView.findViewById(R.id.number7IV);
        number7IV.setOnClickListener(this);
        TextView number6IV = (TextView) convertView.findViewById(R.id.number6IV);
        number6IV.setOnClickListener(this);
        TextView number5IV = (TextView) convertView.findViewById(R.id.number5IV);
        number5IV.setOnClickListener(this);
        TextView number4IV = (TextView) convertView.findViewById(R.id.number4IV);
        number4IV.setOnClickListener(this);
        TextView number3IV = (TextView) convertView.findViewById(R.id.number3IV);
        number3IV.setOnClickListener(this);
        TextView number2IV = (TextView) convertView.findViewById(R.id.number2IV);
        number2IV.setOnClickListener(this);
        TextView number1IV = (TextView) convertView.findViewById(R.id.number1IV);
        number1IV.setOnClickListener(this);
        TextView deleteTextIV = (TextView) convertView.findViewById(R.id.deleteTextIV);
        deleteTextIV.setOnClickListener(this);
        numberIV = (TextView) convertView.findViewById(R.id.numberIV);
        numberIV.setText(num);
        setTitle(rmb, convertView);

        setView(convertView);
        show();
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.okIV:
                numberCallBack.updateNumber(getNumInteger());
            case R.id.cancelIV:
                dismiss();
                break;
            case R.id.number0IV:
                enter("0");
                break;
            case R.id.number1IV:
                enter("1");
                break;
            case R.id.number2IV:
                enter("2");
                break;
            case R.id.number3IV:
                enter("3");
                break;
            case R.id.number4IV:
                enter("4");
                break;
            case R.id.number5IV:
                enter("5");
                break;
            case R.id.number6IV:
                enter("6");
                break;
            case R.id.number7IV:
                enter("7");
                break;
            case R.id.number8IV:
                enter("8");
                break;
            case R.id.number9IV:
                enter("9");
                break;
            case R.id.deleteTextIV:
                int size = numBuffer.length();
                if (size > 0) {
                    numBuffer.deleteCharAt(size - 1);
                    numberIV.setText(getNumString());
                }
                break;


        }
    }

    private void enter(String number) {
        numBuffer.append(number);
        numberIV.setText(getNumString());
    }

    private String getNumString() {
        return String.valueOf(getNumInteger());
    }

    private int getNumInteger() {
        int num = 0;
        String string = numBuffer.toString();
        if (!TextUtils.isEmpty(string)) {
            if (string.length() < 10) {
                try {
                    num = Integer.valueOf(string);
                } catch (NumberFormatException e) {
                    e.printStackTrace();
                }
            }
        }
        numBuffer.setLength(0);
        numBuffer.append(num);
        return num;
    }

    private void setTitle(DataDao.RMB rmb, View convertView) {
        TextView titleTextIV = (TextView) convertView.findViewById(R.id.titleTextIV);
        ImageView titleImageIV = (ImageView) convertView.findViewById(R.id.titleImageIV);
        String titleTemp = mContext.getString(R.string.title_enter_number);
        switch (rmb) {
            case YI_JIAO:
                titleImageIV.setImageResource(R.mipmap.yijiao);
                titleTextIV.setText(Html.fromHtml(String.format(Locale.getDefault(), titleTemp, mContext.getString(R.string.yijiao))));
                break;
            case WU_JIAO:
                titleImageIV.setImageResource(R.mipmap.wujiao);
                titleTextIV.setText(Html.fromHtml(String.format(Locale.getDefault(), titleTemp, mContext.getString(R.string.wujiao))));
                break;
            case YI_YUAN:
                titleImageIV.setImageResource(R.mipmap.yiyuan);
                titleTextIV.setText(Html.fromHtml(String.format(Locale.getDefault(), titleTemp, mContext.getString(R.string.yiyuan))));
                break;
            case YI_YUAN_ZHI:
                titleImageIV.setImageResource(R.mipmap.yiyuan_zhi);
                titleTextIV.setText(Html.fromHtml(String.format(Locale.getDefault(), titleTemp, mContext.getString(R.string.yiyuanzhibi))));
                break;
            case WU_YUAN:
                titleImageIV.setImageResource(R.mipmap.wuyuan);
                titleTextIV.setText(Html.fromHtml(String.format(Locale.getDefault(), titleTemp, mContext.getString(R.string.wuyuan))));
                break;
            case SHI_YUAN:
                titleImageIV.setImageResource(R.mipmap.shiyuan);
                titleTextIV.setText(Html.fromHtml(String.format(Locale.getDefault(), titleTemp, mContext.getString(R.string.shiyuan))));
                break;
            case ER_SHI_YUAN:
                titleImageIV.setImageResource(R.mipmap.ershiyuan);
                titleTextIV.setText(Html.fromHtml(String.format(Locale.getDefault(), titleTemp, mContext.getString(R.string.ershiyuan))));
                break;
            case WU_SHI_YUAN:
                titleImageIV.setImageResource(R.mipmap.wushiyuan);
                titleTextIV.setText(Html.fromHtml(String.format(Locale.getDefault(), titleTemp, mContext.getString(R.string.wushiyuan))));
                break;
            default:
                titleImageIV.setImageResource(R.mipmap.yijiao);
                titleTextIV.setText(Html.fromHtml(String.format(Locale.getDefault(), titleTemp, mContext.getString(R.string.yijiao))));
                break;
        }
    }

    public interface NumberCallBack {
        void updateNumber(int num);
    }

}
