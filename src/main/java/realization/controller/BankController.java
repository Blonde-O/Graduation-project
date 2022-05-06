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

    /*@GetMapping("/questions")
    public List<List> findQuestion(@RequestParam("arg1") Integer questionId){
        List <String> array = new ArrayList<>();
        List <List> list = new ArrayList<>();
        array.add(bankService.getText(questionId));
        array.add(bankService.getVar1(questionId));
        array.add(bankService.getVar2(questionId));
        array.add(bankService.getVar3(questionId));
        array.add(bankService.getVar4(questionId));
        list.add(array);
        return list;
    }*/

    @GetMapping("/questions")
    public List<String> findQuestion(@RequestParam("arg1") Integer questionId){
        Set<Integer> generated = new HashSet<Integer>();
        Random r = new Random();
        while (generated.size() < 6) {
            generated.add(r.nextInt(10) + 1);
        }
        List<BankDto> bankDtoList = new ArrayList<>();
        for (Integer id:generated){
            bankDtoList.add(new BankDto(bankService.getText(id), bankService.getVar1(id),
                    bankService.getVar2(id), bankService.getVar3(id),
                    bankService.getVar4(id), bankService.getControl(id)));
        }
        List<String> textList=bankDtoList.stream().map(x-> x.getText()).collect(Collectors.toList());
        return textList;
    }
    @PostMapping("/questions/postresult")
    public void postResult(@RequestParam("arg1") Integer value, @RequestParam("arg2") Integer id){
        Result result = new Result();
        result.setUser(userRepository.getById(id));
        result.setValue(value);
        resultRepository.save(result);


    }



}
