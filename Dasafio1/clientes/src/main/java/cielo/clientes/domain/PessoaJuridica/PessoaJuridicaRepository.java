package cielo.clientes.domain.PessoaJuridica;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface PessoaJuridicaRepository extends JpaRepository<PessoaJuridica, Long>{
    Page<PessoaJuridica> findAllByAtivoTrue(Pageable paginacao);
}
