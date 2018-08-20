package br.sp.dilopes.pages;

import static br.sp.dilopes.core.DriverFactory.getDriver;

import org.openqa.selenium.By;

import br.sp.dilopes.core.BasePage;

public class MyStoreHomePage extends BasePage {
		
	public void acessarTelaInicial(){
		getDriver().get("http://automationpractice.com/index.php?");
	}

	public void posicionarProduto() {
		acaoMouseOver("//*[@id=\"homefeatured\"]/li[1]/div/div[2]/h5/a");
	}

	public void adicionarProdutoAoCarrinho() throws InterruptedException {
		clicarBotao(By.xpath("//*[@id=\"homefeatured\"]/li[1]/div/div[2]/div[2]/a[1]/span"));
	}
	
	public String obterMensagemSucesso(){
		return obterTexto(By.xpath("^xpath=\\(\\.//[\\s\\S]*\\[normalize-space\\(text\\(\\)\\) and normalize-space\\(\\.\\)='Check out'\\]\\)\\[1\\]/following::h2\\[1\\]$"));
	}
	
	public String validaProdutoCarrinho() throws InterruptedException {
		String validacao = acaoMouseOverValida("//*[@id=\"layer_cart\"]/div[1]/div[1]/h2");
		return validacao;
	}
	
	public void prosseguirCheckOut() throws InterruptedException {
		acaoMouseOver("//*[@id=\"layer_cart\"]/div[1]/div[2]/div[4]/a/span");
		
		clicarBotao(By.xpath("//*[@id=\"layer_cart\"]/div[1]/div[2]/div[4]/a/span"));
	}
}
