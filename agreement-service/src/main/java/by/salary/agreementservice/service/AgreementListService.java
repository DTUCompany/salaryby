package by.salary.agreementservice.service;

import by.salary.agreementservice.entity.AgreementList;
import by.salary.agreementservice.exceptions.AgreementNotFoundException;
import by.salary.agreementservice.model.AgreementListRequestDTO;
import by.salary.agreementservice.model.AgreementListResponseDTO;
import by.salary.agreementservice.repo.AgreementListRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AgreementListService {

    private final AgreementListRepository agreementListRepository;
    private final AgreementService agreementService;

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
        return agreementListRepository.findById(agreementListId)
                .map(AgreementListResponseDTO::new)
                .orElseThrow(() -> new AgreementNotFoundException("Agreement list with id: " + agreementListId + " not found", HttpStatus.NOT_FOUND));
    }

    public AgreementListResponseDTO createAgreementList(Long agreementId, AgreementListRequestDTO agreementListRequestDTO) {
        AgreementList agreementList = AgreementList.builder()
                .agreement(agreementService.getAgreementObjectById(agreementId))
                .agreementListName(agreementListRequestDTO.getAgreementListName())
                .build();
        return new AgreementListResponseDTO(agreementListRepository.save(agreementList));
    }

    public AgreementListResponseDTO updateAgreementList(Long agreementListId, AgreementListRequestDTO agreementListRequestDTO) {
        AgreementList agreementList = agreementListRepository.findById(agreementListId)
                .orElseThrow(() -> new AgreementNotFoundException("Agreement list with id: " + agreementListId + " not found", HttpStatus.NOT_FOUND));
        agreementList.setAgreementListName(agreementListRequestDTO.getAgreementListName());
        return new AgreementListResponseDTO(agreementListRepository.save(agreementList));
    }

    public AgreementList getAgreementListObjectById(Long agreementListId) {
        return agreementListRepository.findById(agreementListId)
                .orElseThrow(() -> new AgreementNotFoundException("Agreement list with id: " + agreementListId + " not found", HttpStatus.NOT_FOUND));
    }

    public AgreementListResponseDTO deleteAgreementList(Long agreementListId) {
        Optional<AgreementList> agreementList = agreementListRepository.findById(agreementListId);
        if (agreementList.isEmpty()) {
            throw new AgreementNotFoundException("Agreement list with id: " + agreementListId + " not found", HttpStatus.NOT_FOUND);
        }
        agreementListRepository.delete(agreementList.get());
        return new AgreementListResponseDTO(agreementList.get());
    }
}
