package pl.sda.shopapp.dto;

import java.util.UUID;

public class CustomerIdDto {

    private UUID id;

    public CustomerIdDto(UUID id) {
        this.id = id;
    }

    public UUID getId() {
        return id;
    }
}
