import { Component, OnDestroy, OnInit } from '@angular/core';
import { AdminService } from '../../services/admin.service';
import { GymOwner } from '../../models/gym-owner';
import { GymCenter } from '../../models/gym-center';

interface GymAdmin {

}

@Component({
  selector: 'app-gym-admin',
  templateUrl: './gym-admin.component.html',
  styleUrl: './gym-admin.component.css'
})
export class GymAdminComponent implements OnInit {

  activeView: string = 'home';

  centers: GymCenter[] = [];
  owners: any[] = [];

  pendingOwners: GymOwner[] = [];
  pendingCenters: GymCenter[] = [];

  constructor(private _httpservice: AdminService) { }

  ngOnInit() {
    this.loadCenters();
    this.loadOwners();
    this.getPendingOwners();
    this.getPendingCenters();
  }

  setView(view: string): void {
    this.activeView = view;
  }

  loadCenters() {
    this._httpservice.getCenters().subscribe(data => {
      this.centers = data
    });
  }

  loadOwners() {
    this._httpservice.getOwners().subscribe(data => {
      console.log("owner"+data);
      this.owners = data;
    });
  }

  getPendingOwners(){
    this._httpservice.getPendingOwners().subscribe(res => {
      this.pendingOwners = res;
    });
  }

  getPendingCenters(){
    this._httpservice.getPendingCenters().subscribe(res => {
      this.pendingCenters = res;
    });
  }

  approveGymOwner(id: number) {
    this._httpservice.approveGymOwner(id).subscribe(res => {
      this.getPendingOwners();
    })
  }

  approveGymCenter(id: number) {
    this._httpservice.approveGymCenter(id).subscribe(res => {
      this.getPendingCenters();
    })
  }

}
