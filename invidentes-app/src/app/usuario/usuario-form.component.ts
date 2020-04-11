import { Component, OnInit, Output, EventEmitter } from '@angular/core';
import { FormGroup, FormBuilder, Validators } from '@angular/forms';
import { UsuarioService } from '../services/usuario.service';
import { UsuarioDTO } from '../dto/usuario.dto';
import Swal from 'sweetalert2';
import { Router } from '@angular/router';
import { RolDTO } from '../dto/rol.dto';

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
   * Atributo que representa el rol del usuario
   */
  public rol: RolDTO;

  public roles: RolDTO[] = [];

  /**
   * Atributo para paginado de la tabla
   */
  public pageActual: number = 1;
  /**
   * lista de usuarios que se encuantran en la base de datos
   */
  public usuarios: UsuarioDTO[] = [];

  @Output() isRol = new EventEmitter<boolean>();

  constructor(private fb: FormBuilder, private usuarioservice: UsuarioService, private router: Router) {
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
    this.getRoles();
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
    this.roles.forEach(element => {
      if (element.nombre === this.gestionarUsuarioForm.controls.rol.value) {
        this.rol = element;
      }
    });

    this.Usuario.rol = this.rol;
    console.log(JSON.stringify(this.Usuario));
    this.usuarioservice.crearUsuario(this.Usuario).subscribe(respuesta => {
      Swal.fire(
        'Usuario creado con exito!',
        'success'
      );
      this.usuarios.push(respuesta.body)
      this.limpiarFormulario();
    })
  }

  getRoles() {
    this.usuarioservice.getRoles().subscribe(roles => {
      this.roles = roles;
    })
  }

  /**
  * @description metodo encargado de limpiar el formualrio
  * @author Pedro Aguirre Arias
  */
  private limpiarFormulario(): void {
    this.gestionarUsuarioForm.reset();
  }

  /**
   * @description Metodo encargado de consultar todos los usuarios 
   * que se encuentran en la base de datos
   * @author Pedro Aguirre Arias <pedro.aguirre@uptc.edu.co>
   */
  getUsuarios() {
    this.usuarioservice.getUsuarios().subscribe(
      usuarios => {
        this.usuarios = usuarios
      }
    );
  }

  /**
     * @description metodo encargado de elimar usuario
     * @author Pedro Aguirre Arias
     * @param usuario 
     */
  delete(usuario: UsuarioDTO) {
    const swalWithBootstrapButtons = Swal.mixin({
      customClass: {
        confirmButton: 'btn btn-success',
        cancelButton: 'btn btn-danger'
      },
      buttonsStyling: false
    })

    swalWithBootstrapButtons.fire({
      title: 'Estás seguro?',
      text: "No podrás revertir los cambios!",
      icon: 'warning',
      showCancelButton: true,
      confirmButtonText: 'Si, bórralo!',
      cancelButtonText: 'No, cancelar!',
      reverseButtons: true
    }).then((result) => {
      if (result.value) {
        let usuarioAux: UsuarioDTO = usuario;
        this.usuarioservice.eliminar(usuarioAux.id).subscribe(resultadoDTO => {
          if (resultadoDTO.exitoso) {
            swalWithBootstrapButtons.fire(
              'Eliminado!',
              'El usuario: ' + usuarioAux.nombre + '  ha sido eliminado.',
              'success'
            )
            this.getUsuarios();
          } else {
            swalWithBootstrapButtons.fire(
              'No se ha eliminado!',
              'El usuario: ' + usuarioAux.nombre + '  No ha sido eliminado.',
              'success'
            )
          }
        });
      } else if (
        /* Read more about handling dismissals below */
        result.dismiss === Swal.DismissReason.cancel
      ) {
        swalWithBootstrapButtons.fire(
          'Cancelado',
          'Tu usuario esta seguro :)',
          'error'
        )
      }
    })
  }

  cambiarEstado(){
    this.isRol.emit(true);
  }

}
