package cielo.clientes;

import cielo.clientes.domain.PessoaFisica.DadosAtualizarPessoaFisica;
import cielo.clientes.domain.PessoaFisica.DadosDetalhamentoPessoaFisica;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.json.AutoConfigureJsonTesters;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.json.JacksonTester;
import org.springframework.http.HttpStatus;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.reactive.server.WebTestClient;
import cielo.clientes.domain.PessoaFisica.*;
import cielo.clientes.domain.PessoaFisica.PessoaFisica;
import cielo.clientes.domain.PessoaJuridica.*;
import cielo.clientes.domain.PessoaJuridica.PessoaJuridica;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import static org.assertj.core.api.Assertions.*;
import org.springframework.http.MediaType;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;



import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;

@SpringBootTest
@AutoConfigureMockMvc
@AutoConfigureJsonTesters
class ClientesApplicationTests {

	@Autowired
	private MockMvc mvc;

	@Autowired
	private JacksonTester<DadosCadastroPessoaFisica> dadosCadastroPessoaFisicaJson;
	@Autowired
	private JacksonTester<DadosAtualizarPessoaFisica> dadosAtualizarPessoaFisicaJson;

	@Autowired
	private JacksonTester<DadosCadastrarPessoaJuridica> dadosCadastrarPessoaJuridicaJson;
	@Autowired
	private JacksonTester<DadosAtualizarPessoaJuridica> dadosAtualizarPessoaJuridicaJson;

	private WebTestClient teste;


	@Test
	@WithMockUser
	void testeAdicionarPessoaFisica_OK() throws Exception{
		var response = mvc.perform(post("/pessoafisica")
						.contentType(MediaType.APPLICATION_JSON)
						.content(dadosCadastroPessoaFisicaJson.write(
								new DadosCadastroPessoaFisica("12345678915",8888,"Aluno Santos","alunos.santos@cielo.com")
						).getJson()))
				.andReturn().getResponse();
		assertThat(response.getStatus()).isEqualTo(HttpStatus.CREATED.value());
	}

	@Test
	@WithMockUser
	void testeAdicionarPessoaFisica_NotOK() throws Exception{
		var response = mvc.perform(post("/pessoafisica")
						.contentType(MediaType.APPLICATION_JSON)
						.content(dadosCadastroPessoaFisicaJson.write(
								new DadosCadastroPessoaFisica("12345678915",8888,
										"Aluno Santos","alunos.santos@cielo.com")
						).getJson()))
				.andReturn().getResponse();
		assertThat(response.getStatus()).isEqualTo(HttpStatus.CONFLICT.value());
	}


	@Test
	@WithMockUser
	void testeConsultarPessoaFisica_OK() throws Exception{
		var response = mvc.perform(get("/pessoafisica/1")
						.contentType(MediaType.APPLICATION_JSON)
						.accept(MediaType.APPLICATION_JSON))
				.andReturn().getResponse();
		assertThat(response.getStatus()).isEqualTo(HttpStatus.OK.value());
	}

	@Test
	@WithMockUser
	void testeConsultarPessoaFisica_NotOK() throws Exception{
		var response = mvc.perform(get("/pessoafisica/100")
						.contentType(MediaType.APPLICATION_JSON)
						.accept(MediaType.APPLICATION_JSON))
				.andReturn().getResponse();
		assertThat(response.getStatus()).isEqualTo(HttpStatus.CONFLICT.value());
	}



	@Test
	@WithMockUser
	void testeAlteraPessoaFisica_OK() throws Exception{
		java.lang.Long id =  1L;
		var response = mvc.perform(put("/pessoafisica")
						.contentType(MediaType.APPLICATION_JSON)
						.content(dadosAtualizarPessoaFisicaJson.write(
								new DadosAtualizarPessoaFisica(1L,"12345678902",
										8888,"Aluno Novo","alunos.santos@cielo.com",1)
						).getJson()))
				.andReturn().getResponse();
		assertThat(response.getStatus()).isEqualTo(HttpStatus.OK.value());
	}

	@Test
	@WithMockUser
	void testeAlteraPessoaFisica_NotOK() throws Exception{
		java.lang.Long id =  1L;
		var response = mvc.perform(put("/pessoafisica")
						.contentType(MediaType.APPLICATION_JSON)
						.content(dadosAtualizarPessoaFisicaJson.write(
								new DadosAtualizarPessoaFisica(100L,"12345678902",
										8888,"Aluno Novo","alunos.santos@cielo.com",1)
						).getJson()))
				.andReturn().getResponse();
		assertThat(response.getStatus()).isEqualTo(HttpStatus.CONFLICT.value());
	}




