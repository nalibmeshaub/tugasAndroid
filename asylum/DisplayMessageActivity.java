package insane.asylum;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class DisplayMessageActivity<message> extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_message);

        Intent intent = getIntent();
        String meme = intent.getStringExtra(MainActivity.extraMessage);

        TextView textView = findViewById(R.id.fin);
        textView.setText(meme);
    }
}