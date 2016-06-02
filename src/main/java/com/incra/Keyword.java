package com.incra;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * @author Jeff Risberg
 * @since 03/11/2016
 */
public class Keyword {
    private long id;

    private String content;

    public Keyword() {
        // Jackson deserialization
    }

    public Keyword(long id, String content) {
        this.id = id;
        this.content = content;
    }

    @JsonProperty
    public long getId() {
        return id;
    }

    @JsonProperty
    public String getContent() {
        return content;
    }
}
