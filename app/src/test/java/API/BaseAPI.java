package API;

import com.google.gson.JsonElement;

import java.util.Map;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Url;

/**
 * Created by amaral on 05/07/17.
 */

public interface BaseAPI {

    @GET
    Call<JsonElement> getGeneric(@Url String url);

    @FormUrlEncoded
    @POST
    Call<JsonElement> postGeneric(@Url String url, @FieldMap(encoded = true) Map<String, String> params);

    @FormUrlEncoded
    @POST("/auth/oauth/v2/token")
    Call<JsonElement> getTokenClient(@Field("client_id") String client_id,
                                     @Field("client_secret") String client_secret,
                                     @Field("grant_type") String grant_type,
                                     @Field("scope") String scope);




    /**
     * Exemplos
     *
     *  @GET("eventos")
        Call<BaseRequest> getEventosMeus(@Query("id_usuario") String id_usuario);

         @GET("eventos/{id_evento}")
         Call<BaseRequest> getEvento(@Path("id_evento") String id_evento);

         @FormUrlEncoded
         @POST("eventos_participar")
         Call<BaseRequest> participarEvento(@Field("id_usuario") String id_usuario);
     *
     * */
}

