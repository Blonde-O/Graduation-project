package realization.service;

import realization.dto.ResultDto;
import realization.model.User;

import java.util.List;
import java.util.Map;

public interface ResultService {

    Integer averageGrade (Map<String, String> answers) throws Exception;
    List<ResultDto> getAllResults();
    boolean findExistingUser (User user);
}
