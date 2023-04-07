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
