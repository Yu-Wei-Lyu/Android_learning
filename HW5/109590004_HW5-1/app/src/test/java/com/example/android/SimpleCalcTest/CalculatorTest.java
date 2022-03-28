/*
 * Copyright 2018, Google Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.example.android.SimpleCalcTest;

import android.test.suitebuilder.annotation.SmallTest;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

/**
 * JUnit4 unit tests for the calculator logic.
 * These are local unit tests; no device needed.
 */
@RunWith(JUnit4.class)
@SmallTest
public class CalculatorTest {

    private Calculator mCalculator;

    /**
     * Sets up the environment for testing.
     */
    @Before
    public void setUp() {
        mCalculator = new Calculator();
    }

    @Test
    public void powPositiveNumbers() {
        double resultPow = mCalculator.pow(5d, 3d);
        assertThat(resultPow, is(equalTo(125d)));
    }

    @Test
    public void powNegativeFirstNumbers() {
        double resultPow = mCalculator.pow(-5d, 3d);
        assertThat(resultPow, is(equalTo(-125d)));
    }

    @Test
    public void powNegativeSecondNumbers() {
        double resultPow = mCalculator.pow(5d, -2d);
        assertThat(resultPow, is(equalTo(0.04d)));
    }

    @Test
    public void powZeroFirstNumbers() {
        double resultPow = mCalculator.pow(0d, 8d);
        assertThat(resultPow, is(equalTo(0d)));
    }

    @Test
    public void powZeroSecondNumbers() {
        double resultPow = mCalculator.pow(8d, 0d);
        assertThat(resultPow, is(equalTo(1d)));
    }

    @Test
    public void powZeroFirstNegativeOneSecondNumbers() {
        double resultPow = mCalculator.pow(0d, -1d);
        assertThat(resultPow, is(equalTo(Double.POSITIVE_INFINITY)));
    }

    @Test
    public void powZeroFirstNegativeAnySecondNumbers() {
        double resultPow = mCalculator.pow(-0d, -314159d);
        assertThat(resultPow, is(equalTo(Double.POSITIVE_INFINITY)));
    }


}