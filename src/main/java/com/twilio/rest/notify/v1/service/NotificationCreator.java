/**
 * This code was generated by
 * \ / _    _  _|   _  _
 *  | (_)\/(_)(_|\/| |(/_  v1.0.0
 *       /       /
 */

package com.twilio.rest.notify.v1.service;

import com.twilio.base.Creator;
import com.twilio.converter.Converter;
import com.twilio.converter.Promoter;
import com.twilio.exception.ApiConnectionException;
import com.twilio.exception.ApiException;
import com.twilio.exception.RestException;
import com.twilio.http.HttpMethod;
import com.twilio.http.Request;
import com.twilio.http.Response;
import com.twilio.http.TwilioRestClient;
import com.twilio.rest.Domains;

import java.util.List;
import java.util.Map;

/**
 * PLEASE NOTE that this class contains beta products that are subject to
 * change. Use them with caution.
 */
public class NotificationCreator extends Creator<Notification> {
    private final String pathServiceSid;
    private List<String> identity;
    private List<String> tag;
    private String body;
    private Notification.Priority priority;
    private Integer ttl;
    private String title;
    private String sound;
    private String action;
    private Map<String, Object> data;
    private Map<String, Object> apn;
    private Map<String, Object> gcm;
    private Map<String, Object> sms;
    private Map<String, Object> facebookMessenger;
    private Map<String, Object> fcm;
    private List<String> segment;
    private Map<String, Object> alexa;
    private List<String> toBinding;

    /**
     * Construct a new NotificationCreator.
     * 
     * @param pathServiceSid The service_sid
     */
    public NotificationCreator(final String pathServiceSid) {
        this.pathServiceSid = pathServiceSid;
    }

    /**
     * (optional for all except Alexa) Indicates the notification body text.
     * Translates to `data.twi_body` for FCM and GCM, `aps.alert.body` for APNS,
     * `Body` for SMS and Facebook Messenger and `request.message.data` for Alexa. 
     * For SMS either this, `body`, or the `media_url` attribute of the `Sms`
     * parameter is required.  For Facebook Messenger either this parameter or the
     * body attribute in the `FacebookMessenger` parameter is required..
     * 
     * @param body Indicates the notification body text.
     * @return this
     */
    public NotificationCreator setBody(final String body) {
        this.body = body;
        return this;
    }

    /**
     * Two priorities defined: `low` and `high` (default). `low` optimizes the
     * client app's battery consumption, and notifications may be delivered with
     * unspecified delay. This is the same as Normal priority for FCM and GCM or
     * priority 5 for APNS. `high` sends the notification immediately, and can wake
     * up a sleeping device. This is the same as High priority for FCM and GCM or
     * priority 10 for APNS.  This feature is not supported by SMS and Facebook
     * Messenger and will be ignored for deliveries via those channels..
     * 
     * @param priority Two priorities defined: low and high.
     * @return this
     */
    public NotificationCreator setPriority(final Notification.Priority priority) {
        this.priority = priority;
        return this;
    }

    /**
     * This parameter specifies how long (in seconds) the notification is valid.
     * Delivery should be attempted if the device is offline. The maximum time to
     * live supported is 4 weeks. The value zero means that the notification
     * delivery is attempted immediately once but not stored for future delivery.
     * The default value is 4 weeks.  This feature is not supported by SMS and
     * Facebook Messenger and will be ignored for deliveries via those channels..
     * 
     * @param ttl This parameter specifies how long the notification is valid.
     * @return this
     */
    public NotificationCreator setTtl(final Integer ttl) {
        this.ttl = ttl;
        return this;
    }

    /**
     * (optional for all except Alexa) Indicates the notification title. This field
     * is not visible on iOS phones and tablets but it is on Apple Watch and Android
     * devices. Translates to `data.twi_title` for FCM and GCM, `aps.alert.title`
     * for APNS and `displayInfo.content[0].title`,
     * `displayInfo.content[].toast.primaryText` of `request.message` for Alexa. It
     * is not supported for SMS and Facebook Messenger and will be omitted from
     * deliveries via those channels..
     * 
     * @param title Indicates the notification title.
     * @return this
     */
    public NotificationCreator setTitle(final String title) {
        this.title = title;
        return this;
    }

