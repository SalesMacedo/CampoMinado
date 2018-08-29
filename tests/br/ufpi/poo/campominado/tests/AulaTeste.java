package br.ufpi.poo.campominado.tests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import br.ufpi.poo.campominado.enums.Acao;
import br.ufpi.poo.campominado.enums.EstadoZona;
import br.ufpi.poo.campominado.exceptions.AcaoInvalidaException;
import br.ufpi.poo.campominado.exceptions.BombaExplodiuException;
import br.ufpi.poo.campominado.exceptions.PosicaoInvalidaException;
import br.ufpi.poo.campominado.model.CampoMinado;
import br.ufpi.poo.campominado.model.Coordenada;
import br.ufpi.poo.campominado.model.Jogada;
import br.ufpi.poo.campominado.model.Tabuleiro;
import br.ufpi.poo.campominado.model.Zona;

public class AulaTeste {
	@Test(expected = AcaoInvalidaException.class)
	public void coordenadaTest()throws PosicaoInvalidaException, AcaoInvalidaException, BombaExplodiuException{
		CampoMinado cm = new CampoMinado();
		
		cm.reseta();
		
		Jogada nova1 = new Jogada(Acao.MARCAR, new Coordenada(0,0));
		Jogada nova2 = new Jogada(Acao.MARCAR,new Coordenada(0,0));
		
		cm.executa(nova1);
		
		cm.executa(nova2);
		
	}
	@Test(expected = PosicaoInvalidaException.class)
	public void investigadoTest() throws PosicaoInvalidaException, AcaoInvalidaException, BombaExplodiuException{
		CampoMinado cm = new CampoMinado();
		cm.reseta();
		Jogada n1 = new Jogada(Acao.INVESTIGAR, new Coordenada(0,0));
		Jogada n2 = new Jogada(Acao.INVESTIGAR, new Coordenada(0,0));
		cm.executa(n1);
		cm.executa(n2);
	}
	
	@Test(expected = PosicaoInvalidaException.class)
	public void foraDosLimites() throws PosicaoInvalidaException, AcaoInvalidaException, BombaExplodiuException{
		CampoMinado cm = new CampoMinado();
		cm.reseta();
		
		Jogada jog = new Jogada(Acao.MARCAR, new Coordenada(20,-1));
		cm.executa(jog);
	}
	@Test(expected = PosicaoInvalidaException.class)
	public void foraDosLimitesX() throws PosicaoInvalidaException, AcaoInvalidaException, BombaExplodiuException{
		CampoMinado cm = new CampoMinado();
		cm.reseta();
		
		Jogada jog = new Jogada(Acao.MARCAR, new Coordenada(5,0));
		cm.executa(jog);
	}
	@Test(expected = PosicaoInvalidaException.class)
	public void foraDosLimitesY() throws PosicaoInvalidaException, AcaoInvalidaException, BombaExplodiuException{
		CampoMinado cm = new CampoMinado();
		cm.reseta();
		
		Jogada jog = new Jogada(Acao.MARCAR, new Coordenada(0,5));
		cm.executa(jog);
	}
	
	@Test(expected = PosicaoInvalidaException.class)
	public void investigaForaLimitesEixoX() throws PosicaoInvalidaException, AcaoInvalidaException, BombaExplodiuException{
		CampoMinado cm = new CampoMinado();
		cm.reseta();
		Jogada n1 = new Jogada(Acao.INVESTIGAR, new Coordenada(10,0));
		cm.executa(n1);
	}
	
	@Test(expected = PosicaoInvalidaException.class)
	public void investigaForaLimitesEixoY() throws PosicaoInvalidaException, AcaoInvalidaException, BombaExplodiuException{
		CampoMinado cm = new CampoMinado();
		cm.reseta();
		Jogada n1 = new Jogada(Acao.INVESTIGAR, new Coordenada(0,10));
		cm.executa(n1);
	}
	
	
	@Test(expected = PosicaoInvalidaException.class)
	public void invetigaAmbosForaLimitesXY() throws PosicaoInvalidaException, AcaoInvalidaException, BombaExplodiuException{
		CampoMinado cm = new CampoMinado();
		cm.reseta();
		Jogada n1 = new Jogada(Acao.INVESTIGAR, new Coordenada(15,10));
		cm.executa(n1);
	
	}
	
	//------------------------------- 
	
	@Test(expected = AcaoInvalidaException.class)/*Tenta marcar um valor em ambas cordenadas negativas*/
	public void TesteMarcarLimiteNegativo() throws PosicaoInvalidaException, AcaoInvalidaException, BombaExplodiuException{
		CampoMinado cm = new CampoMinado();
		cm.reseta();
		
		Jogada jog = new Jogada(Acao.MARCAR, new Coordenada(-1,-1));
		cm.executa(jog);
	}
	
