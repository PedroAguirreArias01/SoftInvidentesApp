import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import {AngularMaterial} from './angularMaterial';
import { AppComponent } from './app.component';
import {HeaderComponent} from './header/header.component';
import {FooterComponent} from './footer/footer.component';
import { ColaboradorComponent } from './colaborador/colaborador.component';
import { ColaboradorService } from "./services/colaboradorService";
import { PaginaPricipalComponent } from './pagina-pricipal/pagina-pricipal.component';
import { PqrsFormComponent } from './pqrs-form/pqrs-form.component';
import { NormativaFormComponent } from './normativa-form/normativa-form.component';
//TODO
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { LoginComponent } from './login/login.component';
import { ColaboradorFormComponent } from './colaborador/colaborador-form.component';
import { FormsModule } from '@angular/forms';
import { ReactiveFormsModule } from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';

//--------------paginado-------------------
import { NgxPaginationModule } from 'ngx-pagination';

@NgModule({
  declarations: [
    AppComponent,
    HeaderComponent,
    FooterComponent,
    ColaboradorComponent,
    PaginaPricipalComponent,
    PqrsFormComponent,
    NormativaFormComponent,
    LoginComponent,
    ColaboradorFormComponent
  ],
  imports: [
    BrowserModule,
    BrowserAnimationsModule,
    AppRoutingModule,
    FormsModule,
    ReactiveFormsModule,
    HttpClientModule,
    NgxPaginationModule,
    AngularMaterial
  ],
  providers: [ColaboradorService],
  bootstrap: [AppComponent]
})
export class AppModule { }
