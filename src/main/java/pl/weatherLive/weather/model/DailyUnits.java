package pl.weatherLive.weather.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class DailyUnits {
    public String time;
    public String temperature_2m_max;
    public String temperature_2m_min;
    public String precipitation_probability_mean;
    public String precipitation_sum;
    public String windspeed_10m_max;
}
