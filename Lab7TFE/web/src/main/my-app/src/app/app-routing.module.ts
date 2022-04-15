import {NgModule} from '@angular/core';
import {RouterModule, Routes} from '@angular/router';
import {LocationComponent} from "./locations/location.component";

const routes: Routes = [
  {path: 'locations', component: LocationComponent},
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
