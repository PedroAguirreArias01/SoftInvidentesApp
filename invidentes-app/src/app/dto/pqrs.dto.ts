import { RespuestaDTO } from './respuesta.dto';
import { PersonaDTO } from './persona.dto';

/**
 * @author Pedro Aguirre Arias <pedro.aguirre@uptc.edu.co>
 * @description clase que representa la entidad de preguntas quejas reclamos o sujerencias
 */
export class PqrsDTO {

    /**
     * Atributo que representa el id de la entidad
     */
    public id: number;

    /**
     * Atributo que representa la descripcion detallada de la problematica
     */
    public descripcion: string;

    /**
     * Atributo que representa el tipo de informacion 
     * pregunta, queja, reclamo, sugerencia
     */
    public tipoPqrsEnum: string;

    /**
     * Lista de respuestas realizadas por los usuarios
     */
    public respuestas: RespuestaDTO[]=[];

    /**
     * @description Atributo que representa a la persona que realiza la queja reclamo o sujerencia
     */
    public persona: PersonaDTO;

}