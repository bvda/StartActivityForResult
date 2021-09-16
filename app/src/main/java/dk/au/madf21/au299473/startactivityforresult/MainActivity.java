package dk.au.madf21.au299473.startactivityforresult;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import androidx.activity.ComponentActivity;
import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;

public class MainActivity extends ComponentActivity {

    ActivityResultLauncher<Intent> mStartActivity = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), new ActivityResultCallback<ActivityResult>() {
        @Override
        public void onActivityResult(ActivityResult result) {
            if(result.getResultCode() == Activity.RESULT_OK) {
                ((TextView)findViewById(R.id.textView)).setText(result.getData().getStringExtra("data"));
            } else if(result.getResultCode() == Activity.RESULT_CANCELED) {
                Log.d("MainActivity", "OtherActivity: Canceled");
            }
        }
    });

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewById(R.id.goToOtherActivityButton).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mStartActivity.launch(new Intent(MainActivity.this, OtherActivity.class));
            }
        });
    }
}