    /**
     * Indicates a sound to be played. Translates to `data.twi_sound` for FCM and
     * GCM and `aps.sound` for APNS.  This parameter is not supported by SMS and
     * Facebook Messenger and is omitted from deliveries via those channels..
     * 
     * @param sound Indicates a sound to be played.
     * @return this
     */
    public NotificationCreator setSound(final String sound) {
        this.sound = sound;
        return this;
    }

    /**
     * Specifies the actions to be displayed for the notification. Translates to
     * `data.twi_action` for GCM and `aps.category` for APNS.  This parameter is not
     * supported by SMS and Facebook Messenger and is omitted from deliveries via
     * those channels..
     * 
     * @param action Specifies the actions to be displayed for the notification.
     * @return this
     */
    public NotificationCreator setAction(final String action) {
        this.action = action;
        return this;
    }

    /**
     * This parameter specifies the custom key-value pairs of the notification's
     * payload. Translates to `data` dictionary in FCM and GCM payload. FCM and GCM
     * [reserves certain
     * keys](https://firebase.google.com/docs/cloud-messaging/http-server-ref) that
     * cannot be used for those channels. For APNS, attributes of `Data` will be
     * inserted into the APNS payload as custom properties outside of the `aps`
     * dictionary. For Alexa they are added to `request.message.data`. For all
     * channels, the `twi_` prefix is reserved for Twilio for future use. Requests
     * including custom data with keys starting with `twi_` will be rejected as 400
     * Bad request and no delivery will be attempted.  This parameter is not
     * supported by SMS and Facebook Messenger and is omitted from deliveries via
     * those channels..
     * 
     * @param data This parameter specifies the custom key-value pairs of the
     *             notification's payload.
     * @return this
     */
    public NotificationCreator setData(final Map<String, Object> data) {
        this.data = data;
        return this;
    }

    /**
     * APNS specific payload that overrides corresponding attributes in a generic
     * payload for Bindings with the apn BindingType. This value is mapped to the
     * Payload item, therefore the `aps` key has to be used to change standard
     * attributes. Adds custom key-value pairs to the root of the dictionary. Refer
     * to [APNS
     * documentation](https://developer.apple.com/library/content/documentation/NetworkingInternet/Conceptual/RemoteNotificationsPG/CommunicatingwithAPNs.html) for more details. The `twi_` key prefix for custom key-value pairs is reserved for Twilio for future use. Custom data with keys starting with `twi_` is not allowed..
     * 
     * @param apn APNS specific payload that overrides corresponding attributes in
     *            a generic payload for Bindings with the apn BindingType.
     * @return this
     */
    public NotificationCreator setApn(final Map<String, Object> apn) {
        this.apn = apn;
        return this;
    }

    /**
     * GCM specific payload that overrides corresponding attributes in generic
     * payload for Bindings with gcm BindingType.  This value is mapped to the root
     * json dictionary. Refer to [GCM
     * documentation](https://developers.google.com/cloud-messaging/http-server-ref)
     * for more details.  Target parameters `to`, `registration_ids`, and
     * `notification_key` are not allowed. The `twi_` key prefix for custom
     * key-value pairs is reserved for Twilio for future use. Custom data with keys
     * starting with `twi_` is not allowed. FCM and GCM [reserves certain
     * keys](https://firebase.google.com/docs/cloud-messaging/http-server-ref) that
     * cannot be used for those channels..
     * 
     * @param gcm GCM specific payload that overrides corresponding attributes in
     *            generic payload for Bindings with gcm BindingType.
     * @return this
     */
    public NotificationCreator setGcm(final Map<String, Object> gcm) {
        this.gcm = gcm;
        return this;
    }

