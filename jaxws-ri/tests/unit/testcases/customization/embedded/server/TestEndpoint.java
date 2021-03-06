/*
 * Copyright (c) 1997, 2018 Oracle and/or its affiliates. All rights reserved.
 *
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Distribution License v. 1.0, which is available at
 * http://www.eclipse.org/org/documents/edl-v10.php.
 *
 * SPDX-License-Identifier: BSD-3-Clause
 */

package customization.embedded.server;

import javax.jws.WebService;
import javax.xml.ws.Holder;

/**
 * @author Vivek Pandey
 */
@WebService(
        serviceName = "CustomService",
        endpointInterface = "customization.embedded.server.HelloWorld"
)
public class TestEndpoint {
    public void helloWorld(Holder<String> helloArgument, Holder<java.lang.String> helloExtra) {
        helloArgument.value += " World!";
        helloExtra.value += " Fine!";
    }

    public FooResponse echoFoo(Foo fooRequest) throws
            FooException {
        FooResponse resp = new FooResponse();
        resp.setFooResponse1(fooRequest.getFooChild1() + " " + fooRequest.getFooChild2());
        return resp;
    }

    public void voidTest() {

    }

}
