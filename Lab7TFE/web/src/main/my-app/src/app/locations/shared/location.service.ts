import {Injectable} from '@angular/core';

import {HttpClient} from "@angular/common/http";


import {Observable} from "rxjs";
import {LocationModel} from "./location.model";

import {map} from "rxjs/operators";


@Injectable()
export class LocationService {
  private locationsUrl = 'http://localhost:8080/api/locations';

  constructor(private httpClient: HttpClient) {
  }

  getLocation(): Observable<LocationModel[]> {
    return this.httpClient
      .get<Array<LocationModel>>(this.locationsUrl);
  }

  saveLocation(name, altitude, typeOfHike, coordinates, city): Observable<LocationModel> {
    const location = {name, altitude, typeOfHike, coordinates, city};
    return this.httpClient
      .post<LocationModel>(this.locationsUrl, location);
  }

  getLoc(id: number): Observable<LocationModel> {
    return this.getLocation()
      .pipe(
        map(locations => locations.find(location => location.id === id))
      );
  }

  update(location): Observable<LocationModel> {
    const url = `${this.locationsUrl}/${location.id}`;
    return this.httpClient
      .put<LocationModel>(url, location);
  }
}
