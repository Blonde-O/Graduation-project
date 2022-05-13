package realization.controller;

import org.springframework.security.access.annotation.Secured;
import realization.dto.BankDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import realization.repository.ResultRepository;
import realization.repository.UserRepository;
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
    private final ResultRepository resultRepository;
    private final UserRepository userRepository;


    @GetMapping("/questions")
    public List<BankDto> findQuestion() {
        return bankService.findAll();
    }

    @PostMapping
    public void complete(@RequestParam Map<String, String> allRequestParams) {
        Integer a = resultService.averageGrade(allRequestParams);
        System.out.println(a + "%");
    }


}




