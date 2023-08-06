package Service;

import java.util.List;

import Entities.OrderModel;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface IOrderService {
    @GET("api/{userId}/orders")
    Call<List<OrderModel>> fetchAllOrdersOfUser(@Path("userId")long userId);
}
