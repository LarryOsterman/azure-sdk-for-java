/**
 * Copyright (c) Microsoft Corporation. All rights reserved.
 * Licensed under the MIT License. See License.txt in the project root for
 * license information.
 *
 * Code generated by Microsoft (R) AutoRest Code Generator.
 */

package com.microsoft.azure.management.azurestackhci.v2020_10_01.implementation;

import com.microsoft.azure.arm.resources.models.implementation.GroupableResourceCoreImpl;
import com.microsoft.azure.management.azurestackhci.v2020_10_01.Cluster;
import rx.Observable;
import com.microsoft.azure.management.azurestackhci.v2020_10_01.ProvisioningState;
import com.microsoft.azure.management.azurestackhci.v2020_10_01.Status;
import com.microsoft.azure.management.azurestackhci.v2020_10_01.ClusterReportedProperties;
import org.joda.time.DateTime;

class ClusterImpl extends GroupableResourceCoreImpl<Cluster, ClusterInner, ClusterImpl, AzureStackHCIManager> implements Cluster, Cluster.Definition, Cluster.Update {
    ClusterImpl(String name, ClusterInner inner, AzureStackHCIManager manager) {
        super(name, inner, manager);
    }

    @Override
    public Observable<Cluster> createResourceAsync() {
        ClustersInner client = this.manager().inner().clusters();
        return client.createAsync(this.resourceGroupName(), this.name(), this.inner())
            .map(innerToFluentMap(this));
    }

    @Override
    public Observable<Cluster> updateResourceAsync() {
        ClustersInner client = this.manager().inner().clusters();
        return client.createAsync(this.resourceGroupName(), this.name(), this.inner())
            .map(innerToFluentMap(this));
    }

    @Override
    protected Observable<ClusterInner> getInnerAsync() {
        ClustersInner client = this.manager().inner().clusters();
        return client.getByResourceGroupAsync(this.resourceGroupName(), this.name());
    }

    @Override
    public boolean isInCreateMode() {
        return this.inner().id() == null;
    }


    @Override
    public String aadClientId() {
        return this.inner().aadClientId();
    }

    @Override
    public String aadTenantId() {
        return this.inner().aadTenantId();
    }

    @Override
    public String billingModel() {
        return this.inner().billingModel();
    }

    @Override
    public String cloudId() {
        return this.inner().cloudId();
    }

    @Override
    public DateTime lastBillingTimestamp() {
        return this.inner().lastBillingTimestamp();
    }

    @Override
    public DateTime lastSyncTimestamp() {
        return this.inner().lastSyncTimestamp();
    }

    @Override
    public ProvisioningState provisioningState() {
        return this.inner().provisioningState();
    }

    @Override
    public DateTime registrationTimestamp() {
        return this.inner().registrationTimestamp();
    }

    @Override
    public ClusterReportedProperties reportedProperties() {
        return this.inner().reportedProperties();
    }

    @Override
    public Status status() {
        return this.inner().status();
    }

    @Override
    public Double trialDaysRemaining() {
        return this.inner().trialDaysRemaining();
    }

    @Override
    public ClusterImpl withAadClientId(String aadClientId) {
        this.inner().withAadClientId(aadClientId);
        return this;
    }

    @Override
    public ClusterImpl withAadTenantId(String aadTenantId) {
        this.inner().withAadTenantId(aadTenantId);
        return this;
    }

    @Override
    public ClusterImpl withReportedProperties(ClusterReportedProperties reportedProperties) {
        this.inner().withReportedProperties(reportedProperties);
        return this;
    }

}
