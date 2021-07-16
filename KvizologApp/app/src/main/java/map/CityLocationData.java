package map;

import com.google.android.gms.maps.model.LatLng;

import java.util.ArrayList;
import java.util.List;

public abstract class CityLocationData {
    private static final List<City> citiesArray = new ArrayList<>();

    public static City getCityDataByName(String name){
        for(City city : citiesArray)
            if(name.equals(city.getName()))
                return city;
        return null;
    }

    private class City{
        private String name;
        private LatLng coordinates;
        private int imageResource;

        City(String name, LatLng latlang, int imgRes){
            this.name = name;
            this.coordinates = latlang;
            this.imageResource = imgRes;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public LatLng getCoordinates() {
            return coordinates;
        }

        public void setCoordinates(LatLng coordinates) {
            this.coordinates = coordinates;
        }

        public int getImageResource() {
            return imageResource;
        }

        public void setImageResource(int imageResource) {
            this.imageResource = imageResource;
        }
    }
}
