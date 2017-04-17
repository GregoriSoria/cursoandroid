package admin.com.testandosharedpreferences;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {


    private Button botao;
    private TextView txtNome;
    private EditText edtNome;
    private EditText edtIdade;

    private static String MINHAS_PREFERENCIAS = "Minhas preferências";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        botao = (Button) findViewById(R.id.button);
        txtNome = (TextView) findViewById(R.id.txtNome);
        edtNome = (EditText) findViewById(R.id.edtNome);
        edtIdade = (EditText) findViewById(R.id.edtIdade);

        SharedPreferences sharedPreferences = getSharedPreferences(MINHAS_PREFERENCIAS, MODE_PRIVATE);

        if (sharedPreferences.contains("nome")) {
            String nomeUsuario = sharedPreferences.getString("nome", "");
            Integer idadeUsuario = sharedPreferences.getInt("idade", 0);

            txtNome.setText("nome: " + nomeUsuario + " idade: " + idadeUsuario);
        } else {
            txtNome.setText("Insira seus dados!");
        }


        botao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences sharedPreferences = getSharedPreferences(MINHAS_PREFERENCIAS, MODE_PRIVATE);
                SharedPreferences.Editor editor = sharedPreferences.edit();

                editor.putString("nome", edtNome.getText().toString());
                editor.putInt("idade", Integer.parseInt(edtIdade.getText().toString()));

                editor.commit();
            }
        });
    }
}
