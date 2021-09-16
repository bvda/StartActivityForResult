package dk.au.madf21.au299473.startactivityforresult;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class OtherActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_other);

        ((TextView)findViewById(R.id.textView)).setText(getIntent().getStringExtra("data"));

        findViewById(R.id.goBackButton).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent result = new Intent();
                result.putExtra("data", "Data from OtherActivity");
                setResult(Activity.RESULT_OK, result);
                finish();
            }
        });
    }
}