package com.example.john.wordcounter;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import org.w3c.dom.Text;

import static com.example.john.wordcounter.R.id.count;

public class MainActivity extends AppCompatActivity {

    private EditText countEditText;
    private Button countButton;
    private WordCount wordCount;
    private TextView countText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        wordCount = new WordCount();
        countEditText = (EditText) findViewById(R.id.addText);
        countButton = (Button) findViewById(R.id.countButton);
        countText = (TextView) findViewById(count);
    }

    public void onCountButtonClicked(View button) {
        String text = countEditText.getText().toString();
        Log.d(getClass().toString(), text);
        countText.setText(wordCount.doItAll(text));
    }
}
