package com.example.tas_mobile;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class mahasiswa extends AppCompatActivity {

    private EditText nameField;
    private EditText NimField;
    private EditText alamatField;
    private EditText EmailField;
    private Button simpan;
    private  Button edit;
    private  Button Delete;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mahasiswa);

    nameField = findViewById(R.id.editTextnama);
        NimField = findViewById(R.id.editTextid);
    alamatField = findViewById(R.id.editTextAlamat);
    EmailField = findViewById(R.id.editTextEmail);
    edit = findViewById(R.id.btnEdit);
    Delete = findViewById(R.id.btnDelete);
    simpan = findViewById(R.id.Simpan);
}

    public void setSimpan(View v) {
        Intent intent = new Intent(this, MainActivity.class);
        intent.putExtra("Name", nameField.getText().toString());
        intent.putExtra("NIM", NimField.getText().toString());
        intent.putExtra("Alamat", alamatField.getText().toString());
        intent.putExtra("Email", EmailField.getText().toString());

        startActivity(intent);
    }

    private void validateForm() {
        boolean isNameNull = nameField.getText().toString().isEmpty();
        boolean isNidnNull = NimField.getText().toString().isEmpty();
        boolean isAlamatNull = alamatField.getText().toString().isEmpty();
        boolean isEmailNull = EmailField.getText().toString().isEmpty();

        if (nameField.getText().toString().length() == 0){
            nameField.setError("Harap isi nama Anda");
        }
        if (NimField.getText().toString().length() == 0){
            NimField.setError("Harap isi Nim Anda");
        }
        if (alamatField.getText().toString().length() == 0){
            alamatField.setError("Harap isi Alamat Anda");
        }
        if (EmailField.getText().toString().length() == 0){
            EmailField.setError("Harap isi Email Anda");
        }

        else {
            Toast.makeText(mahasiswa.this, "Data berhasil diinput", Toast.LENGTH_SHORT).show();

//        if (!(isNameNull || isNidnNull || isAlamatNull || isAlamatNull) && isEmailNull) {
//            simpan.setBackground(getDrawable(R.drawable.red_simpan));
//            simpan.setEnabled(true);
//            simpan.setClickable(true);
//        } else {
//            simpan.setEnabled(false);
//            simpan.setClickable(false);
//        }
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

}
