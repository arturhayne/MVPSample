package br.gov.ba.prodeb.myapplicationtbs.Main;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import br.gov.ba.prodeb.myapplicationtbs.R;

public class MainActivity extends AppCompatActivity implements MainContract.View{

    private EditText campoA;
    private EditText campoB;
    private TextView resultado;
    private Button button;
    private MainContract.UserActionsListener userActionsListener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        userActionsListener = new MainPresenter(this,this);

        userActionsListener.conexao();

        init();

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                userActionsListener.clickSoma(Integer.parseInt(campoA.getText().toString()),
                        Integer.parseInt(campoB.getText().toString()));
            }
        });

    }

    private void init(){
        campoA = findViewById(R.id.campo_a);
        campoB = findViewById(R.id.campo_b);
        button = findViewById(R.id.button);
        resultado = findViewById(R.id.result);
        userActionsListener.conexao();
    }

    @Override
    public void mostrarResultado(int result) {
            resultado.setText(String.valueOf(result));
    }
}
