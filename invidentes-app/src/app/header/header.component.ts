import {Component} from '@angular/core';
/**
 * @description Clase que representa el header menu con los links de acceso a  cada pantalla
 * @author Pedro Aguirre Arias <pedro.aguirre@uptc.edu.co>
 */
@Component({
  selector: '<app-header>',
  templateUrl: './header.component.html',
  styleUrls: ['./header.component.css']
})
export class HeaderComponent {

  /**
   * Titulo de la aplicacion
   */
  title: string = 'AppInvidentes';

  
}
