package API;

import android.content.Context;

/**
 * Created by dev on 03/10/17.
 */

public class SessionControl {

    public static SessionControl instance;
    private Context context;
    private int nivel;

    public SessionControl(Context c, int nivel) {
        context = c;
        this.nivel = nivel;



    }

    public int getNivel() {
        return nivel;
    }

    public static SessionControl getInstance(Context c, int nivel){

        return instance  = new SessionControl(c,nivel);

    }

    public void verifySession(final SessionListern listern){



    }



    public interface SessionListern{
        void success();
        void error(int cod);
    }

}


