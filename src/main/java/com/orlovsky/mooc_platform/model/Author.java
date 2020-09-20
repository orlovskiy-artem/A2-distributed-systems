package com.orlovsky.mooc_platform.model;

import java.util.UUID;

public class Author {
    private UUID id;
    private String firstName;
    private String lastName;
    private String description;

    public Author(UUID id,
                  String firstName,
                  String lastName,
                  String description) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.description = description;
    }


    public UUID getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getName() {
        return this.getFirstName() + " " + this.getLastName();
    }

    @Override
    public String toString() {
        return "Author{" +
                "platformId=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", description='" + description + '\'' +
                '}';
    }


}
