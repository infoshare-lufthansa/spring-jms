package pl.infoshare.amqp.verifier.complaints;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.util.Random;

@RestController
@RequiredArgsConstructor
public class ComplaintController {

    private static final Random RANDOM = new Random();

    @PostMapping("/api/cases")
    public ComplaintResult createCase(@RequestBody Complaint complaint) {
        if (complaint.getAmount().compareTo(BigDecimal.TEN) <= 0) {
            return ComplaintResult.accepted(RANDOM.nextInt(10000) + 200);
        }

        return ComplaintResult.rejected();
    }
}
