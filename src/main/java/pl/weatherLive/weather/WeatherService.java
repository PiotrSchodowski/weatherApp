package pl.weatherLive.weather;

import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import pl.weatherLive.geolocation.GeolocationService;
import pl.weatherLive.geolocation.model.Coordinates;
import pl.weatherLive.weather.model.Root;

@Service
public class WeatherService {

    RestTemplate restTemplate = new RestTemplate();
    GeolocationService geolocationService;

    @Autowired
    public WeatherService(GeolocationService geolocationService){
        this.geolocationService = geolocationService;
    }

    public Root getWeather(){

        Coordinates coordinates = geolocationService.getCoordinates();
        double latitude = coordinates.getLatitude();
        double longitude = coordinates.getLongitude();

        ResponseEntity<String> exchange = restTemplate.exchange("https://api.open-meteo.com/v1/forecast?latitude="
                        + latitude + "&longitude="
                        + longitude + "&daily=temperature_2m_max," +
                        "temperature_2m_min," +
                        "precipitation_probability_mean," +
                        "precipitation_sum," +
                        "windspeed_10m_max&timezone=auto",
                HttpMethod.GET, HttpEntity.EMPTY,String.class);
        String apiResponse = exchange.getBody();
        return new Gson().fromJson(apiResponse, Root.class);
    }
}
