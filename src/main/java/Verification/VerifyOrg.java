package Verification;

import Entities.Organisations;
import Queries.OrganisationQueries;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Service
public class VerifyOrg {
    @Autowired
    private OrganisationQueries organisationQueries;

    public boolean verifyOrgData(Organisations organisations) {
        return (verifyContactInfo(organisations.getOrgContactNo()) &&
                verifyEmail(organisations.getOrgEmail()) &&
                verifyPassword(organisations.getOrgPassword()));
    }
    public boolean addOrgData(Organisations organisations) {
        boolean hasBeenAdded = false;
        if (verifyOrgData(organisations)) {
            Organisations org = Organisations.builder()
                    .OrgID(organisations.getOrgID())
                    .OrgName(organisations.getOrgName())
                    .AdminName(organisations.getAdminName())
                    .orgContactNo(organisations.getOrgContactNo() == null ? "" : organisations.getOrgContactNo())
                    .orgEmail(organisations.getOrgEmail())
                    .orgPassword(organisations.getOrgPassword())
                    .country(organisations.getCountry())
                    .createdAt(organisations.getCreatedAt())
                    .updatedAt(organisations.getUpdatedAt())
                    .build();
            organisationQueries.save(org);
            hasBeenAdded = true;
        }
        return hasBeenAdded;
    }
    public boolean verifyContactInfo(String contactInfo) {
        return contactInfo.length() < 10;
    }
    public boolean verifyEmail(String email) {
        return email.matches("((?!\\.)[\\w\\-_.]*[^.])(@\\w+)(\\.\\w+(\\.\\w+)?[^.\\W])");
    }
    public boolean verifyPassword(String password) {
        return password.matches("(?=.*\\d)(?=.*[A-Z])(?=.*[a-z])(?=.*[^\\w\\d\\s:])([^\\s]){8,16}");
    }
}
