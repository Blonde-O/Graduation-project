/*
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
    private final BankRepository bankRepository;

    @GetMapping("/questions")
    public Bank findQuestion(@RequestParam("arg1") Integer questionId){
        return bankRepository.getById(questionId);


    }



}
*/