    /**
     * SMS specific payload that overrides corresponding attributes in generic
     * payload for Bindings with sms BindingType.  Each attribute in this JSON
     * object is mapped to the corresponding form parameter of the Twilio
     * [Message](https://www.twilio.com/docs/api/rest/sending-messages) resource. 
     * The following parameters of the Message resource are supported in snake case
     * format: `body`, `media_urls`, `status_callback`, and `max_price`.  The
     * `status_callback` parameter overrides the corresponding parameter in the
     * messaging service if configured. The `media_urls` expects a JSON array..
     * 
     * @param sms SMS specific payload that overrides corresponding attributes in
     *            generic payload for Bindings with sms BindingType.
     * @return this
     */
    public NotificationCreator setSms(final Map<String, Object> sms) {
        this.sms = sms;
        return this;
    }

    /**
     * Messenger specific payload that overrides corresponding attributes in generic
     * payload for Bindings with facebook-messenger BindingType.  This value is
     * mapped to the root json dictionary of Facebook's [Send API
     * request](https://developers.facebook.com/docs/messenger-platform/send-api-reference).  Overriding the `recipient` parameter is not allowed..
     * 
     * @param facebookMessenger Messenger specific payload that overrides
     *                          corresponding attributes in generic payload for
     *                          Bindings with facebook-messenger BindingType.
     * @return this
     */
    public NotificationCreator setFacebookMessenger(final Map<String, Object> facebookMessenger) {
        this.facebookMessenger = facebookMessenger;
        return this;
    }

    /**
     * FCM specific payload that overrides corresponding attributes in generic
     * payload for Bindings with fcm BindingType.  This value is mapped to the root
     * json dictionary. Refer to [FCM
     * documentation](https://firebase.google.com/docs/cloud-messaging/http-server-ref#downstream) for more details.  Target parameters `to`, `registration_ids`, `condition`, and `notification_key` are not allowed. The `twi_` key prefix for custom key-value pairs is reserved for Twilio for future use. Custom data with keys starting with `twi_` is not allowed. Custom data with keys starting with `twi_` is not allowed. FCM and GCM [reserves certain keys](https://firebase.google.com/docs/cloud-messaging/http-server-ref) that cannot be used for those channels..
     * 
     * @param fcm FCM specific payload that overrides corresponding attributes in
     *            generic payload for Bindings with fcm BindingType.
     * @return this
     */
    public NotificationCreator setFcm(final Map<String, Object> fcm) {
        this.fcm = fcm;
        return this;
    }

    /**
     * The segment.
     * 
     * @param segment The segment
     * @return this
     */
    public NotificationCreator setSegment(final List<String> segment) {
        this.segment = segment;
        return this;
    }

    /**
     * The segment.
     * 
     * @param segment The segment
     * @return this
     */
    public NotificationCreator setSegment(final String segment) {
        return setSegment(Promoter.listOfOne(segment));
    }

    /**
     * The alexa.
     * 
     * @param alexa The alexa
     * @return this
     */
    public NotificationCreator setAlexa(final Map<String, Object> alexa) {
        this.alexa = alexa;
        return this;
    }

    /**
     * The destination address in a JSON object (see attributes below).  Multiple
     * ToBinding parameters can be included but the total size of the request entity
     * should not exceed 1MB. This is typically sufficient for 10,000 phone numbers.
     * .
     * 
     * @param toBinding The destination address in a JSON object.
     * @return this
     */
    public NotificationCreator setToBinding(final List<String> toBinding) {
        this.toBinding = toBinding;
        return this;
    }

    /**
     * The destination address in a JSON object (see attributes below).  Multiple
     * ToBinding parameters can be included but the total size of the request entity
     * should not exceed 1MB. This is typically sufficient for 10,000 phone numbers.
     * .
     * 
     * @param toBinding The destination address in a JSON object.
     * @return this
     */
    public NotificationCreator setToBinding(final String toBinding) {
        return setToBinding(Promoter.listOfOne(toBinding));
    }

    /**
     * Delivery will be attempted only to Bindings with an Identity in this list.
     * Maximum 20 items allowed in this list..
     * 
     * @param identity Delivery will be attempted only to Bindings with an Identity
     *                 in this list.
     * @return this
     */
    public NotificationCreator setIdentity(final List<String> identity) {
        this.identity = identity;
        return this;
    }

