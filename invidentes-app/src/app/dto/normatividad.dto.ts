/**
 * Entidad que contiene los atributos de  la normatividad
 * @author Pedro Aguirre Arias <pedro.aguirre@uptc.edu.co>
 */
export class NormatividadDTO {
    /**
	 * Atributo que representa el id de la informacion
	 */
	public id: number;
	/**
	 * Atributo que representa el titulo de la ley o decreto
	 */
	public titulo: string;
	/**
	 * Atributo que representa una pequennia descripcion de la informacion
	 */
	public descripcion: string;
	/**
	 * Atributo que representa el contenido total de la informacion
	 */
	public contenido: string;
	/**
	 * Atributo quue representa el tipo de informacion 
	 */
	public tipoNormativaEnum: string;
}