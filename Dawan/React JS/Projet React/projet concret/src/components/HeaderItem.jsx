import { Link, useLocation } from "react-router-dom";

export const HeaderItem = ({ href, children }) => {
  const { pathname } = useLocation();

  console.log(pathname);

  return (
    <>
      {/* Pour appliquer un style au bouton de la route sur laquelle on se trouve
       si je rempli la conditoin 'pathname === href' j'applique le style des classes */}
      <Link
        to={href}
        className={
          pathname === href ? "myClass underline border-primary font-bold" : ""
        }
      >
        {children}
      </Link>
    </>
  );
};
