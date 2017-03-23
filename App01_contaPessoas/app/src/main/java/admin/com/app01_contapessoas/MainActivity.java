package admin.com.app01_contapessoas;

import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    Context context;
    CoordinatorLayout coordinatorLayout;
    int numeroHomem     = 0;
    int numeroMulher    = 0;
    int numeroPessoas   = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        context = this;
        coordinatorLayout = (CoordinatorLayout) findViewById(R.id.root);

        final TextView campoTexto = (TextView) findViewById(R.id.textoPessoas);

        final Button botaoHomem  = (Button) findViewById(R.id.botaoHomem);
        final Button botaoMulher = (Button) findViewById(R.id.botaoMulher);
        Button botaoReset  = (Button) findViewById(R.id.botaoReset);

        botaoHomem.setOnClickListener(new Button.OnClickListener() {

            @Override
            public void onClick(View v) {
                numeroHomem++;
                numeroPessoas++;

                String mensagem = Integer.toString(numeroPessoas);
                campoTexto.setText("Total: " + mensagem + " pessoas");
                botaoHomem.setText(Integer.toString(numeroHomem));
            }
        });

        botaoMulher.setOnClickListener(new Button.OnClickListener() {

            @Override
            public void onClick(View v) {
                numeroMulher++;
                numeroPessoas++;

                String mensagem = Integer.toString(numeroPessoas);
                campoTexto.setText("Total: " + mensagem + " pessoas");
                botaoMulher.setText(Integer.toString(numeroMulher));
            }
        });

        botaoReset.setOnClickListener(new Button.OnClickListener() {


            @Override
            public void onClick(View v) {

                AlertDialog.Builder dialog = new AlertDialog.Builder(context);

                dialog.setTitle( "Hello" )
                        .setIcon(android.R.drawable.ic_dialog_alert)
                        .setTitle("Alerta")
                        .setMessage("Quer realmente resetar?")
                        .setNegativeButton("NÃO", new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialoginterface, int i) {
                                dialoginterface.cancel();
                            }})
                        .setPositiveButton("SIM", new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialoginterface, int i) {
                                numeroHomem     = 0;
                                numeroMulher    = 0;
                                numeroPessoas   = 0;

                                String mensagem = Integer.toString(numeroPessoas);
                                campoTexto.setText("Total: " + mensagem + " pessoas");
                                botaoHomem.setText(Integer.toString(numeroHomem));
                                botaoMulher.setText(Integer.toString(numeroMulher));

                                Snackbar.make(coordinatorLayout, "Os contadores foram resetados", Snackbar.LENGTH_LONG).show();
                            }
                        }).show();
            }


        });
    }
}
