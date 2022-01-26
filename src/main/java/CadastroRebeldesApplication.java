import br.com.letscode.cadastrorebeldes.CadastroRebeldes;

import java.io.FileNotFoundException;
import java.io.UnsupportedEncodingException;

public class CadastroRebeldesApplication {

    public static void main(String[] args) {
        CadastroRebeldes cadastroRebeldes = new CadastroRebeldes();
        try {
            cadastroRebeldes.cadastroRebelde();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
    }

}
