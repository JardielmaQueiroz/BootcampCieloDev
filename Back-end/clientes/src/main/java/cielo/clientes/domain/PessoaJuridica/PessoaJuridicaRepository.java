package cielo.clientes.domain.PessoaJuridica;


import cielo.clientes.domain.PessoaFisica.PessoaFisica;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface PessoaJuridicaRepository extends JpaRepository<PessoaJuridica, Long>{
    Page<PessoaJuridica> findAllByAtivoTrue(Pageable paginacao);

    List<PessoaJuridica> findByCnpj(String cnpj);
}
