package by.salary.invitationservice.repo;

import by.salary.invitationservice.entity.Invitation;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface InvitationRepository extends MongoRepository<Invitation, Long> {
}
