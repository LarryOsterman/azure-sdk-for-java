// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.

package com.azure.storage.blob.batch;

import com.azure.core.annotation.ServiceClientBuilder;
import com.azure.core.http.HttpPipeline;
import com.azure.storage.blob.BlobContainerAsyncClient;
import com.azure.storage.blob.BlobContainerClient;
import com.azure.storage.blob.BlobServiceAsyncClient;
import com.azure.storage.blob.BlobServiceClient;
import com.azure.storage.blob.BlobServiceVersion;

/**
 * This class provides a fluent builder API to help aid the configuration and instantiation of {@link BlobBatchClient
 * BlobBatchClients} and {@link BlobBatchAsyncClient BlobBatchAsyncClients} when {@link #buildClient() buildClient} and
 * {@link #buildAsyncClient() buildAsyncClient} as called respectively.
 */
@ServiceClientBuilder(serviceClients = {BlobBatchClient.class, BlobBatchAsyncClient.class})
public final class BlobBatchClientBuilder {
    private final String clientUrl;
    private final HttpPipeline pipeline;
    private final BlobServiceVersion version;
    private final boolean containerScoped;

    /**
     * Constructs the {@link BlobBatchClientBuilder} using the {@link BlobServiceClient#getAccountUrl() account URL} and
     * {@link BlobServiceClient#getHttpPipeline() HttpPipeline} properties of the passed {@link BlobServiceClient}.
     *
     * @param client {@link BlobServiceClient} whose properties are used to configure the builder.
     */
    public BlobBatchClientBuilder(BlobServiceClient client) {
        this.clientUrl = client.getAccountUrl();
        this.pipeline = client.getHttpPipeline();
        this.version = client.getServiceVersion();
        this.containerScoped = false;
    }

    /**
     * Constructs the {@link BlobBatchClientBuilder} using the {@link BlobServiceAsyncClient#getAccountUrl() account
     * URL} and {@link BlobServiceAsyncClient#getHttpPipeline() HttpPipeline} properties of the passed {@link
     * BlobServiceAsyncClient}.
     *
     * @param client {@link BlobServiceAsyncClient} whose properties are used to configure the builder.
     */
    public BlobBatchClientBuilder(BlobServiceAsyncClient client) {
        this.clientUrl = client.getAccountUrl();
        this.pipeline = client.getHttpPipeline();
        this.version = client.getServiceVersion();
        this.containerScoped = false;
    }

    /**
     * Constructs the {@link BlobBatchClientBuilder} using the {@link BlobContainerClient#getBlobContainerUrl()
     * container URL} and {@link BlobContainerClient#getHttpPipeline() HttpPipeline} properties of the passed
     * {@link BlobContainerClient}.
     *
     * @param client {@link BlobContainerClient} whose properties are used to configure the builder.
     */
    public BlobBatchClientBuilder(BlobContainerClient client) {
        this.clientUrl = client.getBlobContainerUrl();
        this.pipeline = client.getHttpPipeline();
        this.version = client.getServiceVersion();
        this.containerScoped = true;
    }

    /**
     * Constructs the {@link BlobBatchClientBuilder} using the {@link BlobContainerAsyncClient#getBlobContainerUrl()
     * container URL} and {@link BlobContainerAsyncClient#getHttpPipeline() HttpPipeline} properties of the
     * passed {@link BlobContainerAsyncClient}.
     *
     * @param client {@link BlobContainerAsyncClient} whose properties are used to configure the builder.
     */
    public BlobBatchClientBuilder(BlobContainerAsyncClient client) {
        this.clientUrl = client.getBlobContainerUrl();
        this.pipeline = client.getHttpPipeline();
        this.version = client.getServiceVersion();
        this.containerScoped = true;
    }

    /**
     * Creates a {@link BlobBatchClient} based on options set in the builder.
     *
     * <p><strong>Code sample</strong></p>
     *
     * {@codesnippet com.azure.storage.blob.batch.BlobBatchClientBuilder#buildClient}
     *
     * @return a {@link BlobBatchClient} created from the configurations in this builder.
     */
    public BlobBatchClient buildClient() {
        return new BlobBatchClient(buildAsyncClient());
    }

    /**
     * Creates a {@link BlobBatchAsyncClient} based on options set in the builder.
     *
     * <p><strong>Code sample</strong></p>
     *
     * {@codesnippet com.azure.storage.blob.batch.BlobBatchClientBuilder#buildAsyncClient}
     *
     * @return a {@link BlobBatchAsyncClient} created from the configurations in this builder.
     */
    public BlobBatchAsyncClient buildAsyncClient() {
        BlobServiceVersion serviceVersion = version != null ? version : BlobServiceVersion.getLatest();
        return new BlobBatchAsyncClient(clientUrl, pipeline, serviceVersion, containerScoped);
    }
}
