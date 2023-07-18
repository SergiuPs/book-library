package de.pislaru.sergiu.booklibrary.aspects;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class CreatedByAspect {

    @Around("@annotation(CreatedBy)")
    public String setCreatedBy(ProceedingJoinPoint proceedingJoinPoint) {

        for (Object ob : proceedingJoinPoint.getArgs()) {
           /* if (ob instanceof BaseEntityCommand base) {
                base.setCreatedBy(SecurityUserHolder.getIdOfLoggedInUser());
            }*/
        }

        try {
            return (String) proceedingJoinPoint.proceed();
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }
}
