package com.kiberzoid.pushservice.model;

import com.kiberzoid.pushservice.util.First;
import com.kiberzoid.pushservice.util.Second;

import javax.validation.GroupSequence;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.util.Objects;
import java.util.Set;

@GroupSequence({First.class, Second.class, Message.class})
public class Message {

    @NotBlank(groups = First.class, message = "{any.not_blank}")
    @Size(min = 3, max = 30, groups = Second.class, message = "{title.size}")
    private String title;

    @NotBlank(groups = First.class, message = "{any.not_blank}")
    @Size(min = 3, max = 120, groups = Second.class, message = "{body.size}")
    private String body;

    @NotNull(groups = First.class, message = "{any.not_null}")
    @Size(min = 1, max = 3, groups = Second.class, message = "{destination.size}")
    private Set<@NotBlank(message = "{any.not_blank}")
                @Pattern(regexp = "^ID-TOKEN-[0-9]{10}", message = "{destination.token}") String> destination;

    public Message() {
    }

    public Message(String title, String body, Set<String> destination) {
        this.title = title;
        this.body = body;
        this.destination = destination;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public Set<String> getDestination() {
        return destination;
    }

    public void setDestination(Set<String> destination) {
        this.destination = destination;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Message)) return false;
        Message message = (Message) o;
        return getTitle().equals(message.getTitle()) &&
                getBody().equals(message.getBody()) &&
                getDestination().equals(message.getDestination());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getTitle(), getBody(), getDestination());
    }

    @Override
    public String toString() {
        return "Message{" +
                "title='" + title +
                "', body='" + body +
                "', destination=" + destination +
                '}';
    }
}
