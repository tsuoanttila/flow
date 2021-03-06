/*
 * Copyright 2000-2017 Vaadin Ltd.
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not
 * use this file except in compliance with the License. You may obtain a copy of
 * the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations under
 * the License.
 */
package com.vaadin.flow.router;

import com.vaadin.flow.component.UI;

/**
 * Event created before navigation happens.
 *
 * @author Vaadin Ltd
 */
public class BeforeEnterEvent extends BeforeEvent {

    /**
     * Construct event from a NavigationEvent.
     *
     * @param event
     *            NavigationEvent that is on going
     * @param navigationTarget
     *            Navigation target
     */
    public BeforeEnterEvent(NavigationEvent event, Class<?> navigationTarget) {
        super(event, navigationTarget);
    }

    /**
     * Constructs a new BeforeNavigation Event.
     *
     * @param router
     *            the router that triggered the change, not {@code null}
     * @param trigger
     *            the type of user action that triggered this location change,
     *            not <code>null</code>
     * @param location
     *            the new location, not {@code null}
     * @param navigationTarget
     *            navigation target class
     * @param ui
     *            the UI related to the navigation
     */
    public BeforeEnterEvent(Router router, NavigationTrigger trigger,
            Location location, Class<?> navigationTarget, UI ui) {
        super(router, trigger, location, navigationTarget, ui);
    }
}
