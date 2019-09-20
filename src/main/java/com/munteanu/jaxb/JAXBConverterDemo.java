package com.munteanu.jaxb;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.adapters.XmlAdapter;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import javax.xml.namespace.NamespaceContext;
import javax.xml.stream.XMLOutputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamWriter;
import java.io.StringWriter;

public class JAXBConverterDemo {

//  private static CDATAAdapter adapter = new CDATAAdapter();

  public static void main(String[] args) throws XMLStreamException, JAXBException {

    MyXmlRequest request = new MyXmlRequest();
    request.setData("my data");

    JAXBContext context = JAXBContext.newInstance(MyXmlRequest.class);
    Marshaller m = context.createMarshaller();
    m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

    // #1
//    m.setAdapter(adapter);
//    m.marshal(request, System.out);

    // #2
    StringWriter writer = new StringWriter();
    XMLOutputFactory xof = XMLOutputFactory.newInstance();
    XMLStreamWriter streamWriter = xof.createXMLStreamWriter(writer);
    CDataXMLStreamWriter cdataStreamWriter = new CDataXMLStreamWriter( streamWriter );
    m.marshal(request, cdataStreamWriter);

    System.out.println("RES: " + writer.toString());
  }
}


/*
output when @XmlJavaTypeAdapter(CDATAAdapter.class) without CDataXMLStreamWriter is used:

<?xml version="1.0" encoding="UTF-8" standalone="yes"?>
<request>
    <data>&lt;![CDATA[my data]]&gt;</data>
</request>
 */

@XmlRootElement(name = "request")
@XmlAccessorType(XmlAccessType.FIELD)
class MyXmlRequest {

  @XmlElement(name = "data")
  @XmlJavaTypeAdapter(CDATAAdapter.class)
  private String data;

  public MyXmlRequest() {

  }

  public String getData() {
    return data;
  }

  public void setData(String data) {
    this.data = data;
  }
}

class CDATAAdapter extends XmlAdapter<String, String> {

  private static final String CDATA_BEGIN = "<![CDATA[";
  private static final String CDATA_END = "]]>";

  @Override
  public String unmarshal(String val) throws Exception {
    if (val.startsWith(CDATA_BEGIN) && val.endsWith(CDATA_END)) {
      val = val.substring(CDATA_BEGIN.length(), val.length() - CDATA_END.length());
    }
    return val;
  }

  @Override
  public String marshal(String val) throws Exception {
    return CDATA_BEGIN + val + CDATA_END;
  }
}

class CDataXMLStreamWriter extends DelegatingXMLStreamWriter {

  private static final String CDATA_BEGIN = "<![CDATA[";
  private static final String CDATA_END = "]]>";

  public CDataXMLStreamWriter(XMLStreamWriter del) {
    super(del);
  }

  @Override
  public void writeCharacters(String text) throws XMLStreamException {
    if (text.startsWith(CDATA_BEGIN) && text.endsWith(CDATA_END)) {
      text = text.substring(CDATA_BEGIN.length(), text.length() - CDATA_END.length());
      super.writeCData(text);
    } else {
      super.writeCharacters(text);
    }
  }
}

abstract class DelegatingXMLStreamWriter implements XMLStreamWriter
{
  private final XMLStreamWriter writer;

  public DelegatingXMLStreamWriter( XMLStreamWriter writer )
  {
    this.writer = writer;
  }

  public void writeStartElement( String localName ) throws XMLStreamException
  {
    writer.writeStartElement( localName );
  }

  public void writeStartElement( String namespaceURI, String localName ) throws XMLStreamException
  {
    writer.writeStartElement( namespaceURI, localName );
  }

  public void writeStartElement( String prefix, String localName, String namespaceURI ) throws XMLStreamException
  {
    writer.writeStartElement( prefix, localName, namespaceURI );
  }

  public void writeEmptyElement( String namespaceURI, String localName ) throws XMLStreamException
  {
    writer.writeEmptyElement( namespaceURI, localName );
  }

  public void writeEmptyElement( String prefix, String localName, String namespaceURI ) throws XMLStreamException
  {
    writer.writeEmptyElement( prefix, localName, namespaceURI );
  }

  public void writeEmptyElement( String localName ) throws XMLStreamException
  {
    writer.writeEmptyElement( localName );
  }

  public void writeEndElement() throws XMLStreamException
  {
    writer.writeEndElement();
  }

  public void writeEndDocument() throws XMLStreamException
  {
    writer.writeEndDocument();
  }

  public void close() throws XMLStreamException
  {
    writer.close();
  }

  public void flush() throws XMLStreamException
  {
    writer.flush();
  }

  public void writeAttribute( String localName, String value ) throws XMLStreamException
  {
    writer.writeAttribute( localName, value );
  }

  public void writeAttribute( String prefix, String namespaceURI, String localName, String value )
      throws XMLStreamException
  {
    writer.writeAttribute( prefix, namespaceURI, localName, value );
  }

  public void writeAttribute( String namespaceURI, String localName, String value ) throws XMLStreamException
  {
    writer.writeAttribute( namespaceURI, localName, value );
  }

  public void writeNamespace( String prefix, String namespaceURI ) throws XMLStreamException
  {
    writer.writeNamespace( prefix, namespaceURI );
  }

  public void writeDefaultNamespace( String namespaceURI ) throws XMLStreamException
  {
    writer.writeDefaultNamespace( namespaceURI );
  }

  public void writeComment( String data ) throws XMLStreamException
  {
    writer.writeComment( data );
  }

  public void writeProcessingInstruction( String target ) throws XMLStreamException
  {
    writer.writeProcessingInstruction( target );
  }

  public void writeProcessingInstruction( String target, String data ) throws XMLStreamException
  {
    writer.writeProcessingInstruction( target, data );
  }

  public void writeCData( String data ) throws XMLStreamException
  {
    writer.writeCData( data );
  }

  public void writeDTD( String dtd ) throws XMLStreamException
  {
    writer.writeDTD( dtd );
  }

  public void writeEntityRef( String name ) throws XMLStreamException
  {
    writer.writeEntityRef( name );
  }

  public void writeStartDocument() throws XMLStreamException
  {
    writer.writeStartDocument();
  }

  public void writeStartDocument( String version ) throws XMLStreamException
  {
    writer.writeStartDocument( version );
  }

  public void writeStartDocument( String encoding, String version ) throws XMLStreamException
  {
    writer.writeStartDocument( encoding, version );
  }

  public void writeCharacters( String text ) throws XMLStreamException
  {
    writer.writeCharacters( text );
  }

  public void writeCharacters( char[] text, int start, int len ) throws XMLStreamException
  {
    writer.writeCharacters( text, start, len );
  }

  public String getPrefix( String uri ) throws XMLStreamException
  {
    return writer.getPrefix( uri );
  }

  public void setPrefix( String prefix, String uri ) throws XMLStreamException
  {
    writer.setPrefix( prefix, uri );
  }

  public void setDefaultNamespace( String uri ) throws XMLStreamException
  {
    writer.setDefaultNamespace( uri );
  }

  public void setNamespaceContext( NamespaceContext context ) throws XMLStreamException
  {
    writer.setNamespaceContext( context );
  }

  public NamespaceContext getNamespaceContext()
  {
    return writer.getNamespaceContext();
  }

  public Object getProperty( String name ) throws IllegalArgumentException
  {
    return writer.getProperty( name );
  }
}