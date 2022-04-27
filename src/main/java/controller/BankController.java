package controller;

import dto.BankDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import service.BankService;

@RestController
@RequestMapping("/student")
@RequiredArgsConstructor
public class BankController {
    private final BankService bankService;

    @GetMapping("/questions")
    public String findQuestion(@RequestParam("arg1") Integer questionId){
        return bankService.getText(questionId);


    }



}
