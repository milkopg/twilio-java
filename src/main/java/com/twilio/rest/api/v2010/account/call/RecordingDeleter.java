/**
 * This code was generated by
 * \ / _    _  _|   _  _
 *  | (_)\/(_)(_|\/| |(/_  v1.0.0
 *       /       /
 */

package com.twilio.rest.api.v2010.account.call;

import com.twilio.base.Deleter;
import com.twilio.exception.ApiConnectionException;
import com.twilio.exception.ApiException;
import com.twilio.exception.RestException;
import com.twilio.http.HttpMethod;
import com.twilio.http.Request;
import com.twilio.http.Response;
import com.twilio.http.TwilioRestClient;
import com.twilio.rest.Domains;

public class RecordingDeleter extends Deleter<Recording> {
    private String pathAccountSid;
    private final String pathCallSid;
    private final String pathSid;

    /**
     * Construct a new RecordingDeleter.
     *
     * @param pathCallSid The Call SID of the resources to delete
     * @param pathSid The unique string that identifies the resource
     */
    public RecordingDeleter(final String pathCallSid,
                            final String pathSid) {
        this.pathCallSid = pathCallSid;
        this.pathSid = pathSid;
    }

    /**
     * Construct a new RecordingDeleter.
     *
     * @param pathAccountSid The SID of the Account that created the resources to
     *                       delete
     * @param pathCallSid The Call SID of the resources to delete
     * @param pathSid The unique string that identifies the resource
     */
    public RecordingDeleter(final String pathAccountSid,
                            final String pathCallSid,
                            final String pathSid) {
        this.pathAccountSid = pathAccountSid;
        this.pathCallSid = pathCallSid;
        this.pathSid = pathSid;
    }

    /**
     * Make the request to the Twilio API to perform the delete.
     *
     * @param client TwilioRestClient with which to make the request
     */
    @Override
    @SuppressWarnings("checkstyle:linelength")
    public boolean delete(final TwilioRestClient client) {
        this.pathAccountSid = this.pathAccountSid == null ? client.getAccountSid() : this.pathAccountSid;
        Request request = new Request(
            HttpMethod.DELETE,
            Domains.API.toString(),
            "/2010-04-01/Accounts/" + this.pathAccountSid + "/Calls/" + this.pathCallSid + "/Recordings/" + this.pathSid + ".json",
            client.getRegion()
        );

        Response response = client.request(request);

        if (response == null) {
            throw new ApiConnectionException("Recording delete failed: Unable to connect to server");
        } else if (!TwilioRestClient.SUCCESS.apply(response.getStatusCode())) {
            RestException restException = RestException.fromJson(response.getStream(), client.getObjectMapper());
            if (restException == null) {
                throw new ApiException("Server Error, no content");
            }
            throw new ApiException(restException);
        }

        return response.getStatusCode() == 204;
    }
}