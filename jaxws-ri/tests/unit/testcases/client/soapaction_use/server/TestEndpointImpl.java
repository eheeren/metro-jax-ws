/*
 * Copyright (c) 1997, 2018 Oracle and/or its affiliates. All rights reserved.
 *
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Distribution License v. 1.0, which is available at
 * http://www.eclipse.org/org/documents/edl-v10.php.
 *
 * SPDX-License-Identifier: BSD-3-Clause
 */

package client.soapaction_use.server;

import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.soap.SOAPBinding;
import javax.xml.ws.WebServiceContext;
import javax.xml.ws.BindingProvider;
import javax.xml.ws.BindingType;
import javax.xml.ws.soap.Addressing;
import javax.xml.ws.handler.MessageContext;
import javax.annotation.Resource;
import java.util.Map;


/**
 * @author Rama Pulavarthi
 */
@SOAPBinding(parameterStyle = SOAPBinding.ParameterStyle.BARE)
@WebService(portName = "TestEndpointPort1", targetNamespace = "http://client.soapaction_use.server/", serviceName="TestEndpointService1", name="TestEndpoint1")//,
        //endpointInterface = "client.soapaction_use.server.TestEndpoint")
public class TestEndpointImpl {
    @Resource
    WebServiceContext wsContext;
    @WebMethod(action = "http://example.com/action/echoSOAPAction")
    public String echoSOAPAction(String msg) {
        MessageContext context = wsContext.getMessageContext();
        Map<java.lang.String, java.util.List<java.lang.String>> requestHeaders = (Map<java.lang.String, java.util.List<java.lang.String>>) context.get(MessageContext.HTTP_REQUEST_HEADERS);
        String s = requestHeaders.get("SOAPAction").get(0);
        return s;
    }


}
