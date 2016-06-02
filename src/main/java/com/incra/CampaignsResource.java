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
import java.util.Date;
import java.util.List;

/**
 * @author Jeff Risberg
 * @since 03/11/2016
 */
@Path("/campaigns")
@Produces(MediaType.APPLICATION_JSON)
public class CampaignsResource {
    Logger log = LoggerFactory.getLogger(CampaignsResource.class);

    private List<Campaign> campaigns;

    public CampaignsResource() {
        campaigns = new ArrayList<Campaign>();

        Campaign campaign;

        campaign = new Campaign(1, "Summer 2016 promo", new Date(), true);
        campaigns.add(campaign);
        campaign = new Campaign(2, "Fall 2016 back-to-school promo", new Date(), true);
        campaigns.add(campaign);
        campaign = new Campaign(3, "Holiday 2016 promo", new Date(), false);
        campaigns.add(campaign);
    }

    @GET
    @Timed
    public List<Campaign> listTasks(@QueryParam("contains") Optional<String> contains) {
        List<Campaign> result = new ArrayList<Campaign>();

        String query = contains.or("");

        try {
            for (Campaign campaign : campaigns) {
                result.add(campaign);
            }
        } catch (Exception e) {
            log.error("Exception in campaigns method.", e);
        }
        return result;
    }
}