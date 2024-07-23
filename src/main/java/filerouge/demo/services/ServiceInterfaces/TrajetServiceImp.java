package filerouge.demo.services.ServiceInterfaces;

import filerouge.demo.dtos.TrajetDto;

import java.util.List;

public interface TrajetServiceImp {

    List<TrajetDto> SearchTrajet(TrajetDto trajetDto);

    TrajetDto AddTrajet(TrajetDto trajetDto);

}
