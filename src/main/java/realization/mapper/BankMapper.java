package realization.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import realization.dto.BankDto;
import realization.model.Bank;

import java.util.List;
import java.util.stream.Collectors;

@Mapper
public interface BankMapper {

    @Mapping(target = "id", source = "entity.id")
    @Mapping(target = "text", source = "entity.text")
    @Mapping(target = "var1", source = "entity.var1")
    @Mapping(target = "var2", source = "entity.var2")
    @Mapping(target = "var3", source = "entity.var3")
    @Mapping(target = "var4", source = "entity.var4")
    @Mapping(target = "control", source = "entity.control")
    BankDto toDto(Bank entity);

    default List<BankDto> toDtos(List<Bank> entities) {
        return entities.stream().map(this::toDto).collect(Collectors.toList());
    }

}
