package model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


@Entity
@Table(name = "medicao")
public class Medicao implements Serializable{
	private static final long serialVersionUID = 1L;
    
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    
    private double valor;
    
    private String unidade;
    
    @Temporal(TemporalType.DATE)
    private Date dt_medicao;
    
    @ManyToOne
    @JoinColumn(name = "idproduto")
    private Produto produto;
    	

	public Medicao(Long id, double valor, String unidade, Date dt_medicao, Produto produto) {
		super();
		this.id = id;
		this.valor = valor;
		this.unidade = unidade;
		this.dt_medicao = dt_medicao;
		this.produto = produto;
	}

	public Medicao() {
		super();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public double getValor() {
		return valor;
	}

	public void setValor(double valor) {
		this.valor = valor;
	}

	public String getUnidade() {
		return unidade;
	}

	public void setUnidade(String unidade) {
		this.unidade = unidade;
	}

	public Date getDt_Medicao() {
		return dt_medicao;
	}

	public void setDt_Medicao(Date dt_medicao) {
		this.dt_medicao = dt_medicao;
	}
	
	public Date getDt_medicao() {
		return dt_medicao;
	}

	public void setDt_medicao(Date dt_medicao) {
		this.dt_medicao = dt_medicao;
	}
	
	

	public Produto getProduto() {
		return produto;
	}

	public void setProduto(Produto produto) {
		this.produto = produto;
	}

	@Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        if (!(object instanceof Medicao)) {
            return false;
        }
        Medicao other = (Medicao) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.hibernate.entidade.Produto[ id=" + id + " ]";
    }

}
