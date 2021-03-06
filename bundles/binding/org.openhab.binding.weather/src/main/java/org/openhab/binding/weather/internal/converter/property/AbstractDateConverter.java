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
package org.openhab.binding.weather.internal.converter.property;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

import org.openhab.binding.weather.internal.converter.Converter;

/**
 * Base date converter class with a date pattern.
 *
 * @author Gerhard Riegler
 * @since 1.6.0
 */
public abstract class AbstractDateConverter implements Converter<Calendar> {

    private DateFormat DATE_PATTERN;

    /**
     * Creates a DateConverter with the specified pattern.
     */
    public AbstractDateConverter(String pattern) {
        DATE_PATTERN = new SimpleDateFormat(pattern, Locale.ENGLISH);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Calendar convert(String value) throws ParseException {
        Calendar cal = Calendar.getInstance();
        Date date = DATE_PATTERN.parse(value);
        cal.setTime(date);
        return cal;
    }

}
