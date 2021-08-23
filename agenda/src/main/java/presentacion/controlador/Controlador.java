package presentacion.controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import dto.DomicilioDTO;
import dto.PersonaDTO;
import modelo.Agenda;
import persistencia.dao.mysql.DomicilioDAOSQL;
import presentacion.reportes.ReporteAgenda;
import presentacion.vista.VentanaPersona;
import presentacion.vista.Vista;

public class Controlador implements ActionListener
{
		private Vista vista;
		private List<PersonaDTO> personasEnTabla;
		private List<DomicilioDTO> domiciliosEnTabla;
		private VentanaPersona ventanaPersona; 
		private Agenda agenda;
		private DomicilioDAOSQL domicilioDAOSQL = new DomicilioDAOSQL();
		
		public Controlador(Vista vista, Agenda agenda)
		{
			this.vista = vista;
			this.vista.getBtnAgregar().addActionListener(a->ventanaAgregarPersona(a));
			this.vista.getBtnBorrar().addActionListener(s->borrarPersona(s));
			this.vista.getBtnReporte().addActionListener(r->mostrarReporte(r));
			this.ventanaPersona = VentanaPersona.getInstance();
			this.ventanaPersona.getBtnAgregarPersona().addActionListener(p->guardarPersona(p));
			this.agenda = agenda;
			
		
		}
		
		private void ventanaAgregarPersona(ActionEvent a) {
			this.ventanaPersona.mostrarVentana();
		}

		private void guardarPersona(ActionEvent p) {
			String nombre = this.ventanaPersona.getTextNombre().getText();
			String tel = ventanaPersona.getTextTelefono().getText();
			String mail = this.ventanaPersona.getTextEmail().getText();
			String cumple = this.ventanaPersona.getTextCumple().getText();
			String tipo = this.ventanaPersona.getTipes();
			String calle = this.ventanaPersona.getTextCalle().getText();
			String altura = this.ventanaPersona.getTextAltura().getText();
			String piso = this.ventanaPersona.getTextPiso().getText();
			String depto = this.ventanaPersona.getTextNumDepto().getText();
			
			PersonaDTO nuevaPersona = new PersonaDTO(0, nombre, tel, mail, cumple,tipo, 0); 
			DomicilioDTO nuevoDom = new DomicilioDTO(0, calle, altura, piso, depto);
			this.agenda.agregarPersona(nuevaPersona,nuevoDom);
			this.refrescarTabla();
			this.ventanaPersona.cerrar();
		}

		private void mostrarReporte(ActionEvent r) {
			ReporteAgenda reporte = new ReporteAgenda(agenda.obtenerPersonas());
			reporte.mostrar();	
		}

		public void borrarPersona(ActionEvent s)
		{
			domiciliosEnTabla = domicilioDAOSQL.readAll();
			int[] filasSeleccionadas = this.vista.getTablaPersonas().getSelectedRows();
			for (int fila : filasSeleccionadas)
			{
				
				this.agenda.borrarPersona(this.personasEnTabla.get(fila), domiciliosEnTabla.get(this.personasEnTabla.get(fila).getIdDomicilio()));
			}
			
			this.refrescarTabla();
		}
		
		public void inicializar()
		{
			this.refrescarTabla();
			this.vista.show();
		}
		
		private void refrescarTabla()
		{
			this.personasEnTabla = agenda.obtenerPersonas();
			this.vista.llenarTabla(this.personasEnTabla);
		}

		@Override
		public void actionPerformed(ActionEvent e) { }
		
}
