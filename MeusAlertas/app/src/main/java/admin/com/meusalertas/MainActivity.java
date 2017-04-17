package admin.com.meusalertas;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    ListView minhaLista;

    private String[] listaDeNomes   = {"Homer", "Bart", "Lisa", "Marge", "Maggie", "Sr. Burns", "Moe", "Smithers", "Barney", "Ajudante do Papai Noel"};
    private String[] listaDescricao = {
            "desc Homer",
            "desc Bart",
            "desc Lisa",
            "desc Marge",
            "desc Maggie",
            "desc Sr. Burns",
            "desc Moe",
            "desc Smithers",
            "desc Barney",
            "desc Ajudante do Papai Noel"};

    int[] listaIcones = {
            R.drawable.icone128,
            R.drawable.icone256,
            R.drawable.icontweet,
            R.drawable.passaro1,
            R.drawable.passaro2,
            R.drawable.passaro3,
            R.drawable.passaro4,
            R.drawable.passaro5,
            R.drawable.passaro6,
            R.drawable.peninha
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        minhaLista = (ListView) findViewById(R.id.lista);
        minhaLista.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                TextView item = (TextView) view.findViewById(R.id.textoDescricao);
                String descricao = item.getText().toString();

                Toast.makeText(getApplicationContext(), descricao, Toast.LENGTH_SHORT).show();
            }
        });

        MeuAdaptadorCustom adaptador;

        int i = 0;

        adaptador = new MeuAdaptadorCustom(getApplicationContext(), R.layout.minha_celula);

        for (String nome:listaDeNomes) {
            MeuDataProvider dataProvider = new MeuDataProvider(listaIcones[i], nome, listaDescricao[i]);
            adaptador.add(dataProvider);
            i++;
        }

        minhaLista.setAdapter(adaptador);

    }
}
