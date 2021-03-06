/**
 * Copyright (c) Microsoft Corporation. All rights reserved.
 * Licensed under the MIT License. See License.txt in the project root for
 * license information.
 *
 * Code generated by Microsoft (R) AutoRest Code Generator.
 * def
 */

package com.microsoft.azure.management.cosmosdb.v2020_03_01.implementation;

import com.microsoft.azure.arm.resources.collection.implementation.GroupableResourcesCoreImpl;
import com.microsoft.azure.management.cosmosdb.v2020_03_01.DatabaseAccounts;
import com.microsoft.azure.management.cosmosdb.v2020_03_01.DatabaseAccountGetResults;
import rx.Observable;
import rx.Completable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import com.microsoft.azure.arm.resources.ResourceUtilsCore;
import com.microsoft.azure.arm.utils.RXMapper;
import rx.functions.Func1;
import com.microsoft.azure.PagedList;
import com.microsoft.azure.Page;
import com.microsoft.azure.management.cosmosdb.v2020_03_01.DatabaseAccountListKeysResult;
import com.microsoft.azure.management.cosmosdb.v2020_03_01.DatabaseAccountListConnectionStringsResult;
import com.microsoft.azure.management.cosmosdb.v2020_03_01.DatabaseAccountListReadOnlyKeysResult;
import java.util.List;
import com.microsoft.azure.management.cosmosdb.v2020_03_01.FailoverPolicy;
import com.microsoft.azure.management.cosmosdb.v2020_03_01.KeyKind;
import com.microsoft.azure.management.cosmosdb.v2020_03_01.DatabaseAccountMetric;
import com.microsoft.azure.management.cosmosdb.v2020_03_01.DatabaseAccountUsage;
import com.microsoft.azure.management.cosmosdb.v2020_03_01.DatabaseAccountMetricDefinition;

class DatabaseAccountsImpl extends GroupableResourcesCoreImpl<DatabaseAccountGetResults, DatabaseAccountGetResultsImpl, DatabaseAccountGetResultsInner, DatabaseAccountsInner, CosmosDBManager>  implements DatabaseAccounts {
    protected DatabaseAccountsImpl(CosmosDBManager manager) {
        super(manager.inner().databaseAccounts(), manager);
    }

    @Override
    protected Observable<DatabaseAccountGetResultsInner> getInnerAsync(String resourceGroupName, String name) {
        DatabaseAccountsInner client = this.inner();
        return client.getByResourceGroupAsync(resourceGroupName, name);
    }

    @Override
    protected Completable deleteInnerAsync(String resourceGroupName, String name) {
        DatabaseAccountsInner client = this.inner();
        return client.deleteAsync(resourceGroupName, name).toCompletable();
    }

    @Override
    public Observable<String> deleteByIdsAsync(Collection<String> ids) {
        if (ids == null || ids.isEmpty()) {
            return Observable.empty();
        }
        Collection<Observable<String>> observables = new ArrayList<>();
        for (String id : ids) {
            final String resourceGroupName = ResourceUtilsCore.groupFromResourceId(id);
            final String name = ResourceUtilsCore.nameFromResourceId(id);
            Observable<String> o = RXMapper.map(this.inner().deleteAsync(resourceGroupName, name), id);
            observables.add(o);
        }
        return Observable.mergeDelayError(observables);
    }

    @Override
    public Observable<String> deleteByIdsAsync(String...ids) {
        return this.deleteByIdsAsync(new ArrayList<String>(Arrays.asList(ids)));
    }

    @Override
    public void deleteByIds(Collection<String> ids) {
        if (ids != null && !ids.isEmpty()) {
            this.deleteByIdsAsync(ids).toBlocking().last();
        }
    }

    @Override
    public void deleteByIds(String...ids) {
        this.deleteByIds(new ArrayList<String>(Arrays.asList(ids)));
    }

    @Override
    public PagedList<DatabaseAccountGetResults> listByResourceGroup(String resourceGroupName) {
        DatabaseAccountsInner client = this.inner();
        return this.wrapList(client.listByResourceGroup(resourceGroupName));
    }

