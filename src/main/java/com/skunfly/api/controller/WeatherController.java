package com.skunfly.api.controller;

import com.skunfly.api.service.WeatherService;
import com.skunfly.weather.wsdl.ForecastReturn;
import com.skunfly.weather.wsdl.GetCityForecastByZIPResponse;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/weather")
public class WeatherController {

    private WeatherService service;

    public WeatherController(WeatherService service) {
        this.service = service;
    }

    @RequestMapping(value = "/forecast/zip")
    public String getForecastByZip(@RequestParam String zip) {

        GetCityForecastByZIPResponse response = service.getForecastByZip(zip);

        if (response == null) return "";

        ForecastReturn getCityForecastByZIPResult = response.getGetCityForecastByZIPResult();
        String city = getCityForecastByZIPResult.getCity();
        String responseText = getCityForecastByZIPResult.getResponseText();

        return city + ": " + responseText;
    }
}
