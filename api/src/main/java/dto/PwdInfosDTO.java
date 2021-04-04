package dto;

import lombok.Data;

@Data
public class PwdInfosDTO {

    private int numberOfCharacters;
    private boolean uppercase;
    private boolean lowercase;
    private boolean numbers;
    private boolean symbols;

}