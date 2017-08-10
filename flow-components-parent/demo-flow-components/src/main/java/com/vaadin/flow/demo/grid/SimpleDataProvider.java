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
package com.vaadin.flow.demo.grid;

import java.util.function.BiFunction;
import java.util.function.Supplier;
import java.util.stream.Stream;

/**
 * POC data provider interface.
 * 
 * @param <T>
 *            type of the items provided
 */
public interface SimpleDataProvider<T> {

    /**
     * The total number of available data items.
     * 
     * @return the total number of available data items
     */
    int size();

    /**
     * 
     * @param page
     * @param pageSize
     * @return
     */
    Stream<T> fetch(int page, int pageSize);

    /**
     * 
     * @param sizeCallback
     * @param fetchCallback
     * @return
     */
    static <T> SimpleDataProvider<T> fromCallbacks(
            Supplier<Integer> sizeCallback,
            BiFunction<Integer, Integer, Stream<T>> fetchCallback) {
        return new SimpleDataProvider<T>() {

            @Override
            public int size() {
                return sizeCallback.get();
            }

            @Override
            public Stream<T> fetch(int page, int pageSize) {
                return fetchCallback.apply(page, pageSize);
            }
        };
    }
}
