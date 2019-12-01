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

  private urlEndPoint: string = 'http://localhost:8080/api/colaboradores/';

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

  crearColaborador(colaboradorDTO: ColaboradorDTO): Observable<any> {
    return this.http.post(this.urlEndPoint, colaboradorDTO);
  }

  editar(colaboradorDTO: ColaboradorDTO): Observable<any> {
    return this.http.put(this.urlEndPoint, colaboradorDTO);
  }

  eliminar(id: number): Observable<any> {
    return this.http.delete(this.urlEndPoint+id);
  }

}
