/*
 * Copyright 2010-2017 Amazon.com, Inc. or its affiliates. All Rights Reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License").
 * You may not use this file except in compliance with the License.
 * A copy of the License is located at
 *
 *  http://aws.amazon.com/apache2.0
 *
 * or in the "license" file accompanying this file. This file is distributed
 * on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either
 * express or implied. See the License for the specific language governing
 * permissions and limitations under the License.
 */

package software.amazon.awssdk.services.lambda.invoke;

import software.amazon.awssdk.annotation.SdkProtectedApi;
import software.amazon.awssdk.util.ValidationUtils;

/**
 * Configuration for {@link LambdaInvokerFactory} to override default behavior.
 *
 * @deprecated Use {@link LambdaInvokerFactory#builder()} to configure invoker factory.
 */
@Deprecated
public class LambdaInvokerFactoryConfig {

    private final String functionAlias;
    private final String functionVersion;
    private LambdaFunctionNameResolver lambdaFunctionNameResolver;

    /**
     * @deprecated Use {@link LambdaInvokerFactory#builder()} to configure invoker factory.
     */
    @Deprecated
    public LambdaInvokerFactoryConfig() {
        this(new DefaultLambdaFunctionNameResolver(), null, null);
    }

    @SdkProtectedApi
    LambdaInvokerFactoryConfig(LambdaFunctionNameResolver lambdaFunctionNameResolver,
                               String functionAlias,
                               String functionVersion) {
        this.lambdaFunctionNameResolver = lambdaFunctionNameResolver;
        this.functionAlias = functionAlias;
        this.functionVersion = functionVersion;
    }

    public LambdaFunctionNameResolver getLambdaFunctionNameResolver() {
        return lambdaFunctionNameResolver;
    }

    public String getFunctionAlias() {
        return functionAlias;
    }

    public String getFunctionVersion() {
        return functionVersion;
    }

    /**
     * Sets a new Function name resolver to override the default behavior.
     *
     * @param functionNameResolver Implementation of {@link LambdaFunctionNameResolver}
     * @return The current object for method chaining
     * @deprecated Use {@link LambdaInvokerFactory#builder()} to configure invoker factory.
     */
    @Deprecated
    public LambdaInvokerFactoryConfig withLambdaFunctionNameResolver(
            LambdaFunctionNameResolver functionNameResolver) {
        this.lambdaFunctionNameResolver = ValidationUtils
                .assertNotNull(functionNameResolver, "functionNameResolver");
        return this;
    }

}
