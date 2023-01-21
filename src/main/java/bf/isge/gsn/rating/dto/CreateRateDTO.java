package bf.isge.gsn.rating.dto;

import bf.isge.gsn.rating.model.Rating;
import lombok.Data;

@Data
public class CreateRateDTO {
    private int note;
    private String comment;
    private Rating critere;
}
