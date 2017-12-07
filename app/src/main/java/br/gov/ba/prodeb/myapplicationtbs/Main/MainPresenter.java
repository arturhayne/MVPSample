package br.gov.ba.prodeb.myapplicationtbs.Main;

import android.content.Context;

/**
 * Created by artur.oliveira on 06/12/2017.
 */

public class MainPresenter implements MainContract.UserActionsListener{

    private Context context;
    private MainContract.View view;

    public MainPresenter(Context context, MainContract.View view) {
        this.context = context;
        this.view = view;
    }


    @Override
    public void clickSoma(int a, int b) {
            view.mostrarResultado(a+b);
    }

    @Override
    public void conexao() {

    }


}
