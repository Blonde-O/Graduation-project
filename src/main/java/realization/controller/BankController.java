package realization.controller;

import realization.dto.BankDto;
import lombok.RequiredArgsConstructor;
import realization.model.Bank;
import org.springframework.web.bind.annotation.*;
import realization.repository.BankRepository;
import realization.service.BankService;

@RestController
@RequestMapping("/student")
@RequiredArgsConstructor
public class BankController {
    private final BankService bankService;

    @GetMapping("/questions")
    public String findQuestion(@RequestParam("arg1") Integer questionId){
        return bankService.getVar1(questionId);


    }



}
