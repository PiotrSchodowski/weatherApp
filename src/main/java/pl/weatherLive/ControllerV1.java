package pl.weatherLive;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import pl.weatherLive.geolocation.GeolocationService;
import pl.weatherLive.weather.WeatherService;
import pl.weatherLive.weather.model.Root;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.time.format.TextStyle;
import java.util.Locale;


@Controller
public class ControllerV1 {

    private final WeatherService weatherService;
    private final GeolocationService geolocationService;

    @Autowired
    public ControllerV1(WeatherService weatherService, GeolocationService geolocationService) {
        this.weatherService = weatherService;
        this.geolocationService = geolocationService;
    }

    @GetMapping
    public String giveWeather(Model model){
        Root weatherData = weatherService.getWeather();
        String cityName = geolocationService.getCityName();
        model.addAttribute("cityName",cityName);


        for(int i = 0; i < 5; i++) {

            String temperatureMax = weatherData.getDaily().getTemperature_2m_max().get(i).toString();
            String temperatureMin = weatherData.getDaily().getTemperature_2m_min().get(i).toString();

            LocalDate date = LocalDate.parse(weatherData.getDaily().getTime().get(i));
            String dayOfWeek = date.getDayOfWeek().getDisplayName(TextStyle.SHORT, Locale.getDefault());
            String time =  dayOfWeek + " " + date;

            String wind = weatherData.getDaily().getWindspeed_10m_max().get(i).toString();
            String precipitation = weatherData.getDaily().getPrecipitation_sum().get(i).toString();
            Double precipitationProbability = weatherData.getDaily().getPrecipitation_probability_mean().get(i);


            model.addAttribute("temperatureMax"+i, temperatureMax);
            model.addAttribute("temperatureMin"+i, temperatureMin);
            model.addAttribute("time"+i, time);
            model.addAttribute("wind"+i, wind);
            model.addAttribute("precipitation"+i, precipitation);
            model.addAttribute("precipitationProbability"+i, precipitationProbability);
        }
        return "gui";
    }

    @PostMapping("/save")
    public String downloadCity(@RequestParam String nameCity, @RequestParam String nameCountry){
        geolocationService.setCityName(nameCity);
        geolocationService.setCountryName(nameCountry);
        return "redirect:/";
    }
}
