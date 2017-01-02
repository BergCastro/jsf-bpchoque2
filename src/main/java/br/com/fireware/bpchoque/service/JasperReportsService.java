package br.com.fireware.bpchoque.service;

import java.util.Collection;
import java.util.Map;

import org.springframework.stereotype.Service;

import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;


@Service
public class JasperReportsService {

	public void openReportByJasper(String jasperFile, Map<String, Object> params, Collection<?> collection) {
		
		try {
			JasperPrint print = JasperFillManager.fillReport(
					jasperFile, 
					params, 
					new JRBeanCollectionDataSource(collection));
			
			 JasperExportManager.exportReportToPdfFile(print, "relatorio.pdf");
			 JasperExportManager.exportReportToHtmlFile(print, "./src/main/webapp/reports/relatorio.xhtml");
	/*	JasperViewer viewer = new JasperViewer(print);
			viewer.setVisible(true);*/
		
			
		} catch (JRException e) {

			e.printStackTrace();
		}
		
		
		
	}
}
