package pl.sda.shopapp.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class ChangeCompanyNameDto {

    @NotNull
    @NotBlank
    private String name;

    public ChangeCompanyNameDto(String name) {
        this.name = name;
    }

    ChangeCompanyNameDto() {}

    public String getName() {
        return name;
    }
}
