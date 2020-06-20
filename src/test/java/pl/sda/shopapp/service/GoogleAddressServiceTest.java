package pl.sda.shopapp.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import pl.sda.shopapp.dto.GoogleAddressDto;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class GoogleAddressServiceTest {

    @Autowired
    private GoogleAddressService addressService;

    @Test
    void testFindAddress() {
        // given
        var latitude = 52.250714;
        var longitude = 20.876190;

        // when
        var address = addressService.findAddress(latitude, longitude);

        // then
        assertEquals(new GoogleAddressDto("Spychowska 2A", "01-472", "Warszawa", "PL"), address);
    }
}
