package admin.com.meusalertas;

/**
 * Created by admin on 23/03/17.
 */

class MeuDataProvider {

    private int icone;
    private String nome;
    private String descricao;

    public MeuDataProvider(int icone, String nome, String descricao) {
        this.icone = icone;
        this.nome = nome;
        this.descricao = descricao;
    }

    public int getIcone() {
        return icone;
    }

    public String getNome() {
        return nome;
    }

    public String getDescricao() {
        return descricao;
    }
}
