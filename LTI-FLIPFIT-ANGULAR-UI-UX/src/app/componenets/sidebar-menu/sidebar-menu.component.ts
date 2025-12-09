
import { Component, EventEmitter, Output } from '@angular/core';

type SectionKey = 'centers' | 'owners';
type SubKey = 'pending' | 'approved' | 'rejected';

export interface MenuSelection {
  section: SectionKey;
  sub: SubKey;
}

interface MenuItem {
  label: string;
  section: SectionKey;
  sub: SubKey;
}

interface MenuSection {
  id: SectionKey;
  label: string;
  expanded: boolean;
  items: MenuItem[];
}

const STORAGE_KEY = 'menu.active';

@Component({
  selector: 'app-sidebar-menu',
  templateUrl: './sidebar-menu.component.html',
})
export class SidebarMenuComponent {
  @Output() select = new EventEmitter<MenuSelection>();

  sections: MenuSection[] = [
    {
      id: 'centers',
      label: 'Centers',
      expanded: true,
      items: [
        { label: 'Pending',  section: 'centers', sub: 'pending'  },
        { label: 'Approved', section: 'centers', sub: 'approved' },
        { label: 'Rejected', section: 'centers', sub: 'rejected' },
      ],
    },
    {
      id: 'owners',
      label: 'Owners',
      expanded: false,
      items: [
        { label: 'Pending',  section: 'owners', sub: 'pending'  },
        { label: 'Approved', section: 'owners', sub: 'approved' },
        { label: 'Rejected', section: 'owners', sub: 'rejected' },
      ],
    },
  ];

  active: MenuSelection | null = this.restoreActive();

  // ---------- Actions ----------
  toggleSection(section: MenuSection): void {
    section.expanded = !section.expanded;
  }

  selectItem(item: MenuItem): void {
    this.active = { section: item.section, sub: item.sub };
    this.persistActive(this.active);
    this.select.emit(this.active);
  }

  isActive(item: MenuItem): boolean {
    return !!this.active &&
      this.active.section === item.section &&
      this.active.sub === item.sub;
  }

  // ---------- Keyboard handlers ----------
  onSectionKeydown(ev: KeyboardEvent, section: MenuSection): void {
    const key = ev.key;
    if (key === 'Enter' || key === ' ') {
      ev.preventDefault();
      this.toggleSection(section);
    } else if (key === 'ArrowRight') {
      if (!section.expanded) this.toggleSection(section);
      // Focus first submenu item
      queueMicrotask(() => {
        const first = document.querySelector<HTMLButtonElement>(
          `#submenu-${section.id} button`
        );
        first?.focus();
      });
    } else if (key === 'ArrowLeft') {
      if (section.expanded) this.toggleSection(section);
    }
  }

  onItemKeydown(ev: KeyboardEvent, section: MenuSection, index: number): void {
    const container = (ev.currentTarget as HTMLElement).parentElement!;
    const buttons = Array.from(container.querySelectorAll<HTMLButtonElement>('button'));
    const key = ev.key;

    if (key === 'ArrowDown') {
      ev.preventDefault();
      (buttons[index + 1] || buttons[0])?.focus();
    } else if (key === 'ArrowUp') {
      ev.preventDefault();
      (buttons[index - 1] || buttons[buttons.length - 1])?.focus();
    } else if (key === 'Home') {
      ev.preventDefault();
      buttons[0]?.focus();
    } else if (key === 'End') {
      ev.preventDefault();
      buttons[buttons.length - 1]?.focus();
    } else if (key === 'Enter' || key === ' ') {
      ev.preventDefault();
      (ev.currentTarget as HTMLElement).dispatchEvent(
        new MouseEvent('click', { bubbles: true })
      );
    }
  }

  // ---------- Persistence ----------
  restoreActive(): MenuSelection | null {
    try {
      const stored = localStorage.getItem(STORAGE_KEY);
      if (!stored) return null;
      const [section, sub] = stored.split(':') as [SectionKey, SubKey];
      return { section, sub };
    } catch {
      return null;
    }
  }

  persistActive(sel: MenuSelection): void {
    try {
      localStorage.setItem(STORAGE_KEY, `${sel.section}:${sel.sub}`);
    } catch {
      /* ignore storage failures */
    }
  }
}