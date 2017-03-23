package admin.com.meusalertas;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    ListView minhaLista;

    private String[] listaDeNomes = {"Homer", "Bart", "Lisa", "Marge", "Maggie", "Sr. Burns", "Moe", "Smithers", "Barney", "Ajudante do Papai Noel"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        minhaLista = (ListView) findViewById(R.id.lista);

        final ArrayAdapter<String> meuAdaptador = new ArrayAdapter<String>(
                getApplicationContext(),
                android.R.layout.simple_list_item_1,
                android.R.id.text1,
                listaDeNomes
        );

        minhaLista.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                String item = meuAdaptador.getItem(position);

                Toast.makeText(getApplicationContext(), item, Toast.LENGTH_SHORT).show();
            }
        });

        minhaLista.setAdapter(meuAdaptador);
    }
}
