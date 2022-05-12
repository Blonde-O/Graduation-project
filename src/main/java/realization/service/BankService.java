package realization.service;

import realization.dto.BankDto;
import realization.model.Bank;

import java.util.List;

public interface BankService {
/*

    String getText(Integer id);

    String getVar1(Integer id);

    String getVar2(Integer id);

    String getVar3(Integer id);

    String getVar4(Integer id);*/

    Integer getControl(Integer id);

    List<BankDto> findAll();


}
