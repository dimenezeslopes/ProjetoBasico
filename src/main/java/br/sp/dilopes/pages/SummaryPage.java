package br.sp.dilopes.pages;

import org.openqa.selenium.By;

import br.sp.dilopes.core.BasePage;

public class SummaryPage extends BasePage {
	
	public void irParacheckout() throws InterruptedException {
		clicarBotao(By.xpath("//*[@id=\"center_column\"]/p[2]/a[1]/span"));
	}
	
}
