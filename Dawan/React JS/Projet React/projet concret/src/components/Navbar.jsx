import { HeaderItem } from "./HeaderItem";

export const Navbar = () => {
  return (
    <header className="navbar px-5 shadow-lg navbar bg-neutral txt-neutral-content">
      <nav className="w-full">
        <div className="m-auto w-fit">
          <ul className="flex items-center gap-10 text-primary">
            <li>
              <HeaderItem href="/">Accueil</HeaderItem>
            </li>
            <li>
              <HeaderItem href="/produits">Produits</HeaderItem>
            </li>
            <li>
              <HeaderItem href="/panier">Panier</HeaderItem>
            </li>
            <li>
              <HeaderItem href="/login">Connexion</HeaderItem>
            </li>
          </ul>
        </div>
      </nav>
    </header>
  );
};
