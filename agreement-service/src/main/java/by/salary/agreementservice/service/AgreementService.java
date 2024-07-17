package by.salary.agreementservice.service;

import by.salary.agreementservice.entity.Agreement;
import by.salary.agreementservice.exceptions.AgreementNotFoundException;
import by.salary.agreementservice.model.AgreementRequestDTO;
import by.salary.agreementservice.model.AgreementResponseDTO;
import by.salary.agreementservice.repo.AgreementRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AgreementService {

    private final AgreementRepository agreementRepository;

    @Autowired
    public AgreementService(AgreementRepository agreementRepository) {
        this.agreementRepository = agreementRepository;
    }

    public List<AgreementResponseDTO> getAllAgreements() {
        return agreementRepository.findAll().stream()
                .map(AgreementResponseDTO::new)
                .toList();
    }

    public AgreementResponseDTO getAgreementById(Long id) {
        Optional<Agreement> agreement = agreementRepository.findById(id);
        if (agreement.isEmpty()) {
            throw new AgreementNotFoundException("Agreement with id: " + id + " not found", HttpStatus.NOT_FOUND);
        }
        return new AgreementResponseDTO(agreement.get());
    }

    public AgreementResponseDTO createAgreement(AgreementRequestDTO agreementRequestDTO) {
        Agreement agreement = Agreement.builder()
                .agreementName(agreementRequestDTO.getAgreementName())
                .build();
        return new AgreementResponseDTO(agreementRepository.save(agreement));
    }

    public AgreementResponseDTO updateAgreement(Long id, AgreementRequestDTO agreementResponseDTO) {
        Optional<Agreement> agreement = agreementRepository.findById(id);
        if (agreement.isEmpty()) {
            throw new AgreementNotFoundException("Agreement with id: " + id + " not found", HttpStatus.NOT_FOUND);
        }
        agreement.get().setAgreementName(agreementResponseDTO.getAgreementName());
        return new AgreementResponseDTO(agreementRepository.save(agreement.get()));
    }

    public AgreementResponseDTO deleteAgreement(Long id) {
        Optional<Agreement> agreement = agreementRepository.findById(id);
        if(agreement.isEmpty()){
            throw new AgreementNotFoundException("Agreement with id: " + id+ "not found",HttpStatus.NOT_FOUND);
        }
        agreementRepository.delete(agreement.get());
        return new AgreementResponseDTO(agreement.get());
    }
}
