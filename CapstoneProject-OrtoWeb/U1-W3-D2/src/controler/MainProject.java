package controler;

import model.Evento;
import model.EventoDAO;
import model.TipoEvento;

public class MainProject {

	public static void main(String[] args) {
		
		Evento e = new Evento();
			e.setTitolo("Festa Della Mamma!");
			e.setDataEvento("08/03/2023");
			e.setDescrizione("Birra gratis per tutti!");
			e.setTipoEvento(TipoEvento.PUBBLICO);
			e.setNumeroMassimoPartecipanti(500);
			
		try {
			
			//	EventoDAO.save(e);
			//	Evento ev = EventoDAO.getById(3L);
			//	EventoDAO.delete(ev);
			
		} catch (Exception e1) {}

	}


}
