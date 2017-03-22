package admin.com.meuprimeiroapp;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends Activity {

    TextView text;
    Button botao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        text    = (TextView) findViewById(R.id.textView);
        botao   = (Button) findViewById(R.id.button);

        botao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                text.setText("Cliquei");
                Intent intent = new Intent(MainActivity.this, SegundaTela.class);
                intent.putExtra("variavel", text.getText());
                startActivity(intent);
            }
        });

    }
}
