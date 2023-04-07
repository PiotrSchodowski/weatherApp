package pl.weatherLive.geolocation.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Coordinates {
    private final double latitude;
    private final double longitude;
}