    /**
     * Delivery will be attempted only to Bindings with an Identity in this list.
     * Maximum 20 items allowed in this list..
     * 
     * @param identity Delivery will be attempted only to Bindings with an Identity
     *                 in this list.
     * @return this
     */
    public NotificationCreator setIdentity(final String identity) {
        return setIdentity(Promoter.listOfOne(identity));
    }

    /**
     * Delivery will be attempted only to Bindings that have all of the Tags in this
     * list. Maximum 5 items allowed in this list. The implicit tag "all" is
     * available to notify all Bindings in a Service instance. Similarly the
     * implicit tags "apn", "fcm", "gcm", "sms" and "facebook-messenger" are
     * available to notify all Bindings of the given type..
     * 
     * @param tag Delivery will be attempted only to Bindings that have all of the
     *            Tags in this list.
     * @return this
     */
    public NotificationCreator setTag(final List<String> tag) {
        this.tag = tag;
        return this;
    }

    /**
     * Delivery will be attempted only to Bindings that have all of the Tags in this
     * list. Maximum 5 items allowed in this list. The implicit tag "all" is
     * available to notify all Bindings in a Service instance. Similarly the
     * implicit tags "apn", "fcm", "gcm", "sms" and "facebook-messenger" are
     * available to notify all Bindings of the given type..
     * 
     * @param tag Delivery will be attempted only to Bindings that have all of the
     *            Tags in this list.
     * @return this
     */
    public NotificationCreator setTag(final String tag) {
        return setTag(Promoter.listOfOne(tag));
    }

    /**
     * Make the request to the Twilio API to perform the create.
     * 
     * @param client TwilioRestClient with which to make the request
     * @return Created Notification
     */
    @Override
    @SuppressWarnings("checkstyle:linelength")
    public Notification create(final TwilioRestClient client) {
        Request request = new Request(
            HttpMethod.POST,
            Domains.NOTIFY.toString(),
            "/v1/Services/" + this.pathServiceSid + "/Notifications",
            client.getRegion()
        );

        addPostParams(request);
        Response response = client.request(request);

        if (response == null) {
            throw new ApiConnectionException("Notification creation failed: Unable to connect to server");
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

        return Notification.fromJson(response.getStream(), client.getObjectMapper());
    }

    /**
     * Add the requested post parameters to the Request.
     * 
     * @param request Request to add post params to
     */
    private void addPostParams(final Request request) {
        if (identity != null) {
            for (String prop : identity) {
                request.addPostParam("Identity", prop);
            }
        }

        if (tag != null) {
            for (String prop : tag) {
                request.addPostParam("Tag", prop);
            }
        }

        if (body != null) {
            request.addPostParam("Body", body);
        }

        if (priority != null) {
            request.addPostParam("Priority", priority.toString());
        }

        if (ttl != null) {
            request.addPostParam("Ttl", ttl.toString());
        }

        if (title != null) {
            request.addPostParam("Title", title);
        }

        if (sound != null) {
            request.addPostParam("Sound", sound);
        }

        if (action != null) {
            request.addPostParam("Action", action);
        }

        if (data != null) {
            request.addPostParam("Data", Converter.mapToJson(data));
        }

        if (apn != null) {
            request.addPostParam("Apn", Converter.mapToJson(apn));
        }

        if (gcm != null) {
            request.addPostParam("Gcm", Converter.mapToJson(gcm));
        }

        if (sms != null) {
            request.addPostParam("Sms", Converter.mapToJson(sms));
        }

        if (facebookMessenger != null) {
            request.addPostParam("FacebookMessenger", Converter.mapToJson(facebookMessenger));
        }

        if (fcm != null) {
            request.addPostParam("Fcm", Converter.mapToJson(fcm));
        }

        if (segment != null) {
            for (String prop : segment) {
                request.addPostParam("Segment", prop);
            }
        }

        if (alexa != null) {
            request.addPostParam("Alexa", Converter.mapToJson(alexa));
        }

        if (toBinding != null) {
            for (String prop : toBinding) {
                request.addPostParam("ToBinding", prop);
            }
        }
    }
}