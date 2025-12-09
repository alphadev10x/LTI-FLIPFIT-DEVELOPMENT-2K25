import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { CustomerService } from '../../services/customer.service';

interface Slot {
  centerId: number;
  slotId: number;
  slotDate: Date;
  userId: number;
}

@Component({
  selector: 'app-customer',
  templateUrl: './customer.component.html',
  styleUrl: './customer.component.css'
})
export class CustomerComponent implements OnInit {

  centers: any[] = [];
  slotForm!: FormGroup;
  selectedCenterId: number | null = null;
  selectedSlotId: number | null = null;

  availableSlots: any[] = [];

  constructor(private fb: FormBuilder, private httpClient: HttpClient, private _httpservice: CustomerService) { }


  bookings: any;

  activeView: string = 'bookings';

  slot : Slot = { centerId: 0, slotId: 0, slotDate: new Date(), userId: 0 };

  userId: String | null = localStorage.getItem("userId");

  ngOnInit(): void {
    this.loadCenters();
    this.slotForm = this.fb.group({
      centerId: ['', Validators.required],
      slotDate: ['', Validators.required],
      slotId: [{ value: '', disabled: true }, Validators.required] // Start disabled
    });

    // Subscribe to value changes to manage the slots dropdown
    this.slotForm.get('centerId')!.valueChanges.subscribe(() => {
      this.fetchAndEnableSlots();
    });

    this.slotForm.get('slotDate')!.valueChanges.subscribe(() => {
      this.fetchAndEnableSlots();
    });

    this.getBookingsByUserId(localStorage.getItem("userId"));
  }

  // Function to change the active view when a button is clicked
  setView(view: string): void {
    this.activeView = view;
  }

  fetchAndEnableSlots(): void {
    const centerId = this.slotForm.get('centerId')!.value;
    const date = this.slotForm.get('slotDate')!.value;

    if (centerId && date) {
      // 1. Fetch available slots based on centerId and date (simulate API call)
      console.log(`Fetching slots for Center ${centerId} on ${date}`);
      this.getSlotsByCenterId(centerId);

      // 2. Enable the slot select control
      this.slotForm.get('slotId')!.enable();
    } else {
      // If either field is cleared or incomplete, disable slots again
      this.slotForm.get('slotId')!.disable();
      this.availableSlots = []; // Clear options if criteria aren't met
      this.slotForm.get('slotId')!.setValue(''); // Reset selection
    }
  }

  onSubmit(): void {
    if (this.slotForm.valid) {
      this.slot.centerId = this.slotForm.value.centerId;
      this.slot.slotDate = new Date(this.slotForm.value.slotDate);
      this.slot.slotId = this.slotForm.value.slotId;
      this.slot.userId = Number(this.userId);
      this._httpservice.bookSlot(this.slot).subscribe({
        next: (response: any) => {
          if (response) {
            console.log('Form Submitted Successfully!', this.slotForm.value);
          }
        },
      });
    }
  }

  onLogout() {
    localStorage.removeItem("userId");
  }

  loadCenters() {
    this._httpservice.getCenters().subscribe(data => {
      this.centers = data
    });
  }

  getBookingsByUserId(id: any) {
    console.log(`customer Id: ${id}`);
    if (id) {
      this._httpservice.getBookings(id).subscribe({
        next: (res) => {
          this.bookings = res;
        },
        error: (err) => console.error('Error fetching bookings:', err)
      })
    }
  }

  getSlotsByCenterId(id: any) {
    this._httpservice.getSlotsByCenterId(id).subscribe({
      next: (res) => {
        this.availableSlots = res;
        console.log(res);
      },
      error: (err) => console.error('Error fetching Slots:', err)
    })
  }
}
