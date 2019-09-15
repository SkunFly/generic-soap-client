# Generic SOAP Client

This demo project defines a generic soap client using spring and JAXB2 plugin
to generate the POJO classes from a wsdl.

The pom.xml can define various profiles with different wsdl endpoint for the same
soap service.

For example a weather forecast service was used: http://wsf.cdyne.com/WeatherWS/Weather.asmx?WSDL 