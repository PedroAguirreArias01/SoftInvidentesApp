import { Component, OnInit } from '@angular/core';
import { ColaboradorDTO } from '../dto/colaborador.dto';
import { ColaboradorService } from "../services/colaboradorService";
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
  public colaboradores: ColaboradorDTO[];
  
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
      colaboradores => this.colaboradores = colaboradores
    );
  }

}
