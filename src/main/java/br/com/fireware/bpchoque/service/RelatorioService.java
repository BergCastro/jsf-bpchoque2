package br.com.fireware.bpchoque.service;
import java.io.*;

import java.util.Collection;
import java.util.HashMap;
import javax.faces.context.*;

import javax.servlet.ServletContext;
import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.engine.export.*;
import net.sf.jasperreports.engine.export.oasis.JROdtExporter;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.export.*;
import org.primefaces.model.*;
import br.com.fireware.bpchoque.exception.UtilException;

public class RelatorioService {
	
		
	
		public static final int	RELATORIO_PDF		= 1;
		public static final int	RELATORIO_EXCEL		= 2;
		public static final int	RELATORIO_HTML		= 3;
		public static final int	RELATORIO_PLANILHA_OPEN_OFFICE	= 4;
		public StreamedContent geraRelatorio(HashMap parametrosRelatorio, String nomeRelatorioJasper,
			String nomeRelatorioSaida, Collection<?> collection, int tipoRelatorio) throws UtilException { 
			StreamedContent arquivoRetorno = null;
			try {
				
				FacesContext contextoFaces = FacesContext.getCurrentInstance();
				ExternalContext contextoExterno = contextoFaces.getExternalContext();
				ServletContext contextoServlet = (ServletContext) contextoExterno.getContext();

				String caminhoRelatorios = contextoServlet.getRealPath("/reports"); 
				String caminhoArquivoJasper = caminhoRelatorios + File.separator + nomeRelatorioJasper
						+ ".jasper"; 
				String caminhoArquivoRelatorio = caminhoRelatorios + File.separator + nomeRelatorioSaida;

				JasperReport relatorioJasper = (JasperReport) JRLoader.loadObjectFromFile(caminhoArquivoJasper); 
				JasperPrint impressoraJasper = JasperFillManager
					.fillReport(relatorioJasper, parametrosRelatorio, new JRBeanCollectionDataSource(collection)); 

				String extensao = null;
				File arquivoGerado = null;

				switch (tipoRelatorio) {
					case RelatorioService.RELATORIO_PDF:
						JRPdfExporter pdfExportado = new JRPdfExporter(); 
						extensao = "pdf";
						arquivoGerado = new java.io.File(caminhoArquivoRelatorio + "." + extensao);
						pdfExportado.setExporterInput(new SimpleExporterInput(	impressoraJasper));
						pdfExportado.setExporterOutput(new SimpleOutputStreamExporterOutput(arquivoGerado));
						pdfExportado.exportReport();
						arquivoGerado.deleteOnExit(); 
						break;
					case RelatorioService.RELATORIO_HTML:
						HtmlExporter htmlExportado = new HtmlExporter();
						extensao = "html";
						arquivoGerado = new java.io.File(caminhoArquivoRelatorio + "." + extensao);
						htmlExportado.setExporterInput(new SimpleExporterInput(impressoraJasper));
						htmlExportado.setExporterOutput(new SimpleHtmlExporterOutput(arquivoGerado));
						htmlExportado.exportReport();
						arquivoGerado.deleteOnExit();
					break;
					case RelatorioService.RELATORIO_EXCEL:
						JRXlsExporter xlsExportado = new JRXlsExporter();
						extensao = "xls";
						arquivoGerado = new java.io.File(caminhoArquivoRelatorio + "." + extensao);
						xlsExportado.setExporterInput(new SimpleExporterInput(	impressoraJasper));
						xlsExportado.setExporterOutput(new SimpleOutputStreamExporterOutput(arquivoGerado));
						xlsExportado.exportReport();
						arquivoGerado.deleteOnExit();
						break;
					case RelatorioService.RELATORIO_PLANILHA_OPEN_OFFICE:
						JROdtExporter openExportado = new JROdtExporter();
						extensao = "ods";
						arquivoGerado = new java.io.File(caminhoArquivoRelatorio + "." + extensao);
						openExportado.setExporterInput(new SimpleExporterInput(impressoraJasper));
						openExportado.setExporterOutput(new SimpleOutputStreamExporterOutput(arquivoGerado));
						openExportado.exportReport();
						arquivoGerado.deleteOnExit();
						break;
				}

				InputStream conteudoRelatorio = new FileInputStream(arquivoGerado);
				arquivoRetorno = new DefaultStreamedContent(conteudoRelatorio, "application/"
					+ extensao, nomeRelatorioSaida + "." + extensao); 
			} catch (JRException e) {
				System.out.println(e.getMessage()+ " não foi possível gerar o arquivo");
				throw new UtilException("Não foi possível gerar o relatório.", e);
			} catch (FileNotFoundException e) {
				System.out.println(e.getStackTrace()+ " não foi possível encontrar o arquivo");
				System.out.println(e.getMessage()+ " não foi possível encontrar o arquivo");
				throw new UtilException("Arquivo do relatório não encontrado.", e);
				
			}
			return arquivoRetorno;
		}

		
	

	
}
