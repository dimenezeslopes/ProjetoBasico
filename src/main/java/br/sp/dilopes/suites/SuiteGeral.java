package br.sp.dilopes.suites;

import org.junit.AfterClass;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import br.sp.dilopes.core.DriverFactory;

@RunWith(Suite.class)
@SuiteClasses({
//	ContaTest.class,
//	MovimentacaoTest.class,
//	RemoverMovimentacaoContaTest.class,
//	SaldoTest.class,
//	ResumoTest.class
})
public class SuiteGeral {
//	private static LoginPage page = new LoginPage();
//	
//	@BeforeClass
//	public static void inicializa(){
//		page.acessarTelaInicial();
//		
//		page.setEmail("wagner@costa");
//		page.setSenha("123456");
//		page.entrar();
//	}
	
	@AfterClass
	public static void finaliza(){
		DriverFactory.killDriver();
	}
}
