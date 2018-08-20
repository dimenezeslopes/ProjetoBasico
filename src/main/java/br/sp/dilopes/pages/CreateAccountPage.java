package br.sp.dilopes.pages;

import org.openqa.selenium.By;

import br.sp.dilopes.core.BasePage;

public class CreateAccountPage extends BasePage {
	
	public void selecionarGeneroMrs() throws InterruptedException {
		clicarRadio("uniform-id_gender2");
	}
	
	public void firstName(String nome) throws InterruptedException {
		escrever(By.id("customer_firstname"), nome);
	}
	
	public void lastName(String sobrenome) throws InterruptedException {
		escrever(By.id("customer_lastname"), sobrenome);
	}
	
	public void password(String password) throws InterruptedException {
		escrever(By.id("passwd"), password);
	}

	public void dataAniversario(String data) {
		String dia, mes, ano;
		dia = data.substring(0,2);
		mes = data.substring(3,5);
		ano = data.substring(6,10);
		selecionarCombo("days", String.valueOf(Integer.parseInt(dia)));
		selecionarCombo("months", String.valueOf(Integer.parseInt(mes)));
		selecionarCombo("years", String.valueOf(Integer.parseInt(ano)));
		
	}

	public void endereco(String endereco) throws InterruptedException {
		escrever(By.id("address1"), endereco);
		
	}

	public void cidade(String cidade) throws InterruptedException {
		escrever(By.id("city"), cidade);
	}

	public void estado(String string) {
		selecionarComboTxt("id_state", "Alabama");
	}

	public void cep(String cep) throws InterruptedException {
		escrever(By.id("postcode"), cep);
	}

	public void telefone(String cel) throws InterruptedException {
		escrever(By.id("phone_mobile"), cel);
		
	}

	public void registrar() throws InterruptedException {
		clicarBotao("submitAccount");
	}

	public void checkout() throws InterruptedException {
		clicarBotao(By.name("processAddress"));
	}

	public void paginaPagamento() throws InterruptedException {
		clicarBotao(By.name("processCarrier"));
	}

	public void aceitarTermo() {
		clicarCheck("cgv");
	}
	
	
	
}
