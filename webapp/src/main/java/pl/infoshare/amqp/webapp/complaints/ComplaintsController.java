package pl.infoshare.amqp.webapp.complaints;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequiredArgsConstructor
public class ComplaintsController {

    private final ComplaintService complaintService;

    @PostMapping("/api/complaints")
    public void createComplaint(@RequestBody @Valid Complaint complaint) {
        complaintService.processComplaint(complaint);
    }
}
