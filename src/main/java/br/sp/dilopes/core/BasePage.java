package br.sp.dilopes.core;

import static br.sp.dilopes.core.DriverFactory.getDriver;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class BasePage {

	/********* TextField e TextArea 
	 * @throws InterruptedException ************/
	
	public void escrever(By by, String texto) throws InterruptedException{
		getDriver().findElement(by).clear();
		getDriver().findElement(by).sendKeys(texto);
		Thread.sleep(1000);
	}

	public void escrever(String id_campo, String texto) throws InterruptedException{
		escrever(By.id(id_campo), texto);
	}
	
	public String obterValorCampo(String id_campo) {
		return getDriver().findElement(By.id(id_campo)).getAttribute("value");
	}
	
	/********* Radio e Check ************/
	
	public void clicarRadio(By by) {
		getDriver().findElement(by).click();
	}
	
	public void clicarRadio(String id) throws InterruptedException {
		Thread.sleep(1000);
		clicarRadio(By.id(id));
	}
	
	public boolean isRadioMarcado(String id){
		return getDriver().findElement(By.id(id)).isSelected();
	}
	
	public void clicarCheck(String id) {
		getDriver().findElement(By.id(id)).click();
	}
	
	public boolean isCheckMarcado(String id){
		return getDriver().findElement(By.id(id)).isSelected();
	}
	
	/********* Combo ************/
	
	public void selecionarCombo(String id, String valor) {
		WebElement element = getDriver().findElement(By.id(id));
		Select combo = new Select(element);
		combo.selectByValue(valor);
	}
	
	public void selecionarComboTxt(String id, String valor) {
		WebElement element = getDriver().findElement(By.id(id));
		Select combo = new Select(element);
		combo.selectByVisibleText(valor);
	}


	public List<String> obterValoresCombo(String id) {
		WebElement element = getDriver().findElement(By.id("elementosForm:esportes"));
		Select combo = new Select(element);
		List<WebElement> allSelectedOptions = combo.getAllSelectedOptions();
		List<String> valores = new ArrayList<String>();
		for(WebElement opcao: allSelectedOptions) {
			valores.add(opcao.getText());
		}
		return valores;
	}
	
	public int obterQuantidadeOpcoesCombo(String id){
		WebElement element = getDriver().findElement(By.id(id));
		Select combo = new Select(element);
		List<WebElement> options = combo.getOptions();
		return options.size();
	}
	
	
	/********* Botao @throws InterruptedException ************/
	
	public void clicarBotao(By by) throws InterruptedException {
		Thread.sleep(1000);
		getDriver().findElement(by).click();
	}
	public void clicarBotao(String id) throws InterruptedException {
		clicarBotao(By.id(id));
	}
	
	public void clicarBotaoPorTexto(String texto) throws InterruptedException{
		clicarBotao(By.xpath("//button[.='"+texto+"']"));
	}
	
	public String obterValueElemento(String id) {
		return getDriver().findElement(By.id(id)).getAttribute("value");
	}
	
	/********* Textos ************/
	
	public String obterTexto(By by) {
		return getDriver().findElement(by).getText();
	}
	
	public String obterTexto(String id) {
		return obterTexto(By.id(id));
	}
	
	public String obterTextoByTagname() {
		String retorno = getDriver().findElement(By.tagName(("BODY"))).getText().toString();
		return retorno;
	}
	
	/************** MouseOver *********************/
	
	public void acaoMouseOver(String produto) {
		Actions acao = new Actions(getDriver());
		acao.moveToElement(getDriver().findElement(By.xpath(produto))).perform();
	}
	
	public String acaoMouseOverValida(String valida) throws InterruptedException {
		Actions acao = new Actions(getDriver());
		Thread.sleep(1000);
		acao.moveToElement(getDriver().findElement(By.xpath(valida))).perform();
		valida = getDriver().findElement(By.xpath(valida)).getText();
		return valida;
	}
	
	
	/************** Tabela *********************/
	
	public WebElement obterCelula(String colunaBusca, String valor, String colunaBotao, String idTabela){
		//procurar coluna do registro
		WebElement tabela = getDriver().findElement(By.xpath("//*[@id='"+idTabela+"']"));
		int idColuna = obterIndiceColuna(colunaBusca, tabela);
		
		//encontrar a linha do registro
		int idLinha = obterIndiceLinha(valor, tabela, idColuna);
		
		//procurar coluna do botao
		int idColunaBotao = obterIndiceColuna(colunaBotao, tabela);
		
		//clicar no botao da celula encontrada
		WebElement celula = tabela.findElement(By.xpath(".//tr["+idLinha+"]/td["+idColunaBotao+"]"));
		return celula;
	}
	
	public void clicarBotaoTabela(String colunaBusca, String valor, String colunaBotao, String idTabela){
		WebElement celula = obterCelula(colunaBusca, valor, colunaBotao, idTabela);
		celula.findElement(By.xpath(".//input")).click();
		
	}

	protected int obterIndiceLinha(String valor, WebElement tabela, int idColuna) {
		List<WebElement> linhas = tabela.findElements(By.xpath("./tbody/tr/td["+idColuna+"]"));
		int idLinha = -1;
		for(int i = 0; i < linhas.size(); i++) {
			if(linhas.get(i).getText().equals(valor)) {
				idLinha = i+1;
				break;
			}
		}
		return idLinha;
	}

	protected int obterIndiceColuna(String coluna, WebElement tabela) {
		List<WebElement> colunas = tabela.findElements(By.xpath(".//th"));
		int idColuna = -1;
		for(int i = 0; i < colunas.size(); i++) {
			if(colunas.get(i).getText().equals(coluna)) {
				idColuna = i+1;
				break;
			}
		}
		return idColuna;
	}
}
