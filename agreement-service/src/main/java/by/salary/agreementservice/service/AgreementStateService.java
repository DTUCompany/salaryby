package by.salary.agreementservice.service;

import by.salary.agreementservice.entity.AgreementList;
import by.salary.agreementservice.entity.AgreementState;
import by.salary.agreementservice.exceptions.AgreementNotFoundException;
import by.salary.agreementservice.model.AgreementStateRequestDTO;
import by.salary.agreementservice.model.AgreementStateResponseDTO;
import by.salary.agreementservice.repo.AgreementStateRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AgreementStateService {

    private final AgreementStateRepository agreementStateRepository;
    private final AgreementListService agreementListService;


    public List<AgreementStateResponseDTO> getAllAgreementStates() {
        return agreementStateRepository.findAll().stream()
                .map(AgreementStateResponseDTO::new)
                .toList();
    }

    public List<AgreementStateResponseDTO> getAgreementStatesByAgreementListId(Long id) {
        return agreementStateRepository.findByAgreementListId(id).stream()
                .map(AgreementStateResponseDTO::new)
                .toList();
    }

    public AgreementStateResponseDTO getAgreementStateById(Long agreementStateId) {
        Optional<AgreementState> agreementState = agreementStateRepository.findById(agreementStateId);
        if (agreementState.isEmpty()) {
            throw new AgreementNotFoundException("Agreement state with id: " + agreementStateId + " not found", HttpStatus.NOT_FOUND);
        }
        return new AgreementStateResponseDTO(agreementState.get());
    }

    public AgreementStateResponseDTO createAgreementStateInAgreementList(Long agreementListId, AgreementStateRequestDTO agreementStateResponseDTO) {
        AgreementList agreementList = agreementListService.getAgreementListObjectById(agreementListId);
        if (agreementList == null) {
            throw new AgreementNotFoundException("Agreement list with id: " + agreementListId + " not found", HttpStatus.NOT_FOUND);
        }
        AgreementState agreementState = AgreementState.builder()
                .agreementList(agreementList)
                .stateName(agreementStateResponseDTO.getStateName())
                .stateDescription(agreementStateResponseDTO.getStateDescription())
                .build();
        return new AgreementStateResponseDTO(agreementStateRepository.save(agreementState));
    }

    public AgreementStateResponseDTO updateAgreementState(Long agreementStateId, AgreementStateResponseDTO agreementStateResponseDTO) {
        Optional<AgreementState> agreementState = agreementStateRepository.findById(agreementStateId);
        if (agreementState.isEmpty()) {
            throw new AgreementNotFoundException("Agreement state with id: " + agreementStateId + " not found", HttpStatus.NOT_FOUND);
        }
        agreementState.get().setStateName(agreementStateResponseDTO.getStateName());
        return new AgreementStateResponseDTO(agreementStateRepository.save(agreementState.get()));
    }

    public AgreementStateResponseDTO deleteAgreementState(Long agreementStateId) {
        Optional<AgreementState> agreementState = agreementStateRepository.findById(agreementStateId);
        if (agreementState.isEmpty()) {
            throw new AgreementNotFoundException("Agreement state with id: " + agreementStateId + " not found", HttpStatus.NOT_FOUND);
        }
        agreementStateRepository.deleteById(agreementStateId);
        return new AgreementStateResponseDTO(agreementState.get());
    }
}
