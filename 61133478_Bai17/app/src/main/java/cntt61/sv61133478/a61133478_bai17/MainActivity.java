package cntt61.sv61133478.a61133478_bai17;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private ListView listView;
    private ArrayList<String> listData;
    private ArrayAdapter<String> adapter;
    private Context context;
    private Button button;
    private EditText editText;
    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        context = this;
        listView = (ListView) findViewById(R.id.lv);
        button = (Button) findViewById(R.id.btn);
        editText = (EditText) findViewById(R.id.edt);
        textView = (TextView) findViewById(R.id.txtselection);

        listData = new ArrayList<>();
        listData.add("Tèo");
        listData.add("Tý");
        listData.add("Bin");
        adapter = new ArrayAdapter<>(context, android.R.layout.simple_list_item_1, listData);
        listView.setAdapter(adapter);

        button.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick (View v)
            {
             String item = editText.getText().toString().trim();
                if(TextUtils.isEmpty(item))
                {
                    Toast.makeText(context, "Phải nhập dữ liệu", Toast.LENGTH_SHORT).show();
                    return;
                }
             listData.add(item);
             adapter.notifyDataSetChanged();
            }
        });

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                String value = (String) listView.getItemAtPosition(i);
                textView.setText("position: "+i+" ; value = "+ value);
            }
        });
    }
}