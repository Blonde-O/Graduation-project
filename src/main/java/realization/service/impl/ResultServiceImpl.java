package realization.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import realization.dto.ResultDto;
import realization.exception.RepeatedTestingException;
import realization.model.Result;
import realization.model.User;
import realization.repository.ResultRepository;
import realization.repository.UserRepository;
import realization.security.UserPrincipal;
import realization.service.BankService;
import realization.service.ResultService;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ResultServiceImpl implements ResultService {
    private final BankService bankService;
    private final UserRepository userRepository;
    private final ResultRepository resultRepository;


    @Override
    public Integer averageGrade(Map<String, String> answers) throws Exception {
        System.out.println(answers);
        List<Integer> keys = answers.keySet().stream().map(x -> Integer.valueOf(x)).collect(Collectors.toList());
        List<Integer> values = answers.values().stream().map(x -> Integer.valueOf(x)).collect(Collectors.toList());
        double averageGrade = 0.0;
        for (int i = 0; i < keys.size(); i++) {
            if (bankService.getControl(keys.get(i)) == values.get(i)) {
                averageGrade += 1;
            }
        }
        System.out.println(keys);
        System.out.println(values);
        Integer total = Integer.valueOf((int) Math.round((100 * averageGrade / keys.size())));
        UserPrincipal userPrincipal = (UserPrincipal) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        String login = userPrincipal.getUsername();
        User user = userRepository.findUserByLogin(login);
        if (findExistingUser(user)){
            throw new RepeatedTestingException("Повторное прохождение теста");
        }
        Result result = new Result();
        result.setUser(user);
        result.setValue(total);
        resultRepository.save(result);

        return total;
    }

    @Override
    public List<ResultDto> getAllResults() {
        List<Result> resultList = resultRepository.findAll();
        List<ResultDto> resultDtoList = resultList.stream()
                .map(x -> new ResultDto(x.getId(), x.getUser().getFio(), x.getValue()))
                .toList();
        System.out.println(resultDtoList);
        return resultDtoList;
    }

    @Override
    public boolean findExistingUser(User user) {
        return resultRepository.existsResultByUser(user);
    }
}
