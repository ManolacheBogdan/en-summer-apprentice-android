package Service;

import androidx.annotation.Nullable;

import java.util.List;

import Entities.EventModel;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface IEventService {
    @GET("/api/events")
    Call<List<EventModel>> fetchAllEvents(@Query("locationId") @Nullable Integer locationId,
                                          @Query("eventTypeName") @Nullable String eventTypeName);
}
