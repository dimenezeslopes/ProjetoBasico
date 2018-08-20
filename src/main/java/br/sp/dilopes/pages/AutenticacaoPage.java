package br.sp.dilopes.pages;

import org.openqa.selenium.By;

import br.sp.dilopes.core.BasePage;

public class AutenticacaoPage extends BasePage {
	
	public void preencherEmail(String email) throws InterruptedException{
		escrever(By.id("email_create"), email);
	}
	
	public void botaoCriarConta() throws InterruptedException {
		clicarBotao("SubmitCreate");
	}
}	
