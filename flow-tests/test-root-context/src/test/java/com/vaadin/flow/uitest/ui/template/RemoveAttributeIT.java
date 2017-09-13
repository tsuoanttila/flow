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
package com.vaadin.flow.uitest.ui.template;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.vaadin.flow.testutil.ChromeBrowserTest;

public class RemoveAttributeIT extends ChromeBrowserTest {

    @Test
    public void checkAttributeWasRemoved() {
        open();

        waitForElementPresent(By.tagName("remove-attribute"));

        WebElement root = findElement(By.tagName("remove-attribute"));
        List<WebElement> list = findInShadowRoot(root, By.id("div"));
        Assert.assertEquals(1, list.size());

        WebElement div = list.get(0);
        String attribute = div.getAttribute("someAttribute");
        Assert.assertNull(attribute);
    }

}
