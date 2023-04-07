package pl.weatherLive.geolocation;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import pl.weatherLive.geolocation.model.Coordinates;
import pl.weatherLive.geolocation.model.GeocodeResponse;
import pl.weatherLive.geolocation.model.Geometry;
import pl.weatherLive.geolocation.model.Result;


@Data
@Service
public class GeolocationService {

    private final RestTemplate restTemplate = new RestTemplate();
    @Value("${apiKey}")
    private String apiKey;

    String cityName = "Warszawa";
    String countryName = "Poland";

    public Coordinates getCoordinates(){


        String url = "https://api.opencagedata.com/geocode/v1/json?q="+ cityName + "%2C+" + countryName + "&key=" + apiKey + "&no_annotations=1";

        ResponseEntity<GeocodeResponse> responseEntity = restTemplate.exchange(url, HttpMethod.GET, HttpEntity.EMPTY,GeocodeResponse.class);

        GeocodeResponse response = responseEntity.getBody();
        if (response != null && response.getResults() != null && response.getResults().size() > 0) {
            Result result = response.getResults().get(0);
            Geometry geometry = result.getGeometry();

            return new Coordinates(geometry.getLat(), geometry.getLng());
        }
        return null;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public void setCountryName(String countryName) {
        this.countryName = countryName;
    }

}



