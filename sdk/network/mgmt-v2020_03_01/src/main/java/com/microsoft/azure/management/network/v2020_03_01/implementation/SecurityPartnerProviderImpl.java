/**
 * Copyright (c) Microsoft Corporation. All rights reserved.
 * Licensed under the MIT License. See License.txt in the project root for
 * license information.
 *
 * Code generated by Microsoft (R) AutoRest Code Generator.
 */

package com.microsoft.azure.management.network.v2020_03_01.implementation;

import com.microsoft.azure.arm.resources.models.implementation.GroupableResourceCoreImpl;
import com.microsoft.azure.management.network.v2020_03_01.SecurityPartnerProvider;
import rx.Observable;
import com.microsoft.azure.management.network.v2020_03_01.ProvisioningState;
import com.microsoft.azure.management.network.v2020_03_01.SecurityProviderName;
import com.microsoft.azure.management.network.v2020_03_01.SecurityPartnerProviderConnectionStatus;
import com.microsoft.azure.SubResource;

class SecurityPartnerProviderImpl extends GroupableResourceCoreImpl<SecurityPartnerProvider, SecurityPartnerProviderInner, SecurityPartnerProviderImpl, NetworkManager> implements SecurityPartnerProvider, SecurityPartnerProvider.Definition, SecurityPartnerProvider.Update {
    SecurityPartnerProviderImpl(String name, SecurityPartnerProviderInner inner, NetworkManager manager) {
        super(name, inner, manager);
    }

    @Override
    public Observable<SecurityPartnerProvider> createResourceAsync() {
        SecurityPartnerProvidersInner client = this.manager().inner().securityPartnerProviders();
        return client.createOrUpdateAsync(this.resourceGroupName(), this.name(), this.inner())
            .map(innerToFluentMap(this));
    }

    @Override
    public Observable<SecurityPartnerProvider> updateResourceAsync() {
        SecurityPartnerProvidersInner client = this.manager().inner().securityPartnerProviders();
        return client.createOrUpdateAsync(this.resourceGroupName(), this.name(), this.inner())
            .map(innerToFluentMap(this));
    }

    @Override
    protected Observable<SecurityPartnerProviderInner> getInnerAsync() {
        SecurityPartnerProvidersInner client = this.manager().inner().securityPartnerProviders();
        return client.getByResourceGroupAsync(this.resourceGroupName(), this.name());
    }

    @Override
    public boolean isInCreateMode() {
        return this.inner().id() == null;
    }


    @Override
    public SecurityPartnerProviderConnectionStatus connectionStatus() {
        return this.inner().connectionStatus();
    }

    @Override
    public String etag() {
        return this.inner().etag();
    }

    @Override
    public ProvisioningState provisioningState() {
        return this.inner().provisioningState();
    }

    @Override
    public SecurityProviderName securityProviderName() {
        return this.inner().securityProviderName();
    }

    @Override
    public SubResource virtualHub() {
        return this.inner().virtualHub();
    }

    @Override
    public SecurityPartnerProviderImpl withSecurityProviderName(SecurityProviderName securityProviderName) {
        this.inner().withSecurityProviderName(securityProviderName);
        return this;
    }

    @Override
    public SecurityPartnerProviderImpl withVirtualHub(SubResource virtualHub) {
        this.inner().withVirtualHub(virtualHub);
        return this;
    }

}