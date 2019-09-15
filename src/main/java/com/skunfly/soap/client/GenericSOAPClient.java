package com.skunfly.soap.client;

import org.springframework.oxm.jaxb.Jaxb2Marshaller;
import org.springframework.ws.client.core.support.WebServiceGatewaySupport;
import org.springframework.ws.soap.client.core.SoapActionCallback;

public class GenericSOAPClient extends WebServiceGatewaySupport {

    public GenericSOAPClient(Jaxb2Marshaller marshaller, String defaultUri) {
        this.setMarshaller(marshaller);

        this.setUnmarshaller(marshaller);

        this.setDefaultUri(defaultUri);
    }

    public Object sendAndReceive(Object request, String soapAction) {

        SoapActionCallback soapActionCallback = null;

        if (soapAction != null) soapActionCallback = new SoapActionCallback(soapAction);

        return getWebServiceTemplate().marshalSendAndReceive(request, soapActionCallback);
    }

}
