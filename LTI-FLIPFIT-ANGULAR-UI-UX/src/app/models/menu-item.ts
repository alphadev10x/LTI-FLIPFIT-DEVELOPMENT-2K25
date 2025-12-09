import { MenuSelection } from "./menu-selection";
import { SubKey } from "./SubKey";

export interface MenuItem {
    label: string;
    section: MenuSelection['section'];
    sub: SubKey;
}