    @Override
    public Observable<DatabaseAccountGetResults> listByResourceGroupAsync(String resourceGroupName) {
        DatabaseAccountsInner client = this.inner();
        return client.listByResourceGroupAsync(resourceGroupName)
        .flatMap(new Func1<Page<DatabaseAccountGetResultsInner>, Observable<DatabaseAccountGetResultsInner>>() {
            @Override
            public Observable<DatabaseAccountGetResultsInner> call(Page<DatabaseAccountGetResultsInner> innerPage) {
                return Observable.from(innerPage.items());
            }
        })
        .map(new Func1<DatabaseAccountGetResultsInner, DatabaseAccountGetResults>() {
            @Override
            public DatabaseAccountGetResults call(DatabaseAccountGetResultsInner inner) {
                return wrapModel(inner);
            }
        });
    }

    @Override
    public PagedList<DatabaseAccountGetResults> list() {
        DatabaseAccountsInner client = this.inner();
        return this.wrapList(client.list());
    }

    @Override
    public Observable<DatabaseAccountGetResults> listAsync() {
        DatabaseAccountsInner client = this.inner();
        return client.listAsync()
        .flatMap(new Func1<Page<DatabaseAccountGetResultsInner>, Observable<DatabaseAccountGetResultsInner>>() {
            @Override
            public Observable<DatabaseAccountGetResultsInner> call(Page<DatabaseAccountGetResultsInner> innerPage) {
                return Observable.from(innerPage.items());
            }
        })
        .map(new Func1<DatabaseAccountGetResultsInner, DatabaseAccountGetResults>() {
            @Override
            public DatabaseAccountGetResults call(DatabaseAccountGetResultsInner inner) {
                return wrapModel(inner);
            }
        });
    }

    @Override
    public DatabaseAccountGetResultsImpl define(String name) {
        return wrapModel(name);
    }

    @Override
    public Completable failoverPriorityChangeAsync(String resourceGroupName, String accountName, List<FailoverPolicy> failoverPolicies) {
        DatabaseAccountsInner client = this.inner();
        return client.failoverPriorityChangeAsync(resourceGroupName, accountName, failoverPolicies).toCompletable();
    }

    @Override
    public Observable<DatabaseAccountListKeysResult> listKeysAsync(String resourceGroupName, String accountName) {
        DatabaseAccountsInner client = this.inner();
        return client.listKeysAsync(resourceGroupName, accountName)
        .map(new Func1<DatabaseAccountListKeysResultInner, DatabaseAccountListKeysResult>() {
            @Override
            public DatabaseAccountListKeysResult call(DatabaseAccountListKeysResultInner inner) {
                return new DatabaseAccountListKeysResultImpl(inner, manager());
            }
        });
    }

    @Override
    public Observable<DatabaseAccountListConnectionStringsResult> listConnectionStringsAsync(String resourceGroupName, String accountName) {
        DatabaseAccountsInner client = this.inner();
        return client.listConnectionStringsAsync(resourceGroupName, accountName)
        .map(new Func1<DatabaseAccountListConnectionStringsResultInner, DatabaseAccountListConnectionStringsResult>() {
            @Override
            public DatabaseAccountListConnectionStringsResult call(DatabaseAccountListConnectionStringsResultInner inner) {
                return new DatabaseAccountListConnectionStringsResultImpl(inner, manager());
            }
        });
    }

    @Override
    public Completable offlineRegionAsync(String resourceGroupName, String accountName, String region) {
        DatabaseAccountsInner client = this.inner();
        return client.offlineRegionAsync(resourceGroupName, accountName, region).toCompletable();
    }

    @Override
    public Completable onlineRegionAsync(String resourceGroupName, String accountName, String region) {
        DatabaseAccountsInner client = this.inner();
        return client.onlineRegionAsync(resourceGroupName, accountName, region).toCompletable();
    }

    @Override
    public Observable<DatabaseAccountListReadOnlyKeysResult> listReadOnlyKeysAsync(String resourceGroupName, String accountName) {
        DatabaseAccountsInner client = this.inner();
        return client.listReadOnlyKeysAsync(resourceGroupName, accountName)
        .map(new Func1<DatabaseAccountListReadOnlyKeysResultInner, DatabaseAccountListReadOnlyKeysResult>() {
            @Override
            public DatabaseAccountListReadOnlyKeysResult call(DatabaseAccountListReadOnlyKeysResultInner inner) {
                return new DatabaseAccountListReadOnlyKeysResultImpl(inner, manager());
            }
        });
    }

