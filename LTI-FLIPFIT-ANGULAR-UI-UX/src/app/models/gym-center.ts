import { GymCenterAddress } from "./gym-center-address";

export interface GymCenter {

	centerId: number;

	centerName: String;

	city: String;

	gymOwnerId: number;

	isApproved: boolean;

	description: String;

	contactPerson: String;

	phone: String;

	email: String;

	centerLocation: GymCenterAddress;

}
