/**
 * This code was generated by
 * \ / _    _  _|   _  _
 *  | (_)\/(_)(_|\/| |(/_  v1.0.0
 *       /       /
 */

package com.twilio.rest.taskrouter.v1.workspace.worker;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.common.base.MoreObjects;
import com.twilio.base.Resource;
import com.twilio.converter.Converter;
import com.twilio.exception.ApiConnectionException;
import com.twilio.exception.ApiException;
import com.twilio.exception.RestException;
import com.twilio.http.HttpMethod;
import com.twilio.http.Request;
import com.twilio.http.Response;
import com.twilio.http.TwilioRestClient;
import com.twilio.rest.Domains;

import java.io.IOException;
import java.io.InputStream;
import java.net.URI;
import java.util.List;
import java.util.Map;
import java.util.Objects;

@JsonIgnoreProperties(ignoreUnknown = true)
public class WorkersRealTimeStatistics extends Resource {
    private static final long serialVersionUID = 59891376471139L;

    /**
     * Create a WorkersRealTimeStatisticsFetcher to execute fetch.
     *
     * @param pathWorkspaceSid The SID of the Workspace with the resource to fetch
     * @return WorkersRealTimeStatisticsFetcher capable of executing the fetch
     */
    public static WorkersRealTimeStatisticsFetcher fetcher(final String pathWorkspaceSid) {
        return new WorkersRealTimeStatisticsFetcher(pathWorkspaceSid);
    }

    /**
     * Converts a JSON String into a WorkersRealTimeStatistics object using the
     * provided ObjectMapper.
     *
     * @param json Raw JSON String
     * @param objectMapper Jackson ObjectMapper
     * @return WorkersRealTimeStatistics object represented by the provided JSON
     */
    public static WorkersRealTimeStatistics fromJson(final String json, final ObjectMapper objectMapper) {
        // Convert all checked exceptions to Runtime
        try {
            return objectMapper.readValue(json, WorkersRealTimeStatistics.class);
        } catch (final JsonMappingException | JsonParseException e) {
            throw new ApiException(e.getMessage(), e);
        } catch (final IOException e) {
            throw new ApiConnectionException(e.getMessage(), e);
        }
    }

    /**
     * Converts a JSON InputStream into a WorkersRealTimeStatistics object using the
     * provided ObjectMapper.
     *
     * @param json Raw JSON InputStream
     * @param objectMapper Jackson ObjectMapper
     * @return WorkersRealTimeStatistics object represented by the provided JSON
     */
    public static WorkersRealTimeStatistics fromJson(final InputStream json, final ObjectMapper objectMapper) {
        // Convert all checked exceptions to Runtime
        try {
            return objectMapper.readValue(json, WorkersRealTimeStatistics.class);
        } catch (final JsonMappingException | JsonParseException e) {
            throw new ApiException(e.getMessage(), e);
        } catch (final IOException e) {
            throw new ApiConnectionException(e.getMessage(), e);
        }
    }

    private final String accountSid;
    private final List<Map<String, Object>> activityStatistics;
    private final Integer totalWorkers;
    private final String workspaceSid;
    private final URI url;

    @JsonCreator
    private WorkersRealTimeStatistics(@JsonProperty("account_sid")
                                      final String accountSid,
                                      @JsonProperty("activity_statistics")
                                      final List<Map<String, Object>> activityStatistics,
                                      @JsonProperty("total_workers")
                                      final Integer totalWorkers,
                                      @JsonProperty("workspace_sid")
                                      final String workspaceSid,
                                      @JsonProperty("url")
                                      final URI url) {
        this.accountSid = accountSid;
        this.activityStatistics = activityStatistics;
        this.totalWorkers = totalWorkers;
        this.workspaceSid = workspaceSid;
        this.url = url;
    }

    /**
     * Returns The SID of the Account that created the resource.
     *
     * @return The SID of the Account that created the resource
     */
    public final String getAccountSid() {
        return this.accountSid;
    }

    /**
     * Returns The number of current Workers by Activity.
     *
     * @return The number of current Workers by Activity
     */
    public final List<Map<String, Object>> getActivityStatistics() {
        return this.activityStatistics;
    }

    /**
     * Returns The total number of Workers.
     *
     * @return The total number of Workers
     */
    public final Integer getTotalWorkers() {
        return this.totalWorkers;
    }

    /**
     * Returns The SID of the Workspace that contains the Workers.
     *
     * @return The SID of the Workspace that contains the Workers
     */
    public final String getWorkspaceSid() {
        return this.workspaceSid;
    }

    /**
     * Returns The absolute URL of the Workers statistics resource.
     *
     * @return The absolute URL of the Workers statistics resource
     */
    public final URI getUrl() {
        return this.url;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }

        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        WorkersRealTimeStatistics other = (WorkersRealTimeStatistics) o;

        return Objects.equals(accountSid, other.accountSid) &&
               Objects.equals(activityStatistics, other.activityStatistics) &&
               Objects.equals(totalWorkers, other.totalWorkers) &&
               Objects.equals(workspaceSid, other.workspaceSid) &&
               Objects.equals(url, other.url);
    }

    @Override
    public int hashCode() {
        return Objects.hash(accountSid,
                            activityStatistics,
                            totalWorkers,
                            workspaceSid,
                            url);
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                          .add("accountSid", accountSid)
                          .add("activityStatistics", activityStatistics)
                          .add("totalWorkers", totalWorkers)
                          .add("workspaceSid", workspaceSid)
                          .add("url", url)
                          .toString();
    }
}