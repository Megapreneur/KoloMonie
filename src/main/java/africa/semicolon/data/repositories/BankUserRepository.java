package africa.semicolon.data.repositories;

import africa.semicolon.data.models.BankUser;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface BankUserRepository extends MongoRepository<BankUser, String> {

    boolean existsByEmail(String email);
}
