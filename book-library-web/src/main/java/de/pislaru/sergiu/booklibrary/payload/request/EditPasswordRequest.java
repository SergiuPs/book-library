package de.pislaru.sergiu.booklibrary.payload.request;

import javax.validation.constraints.NotEmpty;

public class EditPasswordRequest {

    @NotEmpty
    private char[] oldPassword;

    @NotEmpty
    private char[] newPassword;

    public char[] getOldPassword() {return oldPassword;}
    public char[] getNewPassword() {return newPassword;}
}
