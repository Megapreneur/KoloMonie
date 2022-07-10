package africa.semicolon.dto.Response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class DepositResponse {
    private String message;
    private int balance;
//    private LocalDateTime localDateTime;
}
