package realization.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import realization.dto.ResultDto;
import realization.exception.RepeatedTestingException;
import realization.model.Result;
import realization.model.User;
import realization.pojo.TotalValueResponse;
import realization.repository.ResultRepository;
import realization.service.BankService;
import realization.service.ResultService;
import realization.service.UserService;

import java.util.List;
import java.util.Map;
import java.util.Objects;

@Service
@RequiredArgsConstructor
public class ResultServiceImpl implements ResultService {
    private final BankService bankService;
    private final UserService userService;
    private final ResultRepository resultRepository;


    @Override
    public TotalValueResponse averageGrade(Map<String, String> answers) {
        List<Integer> keys = answers.keySet().stream().map(Integer::valueOf).toList();
        List<Integer> values = answers.values().stream().map(Integer::valueOf).toList();
        double averageGrade = 0.0;
        for (int i = 0; i < keys.size(); i++) {
            if (Objects.equals(bankService.getControl(keys.get(i)), values.get(i))) {
                averageGrade += 1;
            }
        }
        Integer total = (int) Math.round((100 * averageGrade / keys.size()));
        TotalValueResponse totalValueResponse = new TotalValueResponse();
        try {
            saveResult(total);
            if (total < 60) {
                totalValueResponse.setResponseId(0);
                totalValueResponse.setMessage("Ваш результат: " + total + "%. Вы не сдали тест.");
            } else {
                totalValueResponse.setResponseId(1);
                totalValueResponse.setMessage("Ваш результат: " + total + "%. Вы сдали тест.");
            }
        } catch (RepeatedTestingException e) {
            System.out.println(e.getMessage());
            totalValueResponse.setResponseId(-1);
            totalValueResponse.setMessage("ВЫ УЖЕ ПРОХОДИЛИ ТЕСТ.");
        }

        return totalValueResponse;
    }

    @Override
    public List<ResultDto> getAllResults() {
        List<Result> resultList = resultRepository.findAll();
        List<ResultDto> resultDtoList = resultList.stream()
                .map(x -> new ResultDto(x.getId(), x.getUser().getFio(), x.getValue()))
                .toList();
        return resultDtoList;
    }

    @Override
    public boolean findExistingUser(User user) {
        return resultRepository.existsResultByUser(user);
    }

    public void saveResult(Integer total) throws RepeatedTestingException {
        User user = userService.getAuthorisedUser();
        if (findExistingUser(user)) {
            throw new RepeatedTestingException("Повторное прохождение теста");
        }
        Result result = new Result();
        result.setUser(user);
        result.setValue(total);
        resultRepository.save(result);
    }

}
