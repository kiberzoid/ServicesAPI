package com.kiberzoid.emailservice.model;

import com.kiberzoid.emailservice.util.First;
import com.kiberzoid.emailservice.util.Second;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.GroupSequence;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;

@GroupSequence({First.class, Second.class, Message.class})
public class Message {

    @NotBlank(groups = First.class, message="{any.not_blank}")
    @Email(groups = Second.class, message="{any.email}")
    private String from;

    @NotNull(groups = First.class, message="{any.not_null}")
    @Size(min = 1, max = 3, groups = Second.class, message="{destination.size}")
    private Set<@NotBlank(message="{any.not_blank}") @Email(message="{any.email}") String> destination;

    @NotBlank(groups = First.class, message="{any.not_blank}")
    @Size(min = 1, max = 30, groups = Second.class, message="{subject.size}")
    private String subject;

    @NotBlank(groups = First.class, message="{any.not_blank}")
    @Size(min = 1, max = 300, groups = Second.class, message="{text.size}")
    private String text;

    private List<MultipartFile> attachment;

    public Message() {
    }

    public Message(String from, Set<String> destination, String subject, String text) {
        this.from = from;
        this.destination = destination;
        this.subject = subject;
        this.text = text;
    }

    public Message(String from, Set<String> destination, String subject, String text, List<MultipartFile> attachment) {
        this(from, destination, subject, text);
        this.attachment = attachment;
    }

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public Set<String> getDestination() {
        return destination;
    }

    public void setDestination(Set<String> destination) {
        this.destination = destination;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public List<MultipartFile> getAttachment() {
        return attachment;
    }

    public void setAttachment(List<MultipartFile> attachment) {
        this.attachment = attachment;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Message)) return false;
        Message message = (Message) o;
        return getFrom().equals(message.getFrom()) &&
                getDestination().equals(message.getDestination()) &&
                getSubject().equals(message.getSubject()) &&
                getText().equals(message.getText()) &&
                Objects.equals(getAttachment(), message.getAttachment());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getFrom(), getDestination(), getSubject(), getText(), getAttachment());
    }

    @Override
    public String toString() {
        if (attachment != null && !attachment.isEmpty()) {
            List<String> listNames = attachment.stream()
                    .map(MultipartFile::getOriginalFilename)
                    .collect(Collectors.toList());
            String names = StringUtils.collectionToDelimitedString(listNames, ",", "[", "]");
            return "Message{" +
                    "from=" + from +
                    ", destination=" + destination +
                    ", subject='" + subject +
                    "', text='" + text +
                    "', attachment=" + names +
                    "}";

        } else {
            return "Message{" +
                    "from=" + from +
                    ", destination=" + destination +
                    ", subject='" + subject +
                    "', text='" + text +
                    "'}";
        }
    }
}
