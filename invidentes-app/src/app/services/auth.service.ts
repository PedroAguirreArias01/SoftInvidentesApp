import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { UsuarioDTO } from '../dto/usuario.dto';
import { URL_SERVIDOR } from 'src/assets/constantes/configServer';

@Injectable({
  providedIn: 'root'
})
export class AuthService {

  private urlEndPoint: string = URL_SERVIDOR + 'oauth/token';
  credenciales = btoa('invidentesapp' + ':' + 'invidentes123')
  httpOptions = {
    'headers': new HttpHeaders({
      'Content-Type': 'application/x-www-form-urlencoded',
      'Authorization': 'Basic ' + this.credenciales,
    })
  };

  private _usuario: UsuarioDTO;
  private _token: string;

  constructor(private http: HttpClient) { }

  login(usuario: UsuarioDTO): Observable<any> {
    let params = new URLSearchParams();
    params.set('grant_type', 'password');
    params.set('username', usuario.usuario);
    params.set('password', usuario.contrasena);
    console.log(params.toString());

    return this.http.post(this.urlEndPoint, params.toString(), this.httpOptions)
  }

  /**
   * Metodo encargado de guardar el usuario en la sesion
   * @param accessToken 
   */
  guardarUsuario(accessToken: string): void {
    let payload = this.obtenerDatosToken(accessToken);
    this._usuario = new UsuarioDTO();
    this._usuario.nombre = payload.nombre;
    this._usuario.apellido = payload.apellido;
    this._usuario.usuario = payload.user_name;
    this._usuario.rol = payload.authorities;
    sessionStorage.setItem('usuario', JSON.stringify(this._usuario));
  }

  /**
   * metodo encargado de guardar el token en la sesion
   * @param accessToken 
   */
  guardarToken(accessToken: string): void {
    this._token = accessToken;
    sessionStorage.setItem('token', this._token);
  }

  /**
   * 
   * @param accessToken Metodo que obtiene los datos del token 
   */
  obtenerDatosToken(accessToken: string): any {
    if (accessToken != null) {
      return JSON.parse(atob(accessToken.split(".")[1]));
    }
    return null;
  }

   /**
   * Metodo que verifica que el usuario este autenticado 
   */
  isAuthenticated(): boolean{
    let payload = this.obtenerDatosToken(this.token);
    if(payload != null && payload.user_name && payload.user_name.length >0){
      return true;
    }
    return false;
  }


  /**
   * Metodo que finaliza la sesion del usuario
   */
  salir(){
    this._token = null;
    this._usuario = null;
    sessionStorage.clear();
  }

  public get usuario(): UsuarioDTO{
    if(this._usuario != null){
      return this._usuario;
    }else if(this._usuario == null && sessionStorage.getItem('usuario') != null){
      this._usuario = JSON.parse(sessionStorage.getItem('usuario'));
      return this._usuario;
    }
    return new UsuarioDTO();
  }

  public get token(): string{
    if(this._token != null){
      return this._token;
    }else if(this._token == null && sessionStorage.getItem('token') != null){
      this._token = JSON.parse(sessionStorage.getItem('token'));
      return this._token;
    }
  }


}
