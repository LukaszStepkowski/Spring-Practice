package pl.sda.shopapp.service.geocoding;

import pl.sda.shopapp.dto.GeocodeAddressDto;

public interface GeocodingService {

    GeocodeAddressDto find(double latitude, double longitude);
}
