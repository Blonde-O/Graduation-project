package realization.controller;

import org.springframework.security.access.annotation.Secured;
import realization.dto.BankDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import realization.pojo.TotalValueResponse;
import realization.service.BankService;
import realization.service.ResultService;

import java.util.*;

@RestController
@Secured("student")
@RequestMapping("/student")
@RequiredArgsConstructor
public class StudentController {
    private final BankService bankService;
    private final ResultService resultService;


    @GetMapping("/questions")
    public List<BankDto> findQuestion() {
        return bankService.findAll();
    }

    @PostMapping
    public TotalValueResponse complete(@RequestParam Map<String, String> allRequestParams) throws Exception {
        return resultService.averageGrade(allRequestParams);
    }

}