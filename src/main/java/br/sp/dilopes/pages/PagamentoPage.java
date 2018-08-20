package br.sp.dilopes.pages;

import org.openqa.selenium.By;

import br.sp.dilopes.core.BasePage;

public class PagamentoPage extends BasePage {
	
	public void payBankWire() throws InterruptedException {
		clicarBotao(By.xpath("//*[@id=\"HOOK_PAYMENT\"]/div[1]/div/p/a"));
	}
	
	public void confirmarPagamento() throws InterruptedException {
		clicarBotao(By.xpath("//*[@id=\"cart_navigation\"]/button/span"));
	}

	public String confirmacaoCompra() {
		String txtValida;
		txtValida = obterTexto(By.xpath("//*[@id=\"center_column\"]/div/p/strong"));
		
		return txtValida;
	}
}
