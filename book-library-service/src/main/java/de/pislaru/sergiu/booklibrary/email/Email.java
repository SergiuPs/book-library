package de.pislaru.sergiu.booklibrary.email;

public class Email {

    private final String to;
    private final EmailSender from;
    private final EmailSubject subject;
    private final EmailContent content;

    public Email(String to, EmailSender from, EmailSubject subject, EmailContent content) {
        this.to = to;
        this.from = from;
        this.subject = subject;
        this.content = content;
    }

    public String getTo() {return to;}
    public EmailSender getFrom() {return from;}
    public EmailSubject getSubject() {return subject;}
    public EmailContent getContent() {return content;}
}
