package cielo.clientes.domain.PessoaFisica;

import cielo.clientes.domain.PessoaFisica.PessoaFisica;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PessoaFisicaRepository extends JpaRepository<PessoaFisica, Long> {
    Page<PessoaFisica> findAllByAtivoTrue(Pageable paginacao);
}
