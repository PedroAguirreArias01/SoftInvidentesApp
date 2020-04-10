import { Component, OnInit } from '@angular/core';
import { UsuarioDTO } from '../dto/usuario.dto';
import { UsuarioService } from "../services/usuario.service";
import Swal from 'sweetalert2';
/**
 * @description Clase usuarioComponent donde contiene todos los metodos de gestion de 
 * usuarios
 * @author Pedro Aguirre Arias <pedro.aguirre@uptc.edu.co>
 */
@Component({
  selector: 'usuario',
  templateUrl: './usuario.component.html',
  styleUrls: ['./usuario.component.css']
})
export class UsuarioComponent implements OnInit {

  /**
   * lista de usuarios que se encuantran en la base de datos
   */
  public usuarios: UsuarioDTO[] = [];
  
  /**
   * Contructor de la clase usuarioComponent
   * @param usuarioService 
   */
  constructor(private usuarioService: UsuarioService) { }

  /**
   * @description Evento angular que se ejecuta al invocar el componente
   * @author Pedro Aguirre Arias <pedro.aguirre@uptc.edu.co>
   */
  ngOnInit() {

    
    this.getUsuarios();
  }

  /**
   * @description Metodo encargado de consultar todos los usuarios 
   * que se encuentran en la base de datos
   * @author Pedro Aguirre Arias <pedro.aguirre@uptc.edu.co>
   */
  getUsuarios(){
    this.usuarioService.getUsuarios().subscribe(
      usuarios =>{ 
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
              this.usuarioService.eliminar(usuarioAux.id).subscribe(resultadoDTO =>{
                  if(resultadoDTO.exitoso){
                      swalWithBootstrapButtons.fire(
                          'Eliminado!',
                          'El usuario: ' + usuarioAux.nombre + '  ha sido eliminado.',
                          'success'
                      )
                      this.getUsuarios();
                  }else{
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

}
