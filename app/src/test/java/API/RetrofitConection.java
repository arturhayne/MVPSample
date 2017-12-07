package API;

import android.content.Context;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by amaral on 05/07/17.
 */

public class RetrofitConection {
    private BaseAPI baseAPI;
    private Context context;
    private Gson gson;
    private Retrofit retrofit;
    private int nivel;
    public static final int SEMNIVEL = -1, NIVEL0 = 0, NIVEL1 = 1;
    private static RetrofitConection instance;


    public RetrofitConection(Context c,int nivel){

        this.nivel = nivel;
        this.context = c;

        gson = new GsonBuilder().setLenient().create();

        //HttpLoggingInterceptor logging = new HttpLoggingInterceptor();
        //logging.setLevel(HttpLoggingInterceptor.Level.BODY);

        /*File httpCacheDirectory = new File(context.getCacheDir(), "responses");
        int cacheSize = 10 * 1024 * 1024; // 10 MB
        Cache cache = new Cache(httpCacheDirectory, cacheSize);*/

//        OkHttpClient client = new OkHttpClient.Builder()
//                //.sslSocketFactory(getSSLConfig(context))
//                //.cache(cache)
//                .addInterceptor(getInterceptorAuthorization(context,nivel))
//                .build();


        retrofit = new Retrofit.Builder().baseUrl("https://c360dmapigw.ba.gov.br:8443")
                //.client(client)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();

        baseAPI = retrofit.create(BaseAPI.class);
    }

    public static RetrofitConection getInstance(Context c, int nivel){

        if (instance == null || instance.getNivel() != nivel || nivel == SEMNIVEL || nivel == NIVEL0) {
            instance = new RetrofitConection(c,nivel);
        }

        return instance;

    }

    public int getNivel() {
        return nivel;
    }

    public BaseAPI getBaseAPI() {
        
        return baseAPI;

    }

    public void clear() {
        instance = null;
    }

   /* private static Interceptor getInterceptorAuthorization(final Context context, final int nivel){

        Interceptor interceptor = new Interceptor() {
            @Override
            public Response intercept(Interceptor.Chain chain) throws IOException {
                Request original = chain.request();

                Request request = original;

               // SessionOauth sessionOauthN1 = SheredUtil.getTokenSessioN1(context);

               // SessionOauth sessionOauthN0 = SheredUtil.getTokenSessioN0(context);

                boolean isValidN1 = SessionControl.getInstance(context,NIVEL1).verificarValidadeToken();

                if (nivel == SEMNIVEL){

                    return chain.proceed(request);

                }

                if (nivel == NIVEL0 && (sessionOauthN1.getAccess_token().equals("") || !isValidN1)) {

                    if (sessionOauthN0.getAccess_token() != null ) {
                        Request.Builder requestBuilder = original.newBuilder()
                                .header("Authorization", sessionOauthN0.getAuthorization()); // <-- this is the important line

                        request = requestBuilder.build();
                    }

                }else {


                    if (sessionOauthN1.getAccess_token() != null ) {
                        Request.Builder requestBuilder = original.newBuilder()
                                .header("Authorization", sessionOauthN1.getAuthorization()); // <-- this is the important line

                        request = requestBuilder.build();
                    }

                }

                return chain.proceed(request);
            }
        };

        return interceptor;
    }*/
}
