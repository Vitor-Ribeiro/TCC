package dao.tests;


import org.junit.Test;

import dao.EmpresaDaoImpl;
import dao.helper.HibernateUtil;
import model.Empresa;
import model.Endereco;
import util.UtilTeste;

import java.util.Date;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.junit.Assert;

/**
 *
 * @author Aluno
 */
public class EmpresaDaoTEST {

    private Empresa empresa;
    private Session session;
    private EmpresaDaoImpl empresaDAO;
    private Endereco endereco;

    public EmpresaDaoTEST() {
        empresaDAO = new EmpresaDaoImpl();
    }

    @Test
    public void testSalvar() {
        System.out.println("salvar");
        empresa = new Empresa(null,"nome " + UtilTeste.gerarCaracter(6));
        endereco = new Endereco(null,
                 "Logradouro " + UtilTeste.gerarCaracter(7),
                 UtilTeste.gerarNumero(3),
                 "Complemento " + UtilTeste.gerarCaracter(8),
                 "88106-785",
                 "Bairro " + UtilTeste.gerarCaracter(9),
                 "Cidade" + UtilTeste.gerarCaracter(10),                
                 "SC",
                 "Pais" + UtilTeste.gerarCaracter(5));
        empresa.setEndereco(endereco);  
        endereco.setEmpresa(empresa);
        session = HibernateUtil.abrirSessao();
        empresaDAO.salvarOuAlterar(empresa, session);
        session.close();
        Assert.assertNotNull(empresa.getId());
        Assert.assertNotNull(endereco.getId());
    }

   // @Test
     public void testAlterar() {
       System.out.println("alterar");
        primeiroEmpresaBanco();
        empresa.setNome("Nome alterado");
        empresa.setEndereco(endereco);
        session = HibernateUtil.abrirSessao();
        empresaDAO.salvarOuAlterar(empresa, session);
        Empresa empresaAlterado = empresaDAO.pesquisarPorId(empresa.getId(), session);
        session.close();
        Assert.assertEquals(empresaAlterado.getEndereco(), empresa.getEndereco());
        Assert.assertEquals(empresaAlterado.getNome(), empresa.getNome());
    }

     // @Test
    public void testPesquisarPorId() {
        System.out.println("pesquisarPorId");
        primeiroEmpresaBanco();
        session = HibernateUtil.abrirSessao();
        Empresa prodPesquisado = empresaDAO.pesquisarPorId(empresa.getId(), session);
        session.close();
        Assert.assertNotNull(prodPesquisado);
    }
    
    // @Test
    public void testExcluir() {
        System.out.println("excluir");
        primeiroEmpresaBanco();
        session = HibernateUtil.abrirSessao();
        empresaDAO.excluir(empresa, session);
        Empresa empresaExcluido = empresaDAO.pesquisarPorId(empresa.getId(), session);
        session.close();
        Assert.assertNull(empresaExcluido);
    }
    
    // @Test
    public void testPesquisarTodos() {
        System.out.println("pesquisarTodos");
        primeiroEmpresaBanco();
        session = HibernateUtil.abrirSessao();
        List<Empresa> empresas = empresaDAO.listarTodos(session);
        session.close();
        Assert.assertFalse(empresas.isEmpty());
    }
    
    

    public Empresa primeiroEmpresaBanco() {
        session = HibernateUtil.abrirSessao();
        Query consulta = session.createQuery("from Empresa");
        consulta.setMaxResults(1);
        empresa = (Empresa) consulta.uniqueResult();
        session.close();
        if (empresa == null) {
            testSalvar();
        }
        return empresa;
    }

}