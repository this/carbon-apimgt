/*
 * Copyright (c) 2017, WSO2 Inc. (http://www.wso2.org) All Rights Reserved.
 *
 * WSO2 Inc. licenses this file to you under the Apache License,
 * Version 2.0 (the "License"); you may not use this file except
 * in compliance with the License.
 * You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */
package org.wso2.carbon.apimgt.ballerina.util;

import org.ballerinalang.bre.Context;
import org.ballerinalang.model.types.TypeEnum;
import org.ballerinalang.model.values.BInteger;
import org.ballerinalang.model.values.BValue;
import org.ballerinalang.natives.AbstractNativeFunction;
import org.ballerinalang.natives.annotations.Argument;
import org.ballerinalang.natives.annotations.Attribute;
import org.ballerinalang.natives.annotations.BallerinaAnnotation;
import org.ballerinalang.natives.annotations.BallerinaFunction;
import org.ballerinalang.natives.annotations.ReturnType;
import org.ballerinalang.util.exceptions.BallerinaException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Native function org.wso2.carbon.apimgt.ballerina.util.Wait.{@link Wait}
 * This function used to make util in bal program
 *
 * @since 0.10-SNAPSHOT
 */
@BallerinaFunction(
        packageName = "org.wso2.carbon.apimgt.ballerina.util",
        functionName = "wait",
        args = {@Argument(name = "value ", type = TypeEnum.INT)},
        returnType = {@ReturnType(type = TypeEnum.INT)},
        isPublic = true
)
@BallerinaAnnotation(annotationName = "Description", attributes = {@Attribute(name = "value",
        value = "Program for apply wait")})
@BallerinaAnnotation(annotationName = "Param", attributes = {@Attribute(name = "value",
        value = "time for wait in milliseconds")})
@BallerinaAnnotation(annotationName = "Return", attributes = {@Attribute(name = "string",
        value = "wait Status")})
public class Wait extends AbstractNativeFunction {

    private static final Logger log = LoggerFactory.getLogger(Wait.class);

    @Override
    public BValue[] execute(Context context) {
        BInteger value = (BInteger) getArgument(context, 0);
        try {
            Thread.sleep(value.intValue());
            return new BValue[] {new BInteger(0)};
        } catch (Throwable e) {
            throw new BallerinaException("Couldn't wait for expected time : " + value.intValue());
        }
    }
}

