/**
 * Copyright 2015 Amazon.com, Inc. or its affiliates. All Rights Reserved.
 *
 * You may not use this file except in compliance with the License. A copy of the License is located the "LICENSE.txt"
 * file accompanying this source. This file is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied. See the License for the specific language governing permissions and limitations
 * under the License.
 */
package com.amazon.alexa.avs;

import org.slf4j.Logger;

import java.util.Set;

public class SimpleStateChangeTransition<E> extends StateTransition<E> {

    private final E endState;

    private final Logger errorLogger;

    public SimpleStateChangeTransition(Set<E> validStartStates, E endState, Logger errorLogger) {
        super(validStartStates);
        this.endState = endState;
        this.errorLogger = errorLogger;
    }

    @Override
    protected final void onTransition(State<E> state) {
        state.set(endState);
    }

    @Override
    protected final void onInvalidStartState(State<E> currentState) {
        errorLogger.debug("Invalid {} from {}.", this.getClass().getSimpleName(),
                currentState.get());
    }
}
