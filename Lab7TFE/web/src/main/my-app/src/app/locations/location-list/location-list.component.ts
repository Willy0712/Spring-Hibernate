import {Component, OnInit} from '@angular/core';
import {LocationModel} from "../shared/location.model";
import {LocationService} from "../shared/location.service";
import {Router} from "@angular/router";

@Component({
  selector: 'app-location-list',
  templateUrl: './location-list.component.html',
  styleUrls: ['./location-list.component.css']
})

export class LocationListComponent implements OnInit {
  locations: LocationModel[];
  allLocations: Array<LocationModel>;
  errorMessage: string;
  selectedLocation: LocationModel;

  constructor(private locationService: LocationService,
              private router: Router) {
  }

  ngOnInit(): void {
    this.locationService.getLocation()
      .subscribe(
        locations => this.allLocations = locations,
        error => this.errorMessage = <any>error);
  }

  addLocation() {
    this.router.navigate(["locations/new"]);
  }
  getLocations() {
    this.locationService.getLocation()
      .subscribe(locations => this.allLocations = locations,
        error => this.errorMessage = <any>error);
  }

  onSelect(location: LocationModel): void {
    this.selectedLocation = location;
  }

  gotoDetail(): void {
    this.router.navigate(['/location/detail', this.selectedLocation.id]);
  }
}
