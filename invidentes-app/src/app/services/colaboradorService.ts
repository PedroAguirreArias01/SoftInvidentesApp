import { Injectable, Injector } from '@angular/core';
import { ColaboradorDTO } from '../dto/colaborador.dto';
import { Observable, of } from 'rxjs';
import { HttpClient } from "@angular/common/http";

/**
 * @description clase que se encarga de gestionar los  servicios de colaborador
 * @author Pedro Aguirre Arias
 */
@Injectable({
  providedIn: 'root'
})
export class ColaboradorService {

  /**
   * Url que define la localizacion de los recursos 
   */
  private urlEndPoint: string = 'http://192.168.100.4:8080/api/colaboradores/';

   /**
   * @description contructor de la clase
   */
  constructor(injector: Injector, private http : HttpClient) { }  


  /**
   * @description metodo encargado de obtener todos los colaboradores que se encuentran en la base de datos
   * @author Pedro Aguirre Arias <pedro.aguirre@uptc.edu.co>
   */
  getColaboradores(): Observable<any> {
    return this.http.get(this.urlEndPoint);
  }

  /**
   * @description Metodo encargado de crear el colaborador
   * @param colaboradorDTO 
   */
  crearColaborador(colaboradorDTO: ColaboradorDTO): Observable<any> {
    return this.http.post(this.urlEndPoint, colaboradorDTO);
  }

  /**
   * @description Metodo encargado de modificar la informacion del colaborador
   */
  editar(colaboradorDTO: ColaboradorDTO): Observable<any> {
    return this.http.put(this.urlEndPoint, colaboradorDTO);
  }

  /**
   * @description Metodod encargado de elimanar un colaborador
   * @param id 
   */
  eliminar(id: number): Observable<any> {
    return this.http.delete(this.urlEndPoint+id);
  }

}
