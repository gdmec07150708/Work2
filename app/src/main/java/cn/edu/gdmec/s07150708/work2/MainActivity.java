package cn.edu.gdmec.s07150708.work2;

import android.os.PersistableBundle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView tv1;
    private TextView tv2;
    private int iNum1,iNum2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout);
        tv1=(TextView) findViewById(R.id.textView);
        tv2=(TextView) findViewById(R.id.textView2);
        tv1.setText("你好，onCreate修改");
        iNum1=iNum2=0;
    }

    @Override
    protected void onResume() {
        super.onResume();
        tv1.setText("onResume");
        tv2.setText("onResume");
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        iNum1++;
        iNum2++;
        outState.putString("tv1","tv1保存时的值"+iNum1);
        outState.putString("tv2", String.valueOf(iNum2));
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        tv1.setText(savedInstanceState.getString("tv1"));
        tv2.setText(savedInstanceState.getString("tv2"));
        iNum2=Integer.parseInt(savedInstanceState.getString("tv2"));
    }
}
