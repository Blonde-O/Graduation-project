package realization.controller;

import realization.dto.BankDto;
import lombok.RequiredArgsConstructor;
import realization.model.Bank;
import org.springframework.web.bind.annotation.*;
import realization.model.Result;
import realization.model.User;
import realization.repository.BankRepository;
import realization.repository.ResultRepository;
import realization.repository.UserRepository;
import realization.service.BankService;

import java.util.*;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/student")
@RequiredArgsConstructor
public class BankController {
    private final BankService bankService;
    private final ResultRepository resultRepository;
    private final UserRepository userRepository;

    @GetMapping("/questions")
    public List<BankDto> findQuestion() {
        return bankService.findAll();
    }

    @PostMapping
    public void complete(@RequestParam Map<String, String> allRequestParams) {
        System.out.println(allRequestParams);
        List<Integer> keys = allRequestParams.keySet().stream().map(x -> Integer.valueOf(x)).collect(Collectors.toList());
        List<Integer> values = allRequestParams.values().stream().map(x -> Integer.valueOf(x)).collect(Collectors.toList());
        Double averageGrade = 0.0;
        for (int i = 0; i < keys.size(); i++) {
            if (bankService.getControl(keys.get(i)) == values.get(i)) {
                averageGrade += 1;
            }
        }
        System.out.println(keys);
        System.out.println(values);
        System.out.println((100 * averageGrade / keys.size()) + "%");

    }


}




