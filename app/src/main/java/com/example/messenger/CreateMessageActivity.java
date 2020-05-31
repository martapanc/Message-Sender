package com.example.messenger;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class CreateMessageActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_message);
    }

    public void onSendMessage(View view) {
        EditText editText = findViewById(R.id.message);
        String messageText = editText.getText().toString();

        Intent intent = new Intent(this, ReceiveMessageActivity.class);
        intent.putExtra("message", messageText);
        intent.putExtra("number", 17);
        startActivity(intent);
    }

    public void onSendMessageExternally(View view) {
        EditText editText = findViewById(R.id.message);
        String messageText = editText.getText().toString();

        Intent intent = new Intent(Intent.ACTION_SEND);
        intent.setType("text/plain");
        intent.putExtra(Intent.EXTRA_TEXT, messageText);
        intent.putExtra(Intent.EXTRA_SUBJECT, "Subject");
        startActivity(intent);
    }

    public void onSendMessageExternallyPreventDefault(View view) {
        EditText editText = findViewById(R.id.message);
        String messageText = editText.getText().toString();

        Intent intent = new Intent(Intent.ACTION_SEND);
        intent.setType("text/plain");
        intent.putExtra(Intent.EXTRA_TEXT, messageText);
        Intent chosenIntent = Intent.createChooser(intent, "Send message...");
        startActivity(chosenIntent);
    }
}