package africa.semicolon.data.repositories;

import africa.semicolon.data.models.BankUser;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface BankUserRepository extends MongoRepository<BankUser, String> {

    boolean existsByEmail(String email);

    Optional<BankUser> findByEmail(String email);

}