	@Test(expected = PosicaoInvalidaException.class)/*Investiga tabuleiro com limites negativos*/
	public void TesteInvestigarLimiteNegativo() throws PosicaoInvalidaException, AcaoInvalidaException, BombaExplodiuException{
		CampoMinado cm = new CampoMinado();
		cm.reseta();
		Jogada n1 = new Jogada(Acao.INVESTIGAR, new Coordenada(-1,-1));
		cm.executa(n1);
	
	}
	@Test(expected = AcaoInvalidaException.class)/*Tenta marcar um valor na linha com posição negativa*/
	public void TesteAcaoMarcarPosicaoLinhaNegativa()throws PosicaoInvalidaException, AcaoInvalidaException, BombaExplodiuException{
		CampoMinado cm = new CampoMinado();
		
		cm.reseta();
		
		Jogada nova1 = new Jogada(Acao.MARCAR, new Coordenada(-1,0));		
		cm.executa(nova1);
		

	}
	@Test(expected = AcaoInvalidaException.class)/*Tenta marcar um valor na coluna com posição negativa*/
	public void TesteAcaoMarcarPosicaoColunaNegativa()throws PosicaoInvalidaException, AcaoInvalidaException, BombaExplodiuException{
		CampoMinado cm = new CampoMinado();
		
		cm.reseta();
		
		Jogada nova1 = new Jogada(Acao.MARCAR, new Coordenada(1,-2));		
		cm.executa(nova1);
		
	}
	 @Test
	  public void TestaTemVencedor() { 
		boolean retorno = false;
	    CampoMinado cm = new CampoMinado(); 
	    Tabuleiro tb = new Tabuleiro();
	    if (tb.getQtdeZonasLivres() == 0)
			retorno = true;
		retorno = false;
		
		
		assertTrue("Deveria retornar TRUE", retorno == cm.temVencedor());
	  }
	 
	@Test //Verifica numero de zonas
	public void TesteNumZonas(){
		Tabuleiro tb = new Tabuleiro();
		assertEquals(12, tb.getNumZonas());
		
	}
	
	@Test //Verifica se a Cordenada X não é inicializada com valor diferente de 0,1,2 ou 3
	public void TesteValorCordenadaValidaX(){
		int x1 = 0, x2 = 1, x3 = 2, x4 = 3;
		int y = 0;
		
		Coordenada cd = new Coordenada(x1, y);
		assertEquals(x1>=0 && x1<4, cd.getX());
		
		Coordenada cd1 = new Coordenada(x2, y);
		assertEquals(x2>=0 && x2<4, cd1.getX());
		
		Coordenada cd2 = new Coordenada(x3, y);
		assertEquals(x3>=0 && x3<4, cd2.getX());
		
		Coordenada cd3 = new Coordenada(x4, y);
		assertEquals(x4>=0 && x4<4, cd3.getX());
		
	}
	
	@Test //Verifica se a Cordenada y não é inicializada com valor diferente de 0,1,2 ou 3
	public void TesteValorCordenadaValidaY(){
		int x = 0;
		int y1 = 0, y2 = 1, y3 = 2, y4 = 3;
		
		Coordenada cd = new Coordenada(x, y1);
		assertEquals(y1>=0 && y1<4, cd.getY());
		
		Coordenada cd1 = new Coordenada(x, y2);
		assertEquals(y2>=0 && y2<4, cd1.getY());
		
		Coordenada cd2 = new Coordenada(x, y3);
		assertEquals(y3>=0 && y3<4, cd2.getY());
		
		Coordenada cd3 = new Coordenada(x, y4);
		assertEquals(y4>=0 && y4<4, cd3.getY());
		
	}
	
	@Test //Verifica Estado de zona aberto
	public void VerificaEstadoAberto() {
		Zona z = new Zona();
		//EstadoZona e = EstadoZona.ABERTO;
		z.setEstadoZona(EstadoZona.ABERTO);
		
		assertEquals(EstadoZona.ABERTO, z.getEstadoZona());
		
	}
	
	@Test //Verifica Estado de zona Marcado
	public void VerificaEstadoMarcado() {
		Zona z = new Zona();
		//EstadoZona e = EstadoZona.ABERTO;
		z.setEstadoZona(EstadoZona.MARCADO);
		
		assertEquals(EstadoZona.MARCADO, z.getEstadoZona());
		
	}
	
	@Test //Verifica Estado de zona Marcado
	public void VerificaEstadoVazio() {
		Zona z = new Zona();
		//EstadoZona e = EstadoZona.ABERTO;
		z.setEstadoZona(EstadoZona.VAZIO);
		
		assertEquals(EstadoZona.VAZIO, z.getEstadoZona());
		
	}
}
