import { Component, OnInit } from '@angular/core';
import { ColaboradorDTO } from '../dto/colaborador.dto';
import { ColaboradorService } from "../services/colaboradorService";
import Swal from 'sweetalert2';
/**
 * @description Clase ColaboradorComponent donde contiene todos los metodos de gestion de 
 * colaboradores
 * @author Pedro Aguirre Arias <pedro.aguirre@uptc.edu.co>
 */
@Component({
  selector: 'colaborador',
  templateUrl: './colaborador.component.html',
  styleUrls: ['./colaborador.component.css']
})
export class ColaboradorComponent implements OnInit {

  /**
   * lista de colaboradores que se encuantran en la base de datos
   */
  public colaboradores: ColaboradorDTO[] = [];
  
  /**
   * Contructor de la clase ColaboradorComponent
   * @param colaboradorService 
   */
  constructor(private colaboradorService: ColaboradorService) { }

  /**
   * @description Evento angular que se ejecuta al invocar el componente
   * @author Pedro Aguirre Arias <pedro.aguirre@uptc.edu.co>
   */
  ngOnInit() {
    this.getColaboradores();
  }

  /**
   * @description Metodo encargado de consultar todos los colaboradores 
   * que se encuentran en la base de datos
   * @author Pedro Aguirre Arias <pedro.aguirre@uptc.edu.co>
   */
  getColaboradores(){
    this.colaboradorService.getColaboradores().subscribe(
      colaboradores =>{ this.colaboradores = colaboradores
      }
    );
  }

   /**
     * @description metodo encargado de elimar Colaborador
     * @author Pedro Aguirre Arias
     * @param colaborador 
     */
    eliminarComic(colaborador: ColaboradorDTO) {
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
              let colaboradorAux: ColaboradorDTO = colaborador;
              this.colaboradorService.eliminar(colaboradorAux.id).subscribe(resultadoDTO =>{
                  if(resultadoDTO.exitoso){
                      swalWithBootstrapButtons.fire(
                          'Eliminado!',
                          'El Colaborador: ' + colaboradorAux.nombre + '  ha sido eliminado.',
                          'success'
                      )
                      this.getColaboradores();
                  }else{
                      swalWithBootstrapButtons.fire(
                          'No se ha eliminado!',
                          'El colaborador: ' + colaboradorAux.nombre + '  No ha sido eliminado.',
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
                  'Tu Colaborador esta seguro :)',
                  'error'
              )
          }
      })
  }

  /**
     * @description metodo encargado de actualizar la información del comic
     * @author Pedro aguirre Arias;
     * @param comic 
     */
   /*  public editarComic(colaborador: ColaboradorDTO): void {
      this.posComicEdit = posicion;
      this.gestionarComicForm.controls.nombre.setValue(comic.nombre);
      this.gestionarComicForm.controls.editorial.setValue(comic.editorial);
      this.gestionarComicForm.controls.tematica.setValue(comic.tematica);
      this.gestionarComicForm.controls.coleccion.setValue(comic.coleccion);
      this.gestionarComicForm.controls.numeroPaginas.setValue(comic.numeroPaginas);
      this.gestionarComicForm.controls.precio.setValue(comic.precio);
      this.gestionarComicForm.controls.autores.setValue(comic.autores);
      this.gestionarComicForm.controls.color.setValue(comic.color);
      this.editar = true;
  } */

}
