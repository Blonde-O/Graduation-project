package realization.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
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
    public Integer averageGrade(Map<String, String> answers) {
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
        Result result = new Result();
        result.setUser(user);
        result.setValue(total);
        resultRepository.save(result);
        return total;
    }
}