package com.example.tas_mobile;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.Html;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.slidingpanelayout.widget.SlidingPaneLayout;

public class MainActivity extends AppCompatActivity {
        private EditText nameField;
        private EditText NidnField;
        private EditText alamatField;
        private EditText EmailField;
        private EditText foto;
        private EditText educationField;
        private Button simpan;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main);

            nameField = findViewById(R.id.txtName);
            NidnField = findViewById(R.id.txtnidn);
            alamatField = findViewById(R.id.txtalamat);
            EmailField = findViewById(R.id.txtemail);
            foto = findViewById(R.id.txtlink);
            simpan = findViewById(R.id.Simpan);
        }

        public void setSimpan(View v) {
            Intent intent = new Intent(this, MainActivity.class);
            intent.putExtra("Name", nameField.getText().toString());
            intent.putExtra("Nidn", NidnField.getText().toString());
            intent.putExtra("Alamat", alamatField.getText().toString());
            intent.putExtra("Email", EmailField.getText().toString());
            intent.putExtra("foto", foto.getText().toString());
            startActivity(intent);
        }

        private void validateForm() {
            boolean isNameNull = nameField.getText().toString().isEmpty();
            boolean isNidnNull = NidnField.getText().toString().isEmpty();
            boolean isAlamatNull = alamatField.getText().toString().isEmpty();
            boolean isEmailNull = EmailField.getText().toString().isEmpty();


            if (!(isNameNull || isNidnNull || isAlamatNull || isAlamatNull) && isEmailNull) {
                simpan.setBackground(getDrawable(R.drawable.red_simpan));
                simpan.setEnabled(true);
                simpan.setClickable(true);
            } else {
                simpan.setEnabled(false);
                simpan.setClickable(false);
            }
            nameField.addTextChangedListener(new TextWatcher() {
                @Override
                public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                }

                @Override
                public void onTextChanged(CharSequence s, int i, int i1, int i2) {
                    validateForm();
                }

                @Override
                public void afterTextChanged(Editable editable) {
                }
            });
        }
    }

    ;

//    Toolbar toolbar;
//
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main);
//
//        toolbar= (Toolbar) findViewById(R.id.toolbar);
//        setSupportActionBar(toolbar);
//    }
//
//    public boolean harusdiisi(EditText editText, EditText txtNama) {
//        String text = editText.getText().toString().trim();
//        editText.setError(null);
//
//        // length 0 means there is no text
//        if (text.length() == 0) {
//            editText.setError(Html
//                    .fromHtml("<font color='red'>Input tidak boleh kosong</font>"));
//            return false;
//        }
//
//        return true;
//         txtNama = (EditText) findViewById(R.id.txtName);
//        txtNama = (EditText) findViewById(R.id.txtnidn);
//        txtNama = (EditText) findViewById(R.id.txtemail);
//        txtNama = (EditText) findViewById(R.id.txtalamat);
//        txtNama = (EditText) findViewById(R.id.txtlink);
//        // TextWatcher would let us check validation error on the fly
//        txtNama.addTextChangedListener(new TextWatcher() {
//            public void afterTextChanged(Editable s) {
//                boolean harusdiisi = harusdiisi(txtNama);
//            }
//
//            public void beforeTextChanged(CharSequence s, int start, int count,
//                                          int after) {
//            }
//
//            public void onTextChanged(CharSequence s, int start, int before,
//                                      int count) {
//            }
//        });
//    }
//}
