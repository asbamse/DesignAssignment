/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package designassignment.dal;

import designassignment.be.Message;
import designassignment.be.MessageWrapper;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.prefs.Preferences;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

/**
 *
 * @author janvanzetten
 */
public class DALManagerXML implements DALFacade {

    private File file;

    public DALManagerXML() {
        Preferences prefs = Preferences.userNodeForPackage(DALManagerXML.class);
        String filePath = prefs.get("filePath", null);
        if (filePath != null) {
            file = new File(filePath);
        } else {
            file = null;
        }
    }

    @Override
    public Message sendMessage(String message) throws DALException {
        Message messageobject = new Message(message);
        List<Message> messages = getMessages();
        messages.add(messageobject);
        

        try {
            JAXBContext context = JAXBContext
                    .newInstance(MessageWrapper.class);
            Marshaller m = context.createMarshaller();
            m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

            // Wrapping our person data.
            MessageWrapper wrapper = new MessageWrapper();
            wrapper.setPersons(messages);

            // Marshalling and saving XML to the file.
            m.marshal(wrapper, file);

            // Save the file path to the registry.
            setPersonFilePath(file);
        } catch (Exception e) { // catches ANY exception
            e.printStackTrace();
        }

        return messageobject;
    }

    @Override
    public List<Message> getMessages() throws DALException {
        List<Message> mesageData = new ArrayList<>();
        
        if (file == null){
            return mesageData;
        }
        
        try {
            JAXBContext context = JAXBContext
                    .newInstance(MessageWrapper.class);
            Unmarshaller um = context.createUnmarshaller();

            // Reading XML from the file and unmarshalling.
            MessageWrapper wrapper = (MessageWrapper) um.unmarshal(file);

            mesageData.clear();
            mesageData.addAll(wrapper.getMessages());

            // Save the file path to the registry.
            setPersonFilePath(file);

        } catch (Exception e) { // catches ANY exception
            e.printStackTrace();

        }

        return mesageData;

    }

    /**
     * Sets the file path of the currently loaded file. The path is persisted in
     * the OS specific registry.
     *
     * @param file the file or null to remove the path
     */
    public void setPersonFilePath(File file) {
        Preferences prefs = Preferences.userNodeForPackage(DALManagerXML.class);
        if (file != null) {
            prefs.put("filePath", file.getPath());

        } else {
            prefs.remove("filePath");

        }
    }

}