	@Test
	@WithMockUser
	void testeDeletarPessoaFisica_OK() throws Exception{
		var response = mvc.perform(delete("/pessoafisica/1")
						.contentType(MediaType.APPLICATION_JSON)
						.accept(MediaType.APPLICATION_JSON))
				.andReturn().getResponse();
		assertThat(response.getStatus()).isEqualTo(HttpStatus.NO_CONTENT.value());
	}

	@Test
	@WithMockUser
	void testeDeletarPessoaFisica_NotOK() throws Exception{
		var response = mvc.perform(delete("/pessoafisica/100")
						.contentType(MediaType.APPLICATION_JSON)
						.accept(MediaType.APPLICATION_JSON))
				.andReturn().getResponse();
		assertThat(response.getStatus()).isEqualTo(HttpStatus.CONFLICT.value());
	}




	@Test
	@WithMockUser
	void testeAdicionarPessoaJuridica_OK() throws Exception{
		var response = mvc.perform(post("/pessoajuridica")
						.contentType(MediaType.APPLICATION_JSON)
						.content(dadosCadastrarPessoaJuridicaJson.write(
								new DadosCadastrarPessoaJuridica("12345678912349",
										"empresa001",8888,"12345678912",
										"Aluno Santos","teste@gmail.com")
						).getJson()))
				.andReturn().getResponse();
		assertThat(response.getStatus()).isEqualTo(HttpStatus.CREATED.value());
	}



	@Test
	@WithMockUser
	void testeAdicionarPessoaJuridica_NotOK() throws Exception{
		var response = mvc.perform(post("/pessoajuridica")
						.contentType(MediaType.APPLICATION_JSON)
						.content(dadosCadastrarPessoaJuridicaJson.write(
								new DadosCadastrarPessoaJuridica("12345678912349",
										"empresa001",8888,"12345678910",
										"Aluno Santos","alunos.santos@cielo.com")
						).getJson()))
				.andReturn().getResponse();
		assertThat(response.getStatus()).isEqualTo(HttpStatus.CONFLICT.value());
	}


	@Test
	@WithMockUser
	void testeConsultarPessoaJuridica_OK() throws Exception{
		var response = mvc.perform(get("/pessoajuridica/1")
						.contentType(MediaType.APPLICATION_JSON)
						.accept(MediaType.APPLICATION_JSON))
				.andReturn().getResponse();
		assertThat(response.getStatus()).isEqualTo(HttpStatus.OK.value());
	}

	@Test
	@WithMockUser
	void testeConsultarPessoaJuridica_NotOK() throws Exception{
		var response = mvc.perform(get("/pessoajuridica/100")
						.contentType(MediaType.APPLICATION_JSON)
						.accept(MediaType.APPLICATION_JSON))
				.andReturn().getResponse();
		assertThat(response.getStatus()).isEqualTo(HttpStatus.CONFLICT.value());
	}


	@Test
	@WithMockUser
	void testeAlteraPessoaJuridica_OK() throws Exception{
		java.lang.Long id =  1L;
		var response = mvc.perform(put("/pessoajuridica")
						.contentType(MediaType.APPLICATION_JSON)
						.content(dadosAtualizarPessoaJuridicaJson.write(
								new DadosAtualizarPessoaJuridica(1L,"12345678912345",
										"empresa001",8888,"12345678912",
										"Aluno Santos","teste@gmail.com",1)
						).getJson()))
				.andReturn().getResponse();
		assertThat(response.getStatus()).isEqualTo(HttpStatus.OK.value());
	}

	@Test
	@WithMockUser
	void testeAlteraPessoaJuridica_NotOK() throws Exception{
		java.lang.Long id =  1L;
		var response = mvc.perform(put("/pessoajuridica")
						.contentType(MediaType.APPLICATION_JSON)
						.content(dadosAtualizarPessoaJuridicaJson.write(
								new DadosAtualizarPessoaJuridica(100L,"12345678912345",
										"empresa001",8888,"12345678912",
										"Aluno Santos","teste@gmail.com",1)
						).getJson()))
				.andReturn().getResponse();
		assertThat(response.getStatus()).isEqualTo(HttpStatus.CONFLICT.value());
	}


	@Test
	@WithMockUser
	void testeDeletarPessoaJuridica_OK() throws Exception{
		var response = mvc.perform(delete("/pessoajuridica/1")
						.contentType(MediaType.APPLICATION_JSON)
						.accept(MediaType.APPLICATION_JSON))
				.andReturn().getResponse();
		assertThat(response.getStatus()).isEqualTo(HttpStatus.NO_CONTENT.value());
	}

	@Test
	@WithMockUser
	void testeDeletarPessoaJuridica_NotOK() throws Exception{
		var response = mvc.perform(delete("/pessoajuridica/100")
						.contentType(MediaType.APPLICATION_JSON)
						.accept(MediaType.APPLICATION_JSON))
				.andReturn().getResponse();
		assertThat(response.getStatus()).isEqualTo(HttpStatus.CONFLICT.value());
	}

}
