package Parcial.Midia;

public class Testador {

	public static void main(String[] args) {
		
		Midia cd =  new Cd (3, "Cd");
		Midia vhs = new Vhs(3,"Vhs");
		
		
		
		Conexao c = new Conexao();
		
		MidiaDaoCd lDao = new MidiaDaoCd(c.abrirConexao());
		
		lDao.saveCd((Cd)cd);

		//lDao.delete(1);
		
		
		c.fechaConexao();
		
		//-------------------------------------------------------------------
		
		MidiaDaoVhs lDao2 = new MidiaDaoVhs(c.abrirConexao());
		
		lDao2.saveVhs((Vhs)vhs);
		
		//lDao2.delete(1);
		
		
		c.fechaConexao();
		
		
	
	}

}
