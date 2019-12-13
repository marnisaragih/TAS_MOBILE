package com.example.tas_mobile;

import android.os.Bundle;
import android.text.Editable;
import android.text.Html;
import android.text.TextWatcher;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

public class MainActivity extends AppCompatActivity {

    Toolbar toolbar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        toolbar= (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
    }
    
    public boolean harusdiisi(EditText editText, EditText txtNama) {
        String text = editText.getText().toString().trim();
        editText.setError(null);

        // length 0 means there is no text
        if (text.length() == 0) {
            editText.setError(Html
                    .fromHtml("<font color='red'>Input tidak boleh kosong</font>"));
            return false;
        }

        return true;
         txtNama = (EditText) findViewById(R.id.txtName);
        txtNama = (EditText) findViewById(R.id.txtnidn);
        txtNama = (EditText) findViewById(R.id.txtemail);
        txtNama = (EditText) findViewById(R.id.txtalamat);
        txtNama = (EditText) findViewById(R.id.txtlink);
        // TextWatcher would let us check validation error on the fly
        txtNama.addTextChangedListener(new TextWatcher() {
            public void afterTextChanged(Editable s) {
                boolean harusdiisi = harusdiisi(txtNama);
            }

            public void beforeTextChanged(CharSequence s, int start, int count,
                                          int after) {
            }

            public void onTextChanged(CharSequence s, int start, int before,
                                      int count) {
            }
        });
    }
}
