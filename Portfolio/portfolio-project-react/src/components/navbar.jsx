import {
    HomeIcon,
    PersonIcon,
    RocketIcon,
    LayersIcon,
    EnvelopeClosedIcon,
} from "@radix-ui/react-icons";

const Navbar = () => (
  <>
    {/* Mobile & Tablet navbar: icônes seules */}
    <nav
      className="
        fixed bottom-10 z-50 flex gap-5 p-4 text-sm rounded-full
        bg-black/60 backdrop-blur-xl border border-white/10
        shadow-[0_0_30px_rgba(212,175,55,0.12)]
        left-20/100 md:left-40/100 lg:left-44/100
        flex lg:hidden
      "
    >
      {/* HOME */}
      <a href="#home" className="group relative transition-all duration-300 ease-out">
        <HomeIcon
          className="
            h-5 w-5 text-white
            transition-all duration-300 ease-out
            group-hover:text-[var(--accentPrimary)]
            group-hover:scale-150
            group-hover:drop-shadow-[0_0_12px_rgba(212,175,55,0.45)]
          "
        />
        <span className="absolute inset-0 rounded-full bg-[radial-gradient(circle_at_center,rgba(212,175,55,0.25),transparent_60%)] opacity-0 group-hover:opacity-100 transition pointer-events-none" />
      </a>

      {/* ABOUT */}
      <a href="#about" className="group relative transition-all duration-300 ease-out">
        <PersonIcon
          className="
            h-5 w-5 text-white
            transition-all duration-300 ease-out
            group-hover:text-[var(--accentPrimary)]
            group-hover:scale-150
            group-hover:drop-shadow-[0_0_12px_rgba(212,175,55,0.45)]
          "
        />
        <span className="absolute inset-0 rounded-full bg-[radial-gradient(circle_at_center,rgba(212,175,55,0.25),transparent_60%)] opacity-0 group-hover:opacity-100 transition pointer-events-none" />
      </a>

      {/* PROJECTS */}
      <a href="#projects" className="group relative transition-all duration-300 ease-out">
        <RocketIcon
          className="
            h-5 w-5 text-white
            transition-all duration-300 ease-out
            group-hover:text-[var(--accentPrimary)]
            group-hover:scale-150
            group-hover:drop-shadow-[0_0_12px_rgba(212,175,55,0.45)]
          "
        />
        <span className="absolute inset-0 rounded-full bg-[radial-gradient(circle_at_center,rgba(212,175,55,0.25),transparent_60%)] opacity-0 group-hover:opacity-100 transition pointer-events-none" />
      </a>

      {/* SKILLS */}
      <a href="#skills" className="group relative transition-all duration-300 ease-out">
        <LayersIcon
          className="
            h-5 w-5 text-white
            transition-all duration-300 ease-out
            group-hover:text-[var(--accentPrimary)]
            group-hover:scale-150
            group-hover:drop-shadow-[0_0_12px_rgba(212,175,55,0.45)]
          "
        />
        <span className="absolute inset-0 rounded-full bg-[radial-gradient(circle_at_center,rgba(212,175,55,0.25),transparent_60%)] opacity-0 group-hover:opacity-100 transition pointer-events-none" />
      </a>

      {/* CONTACT */}
      <a href="#contact" className="group relative transition-all duration-300 ease-out">
        <EnvelopeClosedIcon
          className="
            h-5 w-5 text-white
            transition-all duration-300 ease-out
            group-hover:text-[var(--accentPrimary)]
            group-hover:scale-150
            group-hover:drop-shadow-[0_0_12px_rgba(212,175,55,0.45)]
          "
        />
        <span className="absolute inset-0 rounded-full bg-[radial-gradient(circle_at_center,rgba(212,175,55,0.25),transparent_60%)] opacity-0 group-hover:opacity-100 transition pointer-events-none" />
      </a>
    </nav>

    {/* Desktop navbar: icône + label + barre verticale */}
    <nav
      className="
        hidden lg:flex fixed bottom-10 z-50 items-center
        gap-4 px-6 py-3 rounded-full
        bg-black/60 backdrop-blur-xl border border-white/10
        shadow-[0_0_30px_rgba(212,175,55,0.12)]
        left-1/2 -translate-x-1/2
        text-sm text-white
      "
    >
      <a href="#home" className="flex items-center gap-2 hover:text-[var(--accentPrimary)] transition">
        <HomeIcon className="h-4 w-4" />
        <span>Accueil</span>
      </a>
      <span className="h-4 w-px bg-white/20" />
      <a href="#about" className="flex items-center gap-2 hover:text-[var(--accentPrimary)] transition">
        <PersonIcon className="h-4 w-4" />
        <span>À propos</span>
      </a>
      <span className="h-4 w-px bg-white/20" />
      <a href="#projects" className="flex items-center gap-2 hover:text-[var(--accentPrimary)] transition">
        <RocketIcon className="h-4 w-4" />
        <span>Projets</span>
      </a>
      <span className="h-4 w-px bg-white/20" />
      <a href="#skills" className="flex items-center gap-2 hover:text-[var(--accentPrimary)] transition">
        <LayersIcon className="h-4 w-4" />
        <span>Compétences</span>
      </a>
      <span className="h-4 w-px bg-white/20" />
      <a href="#contact" className="flex items-center gap-2 hover:text-[var(--accentPrimary)] transition">
        <EnvelopeClosedIcon className="h-4 w-4" />
        <span>Contact</span>
      </a>
    </nav>
  </>
);

export default Navbar;