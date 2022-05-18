package realization.controller;

import org.springframework.security.access.annotation.Secured;
import realization.dto.BankDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
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
    public Integer complete(@RequestParam Map<String, String> allRequestParams) {
        Integer a;
        try {
            a = resultService.averageGrade(allRequestParams);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return -1;
        }
        return a;
    }

}




