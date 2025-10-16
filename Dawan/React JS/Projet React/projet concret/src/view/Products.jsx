import { useEffect, useState } from "react";
import { useProducts } from "../hooks/useProducts";
import { ProductCard } from "../components/ProductCard";
import { PaginationButton } from "../components/PaginationButton";
import { useSelector } from "react-redux";

export const Products = () => {
  const { getPaginate } = useProducts();

  const [products, setProducts] = useState([]);
  const [page, setPage] = useState(1);

  const [responseApi, setResponseApi] = useState({
    page: 1,
    pages: 0,
  });

  useEffect(() => {
    loadProducts();
  }, [page]);

  const loadProducts = () => {
    getPaginate(page, 12).then((resp) => {
      setProducts(resp.data.data);
      setResponseApi(resp.data);
    });
  };

  const handleClickPagination = (buttonNumber) => {
    setPage(buttonNumber);
  };

  // Exemple récupératon du 'state' count du store Redux
  const count = useSelector((state) => state.count.value);

  return (
    <>
      <h1>Mon compteur: {count} </h1>
      <h1>Mes produits</h1>
      <div className="w-full grid grid-cols-4 gap-2">
        {products.map((product) => (
          <ProductCard product={product} />
        ))}
      </div>

      <div className="w-fix m-auto mt-5">
        <button className="btn" onClick={() => setPage((prev) => prev - 1)}>
          précédent
        </button>
        <span>
          N°: {responseApi.next ? responseApi.next - 1 : responseApi.prev + 1}
        </span>
        <button className="btn" onClick={() => setPage((prev) => prev + 1)}>
          suivant
        </button>
      </div>
      <div className="w-fit m-auto mt-5">
        <PaginationButton
          handleClick={handleClickPagination}
          nbrButton={responseApi.pages}
        />
      </div>
    </>
  );
};
