import { Injectable, Injector } from '@angular/core';
import { UsuarioDTO } from '../dto/usuario.dto';
import { Observable, of } from 'rxjs';
import {catchError} from 'rxjs/operators';
import { HttpClient } from "@angular/common/http";

/**
 * @description clase que se encarga de gestionar los  servicios de Usuario
 * @author Pedro Aguirre Arias <pedro.aguirre@uptc.edu.co>
 */
@Injectable({
  providedIn: 'root'
})
export class UsuarioService {

  /**
   * Url que define la localizacion de los recursos 
   */
  private urlEndPoint: string = 'http://localhost:8080/api/usuarios/';

   /**
   * @description contructor de la clase
   */
  constructor(injector: Injector, private http : HttpClient) { }  


  /**
   * @description metodo encargado de obtener todos los Usuarioes que se encuentran en la base de datos
   * @author Pedro Aguirre Arias <pedro.aguirre@uptc.edu.co>
   */
  getUsuarios(): Observable<any> {
    return this.http.get(this.urlEndPoint);
  }

  /**
   * @description Metodo encargado de crear el Usuario
   * @param usuarioDTO 
   */
  crearUsuario(usuarioDTO: UsuarioDTO): Observable<any> {
    return this.http.post(this.urlEndPoint, usuarioDTO);
  }

  /**
   * @description Metodo encargado de modificar la informacion del Usuario
   */
  editar(usuarioDTO: UsuarioDTO): Observable<any> {
    return this.http.put(`${this.urlEndPoint}${usuarioDTO.id}`, usuarioDTO);
  }

  /**
   * @description Metodod encargado de elimanar un Usuario
   * @param id 
   */
  eliminar(id: number): Observable<any> {
    return this.http.delete(`${this.urlEndPoint}${id}`);
  }

}
