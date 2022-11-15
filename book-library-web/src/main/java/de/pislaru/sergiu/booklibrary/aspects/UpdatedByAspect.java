package de.pislaru.sergiu.booklibrary.aspects;

import de.pislaru.sergiu.booklibrary.commands.BaseEntityCommand;
import de.pislaru.sergiu.booklibrary.security.AuthenticationService;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class UpdatedByAspect {

    private final AuthenticationService authenticationService;

    public UpdatedByAspect(AuthenticationService authenticationService) {
        this.authenticationService = authenticationService;
    }


    @Around("@annotation(UpdatedBy)")
    public String setUpdatedBy(ProceedingJoinPoint proceedingJoinPoint) {

        for (Object ob : proceedingJoinPoint.getArgs()) {
            if (ob instanceof BaseEntityCommand base) {
                base.setUpdatedBy(authenticationService.getLoggedInUser().user().getId());
            }
        }

        try {
            return (String) proceedingJoinPoint.proceed();
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

}
