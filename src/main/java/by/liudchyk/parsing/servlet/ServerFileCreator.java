package by.liudchyk.parsing.servlet;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/**
 * Created by Admin on 26.11.2016.
 */
public class ServerFileCreator {
    private static final Logger LOG = LogManager.getLogger();

    public HashMap<String, String[]> createServerFile(HttpServletRequest request) {
        HashMap<String, String[]> requestParameters = new HashMap<String, String[]>();
        DiskFileItemFactory diskFileItemFactory = new DiskFileItemFactory();
        ServletFileUpload upload = new ServletFileUpload(diskFileItemFactory);
        List items = null;
        try {
            items = upload.parseRequest(request);
        } catch (FileUploadException e) {
            LOG.error(e);
        }
        Iterator iter = items.iterator();
        while (iter.hasNext()) {
            FileItem item = (FileItem) iter.next();
            if (item.isFormField()) {
                requestParameters.put(item.getFieldName(), new String[]{item.getString()});
            } else {
                byte[] data = item.get();
                FileOutputStream fos = null;
                try {
                    fos = new FileOutputStream(new File(request.getServletContext().getRealPath("") + "/data/candies.xml"));
                    fos.write(data, 0, data.length);
                } catch (FileNotFoundException e) {
                    LOG.error("File not found!"+e);
                } catch (IOException e) {
                    LOG.error(e);
                }
            }
        }
        return requestParameters;
    }
}
