import br.com.letscode.cadastrorebeldes.controller.InteligenciaCentral;
import br.com.letscode.cadastrorebeldes.controller.OrdenacaoController;
import br.com.letscode.cadastrorebeldes.domain.Rebelde;
import br.com.letscode.cadastrorebeldes.view.RebeldesView;

import java.util.List;

public class CadastroRebeldesApplication {

    public static void main(String[] args) {

        RebeldesView rebeldesView = new RebeldesView();
        List<Rebelde> rebeldeList = rebeldesView.cadastroRebelde();

        OrdenacaoController ordenacaoController = new OrdenacaoController();
        String opcaoOrdenacao = ordenacaoController.tipoDeOrdenacao();
        List<Rebelde> listaOrdenada = ordenacaoController.executarOrdenacao(rebeldeList, opcaoOrdenacao);

        InteligenciaCentral ic = new InteligenciaCentral();
        ic.imprimirRebeldesAdmitidos(listaOrdenada);

    }

}
