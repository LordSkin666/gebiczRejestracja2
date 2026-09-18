package com.example.gebiczrejestracja;

import android.os.Bundle;
import android.util.Patterns;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    EditText imie;
    EditText nazwisko;
    EditText email;
    EditText haslo;
    Button przycisk;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imie = findViewById(R.id.imie);
        nazwisko = findViewById(R.id.nazwisko);
        email = findViewById(R.id.email);
        haslo = findViewById(R.id.haslo);
        przycisk = findViewById(R.id.przycisk);

        przycisk.setOnClickListener(v -> {

            String imieTekst = imie.getText().toString().trim();
            String nazwiskoTekst = nazwisko.getText().toString().trim();
            String emailTekst = email.getText().toString().trim();
            String hasloTekst = haslo.getText().toString().trim();

            if (imieTekst.isEmpty() || nazwiskoTekst.isEmpty() ||
                    emailTekst.isEmpty() || hasloTekst.isEmpty()) {

                Toast.makeText(this,
                        "Uzupełnij wszystkie pola",
                        Toast.LENGTH_SHORT).show();

                return;
            }
            if (!Patterns.EMAIL_ADDRESS.matcher(emailTekst).matches()) {

                Toast.makeText(this,
                        "Podaj poprawny adres email",
                        Toast.LENGTH_SHORT).show();

                return;
            }
            boolean duzaLitera = false;
            boolean malaLitera = false;
            boolean znakSpecjalny = false;

            for (int i = 0; i < hasloTekst.length(); i++) {

                char znak = hasloTekst.charAt(i);

                if (Character.isUpperCase(znak)) {
                    duzaLitera = true;
                }
                if (Character.isLowerCase(znak)) {
                    malaLitera = true;
                }
                if (!Character.isLetterOrDigit(znak)) {
                    znakSpecjalny = true;
                }
            }
            if (hasloTekst.length() < 8) {
                Toast.makeText(this,
                        "Hasło musi mieć co najmniej 8 znaków",
                        Toast.LENGTH_SHORT).show();
                return;
            }
            if (!duzaLitera) {
                Toast.makeText(this,
                        "Hasło musi zawierać dużą literę",
                        Toast.LENGTH_SHORT).show();
                return;
            }
            if (!malaLitera) {
                Toast.makeText(this,
                        "Hasło musi zawierać małą literę",
                        Toast.LENGTH_SHORT).show();
                return;
            }
            if (!znakSpecjalny) {
                Toast.makeText(this,
                        "Hasło musi zawierać znak specjalny",
                        Toast.LENGTH_SHORT).show();
                return;
            }
            Toast.makeText(this,
                    "Dane są poprawne",
                    Toast.LENGTH_SHORT).show();
        });
    }
}