package cn.edu.gdmec.android.spinner;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;

public class SpinnerTest extends AppCompatActivity {
    private static final String[] citys={"杭州","北京","成都","大连","深圳","南京"};
    private TextView text;
    private Spinner spinner;
    private ArrayAdapter<String> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate ( savedInstanceState );
        setContentView ( R.layout.activity_spinner_test );
        text=(TextView)findViewById(R.id.text);
        spinner=(Spinner)findViewById(R.id.spinner);
        //将可选内容与ArrayAdapter连接
        adapter=new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item,citys);
        //设置下拉列表风格
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        //将adapter添加到spinner中
        spinner.setAdapter(adapter);
        //添加Spinner事件监听
        spinner.setOnItemSelectedListener(new Spinner.OnItemSelectedListener()
        {
            @Override
            public void onItemSelected(AdapterView<?>arg0, View arg1, int arg2, long arg3){
                text.setText ( "你所在的城市是："+citys[arg2] );
                //设置显示当前选择的项
                arg0.setVisibility(View.VISIBLE);
            }
            @Override
            public void onNothingSelected(AdapterView<?> arg0){

            }
        });
    }
}
