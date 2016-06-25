package com.sce.model.servlet;

import com.sce.model.domain.NotaFiscal;
import com.sce.model.service.NotaFiscalService;
import com.sce.model.servlet.writepdresponse.ReportHelp;
import com.sce.model.wrapper.NotaFiscalXml;
import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.engine.query.JRXPathQueryExecuterFactory;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.engine.util.JRXmlUtils;
import org.w3c.dom.Document;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import java.io.*;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Andre on 05/06/2016.
 */
public class ReportItensEntradaServlet extends HttpServlet {

    @Inject
    private NotaFiscalService notaFiscalService;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {

            List<NotaFiscal> notaFiscais = notaFiscalService.getNotasFiscaisEntrada();

            NotaFiscalXml notaFiscalXml = new NotaFiscalXml();

            notaFiscalXml.setNotaFiscalList(notaFiscais);

            JAXBContext context;
            context = JAXBContext.newInstance(NotaFiscalXml.class);
            Marshaller marshaller = context.createMarshaller();
            BufferedWriter out = new BufferedWriter(new OutputStreamWriter(
                    new FileOutputStream("C:\\Workspace\\SCE\\web\\xmls\\notasfiscaisEntrada.xml"), "UTF-8"
            ));
            marshaller.marshal(notaFiscalXml, out);

            String jasperReport = "C:\\Workspace\\SCE\\web\\reports\\SCEMovimentos.jasper";
            String dataSourceFile = "C:/Workspace/SCE/web/xmls/notasfiscaisEntrada.xml";
            String pdfout = "C:\\Workspace\\SCE\\web\\reports\\SCEMovimentos.pdf";

            Document document = JRXmlUtils.parse(JRLoader.getLocationInputStream(dataSourceFile));
            Map params = new HashMap();
            params.put(JRXPathQueryExecuterFactory.PARAMETER_XML_DATA_DOCUMENT, document);
            params.put("ReportTitle", "Entrada de Produtos");
            JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, params);

            JasperExportManager.exportReportToPdfFile(jasperPrint, pdfout);

            ReportHelp.writePdfResponse(response, pdfout);

        } catch (JAXBException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (JRException e) {
            e.printStackTrace();
        }

    }


}
