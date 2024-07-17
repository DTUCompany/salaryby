package by.salary.agreementservice.service;

import by.salary.agreementservice.entity.AgreementList;
import by.salary.agreementservice.exceptions.AgreementNotFoundException;
import by.salary.agreementservice.model.AgreementListRequestDTO;
import by.salary.agreementservice.model.AgreementListResponseDTO;
import by.salary.agreementservice.repo.AgreementListRepository;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AgreementListService {

    private final AgreementListRepository agreementListRepository;
    private final AgreementService agreementService;

    @Autowired
    public AgreementListService(AgreementListRepository agreementListRepository, AgreementService agreementService) {
        this.agreementListRepository = agreementListRepository;
        this.agreementService = agreementService;
    }

    public List<AgreementListResponseDTO> getAllAgreementLists() {
        return agreementListRepository.findAll().stream()
                .map(AgreementListResponseDTO::new)
                .toList();
    }

    public List<AgreementListResponseDTO> getAgreementListsByAgreementId(Long agreementId) {
        return agreementListRepository.findByAgreementId(agreementId).stream()
                .map(AgreementListResponseDTO::new)
                .toList();
    }

    public AgreementListResponseDTO getAgreementListById(Long agreementListId) {
        Optional<AgreementListResponseDTO> agreementList = agreementListRepository.findById(agreementListId).map(AgreementListResponseDTO::new);
        if (agreementList.isEmpty()) {
            throw new AgreementNotFoundException("Agreement list with id: " + agreementListId + " not found", HttpStatus.NOT_FOUND);
        }
        return agreementList.get();
    }

    public AgreementListResponseDTO createAgreementList(Long agreementId, AgreementListRequestDTO agreementListRequestDTO) {
        AgreementList agreementList = AgreementList.builder()
                .agreement(agreementService.getAgreementObjectById(agreementId))
                .agreementListName(agreementListRequestDTO.getAgreementListName())
                .build();
        return new AgreementListResponseDTO(agreementListRepository.save(agreementList));
    }

    public AgreementListResponseDTO updateAgreementList(Long agreementListId, AgreementListRequestDTO agreementListRequestDTO) {
        Optional<AgreementList> agreementList = agreementListRepository.findById(agreementListId);
        if (agreementList.isEmpty()) {
            throw new AgreementNotFoundException("Agreement list with id: " + agreementListId + " not found", HttpStatus.NOT_FOUND);
        }
        agreementList.get().setAgreementListName(agreementListRequestDTO.getAgreementListName());
        return new AgreementListResponseDTO(agreementListRepository.save(agreementList.get()));
    }
}
