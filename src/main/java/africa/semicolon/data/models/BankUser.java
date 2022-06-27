package africa.semicolon.data.models;


import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@RequiredArgsConstructor 
@NoArgsConstructor
@Document("Bank")
public class BankUser {
    @Id
    private int id;
    @NonNull
    private String firstName;
    @NonNull
    private String lastName;
    @NonNull
    private String email;
    @NonNull
    private String address;
    @NonNull
    private String phoneNumber;
    @NonNull
    private String occupation;
    private String accountNumber;
    private String password;
}
