package de.pislaru.sergiu.booklibrary.user.account.service;

import de.pislaru.sergiu.booklibrary.domain.entity.user.User;
import de.pislaru.sergiu.booklibrary.domain.entity.user.VerificationToken;
import de.pislaru.sergiu.booklibrary.repository.user.VerificationTokenRepository;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.time.LocalDateTime;
import java.util.UUID;

@Service
public class VerificationTokenServiceImpl implements VerificationTokenService {

    private final VerificationTokenRepository tokenRepository;

    public VerificationTokenServiceImpl(VerificationTokenRepository tokenRepository) {
        this.tokenRepository = tokenRepository;
    }

    @Override
    public String createVerificationToken(User user) {
        String token = UUID.randomUUID().toString();
        VerificationToken verificationToken = new VerificationToken(token, user);
        tokenRepository.save(verificationToken);
        return token;
    }

    @Override
    public boolean isVerificationTokenValid(VerificationToken verificationToken) {
        return verificationToken.getExpirationDate().isAfter(LocalDateTime.now());
    }

    @Override
    public VerificationToken getTokenByString(String token) {
        return tokenRepository.findByToken(token).orElseThrow(EntityNotFoundException::new);
    }
}
