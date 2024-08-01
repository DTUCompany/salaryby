package by.salary.useragreementservice.repo;

import by.salary.useragreementservice.dao.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
