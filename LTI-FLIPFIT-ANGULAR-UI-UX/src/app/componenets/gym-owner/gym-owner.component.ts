import { Component, OnInit, ViewChild } from '@angular/core';
import { OwnerService } from '../../services/owner.service';
import { GymCenter } from '../../models/gym-center';
import { GymCenterAddressInt } from '../../models/gym-center-address-int';
import { Router } from '@angular/router';
import { NgForm } from '@angular/forms';

interface Slot {
  centerId: number;
  slotName: String;
  startTime: String;
  endTime: String;
  capacity: number;
}


@Component({
  selector: 'app-gym-owner',
  templateUrl: './gym-owner.component.html',
  styleUrl: './gym-owner.component.css'
})
export class GymOwnerComponent implements OnInit {
  centers: any[] = [];
  showAddCenterForm = false;
  showAddSlotForm = false;
  selectedCenterId: number | null = null;

  centerAddress: GymCenterAddressInt = {
    address1: '',
    address2: '',
    city: '',
    state: '',
    pincode: 0,
    country: ''
  }
  userId: String | null = localStorage.getItem("userId");
  newCenter: GymCenter = {
    centerId: 0,
    centerName: '',
    city: '',
    isApproved: false,
    gymOwnerId: Number(this.userId),
    description: '',
    contactPerson: '',
    phone: '',
    email: '',
    centerLocation: this.centerAddress,
  };
  newSlot: Slot = { centerId: 0, slotName: '',capacity: 0, startTime: '', endTime: '' };

  activeView: string = 'centers';

  @ViewChild('addcenterform') addcenterform!: NgForm;
  @ViewChild('addslotform') addslotform!: NgForm;

  constructor(private _httpservice: OwnerService, private router: Router) { }

  ngOnInit() {
    this.loadCenters(this.newCenter.gymOwnerId);
  }

  setView(view: string): void {
    this.activeView = view;
  }

  loadCenters(id: number) {
    this._httpservice.getCentersByOwnerId(id).subscribe(data => {
      this.centers = data
      console.log(data);
    });
  }

  addCenter() {
    this._httpservice.addCenter(this.newCenter).subscribe(() => {
      alert(`${this.newCenter.centerName} Added Successfully`);
      this.addcenterform.reset();
      this.loadCenters(this.newCenter.gymOwnerId);
    });
  }

  addSlot() {
    this._httpservice.addSlot(this.newSlot).subscribe(() => {
      alert(`${this.newSlot.slotName} Added Successfully`);
      this.addslotform.reset();
      this.loadCenters(this.newCenter.gymOwnerId);
    });
  }


}