package RetrofitClient;

import java.security.SecureRandom;
import java.security.cert.X509Certificate;

import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import okhttp3.OkHttpClient;
import Service.IEventService;
import Service.IOrderService;

public class RetrofitClient {
    public static final String BASE_URL = "http://localhost:8080";
    private static Retrofit retrofit;

    public static Retrofit getRetrofitInstance() {
        if (retrofit == null) {
            OkHttpClient httpClient = createOkHttpClient();
            retrofit = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .client(httpClient)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return retrofit;
    }

    private static OkHttpClient createOkHttpClient() {
        OkHttpClient.Builder httpClient = new OkHttpClient.Builder();
            try {
                final TrustManager[] trustAllCerts = new TrustManager[]{
                        new X509TrustManager() {
                            public void checkClientTrusted(X509Certificate[] chain, String authType) {
                            }

                            public void checkServerTrusted(X509Certificate[] chain, String authType) {
                            }

                            public X509Certificate[] getAcceptedIssuers() {
                                return new X509Certificate[0];
                            }
                        }
                };

                // Install the trust manager
                SSLContext sslContext = SSLContext.getInstance("TLS");
                sslContext.init(null, trustAllCerts, new SecureRandom());
                SSLSocketFactory sslSocketFactory = sslContext.getSocketFactory();
                httpClient.sslSocketFactory(sslSocketFactory, (X509TrustManager) trustAllCerts[0]);
                httpClient.hostnameVerifier((hostname, session) -> true);
            } catch (Exception e) {
                e.printStackTrace();
            }
            return httpClient.build();
        }


    public static IEventService getApiEventService(){
        return getRetrofitInstance().create(IEventService.class);
    }

    public static IOrderService getApiOrderService(){
        return getRetrofitInstance().create(IOrderService.class);
    }
    }


