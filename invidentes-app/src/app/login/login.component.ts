import { Component, OnInit } from '@angular/core';
import { FormGroup, FormBuilder, Validators } from '@angular/forms';
import { UsuarioDTO } from '../dto/usuario.dto';
import swal from 'sweetalert2';
import { AuthService } from '../services/auth.service';
import { Router } from '@angular/router';

/**
 * @description clase encargada de realizar el login del usuario
 * @author Pedro Aguirre Arias <pedro.aguirre@uptc.edu.co>
 */
@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  public formLogin: FormGroup;

  public usuario: UsuarioDTO;

  /**
   * @description Contructor de la clase LoginComponent
   */
  constructor(
    private formBuilder: FormBuilder, 
    private authServer: AuthService,
    private router: Router,
  ) {
    this.formLogin = formBuilder.group({
      usuario:  [null, Validators.required],
      contrasena: [null, Validators.required]
    })
    this.usuario = new UsuarioDTO();
   }

  /**
   * @description Metdodo que se inicia cuando el componente es iniciado
   * @author Pedro Aguirre Arias <pedro.aguirre@uptc.edu.co>
   */
  ngOnInit() {
    if(this.authServer.isAuthenticated()){
      this.router.navigate(['/administracion']);
      swal.fire('Login', 'Hola '+this.authServer.usuario.usuario+' ya estás autenticado', 'info');
    }else{
      swal.fire('Login', 'No estás autenticado!', 'info');
    }
  }

  login(): void{
    if(this.formLogin.invalid){
      swal.fire('Error Login', 'Usuario o Contraseña estan vacías!', 'error');
      return;
    }else{
      this.usuario.usuario = this.formLogin.controls.usuario.value;
      this.usuario.contrasena = this.formLogin.controls.contrasena.value;
      console.log(this.usuario);
      this.authServer.login(this.usuario).subscribe(respuesta=>{
        this.authServer.guardarUsuario(respuesta.access_token);
        this.authServer.guardarToken(respuesta.access_token);
        let usuario = this.authServer.usuario;
        console.log('respuesta: '+respuesta);
        this.router.navigate(['/administracion']);
        swal.fire('Login',  'Bienvenido: '+usuario.nombre+ ' Administracion Invidentes!','success');
      }, error => {
        if(error.status == 400){
          swal.fire('Error Login', 'Usuario o Contraseña incorrecta!', 'error');
        }
      }
      );
    }
  }

}
