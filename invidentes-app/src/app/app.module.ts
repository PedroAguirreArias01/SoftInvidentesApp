import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import {AngularMaterial} from './angularMaterial';
import { AppComponent } from './app.component';
import {HeaderComponent} from './header/header.component';
import {FooterComponent} from './footer/footer.component';
import { UsuarioComponent } from './usuario/usuario.component';
import { UsuarioService } from "./services/usuario.service";
import { PaginaPricipalComponent } from './pagina-pricipal/pagina-pricipal.component';
import { PqrsFormComponent } from './pqrs-form/pqrs-form.component';
import { NormativaFormComponent } from './normativa-form/normativa-form.component';
//Formularios reactivos 
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { FormsModule } from '@angular/forms';
import { ReactiveFormsModule } from '@angular/forms';
import { HttpClientModule, HTTP_INTERCEPTORS } from '@angular/common/http';

//--------------paginado-------------------
import { NgxPaginationModule } from 'ngx-pagination';
//-------------modulos----------------
import { LoginComponent } from './login/login.component';
import { UsuarioFormComponent } from './usuario/usuario-form.component';
import { QuienesSomosComponent } from './quienes-somos/quienes-somos.component';
import { PoliticasComponent } from './politicas/politicas.component';
import { GestionarRolComponent } from './gestionar-rol/gestionar-rol.component';
import { GestionarContenidoComponent } from './gestionar-contenido/gestionar-contenido.component';
import { MenuComponent } from './menu/menu.component';
//---------------flex layout
import { FlexLayoutModule } from '@angular/flex-layout';
import { CargarArchivosComponent } from './cargar-archivos/cargar-archivos.component';
import { AdminQuienesSomosComponent } from './admin-quienes-somos/admin-quienes-somos.component';
import { AdministracionComponent } from './administracion/administracion.component';
import { GestionPqrsComponent } from './gestion-pqrs/gestion-pqrs.component';
import { GerstionTipoNormatividadComponent } from './gerstion-tipo-normatividad/gerstion-tipo-normatividad.component';
import { AuthInterceptor } from './usuario/interceptors/auth.Interceptor';

// se importa el request interseptor

@NgModule({
  declarations: [
    AppComponent,
    HeaderComponent,
    FooterComponent,
    UsuarioComponent,
    PaginaPricipalComponent,
    PqrsFormComponent,
    NormativaFormComponent,
    LoginComponent,
    UsuarioFormComponent,
    QuienesSomosComponent,
    PoliticasComponent,
    GestionarRolComponent,
    GestionarContenidoComponent,
    MenuComponent,
    CargarArchivosComponent,
    AdminQuienesSomosComponent,
    AdministracionComponent,
    GestionPqrsComponent,
    GerstionTipoNormatividadComponent
  ],
  imports: [
    BrowserModule,
    BrowserAnimationsModule,
    AppRoutingModule,
    FormsModule,
    ReactiveFormsModule,
    HttpClientModule,
    NgxPaginationModule,
    AngularMaterial,
    FlexLayoutModule
    
  ],
  exports: [
    AngularMaterial  
  ],
  providers: [UsuarioService, {provide: HTTP_INTERCEPTORS, useClass: AuthInterceptor, multi: true}],
  bootstrap: [AppComponent]
})
export class AppModule { }
