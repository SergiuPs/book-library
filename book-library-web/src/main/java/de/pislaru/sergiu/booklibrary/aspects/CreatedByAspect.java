package de.pislaru.sergiu.booklibrary.aspects;

import de.pislaru.sergiu.booklibrary.commands.BaseEntityCommand;
import de.pislaru.sergiu.booklibrary.security.AuthenticationService;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;

@Aspect
public class CreatedByAspect {

    private final AuthenticationService authenticationService;

    public CreatedByAspect(AuthenticationService authenticationService) {
        this.authenticationService = authenticationService;
    }

    @Around("@annotation(CreatedBy)")
    public String setCreatedBy(ProceedingJoinPoint proceedingJoinPoint) {

        for (Object ob : proceedingJoinPoint.getArgs()) {
            if (ob instanceof BaseEntityCommand base) {
                base.setCreatedBy(authenticationService.getLoggedInUser().user().getId());
            }
        }

        try {
            return (String) proceedingJoinPoint.proceed();
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }
}
