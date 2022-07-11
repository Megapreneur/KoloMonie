package africa.semicolon.dto.Request;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CheckBalanceRequest {
    private String accountNumber;
    private String password;
}
