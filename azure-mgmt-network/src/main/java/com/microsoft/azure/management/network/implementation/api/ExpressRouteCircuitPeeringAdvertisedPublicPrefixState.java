/**
 * Copyright (c) Microsoft Corporation. All rights reserved.
 * Licensed under the MIT License. See License.txt in the project root for
 * license information.
 */

package com.microsoft.azure.management.network.implementation.api;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

/**
 * Defines values for ExpressRouteCircuitPeeringAdvertisedPublicPrefixState.
 */
public class ExpressRouteCircuitPeeringAdvertisedPublicPrefixState {
    /** Static value NotConfigured for ExpressRouteCircuitPeeringAdvertisedPublicPrefixState. */
    public static final String NOTCONFIGURED = "NotConfigured";

    /** Static value Configuring for ExpressRouteCircuitPeeringAdvertisedPublicPrefixState. */
    public static final String CONFIGURING = "Configuring";

    /** Static value Configured for ExpressRouteCircuitPeeringAdvertisedPublicPrefixState. */
    public static final String CONFIGURED = "Configured";

    /** Static value ValidationNeeded for ExpressRouteCircuitPeeringAdvertisedPublicPrefixState. */
    public static final String VALIDATIONNEEDED = "ValidationNeeded";

}
