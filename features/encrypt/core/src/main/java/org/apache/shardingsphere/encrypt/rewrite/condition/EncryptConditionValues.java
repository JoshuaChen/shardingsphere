/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.apache.shardingsphere.encrypt.rewrite.condition;

import lombok.RequiredArgsConstructor;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

/**
 * Encrypt condition values.
 */
@RequiredArgsConstructor
public final class EncryptConditionValues {
    
    private final Map<Integer, Integer> positionIndexMap;
    
    private final Map<Integer, Object> positionValueMap;
    
    /**
     * Get values.
     *
     * @param params parameters
     * @return values
     */
    public List<Object> getValues(final List<Object> params) {
        List<Object> result = new ArrayList<>(positionValueMap.values());
        for (Entry<Integer, Integer> entry : positionIndexMap.entrySet()) {
            Object param = params.get(entry.getValue());
            if (entry.getKey() < result.size()) {
                result.add(entry.getKey(), param);
            } else {
                result.add(param);
            }
        }
        return result;
    }
}
