package com.sce.model.servlet.writepdresponse;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import java.io.*;

/**
 * Created by Andre on 06/06/2016.
 */
public class ReportHelp {
    public static void writePdfResponse(HttpServletResponse response, String pdfout) throws IOException {
        response.setContentType("text/html;charset=UTF-8");

        ServletOutputStream outs = response.getOutputStream();
        response.setContentType("application/pdf");  // MIME type for pdf doc

        File file = new File(pdfout);

        response.setHeader("Content-disposition", "inline; filename=" + file.getName());

        BufferedInputStream bis = null;
        BufferedOutputStream bos = null;
        try {

            InputStream isr = new FileInputStream(file);
            bis = new BufferedInputStream(isr);
            bos = new BufferedOutputStream(outs);
            byte[] buff = new byte[2048];
            int bytesRead;
            while (-1 != (bytesRead = bis.read(buff, 0, buff.length))) {
                bos.write(buff, 0, bytesRead);
            }
        } catch (Exception e) {
            System.out.println("Exception ----- Message ---" + e);
        } finally {
            if (bis != null)
                bis.close();
            if (bos != null)
                bos.close();
        }
    }
}
