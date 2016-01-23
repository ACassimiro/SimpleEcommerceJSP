package PDFServlet;

import java.io.*;
import java.util.Date;
import java.util.Random;
import java.lang.*;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


// Document Object
import com.itextpdf.text.Document;
//For adding content into PDF document
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;
import com.itextpdf.text.DocumentException;


public class PDFServlet extends HttpServlet {



    //invoked from doGet method to create PDF through servlet 
protected void processRequest(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
    //Set content type to application / pdf
    //browser will open the document only if this is set
    response.setContentType("application/pdf");
    //Get the output stream for writing PDF object        
    OutputStream out=response.getOutputStream();
    try {
        Document document = new Document();
        /* Basic PDF Creation inside servlet */
        PdfWriter.getInstance(document, out);
        document.open();
        String firstname=request.getParameter("FirstName");
        String lastname=request.getParameter("LastName");
        String phone=request.getParameter("PhoneNumber");
        String email=request.getParameter("Email");
        document.add(new Paragraph("This is a confirmation reciept"));
        document.add(new Paragraph(new Date().toString()));
        Random randomGenerator = new Random();
        int randomInt = Math.abs(randomGenerator.nextInt());
        document.add(new Paragraph("Confirmation #: " + randomInt));
        document.add(new Paragraph("Name: " + firstname + " " + lastname));
        document.add(new Paragraph(" "));
        document.add(new Paragraph("Phone Number: " + phone));
        document.add(new Paragraph(" "));
        document.add(new Paragraph("Email: " + email));
        document.close();
    }
            catch (DocumentException exc){
            throw new IOException(exc.getMessage());
            }
    finally {            
        out.close();
    }
}
@Override
protected void doGet(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
    processRequest(request, response);
}
@Override
protected void doPost(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
    processRequest(request, response);
}

@Override
public String getServletInfo() {
    return "This Servlet Generates PDF Using iText Library";
}
}