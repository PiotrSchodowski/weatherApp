package pl.weatherLive.weather.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class GeoCoordinates {
    private double latitude;
    private double longitude;
}
