import { RolDTO } from './rol.dto';

/**
 * @description clase que representa la entidad usuario
 * @author Pedro Aguirre Arias
 */
export class UsuarioDTO {
    /**
     * atributo que representa el id del usuario
     */
    public id: number;
    /**
     * Atributo que representa el nombre del usuario
     */
    public nombre: string;
    /**
     * Atributo que representa el apellido del usuario
     */
    public apellido: string;
    /**
     * Atributo que representa la fecha de creacion del usuario 
     */
    public createAt: Date;
    /**
     * Atributo que representa el email del usuario
     */
    public email: string;
    /**
     * Atributo que representa el usuario con el que iniciara sesion el usuario
     */
    public usuario: string;
    /**
     * Atributo que representa la contraseña del usuario
     */
    public contrasena: string;

    /**
     * Atributo que representa el rol que posee el usuario 
     * estos pueden ser Administrador, Colaborador, o otro tipo de rol 
     * que se desee crear 
     */
    public rol: RolDTO;
}