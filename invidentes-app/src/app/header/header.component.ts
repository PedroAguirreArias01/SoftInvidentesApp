import {Component} from '@angular/core';
/**
 * @description Clase que representa el header
 */
@Component({
  selector: 'app-header',
  templateUrl: './header.component.html'
})
export class HeaderComponent {

  /**
   * Titulo de la aplicacion
   */
  title: string = 'AppInvidentes';
}
