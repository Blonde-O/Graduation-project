package realization.controller;

import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.context.SecurityContextHolder;
import realization.dto.BankDto;
import lombok.RequiredArgsConstructor;
import realization.model.Bank;
import org.springframework.web.bind.annotation.*;
import realization.model.Result;
import realization.model.User;
import realization.repository.BankRepository;
import realization.repository.ResultRepository;
import realization.repository.UserRepository;
import realization.security.UserPrincipal;
import realization.service.BankService;
import realization.service.ResultService;

import java.util.*;
import java.util.stream.Collectors;

@RestController
@Secured("student")
@RequestMapping("/student")
@RequiredArgsConstructor
public class BankController {
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




