package model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "produto")
public class Produto {
	private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    
    private String nome;
	
    private String serial;
    
    private double versao;
    
    private double fw_versao;
   
    
	public Produto() {
		super();
	}
	
	

	public Produto(Long id, String nome, String serial, double versao, double fw_versao) {
		super();
		this.id = id;
		this.nome = nome;
		this.serial = serial;
		this.versao = versao;
		this.fw_versao = fw_versao;
	}		

	public Long getId() {
		return id;
	}



	public void setId(Long id) {
		this.id = id;
	}



	public String getNome() {
		return nome;
	}



	public void setNome(String nome) {
		this.nome = nome;
	}



	public String getSerial() {
		return serial;
	}



	public void setSerial(String serial) {
		this.serial = serial;
	}



	public double getVersao() {
		return versao;
	}



	public void setVersao(double versao) {
		this.versao = versao;
	}



	public double getFw_versao() {
		return fw_versao;
	}



	public void setFw_versao(double fw_versao) {
		this.fw_versao = fw_versao;
	}



	@Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        if (!(object instanceof Produto)) {
            return false;
        }
        Produto other = (Produto) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.hibenarte.entidade.Produto[ id=" + id + " ]";
    }
}
