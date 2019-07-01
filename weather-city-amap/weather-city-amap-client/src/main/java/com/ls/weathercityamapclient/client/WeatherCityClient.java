package com.ls.weathercityamapclient.client;

import com.ls.weathercityamapclient.vo.CityRequest;
import com.ls.weathercityamapclient.vo.CityResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;
import java.util.Map;

/**
 * @author lijiayin
 */
@FeignClient(name = "weather-gateway", fallback = WeatherCityClient.WeatherCityClientFallBack.class)
public interface WeatherCityClient {

    /**
     * 获取city编码
     * @param city
     * @return
     */
    @GetMapping("/city/city/cityCode/{city}")
    String cityCode(@PathVariable("city") String city);

    /**
     * 获取city信息
     * @param request
     * @return
     */
    @PostMapping("/city/city/cityInfo")
    CityResponse cityInfo(CityRequest request);

    /**
     * 获取全部城市信息，区级
     * @return
     */
    @GetMapping("/city/city/cityCode")
    List<String> allCityCode();

    /**
     * 获取城市名称-城市编码
     * @param request
     * @return
     */
    @GetMapping("/cityMap")
    Map<Object, Object> cityMap(CityRequest request);

    @Component
    class WeatherCityClientFallBack implements WeatherCityClient{


        @Override
        public String cityCode(String city) {
            return null;
        }

        @Override
        public CityResponse cityInfo(CityRequest request) {
            return null;
        }

        @Override
        public List<String> allCityCode() {
            return null;
        }

        @Override
        public Map<Object, Object> cityMap(CityRequest request) {
            return null;
        }
    }
}
