/**
 * This code was generated by
 * \ / _    _  _|   _  _
 *  | (_)\/(_)(_|\/| |(/_  v1.0.0
 *       /       /
 */

package com.twilio.rest.proxy.v1.service;

import com.twilio.base.Creator;
import com.twilio.converter.Converter;
import com.twilio.converter.DateConverter;
import com.twilio.converter.Promoter;
import com.twilio.exception.ApiConnectionException;
import com.twilio.exception.ApiException;
import com.twilio.exception.RestException;
import com.twilio.http.HttpMethod;
import com.twilio.http.Request;
import com.twilio.http.Response;
import com.twilio.http.TwilioRestClient;
import com.twilio.rest.Domains;
import org.joda.time.DateTime;

import java.util.List;
import java.util.Map;

/**
 * PLEASE NOTE that this class contains beta products that are subject to
 * change. Use them with caution.
 */
public class SessionCreator extends Creator<Session> {
    private final String pathServiceSid;
    private String uniqueName;
    private DateTime dateExpiry;
    private Integer ttl;
    private Session.Mode mode;
    private Session.Status status;
    private List<Map<String, Object>> participants;

    /**
     * Construct a new SessionCreator.
     * 
     * @param pathServiceSid Service Sid.
     */
    public SessionCreator(final String pathServiceSid) {
        this.pathServiceSid = pathServiceSid;
    }

    /**
     * Your unique identifier for this Session such as a Job ID or conversation ID.
     * *Should not contain PII.*.
     * 
     * @param uniqueName A unique, developer assigned name of this Session.
     * @return this
     */
    public SessionCreator setUniqueName(final String uniqueName) {
        this.uniqueName = uniqueName;
        return this;
    }

    /**
     * An absolute time (ISO 8601) at which this Session should close. If this is
     * populated, it takes precedence over TTL values..
     * 
     * @param dateExpiry The date this Session should expire
     * @return this
     */
    public SessionCreator setDateExpiry(final DateTime dateExpiry) {
        this.dateExpiry = dateExpiry;
        return this;
    }

    /**
     * The time, in seconds, after the latest of Session create time or the
     * Session's last Interaction time at which the session will expire..
     * 
     * @param ttl TTL for a Session, in seconds.
     * @return this
     */
    public SessionCreator setTtl(final Integer ttl) {
        this.ttl = ttl;
        return this;
    }

    /**
     * The type of communications mediums allowed on a Session. Defaults to
     * `voice-and-message`. Other options are `voice-only` or `message-only`..
     * 
     * @param mode The Mode of this Session
     * @return this
     */
    public SessionCreator setMode(final Session.Mode mode) {
        this.mode = mode;
        return this;
    }

    /**
     * Set this value to `closed` to close the session. A Session can be re-opened
     * by posting to a closed session with the value `in-progress`.  This will be
     * `open` by default on create..
     * 
     * @param status Session status
     * @return this
     */
    public SessionCreator setStatus(final Session.Status status) {
        this.status = status;
        return this;
    }

    /**
     * The participants.
     * 
     * @param participants The participants
     * @return this
     */
    public SessionCreator setParticipants(final List<Map<String, Object>> participants) {
        this.participants = participants;
        return this;
    }

    /**
     * The participants.
     * 
     * @param participants The participants
     * @return this
     */
    public SessionCreator setParticipants(final Map<String, Object> participants) {
        return setParticipants(Promoter.listOfOne(participants));
    }

    /**
     * Make the request to the Twilio API to perform the create.
     * 
     * @param client TwilioRestClient with which to make the request
     * @return Created Session
     */
    @Override
    @SuppressWarnings("checkstyle:linelength")
    public Session create(final TwilioRestClient client) {
        Request request = new Request(
            HttpMethod.POST,
            Domains.PROXY.toString(),
            "/v1/Services/" + this.pathServiceSid + "/Sessions",
            client.getRegion()
        );

        addPostParams(request);
        Response response = client.request(request);

        if (response == null) {
            throw new ApiConnectionException("Session creation failed: Unable to connect to server");
        } else if (!TwilioRestClient.SUCCESS.apply(response.getStatusCode())) {
            RestException restException = RestException.fromJson(response.getStream(), client.getObjectMapper());
            if (restException == null) {
                throw new ApiException("Server Error, no content");
            }

            throw new ApiException(
                restException.getMessage(),
                restException.getCode(),
                restException.getMoreInfo(),
                restException.getStatus(),
                null
            );
        }

        return Session.fromJson(response.getStream(), client.getObjectMapper());
    }

    /**
     * Add the requested post parameters to the Request.
     * 
     * @param request Request to add post params to
     */
    private void addPostParams(final Request request) {
        if (uniqueName != null) {
            request.addPostParam("UniqueName", uniqueName);
        }

        if (dateExpiry != null) {
            request.addPostParam("DateExpiry", dateExpiry.toString());
        }

        if (ttl != null) {
            request.addPostParam("Ttl", ttl.toString());
        }

        if (mode != null) {
            request.addPostParam("Mode", mode.toString());
        }

        if (status != null) {
            request.addPostParam("Status", status.toString());
        }

        if (participants != null) {
            for (Map<String, Object> prop : participants) {
                request.addPostParam("Participants", Converter.mapToJson(prop));
            }
        }
    }
}