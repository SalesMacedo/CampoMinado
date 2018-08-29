package br.ufpi.poo.campominado.tests;

import org.junit.Test;

import br.ufpi.poo.campominado.enums.Acao;
import br.ufpi.poo.campominado.exceptions.AcaoInvalidaException;
import br.ufpi.poo.campominado.exceptions.BombaExplodiuException;
import br.ufpi.poo.campominado.exceptions.PosicaoInvalidaException;
import br.ufpi.poo.campominado.model.CampoMinado;
import br.ufpi.poo.campominado.model.Coordenada;
import br.ufpi.poo.campominado.model.Jogada;

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
	@Test(expected = AcaoInvalidaException.class)
	public void Teste()throws PosicaoInvalidaException, AcaoInvalidaException, BombaExplodiuException{
		CampoMinado cm = new CampoMinado();
		
		cm.reseta();
		
		Jogada nova1 = new Jogada(Acao.MARCAR, new Coordenada(1,-2));		
		cm.executa(nova1);
		
	}
	
	
}
