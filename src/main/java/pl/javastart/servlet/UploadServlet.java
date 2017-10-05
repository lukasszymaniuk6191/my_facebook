package pl.javastart.servlet;
import java.io.File;
import java.io.IOException;
import java.nio.file.LinkOption;
import java.nio.file.Path;
import java.nio.file.Paths;

import javax.inject.Inject;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import pl.javastart.model.UserPhotos;
import pl.javastart.repository.UserRepository;

@WebServlet("/UploadServlet")
@MultipartConfig(fileSizeThreshold=1024*1024*2, // 2MB
                 maxFileSize=1024*1024*10,      // 10MB
                 maxRequestSize=1024*1024*50)   // 50MB
public class UploadServlet extends HttpServlet {
    /**
     * Name of the directory where uploaded files will be saved, relative to
     * the web application directory.
     */
    private static final String SAVE_DIR = "images";
    
    @Inject
    private UserRepository userRepository;
    /**
     * handles file upload
     */
    protected void doPost(HttpServletRequest request,
            HttpServletResponse response) throws ServletException, IOException {
        // gets absolute path of the web application
 
    	String appPath = "/home/lszym/Pulpit/Java/nowy_eclipse/projekty/moj_facebook";
    	String savePath =  appPath + File.separator + "src" + File.separator + "main" + File.separator + "webapp" + File.separator + SAVE_DIR;

        // creates the save directory if it does not exists
        File fileSaveDir = new File(savePath);
        if (!fileSaveDir.exists()) {
            fileSaveDir.mkdir();
        }
        
        //UserPhotos userPhotos = new UserPhotos();
        //String login = (String) request.getAttribute("login");
        //String password = request.getParameter("password");
        
        HttpSession httpSession = request.getSession();
        String login = (String) httpSession.getAttribute("login");
        String password = (String) httpSession.getAttribute("password");
         
     
        
        for (Part part : request.getParts()) {
            String fileName = extractFileName(part);
            // refines the fileName in case it is an absolute path
            System.out.println("UploadServlet(): login: "+login+" password: "+password+" filename: "+fileName);
            UserPhotos userPhoto = new UserPhotos(login,password,fileName);
            userRepository.addPhoto(userPhoto);
            fileName = new File(fileName).getName();
            part.write(savePath + File.separator + fileName);
        }
        
        //request.getRequestDispatcher("html/login_page.jsp").include(request,response);
        //request.setAttribute("message", "Upload has been done successfully!");
        //getServletContext().getRequestDispatcher("/message.jsp").forward(request, response);
    }
    /**
     * Extracts file name from HTTP header content-disposition
     */
    private String extractFileName(Part part) {
        String contentDisp = part.getHeader("content-disposition");
        String[] items = contentDisp.split(";");
        for (String s : items) {
            if (s.trim().startsWith("filename")) {
                return s.substring(s.indexOf("=") + 2, s.length()-1);
            }
        }
        return "";
    }
}