package com.incra;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Date;

/**
 * @author Jeff Risberg
 * @since 03/11/2016
 */
public class Campaign {

    private long id;
    private String name;
    private Date startDate;
    private Boolean active;

    public Campaign() {
        // Jackson deserialization
    }

    public Campaign(long id, String name, Date startDate, boolean active) {
        this.id = id;
        this.name = name;
        this.startDate = startDate;
        this.active = active;
    }

    @JsonProperty
    public long getId() {
        return id;
    }

    @JsonProperty
    public String getName() {
        return name;
    }

    @JsonProperty
    public Date getStartDate() {
        return startDate;
    }

    @JsonProperty
    public Boolean getActive() {
        return active;
    }
}
