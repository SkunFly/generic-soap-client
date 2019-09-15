package com.skunfly.api.service;

import com.skunfly.soap.client.GenericSOAPClient;
import com.skunfly.weather.wsdl.GetCityForecastByZIP;
import com.skunfly.weather.wsdl.GetCityForecastByZIPResponse;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

@Service
public class WeatherService {

    private GenericSOAPClient weatherClient;

    public WeatherService(@Qualifier(value = "weatherClient") GenericSOAPClient weatherClient) {
        this.weatherClient = weatherClient;
    }

    public GetCityForecastByZIPResponse getForecastByZip(String zip){
        if (StringUtils.isEmpty(zip)) return null;

        GetCityForecastByZIP request = new GetCityForecastByZIP();
        request.setZIP(zip);

        return (GetCityForecastByZIPResponse) weatherClient.sendAndReceive(request, "http://ws.cdyne.com/WeatherWS/GetCityForecastByZIP");
    }
}
