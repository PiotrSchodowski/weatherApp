package pl.weatherLive.geolocation.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class GeocodeResponse {

    private List<Result> results;

    public void setResults(List<Result> results) {
        this.results = results;
    }
}

//Klasa GeocodeResponse składa się z listy obiektów Result, które reprezentują wyniki wyszukiwania.
// Każdy wynik zawiera obiekt Geometry, który zawiera szerokość i długość geograficzną.
//
//Klasy Result i Geometry są zagnieżdżone w klasie OpenCageResponse,
//ponieważ są one używane tylko w kontekście odpowiedzi z OpenCage Geocoding API.
//W ten sposób zapewniamy, że klasy te nie będą używane poza tą klasą i nie będą powodować konfliktów z innymi klasami w aplikacji.//
