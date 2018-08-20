package br.sp.dilopes.tests;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import br.sp.dilopes.core.BaseTest;
import br.sp.dilopes.pages.AutenticacaoPage;
import br.sp.dilopes.pages.CreateAccountPage;
import br.sp.dilopes.pages.MyStoreHomePage;
import br.sp.dilopes.pages.PagamentoPage;
import br.sp.dilopes.pages.SummaryPage;

public class MyStoreTest extends BaseTest {

	MyStoreHomePage homepg = new MyStoreHomePage();
	SummaryPage summarypg = new SummaryPage();
	AutenticacaoPage autenticpg = new AutenticacaoPage();
	CreateAccountPage createAccpg = new CreateAccountPage(); 
	PagamentoPage pgtopg = new PagamentoPage();
	
	@Before
	public void inicializa() {
		homepg.acessarTelaInicial();
	}
	
	
	@Test
	public void teste01_ProdutoAdicionadoAoCarrinho() throws InterruptedException {
		homepg.posicionarProduto();
		homepg.adicionarProdutoAoCarrinho();
		assertEquals("Product successfully added to your shopping cart" , homepg.validaProdutoCarrinho());
	}
	
	@Test
	public void teste02_ProcedToCheckOut() throws InterruptedException {
		//Seleção de Produto
		homepg.posicionarProduto();
		homepg.adicionarProdutoAoCarrinho();
		homepg.prosseguirCheckOut();
		
		//Página de Sumário
		summarypg.irParacheckout();
		
		//Autenticação | Login
		autenticpg.preencherEmail("testeDiogo006@teste.com");
		autenticpg.botaoCriarConta();
		Thread.sleep(3000);
		
		//Criar Conta
		createAccpg.selecionarGeneroMrs();
		createAccpg.firstName("Cynthia");
		createAccpg.lastName("Teste");
		createAccpg.password("123456");
		createAccpg.dataAniversario("03/05/1989");
		createAccpg.endereco("Rua X");
		createAccpg.cidade("São Paulo");
		createAccpg.estado("Alabama");
		createAccpg.cep("36017");
		createAccpg.telefone("999876786");
		createAccpg.registrar();
		createAccpg.checkout();
		createAccpg.aceitarTermo();
		createAccpg.paginaPagamento();
		
		//Pagamento
		pgtopg.payBankWire();
		pgtopg.confirmarPagamento();
		
		Assert.assertTrue(pgtopg.confirmacaoCompra().contains("Your order on My Store is complete."));
		
	}
	
	@After
	public void finaliza() {

	}
	
}
