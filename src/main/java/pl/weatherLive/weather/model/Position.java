package pl.weatherLive.weather.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Position {
    private double lat;
    private double lng;
}
