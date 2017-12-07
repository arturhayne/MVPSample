package br.gov.ba.prodeb.myapplicationtbs.Main;

/**
 * Created by artur.oliveira on 06/12/2017.
 */

public interface MainContract {

    interface View{
            void mostrarResultado(int result);
    }

    interface UserActionsListener{
            void clickSoma(int a, int b);
            void conexao();
    }


}
