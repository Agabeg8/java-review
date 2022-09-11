import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class Employee {
    private int emId;
    private String empName;
    private String emEmail;
    private List<String> emPhoneNumber;
}
