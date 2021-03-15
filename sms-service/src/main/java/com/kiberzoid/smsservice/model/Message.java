package com.kiberzoid.smsservice.model;

import com.kiberzoid.smsservice.util.First;
import com.kiberzoid.smsservice.util.Second;

import javax.validation.GroupSequence;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.util.Objects;
import java.util.Set;

@GroupSequence({First.class, Second.class, Message.class})
public class Message {

    @NotNull(groups = First.class, message = "{any.not_null}")
    @Size(min = 1, max = 3, groups = Second.class, message = "{destination.size}")
    private Set<@NotBlank(message = "{any.not_blank}")
                @Pattern(regexp = "^79[0-9]{9}", message = "{destination.phone}") String> destination;

    @NotBlank(groups = First.class, message = "{any.not_blank}")
    @Size(min = 1, max = 70, groups = Second.class, message = "{text.size}")
    private String text;

    public Message() {
    }

    public Message(Set<String> destination, String text) {
        this.destination = destination;
        this.text = text;
    }

    public Set<String> getDestination() {
        return destination;
    }

    public void setDestination(Set<String> destination) {
        this.destination = destination;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Message)) return false;
        Message message = (Message) o;
        return getDestination().equals(message.getDestination()) &&
                getText().equals(message.getText());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getDestination(), getText());
    }

    @Override
    public String toString() {
        return "Message{" +
                "destination=" + destination +
                ", text='" + text +
                "'}";
    }
}
