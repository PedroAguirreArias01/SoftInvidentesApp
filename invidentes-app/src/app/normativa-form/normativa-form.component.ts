import { Component, OnInit } from '@angular/core';
import { NormatividadDTO } from '../dto/normatividad.dto';
import { FormGroup, FormBuilder, Validators } from '@angular/forms';
import { NormatividadService } from '../services/normatividad.service';
import { Router } from '@angular/router';
import Swal from 'sweetalert2';
import { TipoNormativaDTO } from '../dto/tipoNormativa.dto';
/**
 * @descripcion clase que se encarga de la gestion normativa
 * @author Pedro Aguirre Arias <pedro.aguirre@uptc.edu.co>
 */
@Component({
  selector: 'app-normativa-form',
  templateUrl: './normativa-form.component.html',
  styleUrls: ['./normativa-form.component.css']
})
export class NormativaFormComponent implements OnInit {

   /**
  * Atributo que contiene los controles del formulario
  */
 public gestionarNormatividadForm: FormGroup;
 /**
  * Atributo que contendra la informacion del normatividad
  */
 private normatividad: NormatividadDTO;

 /**
  * Atributo que indica si se esta editando un comic
  */
 public editar: boolean;
 /**
  * Atributo para paginado de la tabla
  */
 public pageActual: number = 1;

 public listaTipoNormatividad: TipoNormativaDTO[] = [];

public listaNormatividad: NormatividadDTO[] =[];

public idNormatividad: number;

 constructor(private fb: FormBuilder, private normatividadservice: NormatividadService,private router: Router ) {
   this.gestionarNormatividadForm = this.fb.group({
     titulo: [null, Validators.required],
     descripcion: [null, Validators.required],
     contenido: [null, Validators.required],
     tipoNormativaEnum: [null, Validators.required],
   });
 }

 ngOnInit() {
   this.obtenerTodaTipoNormatividad();
   this.obtenerTodaNormatividad();
 }

 /**
    * @descripcion Metodo que permite validar el formulario y crear o actulizar la normatividad
    */
 public crearActualizar(): void {
   if (this.gestionarNormatividadForm.invalid) {
     return;
   }
   this.normatividad = new NormatividadDTO();
   this.normatividad.titulo = this.gestionarNormatividadForm.controls.titulo.value;
   this.normatividad.descripcion = this.gestionarNormatividadForm.controls.descripcion.value;
   this.normatividad.contenido = this.gestionarNormatividadForm.controls.contenido.value;
   this.normatividad.tipoNormativa = this.gestionarNormatividadForm.controls.tipoNormativaEnum.value;
   if (!this.editar) {
     console.log(this.normatividad);
     this.normatividadservice.crear(this.normatividad).subscribe(respuesta => {
       if(respuesta !== null){
        this.listaNormatividad.push(respuesta);
        this.limpiarFormulario();
       }
     }, error => {
       console.log(error);
     });

   } else {
     this.normatividad.id = this.idNormatividad;
     console.log(this.normatividad);
     this.normatividadservice.editar(this.normatividad).subscribe(resultado => {
       console.log('editar resultado: '+JSON.stringify(resultado));
         this.limpiarFormulario();
         this.editar = false;
         this.obtenerTodaNormatividad();
     });
   }
 }

 /**
 * @descripcion metodo encargado de limpiar el formualrio
 * @author Pedro Aguirre Arias
 */
 private limpiarFormulario(): void {
   this.gestionarNormatividadForm.reset();
 }

 public editarNormatividad(normatividad: NormatividadDTO): void{
   this.editar = true;
   this.idNormatividad = normatividad.id;
   this.gestionarNormatividadForm.controls.titulo.setValue(normatividad.titulo);
   this.gestionarNormatividadForm.controls.descripcion.setValue(normatividad.descripcion);
   this.gestionarNormatividadForm.controls.contenido.setValue(normatividad.contenido);
   this.gestionarNormatividadForm.controls.tipoNormativaEnum.setValue(normatividad.tipoNormativa.nombre);
 }

 public eliminarNormativa(idNormatividad: number): void{
   this.normatividadservice.eliminar(idNormatividad).subscribe(respuesta => {
    console.log('esta es la respuesta: '+respuesta);
    this.obtenerTodaNormatividad();
   });
 }

 public obtenerTodaNormatividad(){
   this.normatividadservice.getNormatividad().subscribe(respuesta =>{
    console.table(respuesta)
    this.listaNormatividad = respuesta;
  })
 }

 public obtenerTodaTipoNormatividad(){
   this.normatividadservice.getTipoNormatividad().subscribe(respuesta => {
     console.table(respuesta)
     this.listaTipoNormatividad = respuesta;
   });
 }

 cancelar(){
   this.gestionarNormatividadForm.reset();
 }

}
