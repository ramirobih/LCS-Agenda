package presentacion.reportes;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.view.JasperViewer;
import dto.PersonaDTO;

public class ReporteAgenda
{
	private JasperReport reporte = null;
	private JasperViewer reporteViewer;
	private JasperPrint	reporteLleno;
	
	//Recibe la lista de personas para armar el reporte
    public ReporteAgenda(List<PersonaDTO> personas)
    {
    	
    	
    	
    	//Hardcodeado
		Map<String, Object> parametersMap = new HashMap<String, Object>();
		parametersMap.put("Fecha", new SimpleDateFormat("dd/MM/yyyy").format(new Date()));	
		
		
//		File file = new File("reportes\\ReporteAgenda1.jasper");
//
//
//	    if(file.exists()){
//	        try{
//	            reporte = (JasperReport) JRLoader.loadObject(file);//(getClass().getResource("Reportes\\ReportePresupuesto.jasper"));;//JasperCompileManager.compileReport("src/Reportes/ReportePresupuesto.jrxml");
//	            JasperPrint  print = JasperFillManager.fillReport(this.reporte, parametersMap, 
//						new JRBeanCollectionDataSource(personas));
//	            JasperViewer view = new JasperViewer(print, false);
//	            view.setVisible(true);
//	            view.setTitle("Guardar Agenda:");
//	        }catch(JRException e){
//	            e.printStackTrace();
//	        }
//	    }else{
//	        File file2 = new File("ReporteAgenda.jasper");
//	        try{
//	            reporte = (JasperReport) JRLoader.loadObject(file2);//(getClass().getResource("Reportes\\ReportePresupuesto.jasper"));;//JasperCompileManager.compileReport("src/Reportes/ReportePresupuesto.jrxml");
//	            JasperPrint  print = JasperFillManager.fillReport(this.reporte, parametersMap, 
//						new JRBeanCollectionDataSource(personas));
//	            JasperViewer view = new JasperViewer(print, false);
//	            view.setVisible(true);
//	            view.setTitle("Guardar Agenda:");
//	        }catch(JRException e){
//	            e.printStackTrace();
//	        }
//	    }
//		
		
   	try		{
    		
			this.reporte = (JasperReport) JRLoader.loadObjectFromFile("reportes\\ReporteAgenda1.jasper");
			this.reporteLleno = JasperFillManager.fillReport(this.reporte, parametersMap, 
					new JRBeanCollectionDataSource(personas));
		}
		catch( JRException ex ) 
		{
			ex.printStackTrace();
	}
    }       
    
    public void mostrar()
	{
		this.reporteViewer = new JasperViewer(this.reporteLleno,false);
		this.reporteViewer.setVisible(true);
	}
   
}	