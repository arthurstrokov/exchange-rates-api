package com.gmail.arthurstrokov.exchangeratesapi.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.Accessors;
import lombok.experimental.FieldDefaults;

import java.util.Date;

/**
 * @author Артур Александрович Строков
 * @email astrokov@clevertec.ru
 * @created 11.11.2022
 */
@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Rate {

    @JsonProperty("Cur_ID")
    int currentId;
    @JsonProperty("Date")
    Date date;
    @JsonProperty("Cur_Abbreviation")
    String currentAbbreviation;
    @JsonProperty("Cur_Scale")
    int currentScale;
    @JsonProperty("Cur_Name")
    String currentName;
    @JsonProperty("Cur_OfficialRate")
    double currentOfficialRate;
}
