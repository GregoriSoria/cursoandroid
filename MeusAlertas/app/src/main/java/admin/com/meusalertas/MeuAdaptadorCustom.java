package admin.com.meusalertas;

import android.content.Context;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by admin on 23/03/17.
 */

class MeuAdaptadorCustom extends ArrayAdapter{
    public MeuAdaptadorCustom(@NonNull Context context, @LayoutRes int resource) {
        super(context, resource);
    }

    @Override
    public void add(@Nullable Object object) {
        super.add(object);
    }

    @Override
    public int getCount() {
        return super.getCount();
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        View row;

        row = convertView;
        DataHandler handler;

        if (convertView == null) {
            LayoutInflater inflater = (LayoutInflater) this.getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            row = inflater.inflate(R.layout.minha_celula, parent, false);
            handler = new DataHandler();
            handler.imagemIcone         = (ImageView)row.findViewById(R.id.imagemIcone);
            handler.nomePersonagem      = (TextView)row.findViewById(R.id.textoNome);
            handler.descricaoPersonagem = (TextView)row.findViewById(R.id.textoDescricao);
            row.setTag(handler);
        } else {
            handler = (DataHandler)row.getTag();
        }

        MeuDataProvider dataProvider;
        dataProvider = (MeuDataProvider) this.getItem(position);
        handler.imagemIcone.setImageResource(dataProvider.getIcone());
        handler.nomePersonagem.setText(dataProvider.getNome());
        handler.descricaoPersonagem.setText(dataProvider.getDescricao());

        return row;

    }

    private class DataHandler {

        ImageView   imagemIcone;
        TextView    nomePersonagem;
        TextView    descricaoPersonagem;

    }
}
