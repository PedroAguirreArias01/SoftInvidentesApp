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


  constructor(private http: HttpClient) { }

  login(usuario: UsuarioDTO): Observable<any> {
    let params = new URLSearchParams();
    params.set('grant_type', 'password');
    params.set('username', usuario.usuario);
    params.set('password', usuario.contrasena);
    console.log(params.toString());
    
    return this.http.post(this.urlEndPoint, params.toString(), this.httpOptions)
  }
}
