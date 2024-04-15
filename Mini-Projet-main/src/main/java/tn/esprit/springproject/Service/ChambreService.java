package tn.esprit.springproject.Service;


import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;
import tn.esprit.springproject.Repository.BlocRepository;
import tn.esprit.springproject.entity.Bloc;
import tn.esprit.springproject.entity.Chambre;


import tn.esprit.springproject.Repository.ChambreRepository;
import tn.esprit.springproject.entity.TypeChambre;


import java.util.List;

import java.util.Set;

@Service
public class ChambreService implements iChambreService{

    @Autowired
    ChambreRepository chambreRepository;
    @Autowired
BlocRepository blocRepository;

    @Override
    public List<Chambre> retrieveAllChambers() {
        return chambreRepository.findAll();
    }

    @Override
    public Chambre addChambre(Chambre e) {
        return chambreRepository.save(e);
    }

    @Override
    public Chambre updateChambre(Chambre e) {
        return chambreRepository.save(e);
    }

    @Override
    public Chambre retrieveChambre(Long idChambre) {
        return chambreRepository.findById(idChambre).get();
    }

    @Override
    public void removeChambre(Long idChambre) {
        chambreRepository.deleteById(idChambre);

    }
    public Chambre retrieveChambreByNumero(Long numeroChambre) {
        return chambreRepository.findByNumeroChambre(numeroChambre);
    }

    public Set<Chambre> getChambresParNomBloc(String nomBloc) {
        Bloc bloc = blocRepository.findByNomBloc(nomBloc);

        return bloc.getChambres();
    }
    public long nbChambreParTypeEtBloc(TypeChambre type, long idBloc) {

        Bloc bloc = blocRepository.findById(idBloc).get();

        long count = 0;
        for (Chambre chambre : bloc.getChambres()) {
            if (chambre.getTypeC() == type) {
                count++;
            }
        }

        return count;
    }


}
