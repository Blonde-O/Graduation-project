package realization.service;

import realization.dto.BankDto;

import java.util.List;

public interface BankService {

    Integer getControl(Integer id);

    List<BankDto> findAll();


}
