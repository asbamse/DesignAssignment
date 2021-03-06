/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package designassignment.dal;

import designassignment.be.Message;
import designassignment.be.MessageWrapper;
import designassignment.be.User;
import java.io.File;
import java.io.IOException;
import java.security.MessageDigest;
import java.util.ArrayList;
import java.util.List;
import java.util.prefs.Preferences;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

/**
 *
 * @author Asbamz
 */
public class XML_DAO implements DAO
{
    private final String FILE_PATH = "test.xml";

    public XML_DAO()
    {
    }

    @Override
    public List<Message> getAllMessages() throws DALException
    {
        try
        {
            if (getFilePath() == null)
            {
                setFilePath(new File(FILE_PATH));
            }
        }
        catch (IOException ex)
        {
            throw new DALException(ex.getMessage(), ex.getCause());
        }

        List<Message> mesageData = new ArrayList<>();

        try
        {
            JAXBContext context = JAXBContext.newInstance(MessageWrapper.class);
            Unmarshaller um = context.createUnmarshaller();

            // Reading XML from the file and unmarshalling.
            MessageWrapper wrapper = (MessageWrapper) um.unmarshal(getFilePath());

            if (wrapper.getMessages() != null)
            {
                mesageData.addAll(wrapper.getMessages());
            }
        }
        catch (JAXBException | IOException ex)
        {
            ex.printStackTrace();
            throw new DALException(ex.getMessage(), ex.getCause());
        }

        return mesageData;
    }

    @Override
    public Message saveNewMessage(String message, User sender) throws DALException
    {

        List<Message> messages = new ArrayList<>();
        try
        {
            messages = getAllMessages();
        }
        catch (DALException ex)
        {

        }

        int id = 0;
        int userId = 0;
        if (messages.size() > 0)
        {
            id = messages.get(messages.size() - 1).getId();
            userId = messages.get(messages.size() - 1).getUserId();
        }

        Message messageobject = new Message(id, message, userId);
        messages.add(messageobject);

        saveMessagesToXML(messages);

        return messageobject;
    }

    @Override
    public void deleteMessage(Message thisMessage) throws DALException
    {

        List<Message> messages = new ArrayList<>();
        try
        {
            messages = getAllMessages();
        }
        catch (DALException ex)
        {

        }

        messages.remove(thisMessage);

        saveMessagesToXML(messages);
    }

    private void saveMessagesToXML(List<Message> messages) throws DALException
    {
        try
        {
            JAXBContext context = JAXBContext.newInstance(MessageWrapper.class);
            Marshaller m = context.createMarshaller();
            m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

            // Wrapping our person data.
            MessageWrapper wrapper = new MessageWrapper();
            wrapper.setMessages(messages);

            // Marshalling and saving XML to the file.
            m.marshal(wrapper, getFilePath());
        }
        catch (JAXBException | IOException ex)
        {
            ex.printStackTrace();
            throw new DALException(ex.getMessage(), ex.getCause());
        }
    }

    /**
     * Returns the person file preference, i.e. the file that was last opened.
     * The preference is read from the OS specific registry. If no such
     * preference can be found, null is returned.
     *
     * @return
     */
    public File getFilePath() throws IOException
    {
        Preferences prefs = Preferences.userNodeForPackage(XML_DAO.class);
        String filePath = prefs.get("filePath", null);
        if (filePath != null)
        {
            File file = new File(filePath);
            file.createNewFile(); // if file already exists will do nothing
            return file;
        }
        else
        {
            return null;
        }
    }

    /**
     * Sets the file path of the currently loaded file. The path is persisted in
     * the OS specific registry.
     *
     * @param file the file or null to remove the path
     */
    public void setFilePath(File file) throws IOException
    {
        file.createNewFile(); // if file already exists will do nothing
        Preferences prefs = Preferences.userNodeForPackage(XML_DAO.class);
        if (file != null)
        {
            prefs.put("filePath", file.getPath());
        }
        else
        {
            prefs.remove("filePath");
        }
    }

    @Override
    public User addUser(String Name, String Email, String password) throws DALException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public User login(String Email, String password) throws DALException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<User> getAllUsers() throws DALException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
