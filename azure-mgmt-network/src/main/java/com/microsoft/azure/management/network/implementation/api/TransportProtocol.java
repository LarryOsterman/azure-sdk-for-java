/**
 * Copyright (c) Microsoft Corporation. All rights reserved.
 * Licensed under the MIT License. See License.txt in the project root for
 * license information.
 */

package com.microsoft.azure.management.network.implementation.api;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

/**
 * Defines values for TransportProtocol.
 */
public class TransportProtocol {
    /** Static value Udp for TransportProtocol. */
    public static final String UDP = "Udp";

    /** Static value Tcp for TransportProtocol. */
    public static final String TCP = "Tcp";

}
