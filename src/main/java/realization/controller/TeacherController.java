package realization.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import realization.dto.ResultDto;
import realization.service.ResultService;

import java.util.List;

@RestController
@Secured("teacher")
@RequestMapping("/teacher")
@RequiredArgsConstructor
public class TeacherController {
    private final ResultService resultService;

    @GetMapping("/results")
    public List<ResultDto> getResults(){
        return resultService.getAllResults();
    }


}
