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

package org.apache.shardingsphere.encrypt.rewrite.condition.impl;

import org.apache.shardingsphere.sql.parser.statement.core.segment.dml.expr.ExpressionSegment;
import org.apache.shardingsphere.sql.parser.statement.core.segment.dml.expr.simple.LiteralExpressionSegment;
import org.apache.shardingsphere.sql.parser.statement.core.segment.dml.expr.simple.ParameterMarkerExpressionSegment;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.mockito.Mockito.mock;

class EncryptInConditionTest {
    
    @Test
    void assertNewInstance() {
        List<ExpressionSegment> expressions = Arrays.asList(new ParameterMarkerExpressionSegment(0, 0, 0), new LiteralExpressionSegment(0, 0, 1),
                new ParameterMarkerExpressionSegment(0, 0, 1), mock(ExpressionSegment.class));
        EncryptInCondition actual = new EncryptInCondition("foo_col", null, 0, 0, expressions);
        assertThat(actual.getPositionIndexMap().size(), is(2));
        assertThat(actual.getPositionIndexMap().get(0), is(0));
        assertThat(actual.getPositionIndexMap().get(2), is(1));
        assertThat(actual.getPositionValueMap().size(), is(1));
        assertThat(actual.getPositionValueMap().get(1), is(1));
    }
}
