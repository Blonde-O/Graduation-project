package service.impl;

import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import repository.BankRepository;
import service.BankService;


@Service
@RequiredArgsConstructor
public class BankServiceImpl implements BankService {

    private final BankRepository bankRepository;


    @Override
    public String getText(Integer id) {
        return bankRepository.getById(id).getText();
    }

    @Override
    public String getVar1(Integer id) {
        return bankRepository.getById(id).getVar_1();
    }

    @Override
    public String getVar2(Integer id) {
        return bankRepository.getById(id).getVar_2();
    }

    @Override
    public String getVar3(Integer id) {
        return bankRepository.getById(id).getVar_3();
    }

    @Override
    public String getVar4(Integer id) {
        return bankRepository.getById(id).getVar_4();
    }

    @Override
    public Integer getControl(Integer id) {
        return bankRepository.getById(id).getControl();
    }
}
