package Controladores;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Image;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.sql.DriverManager;
import java.sql.ResultSet;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author olmag
 */
@WebServlet(urlPatterns = {"/pdf"})
public class pdf extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
           
            throws ServletException, IOException {
       
        response.setContentType("application/pdf");
        OutputStream out = response.getOutputStream();
        
//        String nombre=request.getParameter("Txtn");
        
        try {
            
            try {
                Connection con = null;
                Statement st = null;
                ResultSet rs = null;
                
                Class.forName("com.mysql.jdbc.Driver");
                con= (Connection)DriverManager.getConnection("jdbc:mysql://localhost:3306/siproyecto","root","");
//                st=(Statement) con.createStatement();
//                rs= st.executeQuery("SELECT * FROM vista_historial_alarma WHERE Taller='"+nombre+"'");
                
                if (con!=null) {
                    
            try {
                Document documento = new Document();
                PdfWriter.getInstance(documento, out);
                
                documento.open();
              
                
//               Image imagenes = Image.getInstance("C:\\Users\\olmag\\OneDrive\\Pictures\\NOMBRE_LOGO.gif");
//               imagenes.setAlignment(Element.ALIGN_CENTER);
//               documento.add(imagenes);
               
               Paragraph par1 = new Paragraph();
                Font fonttitulo = new Font(Font.FontFamily.HELVETICA,16,Font.BOLD,BaseColor.BLUE);
                par1.add(new Phrase("Histotial de Alarmas",fonttitulo));
                par1.setAlignment(Element.ALIGN_CENTER);
                par1.add(new Phrase(Chunk.NEWLINE));
                par1.add(new Phrase(Chunk.NEWLINE));
                documento.add(par1);
               
                PdfPTable tabla = new PdfPTable(5);
                
                PdfPCell celda1 = new PdfPCell(new Paragraph("Historial",FontFactory.getFont("Arial",12,Font.BOLD,BaseColor.RED)));
                PdfPCell celda2 = new PdfPCell(new Paragraph("Alarma",FontFactory.getFont("Arial",12,Font.BOLD,BaseColor.RED)));            
                PdfPCell celda3 = new PdfPCell(new Paragraph("Taller",FontFactory.getFont("Arial",12,Font.BOLD,BaseColor.RED)));
                PdfPCell celda4 = new PdfPCell(new Paragraph("Telefono",FontFactory.getFont("Arial",12,Font.BOLD,BaseColor.RED)));            
                PdfPCell celda5 = new PdfPCell(new Paragraph("Costo",FontFactory.getFont("Arial",12,Font.BOLD,BaseColor.RED)));
                
                tabla.addCell(celda1);
                tabla.addCell(celda2);
                tabla.addCell(celda3);
                tabla.addCell(celda4);
                tabla.addCell(celda5);
                
                while (rs.next()) {
                tabla.addCell(rs.getString(1));                
                tabla.addCell(rs.getString(2));       
                tabla.addCell(rs.getString(3));
                tabla.addCell(rs.getString(4));       
                tabla.addCell(rs.getString(5));
                
                    
                }
                
                documento.add(tabla);
                
               
                documento.close();
            } catch (Exception ex) {
                ex.getMessage();
            }
                }
                
            } catch (Exception ex) {
                ex.getMessage();
            }
            
        }
        finally{
            out.close();
        }
    }
}
