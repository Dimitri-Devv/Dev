import { createBrowserRouter, Outlet, RouterProvider } from "react-router-dom";
import "./App.css";
import { Navbar } from "./components/Navbar";
import { Products } from "./view/Products";
import { Homepage } from "./view/Homepage";
import { Cart } from "./view/Cart";
import { LoginPage } from "./view/LoginPage";

function App() {
  const router = createBrowserRouter([
    {
      path: "/",
      element: <Root />,
      errorElement: <ErrorElement />,
      children: [
        {
          path: "",
          element: <Homepage />,
        },
        { path: "/produits", element: <Products /> },
        { path: "/produits/:id", element: <p>détails products</p> },
        { path: "/panier", element: <Cart /> },
        { path: "/login", element: <LoginPage /> },
        { path: "*", element: <p>page 404 (not found)</p> },
      ],
    },
  ]);

  function Root() {
    return (
      <>
        <Navbar />
        {/* outlet sera 'remplacé' par le composant associé à la route enfant */}
        <Outlet />
        <>footer</>
      </>
    );
  }

  function ErrorElement() {
    return <div>Oops ! Quelque chose s'est mal passé !</div>;
  }

  return <RouterProvider router={router} />;
}

export default App;
