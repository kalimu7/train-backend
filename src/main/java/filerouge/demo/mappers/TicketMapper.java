package filerouge.demo.mappers;


import filerouge.demo.dtos.TicketDto;
import filerouge.demo.entities.Ticket;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface TicketMapper {

    TicketMapper Instance = Mappers.getMapper(TicketMapper.class);
    @Mapping(target = "passenger.id",source = "passenger_id")
    @Mapping(target = "trajet.id",source = "trajet_id")
    Ticket toEntity(TicketDto ticketDto);


    @Mapping(target = "passenger_id",source = "passenger.id")
    @Mapping(target = "trajet_id",source = "trajet.id")
    TicketDto toDto(Ticket ticket);


}
