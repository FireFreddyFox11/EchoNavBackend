package Controllers;

import Entities.Organisations;
import Verification.VerifyOrg;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/organisations")
public class OrganisationController {
    @PostMapping
    public ResponseEntity<?> createOrganisation(@RequestBody Organisations organisations){
        VerifyOrg verifyOrg = new VerifyOrg();
        if (verifyOrg.addOrgData(organisations)) {
          return ResponseEntity.status(HttpStatus.CREATED).body("Organisation created successfully!");
        }
        else if (!verifyOrg.addOrgData(organisations)) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Organisation already exists!");
        }
        else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Error. Something went wrong!");
        }
    }
}
