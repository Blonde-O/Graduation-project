package realization.service;

import realization.dto.ResultDto;

import java.util.List;
import java.util.Map;

public interface ResultService {

    Integer averageGrade (Map<String, String> answers);
    List<ResultDto> getAllResults();
}
