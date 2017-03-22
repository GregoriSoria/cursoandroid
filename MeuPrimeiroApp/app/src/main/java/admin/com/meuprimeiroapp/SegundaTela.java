package admin.com.meuprimeiroapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class SegundaTela extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_segunda_tela);

        Intent intent = getIntent();
        String texto = intent.getStringExtra("variavel");

        TextView textoSegundaTela = (TextView) findViewById(R.id.textoSegundaTela);
        textoSegundaTela.setText(texto);
    }
}
