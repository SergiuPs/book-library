package de.pislaru.sergiu.booklibrary.security;

import de.pislaru.sergiu.booklibrary.auth.SecurityUser;
import de.pislaru.sergiu.booklibrary.auth.service.SecurityUserHolder;
import org.springframework.security.access.expression.SecurityExpressionRoot;
import org.springframework.security.access.expression.method.MethodSecurityExpressionOperations;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

public class SecurityExpression extends SecurityExpressionRoot implements MethodSecurityExpressionOperations {


    private Object filterObject;
    private Object returnObject;

    public SecurityExpression(Authentication authentication) {
        super(authentication);
    }

    public boolean isResourceOwner(Long userId) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        Object principal = auth.getPrincipal();
        if (!(principal instanceof SecurityUser)) {
            return false;
        }
        return ((SecurityUser) principal).getId().equals(userId);
    }

    @Override
    public void setFilterObject(Object filterObject) {
        this.filterObject = filterObject;
    }

    @Override
    public Object getFilterObject() {
        return filterObject;
    }

    @Override
    public void setReturnObject(Object returnObject) {
        this.returnObject = returnObject;
    }

    @Override
    public Object getReturnObject() {
        return returnObject;
    }

    @Override
    public Object getThis() {
        return this;
    }
}
