/**
 * Copyright (c) Microsoft Corporation. All rights reserved.
 * Licensed under the MIT License. See License.txt in the project root for
 * license information.
 *
 * Code generated by Microsoft (R) AutoRest Code Generator.
 */

package com.microsoft.azure.management.databox.v2019_09_01;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

/**
 * Defines values for NotificationStageName.
 */
public enum NotificationStageName {
    /** Notification at device prepared stage. */
    DEVICE_PREPARED("DevicePrepared"),

    /** Notification at device dispatched stage. */
    DISPATCHED("Dispatched"),

    /** Notification at device delivered stage. */
    DELIVERED("Delivered"),

    /** Notification at device picked up from user stage. */
    PICKED_UP("PickedUp"),

    /** Notification at device received at azure datacenter stage. */
    AT_AZURE_DC("AtAzureDC"),

    /** Notification at data copy started stage. */
    DATA_COPY("DataCopy");

    /** The actual serialized value for a NotificationStageName instance. */
    private String value;

    NotificationStageName(String value) {
        this.value = value;
    }

    /**
     * Parses a serialized value to a NotificationStageName instance.
     *
     * @param value the serialized value to parse.
     * @return the parsed NotificationStageName object, or null if unable to parse.
     */
    @JsonCreator
    public static NotificationStageName fromString(String value) {
        NotificationStageName[] items = NotificationStageName.values();
        for (NotificationStageName item : items) {
            if (item.toString().equalsIgnoreCase(value)) {
                return item;
            }
        }
        return null;
    }

    @JsonValue
    @Override
    public String toString() {
        return this.value;
    }
}
