/**
 * Copyright (c) 2010-2020 Contributors to the openHAB project
 *
 * See the NOTICE file(s) distributed with this work for additional
 * information.
 *
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0
 *
 * SPDX-License-Identifier: EPL-2.0
 */
package org.openhab.core.io.rest.sse.internal;

/**
 * A DTO class holding the state of an item, and its version suitable for display.
 *
 * @author Yannick Schaus - Initial contribution
 */
public class StateDTO {
    public String state;
    public String displayState;

    public StateDTO() {
    }
}