package realization.service.impl;


import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import realization.dto.BankDto;
import realization.mapper.BankMapper;
import realization.model.Bank;
import realization.repository.BankRepository;
import realization.service.BankService;

import java.util.List;


@Service
@RequiredArgsConstructor
public class BankServiceImpl implements BankService {

    private final BankRepository bankRepository;
    private final BankMapper bankMapper;

    @Override
    public Integer getControl(Integer id) {
        return bankRepository.getById(id).getControl();
    }

    @Override
    public List<BankDto> findAll() {
        return bankMapper.toDtos(bankRepository.questions());
    }
}
