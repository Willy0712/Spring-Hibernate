import {BrowserModule} from '@angular/platform-browser';
import {NgModule} from '@angular/core';
import {HttpClientModule} from '@angular/common/http';
import {FormsModule} from '@angular/forms';
import { LocationListComponent } from './locations/location-list/location-list.component';
import { LocationService } from './locations/shared/location.service';
import {AppComponent} from './app.component';
import {AppRoutingModule} from "./app-routing.module";
import { LocationComponent } from './locations/location.component';



@NgModule({
  declarations: [
    AppComponent,
    LocationListComponent,
    LocationComponent
  ],
  imports: [
    BrowserModule,
    FormsModule,
    HttpClientModule,
    AppRoutingModule,
  ],
  providers: [LocationService],
  bootstrap: [AppComponent]
})
export class AppModule { }
