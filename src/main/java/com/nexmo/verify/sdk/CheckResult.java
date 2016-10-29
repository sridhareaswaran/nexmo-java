package com.nexmo.verify.sdk;
/*
 * Copyright (c) 2011-2016 Nexmo Inc
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */

/**
 * Verification check result.
 *
 * @author Daniele Ricci
 */
public class CheckResult extends BaseResult {

    private static final long serialVersionUID = 8468662117199934412L;

    private final String eventId;
    private final float price;
    private final String currency;

    public CheckResult(final int status,
                          final String eventId,
                          final float price,
                          final String currency,
                          final String errorText,
                          final boolean temporaryError) {
        super(status, errorText, temporaryError);
        this.eventId = eventId;
        this.price = price;
        this.currency = currency;
    }

    public String getEventId() {
        return this.eventId;
    }

    public float getPrice() {
        return this.price;
    }

    public String getCurrency() {
        return this.currency;
    }

}
