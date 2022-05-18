package realization.service;

import realization.dto.ResultDto;
import realization.model.User;
import realization.pojo.TotalValueResponse;

import java.util.List;
import java.util.Map;

public interface ResultService {

    TotalValueResponse averageGrade (Map<String, String> answers) throws Exception;
    List<ResultDto> getAllResults();
    boolean findExistingUser (User user);
}
