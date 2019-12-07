package com.app.invidentes.models.entity;

/**
 * Clase que determina el tipo de normatividad
 * @author pedro
 *
 */
public enum TipoNormativaEnum {

	LEY("enum.normatividad.ley"), 
	DECRETO("enum.normatividad.decreto");
	/**
	 * Atributo que contiene la clave del mensaje para la internacionalizacion
	 */
	private String codigoMensaje;

	/**
	 * Constructor que recibe como parametro el codigo del mensaje
	 * 
	 * @param codigoMensaje, Clave del mensaje para para internacionalizacion
	 */
	TipoNormativaEnum(String codigoMensaje) {
		this.codigoMensaje = codigoMensaje;
	}

	/**
	 * Metodo que retorna el valor del atributo
	 * 
	 * @return cadena con el codigo del mensaje
	 */
	public String getCodigoMensaje() {
		return codigoMensaje;
	}

	/**
	 * Metodo que establece el valor del atributo
	 *
	 * @param codigoMensaje
	 */
	public void setCodigoMensaje(String codigoMensaje) {
		this.codigoMensaje = codigoMensaje;
	}
	
	/**
	 * 
	 * Metodo encargado de 
	 * <b>Caso de Uso</b>
	 * @author pedro
	 * 
	 * @return
	 */
	public String  prubeba() {
		return null;
	}
}
