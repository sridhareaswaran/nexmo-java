/*
 * Copyright (c) 2011-2018 Nexmo Inc
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
package com.nexmo.client.conversion;

import org.apache.http.NameValuePair;
import org.apache.http.client.methods.RequestBuilder;
import org.apache.http.message.BasicNameValuePair;
import org.junit.Test;

import java.text.SimpleDateFormat;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class ConversionMethodTest {
    @Test
    public void testConstructParametersWithSms() throws Exception {
        ConversionMethod method = new ConversionMethod(null);
        ConversionRequest request = new ConversionRequest(ConversionRequest.Type.SMS,
                                                          "MESSAGE-ID",
                                                          true,
                                                          new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(
                                                                  "2014-03-04 10:11:12"));
        RequestBuilder requestBuilder = method.makeRequest(request);
        List<NameValuePair> params = requestBuilder.getParameters();

        assertContainsParam(params, "message-id", "MESSAGE-ID");
        assertContainsParam(params, "delivered", "true");
        assertContainsParam(params, "timestamp", "2014-03-04 10:11:12");
        assertEquals(method.getBaseUri() + ConversionRequest.Type.SMS.name().toLowerCase(),
                     requestBuilder.getUri().toString());
    }

    @Test
    public void testConstructParametersWithVoice() throws Exception {
        ConversionMethod method = new ConversionMethod(null);
        ConversionRequest request = new ConversionRequest(ConversionRequest.Type.VOICE,
                                                          "MESSAGE-ID",
                                                          true,
                                                          new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(
                                                                  "2014-03-04 10:11:12"));
        RequestBuilder requestBuilder = method.makeRequest(request);
        List<NameValuePair> params = requestBuilder.getParameters();

        assertContainsParam(params, "message-id", "MESSAGE-ID");
        assertContainsParam(params, "delivered", "true");
        assertContainsParam(params, "timestamp", "2014-03-04 10:11:12");
        assertEquals(method.getBaseUri() + ConversionRequest.Type.VOICE.name().toLowerCase(),
                     requestBuilder.getUri().toString());
    }

    private void assertContainsParam(List<NameValuePair> params, String key, String value) {
        NameValuePair item = new BasicNameValuePair(key, value);
        assertTrue("" + params + " should contain " + item, params.contains(item));
    }
}
