import { Component, OnInit } from '@angular/core';
import { FormGroup, FormBuilder, Validators } from '@angular/forms';
import Swal from 'sweetalert2';
import { PqrsDTO } from '../dto/pqrs.dto';
import { Router } from '@angular/router';
import { PqrsService } from '../services/pqrs.service';
import { PersonaDTO } from '../dto/persona.dto';
/**
 * @description Clase que se encarga de la gestion de PQRS
 * @author Pedro Aguirre Arias <pedro.aguirre@uptc.edu.co>
 */
@Component({
  selector: 'app-pqrs-form',
  templateUrl: './pqrs-form.component.html',
  styleUrls: ['./pqrs-form.component.css']
})
export class PqrsFormComponent implements OnInit {

  /**
  * Atributo que contiene los controles del formulario
  */
 public gestionarPqrsdForm: FormGroup;
 /**
  * Atributo que contendra la informacion del pqrs
  */
 private pqrs: PqrsDTO;

 /**
  * Atributo que indica si se esta editando un comic
  */
 public editar: boolean;
 /**
  * Atributo para paginado de la tabla
  */
 public pageActual: number = 1;

 /**
  * Atributo que representa a la presona quien realiza la informacion
  * 
  */
 public persona: PersonaDTO;

 /**
  * Lista de pqrs
  */
 public listPqrs: PqrsDTO[]=[];

 constructor(private fb: FormBuilder, private pqrsservice: PqrsService,private router: Router ) {
   this.gestionarPqrsdForm = this.fb.group({
    nombre: [null, Validators.required],
    apellido: [null, Validators.required],
    documento: [null],
    direccion: [null, Validators.required],
    descripcion: [null, Validators.required],
    tipoPqrsEnum: [null, Validators.required]
   });
 }

 ngOnInit() {
  this.getPqrs();
 }


 getPqrs(){
  this.pqrsservice.getPqrs().subscribe(pqrs => {
    this.listPqrs = pqrs;
  })
 }

 /**
    * @descripcion Metodo que permite validar el formulario y crear o actulizar la pqrs
    */
 public crearActualizar(): void {
   if (this.gestionarPqrsdForm.invalid) {
     return;
   }
   this.pqrs = new PqrsDTO();
   this.persona = new PersonaDTO;
   this.persona.nombre = this.gestionarPqrsdForm.controls.nombre.value;
   this.persona.apellido = this.gestionarPqrsdForm.controls.apellido.value;
   this.persona.numIdentificacion = this.gestionarPqrsdForm.controls.documento.value;
   this.persona.direccion = this.gestionarPqrsdForm.controls.direccion.value;
   this.pqrs.descripcion = this.gestionarPqrsdForm.controls.descripcion.value;
   this.pqrs.tipoPqrsEnum = this.gestionarPqrsdForm.controls.tipoPqrsEnum.value;
   this.pqrs.persona = this.persona;
   if (!this.editar) {
     console.log(this.pqrs);
     this.pqrsservice.crear(this.pqrs).subscribe(resultadoDTO => {
       if (resultadoDTO.exitoso) {
         Swal.fire(
           'pqrs creada con exito!',
           'success'
         );
         this.limpiarFormulario();
         this.router.navigate(['paginaPrincipal']);
       }
     }, error => {
       console.log(error);
     });

   } else {
     this.pqrsservice.editar(this.pqrs).subscribe(resultadoDTO => {
       if (resultadoDTO.exitoso) {
         Swal.fire(
           'Información modificada con exito!',
           'success'
         );
         this.limpiarFormulario();
         this.editar = false;
       }
     });
   }
 }

 /**
 * @descripcion metodo encargado de limpiar el formualrio
 * @author Pedro Aguirre Arias
 */
 private limpiarFormulario(): void {
   this.gestionarPqrsdForm.controls.nombre.setValue(null);
   this.gestionarPqrsdForm.controls.apellido.setValue(null);
   this.gestionarPqrsdForm.controls.descripcion.setValue(null);
   this.gestionarPqrsdForm.controls.documento.setValue(null);
   this.gestionarPqrsdForm.controls.direccion.setValue(null);
   this.gestionarPqrsdForm.controls.tipoPqrsEnum.setValue(null);
 }

}
