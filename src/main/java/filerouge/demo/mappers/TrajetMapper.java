package filerouge.demo.mappers;


import filerouge.demo.dtos.TrajetDto;
import filerouge.demo.entities.Trajet;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface TrajetMapper {

    TrajetMapper Instance = Mappers.getMapper(TrajetMapper.class);
    Trajet toEntity(TrajetDto trajetDto);
    TrajetDto toDto(Trajet trajet);


}
