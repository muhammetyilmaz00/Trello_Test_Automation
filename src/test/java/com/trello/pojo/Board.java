package com.trello.pojo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)  //ignore fields in the JSON that aren't present in the class
public class Board {
    String id;
    String name;
}
