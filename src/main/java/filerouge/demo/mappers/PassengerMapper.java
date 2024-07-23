package filerouge.demo.mappers;

import filerouge.demo.dtos.PassengerDto;
import filerouge.demo.entities.Passenger;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface PassengerMapper {

    PassengerMapper passengerMapper = Mappers.getMapper(PassengerMapper.class);

    PassengerDto toDto(Passenger passenger);
    Passenger toEntity(PassengerDto passengerDto);

}
