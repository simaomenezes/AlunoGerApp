/**
 * 
 */
package com.simaomenezes.model;

/**
 * @author simao
 *
 */
public class Aluno {
	/**
	 * Atributos do modelo, representam as colunas do banco de dados.
	 **/	
	private String name;
	private String telefone;
	private String endereco;
	private double nota1, nota2, media;
	private String foto;
	
	/**
	 * 
	 */
	public Aluno() {
		// TODO Auto-generated constructor stub
	}
	
	private int id;
	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the telefone
	 */
	public String getTelefone() {
		return telefone;
	}

	/**
	 * @param telefone the telefone to set
	 */
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	/**
	 * @return the endereco
	 */
	public String getEndereco() {
		return endereco;
	}

	/**
	 * @param endereco the endereco to set
	 */
	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	/**
	 * @return the nota1
	 */
	public double getNota1() {
		return nota1;
	}

	/**
	 * @param nota1 the nota1 to set
	 */
	public void setNota1(double nota1) {
		this.nota1 = nota1;
	}

	/**
	 * @return the nota2
	 */
	public double getNota2() {
		return nota2;
	}

	/**
	 * @param nota2 the nota2 to set
	 */
	public void setNota2(double nota2) {
		this.nota2 = nota2;
	}

	/**
	 * @return the media
	 */
	public double getMedia() {
		return media;
	}

	/**
	 * @param media the media to set
	 */
	public void setMedia(double media) {
		this.media = media;
	}

	/**
	 * @return the foto
	 */
	public String getFoto() {
		return foto;
	}

	/**
	 * @param foto the foto to set
	 */
	public void setFoto(String foto) {
		this.foto = foto;
	}
	
	/**
	 * Retorna o id e o nome do aluno
	 **/
	public String toString(){
		return this.id + " - " + this.name;
	}
}
