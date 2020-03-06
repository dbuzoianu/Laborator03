package lab03.eim.system.cs.pub.ro;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import org.w3c.dom.Text;


public class MainActivity extends AppCompatActivity {

    class NumberListener implements View.OnClickListener {

        @Override
        public void onClick(View v) {

            final EditText text=(EditText)findViewById(R.id.editText);
            final Button b = (Button) v;

            text.setText(text.getText().toString() + b.getText());
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final EditText text=(EditText)findViewById(R.id.editText);
        final Button b1 = (Button) findViewById(R.id.button5);
        final Button b2 = (Button) findViewById(R.id.button6);
        final Button b3 = (Button) findViewById(R.id.button7);
        final Button b4 = (Button) findViewById(R.id.button8);
        final Button b5 = (Button) findViewById(R.id.button9);
        final Button b6 = (Button) findViewById(R.id.button10);
        final Button bcall = (Button) findViewById(R.id.button11);
        final Button bcancel = (Button) findViewById(R.id.button11);

        b1.setOnClickListener(new NumberListener());
        b2.setOnClickListener(new NumberListener());
        b3.setOnClickListener(new NumberListener());
        b4.setOnClickListener(new NumberListener());
        b5.setOnClickListener(new NumberListener());
        b6.setOnClickListener(new NumberListener());

        bcall.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v) {
                if (ContextCompat.checkSelfPermission(MainActivity.this, Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
                    ActivityCompat.requestPermissions(
                            MainActivity.this,
                            new String[]{Manifest.permission.CALL_PHONE},
                            1);
                } else {
                    Intent intent = new Intent(Intent.ACTION_CALL);
                    intent.setData(Uri.parse("tel:" + text.getText().toString()));
                    startActivity(intent);
                }
            }
        });

        bcancel.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                finish();
            }
        });
    }
}


