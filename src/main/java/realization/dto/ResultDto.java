package realization.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import realization.model.User;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ResultDto {

    private Integer id;
    private String fio;
    private Integer value;


}
