package filerouge.demo.services;


import filerouge.demo.Exception.NotfoundException;
import filerouge.demo.dtos.TrajetDto;
import filerouge.demo.entities.Trajet;
import filerouge.demo.mappers.TrajetMapper;
import filerouge.demo.repositories.TrajetRepository;
import filerouge.demo.services.ServiceInterfaces.TrajetServiceImp;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TrajetService implements TrajetServiceImp {

    private final TrajetRepository trajetRepository;

    public TrajetService(TrajetRepository trajetRepository) {

        this.trajetRepository = trajetRepository;

    }


    @Override
    public List<TrajetDto> SearchTrajet(TrajetDto trajetDto) {


        List<Trajet> trajets = trajetRepository.findTrajets(trajetDto.getDeparturCity(),trajetDto.getArrivatCity(),trajetDto.getDepartureday());

        List<TrajetDto> trajetDtos = new ArrayList<>();
        for (Trajet trajet : trajets) {
            TrajetDto trajetDto1 = TrajetMapper.Instance.toDto(trajet);
            trajetDtos.add(trajetDto1);
        }
        if(trajetDtos.isEmpty()){
            throw new NotfoundException(" no trajet found ");
        }
        return trajetDtos;

    }

    public TrajetDto AddTrajet(TrajetDto trajetDto) {

        Trajet trajet = TrajetMapper.Instance.toEntity(trajetDto);
        trajet = trajetRepository.save(trajet);
        return TrajetMapper.Instance.toDto(trajet);

    }


}
