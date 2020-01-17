/**
 * @description clase que representa la entidad colaborador
 * @author Pedro Aguirre Arias
 */
export class UsuarioDTO {
    /**
     * atributo que representa el id del colaborador
     */
    public id: number;
    /**
     * Atributo que representa el nombre del colaborador
     */
    public nombre: string;
    /**
     * Atributo que representa el apellido del colaborador
     */
    public apellido: string;
    /**
     * Atributo que representa la fecha de creacion del colaborador 
     */
    public createAt: Date;
    /**
     * Atributo que representa el email del colaborador
     */
    public email: string;
    /**
     * Atributo que representa el usuario con el que iniciara sesion el colaborador
     */
    public usuario: string;
    /**
     * Atributo que representa la contraseña del colaborador
     */
    public contrasena: string;
}