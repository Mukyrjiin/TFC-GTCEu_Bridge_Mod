// Smooth scroll for nav links
document.querySelectorAll('.nav-link').forEach(a => {
  a.addEventListener('click', (e) => {
    e.preventDefault();
    const id = a.getAttribute('href').slice(1);
    const el = document.getElementById(id);
    if (el) el.scrollIntoView({ behavior: 'smooth', block: 'start' });
  });
});

// Sidebar toggle (just hide/show text, keeps nav visible on mobile)
const sidebarToggle = document.getElementById('sidebar-toggle');
const sidebar = document.getElementById('sidebar');
let sidebarCollapsed = false;
if (sidebarToggle) {
  sidebarToggle.addEventListener('click', () => {
    sidebarCollapsed = !sidebarCollapsed;
    sidebar.classList.toggle('collapsed', sidebarCollapsed);
    sidebarToggle.textContent = sidebarCollapsed ? 'Show' : 'Hide';
  });
}

// Timeline reveal on scroll
const steps = Array.from(document.querySelectorAll('.timeline-step'));
const observer = new IntersectionObserver((entries) => {
  entries.forEach(entry => {
    if (entry.isIntersecting) {
      entry.target.classList.add('visible');
    }
  });
}, { threshold: 0.18 });

steps.forEach(s => observer.observe(s));

// Back to top button visibility
const backBtn = document.getElementById('backToTop');
window.addEventListener('scroll', () => {
  if (window.scrollY > 300) backBtn.classList.add('show');
  else backBtn.classList.remove('show');
});
backBtn.addEventListener('click', () => window.scrollTo({ top: 0, behavior: 'smooth' }));

// Details toggling: optional enhancement — preserve state across reloads (localStorage)
document.querySelectorAll('details').forEach((d, idx) => {
  const key = 'tfcgt_details_' + idx;
  try {
    const stored = localStorage.getItem(key);
    if (stored === 'open') d.open = true;
  } catch (e) {}
  d.addEventListener('toggle', () => {
    try {
      localStorage.setItem(key, d.open ? 'open' : 'closed');
    } catch (e) {}
  });
});

// Make timeline steps keyboard focusable for accessibility
steps.forEach(step => {
  step.setAttribute('tabindex', '0');
});
