/**
 * Copyright (c) Microsoft Corporation. All rights reserved.
 * Licensed under the MIT License. See License.txt in the project root for
 * license information.
 */

package com.microsoft.azure.management.network.implementation.api;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

/**
 * Defines values for ExpressRouteCircuitPeeringState.
 */
public class ExpressRouteCircuitPeeringState {
    /** Static value Disabled for ExpressRouteCircuitPeeringState. */
    public static final String DISABLED = "Disabled";

    /** Static value Enabled for ExpressRouteCircuitPeeringState. */
    public static final String ENABLED = "Enabled";

}
