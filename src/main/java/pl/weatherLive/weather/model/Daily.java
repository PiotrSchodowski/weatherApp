package pl.weatherLive.weather.model;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.ArrayList;

@Data
@AllArgsConstructor
public class Daily {
    public ArrayList<String> time;
    public ArrayList<Double> temperature_2m_max;
    public ArrayList<Double> temperature_2m_min;
    public ArrayList<Double> precipitation_probability_mean;
    public ArrayList<Double> precipitation_sum;
    public ArrayList<Double> windspeed_10m_max;
}
