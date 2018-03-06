/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package designassignment.dal;

import designassignment.be.Message;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

/**
 *
 * @author janvanzetten
 */
public class DALManagerXML implements DALFacade {

    @Override
    public Message sendMessage(String message) throws DALException {
        Message messageobject = new Message(message);
        
        try {

            File file = new File("/DesignAssignment/messagefile.xml");
            JAXBContext jaxbContext = JAXBContext.newInstance(Message.class);
            Marshaller jaxbMarshaller = jaxbContext.createMarshaller();

            // output pretty printed
            jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

            jaxbMarshaller.marshal(messageobject, file);
            jaxbMarshaller.marshal(messageobject, System.out);

        } catch (JAXBException ex) {
            Logger.getLogger(DALManagerXML.class.getName()).log(Level.SEVERE, null, ex);
        }
        return messageobject;
    }

    @Override
    public List<Message> getMessages() throws DALException {
        List<Message> list = new ArrayList<>();
        try {

		File file = new File("C:\\file.xml");
		JAXBContext jaxbContext = JAXBContext.newInstance(Message.class);

		Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
		Message message = (Message) jaxbUnmarshaller.unmarshal(file);
		System.out.println(message);
                list.add(message);

	  } catch (JAXBException e) {
	  }
        
        return list;
    }

}
