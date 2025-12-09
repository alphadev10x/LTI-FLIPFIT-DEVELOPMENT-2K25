import { MenuItem } from "./menu-item";
import { MenuSelection } from "./menu-selection";

export interface MenuSection {
  id: MenuSelection['section']; // 'centers' | 'owners'
  label: string;
  expanded: boolean;
  items: MenuItem[];
}
