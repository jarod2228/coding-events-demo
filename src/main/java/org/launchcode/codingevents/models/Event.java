package org.launchcode.codingevents.models;

import javax.validation.constraints.*;
import java.util.Objects;

public class Event {

    private int id;
    private static int nextId = 1;

    @NotBlank(message = "Name is required.")
    @Size(min = 3, max = 50, message = "Your name must be between 3 and 50 characters.")
    private String name;

    @Size(max = 500, message = "Your description was too long. Must be 500 characters or less.")
    private String description;

    @NotBlank(message = "Email is required.")
    @Email
    private String contactEmail;

    @NotBlank(message = "Must include a location consisting of at least 2 but no more than 50 characters.")
    @Size(min = 2, max = 50)
    @NotNull(message = "Null values are not allowed.")
    private String location;

    @AssertTrue(message = "All events are registration-only.")
    @NotBlank(message = "Please check a box.")
    @NotNull(message = "Please check a box.")
    private boolean mustRegister;

    @Size(min = 1, message = "Event must have at least 1 expected attendee.")
    @NotBlank(message = "Event must have an attendee estimation given in the form of a number above 0.")
    @NotNull(message = "Null values are not allowed. Enter the number of expected attendees.")
    private int attendees;

    @NotBlank(message = "Please check a box.")
    @NotNull(message = "Please check a box.")
    private boolean isOutsideFoodAndDrinkAllowed;

    private EventType type;

    public Event(String name, String description, String contactEmail, String location, boolean mustRegister, int attendees,
                 boolean isOutsideFoodAndDrinkAllowed, EventType type) {
        this();
        this.name = name;
        this.description = description;
        this.contactEmail = contactEmail;
        this.location = location;
        this.mustRegister = mustRegister;
        this.attendees = attendees;
        this.isOutsideFoodAndDrinkAllowed = isOutsideFoodAndDrinkAllowed;
        this.type = type;


    }

    public Event() {
        this.id = nextId;
        nextId++;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getContactEmail() {
        return contactEmail;
    }

    public void setContactEmail(String contactEmail) {
        this.contactEmail = contactEmail;
    }

    public int getId() {
        return id;
    }

    public boolean isMustRegister() {
        return mustRegister;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public int getAttendees() {
        return attendees;
    }

    public void setAttendees(int attendees) {
        this.attendees = attendees;
    }

    public boolean isOutsideFoodAndDrinkAllowed() {
        return isOutsideFoodAndDrinkAllowed;
    }

    public void setOutsideFoodAndDrinkAllowed(boolean outsideFoodAndDrinkAllowed) {
        isOutsideFoodAndDrinkAllowed = outsideFoodAndDrinkAllowed;
    }

    public EventType getType() {
        return type;
    }

    public void setType(EventType type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Event event = (Event) o;
        return id == event.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
