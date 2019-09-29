import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { AppComponent } from './app.component';
import { ShoppingListComponent } from './shopping-list/shopping-list.component';
import {MatListModule} from '@angular/material/list';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { DialogComponent } from './dialog/dialog.component';
import { HttpClientModule } from '@angular/common/http';
import { ConfigComponent } from './config/config.component';


@NgModule({
  declarations: [
    AppComponent,
    ShoppingListComponent,
    BrowserModule,
    HttpClientModule,
    ConfigComponent,
  ],
  entryComponents: [
    DialogComponent
  ],
  imports: [
    AppComponent,
    BrowserModule,
    MatListModule,
    BrowserAnimationsModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
