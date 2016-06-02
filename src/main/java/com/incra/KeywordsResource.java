package com.incra;

import com.codahale.metrics.annotation.Timed;
import com.google.common.base.Optional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Jeff Risberg
 * @since 03/11/2016
 */
@Path("/keywords")
@Produces(MediaType.APPLICATION_JSON)
public class KeywordsResource {
    Logger log = LoggerFactory.getLogger(KeywordsResource.class);

    private List<Keyword> keywords;

    public KeywordsResource() {
        keywords = new ArrayList<Keyword>();

        Keyword keyword;

        keyword = new Keyword(1, "sunscreen");
        keywords.add(keyword);
        keyword = new Keyword(2, "pencils");
        keywords.add(keyword);
        keyword = new Keyword(3, "greeting cards");
        keywords.add(keyword);
    }

    @GET
    @Timed
    public List<Keyword> listTasks(@QueryParam("contains") Optional<String> contains) {
        List<Keyword> result = new ArrayList<Keyword>();

        String query = contains.or("");

        try {
            for (Keyword keyword : keywords) {
                result.add(keyword);
            }
        } catch (Exception e) {
            log.error("Exception in keywords method.", e);
        }
        return result;
    }
}