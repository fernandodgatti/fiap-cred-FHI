package br.com.fhi.fiapcredito.repository;

//import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.data.jpa.repository.Query;

import br.com.fhi.fiapcredito.entity.Aluno;

public interface AlunoRepository extends JpaRepository<Aluno, String> {

	/*@Query(value = "select * from Aluno a where a.nome_aluno = :nome")
	List<Aluno> buscarAlunoPorNome(String nome);*/

}