    @Override
    public Completable regenerateKeyAsync(String resourceGroupName, String accountName, KeyKind keyKind) {
        DatabaseAccountsInner client = this.inner();
        return client.regenerateKeyAsync(resourceGroupName, accountName, keyKind).toCompletable();
    }

    @Override
    protected DatabaseAccountGetResultsImpl wrapModel(DatabaseAccountGetResultsInner inner) {
        return  new DatabaseAccountGetResultsImpl(inner.name(), inner, manager());
    }

    @Override
    protected DatabaseAccountGetResultsImpl wrapModel(String name) {
        return new DatabaseAccountGetResultsImpl(name, new DatabaseAccountGetResultsInner(), this.manager());
    }

    private DatabaseAccountMetricImpl wrapDatabaseAccountMetricModel(MetricInner inner) {
        return  new DatabaseAccountMetricImpl(inner, manager());
    }

    private DatabaseAccountUsageImpl wrapDatabaseAccountUsageModel(UsageInner inner) {
        return  new DatabaseAccountUsageImpl(inner, manager());
    }

    private DatabaseAccountMetricDefinitionImpl wrapDatabaseAccountMetricDefinitionModel(MetricDefinitionInner inner) {
        return  new DatabaseAccountMetricDefinitionImpl(inner, manager());
    }

    @Override
    public Observable<DatabaseAccountListReadOnlyKeysResult> getReadOnlyKeysAsync(String resourceGroupName, String accountName) {
        DatabaseAccountsInner client = this.inner();
        return client.getReadOnlyKeysAsync(resourceGroupName, accountName)
        .map(new Func1<DatabaseAccountListReadOnlyKeysResultInner, DatabaseAccountListReadOnlyKeysResult>() {
            @Override
            public DatabaseAccountListReadOnlyKeysResult call(DatabaseAccountListReadOnlyKeysResultInner inner) {
                return new DatabaseAccountListReadOnlyKeysResultImpl(inner, manager());
            }
        });
    }

    @Override
    public Observable<Boolean> checkNameExistsAsync(String accountName) {
        DatabaseAccountsInner client = this.inner();
        return client.checkNameExistsAsync(accountName)
    ;}

    @Override
    public Observable<DatabaseAccountMetric> listMetricsAsync(String resourceGroupName, String accountName, String filter) {
        DatabaseAccountsInner client = this.inner();
        return client.listMetricsAsync(resourceGroupName, accountName, filter)
        .flatMap(new Func1<List<MetricInner>, Observable<MetricInner>>() {
            @Override
            public Observable<MetricInner> call(List<MetricInner> innerList) {
                return Observable.from(innerList);
            }
        })
        .map(new Func1<MetricInner, DatabaseAccountMetric>() {
            @Override
            public DatabaseAccountMetric call(MetricInner inner) {
                return wrapDatabaseAccountMetricModel(inner);
            }
        });
    }

    @Override
    public Observable<DatabaseAccountUsage> listUsagesAsync(String resourceGroupName, String accountName) {
        DatabaseAccountsInner client = this.inner();
        return client.listUsagesAsync(resourceGroupName, accountName)
        .flatMap(new Func1<List<UsageInner>, Observable<UsageInner>>() {
            @Override
            public Observable<UsageInner> call(List<UsageInner> innerList) {
                return Observable.from(innerList);
            }
        })
        .map(new Func1<UsageInner, DatabaseAccountUsage>() {
            @Override
            public DatabaseAccountUsage call(UsageInner inner) {
                return wrapDatabaseAccountUsageModel(inner);
            }
        });
    }

    @Override
    public Observable<DatabaseAccountMetricDefinition> listMetricDefinitionsAsync(String resourceGroupName, String accountName) {
        DatabaseAccountsInner client = this.inner();
        return client.listMetricDefinitionsAsync(resourceGroupName, accountName)
        .flatMap(new Func1<List<MetricDefinitionInner>, Observable<MetricDefinitionInner>>() {
            @Override
            public Observable<MetricDefinitionInner> call(List<MetricDefinitionInner> innerList) {
                return Observable.from(innerList);
            }
        })
        .map(new Func1<MetricDefinitionInner, DatabaseAccountMetricDefinition>() {
            @Override
            public DatabaseAccountMetricDefinition call(MetricDefinitionInner inner) {
                return wrapDatabaseAccountMetricDefinitionModel(inner);
            }
        });
    }

}
