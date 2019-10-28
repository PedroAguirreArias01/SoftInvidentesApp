import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import {RouterModule, Routes} from '@angular/router'
import { AppComponent } from './app.component';
import {HeaderComponent} from './header/header.component';
import {FooterComponent} from './footer/footer.component';
import { UsuariosComponent } from './usuarios/usuarios.component';
import {UsuarioService} from './usuarios/usuario.service';
import { PaginaPricipalComponent } from './pagina-pricipal/pagina-pricipal.component';
import { PqrsFormComponent } from './pqrs-form/pqrs-form.component';
import { NormativaFormComponent } from './normativa-form/normativa-form.component';

const routes: Routes = [
  {path: '', redirectTo: '/paginaPrincipal', pathMatch: 'full'},
  {path: 'paginaPrincipal', component: PaginaPricipalComponent},
  {path: 'usuarios', component: UsuariosComponent },
  {path: 'pqrsForm', component: PqrsFormComponent},
  {path: 'normativaForm', component: NormativaFormComponent}

]

@NgModule({
  declarations: [
    AppComponent,
    HeaderComponent,
    FooterComponent,
    UsuariosComponent,
    PaginaPricipalComponent,
    PqrsFormComponent,
    NormativaFormComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    RouterModule.forRoot(routes)
  ],
  providers: [UsuarioService],
  bootstrap: [AppComponent]
})
export class AppModule { }
