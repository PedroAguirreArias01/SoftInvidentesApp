import { Component, OnInit } from '@angular/core';
import { FormGroup, FormBuilder, Validators } from '@angular/forms';
import { UsuarioService } from '../services/usuario.service';
import { UsuarioDTO } from '../dto/usuario.dto';
import Swal from 'sweetalert2';
import { Router } from '@angular/router';

@Component({
  selector: 'app-Usuario-form',
  templateUrl: './Usuario-form.component.html',
  styleUrls: ['./Usuario-form.component.css']
})
export class UsuarioFormComponent implements OnInit {
  /**
  * Atributo que contiene los controles del formulario
  */
  public gestionarUsuarioForm: FormGroup;
  /**
   * Atributo que contendra la informacion del Usuario
   */
  private Usuario: UsuarioDTO;

  /**
   * Atributo que indica si se esta editando un comic
   */
  public editar: boolean;
  /**
   * Atributo para paginado de la tabla
   */
  public pageActual: number = 1;

  constructor(private fb: FormBuilder, private Usuarioservice: UsuarioService,private router: Router ) {
    this.gestionarUsuarioForm = this.fb.group({
      nombre: [null, Validators.required],
      apellido: [null, Validators.required],
      email: [null, Validators.required],
      usuario: [null, Validators.required],
      password: [null, Validators.required],
      rol: [null, Validators.required],
    });
  }

  ngOnInit() {
  }

  /**
     * @description Metodo que permite validar el formulario y crear o actulizar un Usuario
     */
  public crearActualizar(): void {
    if (this.gestionarUsuarioForm.invalid) {
      return;
    }
    this.Usuario = new UsuarioDTO();
    this.Usuario.nombre = this.gestionarUsuarioForm.controls.nombre.value;
    this.Usuario.apellido = this.gestionarUsuarioForm.controls.apellido.value;
    this.Usuario.email = this.gestionarUsuarioForm.controls.email.value;
    this.Usuario.usuario = this.gestionarUsuarioForm.controls.usuario.value;
    this.Usuario.contrasena = this.gestionarUsuarioForm.controls.password.value;
    if (!this.editar) {
      this.Usuarioservice.crearUsuario(this.Usuario).subscribe(resultadoDTO => {
        if (resultadoDTO.exitoso) {
          Swal.fire(
            'Usuario creado con exito!',
            'success'
          );
          this.limpiarFormulario();
          this.router.navigate(['Usuarioes']);
        }
      }, error => {
        console.log(error);
      });

    } else {
      this.Usuarioservice.editar(this.Usuario).subscribe(resultadoDTO => {
        if (resultadoDTO.exitoso) {
          Swal.fire(
            'Comic modificado con exito!',
            'success'
          );
          this.limpiarFormulario();
          this.editar = false;
        }
      });
    }
  }

  /**
  * @description metodo encargado de limpiar el formualrio
  * @author Pedro Aguirre Arias
  */
  private limpiarFormulario(): void {
    this.gestionarUsuarioForm.controls.nombre.setValue(null);
    this.gestionarUsuarioForm.controls.apellido.setValue(null);
    this.gestionarUsuarioForm.controls.email.setValue(null);
    this.gestionarUsuarioForm.controls.usuario.setValue(null);
    this.gestionarUsuarioForm.controls.password.setValue(null);
  }

}
