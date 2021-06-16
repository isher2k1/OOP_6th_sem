import {NgModule} from '@angular/core';
import {BrowserModule} from '@angular/platform-browser';

import {AppComponent} from './app.component';
import {TablesMenuComponent} from './tables-menu/tables-menu.component';
import {DatabaseComponent} from './database/database.component';
import {BrowserAnimationsModule} from '@angular/platform-browser/animations';
import {MatButtonModule} from '@angular/material/button';
import {MatToolbarModule} from '@angular/material/toolbar';
import {MatTableModule} from '@angular/material/table';
import {MatPaginatorModule} from '@angular/material/paginator';
import {MatInputModule} from '@angular/material/input';
import {MatCardModule} from '@angular/material/card';
import {MatSidenavModule, MatSidenavContainer} from '@angular/material/sidenav';
import {FlexLayoutModule} from '@angular/flex-layout';
import {ToolbarComponent} from './toolbar/toolbar.component';
import {TableComponent} from './table/table.component';
import {FormsModule, ReactiveFormsModule} from '@angular/forms';
import {Routes, RouterModule} from '@angular/router';
import {AuthComponent} from './auth/auth.component';
import { HttpClientModule, HttpClient } from '@angular/common/http';
import { InsertComponent } from './insert/insert.component';

const routes: Routes = [
  {path: '', redirectTo: 'login', pathMatch: 'full'},
  {path: 'table', component: ToolbarComponent},
  {path: 'login', component: AuthComponent},
  {path: 'insert', component: InsertComponent},
];

@NgModule({
  declarations: [
    AppComponent,
    TablesMenuComponent,
    DatabaseComponent,
    ToolbarComponent,
    TableComponent,
    AuthComponent,
    InsertComponent,
  ],
  imports: [
    BrowserModule,
    BrowserAnimationsModule,
    MatButtonModule,
    FlexLayoutModule,
    MatToolbarModule,
    MatSidenavModule,
    MatTableModule,
    MatPaginatorModule,
    MatInputModule,
    FormsModule,
    RouterModule.forRoot(routes),
    MatCardModule,
    ReactiveFormsModule,
    HttpClientModule
  ],
  exports: [
    RouterModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule {
}
