import { Injectable, Injector } from '@angular/core';
import { UsuarioDTO } from '../dto/usuario.dto';
import { Observable, of, throwError } from 'rxjs';
import {catchError} from 'rxjs/operators';
import { HttpClient } from "@angular/common/http";
import Swal from 'sweetalert2';
import { RolDTO } from '../dto/rol.dto';
import { URL_SERVIDOR } from 'src/assets/constantes/configServer';
import { RouterLink, Router } from '@angular/router';
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
  private urlEndPoint: string = URL_SERVIDOR+'api/usuarios/';

  /**
   * Atributo que reprsenta la localizacion de ls recurssos del rol del usuario
   */
  private urlRol: string = URL_SERVIDOR+'api/usuarios/rol/';

   /**
   * @description contructor de la clase
   */
  constructor(injector: Injector, private http : HttpClient, private router: Router) { }  

  isNoAutorizado(e): boolean{
    if(e.status == 401 || e.status == 403){
      this.router.navigate["/login"];
      return true;
    }
    return false;
  }


  /**
   * @description metodo encargado de obtener todos los Usuarioes que se encuentran en la base de datos
   * @author Pedro Aguirre Arias <pedro.aguirre@uptc.edu.co>
   */
  getUsuarios(): Observable<any> {
    return this.http.get(this.urlEndPoint).pipe(
      catchError(e => {
        this.isNoAutorizado(e);
        Swal.fire('Error al cargar los usuarios', e.error.mensaje, 'error');
        return throwError(e);
      })
    );
  }

  /**
   * @description Metodo encargado de crear el Usuario
   * @param usuarioDTO 
   */
  crearUsuario(usuarioDTO: UsuarioDTO): Observable<any> {
    return this.http.post(this.urlEndPoint, usuarioDTO).pipe(
      catchError(e => {
        if(this.isNoAutorizado(e)){
          return throwError(e);
        }
        Swal.fire('Error al crear', e.error.mensaje, 'error');
        return throwError(e);
      })
    );
  }

  /**
   * @description Metodo encargado de modificar la informacion del Usuario
   */
  editar(usuarioDTO: UsuarioDTO): Observable<any> {
    return this.http.put(`${this.urlEndPoint}${usuarioDTO.id}`, usuarioDTO).pipe(
      catchError(e => {
        if(this.isNoAutorizado(e)){
          return throwError(e);
        }
        Swal.fire('Error al editar', e.error.mensaje, 'error');
        return throwError(e);
      })
    );
  }

  /**
   * @description Metodod encargado de elimanar un Usuario
   * @param id 
   */
  eliminar(id: number): Observable<any> {
    return this.http.delete(`${this.urlEndPoint}${id}`).pipe(
      catchError(e => {
        if(this.isNoAutorizado(e)){
          return throwError(e);
        }
        Swal.fire('Error al eliminar', e.error.mensaje, 'error');
        return throwError(e);
      })
    );
  }

  /**
   * Metodo que se encarga de crear ek rol de un usuario
   * @param rol 
   */
  crearRol(rol: RolDTO): Observable<any> {
    return this.http.post(this.urlRol, rol).pipe(
      catchError(e => {
        if(this.isNoAutorizado(e)){
          return throwError(e);
        }
        Swal.fire('Error al agregar!', e.error.mensaje, 'error');
        return throwError(e);
      })
    )
  }

   /**
   * @description metodo encargado de obtener todos los roles que se encuentran en la base de datos
   * @author Pedro Aguirre Arias <pedro.aguirre@uptc.edu.co>
   */
  getRoles(): Observable<any> {
    return this.http.get(this.urlRol).pipe(
      catchError(e => {
        if(this.isNoAutorizado(e)){
          return throwError(e);
        }
        Swal.fire('Error al cargar los roles', e.error.mensaje, 'error');
        return throwError(e);
      })
    );
  }

  /**
   * @description Metodo encargado de modificar la informacion del rol
   */
  editarRol(rol: RolDTO): Observable<any> {
    return this.http.put(`${this.urlRol}${rol.id}`, rol).pipe(
      catchError(e => {
        if(this.isNoAutorizado(e)){
          return throwError(e);
        }
        Swal.fire('Error al editar', e.error.mensaje, 'error');
        return throwError(e);
      })
    );
  }

  /**
   * @description Metodod encargado de elimanar el rol
   * @param id 
   */
  eliminarRol(id: number): Observable<any> {
    return this.http.delete(`${this.urlRol}${id}`).pipe(
      catchError(e => {
        if(this.isNoAutorizado(e)){
          return throwError(e);
        }
        Swal.fire('Error al eliminar', e.error.mensaje, 'error');
        return throwError(e);
      })
    );
  }

}
