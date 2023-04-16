package pl.weatherLive.geolocation;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import pl.weatherLive.geolocation.model.Coordinates;
import pl.weatherLive.geolocation.model.GeocodeResponse;
import pl.weatherLive.geolocation.model.Geometry;
import pl.weatherLive.geolocation.model.Result;

import java.util.List;
import java.util.Optional;


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

        try {
            ResponseEntity<GeocodeResponse> responseEntity = restTemplate.exchange(url, HttpMethod.GET, HttpEntity.EMPTY, GeocodeResponse.class);
            Optional<GeocodeResponse> responseOptional = Optional.ofNullable(responseEntity.getBody());

            List<Result> results = responseOptional.get().getResults();

            if(results != null && !results.isEmpty()){

                Result result = results.get(0);
                Geometry geometry = result.getGeometry();

                return new Coordinates(geometry.getLat(), geometry.getLng());

            }else{
                setCountryName("");
                setCityName("Error, try again !");
                return new Coordinates(52.2297, 21.0122);
            }

        } catch (Exception e) {
            System.err.println("Błąd podczas wywoływania API: " + e.getMessage());
            setCityName("Bad response from API");
            setCountryName("");
            return new Coordinates(52.2297, 21.0122); // domyślne wartości dla Warszawy
        }

    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public void setCountryName(String countryName) {
        this.countryName = countryName;
    }

}



