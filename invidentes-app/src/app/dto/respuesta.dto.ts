import { PersonaDTO } from './persona.dto';

/**
 * Clase que representa la respuesta realizada por un usuario 
 * a una solicitus de preguntas quejas o reclamos o sugerencias 
 * @author Pedro Aguirre Arias <pedro.aguirre@uptc.edu.co>
 */
export class RespuestaDTO {
    /**
     * Atrinuto que representa el id de la respuesta
     */
    public id: number;
    /**
     * Atrinuto que representa la descripcion de la respuesta
     */
    public descripcion: string;
    /**
     * Atributo que representa la calificacion realizada por el usuario a esa respuesta
     */
    public calificacion: number;

    /**
     * usuario quien realizo la  repuesta
     */
    public persona: PersonaDTO;
}