package pl.weatherLive.weather.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Item {
    private String title;
    private String id;
    private Position position;
}
