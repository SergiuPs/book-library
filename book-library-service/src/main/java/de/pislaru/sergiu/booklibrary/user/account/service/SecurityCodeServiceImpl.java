package de.pislaru.sergiu.booklibrary.user.account.service;

import de.pislaru.sergiu.booklibrary.model.user.SecurityCode;
import de.pislaru.sergiu.booklibrary.repositories.SecurityCodeRepository;
import org.springframework.stereotype.Service;

import java.security.SecureRandom;
import java.text.DecimalFormat;
import java.time.LocalDateTime;
import java.util.Set;

@Service
public class SecurityCodeServiceImpl implements SecurityCodeService {

    private final SecurityCodeRepository securityCodeRepository;

    public SecurityCodeServiceImpl(SecurityCodeRepository securityCodeRepository) {
        this.securityCodeRepository = securityCodeRepository;
    }

    @Override
    public String createSecurityCode(String email) {

        String secureCode = new DecimalFormat("000000").format(new SecureRandom().nextInt(999999));

        SecurityCode securityCode = new SecurityCode(secureCode, email);
        securityCodeRepository.save(securityCode);

        return secureCode;
    }

    @Override
    public boolean isSecurityCodeValid(String code, String email) {
        Set<SecurityCode> codes = securityCodeRepository.findAllByCodeAndEmail(code, email);
        return codes.stream().anyMatch(el -> el.getExpirationDate().isAfter(LocalDateTime.now()));
    }
}
